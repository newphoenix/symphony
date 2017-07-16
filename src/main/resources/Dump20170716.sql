CREATE DATABASE  IF NOT EXISTS `rest_db2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `rest_db2`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: rest_db2
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority` (
  `email` varchar(60) NOT NULL,
  `authority` varchar(80) NOT NULL,
  PRIMARY KEY (`email`,`authority`),
  KEY `email` (`email`),
  CONSTRAINT `email_fk7` FOREIGN KEY (`email`) REFERENCES `user` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES ('ad@admin.org','ROLE_admin'),('alaa.elabdullah@gmail.com','ROLE_user'),('alaa@gmail.com','ROLE_company'),('ali@gmail.com','ROLE_user'),('amer@gmail.com','ROLE_user'),('amir@gmail.com','ROLE_user'),('companyapp1001@yahoo.com','ROLE_company'),('delkey1001-buyer@gmail.com','ROLE_user'),('delkey1001@gmail.com','ROLE_user'),('example@gmail.com','ROLE_REST'),('tt00@gmail.com','ROLE_user'),('tt0@gmail.com','ROLE_user'),('tt1@gmail.com','ROLE_user'),('tt2@gmail.com','ROLE_user'),('tt5@gmail.com','ROLE_user'),('tt8@gmail.com','ROLE_user'),('tt91@gmail.com','ROLE_user'),('tt9@gmail.com','ROLE_user'),('tt@gmail.com','ROLE_user'),('tt@gmail.com3','ROLE_user'),('user2@yahoo.com','ROLE_USER'),('userapp1001@gmail.com','ROLE_company');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link`
--

DROP TABLE IF EXISTS `link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `link` varchar(512) NOT NULL,
  `tag` varchar(512) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userId3` (`user_id`),
  CONSTRAINT `userId3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link`
--

LOCK TABLES `link` WRITE;
/*!40000 ALTER TABLE `link` DISABLE KEYS */;
INSERT INTO `link` VALUES (1,'http://www.example.com','technology',24),(2,'http://www.example1.com','technology1',24),(5,'http://www.example4.com','technology5',24),(6,'www.klix.ba','news',24),(10,'http://www.example78.com','technology',24),(12,'http://www.example.com/?a=125','technology',24),(13,'http://www.example.com/?c=125','technology',24),(14,'http://www.example.com/?d=125','technology',24),(15,'http://www.example.com/?e=125','technology',24),(16,'http://www.example.com/?a=125&b=126','technology',24),(18,'http://www.example.com/?a=125&c=126','technology',24),(24,'www.klix.ba/?news=today','technology',24),(27,'http://www.example.com/?b=126&a=125&c-lambda','technology',24);
/*!40000 ALTER TABLE `link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(60) NOT NULL,
  `password` varchar(128) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `enabled` tinyint(1) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (20,'example@gmail.com','test1','example','example',1),(21,'user2@yahoo.com','test1','user2','user2',1),(22,'userapp1001@gmail.com','test1','userapp','userapp',1),(23,'companyapp1001@yahoo.com','test1','company','company',1),(24,'alaa@gmail.com','test1','alaa','el',1),(25,'amer@gmail.com','test1','amer','lulic',1),(26,'ali@gmail.com','test1','ali','mukic',1),(27,'amir@gmail.com','test1','amir','tularic',1),(28,'alaa.elabdullah@gmail.com','test1','alaa','elabdullah',1),(29,'ad@admin.org','test1','ad','admin',1),(30,'delkey1001-buyer@gmail.com','test1','delkey','delkey1001',1),(31,'delkey1001@gmail.com','test1','delkey2','delkey2002',1),(38,'tt@gmail.com','test1','aaa','bbb',1),(40,'tt1@gmail.com','test1','eee','rrr',1),(41,'tt2@gmail.com','test1','dgdfg','dgdg',1),(42,'tt@gmail.com3','test1','aas','ccv',1),(43,'tt5@gmail.com','test1','aax','bbx',1),(44,'tt8@gmail.com','test1','tt8','tt88',1),(45,'tt9@gmail.com','test1','tt9','tt9',1),(46,'tt91@gmail.com','123','abc','xyzz',1),(47,'tt0@gmail.com','test1','aaa','cvb',1),(48,'tt00@gmail.com','   ','   ','      ',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'rest_db2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-16 11:45:52
