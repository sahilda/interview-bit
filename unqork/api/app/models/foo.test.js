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

    it('should insert a valid new document', async () => {
        const validFoo = new FooModel({});
        const savedFoo = await validFoo.save();

        expect(savedFoo.id).toBeDefined();
    });
});
