-- MySQL dump 10.15  Distrib 10.0.35-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: testsir
-- ------------------------------------------------------
-- Server version	10.0.35-MariaDB

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
-- Table structure for table `Allergie`
--

DROP TABLE IF EXISTS `Allergie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Allergie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Allergie`
--

LOCK TABLES `Allergie` WRITE;
/*!40000 ALTER TABLE `Allergie` DISABLE KEYS */;
INSERT INTO `Allergie` VALUES (6,'cereales','cereales'),(7,'crustaces','crustaces'),(8,'oeufs','oeufs'),(9,'poisson','poisson'),(10,'lait','lait');
/*!40000 ALTER TABLE `Allergie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Createur`
--

DROP TABLE IF EXISTS `Createur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Createur` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Createur`
--

LOCK TABLES `Createur` WRITE;
/*!40000 ALTER TABLE `Createur` DISABLE KEYS */;
INSERT INTO `Createur` VALUES (2,'angel.rivas@etudiant.univ-rennes1.fr','rivas','angel');
/*!40000 ALTER TABLE `Createur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DateSondage`
--

DROP TABLE IF EXISTS `DateSondage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DateSondage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `jour` varchar(255) DEFAULT NULL,
  `pause` varchar(255) DEFAULT NULL,
  `sondage_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6bxlk5jjnhdyjs49nexeynidf` (`sondage_id`),
  CONSTRAINT `FK_6bxlk5jjnhdyjs49nexeynidf` FOREIGN KEY (`sondage_id`) REFERENCES `Sondage` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DateSondage`
--

LOCK TABLES `DateSondage` WRITE;
/*!40000 ALTER TABLE `DateSondage` DISABLE KEYS */;
INSERT INTO `DateSondage` VALUES (3,'lundi','true',2),(4,'mardi','false',2);
/*!40000 ALTER TABLE `DateSondage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HeureSondage`
--

DROP TABLE IF EXISTS `HeureSondage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HeureSondage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `depart` varchar(255) DEFAULT NULL,
  `fin` varchar(255) DEFAULT NULL,
  `date_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_my7nsknpjc9672dbdnltwxwd5` (`date_id`),
  CONSTRAINT `FK_my7nsknpjc9672dbdnltwxwd5` FOREIGN KEY (`date_id`) REFERENCES `DateSondage` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HeureSondage`
--

LOCK TABLES `HeureSondage` WRITE;
/*!40000 ALTER TABLE `HeureSondage` DISABLE KEYS */;
INSERT INTO `HeureSondage` VALUES (4,'02:00','03:00',3),(5,'03:00','04:00',3),(6,'02:00','03:00',4);
/*!40000 ALTER TABLE `HeureSondage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Participant`
--

DROP TABLE IF EXISTS `Participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Participant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `allergie_id` bigint(20) DEFAULT NULL,
  `date_id` bigint(20) DEFAULT NULL,
  `heure_id` bigint(20) DEFAULT NULL,
  `preference_id` bigint(20) DEFAULT NULL,
  `sondage_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_kk4fswms2gw8fney0bgo4krvb` (`allergie_id`),
  KEY `FK_1xv49qx2x6i6kemkug9f4udkn` (`date_id`),
  KEY `FK_89vh37xovn8732lhqb5e02oce` (`heure_id`),
  KEY `FK_mun99c8ix68ufsks0u6mbkmey` (`preference_id`),
  KEY `FK_lddyxba49s4501qioljtavx0k` (`sondage_id`),
  CONSTRAINT `FK_1xv49qx2x6i6kemkug9f4udkn` FOREIGN KEY (`date_id`) REFERENCES `DateSondage` (`id`),
  CONSTRAINT `FK_89vh37xovn8732lhqb5e02oce` FOREIGN KEY (`heure_id`) REFERENCES `HeureSondage` (`id`),
  CONSTRAINT `FK_kk4fswms2gw8fney0bgo4krvb` FOREIGN KEY (`allergie_id`) REFERENCES `Allergie` (`id`),
  CONSTRAINT `FK_lddyxba49s4501qioljtavx0k` FOREIGN KEY (`sondage_id`) REFERENCES `Sondage` (`id`),
  CONSTRAINT `FK_mun99c8ix68ufsks0u6mbkmey` FOREIGN KEY (`preference_id`) REFERENCES `Preference` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Participant`
--

LOCK TABLES `Participant` WRITE;
/*!40000 ALTER TABLE `Participant` DISABLE KEYS */;
INSERT INTO `Participant` VALUES (6,'miguel.rivas@etudiant.univ-rennes1.fr','rivas','miguel',6,3,4,1,2),(7,'sebastien.kobenan@etudiant.univ-rennes1.fr','kobenans','sebastien',7,3,5,2,2),(8,'abbah.anno@etudiant.univ-rennes1.fr','anno','abbah',8,3,4,1,2),(9,'laeba.talat@etudiant.univ-rennes1.fr','talat','laeba',6,4,6,1,2),(10,'constant.lagnito@etudiant.univ-rennes1.fr','lagnito','constant',8,4,6,2,2),(11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3);
/*!40000 ALTER TABLE `Participant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Preference`
--

DROP TABLE IF EXISTS `Preference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Preference` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Preference`
--

LOCK TABLES `Preference` WRITE;
/*!40000 ALTER TABLE `Preference` DISABLE KEYS */;
INSERT INTO `Preference` VALUES (1,'ketchup','ketchup'),(2,'nouille','nouille'),(3,'charcuteri','charcuteri'),(4,'sans sucre','sans sucre'),(5,'soda light','soda light');
/*!40000 ALTER TABLE `Preference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Sondage`
--

DROP TABLE IF EXISTS `Sondage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sondage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `intitule` varchar(255) DEFAULT NULL,
  `lieu` varchar(255) DEFAULT NULL,
  `resume` varchar(255) DEFAULT NULL,
  `createur_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ryeweajf7yvl3hebuu6mhfkmf` (`createur_id`),
  CONSTRAINT `FK_ryeweajf7yvl3hebuu6mhfkmf` FOREIGN KEY (`createur_id`) REFERENCES `Createur` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sondage`
--

LOCK TABLES `Sondage` WRITE;
/*!40000 ALTER TABLE `Sondage` DISABLE KEYS */;
INSERT INTO `Sondage` VALUES (2,'sondage 1','beaulieu','sondage de test',2),(3,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `Sondage` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-15 10:34:27
