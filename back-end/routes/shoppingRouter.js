const express = require('express');
const router = express.Router();

const shoppingController = require('../controllers/shoppingController');

router.post('/store', shoppingController.store);


module.exports = router;