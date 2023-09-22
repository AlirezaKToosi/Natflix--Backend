CREATE DATABASE  IF NOT EXISTS `videostream` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `videostream`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: videostream
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `additional_details`
--

DROP TABLE IF EXISTS `additional_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `additional_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `banner_url` varchar(255) DEFAULT NULL,
  `logo_url` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `thumbnail_url` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `video_code` varchar(255) DEFAULT NULL,
  `episod_url` varchar(255) DEFAULT NULL,
  `episode_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `additional_details`
--

LOCK TABLES `additional_details` WRITE;
/*!40000 ALTER TABLE `additional_details` DISABLE KEYS */;
INSERT INTO `additional_details` VALUES (29,'','','A woman Jerry met in Michigan flies into New York and asks to stay with him, but he\'s unsure if it\'s intended to be a romantic situation.','/images/thumbnails/\\d8130001-6490-4f78-8e1d-4d50cec0c963.png','Seinfeld (pilot)','A72K4M1R1tg',NULL,NULL),(30,'','','After recently breaking up with Elaine, Jerry meets a woman at a party but only learns where she works, leading him to stake out her office.','/images/thumbnails/\\7d325f59-90d6-4f9c-b0bd-56d355ea0c69.png','The Stake Out','jVJ7Vs3Y10w',NULL,NULL),(31,'','','Jerry\'s apartment gets robbed, leading him to want to move to a different place and give his current apartment to Elaine.','/images/thumbnails/\\129dccc3-964e-4e6b-b5a9-476c7ba60f26.png','The Robbery','hQXKyIG_NS4',NULL,NULL),(32,'','','After George breaks up with a woman he finds annoying, Jerry dates her and also finds her grating, yet he can\'t bring himself to end the relationship.','/images/thumbnails/\\477643c2-4dee-4f29-89c0-72df5cc37c9a.png','The Ex-Girlfriend','PaPxSsK6ZQA',NULL,NULL),(33,'','','When Jerry\'s parents visit New York, Jerry upsets a family member with a remark about ponies. Kramer wants to build \"levels\" in his apartment.','/images/thumbnails/\\d3d774ff-ba67-47ca-b6d6-d0829259002e.png','The Pony Remark','uzda2bjj6YI',NULL,NULL),(34,'','','Jerry buys an expensive suede jacket with an odd lining. Jerry and George get stuck alone with Elaine\'s intimidating father.','/images/thumbnails/\\6fd764c4-431b-4781-b969-85dc34007f7a.png','The Jacket','9tyGHnm_9Rc',NULL,NULL),(35,'','','George goes to great lengths to prevent a woman he\'s dating from hearing an answering machine message. Jerry\'s date likes a commercial he hates.','/images/thumbnails/\\39ed3369-380f-415b-971f-e3216ab6547f.png','The Phone Message','kjAkpnR3Ptg',NULL,NULL),(36,'','','Jerry scares a massage therapist, while George questions his sexuality after a massage. Kramer insists he saw Joe DiMaggio at a donut shop.','/images/thumbnails/\\d3d774ff-ba67-47ca-b6d6-d0829259002e.png','The Note','ptbw05iuYq0',NULL,NULL),(37,'','','George breaks up with his girlfriend, who happens to be in the middle of helping Jerry with a tax audit. Kramer dates Elaine\'s roommate.','/images/thumbnails/\\24147704-8ab2-490d-b546-080bad765948.png','The Truth','JVte31KnZis',NULL,NULL),(38,'/images/banners/\\0cd8e0ec-9a44-44a3-ac5e-c9f689967d93.png','/images/logos/\\6fb954e3-c8ee-4cb2-89e5-356f5250317b.png','The show about nothing is a sitcom landmark, with comic Jerry and his three sardonic friends finding laughs in both the mundane and the ridiculous','/images/thumbnails/\\e04dba28-cd0a-472c-8288-e7b0248786c4.png','Seinfield',NULL,NULL,''),(39,'/images/banners/\\0cd8e0ec-9a44-44a3-ac5e-c9f689967d93.png','/images/logos/\\6fb954e3-c8ee-4cb2-89e5-356f5250317b.png','The show about nothing is a sitcom landmark, with comic Jerry and his three sardonic friends finding laughs in both the mundane and the ridiculous','/images/thumbnails/\\e04dba28-cd0a-472c-8288-e7b0248786c4.png','Seinfield',NULL,NULL,''),(40,'','','Kido Senshi Gandamu Tsū Ai Senshi-hen is  a 1981 anime film directed by Yoshiyuki Tomino and animated by Sunrise. It is the second Mobile Suit Gundam compilation movie','/images/thumbnails/\\f676f937-a873-4599-8d5f-bfd41edf8dc8.png','Gundam II',NULL,NULL,''),(41,'','/images/logos/\\997078ec-c257-45d3-8e49-925f9b918ea1.png','Kido Senshi Gandamu Tsū Ai Senshi-hen is  a 1981 anime film directed by Yoshiyuki Tomino and animated by Sunrise. It is the second Mobile Suit Gundam compilation movie','/images/thumbnails/\\f9399123-90d6-4666-8c5f-80978b21777a.png','Gundam II',NULL,NULL,''),(42,'','/images/logos/\\1f3677d1-f119-46a3-9082-e229e7704385.png','A man has had his life turned upside down after his partner walks out on him after 17 years.','/images/thumbnails/\\c46257c5-e8d3-4fd1-999c-760dee20ae30.png','Uncoupled',NULL,NULL,''),(43,'','/images/logos/\\ace1351b-3a7a-4f01-bb34-7712970da8b0.png','Lauren Pierce is admitted to a correctional facility after she hits her friend\'s abusive boyfriend. She plots to escape when she realises the extent of corruption in the facility','/images/thumbnails/\\437c082b-bf7e-49ab-9d85-064c5fb5437b.png','Archer',NULL,NULL,''),(44,'','/images/logos/\\3740b8f3-59a3-4953-ae81-4130b2b88ef2.png','After a global financial crisis, the world is engulfed in an AI-driven war, and it\'s up to Section 9 to counter new forms of cyber threats.','/images/logos/\\3740b8f3-59a3-4953-ae81-4130b2b88ef2.png','Ghost in the Shell SAC 2045',NULL,NULL,''),(45,'','/images/logos/\\5fa6c44a-0634-4303-b3df-3838ece49544.png','Aboard the spaceship Bebop, a bounty hunter and his group of skilled comrades embark on adventures across the Solar System to capture criminals','/images/thumbnails/\\e4889363-d2bb-4125-bcfb-3499a628e890.png','Cowboy Bebop',NULL,NULL,''),(46,'','/images/logos/\\43505a58-240b-4d97-bd8b-61160533c31c.png','Eight thieves take hostages and lock themselves in the Royal Mint of Spain as a criminal mastermind manipulates the police to carry out his plan','/images/logos/\\43505a58-240b-4d97-bd8b-61160533c31c.png','Money Heist',NULL,NULL,''),(47,'','/images/logos/\\b59942d0-adfe-4f80-b664-86c5c25181ad.png','Narcos: Mexico is an American-Mexican crime drama streaming television series created and produced by Chris Brancato, Carlo Bernard','/images/thumbnails/\\fa5ddafc-e227-4303-b541-137807f0c5bb.png','Narcos Mexico',NULL,NULL,''),(48,'','/images/logos/\\de763f27-50e0-4c24-ae28-0e77959c50b8.png','Amuro and Char try to blast each other with bombs and rockets while Amuro believes that Char is trying to cause a foolish revolution','/images/thumbnails/\\c231f107-03cf-48b6-a169-615904362199.png','Gundam Char\'s Counter Attack',NULL,NULL,''),(49,'','/images/logos/\\9c97c1b0-94a9-49af-8807-8e56dba212b6.png','Neon Genesis Evangelion is a Japanese mecha anime television series produced by Gainax and animated by Tatsunoko, directed by Hideaki Anno','/images/thumbnails/\\8896da75-e91b-4cbc-9d46-0c93af5a126f.png','Neon Genesis Evangelion',NULL,NULL,''),(50,'','/images/logos/\\7796a2fb-b081-456e-84a8-9f46216bc363.png','Designated Survivor is an American political thriller drama television series created by David Guggenheim. It aired for three seasons','/images/thumbnails/\\dc8d7ec2-0d5b-4e44-9200-24ae45244fed.png','Designated Survivor',NULL,NULL,''),(51,'','/images/logos/\\4592de0e-0869-421e-8f58-74a521ee6438.png','The Queen\'s Gambit is a 2020 American coming-of-age period drama streaming television miniseries based on the 1983 novel of the same name by Walter Tevis.','/images/thumbnails/\\1684b97b-767a-4c4b-85a7-8fc1064f16cd.png','Queen\'s Gambit',NULL,NULL,''),(52,'','/images/logos/\\42da703b-0b52-4735-a9b1-09f9f3e28080.png','A lawyer, whose law degree has been revoked, is compelled to join the Greendale Community College. Students of diverse temperaments join his study group which leads to quirky and memorable encounters.','/images/logos/\\42da703b-0b52-4735-a9b1-09f9f3e28080.png','Community',NULL,NULL,''),(53,'','/images/logos/\\8bd80700-ea2f-4c6c-96b7-b5cac6b8fb57.png','Vikings is a historical drama television series created and written by Michael Hirst for the History channel, a Canadian network.','/images/thumbnails/\\f1d322f8-c2e1-4b9a-b2be-a1ea14ed6726.png','Vikings',NULL,NULL,''),(54,'','/images/logos/\\c0b88689-aadf-4d2e-9208-72c1215a2962.png','Better Call Saul is an American crime and legal drama television series created by Vince Gilligan and Peter Gould','/images/thumbnails/\\a39426f2-cdec-4b54-849b-b041b3e87dc0.png','Better Call Saul',NULL,NULL,''),(55,'/images/banners/\\61599f51-ff9e-454b-91fc-4e453a19aaaf.png','/images/logos/\\84dda7a3-c317-4453-807b-47fde2cf0392.png','A political satire comedy about a high-school history teacher in his thirties who is unexpectedly elected President after a viral video filmed by one of his students shows him making a profane rant against government corruption.','/images/thumbnails/\\67a2cabb-2384-4cfd-b0e3-a1813a24a42e.png','Servant of the people',NULL,NULL,''),(56,'','/images/logos/\\a08606ff-f9ec-4ac4-adeb-b4fcc28e7613.png','A group of terrorists plans to detonate three plutonium cores for a simultaneous nuclear attack on different cities','/images/logos/\\a08606ff-f9ec-4ac4-adeb-b4fcc28e7613.png','Mission Impossible Fallout',NULL,NULL,''),(57,'','/images/logos/\\47204dc7-0975-4aed-91b3-e42e105e2af3.png','Two low-level astronomers must go on a giant media tour to warn mankind of an approaching comet that will destroy planet Earth.','/images/thumbnails/\\502421f8-fa48-47a8-b7b3-be9c87a220ce.png','Don\'t Look Up',NULL,NULL,''),(58,'','/images/logos/\\b4022fb1-a566-4f37-907c-64e551e8a231.png','Lieutenant Hanna, a detective, decides to catch a highly intelligent seasonal criminal who has vowed to pull off one last robbery before he retires for good.','/images/logos/\\b4022fb1-a566-4f37-907c-64e551e8a231.png','Heat',NULL,NULL,''),(59,'','/images/logos/\\309b6f52-64ba-4128-bf89-646fd8365ef7.png','Phil, a self-centred weatherman, goes to the town of Punxsutawney for an assignment.','/images/logos/\\309b6f52-64ba-4128-bf89-646fd8365ef7.png','Groundhog Day',NULL,NULL,''),(60,'','/images/logos/\\b98eac64-0d3c-41c1-82c7-79946b618dac.png','Billy Beane, a baseball general manager, and Peter Brand, an economics graduate, challenge convention as they try to form a competitive sports team using computer-based methods.','/images/logos/\\b98eac64-0d3c-41c1-82c7-79946b618dac.png','Moneyball',NULL,NULL,''),(61,'/images/banners/\\1efa15cb-04d9-4280-9401-b163484123fa.png','/images/logos/\\7f150430-8455-4783-9db8-fe7c19cc09ea.png','In the fall of 1997, Michael Jordan and the Chicago Bulls allowed a film crew to follow them as they went for their sixth NBA title in eight seasons','/images/thumbnails/\\5677d7bb-25a3-419e-8096-e0c262d79f81.png','The last dance',NULL,NULL,''),(62,'','/images/logos/\\530fd97a-e0c4-4ef8-af29-aa1d997e377f.png','Tilikum, a captive killer whale, has taken the lives of three people. This impassioned documentary tells his story to unravel the consequences of keeping orcas in captivity','/images/thumbnails/\\98d39a85-e41f-4df7-9534-7e5cd9b9beff.png','Blackfish',NULL,NULL,''),(63,'','/images/logos/\\36cf3901-9885-4d6c-bb69-e1a178aa2b1b.png','Five Mafia families controlled New York in the 1970s and 80s, until a group of federal agents work to take them down.','/images/thumbnails/\\fd56ef9c-5d32-479e-a13f-fb2e1102e511.png','Fear city',NULL,NULL,''),(64,'','/images/logos/\\f22d0030-a32f-4842-b215-82c43fba27a7.png','A group of elite Greek soldiers is assigned an impossible task of taking out the powerful German cannons on the Aegean island with the help of guerrilla fighters.','/images/thumbnails/\\e08cc19e-1b34-4566-b5d4-f7f9186cfea6.png','The Guns of Navarrone',NULL,NULL,''),(65,'','/images/logos/\\01566f61-f29b-4907-b581-62a2489e684a.png','Claire Beauchamp Randall, a nurse in World War II, mysteriously goes back in time to Scotland in 1743. There, she meets a dashing Highland warrior and gets drawn into an epic rebellion.','/images/thumbnails/\\ae0a4333-22a6-48a4-9fa8-f641391b0294.png','Outlander',NULL,NULL,''),(66,'','/images/logos/\\714e9168-439d-40cc-940e-ce444cd01ef0.png','The story of how kung-fu films became a huge phenomenon around the world, including interviews with action stars and industry figures.','/images/thumbnails/\\69ec44bd-522f-4322-af3c-f5c8628d9b96.png','Iron fist Kung fu Kicks',NULL,NULL,'');
/*!40000 ALTER TABLE `additional_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content`
--

DROP TABLE IF EXISTS `content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `content` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `CONTENT_TYPE_ID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CONT_TYPE_ID` (`CONTENT_TYPE_ID`),
  CONSTRAINT `CONT_TYPE_ID` FOREIGN KEY (`CONTENT_TYPE_ID`) REFERENCES `content_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content`
--

LOCK TABLES `content` WRITE;
/*!40000 ALTER TABLE `content` DISABLE KEYS */;
INSERT INTO `content` VALUES (1,1),(2,2),(3,3);
/*!40000 ALTER TABLE `content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content_category`
--

DROP TABLE IF EXISTS `content_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `content_category` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `CATEGORY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content_category`
--

LOCK TABLES `content_category` WRITE;
/*!40000 ALTER TABLE `content_category` DISABLE KEYS */;
INSERT INTO `content_category` VALUES (1,'Horror'),(2,'Action'),(3,'Comedy'),(4,'Drama'),(5,'Other');
/*!40000 ALTER TABLE `content_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content_type`
--

DROP TABLE IF EXISTS `content_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `content_type` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content_type`
--

LOCK TABLES `content_type` WRITE;
/*!40000 ALTER TABLE `content_type` DISABLE KEYS */;
INSERT INTO `content_type` VALUES (1,'Series'),(2,'Movies'),(3,'Documentaries');
/*!40000 ALTER TABLE `content_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documentaries`
--

DROP TABLE IF EXISTS `documentaries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `documentaries` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ADDITIONAL_ID` int DEFAULT NULL,
  `CATEGORY_ID` int DEFAULT NULL,
  `CONTENT_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `DOC_ADD_ID` (`ADDITIONAL_ID`),
  KEY `DOC_CAT_ID` (`CATEGORY_ID`),
  KEY `DOC_CONTENT_ID` (`CONTENT_ID`),
  CONSTRAINT `DOC_ADD_ID` FOREIGN KEY (`ADDITIONAL_ID`) REFERENCES `additional_details` (`id`),
  CONSTRAINT `DOC_CAT_ID` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `content_category` (`ID`),
  CONSTRAINT `DOC_CONTENT_ID` FOREIGN KEY (`CONTENT_ID`) REFERENCES `content` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documentaries`
--

LOCK TABLES `documentaries` WRITE;
/*!40000 ALTER TABLE `documentaries` DISABLE KEYS */;
INSERT INTO `documentaries` VALUES (1,61,5,3),(2,62,5,3),(3,63,5,3),(4,64,5,3),(5,65,5,3),(6,66,5,3);
/*!40000 ALTER TABLE `documentaries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `episodes`
--

DROP TABLE IF EXISTS `episodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `episodes` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `EPISODE_NUMBER` int DEFAULT NULL,
  `ADDITIONAL_ID` int DEFAULT NULL,
  `SEASON_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `EPISODE_ADD_ID` (`ADDITIONAL_ID`),
  KEY `EPI_SEASON_ID` (`SEASON_ID`),
  CONSTRAINT `EPI_SEASON_ID` FOREIGN KEY (`SEASON_ID`) REFERENCES `seasons` (`id`),
  CONSTRAINT `EPISODE_ADD_ID` FOREIGN KEY (`ADDITIONAL_ID`) REFERENCES `additional_details` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `episodes`
--

LOCK TABLES `episodes` WRITE;
/*!40000 ALTER TABLE `episodes` DISABLE KEYS */;
INSERT INTO `episodes` VALUES (1,1,29,1),(2,2,30,1),(3,3,31,1),(4,1,32,2),(5,2,33,2),(6,3,34,2),(7,4,35,2),(8,2,36,3),(9,3,37,3);
/*!40000 ALTER TABLE `episodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ADDITIONAL_ID` int DEFAULT NULL,
  `CATEGORY_ID` int DEFAULT NULL,
  `CONTENT_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `MOVIE_ADD_ID` (`ADDITIONAL_ID`),
  KEY `MOVIE_CAT_ID` (`CATEGORY_ID`),
  KEY `MOVIE_CONT_ID` (`CONTENT_ID`),
  CONSTRAINT `MOVIE_ADD_ID` FOREIGN KEY (`ADDITIONAL_ID`) REFERENCES `additional_details` (`id`),
  CONSTRAINT `MOVIE_CAT_ID` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `content_category` (`ID`),
  CONSTRAINT `MOVIE_CONT_ID` FOREIGN KEY (`CONTENT_ID`) REFERENCES `content` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,55,2,2),(2,56,2,2),(3,57,3,2),(4,58,2,2),(5,59,4,2),(6,60,2,2);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role` enum('ROLE_ADMIN','ROLE_CUSTOMER') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_CUSTOMER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seasons`
--

DROP TABLE IF EXISTS `seasons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seasons` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `SEASON_NUMBER` int DEFAULT NULL,
  `SERIES_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `SEASON_SERIES_ID` (`SERIES_ID`),
  CONSTRAINT `SEASON_SERIES_ID` FOREIGN KEY (`SERIES_ID`) REFERENCES `series` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seasons`
--

LOCK TABLES `seasons` WRITE;
/*!40000 ALTER TABLE `seasons` DISABLE KEYS */;
INSERT INTO `seasons` VALUES (1,1,1),(2,2,1),(3,3,1);
/*!40000 ALTER TABLE `seasons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `series`
--

DROP TABLE IF EXISTS `series`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `series` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ADDITIONAL_ID` int DEFAULT NULL,
  `CATEGORY_ID` int DEFAULT NULL,
  `CONTENT_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `SERIES_ADD_ID` (`ADDITIONAL_ID`),
  KEY `SERIES_CAT_ID` (`CATEGORY_ID`),
  KEY `SER_CONTENT_ID` (`CONTENT_ID`),
  CONSTRAINT `SER_CONTENT_ID` FOREIGN KEY (`CONTENT_ID`) REFERENCES `content` (`ID`),
  CONSTRAINT `SERIES_ADD_ID` FOREIGN KEY (`ADDITIONAL_ID`) REFERENCES `additional_details` (`id`),
  CONSTRAINT `SERIES_CAT_ID` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `content_category` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `series`
--

LOCK TABLES `series` WRITE;
/*!40000 ALTER TABLE `series` DISABLE KEYS */;
INSERT INTO `series` VALUES (1,39,3,1),(2,41,2,1),(3,42,3,1),(4,43,3,1),(5,44,2,1),(6,45,2,1),(7,46,2,1),(8,47,4,1),(9,48,2,1),(10,49,2,1),(11,50,4,1),(12,51,4,1),(13,52,3,1),(14,53,2,1),(15,54,4,1);
/*!40000 ALTER TABLE `series` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Admin@natflix.com','Admin','$2a$10$iurRFIMuWwzUqxrDEidkpeFvfx4RnVaEfrc0mSoFSfvVoUdVYO65S'),(2,'Alireza@natflix.com','Alireza','$2a$10$UdE8uoveVzXaAFkju31/6OuRI1L6268c4iAfThdOB951aEt6fIQpm');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`),
  CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKrhfovtciq1l558cw6udg0h0d3` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-22 12:35:26
