const db = require('../database/models');

module.exports = {
    list: async (req, res) => {
        const products = await db.Products.findAll();
        res.json({
            status: 200,
            data: products
        })
    },
    store: async (req, res) => {
        console.log(req.body);
    },
}