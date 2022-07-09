DROP DATABASE IF EXISTS elbaiven;
CREATE DATABASE elbaiven;
USE elbaiven;

CREATE TABLE products(
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    quantity INT NOT NULL,
    description TEXT NOT NULL,
    createdAt DATE NULL,
    updatedAt DATE NULL,
	deletedAt DATE NULL,
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE clients(
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    address TEXT NOT NULL,/* por medio de google maps*/
    phone INT(10) NOT NULL,
    createdAt DATE NULL,
    updatedAt DATE NULL,
	deletedAt DATE NULL,
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE shopping(
	id INT NOT NULL AUTO_INCREMENT,
    date DATETIME NOT NULL,
    total DOUBLE NOT NULL,
    idClient INT NOT NULL,
    createdAt DATE NULL,
    updatedAt DATE NULL,
	deletedAt DATE NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (idClient) REFERENCES clients(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE detailShopping(
	id INT NOT NULL AUTO_INCREMENT,
    idProduct  INT NOT NULL,
    idShopping INT NOT NULL,
    quantity INT NOT NULL,
    createdAt DATE NULL,
    updatedAt DATE NULL,
	deletedAt DATE NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (idProduct) REFERENCES products(id),
	FOREIGN KEY (idShopping) REFERENCES shopping(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;