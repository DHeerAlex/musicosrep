#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: mdp
#------------------------------------------------------------

CREATE TABLE mdp(
        mdp_log        Varchar (10) NOT NULL ,
        mdp_pw         Varchar (50) NOT NULL ,
	CONSTRAINT mdp_PK PRIMARY KEY (mdp_log)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: droits
#------------------------------------------------------------

CREATE TABLE droits(
        dro_log        Varchar (10) NOT NULL ,
		dro_app        Varchar (20) NOT NULL ,
        dro_aut        Varchar (5) NOT NULL ,
	CONSTRAINT droits_PK PRIMARY KEY (dro_log,dro_app)
)ENGINE=InnoDB;
