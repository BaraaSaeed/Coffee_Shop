CREATE TABLE `Products` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

INSERT INTO `Products` (name, description, price)
VALUES ('Decaf Sumatra', '1 lb, whole bean', 8.00);
INSERT INTO `Products` (name, description, price)
VALUES ('Caffe Espresso', '1 lb, Ground', 12.00);
INSERT INTO `Products` (name, description, price)
VALUES ('Decaf Chrismass Blend', '1 lb, whole bean', 14.00);
INSERT INTO `Products` (name, description, price)
VALUES ('Iraqi Tea', 'black tea with cardamom ', 1.00);


CREATE TABLE `Users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;
