# Commande SQL pour créer la table:
# N'oubliez pas de corriger les longueurs de colonne VARCHAR aux valeurs appropriées
# et ajouter des index supplémentaires pour vos propres extensions.

# Si vous aviez préparé une instruction SQL CREATE TABLE auparavant,
# assurez-vous que ce code généré automatiquement est
# compatible avec votre propre code. Si le code SQL est incompatible,
# il n'est pas possible d'utiliser ces sources générées avec succès.
# (Changer la longueur des colonnes VARCHAR ne rompt pas le code.)


CREATE TABLE acteur (
      act_log varchar(255) NOT NULL,
      act_nom varchar(255),
      act_pre varchar(255),
      act_tel varchar(255),
      act_mai varchar(255),
      act_pho varchar(255),
      act_grp varchar(255),
      act_ok bigint,
      loc_ins varchar(255),
      typ_id bigint,
      act_log_acteur varchar(255),
PRIMARY KEY(act_log),
INDEX acteur_act_log_INDEX (act_log));


CREATE TABLE typeacteur (
      typ_id bigint NOT NULL,
      typ_lib varchar(255),
PRIMARY KEY(typ_id),
INDEX typeacteur_typ_id_INDEX (typ_id));


CREATE TABLE localite (
      loc_ins varchar(255) NOT NULL,
      loc_cp varchar(255),
      loc_lib varchar(255),
PRIMARY KEY(loc_ins),
INDEX localite_loc_ins_INDEX (loc_ins));


CREATE TABLE propose (
      ser_id bigint NOT NULL,
      act_log varchar(255),
      pro_tar decimal,
      pro_typ varchar(255),
PRIMARY KEY(ser_id),
INDEX propose_ser_id_INDEX (ser_id));


CREATE TABLE service (
      ser_id bigint NOT NULL,
      ser_lib varchar(255),
PRIMARY KEY(ser_id),
INDEX service_ser_id_INDEX (ser_id));


CREATE TABLE mdp (
      mdp_log varchar(255) NOT NULL,
      mdp_pw varchar(255),
PRIMARY KEY(mdp_log),
INDEX mdp_mdp_log_INDEX (mdp_log));


CREATE TABLE droits (
      dro_log varchar(255) NOT NULL,
      dro_app varchar(255),
      dro_aut varchar(255),
PRIMARY KEY(dro_log),
INDEX droits_dro_log_INDEX (dro_log));

