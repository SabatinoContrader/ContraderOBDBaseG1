
DROP DATABASE contraderproject;

CREATE DATABASE contraderproject;

USE contraderproject;

CREATE TABLE appuntamento (
  id_appuntamento int(11) NOT NULL,
  id_officina int(11) NOT NULL,
  id_driver int(11) NOT NULL,
  data varchar(10) NOT NULL,
  stato bit(1) NOT NULL,
  PRIMARY KEY (id_appuntamento),
  FOREIGN KEY (id_officina) REFERENCES officina (id_officina),
  FOREIGN KEY (id_driver) REFERENCES driver (id_driver)
);

INSERT INTO appuntamento VALUES (1,6,9991,'15/05/18', 0),
								(2,7,28956,'13/04/18', 0),
								(3,10,9991,'12/12/17',0);


CREATE TABLE automobile (
  cod_dispositivo int(11) NOT NULL,
  targa varchar(25) NOT NULL,
  telaio int(11) NOT NULL,
  casa_Costruttrice varchar(25) NOT NULL,
  modello varchar(25) NOT NULL,
  alimentazione varchar(25) NOT NULL,
  tipologia varchar(25) NOT NULL,
  cambio char(1) NOT NULL,
  proprietario int(11) NOT NULL,
  revisione varchar(10) NOT NULL,
  tagliando_data varchar(10) NOT NULL,
  tagliando_km int(11) DEFAULT NULL,
  id_driver int(11) default null,
  PRIMARY KEY (cod_dispositivo),
  FOREIGN KEY (proprietario) REFERENCES azienda (id_azienda),
  FOREIGN KEY (id_driver) REFERENCES driver (id_driver)
);

INSERT INTO automobile VALUES	(1,'AS123PC',12,'FORD','FIESTA','DIESEL','UTILITARIA','A',9991,'18/04/17','17/02/18',32000,null),
								(2,'AS123MN',12,'FIAT','PANDA','DIESEL','UTILITARIA','M',28956,'18/04/17','17/02/18',6000,null),
                                (3,'AS6543PC',12,'FIAT','PUNTO','DIESEL','COMMERCIALE','A',1258,'18/04/17','17/02/18',3200,1);

CREATE TABLE azienda (
  id_azienda int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(25) NOT NULL,
  città varchar(25) NOT NULL,
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

CREATE TABLE città (
  nome varchar(25) NOT NULL,
  cap int(11) NOT NULL,
  provincia char(2) NOT NULL,
  regione varchar(15) NOT NULL,
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

CREATE TABLE dati_dispositivo (
  n int(11) auto_increment NOT NULL, 	
  cod_dispositivo int(11) NOT NULL,
  data varchar(10) NOT NULL,
  km int(11) NOT NULL,
  livello_olio float DEFAULT NULL,
  cod_errore varchar(25) NOT NULL default '0',
  stato bit(1) DEFAULT 0,
  PRIMARY KEY (n),
  foreign key (cod_dispositivo) references automobile (cod_dispositivo)
);

INSERT INTO dati_dispositivo VALUES (1, 1,'04/07/18', 13444, 1.1, '0',0),
									(2, 1,'05/07/18', 13445, 1.1, '0',0),
                                    (3, 1,'06/07/18', 13446, 1.1, '0',0),
                                    (4, 1,'07/07/18', 13447, 1.1, '992JN',0);

CREATE TABLE driver (
  id_driver int(11) NOT NULL,
  nome varchar(25) NOT NULL,
  cognome varchar(25) NOT NULL,
  cf char(16) NOT NULL,
  residenza varchar(25) NOT NULL,
  PRIMARY KEY (id_driver)
);

INSERT INTO driver VALUES (1258,'Antonio','Rossi','ASDFA230AAFRWE4R','NAPOLI'),
							(9991,'Pippo','Demagistris','SLONGBLONGSERADM','Torino'),
							(12589,'Carmine','Albero','RSSDFETEADFTSFDF','Modena'),
                            (28956,'Alessia','Bardo','NGRONDNRONGGUNR','Benevento'),
                            (31415,'Givevra','Luce','GRUNCGRRUNCGRUNC','Roma');

CREATE TABLE login (
  username varchar(25) NOT NULL,
  password varchar(25) NOT NULL,
  ruolo int(11) NOT NULL,
  id int(11) NOT NULL,
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

CREATE TABLE offerta (
  id_offerta int(11) NOT NULL,
  id_officina int(11) NOT NULL,
  descrizione varchar(100) DEFAULT NULL,
  PRIMARY KEY (id_offerta),
  FOREIGN KEY (id_offerta) REFERENCES officina (id_officina)
);

INSERT INTO offerta VALUES (6,1,'CAMBIA OLIO A SOLI 15 EURO'),
							(7,2,'CONTROLLO FRENI E TAGLIANDO AD UN COSTO BASSISSIMO!'),
							(8,1,'SOSTITUZIONE PASTICCHE AD UM PREZZO DA SVENIRE'),
                            (10,1,'VIENI A SCOPRIRE I NUOVI PNEUMATICI SUPER RESISTENTI');

CREATE TABLE officina (
  id_officina int(11) NOT NULL AUTO_INCREMENT,
  nome_officina varchar(25) NOT NULL,
  indirizzo varchar(100) NOT NULL,
  città varchar(25) NOT NULL,
  PRIMARY KEY (id_officina)
);

INSERT INTO officina VALUES (6,'OFFICINA_1','Via dei principi 715','Roma'),
							(7,'OFFICINA_2','Via dei Re','Torino'),
                            (8,'OFFICINA_4','Via delle betulle','Roma'),
                            (9,'OFFICINA_5','Via delle orchidee','Modena'),
                            (10,'OFFICINA_6','Via delle Querce','Benevento');

CREATE TABLE preventivo (
  id_preventivo int(11) NOT NULL,
  cod_dispositivo int(11) NOT NULL,
  id_officina int(11) NOT NULL,
  id_driver int(11) NOT NULL,
  casa_Costruttrice varchar(25) NOT NULL,
  modello varchar(25) NOT NULL,
  descrizione varchar(200) DEFAULT NULL,
  costo float DEFAULT NULL,
  stato bit(1) DEFAULT 0,
  PRIMARY KEY (id_preventivo),
  FOREIGN KEY (id_officina) REFERENCES officina (id_officina),
  FOREIGN KEY (cod_dispositivo) REFERENCES automobile (cod_dispositivo)
);

INSERT INTO preventivo VALUES 	(1,1,6,9991,'FIAT','PUNTO','FRENI NON FUNZIONANTI',NULL, 0),
								(2,2,7,28956,'FORD','FIESTA','CAMBIO ROTTO',NULL,0),
								(3,2,10,1258,'FIAT','PANDA','SURRISCALDAMENTO ECCESSIVO MOTORE',NULL,0),
								(4,1,6,9991,'FIAT','PUNTO','FRENI NON FUNZIONANTI',200,1),
								(5,2,7,28956,'FORD','FIESTA','CAMBIO ROTTO',300,1);
