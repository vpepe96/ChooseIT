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
