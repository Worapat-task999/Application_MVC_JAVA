CREATE DATABASE  IF NOT EXISTS `school` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `school`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: school
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `lecturer`
--

DROP TABLE IF EXISTS `lecturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lecturer` (
  `tid` int NOT NULL,
  `firstname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecturer`
--

LOCK TABLES `lecturer` WRITE;
/*!40000 ALTER TABLE `lecturer` DISABLE KEYS */;
INSERT INTO `lecturer` VALUES (1,'karla','asd'),(2,'kuku','ds'),(3,'mumu','aaas'),(4,'mama','ddsad'),(5,'fasfsaf','safsafasfsaf'),(6,'sad','asdasdasd'),(7,'wow','koo');
/*!40000 ALTER TABLE `lecturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platforms`
--

DROP TABLE IF EXISTS `platforms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `platforms` (
  `pid` int NOT NULL,
  `platformname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sscore` double DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platforms`
--

LOCK TABLES `platforms` WRITE;
/*!40000 ALTER TABLE `platforms` DISABLE KEYS */;
INSERT INTO `platforms` VALUES (1,'google classroom',8),(2,'youtube',6.5),(3,'facebook',4),(4,'microsoft team',7),(5,'google hangout',7.5),(6,'zoom',7.5),(7,'perals',8.5);
/*!40000 ALTER TABLE `platforms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjects` (
  `sid` int NOT NULL,
  `subjectname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tid` int DEFAULT NULL,
  `pid` int DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `tid_idx` (`tid`),
  KEY `pid_idx` (`pid`),
  CONSTRAINT `pid` FOREIGN KEY (`pid`) REFERENCES `platforms` (`pid`),
  CONSTRAINT `tid` FOREIGN KEY (`tid`) REFERENCES `lecturer` (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (1,'Fundamental Programming',1,4),(2,'MVC Programming',2,1),(3,'Computer Science',2,1),(4,'Software Engineering',3,7),(5,'Data Structures',3,7),(6,'Calculus',4,3);
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-27 23:37:37
