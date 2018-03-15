-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: contraderproject
-- ------------------------------------------------------
-- Server version	5.5.15

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
-- Current Database: `contraderproject`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `contraderproject` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `contraderproject`;

--
-- Table structure for table `appuntamento`
--

DROP TABLE IF EXISTS `appuntamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appuntamento` (
  `Id` int(11) NOT NULL,
  `Id_Officina` int(11) NOT NULL,
  `Id_Driver` int(11) NOT NULL,
  `Data` datetime NOT NULL,
  `Stato` bit(1) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_Officina` (`Id_Officina`),
  KEY `Id_Driver` (`Id_Driver`),
  CONSTRAINT `appuntamento_ibfk_1` FOREIGN KEY (`Id_Officina`) REFERENCES `officina` (`Id`),
  CONSTRAINT `appuntamento_ibfk_2` FOREIGN KEY (`Id_Driver`) REFERENCES `driver` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appuntamento`
--

LOCK TABLES `appuntamento` WRITE;
/*!40000 ALTER TABLE `appuntamento` DISABLE KEYS */;
INSERT INTO `appuntamento` VALUES (1,6,9991,'2017-06-15 00:00:00',''),(2,7,28956,'2015-01-01 00:00:00','\0'),(3,10,9991,'2018-03-01 00:00:00','\0');
/*!40000 ALTER TABLE `appuntamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `automobile`
--

DROP TABLE IF EXISTS `automobile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `automobile` (
  `Cod_Dispositivo` int(11) NOT NULL,
  `Targa` varchar(25) NOT NULL,
  `Telaio` int(11) NOT NULL,
  `Casa_Costruttrice` varchar(25) NOT NULL,
  `Modello` varchar(25) NOT NULL,
  `Alimentazione` varchar(25) NOT NULL,
  `Tipologia` varchar(25) NOT NULL,
  `Cambio` char(1) NOT NULL,
  `Driver` int(11) NOT NULL,
  `Proprietario` int(11) NOT NULL,
  `Revisione` date DEFAULT NULL,
  `Tagliando_Data` date DEFAULT NULL,
  `Tagliando_Km` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_Dispositivo`),
  KEY `Proprietario` (`Proprietario`),
  KEY `Driver` (`Driver`),
  CONSTRAINT `automobile_ibfk_1` FOREIGN KEY (`Proprietario`) REFERENCES `azienda` (`Id`),
  CONSTRAINT `automobile_ibfk_2` FOREIGN KEY (`Driver`) REFERENCES `driver` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `automobile`
--

LOCK TABLES `automobile` WRITE;
/*!40000 ALTER TABLE `automobile` DISABLE KEYS */;
INSERT INTO `automobile` VALUES (1,'AS123PC',12,'FORD','FIESTA','DIESEL','UTILITARIA','A',9991,3,'2017-06-15','2017-06-28',32000),(2,'AS123MN',12,'FIAT','PANDA','DIESEL','UTILITARIA','M',28956,3,'2016-06-15','2017-08-28',6000),(3,'AS6543PC',12,'FIAT','PUNTO','DIESEL','COMMERCIALE','A',1258,3,'2012-06-15','2015-06-28',3200);
/*!40000 ALTER TABLE `automobile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `azienda`
--

DROP TABLE IF EXISTS `azienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `azienda` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(25) NOT NULL,
  `Nome_Città` varchar(25) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Nome_Città` (`Nome_Città`),
  CONSTRAINT `azienda_ibfk_1` FOREIGN KEY (`Nome_Città`) REFERENCES `città` (`Nome`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azienda`
--

LOCK TABLES `azienda` WRITE;
/*!40000 ALTER TABLE `azienda` DISABLE KEYS */;
INSERT INTO `azienda` VALUES (1,'Azienda_1','Roma'),(2,'Azienda_2','Roma'),(3,'Azienda_3','Roma'),(4,'Azienda_4','Modena'),(5,'Azienda_5','Benevento'),(6,'Azienda_6','Torino'),(7,'Azienda_7','Benevento'),(8,'Azienda_8','Siracusa'),(9,'Azienda_9','Modena');
/*!40000 ALTER TABLE `azienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `città`
--

DROP TABLE IF EXISTS `città`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `città` (
  `Nome` varchar(25) NOT NULL,
  `Cap` int(11) NOT NULL,
  `Provincia` char(2) NOT NULL,
  `Regione` varchar(15) NOT NULL,
  PRIMARY KEY (`Nome`,`Cap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `città`
--

LOCK TABLES `città` WRITE;
/*!40000 ALTER TABLE `città` DISABLE KEYS */;
INSERT INTO `città` VALUES ('Benevento',82100,'BN','CAMPANIA'),('Modena',41121,'MO','EMILIA ROMAGNA'),('MODENA',41125,'MO','EMILIA ROMAGNA'),('Roma',100,'RM','LAZIO'),('Roma',123,'RM','LAZIO'),('Siracusa',96100,'SR','SICILIA'),('Torino',10121,'TO','PIEMONTE'),('Torino',10124,'TO','PIEMONTE');
/*!40000 ALTER TABLE `città` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dati_dispositivo`
--

DROP TABLE IF EXISTS `dati_dispositivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dati_dispositivo` (
  `Cod_Dispositivo` int(11) NOT NULL,
  `Km` int(11) NOT NULL,
  `Codice_Errore` varchar(25) NOT NULL,
  `Stato` int(11) NOT NULL,
  `Livello_Olio` float DEFAULT NULL,
  PRIMARY KEY (`Cod_Dispositivo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dati_dispositivo`
--

LOCK TABLES `dati_dispositivo` WRITE;
/*!40000 ALTER TABLE `dati_dispositivo` DISABLE KEYS */;
INSERT INTO `dati_dispositivo` VALUES (1,251031,'C992JN',1,1.3),(2,28000,'P001PM',1,1.2),(3,30000,'C003MN',1,2.6);
/*!40000 ALTER TABLE `dati_dispositivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `driver` (
  `Id` int(11) NOT NULL,
  `Nome` varchar(25) NOT NULL,
  `Cognome` varchar(25) NOT NULL,
  `cf` char(16) NOT NULL,
  `Residenza` varchar(25) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES (1258,'Antonio','Rossi','ASDFA230AAFRWE4R','NAPOLI'),(9991,'Pippo','Demagistris','SLONGBLONGSERADM','Torino'),(12589,'Carmine','Albero','RSSDFETEADFTSFDF','Modena'),(28956,'Alessia','Bardo','NGRONDNRONGGUNR','Benevento'),(31415,'Givevra','Luce','GRUNCGRRUNCGRUNC','Roma');
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(25) NOT NULL,
  `Password` varchar(25) NOT NULL,
  `Ruolo` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'OWNER','OWNER',1),(2,'O_001','O_001',2),(3,'O_002','O_002',2),(4,'O_003','O_003',2),(5,'A_001','A_001',3),(6,'A_002','A_002',3),(7,'A_003','A_003',3),(8,'D_001','D_001',4),(9,'D_002','D_002',4),(10,'D_003','D_003',4);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offerta`
--

DROP TABLE IF EXISTS `offerta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offerta` (
  `Id` int(11) NOT NULL,
  `Descrizione` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `offerta_ibfk_1` FOREIGN KEY (`Id`) REFERENCES `officina` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offerta`
--

LOCK TABLES `offerta` WRITE;
/*!40000 ALTER TABLE `offerta` DISABLE KEYS */;
INSERT INTO `offerta` VALUES (6,'CAMBIA OLIO A SOLI 15 EURO'),(7,'CONTROLLO FRENI E TAGLIANDO AD UN COSTO BASSISSIMO!'),(8,'SOSTITUZIONE PASTICCHE AD UM PREZZO DA SVENIRE'),(10,'VIENI A SCOPRIRE I NUOVI PNEUMATICI SUPER RESISTENTI');
/*!40000 ALTER TABLE `offerta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `officina`
--

DROP TABLE IF EXISTS `officina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `officina` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Nome_Officina` varchar(25) NOT NULL,
  `Indirizzo` varchar(100) NOT NULL,
  `Nome_Città` varchar(25) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Nome_Città` (`Nome_Città`),
  CONSTRAINT `officina_ibfk_1` FOREIGN KEY (`Nome_Città`) REFERENCES `città` (`Nome`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `officina`
--

LOCK TABLES `officina` WRITE;
/*!40000 ALTER TABLE `officina` DISABLE KEYS */;
INSERT INTO `officina` VALUES (6,'OFFICINA_1','Via dei principi 715','Roma'),(7,'OFFICINA_2','Via dei Re','Torino'),(8,'OFFICINA_4','Via delle betulle','Roma'),(9,'OFFICINA_5','Via delle orchidee','Modena'),(10,'OFFICINA_6','Via delle Querce','Benevento');
/*!40000 ALTER TABLE `officina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preventivo`
--

DROP TABLE IF EXISTS `preventivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preventivo` (
  `Id` int(11) NOT NULL,
  `Cod_Dispositivo` int(11) NOT NULL,
  `Id_Officina` int(11) NOT NULL,
  `Id_Driver` int(11) NOT NULL,
  `Casa_Costruttrice` varchar(25) NOT NULL,
  `Modello` varchar(25) NOT NULL,
  `Descrizione` varchar(200) DEFAULT NULL,
  `Costo` float DEFAULT NULL,
  `Stato` bit(1) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_Officina` (`Id_Officina`),
  KEY `Id_Driver` (`Id_Driver`),
  CONSTRAINT `preventivo_ibfk_1` FOREIGN KEY (`Id_Officina`) REFERENCES `officina` (`Id`),
  CONSTRAINT `preventivo_ibfk_2` FOREIGN KEY (`Id_Driver`) REFERENCES `driver` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preventivo`
--

LOCK TABLES `preventivo` WRITE;
/*!40000 ALTER TABLE `preventivo` DISABLE KEYS */;
INSERT INTO `preventivo` VALUES (1,1,6,9991,'FIAT','PUNTO','FRENI NON FUNZIONANTI',NULL,NULL),(2,2,7,28956,'FORD','FIESTA','CAMBIO ROTTO',NULL,NULL),(3,2,10,1258,'FIAT','PANDA','SURRISCALDAMENTO ECCESSIVO MOTORE',NULL,NULL),(4,1,6,9991,'FIAT','PUNTO','FRENI NON FUNZIONANTI',200,''),(5,2,7,28956,'FORD','FIESTA','CAMBIO ROTTO',300,'\0');
/*!40000 ALTER TABLE `preventivo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-14 12:00:43



