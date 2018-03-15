-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db
-- ------------------------------------------------------
-- Server version	5.5.54-log

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
-- Table structure for table `appuntamento`
--

DROP TABLE IF EXISTS `appuntamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appuntamento` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IdUtente` int(11) DEFAULT NULL,
  `Data` datetime DEFAULT NULL,
  `IdAzienda` int(11) DEFAULT NULL,
  `Dettagli` varchar(1024) DEFAULT NULL,
  `Stato` int(1) NOT NULL DEFAULT '0' COMMENT '0 = in sospeso\n1 = confermato\n2 = rifiutato',
  `Risposta` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_IdUtente_idx` (`IdUtente`),
  KEY `FK_IdAzienda_idx` (`IdAzienda`),
  CONSTRAINT `FK_IdUtente` FOREIGN KEY (`IdUtente`) REFERENCES `utente` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_IdAzienda` FOREIGN KEY (`IdAzienda`) REFERENCES `azienda` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appuntamento`
--

LOCK TABLES `appuntamento` WRITE;
/*!40000 ALTER TABLE `appuntamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `appuntamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auto`
--

DROP TABLE IF EXISTS `auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auto` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Marca` varchar(128) NOT NULL,
  `Modello` varchar(256) NOT NULL,
  `Targa` varchar(10) NOT NULL,
  `NumeroTelaio` varchar(32) NOT NULL,
  `KmAttuali` int(11) NOT NULL,
  `KmInizioNoleggio` int(11) DEFAULT NULL,
  `ScadenzaRevisione` date DEFAULT NULL,
  `ScadenzaTagliando` date DEFAULT NULL,
  `ScadenzaAssicurazione` date DEFAULT NULL,
  `ScadenzaBollo` date DEFAULT NULL,
  `TipologiaAuto` varchar(64) DEFAULT NULL COMMENT 'Utilitaria, Station Wagon, ecc.',
  `DaNoleggio` int(1) NOT NULL COMMENT '1 = Adibita al Noleggio\n0 = Privata',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto`
--

LOCK TABLES `auto` WRITE;
/*!40000 ALTER TABLE `auto` DISABLE KEYS */;
INSERT INTO `auto` VALUES (1,'Fiat','Panda','AN823PA','83N8gnn89g83',321,3213,'2018-12-03','2018-12-03','2018-12-03','2018-12-03','0',0),(2,'asda','das','adsa','dasda',663,546,'2018-12-03','2018-12-03','2018-12-03','2018-12-03','0',0),(3,'Alfa-Romeo','147','RU834MP','8n8err3rb',899,79414,'2018-12-03','2018-12-03','2018-12-03','2018-12-03','0',1),(4,'Seat','Ibiza','eu384bn','N8ut93t8',839,973,'2018-12-03','2018-12-03','2018-12-03','2018-12-03','0',1);
/*!40000 ALTER TABLE `auto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auto_azienda`
--

DROP TABLE IF EXISTS `auto_azienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auto_azienda` (
  `IdAzienda` int(11) NOT NULL,
  `IdAuto` int(11) NOT NULL,
  PRIMARY KEY (`IdAzienda`,`IdAuto`),
  KEY `Id_Auto_FK_idx` (`IdAuto`),
  CONSTRAINT `Id_Auto_FK` FOREIGN KEY (`IdAuto`) REFERENCES `auto` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Id_Azienda_FK` FOREIGN KEY (`IdAzienda`) REFERENCES `azienda` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto_azienda`
--

LOCK TABLES `auto_azienda` WRITE;
/*!40000 ALTER TABLE `auto_azienda` DISABLE KEYS */;
INSERT INTO `auto_azienda` VALUES (1,3),(1,4);
/*!40000 ALTER TABLE `auto_azienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auto_utente`
--

DROP TABLE IF EXISTS `auto_utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auto_utente` (
  `IdUtente` int(11) NOT NULL,
  `IdAuto` int(11) NOT NULL,
  `MaxKmNoleggio` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdUtente`,`IdAuto`),
  KEY `AutoUtente_IdAuto_fk_idx` (`IdAuto`),
  CONSTRAINT `AutoUtente_IdAuto_fk` FOREIGN KEY (`IdAuto`) REFERENCES `auto` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `AutoUtente_IdUtente_fk` FOREIGN KEY (`IdUtente`) REFERENCES `utente` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto_utente`
--

LOCK TABLES `auto_utente` WRITE;
/*!40000 ALTER TABLE `auto_utente` DISABLE KEYS */;
INSERT INTO `auto_utente` VALUES (1,1,435),(5,2,432);
/*!40000 ALTER TABLE `auto_utente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `azienda`
--

DROP TABLE IF EXISTS `azienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `azienda` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Denominazione` varchar(256) NOT NULL,
  `NomeReferente` varchar(128) DEFAULT NULL,
  `CognomeReferente` varchar(128) DEFAULT NULL,
  `Email` varchar(258) DEFAULT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  `Latitudine` float DEFAULT NULL,
  `Longitudine` float DEFAULT NULL,
  `Tipologia` int(1) NOT NULL COMMENT '0 = Autofficina\n1 = Casa Locataria',
  `DataInserimento` date DEFAULT NULL,
  `Citta` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azienda`
--

LOCK TABLES `azienda` WRITE;
/*!40000 ALTER TABLE `azienda` DISABLE KEYS */;
INSERT INTO `azienda` VALUES (1,'Azienda di Prova','Referente azienda','cognome ref azienda','igoe@email.it','5435345',453535,43535300,0,'2018-02-12','Napoli'),(2,'dasdasd','dasda','adasda','dasdas','213123',312312,32131200,0,'2018-02-12','Napoli'),(3,'dasda','gew','fwe','wfs','3424',5342,524,0,NULL,NULL),(4,'dasda','gew','fwe','wfs','3424',5342,524,0,NULL,NULL),(5,'shas','dasd','gad','fdsgfsg','432423',343423,4324,20,'2018-03-15',NULL),(6,'safsd','FSAHDS','fdsf','fdsgs','5452345',54352,5435,0,'2018-03-15','432'),(7,'Contrader','Saba','tino','sab@tino.it','5321432',312685,4124,0,'2018-03-15','Benevento'),(8,'dysag','dtyasfd','das','dfsahgdva','263713',62351,537142,0,'2018-03-15','sdhagvj');
/*!40000 ALTER TABLE `azienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dati_telemetria`
--

DROP TABLE IF EXISTS `dati_telemetria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dati_telemetria` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Dati` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dati_telemetria`
--

LOCK TABLES `dati_telemetria` WRITE;
/*!40000 ALTER TABLE `dati_telemetria` DISABLE KEYS */;
INSERT INTO `dati_telemetria` VALUES (1,'Dati telemetria auto');
/*!40000 ALTER TABLE `dati_telemetria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dispositivo`
--

DROP TABLE IF EXISTS `dispositivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dispositivo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Codice` varchar(10) DEFAULT NULL,
  `IdAuto` int(11) DEFAULT NULL,
  `DataInstallazione` date DEFAULT NULL,
  `IdAzienda` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `dispositivo_auto_fk_idx` (`IdAuto`),
  KEY `dispositivo_azienda_fk_idx` (`IdAzienda`),
  CONSTRAINT `dispositivo_auto_fk` FOREIGN KEY (`IdAuto`) REFERENCES `auto` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `dispositivo_azienda_fk` FOREIGN KEY (`IdAzienda`) REFERENCES `azienda` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dispositivo`
--

LOCK TABLES `dispositivo` WRITE;
/*!40000 ALTER TABLE `dispositivo` DISABLE KEYS */;
INSERT INTO `dispositivo` VALUES (1,'00001',4,'2018-03-13',1),(2,'00002',3,'2018-03-10',1),(3,'00003',NULL,NULL,1),(4,'00004',NULL,NULL,1),(5,'00005',NULL,NULL,1),(6,'00006',NULL,NULL,1),(7,'00007',NULL,NULL,1),(8,'00008',NULL,NULL,1);
/*!40000 ALTER TABLE `dispositivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guasto`
--

DROP TABLE IF EXISTS `guasto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guasto` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Codice` varchar(10) NOT NULL,
  `IdTelemetria` int(11) DEFAULT NULL,
  `Data` datetime NOT NULL,
  `IdDispositivo` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `guasto_CODICE_FK_idx` (`Codice`),
  KEY `guasto_IDTEL_FK_idx` (`IdTelemetria`),
  KEY `guasto_DISPOS_FK_idx` (`IdDispositivo`),
  CONSTRAINT `guasto_CODICE_FK` FOREIGN KEY (`Codice`) REFERENCES `tipologia_guasto` (`Codice`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `guasto_IDTEL_FK` FOREIGN KEY (`IdTelemetria`) REFERENCES `dati_telemetria` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `guasto_DISPOS_FK` FOREIGN KEY (`IdDispositivo`) REFERENCES `dispositivo` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guasto`
--

LOCK TABLES `guasto` WRITE;
/*!40000 ALTER TABLE `guasto` DISABLE KEYS */;
INSERT INTO `guasto` VALUES (1,'a0001',1,'2018-03-15 00:00:00',1);
/*!40000 ALTER TABLE `guasto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offerta`
--

DROP TABLE IF EXISTS `offerta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offerta` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IdAzienda` int(11) DEFAULT NULL,
  `Scadenza` date DEFAULT NULL,
  `Dettagli` varchar(1024) DEFAULT NULL,
  `Inizio` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `offerta_azienda_fk_idx` (`IdAzienda`),
  CONSTRAINT `offerta_azienda_fk` FOREIGN KEY (`IdAzienda`) REFERENCES `azienda` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offerta`
--

LOCK TABLES `offerta` WRITE;
/*!40000 ALTER TABLE `offerta` DISABLE KEYS */;
/*!40000 ALTER TABLE `offerta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preventivo`
--

DROP TABLE IF EXISTS `preventivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preventivo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IdRichiestaPreventivo` int(11) NOT NULL,
  `Dettagli` varchar(1024) DEFAULT NULL,
  `Costo` float DEFAULT NULL,
  PRIMARY KEY (`ID`,`IdRichiestaPreventivo`),
  KEY `preventivo_richiesta_fk_idx` (`IdRichiestaPreventivo`),
  CONSTRAINT `preventivo_richiesta_fk` FOREIGN KEY (`IdRichiestaPreventivo`) REFERENCES `richiesta_preventivo` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preventivo`
--

LOCK TABLES `preventivo` WRITE;
/*!40000 ALTER TABLE `preventivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `preventivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `richiesta_noleggio`
--

DROP TABLE IF EXISTS `richiesta_noleggio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `richiesta_noleggio` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IdAuto` int(11) NOT NULL,
  `IdUtente` int(11) DEFAULT NULL,
  `LuogoRitiro` varchar(128) DEFAULT NULL,
  `DataRitiro` datetime DEFAULT NULL,
  `LuogoRiconsegna` varchar(128) DEFAULT NULL,
  `DataRiconsegna` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`,`IdAuto`),
  KEY `richiesta_noleggio_auto_fk_idx` (`IdAuto`),
  KEY `richiesta_noleggio_utente_fk_idx` (`IdUtente`),
  CONSTRAINT `richiesta_noleggio_auto_fk` FOREIGN KEY (`IdAuto`) REFERENCES `auto` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `richiesta_noleggio_utente_fk` FOREIGN KEY (`IdUtente`) REFERENCES `utente` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `richiesta_noleggio`
--

LOCK TABLES `richiesta_noleggio` WRITE;
/*!40000 ALTER TABLE `richiesta_noleggio` DISABLE KEYS */;
/*!40000 ALTER TABLE `richiesta_noleggio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `richiesta_preventivo`
--

DROP TABLE IF EXISTS `richiesta_preventivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `richiesta_preventivo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Descrizione` varchar(1024) DEFAULT NULL,
  `IdUtente` int(11) DEFAULT NULL,
  `IdAuto` int(11) DEFAULT NULL,
  `IdAzienda` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `richiesta_preventivo_utente_idx` (`IdUtente`),
  KEY `richiesta_preventivo_auto_idx` (`IdAuto`),
  KEY `richiesta_preventivo_azienda_idx` (`IdAzienda`),
  CONSTRAINT `richiesta_preventivo_utente` FOREIGN KEY (`IdUtente`) REFERENCES `utente` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `richiesta_preventivo_auto` FOREIGN KEY (`IdAuto`) REFERENCES `auto` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `richiesta_preventivo_azienda` FOREIGN KEY (`IdAzienda`) REFERENCES `azienda` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `richiesta_preventivo`
--

LOCK TABLES `richiesta_preventivo` WRITE;
/*!40000 ALTER TABLE `richiesta_preventivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `richiesta_preventivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `riparazione`
--

DROP TABLE IF EXISTS `riparazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `riparazione` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Data` date NOT NULL,
  `Descrizione` varchar(512) DEFAULT NULL,
  `IdAuto` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `riparazione_auto_fk_idx` (`IdAuto`),
  CONSTRAINT `riparazione_auto_fk` FOREIGN KEY (`IdAuto`) REFERENCES `auto` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `riparazione`
--

LOCK TABLES `riparazione` WRITE;
/*!40000 ALTER TABLE `riparazione` DISABLE KEYS */;
/*!40000 ALTER TABLE `riparazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipologia_guasto`
--

DROP TABLE IF EXISTS `tipologia_guasto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipologia_guasto` (
  `Codice` varchar(10) NOT NULL,
  `Descrizione` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`Codice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipologia_guasto`
--

LOCK TABLES `tipologia_guasto` WRITE;
/*!40000 ALTER TABLE `tipologia_guasto` DISABLE KEYS */;
INSERT INTO `tipologia_guasto` VALUES ('a0001','Guasto tipo 1'),('a0002','Guasto tipo 2'),('a0003','macchina da buttare'),('a0004','Grosso problema');
/*!40000 ALTER TABLE `tipologia_guasto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utente` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(128) NOT NULL,
  `Cognome` varchar(128) NOT NULL,
  `Email` varchar(256) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Stato` int(1) DEFAULT '0' COMMENT '0 = Stato Normale\n1 = Bloccato',
  `IdAzienda` int(11) DEFAULT NULL,
  `DataRegistrazione` date NOT NULL,
  `Ruolo` int(1) NOT NULL DEFAULT '0' COMMENT '0 = Non Amministratore\n1 = Amministratore\n',
  `Telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `utente_azienda_fk_idx` (`IdAzienda`),
  CONSTRAINT `utente_azienda_fk` FOREIGN KEY (`IdAzienda`) REFERENCES `azienda` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'dfgh','dasdasd','pippo','paperino',0,1,'2018-03-14',0,'4536728370'),(2,'dgavsjd','dasdasd','dasdasd','dasda',0,NULL,'2018-03-14',0,'4678213'),(3,'dgavsjd','dasdasd','dasdasd','dasda',0,NULL,'2018-03-14',0,'4678213'),(4,'dgavsjd','dasdasd','dasdasd','dasda',0,NULL,'2018-03-14',0,'4678213'),(5,'Lorenzo','Vitale','lv@contrader.it','password',0,1,'2018-02-10',1,'33813419'),(6,'dsa','dasda','dasdas','dasdas',0,1,'2018-02-10',0,'65372183'),(7,'Antonio','Vianello','av@email.it','password',0,1,'2018-03-15',0,'456789213');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-15 17:09:39
