const mongoose = require('mongoose');
// Load model
require('./foo');

const { Foo: FooModel } = mongoose.models;

describe('Verify Foo Model', () => {
    beforeAll(async () => {
        await mongoose.connect(
            process.env.MONGO_URL,
            {
                useUnifiedTopology: true,
                useNewUrlParser: true,
                useCreateIndex: true
            }
        );
    });

    afterAll(async () => {
        await mongoose.connection.close();
    });

    beforeEach(async () => {
        await FooModel.deleteMany();
    });

    it('should require a name attribute', async () => {
        const foo = new FooModel({ data: {} });

        await expect(foo.save()).rejects.toThrow('Path `name` is required');
    });

    it('should require the name attribute to be unique', async () => {
        const foo1 = new FooModel({ name: 'foo', data: {} });
        const savedFoo1 = await foo1.save();
        expect(savedFoo1.id).toBeDefined();

        const foo2 = new FooModel({ name: 'foo', data: {} });
        await expect(foo2.save()).rejects.toThrow('E11000 duplicate key error dup key: { : "foo" }');

        foo2.name = 'bar';
        const savedFoo2 = await foo2.save();
        expect(savedFoo2.id).toBeDefined();
    });

    it('should only allow the foos attribute to contain unique foo ids', async () => {
        const foo = new FooModel({ name: 'bar', data: {} });
        let savedFoo = await foo.save();
        expect(savedFoo.id).toBeDefined();

        savedFoo.foos.push(savedFoo.id);
        savedFoo = await foo.save();

        savedFoo.foos.push(savedFoo.id);
        await expect(foo.save()).rejects.toThrow('duplicate object ids');
    });

    it('should require a data attribute', async () => {
        const foo = new FooModel({ name: 'bar' });

        await expect(foo.save()).rejects.toThrow('Foo validation failed: data: Path `data` is required.');
    });

    it('should allow the data attribute to be freeform', async () => {
        const foo = new FooModel({ name: 'bar', data: { any: 'object' } });
        const savedFoo = await foo.save();
        expect(savedFoo.id).toBeDefined();
        expect(savedFoo.data).toEqual({ any: 'object' });
    });

    it('should set the created attribute at creation', async () => {
        const foo = new FooModel({ name: 'bar', data: {} });
        const savedFoo = await foo.save();
        expect(savedFoo.id).toBeDefined();
        expect(savedFoo.created).toBeDefined();
    });

    it('should not update the created attribute on updates', async () => {
        const foo = new FooModel({ name: 'bar', data: {} });
        let savedFoo = await foo.save();
        expect(savedFoo.id).toBeDefined();
        expect(savedFoo.created).toBeDefined();

        const createdAt = savedFoo.created;
        savedFoo.name = 'bar2';
        savedFoo = await savedFoo.save();
        expect(savedFoo.created).toEqual(createdAt);
    });

    it('should set the modified attribute at creation', async () => {
        const foo = new FooModel({ name: 'bar', data: {} });
        const savedFoo = await foo.save();
        expect(savedFoo.id).toBeDefined();
        expect(savedFoo.modified).toBeDefined();
    });

    it('should update the modified attribute on updates', async () => {
        const foo = new FooModel({ name: 'bar', data: {} });
        let savedFoo = await foo.save();
        expect(savedFoo.id).toBeDefined();
        expect(savedFoo.modified).toBeDefined();

        const modifiedAt = savedFoo.modified;
        savedFoo.name = 'bar2';
        savedFoo = await savedFoo.save();
        expect(savedFoo.modified).not.toEqual(modifiedAt);
        expect(savedFoo.modified > modifiedAt).toBeTruthy();
    });

    it('should insert a valid new document', async () => {
        const validFoo = new FooModel({ name: 'bar', data: {} });
        const savedFoo = await validFoo.save();

        expect(savedFoo.id).toBeDefined();
    });
});
