DROP DATABASE IF EXISTS `geotime`;
CREATE DATABASE `geotime`;

USE `geotime`;

CREATE TABLE `period` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
   `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `epoch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `fk_period` int(11) DEFAULT NULL,
  `start` DECIMAL(5,2) NOT NULL,
  `end` DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_period_idx` (`fk_period`),
  CONSTRAINT `fk_period` FOREIGN KEY (`fk_period`) REFERENCES `period` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into period(name, description) values ('Quaternary', 'Current period. Cave lions, sabre-toothed cats, cave bears, giant deer, woolly rhinoceroses, and woolly mammoths were prevailing species of this period.');
insert into epoch(name, description, fk_period, start, end) values ('Holocene','Current epoch. It marks the end of the previous series of ice ages.', 1, 0.01, 0);
insert into epoch(name, description, fk_period, start, end) values ('Pleistocene','A time of ice ages: cold glacial periods with shorter, warmer, interglacials.', 1, 2.6, 0.01);

insert into period(name, description) values ('Neogene', 'This period saw a drastic cooling of the climte.”');
insert into epoch(name, description, fk_period, start, end) values ('Pliocene','The world continued to get cooler and drier in the Pliocene. Some apes started to live on the savannah instead of the forests.', 2, 5.3, 2.6);
insert into epoch(name, description, fk_period, start, end) values ('Miocene','The plants and animals of the Miocene were fairly modern. Modern families of mammals and birds existed. Modern sharks appeared, including the huge Megalodon.', 2, 23, 5.3);

insert into period(name, description) values ('Paleogene', 'During this period most of the Earth climate was tropical. ”');
insert into epoch(name, description, fk_period, start, end) values ('Oligocene','Considered an important time of transition between the tropical Eocene and the more modern ecosystems of the Miocene', 3, 33.9, 23);
insert into epoch(name, description, fk_period, start, end) values ('Eocene','The epoch had a climate much warmer than today. The land was heavily forested, with temperate forests into the polar regions', 3, 56, 33.9);
insert into epoch(name, description, fk_period, start, end) values ('Palaeocene','The epoch both began and ended with an extinction event.', 3, 66, 56);

