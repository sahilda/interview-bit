const express = require('express');
const supertest = require('supertest');
const objectIdChecker = require('./objectIdChecker');

describe('Verify ObjectIdChecker Middleware', () => {
    let request;

    beforeAll(() => {
        const app = express();
        app.get('/:id', objectIdChecker, (req, res) => {
            res.status(200).json({ status: 200, message: 'OK' });
        });

        request = supertest(app);
    });

    it('Should validate the id param is an object id', async () => {
        let response = await request.get('/bogus');
        expect(response.status).toStrictEqual(404);
        expect(response.body).toStrictEqual({ message: 'Invalid id' });

        response = await request.get('/000000000000000000000000');
        expect(response.status).toStrictEqual(200);
    });
});
