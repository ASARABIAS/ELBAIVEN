module.exports = (sequelize, dataTypes) => {
    let alias = "Shopping";
    let cols = {
        id: {
            type: dataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        date :{
            type: dataTypes.DATE,
        },
        total :{
            type: dataTypes.DOUBLE,
        },
        idClient:{
            type: dataTypes.INTEGER,
        }
    };
    let config = {
        tableName: "shopping",
        timestamps: true,
        paranoid: true
    };
    const Shopping = sequelize.define(alias, cols, config);

    return Shopping;

}