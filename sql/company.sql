CREATE DATABASE IF NOT EXISTS `mydb`;
USE `mydb`;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_name` varchar(45) DEFAULT NULL,
  `company_size` varchar(45) DEFAULT NULL,
  `company_location` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `company`
--

INSERT INTO `company` (`company_name`, `company_size`, `company_location`) VALUES 
	('Luv2Code', 'Medium', 'New York'),
	('TechCorp', 'Large', 'San Francisco'),
	('InnoTech', 'Small', 'London'),
	('NexGen', 'Medium', 'Tokyo'),
	('GlobalTech', 'Large', 'Paris');

