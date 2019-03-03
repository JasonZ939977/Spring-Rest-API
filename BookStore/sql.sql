CREATE DATABASE demo;
USE demo;

drop table if exists Book;

CREATE TABLE `Book` (
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`bookName` varchar(100) NOT NULL DEFAULT '',
`author` varchar(100) NOT NULL DEFAULT '',
`date` DATE,
`price` real(5,2),
`number` varchar(100) NOT NULL DEFAULT '',
PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO Book VALUES (NULL, 'TestBook', 'Jerry M', STR_TO_DATE('22-01-1987', '%d-%m-%Y'), 3.62, '22');

-- The password of my mysql is Nokia123 which you can change in the application.properties


