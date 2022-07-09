module.exports = (sequelize, dataTypes) => {
    let alias = "Clients";
    let cols = {
        id: {
            type: dataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        name :{
            type: dataTypes.STRING,
        },
        phone :{
            type: dataTypes.INTEGER,
        },
        address:{
            type: dataTypes.TEXT,
        }
    };
    let config = {
        tableName: "clients",
        timestamps: true,
        paranoid: true
    };
    const Clients = sequelize.define(alias, cols, config);

    return Clients;

}