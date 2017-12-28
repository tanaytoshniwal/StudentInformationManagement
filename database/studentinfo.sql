/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 6.0.0-alpha-community-nt-debug : Database - student1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`student1` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `student1`;

/*Table structure for table `branch` */

DROP TABLE IF EXISTS `branch`;

CREATE TABLE `branch` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `branch` */

insert  into `branch`(`id`,`name`) values 
(1,'IT'),
(2,'CSE'),
(3,'ECE'),
(4,'MECH'),
(5,'EEE'),
(6,'CIVIL');

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `course` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `course` */

insert  into `course`(`id`,`course`) values 
(1,'BCA'),
(2,'MCA'),
(3,'BTECH'),
(4,'MTECH'),
(5,'BBA'),
(6,'MBA');

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

insert  into `faculty_registration`(`empid`,`name`,`dob`,`mobile`,`email`,`dateofjoining`,`address`,`password`) values 
('238314','ritvik','1/Jan/2010','9092030806','ritvikjain2@gmail.com','1/Jan/2010','315,  Shanti Nagar\r\nDrurgapura\r\nJaipur\r\nRajasthan','rit1234'),
('238315','rohan','5/Mar/2010','9092030806','ritvikjain2@gmail.com','5/Mar/2010','351 sem univ','roh1234');

/*Table structure for table `feedback` */

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
  `date` varchar(15) DEFAULT NULL,
  `course` varchar(20) DEFAULT NULL,
  `branch` varchar(20) DEFAULT NULL,
  `feedback` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `feedback` */

insert  into `feedback`(`date`,`course`,`branch`,`feedback`) values 
('24/12/2017','BTECH','MECH','sdsjbcsk');

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `date` varchar(15) DEFAULT NULL,
  `course` varchar(20) DEFAULT NULL,
  `branch` varchar(20) DEFAULT NULL,
  `notice` varchar(300) DEFAULT NULL,
  `uploaded_by` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `notice` */

insert  into `notice`(`date`,`course`,`branch`,`notice`,`uploaded_by`) values 
('27/12/2017','BTECH','MECH','welcome all','Rohan');

/*Table structure for table `student_registration` */

DROP TABLE IF EXISTS `student_registration`;

CREATE TABLE `student_registration` (
  `enrollment` varchar(25) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `roll` varchar(15) DEFAULT NULL,
  `dob` varchar(12) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `mobile` varchar(14) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `branch` varchar(10) DEFAULT NULL,
  `course` varchar(10) DEFAULT NULL,
  `sem` int(5) DEFAULT NULL,
  `dateofjoining` varchar(15) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`enrollment`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student_registration` */

insert  into `student_registration`(`enrollment`,`name`,`roll`,`dob`,`gender`,`mobile`,`email`,`branch`,`course`,`sem`,`dateofjoining`,`address`,`password`) values 
('238314','ritvik','20','1/Jan/2010','Male','902030806','ritvik2@gmail.com','CSE','BTECH',4,'18/Jul/2016','315 shantinagar\ndurgapura','rit1234');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
