drop schema if exists ChooseIT;
create schema ChooseIT;
use ChooseIT;

create table utente(
email			varchar(50)		not null,
pwd				varchar(200)	not null,
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
ragione_sociale_azienda		varchar(50)		not null,
progetto_formativo			varchar(300)	not null,
data_richiesta				date			not null,
tutor_aziendale_email		varchar(50),
tutor_universitario_email	varchar(50),

primary key(id),
foreign key(studente_email) references studente(email),
foreign key(ragione_sociale_azienda) references azienda(ragione_sociale),
foreign key(tutor_aziendale_email) references tutor_aziendale(email),
foreign key(tutor_universitario_email) references tutor_universitario(email)
);

create table stato_richiesta(
data_stato			date			not null,
tipo				enum('nuova','invalidazione','inconvalida','accettata','rifiutata')		not null,
richiesta_id		integer			not null,

primary key(data_stato, tipo, richiesta_id),
foreign key(richiesta_id) references richiesta_tirocinio(id)
);

create table registro_tirocinio(
identificativo				integer			not null		auto_increment,
studente_email				varchar(50)		not null,
data_inizio					date			not null,
tutor_aziendale_email		varchar(50),
tutor_universitario_email	varchar(50),
richiesta_id				integer			not null,

primary key(identificativo),
foreign key(studente_email) references studente(email),
foreign key(richiesta_id) references richiesta_tirocinio(id), 
foreign key(tutor_aziendale_email) references tutor_aziendale(email),
foreign key(tutor_universitario_email) references tutor_universitario(email)
);

create table stato_tirocinio(
data_stato			date				not null,
tipo				enum('incorso','terminato','annullato')		not null,
registro_id			integer				not null,

primary key(data_stato,tipo,registro_id),
foreign key(registro_id) references registro_tirocinio(identificativo)
);


create table questionario_valutativo_studente(
registro_id			integer							not null,
pdt_1				integer,
pdt_2				integer,
pdt_3				integer,
pdt_4				integer,
t_1					integer,
t_2					integer,
t_3					integer,
t_4					integer,
su_1				integer,
su_2				integer,
su_3				integer,

primary key(registro_id),
foreign key(registro_id) references registro_tirocinio(identificativo)
);

create table questionario_valutativo_ente_ospitante(
registro_id			integer							not null,
pdt_1				integer,
pdt_2				integer,
pdt_3				integer,
pdt_4				integer,
pdt_5				integer,
eo_1				integer,
eo_2				integer,
eo_3				integer,
eo_4				integer,
eo_5				integer,
su_1				integer,
su_2				integer,
su_3				integer,

primary key(registro_id),
foreign key(registro_id) references registro_tirocinio(identificativo)
);

create table report(
registro_id				integer			not null,
data_inserimento		date			not null,
contenuto				varchar(500)		not null,
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

INSERT INTO `utente` VALUES ('a.bianchi@studenti.unisa.it','1000:fef35ff36a2e9e82a5771ae91dd87c81:9363e2c740ced58f7225b3ec67b080602bd43f8220d58a201e468a0d4974b6ef757bea14333b6dcb89bb004a2b10ba524e7ca26bed8bc1c6a06f0a886ac2e81e','Andrea','Bianchi','3654351265','via Como 36','1993-03-23',''),
								('a.demichele@studenti.unisa.it','1000:bd4815ec87b1bfeba4a38a9a3491f71c:68b26492fe4c0cb028c18f6a46e17d105c7e7744460ee40b8bfc38b4c38e060dd51452bb669c22e0338af3417a832f5cca506274a4a4b5480b495b3fde80b184','Antonio','DeMichele','3425272212','via Milano 23','1993-05-11',''),
                                ('a.gatti@studenti.unisa.it','1000:f676d2cef44e53c3b80438b646b10fb2:9eeacf40700f93a4082a48eb3f42dd1f85f3d5cae1087c02b41a10f7e7ee4cd37c9fbb7368f81c2696b0f1798640d46a2e8e6948d1cc49408bae0f770772db26','Andrea','Gatti','3442365723','via Avellino 7','1997-12-04',''),
                                ('a.serra@studenti.unisa.it','1000:845f4bd7897202ec73059e3ad984ed20:a54c748e3ac87abaee179326201a90950d89e43b72107d1cf76151e5b882170bef6993ece7ebe35229393e3ada1c737d374149c228f2f6cdb95f8b33adcde326','Angelo','Serra','3423338921','via Napoleone 33','1995-02-02',''),
                                ('aavella@unisa.it','1000:5513db160460333ccdc4e7a61cd35111:ac1f723ce8b1f2ba27d096e7ed9f054d84de7fceb8cb26f171ac72c5e8a2e11b668c9e0cd30446075e0084c917a661a997655962ffc6280975eb78f24ed9ed7c','Adolfo','Avella','3209909345','via Fisciano 89','1963-06-23',''),
                                ('aderosa.di@unisa.it','1000:70ce7d6575af74b5419b11f7b3a6a2f4:9834511fcc295a93dfc9a94a010b624b47c5244d13686c619a56a86abc0de32534afc79968e99581e867e296e52252cf504c664d57f773fd681c7f28ba19390f','Anna',' De Rosa','3315426875','via Del Consiglio 81','1963-05-10',''),
                                ('adesantis@unisa.it','1000:5a15ff8dfe97259adaa07f249bbfe35d:a42dff159c27598d84b806c94a79281aeb30c768c79f32e624a5618aaa4313f8d231de53a568064fb318334267b638f1dd2b6c4b928602b7d1687b94e03e54d0','Andrea','De Santis','3645876125','via Fisciano 21','1961-07-11',''),
                                ('antoniobianchi@gmail.com','1000:47294151a932edae0434106e27d4f98c:dfacc3cb4658148e01b27ccdf777edfcf4b12dd338074856509dda1302f7af75a3fcd936c29e9aa560b48380cb69f421ee8cca30a1ecf9dff4ed5947bfd7a386','Antonio','Bianchi','3442311411','via Foria 9','1968-06-06',''),
                                ('b.chiusano@studenti.unisa.it','1000:2a74c3e2357bd031c1f260e2f5f00a39:0074bc0bd85dc972f41b51ebee9f8736ae0dafcb5866a525d32bd174349c8fef2fda8c860358cc81d9954e6422ec915ad46c86d3f366403bf1c4f7875eda962c','Barbara','Chiusano','6543256456','via Napoli 69','1992-11-11',''),
                                ('c.giordano@studenti.unisa.it','1000:980de02fd126c71610b44fbc99e4c9a5:521c5e156d355441681ec6780614de08b90d6e484b4868a1fb7b932c1709bdaeb840adb7d6953a42ce1d4109e93b74dfd414c84ae69e935d3b065a5d8a1367a7','Carlo','Giordano','3674512123','via Meomartini 67','1996-08-22',''),
                                ('f.colombo19@studenti.unisa.it','1000:49ec42de6e1808dd21b7f72f521de0ac:855ad812e09b2a4dfcece86ab29ab1ac84e83009406e4b329e41a2550a4e315d8b1d3f76881301eec39ad6e55681f2fdf72b7be90ac2f7f722d1eb823c97cbfb','Felice','Colombo','3684584894','via Rinaldi 81','1996-06-16',''),
                                ('f.lombardi@studenti.unisa.it','1000:d8edc83bd0fcc9978ca098caf3adf09c:32631e98c61e08d4c483ef23da2a5e8467a134077d6c2490e0baa9b5061100d7786447c0a5ae6058b405ad1167ed8f5214e04d44969ecb6e2c833a1646de6909','Federico','Lombardi','3213426456','via San Leonardo 17','1997-04-04',''),
                                ('fferrucci@unisa.it','1000:51b6b3fb4cea2903df92d6cc1abf9e66:240d5aa8d18e27eaa35a9bf4bf508dc194cd10bd4107032d2277375722614390b9252de49143644e8417da0ba9846713ae47ed86a83e3e469cf91ec141ee3aef','Filomena','Ferrucci','3365124898','via Fisciano 14','1964-03-21',''),
                                ('g.capra11@studenti.unisa.it','1000:e0fec0bbfa750195d1e2c7493f16ca4e:33e3df1107e99993eee146178af40e71e681dcb3ed0d699e4d2b1c5d18f1c56009a78264d7803c1778b2b0a89bf8866a3b905a7650d97829684ebdad11d29895','Giovanni','Capra','3326974156','via Matera 52','1994-04-14',''),
                                ('g.marchetti@studenti.unisa.it','1000:b5a5e42ad80fce56a37ec8de2156ed99:1738f2e86ed30170dbdfa2517ef4c878b5003c212622f20c46d4ee59cb4ce8b715af8ad836b3afe76766ea4f1bad6449d59eda593f289ce428d044ad0e479267','Gennaro','Marchetti','3678945621','via Nazionale 10','1996-09-10',''),
                                ('g.rizzi@studenti.unisa.it','1000:05e166b09e04c8dc2544fd2c55d6638d:09056335c1f57f3fd864fd6399c863b4a4f4994ecb82f346838c26108e41f06712464525e4389f4c6caea7b915f3b307be3138df566d4931695eff57f15b72e0','Gianluca','Rizzi','3222361111','via Autostrada 1','1998-07-07',''),
                                ('luchini@unisa.it','1000:eb3ddbf6d8d8a9e5db2523d716d0988b:80239ff067732a63edf16f2b81b3aa90dff81fe0af79179002d99ad5b1ac193f50588bdc072331a305e942c6e8e32866bc731bbcba9bdb97bbe2ba17f7bf3eae','Paolo','Luchini','3667231453','via Fisciano 7','1964-07-12',''),
                                ('m.longo@studenti.unisa.it','1000:e39f4184b6f74d64470491c3f1cf4a3b:32b4936a59f8898bb2d94f3bedc93abc620dfd8572404364a4696962d000fbbb43c161f7111f8815117b78fb3dc9c425a69aa9648054c0035ce30e65ef8fc7fb','Michele','Longo','3112367890','via Toledo 8','1991-01-04',''),
                                ('m.mancini@studenti.unisa.it','1000:febed183c7353d26a2b0540ee5b7b46c:254cb6a3837179475aaacef3e65f5162aa3cf12aa76d36c3b7a20e39ff6bc0bff9d5ac301c89c8ea2106eb9743d58cd70784f45afc58b4be52b7242760a8e086','Marco','Mancini','3287345637','via Colombo 34','1992-03-12',''),
                                ('m.rossi@studenti.unisa.it','1000:36ae602c893bf826b6348d737f78c5a5:67530346ca304ea3d279bfbb2d5f5d5426cc84948d117854756d3082b79678ad6e5487849858914046a4a7abc82b5ef5d9fba613c35d82b2b9b8e654155c677d','Mario','Rossi','1358432844','via Roma 51','1990-05-20',''),
                                ('mariopellegrini@gmail.com','1000:24a43b4b948081f8689527b3c391e6ce:9b059ba49319b7288b1b96119769d95edc9a39f63f02679100f77afead1e464aba07623cd6d292aaf7d89ff9fa7987bc3b50b6c0e8ea19079c4d932de45aec6a','Mario','Pellegrini','3293318123','via Americo 3','1969-05-03',''),
                                ('mpoletto@unisa.it','1000:b1d9b9710784dc21b4239565a5511700:5a2f360365777402add8f4f20b9fb3d1d3865b7491a7f0700e1e00b4647f8af015ec6d28cd67185ae9916bb9977f5e9e9af83b2a05254481205bdf5016e3388f','Massimo','Poletto','3789921234','via Fisciano 90','1961-08-04',''),
                                ('rgiordano.di@unisa.it','1000:dbbeb28920c58ddf2265d7d97e6ab496:84f27790a9f190da9fd6856fd99e4cfb88a897cd007dc2d89c00607adfebe0c68611ed00d4450a7c28ddfb29ae77b7e25ff0f90429eac644b52e5df7260af706','Rosa','Giordano','3384516974','via Alto Mare 11','1976-11-03',''),
                                ('t.ferrari@studenti.unisa.it','1000:475ef6e93184d8254b69198c4def6a10:c3358aed3a1bcecfd8be7b017019995e064a49bb4553a4b32a285875bab2bcef2a0db42e62cf923ed7ba5d8a4e1a060687d6beff39b93b6e7eb3f557ba7e400c','Tiziano','Ferrari','3279124567','via Salerno 87','1990-07-15',''),
                                ('valeriorossi@gmail.com','1000:0a007cd4e971ff429478a2fa33cd5563:3a3d2e019dc9713e052d86130d489c4e5159329e46748b5a09871d3300289c215db66013811f70039a2a69895e9c5647d722119e2905e2d0d00e5ba7392d9885','Valerio','Rossi','3227712344','via Mecenate 2','1970-04-03',''),
                                ('valfieri@unisa.it','1000:7cef1ae662e5f57132fdfd6381782849:9834ea91734cb36a2e414a3538b15fe6764949ccc05187ae113c2369734aad6760bc6406ade35a3f631ed831c15d59692259a1c44d9cfb88613e55a95eb2d5f1','Vittorio','Alfieri','3108921121','via Fisciano 33','1962-05-22',''),
                                ('vnovo@gmail.com','1000:311535042209398ac9b1e581f0751d78:8bd37f48facd1f038d148dc18ca417546877925ad13a75a4a1d670786840471c2de449767d8064e7b721190ad70322f5e359dc4cde991c1247a50a49166e3184','Valentino','Novo','3267855842','via Dei Tribunali 66','1974-08-11','');

INSERT INTO `studente` VALUES ('a.bianchi@studenti.unisa.it','0512104125','Andrea Bianchi, studente presso unisa\r'),
								('a.demichele@studenti.unisa.it','0512104852','Antonio DeMichele, studente al terzo anno di informatica\r'),
                                ('a.gatti@studenti.unisa.it','0512104179','Andrea Gatti\r'),
                                ('a.serra@studenti.unisa.it','0512105645','Angelo Serra, studente presso unisa\r'),
                                ('b.chiusano@studenti.unisa.it','0512124789','Barbara Chiusano, studentessa di informatica presso l\'Università degli Studi di Salerno\r'),
                                ('c.giordano@studenti.unisa.it','0512105233','Carlo Giordano, studente di informatica presso l\'Università degli Studi di Salerno\r'),
                                ('f.colombo19@studenti.unisa.it','0512105326','Felice Colombo, studente al terzo anno di informatica presso l\'Università di Salerno\r'),
                                ('f.lombardi@studenti.unisa.it','0512104812','Federico Lombardi, studente di informatica\r'),
                                ('g.capra11@studenti.unisa.it','0512104257','Giovanni Capra, studente presso unisa\r'),
                                ('g.marchetti@studenti.unisa.it','0512105228','Gennaro Marchetti\r'),
                                ('g.rizzi@studenti.unisa.it','0512105227','Gianluca Rizzi'),
                                ('m.longo@studenti.unisa.it','0512104113','Michele Longo, studente al terzo anno di informatica\r'),
                                ('m.mancini@studenti.unisa.it','0512105777','Marco Mancini, studente al terzo anno di informatica\r'),
                                ('m.rossi@studenti.unisa.it','0512104856','Mario Rossi, studente presso unisa\r'),
                                ('t.ferrari@studenti.unisa.it','0512105147','Tiziano Ferrari, studente di informatica presso unisa\r');

INSERT INTO `segreteria` VALUES ('aderosa.di@unisa.it'),
								('rgiordano.di@unisa.it');

INSERT INTO `presidente` VALUES ('adesantis@unisa.it'),
								('fferrucci@unisa.it');

INSERT INTO `tutor_universitario` VALUES ('aavella@unisa.it'),
											('luchini@unisa.it'),
											('mpoletto@unisa.it'),
                                            ('valfieri@unisa.it');

INSERT INTO `azienda` VALUES ('Agic Technology','','via Emanuele Gianturco 108, Napoli(NA)','via di Castel Giubileo 62, Roma (RM)\r'),
								('Allinit','','via del Parco Donica 12, Fisciano (SA)','via del Parco Donica 12, Fisciano (SA)'),
                                ('ITD Solutions','','via Galileo Galilei 7, Milano (MI)','via della Maglianella 65, Roma (RM)\r'),
                                ('Sautech','','via Corso Umberto I 158, SA','via Corso Umberto I 158, Cava de\' Tirreni (SA)\r');

INSERT INTO `tutor_aziendale` VALUES ('valeriorossi@gmail.com','Agic Technology'),
										('antoniobianchi@gmail.com','Allinit'),
										('vnovo@gmail.com','ITD Solutions'),
                                        ('mariopellegrini@gmail.com','Sautech');

INSERT INTO `richiesta_tirocinio` VALUES (1,'m.rossi@studenti.unisa.it','Agic Technology','','2012-11-05','valeriorossi@gmail.com','valfieri@unisa.it'),
											(2,'a.bianchi@studenti.unisa.it','Sautech','','2014-10-10','mariopellegrini@gmail.com','mpoletto@unisa.it'),
                                            (3,'f.colombo19@studenti.unisa.it','ITD Solutions','','2017-10-10','vnovo@gmail.com','aavella@unisa.it'),
                                            (4,'a.demichele@studenti.unisa.it','ITD Solutions','','2018-11-10','vnovo@gmail.com','luchini@unisa.it'),
                                             (5,'m.longo@studenti.unisa.it','ITD Solutions','','2018-11-25','vnovo@gmail.com','luchini@unisa.it');

INSERT INTO `stato_richiesta` VALUES ('2012-11-05','nuova',1),
										('2012-11-06','invalidazione',1),
                                        ('2012-11-06','inconvalida',1),
                                        ('2012-11-07','accettata',1),
                                        ('2014-10-10','nuova',2),
                                        ('2014-10-11','invalidazione',2),
                                        ('2014-10-11','inconvalida',2),
                                        ('2014-10-12','accettata',2),
                                        ('2017-10-10','nuova',3),
                                        ('2017-10-10','invalidazione',3),
                                        ('2017-10-11','inconvalida',3),
                                        ('2017-10-11','accettata',3),
                                        ('2018-11-10','nuova',4),
                                        ('2018-11-10','invalidazione',4),
                                        ('2018-11-11','inconvalida',4),
                                        ('2018-11-11','accettata',4),
                                        ('2018-11-25','nuova',5),
                                        ('2018-11-25','invalidazione',5),
                                        ('2018-11-25','inconvalida',5),
                                        ('2018-11-25','accettata',5);
                                        
INSERT INTO `registro_tirocinio` VALUES (1,'m.rossi@studenti.unisa.it','2012-11-05','valeriorossi@gmail.com','valfieri@unisa.it',1),
										(2,'a.bianchi@studenti.unisa.it','2014-10-10','mariopellegrini@gmail.com','mpoletto@unisa.it',2),
                                        (3,'f.colombo19@studenti.unisa.it','2017-10-10','vnovo@gmail.com','aavella@unisa.it',3),
                                        (4,'a.demichele@studenti.unisa.it','2018-11-10','vnovo@gmail.com','luchini@unisa.it',4),
                                        (5,'m.longo@studenti.unisa.it','2018-11-25','vnovo@gmail.com','luchini@unisa.it',5);
                                        
INSERT INTO `stato_tirocinio` VALUES ('2012-11-05','incorso',1),
										('2013-02-27','terminato',1),
                                        ('2014-10-10','incorso',2),
                                        ('2014-11-03','annullato',2),
                                        ('2017-10-10','incorso',3),
                                        ('2018-01-10','terminato',3),
                                        ('2018-11-10','incorso',4),
                                        ('2018-11-25','incorso',5);

INSERT INTO `questionario_valutativo_studente` VALUES (1,3,5,4,3,5,3,2,4,2,3,4),
														(2,null,null,null,null,null,null,null,null,null,null,null),
                                                        (3,5,4,3,4,3,2,4,5,3,4,4),
                                                        (4,null,null,null,null,null,null,null,null,null,null,null),
                                                        (5,null,null,null,null,null,null,null,null,null,null,null);

INSERT INTO `questionario_valutativo_ente_ospitante` VALUES (1,4,3,5,2,4,4,5,3,4,2,4,3,4),
																(2,null,null,null,null,null,null,null,null,null,null,null,null,null),
                                                                (3,5,3,4,4,3,3,5,3,4,3,4,2,4),
                                                                (4,null,null,null,null,null,null,null,null,null,null,null,null,null),
                                                                (5,null,null,null,null,null,null,null,null,null,null,null,null,null);

INSERT INTO `report` VALUES (1,'2012-11-10','','valeriorossi@gmail.com'),
							(1,'2013-02-06','','valeriorossi@gmail.com'),
                            (1,'2013-02-21','','valeriorossi@gmail.com'),
                            (2,'2014-10-07','','mariopellegrini@gmail.com'),
                            (2,'2014-10-16','','mariopellegrini@gmail.com'),
                            (2,'2014-11-03','','mariopellegrini@gmail.com'),
                            (3,'2017-10-12','','vnovo@gmail.com'),
                            (3,'2017-12-04','','vnovo@gmail.com'),
                            (3,'2018-01-08','','vnovo@gmail.com');

INSERT INTO `stato_report` VALUES ('2012-11-10','compilato',1,'2012-11-10'),
									('2012-11-11','validato',1,'2012-11-10'),
                                    ('2013-02-06','compilato',1,'2013-02-06'),
                                    ('2013-02-21','compilato',1,'2013-02-21'),
                                    ('2013-02-21','validato',1,'2013-02-21'),
                                    ('2014-10-07','compilato',2,'2014-10-07'),
                                    ('2014-10-07','validato',2,'2014-10-07'),
                                    ('2014-10-16','compilato',2,'2014-10-16'),
                                    ('2014-10-17','validato',2,'2014-10-16'),
                                    ('2014-11-03','compilato',2,'2014-11-03'),
                                    ('2014-11-03','validato',2,'2014-11-03'),
                                    ('2017-10-12','compilato',3,'2017-10-12'),
                                    ('2017-10-12','validato',3,'2017-10-12'),
                                    ('2017-12-04','compilato',3,'2017-12-04'),
                                    ('2017-12-05','validato',3,'2017-12-04'),
                                    ('2018-01-08','compilato',3,'2018-01-08'),
                                    ('2018-01-09','validato',3,'2018-01-08');