const { Router } = require('express');

const mongoose = require('mongoose');
const objectIdChecker = require('../middleware/objectIdChecker.js');
const Foos = require('../models/foo');

const router = Router();

mongoose.connect(
    process.env.MONGO_URL,
    {
        useUnifiedTopology: true,
        useNewUrlParser: true,
        useCreateIndex: true
    }
);

router.get('/', (req, res) => {
    res.status(200).json({ status: 200, message: 'OK' });
});
router.get('/err', (req, res, next) => {
    next(new Error('DOH!'));
});

router.get('/foos', async (req, res) => {
    const query = req.query.filter || {};
    const result = await Foos.find(query).exec();
    res.status(200).json(result);
});

router.get('/foos/:id', objectIdChecker, async (req, res) => {
    const query = Foos.findById(req.params.id);
    if (req.query.include === 'foos') {
        query.populate('foos');
    }
    const result = await query.exec();
    res.status(200).json(result);
});

router.post('/foos', async (req, res) => {
    const foo = new Foos(req.body);
    const validationError = await foo.validateSync();

    if (validationError) {
        res.status(422).json(validationError.errors.name.message);
    } else {
        const result = await foo.save();
        res.status(200).json(result);
    }
});

router.put('/foos/:id', objectIdChecker, async (req, res) => {
    const result = await Foos.findOneAndUpdate(req.params.id, req.body,
        { new: true, useFindAndModify: false }).exec();
    res.status(200).send(result);
});

router.delete('/foos/:id', objectIdChecker, async (req, res) => {
    const result = await Foos.deleteOne({ _id: req.params.id }).exec();

    // Remove from other foos referencing self
    await Foos.updateMany(
        { foos: { $in: req.params.id } },
        { $pull: { foos: req.params.id } }
    );

    res.status(200).send(result);
});

module.exports = router;
