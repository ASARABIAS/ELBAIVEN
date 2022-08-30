const db = require('../database/models');
const BASE_URL = "http://localhost:3030";

module.exports = {
    index: async (req, res) => {
        const top6InQuantityProducts = await db.Products.findAll({
            order: [
                ['quantity', 'DESC']
            ],
            limit: 6,
        })
        res.status(200).json({
            status: 200,
            answer: {
                data: top6InQuantityProducts,
                urlStaticImages: `${BASE_URL}/images/products/`,
            }
        });
    }
}