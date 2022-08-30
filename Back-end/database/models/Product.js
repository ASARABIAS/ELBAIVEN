module.exports = (sequelize, dataTypes) => {
    let alias = "Products";
    let cols = {
        id: {
            type: dataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        name :{
            type: dataTypes.STRING,
            unique: true,
            allowNull: false,
        },
        quantity :{ /*la cantidad es representada 1 = 30 unidades o 4 unidades si esta en tru isSaleSixpack */
            type: dataTypes.INTEGER,
            allowNull: false,
        },
        description:{
            type: dataTypes.TEXT,
            allowNull: false,
        },
        price:{
            type:dataTypes.DOUBLE,
            allowNull: false,
        },
        image :{
            type: dataTypes.STRING,
            allowNull: false,
        },
        isSaleSixpack :{ /*0 => false; 1 = true */
            type: dataTypes.TINYINT,
            allowNull: false,
        },
    };
    let config = {
        tableName: "products",
        timestamps: true,
        paranoid: true
    };
    const Products = sequelize.define(alias, cols, config);

    return Products;

}