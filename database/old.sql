/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 5.1.33-community : Database - sis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sis` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `sis`;

/*Table structure for table `branch` */

DROP TABLE IF EXISTS `branch`;

CREATE TABLE `branch` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `branch` */

/*Table structure for table `faculty_registration` */

DROP TABLE IF EXISTS `faculty_registration`;

CREATE TABLE `faculty_registration` (
  `empid` varchar(25) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `dob` varchar(12) DEFAULT NULL,
  `mobile` varchar(14) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `dateofjoining` varchar(15) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`empid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `faculty_registration` */

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `date` varchar(15) DEFAULT NULL,
  `subject` varchar(50) DEFAULT NULL,
  `notice` varchar(300) DEFAULT NULL,
  `branch` int(10) DEFAULT NULL,
  `uploaded_by` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `notice` */

/*Table structure for table `student_registration` */

DROP TABLE IF EXISTS `student_registration`;

CREATE TABLE `student_registration` (
  `enrollment` varchar(25) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `roll` varchar(15) DEFAULT NULL,
  `dob` varchar(12) DEFAULT NULL,
  `mobile` varchar(14) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `branch` int(10) DEFAULT NULL,
  `sem` int(5) DEFAULT NULL,
  `dateofjoining` varchar(15) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`enrollment`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student_registration` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
