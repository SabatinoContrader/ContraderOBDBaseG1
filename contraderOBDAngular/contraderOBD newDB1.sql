DROP DATABASE contraderOBDproject;

CREATE DATABASE contraderOBDproject;

USE contraderOBDproject;

CREATE TABLE azienda (
  id_azienda INT(11) NOT NULL AUTO_INCREMENT,
  nome VARCHAR(25) NOT NULL,
  citta VARCHAR(25) NOT NULL,
  PRIMARY KEY (id_azienda)
);

INSERT INTO azienda VALUES 	(1,'Azienda_1','Roma'),
							(2,'Azienda_2','Roma'),
                            (3,'Azienda_3','Roma'),
                            (4,'Azienda_4','Modena'),
                            (5,'Azienda_5','Benevento'),
                            (6,'Azienda_6','Torino'),
                            (7,'Azienda_7','Benevento'),
                            (8,'Azienda_8','Siracusa'),
                            (9,'Azienda_9','Modena');
                           
CREATE TABLE driver (
  id_driver INT(11) NOT NULL,
  nome VARCHAR(25) NOT NULL,
  cognome VARCHAR(25) NOT NULL,
  cf CHAR(16) NOT NULL,
  email VARCHAR(30),
  cellulare VARCHAR(20),
  residenza VARCHAR(25) NOT NULL,
  id_azienda INT(11),
  PRIMARY KEY (id_driver),
  FOREIGN KEY (id_azienda) REFERENCES azienda (id_azienda)
);

INSERT INTO driver VALUES (1,'Antonio','Rossi', 'ASDFA230AAFRWE4R', 'email@email.it', '3331234567','Napoli', NULL),
							(2,'Pippo','Demagistris','SLONGBLONGSERADM', 'email@email.it', '3331234567','Torino', NULL),
							(3,'Carmine','Albero', 'RSSDFETEADFTSFDF','email@email.it', '3331234567','Modena', NULL),
                            (4,'Alessia','Bardo','NGRONDNRONGGUNR', 'email@email.it', '3331234567','Benevento', NULL),
                            (5,'Ginevra','Luce', 'GRUNCGRRUNCGRUNC','email@email.it', '3331234567','Roma', NULL);
                            
CREATE TABLE login (
  username VARCHAR(25) NOT NULL,
  password VARCHAR(25) NOT NULL,
  ruolo INT(11) NOT NULL,
  id INT(11) NOT NULL,
  PRIMARY KEY (username)
);

INSERT INTO login VALUES ('OWNER','OWNER',1,0),
						 ('O_01','O_01',2,1),
						 ('O_02','O_02',2,2),
                         ('O_03','O_03',2,3),
                         ('A_01','A_01',3,1),
                         ('A_02','A_02',3,2),
                         ('A_03','A_03',3,3),
                         ('D_01','D_01',4,1),
                         ('D_02','D_02',4,2),
                         ('D_03','D_03',4,3);

CREATE TABLE officina (
  id_officina INT(11) NOT NULL AUTO_INCREMENT,
  nome_officina VARCHAR(25) NOT NULL,
  indirizzo VARCHAR(100) NOT NULL,
  citta VARCHAR(25) NOT NULL,
  PRIMARY KEY (id_officina)
);

INSERT INTO officina VALUES (1,'OFFICINA_1','Via dei principi 715','Roma'),
							(2,'OFFICINA_2','Via dei Re','Torino'),
                            (3,'OFFICINA_4','Via delle betulle','Roma'),
                            (4,'OFFICINA_5','Via delle orchidee','Modena'),
                            (5,'OFFICINA_6','Via delle Querce','Benevento');
                            
CREATE TABLE automobile (
  cod_dispositivo INT(11) NOT NULL,
  targa VARCHAR(25) NOT NULL,
  telaio INT(11) NOT NULL,
  casa_costruttrice VARCHAR(25) NOT NULL,
  modello VARCHAR(25) NOT NULL,
  alimentazione VARCHAR(25) NOT NULL,
  tipologia VARCHAR(25) NOT NULL,
  cambio CHAR(1) NOT NULL,
  proprietario VARCHAR(10) NOT NULL,
  revisione VARCHAR(10) NOT NULL,
  tagliando_data VARCHAR(10) NOT NULL,
  tagliando_km INT(11) DEFAULT NULL,
  id_driver INT(11),
  id_officina INT(11) NOT NULL,
  noleggiabile bit,
  PRIMARY KEY (cod_dispositivo),
  FOREIGN KEY (id_driver) REFERENCES driver (id_driver),
  FOREIGN KEY (id_officina) REFERENCES officina (id_officina)
);

INSERT INTO automobile VALUES	(1,'AS123PC',3421343,'FORD','FIESTA','DIESEL','UTILITARIA','A','a_01','18/04/17','17/02/18',32000,NULL,1,0),
								(2,'AS123MN',342135452,'FIAT','PANDA','DIESEL','UTILITARIA','M','a_01','18/04/17','17/02/18',6000,NULL,1,0),
                                (3,'AS654PC',125642,'FIAT','PUNTO','DIESEL','COMMERCIALE','M','a_02','10/04/16','17/02/18',3200,1,1,1),
                                (4,'FG050588',213465321,'FERRARI','F430','DIESEL','COMMERCIALE','A','a_03','18/04/17','17/02/18',3200,1,1,1),
                                (5,'FE643DE',8346743,'NISSAN','QASHQAI','DIESEL','SUV','M','a_02','02/10/17','12/12/17',3200,1,1,1),
                                (6,'AA832DB',685436081,'VOLKSWAGEN','POLO','BENZINA','UTILITARIA','M','a_02','02/02/18','17/03/18',3200,1,1,1);
                                
CREATE TABLE dati_dispositivo (
  n INT(11) AUTO_INCREMENT NOT NULL,
  cod_dispositivo INT(11) NOT NULL,
  data VARCHAR(10) NOT NULL,
  km INT(11) NOT NULL,
  livello_olio FLOAT DEFAULT NULL,
  cod_errore VARCHAR(25),
  stato BIT(1),
  PRIMARY KEY (n),
  FOREIGN KEY (cod_dispositivo) REFERENCES automobile (cod_dispositivo)
);

INSERT INTO dati_dispositivo VALUES (1, 1, '04/07/18', 13444, 1.1, NULL, 0),
									(2, 1, '05/07/18', 13445, 1.1, NULL, 0),
                                    (3, 1, '06/07/18', 13446, 1.1, NULL, 0),
                                    (4, 1, '07/07/18', 13447, 1.1, '992JN', 0),
                                    (5, 3, '19/03/18', 10000, 1.1, NULL, 0),
                                    (6, 4, '19/03/18', 10000, 1.1, NULL, 0),
                                    (7, 5, '19/03/18', 10000, 1.1, 'P6788', 0),
                                    (8, 6, '19/03/18', 18000, 1.1, NULL, 0);
                                    
CREATE TABLE città (
  nome VARCHAR(25) NOT NULL,
  cap INT(11) NOT NULL,
  provincia CHAR(2) NOT NULL,
  regione VARCHAR(15) NOT NULL,
  PRIMARY KEY (nome, cap)
);

INSERT INTO città VALUES ('Benevento',82100,'BN','CAMPANIA'),
						('Modena',41121,'MO','EMILIA ROMAGNA'),
						('MODENA',41125,'MO','EMILIA ROMAGNA'),
                        ('Roma',100,'RM','LAZIO'),
                        ('Roma',123,'RM','LAZIO'),
                        ('Siracusa',96100,'SR','SICILIA'),
                        ('Torino',10121,'TO','PIEMONTE'),
                        ('Torino',10124,'TO','PIEMONTE');
                        
CREATE TABLE appuntamento (
  id_appuntamento INT(11) AUTO_INCREMENT NOT NULL,
  cod_dispositivo INT(11) NOT NULL,
  id_officina INT(11) NOT NULL,
  id_driver INT(11) NOT NULL,
  descrizione VARCHAR(200) DEFAULT NULL,
  data VARCHAR(16) NOT NULL,
  stato BIT(1) DEFAULT NULL,
  PRIMARY KEY (id_appuntamento),
  FOREIGN KEY (cod_dispositivo) REFERENCES automobile (cod_dispositivo),
  FOREIGN KEY (id_officina) REFERENCES officina (id_officina),
  FOREIGN KEY (id_driver) REFERENCES driver (id_driver)
);

INSERT INTO appuntamento VALUES (1,1,1,1,'Errore P77ST','15/05/18', NULL),
								(2,1,1,2,'Tagliando','13/04/18', NULL),
								(3,2,1,2,'Revisione','12/12/17', NULL);
                                
CREATE TABLE preventivo (
  id_preventivo INT(11) AUTO_INCREMENT NOT NULL,
  cod_dispositivo INT(11) NOT NULL,
  id_officina INT(11) NOT NULL,
  id_driver INT(11) NOT NULL,
  descrizione VARCHAR(200) DEFAULT NULL,
  costo FLOAT DEFAULT NULL,
  stato BIT(1) DEFAULT NULL,
  PRIMARY KEY (id_preventivo),
  FOREIGN KEY (cod_dispositivo) REFERENCES automobile (cod_dispositivo),
  FOREIGN KEY (id_officina) REFERENCES officina (id_officina),
  FOREIGN KEY (id_driver) REFERENCES driver (id_driver)
);

INSERT INTO preventivo VALUES 	(1,1,1,1,'FRENI NON FUNZIONANTI', NULL, NULL),
								(2,2,2,2,'CAMBIO ROTTO', NULL, NULL),
								(3,2,3,2,'SURRISCALDAMENTO ECCESSIVO MOTORE', NULL, NULL),
								(4,1,2,2,'FRENI NON FUNZIONANTI', NULL, NULL),
								(5,2,2,2,'CAMBIO ROTTO',300,1);
                                
CREATE TABLE offerta (
  id_offerta INT(11) AUTO_INCREMENT NOT NULL,
  id_officina INT(11) NOT NULL,
  descrizione VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (id_offerta),
  FOREIGN KEY (id_officina) REFERENCES officina (id_officina)
);

INSERT INTO offerta VALUES (1,1,'CAMBIA OLIO A SOLI 15 EURO'),
							(2,2,'CONTROLLO FRENI E TAGLIANDO AD UN COSTO BASSISSIMO!'),
							(3,1,'SOSTITUZIONE PASTICCHE AD UN PREZZO DA SVENIRE'),
                            (4,1,'VIENI A SCOPRIRE I NUOVI PNEUMATICI SUPER RESISTENTI');                                
								
CREATE TABLE noleggio (
  id_noleggio INT(11) AUTO_INCREMENT NOT NULL,
  cod_dispositivo INT(11),
  id_driver INT(11) ,
  inizio_noleggio VARCHAR(25) DEFAULT NULL,
  fine_noleggio VARCHAR(25) DEFAULT NULL,
  PRIMARY KEY (id_noleggio),
  FOREIGN KEY (cod_dispositivo) REFERENCES automobile (cod_dispositivo),
  FOREIGN KEY (id_driver) REFERENCES driver(id_driver)

);