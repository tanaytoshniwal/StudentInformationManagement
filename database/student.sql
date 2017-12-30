CREATE DATABASE  IF NOT EXISTS `student` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `student`;
-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: student
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `branch` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'IT'),(2,'CSE'),(3,'ECE'),(4,'MECH'),(5,'EEE'),(6,'CIVIL');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `course` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'BCA'),(2,'MCA'),(3,'BTECH'),(4,'MTECH'),(5,'BBA'),(6,'MBA');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_registration`
--

DROP TABLE IF EXISTS `faculty_registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_registration`
--

LOCK TABLES `faculty_registration` WRITE;
/*!40000 ALTER TABLE `faculty_registration` DISABLE KEYS */;
INSERT INTO `faculty_registration` VALUES ('11111','tanay','3/Nov/1998','9829077531','tanaytoshniwal98@gmail.com','3/Nov/2015','Jaipur\r\nRajasthan','tan123'),('11112','tanisha','1/Nov/2000','9839077521','tanishajain@gmail.com','1/Nov/2015','ghar','tan456');
/*!40000 ALTER TABLE `faculty_registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `date` varchar(15) DEFAULT NULL,
  `course` varchar(20) DEFAULT NULL,
  `branch` varchar(20) DEFAULT NULL,
  `feedback` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES ('24/12/2017','BTECH','CSE','sdsjbcsk');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice` (
  `date` varchar(15) DEFAULT NULL,
  `course` varchar(20) DEFAULT NULL,
  `branch` varchar(20) DEFAULT NULL,
  `notice` varchar(300) DEFAULT NULL,
  `uploaded_by` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES ('27/12/2017','BTECH','CSE','welcome all','Hello');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_registration`
--

DROP TABLE IF EXISTS `student_registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_registration`
--

LOCK TABLES `student_registration` WRITE;
/*!40000 ALTER TABLE `student_registration` DISABLE KEYS */;
INSERT INTO `student_registration` VALUES ('11111','tanay','69','3/Nov/1998','Male','9829077531','tanaytoshniwal98@gmail.com','CSE','BTECH',4,'18/Jul/2016','Jaipur Rajasthan','tan123');
/*!40000 ALTER TABLE `student_registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'student'
--

--
-- Dumping routines for database 'student'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-31  0:48:39
