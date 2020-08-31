const { Router } = require('express');
const rootRouter = require('./root');

const router = Router();

router.use(rootRouter);

module.exports = router;
