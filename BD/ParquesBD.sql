CREATE DATABASE  IF NOT EXISTS `gestionparquesnaturales` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gestionparquesnaturales`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gestionparquesnaturales
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `actividades_ocio`
--

DROP TABLE IF EXISTS `actividades_ocio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividades_ocio` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) DEFAULT NULL,
  `Descripcion` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividades_ocio`
--

LOCK TABLES `actividades_ocio` WRITE;
/*!40000 ALTER TABLE `actividades_ocio` DISABLE KEYS */;
INSERT INTO `actividades_ocio` VALUES (1,'Senderismo','Caminatas por rutas naturales'),(2,'Observación de aves','Avistamiento de diferentes especies de aves'),(3,'Ciclismo','Rutas en bicicleta por el parque'),(4,'Escalada','Escalada en roca en áreas designadas'),(5,'Camping','Acampada en zonas permitidas'),(6,'Piragüismo','Navegación en kayak o canoa'),(7,'Pesca','Pesca en ríos y lagos del parque'),(8,'Fotografía','Fotografía de paisajes y fauna'),(9,'Montañismo','Ascenso a montañas y picos'),(10,'Equitación','Paseos a caballo por el parque'),(11,'Espeleología','Exploración de cuevas y cavernas'),(12,'Rafting','Descenso de ríos en balsa'),(13,'Tiro con arco','Práctica de tiro con arco en áreas designadas'),(14,'Yoga al aire libre','Sesiones de yoga en la naturaleza'),(15,'Educación ambiental','Actividades educativas sobre el medio ambiente'),(16,'Senderismo','Caminatas por rutas naturales'),(17,'Observación de aves','Avistamiento de diferentes especies de aves'),(18,'Ciclismo','Rutas en bicicleta por el parque'),(19,'Escalada','Escalada en roca en áreas designadas'),(20,'Camping','Acampada en zonas permitidas'),(21,'Piragüismo','Navegación en kayak o canoa'),(22,'Pesca','Pesca en ríos y lagos del parque'),(23,'Fotografía','Fotografía de paisajes y fauna'),(24,'Montañismo','Ascenso a montañas y picos'),(25,'Equitación','Paseos a caballo por el parque'),(26,'Espeleología','Exploración de cuevas y cavernas'),(27,'Rafting','Descenso de ríos en balsa'),(28,'Tiro con arco','Práctica de tiro con arco en áreas designadas'),(29,'Yoga al aire libre','Sesiones de yoga en la naturaleza'),(30,'Educación ambiental','Actividades educativas sobre el medio ambiente');
/*!40000 ALTER TABLE `actividades_ocio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comunidadesautonomas`
--

DROP TABLE IF EXISTS `comunidadesautonomas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comunidadesautonomas` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comunidadesautonomas`
--

LOCK TABLES `comunidadesautonomas` WRITE;
/*!40000 ALTER TABLE `comunidadesautonomas` DISABLE KEYS */;
INSERT INTO `comunidadesautonomas` VALUES (1,'Andalucía'),(2,'Cantabria'),(3,'Castilla-La Mancha'),(4,'Castilla y León'),(5,'Cataluña'),(6,'Comunidad Valenciana'),(7,'Galicia'),(8,'Islas Baleares'),(9,'Islas Canarias'),(10,'Madrid'),(11,'Murcia'),(12,'Navarra'),(13,'País Vasco'),(14,'La Rioja'),(15,'Aragón');
/*!40000 ALTER TABLE `comunidadesautonomas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especies`
--

DROP TABLE IF EXISTS `especies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especies` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) DEFAULT NULL,
  `Descripcion` text,
  `Tipo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especies`
--

LOCK TABLES `especies` WRITE;
/*!40000 ALTER TABLE `especies` DISABLE KEYS */;
INSERT INTO `especies` VALUES (1,'Lince Ibérico','Mamífero carnívoro','Mamífero'),(2,'Aguila pro','si','siso'),(3,'Lobo Ibérico','Mamífero carnívoro','Mamífero'),(4,'Caballo de Przewalski','Mamífero herbívoro','Mamífero'),(5,'Tartamudo','Ave acuática','Ave'),(6,'Nutria Europea','Mamífero semiacuático','Mamífero'),(7,'Gato Montés','Mamífero carnívoro','Mamífero'),(8,'Ciervo de los Montes Cantábricos','Mamífero herbívoro','Mamífero'),(9,'Buitre Negro','Ave rapaz','Ave'),(10,'Zorro Ibérico','Mamífero carnívoro','Mamífero'),(11,'Lagarto Ocelado','Reptil','Reptil'),(12,'Garza Real','Ave acuática','Ave'),(13,'Jabalí','Mamífero herbívoro','Mamífero'),(14,'Perdiz Nival','Ave de caza','Ave'),(15,'Gato Montés2','Mamífero carnívoro','Mamífero'),(16,'Gato Iberico','Mamífero carnívoro','Mamífero'),(19,'Gato Iberico333','Mamífero carnívoro','Mamífero'),(20,'Gato Iberico333','Mamífero carnívoro','Mamífero'),(21,'Gato Iberico333','Mamífero carnívoro','Mamífero'),(22,'Gato Iberico333','Mamífero carnívoro','Mamífero'),(23,'Gato Iberico333','Mamífero carnívoro','Mamífero'),(24,'Gato Iberico333','Mamífero carnívoro','Mamífero'),(25,'Gato Iberico333','Mamífero carnívoro','Mamífero'),(26,'Gato Iberico333','Mamífero carnívoro','Mamífero'),(27,'Gato Iberico333','Mamífero carnívoro','Mamífero'),(29,'garza comun','Descripción de la especie A','Tipo A'),(30,'especie pro','si','si'),(33,'EspecieDomingo','Es del domingo','Carnivoro'),(34,'EspecieDomingo','Es del domingo','Carnivoro'),(35,'PreubaDomingo3','sis','si'),(36,'PreuabDomingo5','csacsadwadw','gsgsegs'),(37,'PreuabDomingo5','csacsadwadw','gsgsegs'),(38,'DomingoPROOOO','fadwfa','fadawda'),(39,'RatonPequenio','Es un raton pequeo','Mamifero');
/*!40000 ALTER TABLE `especies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organismos`
--

DROP TABLE IF EXISTS `organismos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organismos` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) DEFAULT NULL,
  `Descripcion` text,
  `ComunidadAutonomaID` int DEFAULT NULL,
  `ResponsableID` int DEFAULT NULL,
  `comunidad_autonomaid` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKr5uu868sbh9t686ef9q9xhar2` (`ResponsableID`),
  KEY `caut` (`ComunidadAutonomaID`),
  KEY `FKgtvvu2ke18rxfagunoipdro1x` (`comunidad_autonomaid`),
  CONSTRAINT `caut` FOREIGN KEY (`ComunidadAutonomaID`) REFERENCES `comunidadesautonomas` (`ID`),
  CONSTRAINT `FKgtvvu2ke18rxfagunoipdro1x` FOREIGN KEY (`comunidad_autonomaid`) REFERENCES `comunidadesautonomas` (`ID`),
  CONSTRAINT `FKr5uu868sbh9t686ef9q9xhar2` FOREIGN KEY (`ResponsableID`) REFERENCES `responsables` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organismos`
--

LOCK TABLES `organismos` WRITE;
/*!40000 ALTER TABLE `organismos` DISABLE KEYS */;
INSERT INTO `organismos` VALUES (1,'OAPN Andalucía','Organismo Autónomo Parques Nacionales en Andalucía',1,1,NULL),(2,'OAPN Cantabria','Organismo Autónomo Parques Nacionales en Cantabria',2,2,NULL),(3,'OAPN Castilla-La Mancha','Organismo Autónomo Parques Nacionales en Castilla-La Mancha',3,3,NULL),(4,'OAPN Castilla y León','Organismo Autónomo Parques Nacionales en Castilla y León',4,4,NULL),(5,'OAPN Cataluña','Organismo Autónomo Parques Nacionales en Cataluña',5,5,NULL),(6,'OAPN Comunidad Valenciana','Organismo Autónomo Parques Nacionales en Comunidad Valenciana',6,7,NULL),(7,'OAPN Galicia','Organismo Autónomo Parques Nacionales en Galicia',7,6,NULL),(8,'OAPN Islas Baleares','Organismo Autónomo Parques Nacionales en Islas Baleares',8,9,NULL),(9,'OAPN Islas Canarias','Organismo Autónomo Parques Nacionales en Islas Canarias',9,8,NULL),(10,'OAPN Madrid','Organismo Autónomo Parques Nacionales en Madrid',10,11,NULL),(11,'OAPN Murcia','Organismo Autónomo Parques Nacionales en Murcia',11,13,NULL),(12,'OAPN Navarra','Organismo Autónomo Parques Nacionales en Navarra',12,10,NULL),(13,'OAPN País Vasco','Organismo Autónomo Parques Nacionales en País Vasco',13,14,NULL),(14,'OAPN La Rioja','Organismo Autónomo Parques Nacionales en La Rioja',14,12,NULL),(15,'OAPN Aragón','Organismo Autónomo Parques Nacionales en Aragón',15,NULL,NULL);
/*!40000 ALTER TABLE `organismos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parques_actividades`
--

DROP TABLE IF EXISTS `parques_actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parques_actividades` (
  `ParqueID` int NOT NULL,
  `ActividadID` int NOT NULL,
  PRIMARY KEY (`ParqueID`,`ActividadID`),
  KEY `ActividadID` (`ActividadID`),
  CONSTRAINT `FK_Actividad` FOREIGN KEY (`ActividadID`) REFERENCES `actividades_ocio` (`ID`),
  CONSTRAINT `FK_Parque` FOREIGN KEY (`ParqueID`) REFERENCES `parquesnaturales` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parques_actividades`
--

LOCK TABLES `parques_actividades` WRITE;
/*!40000 ALTER TABLE `parques_actividades` DISABLE KEYS */;
INSERT INTO `parques_actividades` VALUES (1,1),(2,1),(6,1),(11,1),(1,2),(6,2),(11,2),(1,3),(7,3),(12,3),(2,4),(7,4),(12,4),(2,5),(7,5),(12,5),(3,6),(8,6),(3,7),(8,7),(3,8),(8,8),(4,9),(8,9),(9,9),(4,10),(9,10),(4,11),(9,11),(5,12),(10,12),(5,13),(10,13),(5,14),(10,14),(6,15),(11,15),(6,16),(11,16);
/*!40000 ALTER TABLE `parques_actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parques_especies`
--

DROP TABLE IF EXISTS `parques_especies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parques_especies` (
  `ParqueID` int NOT NULL DEFAULT '0',
  `EspecieID` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ParqueID`,`EspecieID`),
  KEY `FKb7lcou748qvvy2tjy1ish3kgl` (`EspecieID`),
  CONSTRAINT `FKb7lcou748qvvy2tjy1ish3kgl` FOREIGN KEY (`EspecieID`) REFERENCES `especies` (`ID`),
  CONSTRAINT `FKmd5w86imuy9io1fuvu9d2lkp1` FOREIGN KEY (`ParqueID`) REFERENCES `parquesnaturales` (`ID`),
  CONSTRAINT `parques_especies_ibfk_1` FOREIGN KEY (`ParqueID`) REFERENCES `parquesnaturales` (`ID`),
  CONSTRAINT `parques_especies_ibfk_2` FOREIGN KEY (`EspecieID`) REFERENCES `especies` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parques_especies`
--

LOCK TABLES `parques_especies` WRITE;
/*!40000 ALTER TABLE `parques_especies` DISABLE KEYS */;
INSERT INTO `parques_especies` VALUES (5,1),(8,1),(16,1),(32,1),(36,1),(39,1),(68,1),(5,2),(11,2),(17,2),(26,2),(32,2),(36,2),(39,2),(51,2),(2,3),(3,3),(6,3),(18,3),(21,3),(2,4),(12,4),(58,4),(59,4),(61,4),(62,4),(13,5),(27,5),(40,5),(43,5),(60,5),(63,5),(68,5),(7,6),(14,6),(23,6),(8,7),(24,7),(40,7),(43,7),(62,7),(3,8),(20,8),(28,8),(62,8),(63,8),(2,9),(9,9),(22,9),(5,10),(25,10),(4,11),(19,11),(9,12),(10,12),(29,12),(15,13),(30,13),(3,15),(8,15),(3,16),(69,39);
/*!40000 ALTER TABLE `parques_especies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parquesnaturales`
--

DROP TABLE IF EXISTS `parquesnaturales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parquesnaturales` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) DEFAULT NULL,
  `comunidad_autonomaid` int DEFAULT NULL,
  `Extension` decimal(10,2) DEFAULT NULL,
  `OrganismoID` int DEFAULT NULL,
  `TipoParqueID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKtd18l571mhiai5opwfui369dj` (`OrganismoID`),
  KEY `FK_TipoParque` (`TipoParqueID`),
  KEY `fk.cou_idx` (`comunidad_autonomaid`),
  CONSTRAINT `fk.cou` FOREIGN KEY (`comunidad_autonomaid`) REFERENCES `comunidadesautonomas` (`ID`),
  CONSTRAINT `FK_TipoParque` FOREIGN KEY (`TipoParqueID`) REFERENCES `tipo_parque` (`ID`),
  CONSTRAINT `FKtd18l571mhiai5opwfui369dj` FOREIGN KEY (`OrganismoID`) REFERENCES `organismos` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parquesnaturales`
--

LOCK TABLES `parquesnaturales` WRITE;
/*!40000 ALTER TABLE `parquesnaturales` DISABLE KEYS */;
INSERT INTO `parquesnaturales` VALUES (1,'Carbon',NULL,NULL,NULL,1),(2,'Parque Nacional del Teide',9,189.90,2,1),(3,'Parque Nacional de los Picos de Europa',4,671.00,3,1),(4,'Parque Nacional de Ordesa y Monte Perdido',14,156.00,4,2),(5,'Parque Nacional de la Sierra de Guadarrama',10,339.00,5,2),(6,'Parque Nacional de Monfragüe',3,183.00,6,3),(7,'Parque Nacional de Cabañeros',3,408.00,7,3),(8,'Parque Nacional de Aigüestortes y Estany de Sant Maurici',5,141.00,8,4),(9,'Parque Nacional de Caldera de Taburiente',9,46.00,9,4),(10,'Parque Nacional de Garajonay',9,39.00,10,4),(11,'Parque Nacional de las Islas Atlánticas de Galicia',7,85.00,11,NULL),(12,'Parque Nacional de Timanfaya',9,51.00,12,NULL),(13,'Parque Nacional de Cazorla, Segura y Las Villas',3,214.00,13,NULL),(14,'Parque Nacional de la Sierra Nevada',1,86.00,14,NULL),(15,'Parque Nacional de Montesinho',15,85.00,15,NULL),(16,'Parque Nacional de Doñana',1,543.00,1,NULL),(17,'Parque Nacional del Teide',9,189.90,2,NULL),(18,'Parque Nacional de los Picos de Europa',4,671.00,3,NULL),(19,'Parque Nacional de Ordesa y Monte Perdido',14,156.00,4,NULL),(20,'Parque Nacional de la Sierra de Guadarrama',10,339.00,5,NULL),(21,'Parque Nacional de Monfragüe',3,183.00,6,NULL),(22,'Parque Nacional de Cabañeros',3,408.00,7,NULL),(23,'Parque Nacional de Aigüestortes y Estany de Sant Maurici',5,141.00,8,NULL),(24,'Parque Nacional de Caldera de Taburiente',9,46.00,9,NULL),(25,'Parque Nacional de Garajonay',9,39.00,10,NULL),(26,'Parque Nacional de las Islas Atlánticas de Galicia',7,85.00,11,NULL),(27,'Parque Nacional de Timanfaya',9,51.00,12,NULL),(28,'Parque Nacional de Cazorla, Segura y Las Villas',3,214.00,13,NULL),(29,'Parque Nacional de la Sierra Nevada',1,86.00,14,NULL),(30,'Parque Nacional de Montesinho',15,85.00,15,NULL),(32,'Parque Nacional2',NULL,1234.56,NULL,NULL),(33,'Parque Natural de la Albufera',NULL,21120.00,NULL,NULL),(34,'Parque Natural de la Albufera',NULL,21120.00,NULL,NULL),(35,'Parque Natural de marjal de oliva',NULL,0.00,NULL,NULL),(36,'Parque Natural Peñagolosa',NULL,21120.00,NULL,NULL),(37,'Parque Natural Calderona',NULL,21120.00,NULL,NULL),(38,'Parque Natural Mont Cabrer',NULL,21120.00,NULL,NULL),(39,'Parque Natural de la marjal de sagunto',NULL,21120.00,1,NULL),(40,'Parque Natural marjal de Pego',NULL,232323.00,2,NULL),(43,'Parque Natural Gredps',4,232323.00,2,NULL),(44,'Parque Natural Las Medulas Romanas',NULL,232323.00,NULL,NULL),(51,'sisora',NULL,3.90,NULL,NULL),(56,'prueba5act',NULL,44.80,NULL,NULL),(58,'NuevoParque',NULL,44.90,NULL,NULL),(59,'Sisa',NULL,33.80,NULL,NULL),(60,'Prueba extrema',NULL,44.60,NULL,NULL),(61,'PruebaRoom',NULL,33.90,NULL,NULL),(62,'PruebaRoom2',NULL,44.90,NULL,NULL),(63,'PruebaDomingo',NULL,44.80,NULL,NULL),(64,'PruebaDomingoSinEspecie',NULL,55.90,NULL,NULL),(68,'NuevoParque',NULL,32342.00,NULL,NULL),(69,'Parque de ratones',NULL,44.00,NULL,NULL);
/*!40000 ALTER TABLE `parquesnaturales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsables`
--

DROP TABLE IF EXISTS `responsables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `responsables` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `DNI` varchar(20) DEFAULT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsables`
--

LOCK TABLES `responsables` WRITE;
/*!40000 ALTER TABLE `responsables` DISABLE KEYS */;
INSERT INTO `responsables` VALUES (1,'12345678X','Juan Pérez','600123456'),(2,'23456789Y','Ana García','600987654'),(3,'34567890Z','Carlos López','601234567'),(4,'45678901A','María Fernández','601987654'),(5,'56789012B','José Martínez','602345678'),(6,'67890123C','Laura Gómez','602987654'),(7,'78901234D','Pedro Sánchez','603456789'),(8,'89012345E','Isabel Hernández','603987654'),(9,'90123456F','Miguel Ramírez','604345678'),(10,'01234567G','Elena Torres','604987654'),(11,'12345678H','Sergio Navarro','605456789'),(12,'23456789I','Carmen Ruiz','605987654'),(13,'34567890J','Antonio Vargas','606345678'),(14,'45678901K','Lucía Jiménez','606987654');
/*!40000 ALTER TABLE `responsables` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_parque`
--

DROP TABLE IF EXISTS `tipo_parque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_parque` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_parque`
--

LOCK TABLES `tipo_parque` WRITE;
/*!40000 ALTER TABLE `tipo_parque` DISABLE KEYS */;
INSERT INTO `tipo_parque` VALUES (1,'Montaña'),(2,'Litoral'),(3,'Laguna'),(4,'Bosque');
/*!40000 ALTER TABLE `tipo_parque` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-13 11:53:36
