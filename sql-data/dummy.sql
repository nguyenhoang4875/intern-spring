DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `detail` varchar(255) NOT NULL,
 `due_date` datetime(6) DEFAULT NULL,
 `name` varchar(255) NOT NULL,
 `status` varchar(255) NOT NULL,
 PRIMARY KEY (`id`)
 )