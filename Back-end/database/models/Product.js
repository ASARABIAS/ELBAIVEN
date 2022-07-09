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
        },
        quantity :{
            type: dataTypes.INTEGER,
        },
        description:{
            type: dataTypes.TEXT,
        }
    };
    let config = {
        tableName: "products",
        timestamps: true,
        paranoid: true
    };
    const Products = sequelize.define(alias, cols, config);

    return Products;

}