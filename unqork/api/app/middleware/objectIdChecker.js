const mongoose = require('mongoose');

module.exports = (req, res, next) => {
    const objectId = req.params.id;
    const validObjectId = mongoose.Types.ObjectId.isValid(objectId);
    if (objectId && !validObjectId) {
        res.status(404).json({ message: 'Invalid id' });
    } else {
        next();
    }
};
