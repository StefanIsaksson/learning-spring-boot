DROP DATABASE `mythology`;
CREATE DATABASE `mythology`;

USE `mythology`;

CREATE TABLE `religion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `gods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `fk_religion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_religion_idx` (`fk_religion`),
  CONSTRAINT `fk_religion` FOREIGN KEY (`fk_religion`) REFERENCES `religion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;