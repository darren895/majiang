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
-- Table structure for table `fan`
--

DROP TABLE IF EXISTS `fan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `score` int(11) unsigned NOT NULL DEFAULT '0',
  `except` varchar(255) DEFAULT NULL,
  `unique` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fan`
--

LOCK TABLES `fan` WRITE;
/*!40000 ALTER TABLE `fan` DISABLE KEYS */;
INSERT INTO `fan` VALUES (1,'一般高',1,NULL,''),(2,'喜相逢',1,NULL,''),(3,'连六',1,NULL,''),(4,'老少副',1,NULL,''),(5,'幺九刻',1,NULL,'\0'),(6,'明杠',1,NULL,''),(7,'缺一门',1,NULL,''),(8,'无字',1,NULL,''),(9,'边张',1,NULL,''),(10,'坎张',1,NULL,''),(11,'单钓将',1,NULL,''),(12,'自摸',1,NULL,''),(13,'花牌',1,NULL,'\0'),(14,'箭刻',2,NULL,''),(15,'圈风刻',2,NULL,''),(16,'门风刻',2,NULL,''),(17,'门前清',2,NULL,''),(18,'平和',2,NULL,''),(19,'四归一',2,NULL,''),(20,'双同刻',2,NULL,''),(21,'双暗刻',2,NULL,''),(22,'暗杠',2,NULL,''),(23,'断幺',2,NULL,''),(24,'全带幺',4,NULL,''),(25,'不求人',4,'12',''),(26,'双明杠',4,'6',''),(27,'和绝张',4,NULL,''),(28,'碰碰和',6,NULL,''),(29,'混一色',6,NULL,''),(30,'三色三步高',6,NULL,''),(31,'五门齐',6,NULL,''),(32,'全求人',6,'11',''),(33,'双暗杠',6,NULL,''),(34,'双箭刻',6,NULL,''),(35,'花龙',8,NULL,''),(36,'推不倒',8,'7',''),(37,'三色三同顺',8,NULL,''),(38,'三色三节高',8,NULL,''),(39,'无番和',8,NULL,''),(40,'妙手回春',8,'12',''),(41,'海底捞月',8,NULL,''),(42,'杠上开花',8,'12',''),(43,'抢杠和',8,'27',''),(44,'全不靠',12,'31,17,11',''),(45,'组合龙',12,NULL,''),(46,'大于五',12,'8',''),(47,'小于五',12,'8',''),(48,'三风刻',12,NULL,''),(49,'清龙',16,NULL,''),(50,'三色双龙会',16,'2,4,8,18',''),(51,'一色三步高',16,NULL,''),(52,'全带五',16,'23',''),(53,'三同刻',16,NULL,''),(54,'三暗刻',16,NULL,''),(55,'七对',24,'11,12,17',''),(56,'七星不靠',24,'31,17,11',''),(57,'全双刻',24,'28,22',''),(58,'清一色',24,'8',''),(59,'一色三同顺',24,'60',''),(60,'一色三节高',24,'59',''),(61,'全大',24,'8',''),(62,'全中',24,'23',''),(63,'全小',24,'8',''),(64,'一色四步高',32,NULL,''),(65,'三杠',32,NULL,''),(66,'混幺九',32,'28',''),(67,'一色四同顺',48,'65,60,1,19',''),(68,'一色四节高',48,'59,28',''),(69,'清幺九',64,'28,24,5,8',''),(70,'小四喜',64,'48',''),(71,'小三元',64,'14',''),(72,'字一色',64,'28',''),(73,'四暗刻',64,'28,17',''),(74,'一色双龙会',64,'55,18,58',''),(75,'大四喜',88,'28,48,16,15,5',''),(76,'大三元',88,'14,34',''),(77,'绿一色',88,NULL,''),(78,'九莲宝灯',88,'58,5,12,17',''),(79,'四杠',88,NULL,''),(80,'连七对',88,'55,58,11,17,25',''),(81,'十三幺',88,'31,17,11,12','');
/*!40000 ALTER TABLE `fan` ENABLE KEYS */;
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
