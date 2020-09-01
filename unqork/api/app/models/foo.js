const mongoose = require('mongoose');

const fooSchema = new mongoose.Schema({
    name: { type: String, required: true, unique: true },
    foos: {
        type: [mongoose.Schema.Types.ObjectId],
        ref: 'Foo',
        validate: {
            validator: (array) => array.length === new Set(array.map((x) => x.toString())).size,
            message: 'duplicate object ids'
        }
    },
    data: { type: {}, required: true }
}, { timestamps: { createdAt: 'created', updatedAt: 'modified' } });

// Attempted to add a middleware hook but was unsuccessful in getting it working,
// ended up adding this functionality into the controller directly.

// fooSchema.pre('deleteOne', function (next) {
//     this.model.updateMany(
//         { foos: { $in: this._id } },
//         { $pull: { foos: this._id } },
//         { multi: true },
//         next
//     );
// });

module.exports = mongoose.model('Foo', fooSchema);
