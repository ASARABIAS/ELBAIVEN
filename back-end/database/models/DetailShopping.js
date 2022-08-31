module.exports = (sequelize, dataTypes) => {
    let alias = "DetailShopping";
    let cols = {
        id: {
            type: dataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        idProduct :{
            type: dataTypes.INTEGER,
        },
        idShopping :{
            type: dataTypes.INTEGER,
        },
        quantity :{
            type: dataTypes.INTEGER,
        }
    };
    let config = {
        tableName: "detailShopping",
        timestamps: true,
        paranoid: true
    };
    const DetailShopping = sequelize.define(alias, cols, config);

    return DetailShopping;

}