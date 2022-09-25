const createError = require('http-errors');
const express = require('express');
const cors = require("cors");
const path = require('path');
const cookieParser = require('cookie-parser');

const app = express();
const indexRoutes = require('./routes/indexRoutes');
const productRoutes = require('./routes/productRoutes');
const shoppingRoutes = require('./routes/shoppingRouter');

app.use(express.json());
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));
app.use(cors());

app.use('/',indexRoutes);
app.use('/products',productRoutes);
app.use('/shopping',shoppingRoutes);

module.exports = app;
