const express = require('express');
const supertest = require('supertest');
const router = require('./root');
const Foos = require('../models/foo');

describe('Verify Root Endpoint', () => {
    let request;

    beforeAll(() => {
        const app = express();
        app.use(express.json());
        app.use(router);

        request = supertest(app);
    });

    beforeEach(async () => {
        await Foos.deleteMany();
    });

    describe('GET /foos/', () => {
        it('Should respond to GET /foos', async () => {
            let response = await request.get('/foos');
            expect(response.status).toStrictEqual(200);
            expect(response.body).toHaveLength(0);
            expect(response.body).toStrictEqual([]);

            const foo1 = await Foos.create({ name: 'bar1', data: {} });
            const foo2 = await Foos.create({ name: 'bar2', data: {} });
            const foo3 = await Foos.create({ name: 'bar3', data: {} });

            response = await request.get('/foos');
            expect(response.status).toStrictEqual(200);
            expect(response.body).toHaveLength(3);

            expect(response.body.map((x) => x.name).sort())
                .toEqual([foo1.name, foo2.name, foo3.name].sort());
        });

        it('Should be able to filter results', async () => {
            await Foos.create({ name: 'bar1', data: {} });
            const foo2 = await Foos.create({ name: 'bar2', data: {} });
            await Foos.create({ name: 'bar3', data: {} });

            const response = await request.get(`/foos?filter[name]=${foo2.name}`);
            expect(response.status).toStrictEqual(200);
            expect(response.body).toHaveLength(1);
            expect(response.body[0].name).toStrictEqual(foo2.name);
        });
    });

    describe('GET /foos/:id', () => {
        it('Should respond with the requested foo', async () => {
            const foo1 = await Foos.create({ name: 'bar1', data: {} });
            const foo2 = await Foos.create({ name: 'bar2', data: {} });

            let response = await request.get(`/foos/${foo1.id}`);
            expect(response.status).toStrictEqual(200);
            expect(response.body.name).toStrictEqual(foo1.name);

            response = await request.get(`/foos/${foo2.id}`);
            expect(response.status).toStrictEqual(200);
            expect(response.body.name).toStrictEqual(foo2.name);

            response = await request.get('/foos/000000000000000000000000');
            expect(response.status).toStrictEqual(200);
            expect(response.body).toStrictEqual(null);
        });

        it('Should validate the id param', async () => {
            const response = await request.get('/foos/bogus');
            expect(response.status).toStrictEqual(404);
            expect(response.body).toStrictEqual({ message: 'Invalid id' });
        });

        it('Should include all related Foos if included', async () => {
            const foo1 = await Foos.create({ name: 'bar1', data: {} });
            const foo2 = await Foos.create({ name: 'bar2', data: {}, foos: [foo1.id] });

            const response = await request.get(`/foos/${foo2.id}?include=foos`);
            expect(response.status).toStrictEqual(200);
            expect(response.body.name).toStrictEqual(foo2.name);
            expect(response.body.foos).toHaveLength(1);
            expect(response.body.foos[0].name).toStrictEqual(foo1.name);
        });
    });

    describe('POST /foos', () => {
        it('Should create a foo object', async () => {
            const relatedFoo = await Foos.create({ name: 'related', data: {} });
            const response = await request.post('/foos').send({ name: 'bar1', data: { nested: 'prop' }, foos: [relatedFoo.id] });
            expect(response.status).toStrictEqual(200);
            expect(response.body.name).toStrictEqual('bar1');
            expect(response.body.data).toStrictEqual({ nested: 'prop' });
            expect(response.body.foos).toHaveLength(1);
            expect(response.body.foos[0]).toStrictEqual(relatedFoo.id);
        });

        it('Should return a 422 if missing params', async () => {
            const response = await request.post('/foos', { data: {} });
            expect(response.status).toStrictEqual(422);
            expect(response.body).toStrictEqual('Path `name` is required.');
        });
    });

    describe('PUT /foos/:id', () => {
        it('Should update the requested foo', async () => {
            const foo = await Foos.create({ name: 'bar1', data: {} });

            const response = await request.put(`/foos/${foo.id}`).send({ name: 'updated!', data: { nested: 'prop' }, foos: [foo.id] });
            expect(response.status).toStrictEqual(200);
            expect(response.body.name).toStrictEqual('updated!');
            expect(response.body.data).toStrictEqual({ nested: 'prop' });
            expect(response.body.foos[0]).toStrictEqual(foo.id);
        });

        it('Should validate the id param', async () => {
            const response = await request.put('/foos/bogus').send({ name: 'updated!' });
            expect(response.status).toStrictEqual(404);
            expect(response.body).toStrictEqual({ message: 'Invalid id' });
        });
    });

    describe('DELETE /foos/:id', () => {
        it('Should delete the requested foo', async () => {
            const foo1 = await Foos.create({ name: 'bar1', data: {} });

            const response = await request.delete(`/foos/${foo1.id}`);
            expect(response.status).toStrictEqual(200);
            expect(response.body.deletedCount).toStrictEqual(1);
        });

        it('Should validate the id param', async () => {
            const response = await request.delete('/foos/bogus');
            expect(response.status).toStrictEqual(404);
            expect(response.body).toStrictEqual({ message: 'Invalid id' });
        });

        it('Should delete the referenced foo from other documents', async () => {
            const foo1 = new Foos({ name: 'bar1', data: {} });
            const foo2 = new Foos({ name: 'bar2', data: {}, foos: [foo1.id] });
            const foo3 = new Foos({ name: 'bar3', data: {}, foos: [foo1.id, foo2.id] });

            const savedFoo1 = await foo1.save();
            let savedFoo2 = await foo2.save();
            let savedFoo3 = await foo3.save();

            expect(savedFoo2.foos).toHaveLength(1);
            expect(savedFoo3.foos).toHaveLength(2);

            const response = await request.delete(`/foos/${savedFoo1.id}`);
            expect(response.status).toStrictEqual(200);

            savedFoo2 = await Foos.findById(savedFoo2.id);
            savedFoo3 = await Foos.findById(savedFoo3.id);
            expect(savedFoo2.foos).toHaveLength(0);
            expect(savedFoo3.foos).toHaveLength(1);
        });
    });
});
