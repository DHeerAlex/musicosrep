#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: localite
#------------------------------------------------------------

CREATE TABLE localite(
        loc_ins Varchar (5) NOT NULL ,
        loc_cp  Varchar (5) NOT NULL ,
        loc_lib Varchar (50) NOT NULL
	,CONSTRAINT localite_PK PRIMARY KEY (loc_ins)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: service
#------------------------------------------------------------

CREATE TABLE service(
        ser_id  Int  Auto_increment  NOT NULL ,
        ser_lib Varchar (50) NOT NULL
	,CONSTRAINT service_PK PRIMARY KEY (ser_id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: typeacteur
#------------------------------------------------------------

CREATE TABLE typeacteur(
        typ_id  Int  Auto_increment  NOT NULL ,
        typ_lib Varchar (50) NOT NULL
	,CONSTRAINT typeacteur_PK PRIMARY KEY (typ_id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: acteur
#------------------------------------------------------------

CREATE TABLE acteur(
        act_log        Varchar (10) NOT NULL ,
        act_nom        Varchar (50) NOT NULL ,
        act_pre        Varchar (50) NOT NULL ,
        act_tel        Varchar (10) NOT NULL ,
        act_mai        Varchar (50) NOT NULL ,
	act_pas        Varchar (10) NOT NULL ,
        act_pho        Varchar (50) NOT NULL ,
        act_grp        Varchar (10) NOT NULL ,
        act_ok         boolean NOT NULL ,
        loc_ins        Varchar (5) NOT NULL ,
        typ_id         Int NOT NULL ,
        act_log_acteur Varchar (10)
	,CONSTRAINT acteur_PK PRIMARY KEY (act_log)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: propose
#------------------------------------------------------------

CREATE TABLE propose(
        ser_id  Int NOT NULL ,
        act_log Varchar (10) NOT NULL ,
        pro_tar Float NOT NULL ,
        pro_typ Char (1) NOT NULL
	,CONSTRAINT propose_PK PRIMARY KEY (ser_id,act_log)
)ENGINE=InnoDB;




ALTER TABLE acteur
	ADD CONSTRAINT acteur_localite0_FK
	FOREIGN KEY (loc_ins)
	REFERENCES localite(loc_ins);

ALTER TABLE acteur
	ADD CONSTRAINT acteur_typeacteur1_FK
	FOREIGN KEY (typ_id)
	REFERENCES typeacteur(typ_id);

ALTER TABLE acteur
	ADD CONSTRAINT acteur_acteur2_FK
	FOREIGN KEY (act_log_acteur)
	REFERENCES acteur(act_log);

ALTER TABLE propose
	ADD CONSTRAINT propose_service0_FK
	FOREIGN KEY (ser_id)
	REFERENCES service(ser_id);

ALTER TABLE propose
	ADD CONSTRAINT propose_acteur1_FK
	FOREIGN KEY (act_log)
	REFERENCES acteur(act_log);
