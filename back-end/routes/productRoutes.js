const express = require('express');
const router = express.Router();

const { list, store, byId } = require('../controllers/productController');

router.get('/', list);
router.get('/:id', byId);
router.post('/store', store);

module.exports = router;