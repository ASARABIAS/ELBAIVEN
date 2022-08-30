const db = require('../database/models');

module.exports = {
    list: async (req, res) => {
        const response = await db.Products.findAll();
        res.status(200).json({
            status: 200,
            answer: {
                data: response,
                urlStaticImages: 'http://localhost:3030/images/products/',
            }
        });
    },
    byId: async (req, res) => {
        const response = await db.Products.findByPk(req.params.id);
        res.status(200).json({
            status: 200,
            answer: {
                data: response,
                urlStaticImages: 'http://localhost:3030/images/products/',
            }
        });
    },
    store: (req, res) => {
        db.Products.create(req.body)
            .then(response => {
                res.status(200).json({
                    status: 200,
                    data: response
                })
            })
            .catch(error => {
                res.status(500).json({
                    status: 500,
                    data: error
                })
            })

    },
}