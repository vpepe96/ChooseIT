drop schema if exists ChooseIT;
create schema ChooseIT;
use ChooseIT;

create table utente(
email			varchar(50)		not null,
pwd				varchar(20)		not null,
nome			varchar(30)		not null,
cognome			varchar(30)		not null,
telefono		varchar(10)		not null,
indirizzo		varchar(50)		not null,
data_nascita	date			not null,
foto_profilo	varchar(500),

primary key(email)
);

create table studente(
email			varchar(50)		not null,
matricola		varchar(10)		not null,
descrizione		varchar(500),

primary key(email),
foreign key(email) references utente(email)
);

create table segreteria(
email			varchar(50)		not null,

primary key(email),
foreign key(email) references utente(email)
);

create table presidente(
email		varchar(50)			not null,

primary key(email),
foreign key(email) references utente(email)
);

create table tutor_universitario(
email		varchar(50)			not null,

primary key(email),
foreign key(email) references utente(email)
);

create table azienda(
ragione_sociale		varchar(50)		not null,
progetto_formativo	varchar(300)	not null,
sede_operativa		varchar(50)		not null,
sede_legale			varchar(50)		not null,

primary key(ragione_sociale)
);

create table tutor_aziendale(
email				varchar(50)		not null,
azienda_id			varchar(50)		not null,

primary key(email),
foreign key(email) references utente(email),
foreign key(azienda_id) references azienda(ragione_sociale)
);

create table registro_tirocinio(
identificativo				integer			not null		auto_increment,
studente_email				varchar(50)		not null,
data_inizio					date			not null,
tutor_aziendale_email		varchar(50),
tutor_universitario_email	varchar(50),

primary key(identificativo),
foreign key(studente_email) references studente(email),
foreign key(tutor_aziendale_email) references tutor_aziendale(email),
foreign key(tutor_universitario_email) references tutor_universitario(email)
);

create table stato_tirocinio(
data_stato			date				not null,
tipo				enum('in corso','terminato','annullato')		not null,
registro_id			integer				not null,

primary key(data_stato,tipo,registro_id),
foreign key(registro_id) references registro_tirocinio(identificativo)
);

create table questionario_valutativo_studente(
registro_id			integer							not null,
pdt_1				enum('1','2','3','4','5'),
pdt_2				enum('1','2','3','4','5'),
pdt_3				enum('1','2','3','4','5'),
pdt_4				enum('1','2','3','4','5'),
t_1					enum('1','2','3','4','5'),
t_2					enum('1','2','3','4','5'),
t_3					enum('1','2','3','4','5'),
t_4					enum('1','2','3','4','5'),
su_1				enum('1','2','3','4','5'),
su_2				enum('1','2','3','4','5'),
su_3				enum('1','2','3','4','5'),

primary key(registro_id),
foreign key(registro_id) references registro_tirocinio(identificativo)
);

create table questionario_valutativo_ente_ospitante(
registro_id			integer							not null,
pdt_1				enum('1','2','3','4','5'),
pdt_2				enum('1','2','3','4','5'),
pdt_3				enum('1','2','3','4','5'),
pdt_4				enum('1','2','3','4','5'),
pdt_5				enum('1','2','3','4','5'),
eo_1				enum('1','2','3','4','5'),
eo_2				enum('1','2','3','4','5'),
eo_3				enum('1','2','3','4','5'),
eo_4				enum('1','2','3','4','5'),
eo_5				enum('1','2','3','4','5'),
su_1				enum('1','2','3','4','5'),
su_2				enum('1','2','3','4','5'),
su_3				enum('1','2','3','4','5'),

primary key(registro_id),
foreign key(registro_id) references registro_tirocinio(identificativo)
);

create table report(
registro_id				integer			not null,
data_inserimento		date			not null,
contenuto				varchar(50)		not null,
tutor_aziendale_email	varchar(50),

primary key(registro_id, data_inserimento),
foreign key(registro_id) references registro_tirocinio(identificativo),
foreign key(tutor_aziendale_email) references registro_tirocinio(tutor_aziendale_email)
);

create table stato_report(
data_stato					date										not null,
tipo						enum('compilato','validato','rifiutato')	not null,
report_id_reg				integer										not null,
report_data					date										not null,

primary key(data_stato,tipo,report_id_reg,report_data),
foreign key(report_id_reg,report_data) references report(registro_id,data_inserimento)
);

create table feedback(
email_studente				varchar(50)			not null,
ragione_sociale_azienda		varchar(50)			not null,
descrizione					varchar(200)		not null,

primary key(email_studente,ragione_sociale_azienda),
foreign key(email_studente) references studente(email),
foreign key(ragione_sociale_azienda) references azienda(ragione_sociale)
);

create table richiesta_tirocinio(
id							integer			not null		auto_increment,
studente_email				varchar(50)		not null,
registro_id					integer			not null,
ragione_sociale_azienda		varchar(50)		not null,
progetto_formativo			varchar(300)	not null,
data_richiesta				date			not null,

primary key(id),
foreign key(studente_email) references studente(email),
foreign key(registro_id) references registro_tirocinio(identificativo)
);

create table stato_richiesta(
data_stato			date			not null,
tipo				enum('nuova','in validazione','in convalida','accettata','rifiutata')		not null,
richiesta_id		integer			not null,

primary key(data_stato, tipo, richiesta_id),
foreign key(richiesta_id) references richiesta_tirocinio(id)
);

INSERT INTO `utente` VALUES ('a.bianchi@studenti.unisa.it','bononloso','Andrea','Bianchi','3654351265','via Como 36','1993-03-23','*path da inserire*\r'),('a.demichele@studenti.unisa.it','abcd','Antonio','DeMichele','3425272212','via Milano 23','1993-05-11','*path da inserire*\r'),('a.gatti@studenti.unisa.it','aeiou','Andrea','Gatti','3442365723','via Avellino 7','1997-12-04','*path da inserire*\r'),('a.serra@studenti.unisa.it','1234','Angelo','Serra','3423338921','via Napoleone 33','1995-02-02','*path da inserire*\r'),('aavella@unisa.it','avella','Adolfo','Avella','3209909345','via Fisciano 89','1963-06-23','*path da inserire*\r'),('aderosa.di@unisa.it','segreteriapwd','Anna',' De Rosa','3315426875','via Del Consiglio 81','1963-05-10','*path da inserire*'),('adesantis@unisa.it','andrea','Andrea','De Santis','3645876125','via Fisciano 21','1961-07-11','*path da inserire*\r'),('antoniobianchi@gmail.com','bianchi','Antonio','Bianchi','3442311411','via Foria 9','1968-06-06','*path da inserire*\r'),('b.chiusano@studenti.unisa.it','password','Barbara','Chiusano','6543256456','via Napoli 69','1992-11-11','*path da inserire*\r'),('c.giordano@studenti.unisa.it','efghi','Carlo','Giordano','3674512123','via Meomartini 67','1996-08-22','*path da inserire*\r'),('f.colombo19@studenti.unisa.it','lalala','Felice','Colombo','3684584894','via Rinaldi 81','1996-06-16','*path da inserire*\r'),('f.lombardi@studenti.unisa.it','pass','Federico','Lombardi','3213426456','via San Leonardo 17','1997-04-04','*path da inserire*\r'),('fferrucci@unisa.it','ferrucci','Filomena','Ferrucci','3365124898','via Fisciano 14','1964-03-21','*path da inserire*\r'),('g.capra11@studenti.unisa.it','bobo','Giovanni','Capra','3326974156','via Matera 52','1994-04-14','*path da inserire*\r'),('g.marchetti@studenti.unisa.it','a1b2c3','Gennaro','Marchetti','3678945621','via Nazionale 10','1996-09-10','*path da inserire*\r'),('g.rizzi@studenti.unisa.it','user','Gianluca','Rizzi','3222361111','via Autostrada 1','1998-07-07','*path da inserire*\r'),('luchini@unisa.it','luchini','Paolo','Luchini','3667231453','via Fisciano 7','1964-07-12','*path da inserire*\r'),('m.longo@studenti.unisa.it','abc123','Michele','Longo','3112367890','via Toledo 8','1991-01-04','*path da inserire*\r'),('m.mancini@studenti.unisa.it','unisa','Marco','Mancini','3287345637','via Colombo 34','1992-03-12','*path da inserire*\r'),('m.rossi@studenti.unisa.it','blabla','Mario','Rossi','1358432844','via Roma 51','1990-05-20','*path da inserire*\r'),('mariopellegrini@gmail.com','pelle','Mario','Pellegrini','3293318123','via Americo 3','1969-05-03','*path da inserire*\r'),('mpoletto@unisa.it','massimo','Massimo','Poletto','3789921234','via Fisciano 90','1961-08-04','*path da inserire*\r'),('rgiordano.di@unisa.it','altrasegreteria','Rosa','Giordano','3384516974','via Alto Mare 11','1976-11-03','*path da inserire*\r'),('t.ferrari@studenti.unisa.it','home','Tiziano','Ferrari','3279124567','via Salerno 87','1990-07-15','*path da inserire*\r'),('valeriorossi@gmail.com','vale','Valerio','Rossi','3227712344','via Mecenate 2','1970-04-03','*path da inserire*\r'),('valfieri@unisa.it','alfieri','Vittorio','Alfieri','3108921121','via Fisciano 33','1962-05-22','*path da inserire*\r'),('vnovo@gmail.com','novo','Valentino','Novo','3267855842','via Dei Tribunali 66','1974-08-11','*path da inserire*\r');
INSERT INTO `studente` VALUES ('a.bianchi@studenti.unisa.it','0512104125','Andrea Bianchi, studente presso unisa\r'),('a.demichele@studenti.unisa.it','0512104852','Antonio DeMichele, studente al terzo anno di informatica\r'),('a.gatti@studenti.unisa.it','0512104179','Andrea Gatti\r'),('a.serra@studenti.unisa.it','0512105645','Angelo Serra, studente presso unisa\r'),('b.chiusano@studenti.unisa.it','0512124789','Barbara Chiusano, studentessa di informatica presso l\'Università degli Studi di Salerno\r'),('c.giordano@studenti.unisa.it','0512105233','Carlo Giordano, studente di informatica presso l\'Università degli Studi di Salerno\r'),('f.colombo19@studenti.unisa.it','0512105326','Felice Colombo, studente al terzo anno di informatica presso l\'Università di Salerno\r'),('f.lombardi@studenti.unisa.it','0512104812','Federico Lombardi, studente di informatica\r'),('g.capra11@studenti.unisa.it','0512104257','Giovanni Capra, studente presso unisa\r'),('g.marchetti@studenti.unisa.it','0512105228','Gennaro Marchetti\r'),('g.rizzi@studenti.unisa.it','0512105227','Gianluca Rizzi'),('m.longo@studenti.unisa.it','0512104113','Michele Longo, studente al terzo anno di informatica\r'),('m.mancini@studenti.unisa.it','0512105777','Marco Mancini, studente al terzo anno di informatica\r'),('m.rossi@studenti.unisa.it','0512104856','Mario Rossi, studente presso unisa\r'),('t.ferrari@studenti.unisa.it','0512105147','Tiziano Ferrari, studente di informatica presso unisa\r');
INSERT INTO `segreteria` VALUES ('aderosa.di@unisa.it'),('rgiordano.di@unisa.it');
INSERT INTO `presidente` VALUES ('adesantis@unisa.it'),('fferrucci@unisa.it');
INSERT INTO `tutor_universitario` VALUES ('aavella@unisa.it'),('luchini@unisa.it'),('mpoletto@unisa.it'),('valfieri@unisa.it');
INSERT INTO `azienda` VALUES ('Agic Technology','*path da inserire*','via Emanuele Gianturco 108, Napoli(NA)','via di Castel Giubileo 62, Roma (RM)\r'),('Allinit','*path da inserire*','via del Parco Donica 12, Fisciano (SA)','via del Parco Donica 12, Fisciano (SA)'),('ITD Solutions','*path da inserire*','via Galileo Galilei 7, Milano (MI)','via della Maglianella 65, Roma (RM)\r'),('Sautech','*path da inserire*','via Corso Umberto I 158, SA','via Corso Umberto I 158, Cava de\' Tirreni (SA)\r');
INSERT INTO `tutor_aziendale` VALUES ('valeriorossi@gmail.com','Agic Technology'),('antoniobianchi@gmail.com','Allinit'),('vnovo@gmail.com','ITD Solutions'),('mariopellegrini@gmail.com','Sautech');
INSERT INTO `registro_tirocinio` VALUES (1,'m.rossi@studenti.unisa.it','2012-11-05','valeriorossi@gmail.com','valfieri@unisa.it'),(2,'a.bianchi@studenti.unisa.it','2014-10-10','mariopellegrini@gmail.com','mpoletto@unisa.it'),(3,'f.colombo19@studenti.unisa.it','2017-10-10','vnovo@gmail.com','aavella@unisa.it');
INSERT INTO `stato_tirocinio` VALUES ('2012-11-05','in corso',1),('2013-02-27','terminato',1),('2014-10-10','in corso',2),('2014-11-03','annullato',2),('2017-10-10','in corso',3),('2018-01-10','terminato',3);
INSERT INTO `questionario_valutativo_studente` VALUES (1,'3','5','4','3','5','3','2','4','2','3','4'),(3,'5','4','3','4','3','2','4','5','3','4','4');
INSERT INTO `questionario_valutativo_ente_ospitante` VALUES (1,'4','3','5','2','4','4','5','3','4','2','4','3','4'),(3,'5','3','4','4','3','3','5','3','4','3','4','2','4');
INSERT INTO `report` VALUES (1,'2012-11-10','*path da inserire*','valeriorossi@gmail.com'),(1,'2013-02-06','*path da inserire*','valeriorossi@gmail.com'),(1,'2013-02-21','*path da inserire*','valeriorossi@gmail.com'),(2,'2014-10-07','*path da inserire*','mariopellegrini@gmail.com'),(2,'2014-10-16','*path da inserire*','mariopellegrini@gmail.com'),(2,'2014-11-03','*path da inserire*','mariopellegrini@gmail.com'),(3,'2017-10-12','*path da inserire*','vnovo@gmail.com'),(3,'2017-12-04','*path da inserire*','vnovo@gmail.com'),(3,'2018-01-08','*path da inserire*','vnovo@gmail.com');
INSERT INTO `stato_report` VALUES ('2012-11-10','compilato',1,'2012-11-10'),('2012-11-11','validato',1,'2012-11-10'),('2013-02-06','compilato',1,'2013-02-06'),('2013-02-21','compilato',1,'2013-02-21'),('2013-02-21','validato',1,'2013-02-21'),('2014-10-07','compilato',2,'2014-10-07'),('2014-10-07','validato',2,'2014-10-07'),('2014-10-16','compilato',2,'2014-10-16'),('2014-10-17','validato',2,'2014-10-16'),('2014-11-03','compilato',2,'2014-11-03'),('2014-11-03','validato',2,'2014-11-03'),('2017-10-12','compilato',3,'2017-10-12'),('2017-10-12','validato',3,'2017-10-12'),('2017-12-04','compilato',3,'2017-12-04'),('2017-12-05','validato',3,'2017-12-04'),('2018-01-08','compilato',3,'2018-01-08'),('2018-01-09','validato',3,'2018-01-08');
INSERT INTO `richiesta_tirocinio` VALUES (1,'m.rossi@studenti.unisa.it',1,'Agic Technology','*path da inserire*','2012-11-05'),(2,'a.bianchi@studenti.unisa.it',2,'Sautech','*path da inserire*','2014-10-10'),(3,'f.colombo19@studenti.unisa.it',3,'ITD Solutions','*path da inserire*','2017-10-10');
INSERT INTO `stato_richiesta` VALUES ('2012-11-05','nuova',1),('2012-11-06','in validazione',1),('2012-11-06','in convalida',1),('2012-11-07','accettata',1),('2014-10-10','nuova',2),('2014-10-11','in validazione',2),('2014-10-11','in convalida',2),('2014-10-12','accettata',2),('2017-10-10','nuova',3),('2017-10-10','in validazione',3),('2017-10-11','in convalida',3),('2017-10-11','accettata',3);