-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: hhr
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `card_status`
--

DROP TABLE IF EXISTS `card_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card_status`
--

LOCK TABLES `card_status` WRITE;
/*!40000 ALTER TABLE `card_status` DISABLE KEYS */;
INSERT INTO `card_status` VALUES (1,'Новая'),(2,'Черновик'),(3,'Сохранена'),(4,'В архиве'),(5,'Переоткрыта'),(6,'Закрыта');
/*!40000 ALTER TABLE `card_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dev_methodology`
--

DROP TABLE IF EXISTS `dev_methodology`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dev_methodology` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dev_methodology`
--

LOCK TABLES `dev_methodology` WRITE;
/*!40000 ALTER TABLE `dev_methodology` DISABLE KEYS */;
INSERT INTO `dev_methodology` VALUES (1,'Waterfall Model'),(2,'Incremental Model'),(3,'Agile Model'),(4,'Spiral Model');
/*!40000 ALTER TABLE `dev_methodology` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `overtimes`
--

DROP TABLE IF EXISTS `overtimes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `overtimes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `overtimes`
--

LOCK TABLES `overtimes` WRITE;
/*!40000 ALTER TABLE `overtimes` DISABLE KEYS */;
INSERT INTO `overtimes` VALUES (1,'Редкие'),(2,'Постоянные');
/*!40000 ALTER TABLE `overtimes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `id` int NOT NULL AUTO_INCREMENT,
  `client` varchar(100) NOT NULL,
  `card_status` int DEFAULT NULL,
  `project_type` int DEFAULT NULL,
  `id_employee` int NOT NULL,
  `name` varchar(200) NOT NULL,
  `func_area` text,
  `subject_area` text,
  `description` text NOT NULL,
  `tasks` text NOT NULL,
  `stage` int DEFAULT NULL,
  `dead_line` date NOT NULL,
  `technoligies` text NOT NULL,
  `dev_method` int DEFAULT NULL,
  `stake_holders` int DEFAULT NULL,
  `product` tinyint(1) NOT NULL,
  `analitics` int NOT NULL,
  `devs` int NOT NULL,
  `testers` tinyint(1) NOT NULL,
  `tech_writers` tinyint(1) NOT NULL,
  `team` int NOT NULL,
  `location` text,
  `timeplan` int DEFAULT NULL,
  `deadline_hr` date NOT NULL,
  `overtimes` int DEFAULT NULL,
  `hr_details` text NOT NULL,
  `gost` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `card_status` (`card_status`),
  KEY `project_type` (`project_type`),
  KEY `stage` (`stage`),
  KEY `dev_method` (`dev_method`),
  KEY `timeplan` (`timeplan`),
  KEY `overtimes` (`overtimes`),
  CONSTRAINT `project_ibfk_1` FOREIGN KEY (`card_status`) REFERENCES `card_status` (`id`),
  CONSTRAINT `project_ibfk_2` FOREIGN KEY (`project_type`) REFERENCES `project_type` (`id`),
  CONSTRAINT `project_ibfk_3` FOREIGN KEY (`stage`) REFERENCES `project_stage` (`id`),
  CONSTRAINT `project_ibfk_4` FOREIGN KEY (`dev_method`) REFERENCES `dev_methodology` (`id`),
  CONSTRAINT `project_ibfk_5` FOREIGN KEY (`timeplan`) REFERENCES `time_plan` (`id`),
  CONSTRAINT `project_ibfk_6` FOREIGN KEY (`overtimes`) REFERENCES `overtimes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_stage`
--

DROP TABLE IF EXISTS `project_stage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_stage` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_stage`
--

LOCK TABLES `project_stage` WRITE;
/*!40000 ALTER TABLE `project_stage` DISABLE KEYS */;
INSERT INTO `project_stage` VALUES (1,'Инициация'),(2,'Начало'),(3,'Середина'),(4,'Завершение');
/*!40000 ALTER TABLE `project_stage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_type`
--

DROP TABLE IF EXISTS `project_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_type`
--

LOCK TABLES `project_type` WRITE;
/*!40000 ALTER TABLE `project_type` DISABLE KEYS */;
INSERT INTO `project_type` VALUES (1,'Фикс'),(2,'Т и М'),(3,'ПО'),(4,'ПАК'),(5,'MVP'),(6,'Новая система'),(7,'Модернизация существующей системы');
/*!40000 ALTER TABLE `project_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_plan`
--

DROP TABLE IF EXISTS `time_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time_plan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_plan`
--

LOCK TABLES `time_plan` WRITE;
/*!40000 ALTER TABLE `time_plan` DISABLE KEYS */;
INSERT INTO `time_plan` VALUES (1,'Строго по графику'),(2,'Сдвиг по времени');
/*!40000 ALTER TABLE `time_plan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-24 23:42:15
