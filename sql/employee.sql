CREATE DATABASE  IF NOT EXISTS `mydb`;
USE `mydb`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(45) DEFAULT NULL,
  `employee_surname` varchar(45) DEFAULT NULL,
  `employee_email` varchar(45) DEFAULT NULL,
  `employee_city` varchar(45) DEFAULT NULL,
  `employee_years_of_experience` varchar(45) DEFAULT NULL,
  `employee_social_link` varchar(45) DEFAULT NULL,
  `employee_introduction` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com','a','a','a','a'),
	(2,'Emma','Baumgarten','emma@luv2code.com','b','b','b','b'),
	(3,'Avani','Gupta','avani@luv2code.com','b','b','b','b'),
	(4,'Yuri','Petrov','yuri@luv2code.com','b','b','b','b'),
	(5,'Juan','Vega','juan@luv2code.com','b','b','b','b');