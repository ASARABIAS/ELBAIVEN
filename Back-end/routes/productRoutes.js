const express = require('express');
const router = express.Router();

const { list, store } = require('../controllers/productController');

router.get('/', list);
router.get('/store', store);

module.exports = router;