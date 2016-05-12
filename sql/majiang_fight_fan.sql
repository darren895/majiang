-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: majiang
-- ------------------------------------------------------
-- Server version	5.7.9-log

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
-- Table structure for table `fight_fan`
--

DROP TABLE IF EXISTS `fight_fan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fight_fan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fightId` int(11) DEFAULT NULL,
  `fanId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `useridIndex` (`userId`),
  KEY `fightIndex` (`fightId`),
  KEY `userIdFanId` (`userId`,`fanId`)
) ENGINE=InnoDB AUTO_INCREMENT=331 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fight_fan`
--

LOCK TABLES `fight_fan` WRITE;
/*!40000 ALTER TABLE `fight_fan` DISABLE KEYS */;
INSERT INTO `fight_fan` VALUES (1,1,30,4),(2,1,23,4),(3,1,18,4),(4,2,37,2),(5,2,18,2),(6,2,10,2),(7,3,61,3),(8,3,38,3),(9,3,19,3),(10,3,6,3),(11,3,5,3),(12,3,13,3),(13,3,13,3),(14,3,13,3),(15,3,13,3),(16,4,29,5),(17,4,5,5),(18,4,10,5),(19,4,13,5),(20,4,13,5),(21,5,35,2),(22,5,18,2),(23,5,13,2),(24,5,13,2),(25,5,13,2),(26,5,13,2),(27,5,13,2),(28,6,32,4),(29,6,8,4),(30,6,5,4),(31,6,13,4),(37,7,31,2),(38,7,6,2),(39,7,5,2),(40,7,2,2),(41,7,12,2),(42,7,13,2),(43,8,47,4),(44,8,20,4),(45,8,19,4),(46,9,28,5),(47,9,21,5),(48,9,11,5),(49,9,5,5),(50,9,5,5),(51,9,13,5),(52,10,30,5),(53,10,14,5),(54,10,13,5),(55,10,13,5),(56,11,47,5),(57,11,20,5),(58,11,12,5),(59,11,13,5),(60,11,13,5),(61,12,47,5),(62,12,43,5),(63,12,5,5),(64,12,2,5),(65,12,13,5),(66,12,13,5),(81,14,49,1),(82,14,27,1),(83,14,18,1),(84,14,2,1),(85,14,12,1),(86,14,10,1),(87,16,49,4),(88,16,18,4),(89,16,2,4),(90,16,12,4),(91,16,9,4),(92,16,13,4),(93,16,13,4),(94,17,31,2),(95,17,16,2),(96,17,12,2),(97,17,10,2),(98,17,13,2),(99,17,13,2),(100,18,29,7),(101,18,14,7),(102,18,12,7),(103,19,49,4),(104,19,18,4),(105,19,7,4),(106,19,13,4),(107,20,49,4),(108,20,17,4),(109,20,8,4),(110,20,7,4),(111,21,31,4),(112,21,30,4),(113,21,16,4),(114,21,15,4),(115,21,6,4),(116,21,13,4),(117,21,13,4),(118,21,13,4),(119,21,13,4),(120,21,13,4),(125,22,31,2),(126,22,15,2),(127,22,11,2),(128,22,6,2),(129,22,2,2),(130,23,30,2),(131,23,18,2),(132,23,13,2),(133,23,13,2),(134,23,13,2),(139,24,29,2),(140,24,14,2),(141,24,11,2),(142,24,5,2),(143,24,13,2),(144,25,29,1),(145,25,28,1),(146,25,34,1),(147,25,5,1),(148,25,13,1),(149,26,44,2),(150,26,13,2),(151,26,13,2),(152,27,35,2),(153,27,12,2),(154,27,10,2),(155,28,31,4),(156,28,27,4),(157,28,17,4),(158,28,15,4),(159,28,13,4),(160,28,13,4),(161,29,37,1),(162,29,18,1),(163,29,17,1),(164,29,11,1),(165,29,4,1),(166,29,13,1),(167,29,13,1),(168,30,55,1),(169,30,31,1),(170,30,13,1),(171,30,13,1),(172,31,28,1),(173,31,8,1),(174,31,6,1),(175,31,5,1),(176,31,5,1),(177,31,13,1),(178,32,46,2),(179,32,19,2),(180,32,6,2),(181,32,12,2),(182,32,13,2),(183,33,31,1),(184,33,11,1),(185,33,1,1),(186,33,5,1),(187,34,29,1),(188,34,14,1),(189,34,1,1),(190,34,13,1),(191,35,55,1),(192,35,25,1),(193,35,7,1),(194,35,13,1),(195,35,13,1),(196,35,13,1),(197,36,46,2),(198,36,2,2),(199,36,12,2),(200,36,13,2),(201,37,31,4),(202,37,16,4),(203,37,11,4),(204,37,2,4),(205,37,13,4),(209,38,31,7),(210,38,25,7),(211,38,16,7),(212,38,13,7),(213,38,13,7),(214,39,47,2),(215,39,19,2),(216,39,13,2),(217,39,13,2),(218,40,31,7),(219,40,14,7),(220,40,5,7),(221,40,12,7),(222,40,10,7),(223,41,58,1),(224,41,5,1),(225,41,12,1),(226,41,13,1),(227,41,13,1),(228,42,55,2),(229,42,8,2),(230,42,7,2),(231,42,13,2),(232,43,58,2),(233,43,51,2),(234,43,10,2),(235,43,13,2),(236,43,13,2),(237,43,13,2),(238,43,13,2),(239,43,13,2),(240,44,35,1),(241,44,31,1),(242,44,11,1),(243,44,5,1),(244,44,12,1),(245,44,13,1),(246,44,13,1),(247,44,13,1),(248,13,47,1),(249,13,18,1),(250,13,1,1),(251,13,2,1),(252,13,10,1),(253,13,13,1),(254,13,13,1),(255,45,46,2),(256,45,37,2),(257,45,10,2),(258,45,13,2),(259,45,13,2),(260,46,49,7),(261,46,13,7),(262,46,13,7),(263,46,13,7),(264,47,29,9),(265,47,28,9),(266,47,21,9),(267,47,5,9),(268,47,5,9),(269,47,13,9),(270,47,13,9),(271,48,25,10),(272,48,11,10),(273,48,8,10),(274,48,3,10),(275,48,2,10),(276,49,61,9),(277,49,1,9),(278,49,2,9),(279,49,9,9),(280,49,13,9),(281,49,13,9),(282,50,29,9),(283,50,32,9),(284,50,5,9),(285,50,5,9),(286,50,13,9),(287,50,13,9),(288,50,13,9),(289,51,30,9),(290,51,18,9),(291,51,2,9),(292,51,13,9),(293,52,71,1),(294,52,29,1),(295,52,5,1),(296,52,12,1),(297,52,13,1),(298,52,13,1),(299,53,28,10),(300,53,15,10),(301,53,7,10),(302,53,5,10),(303,53,13,10),(304,54,58,1),(305,54,5,1),(306,54,12,1),(307,54,13,1),(308,55,35,1),(309,55,8,1),(310,55,13,1),(311,55,13,1),(312,56,55,1),(313,56,25,1),(314,56,8,1),(315,56,13,1),(316,56,13,1),(317,57,28,11),(318,57,23,11),(319,57,12,11),(320,57,13,11),(321,58,55,9),(322,58,8,9),(323,58,7,9),(324,58,13,9),(325,58,13,9),(326,59,30,9),(327,59,18,9),(328,59,2,9),(329,59,12,9),(330,59,13,9);
/*!40000 ALTER TABLE `fight_fan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-12  0:49:40