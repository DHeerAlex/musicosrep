# SQL command to create the table: 
# Remember to correct VARCHAR column lengths to proper values 
# and add additional indexes for your own extensions.

# If you had prepaired CREATE TABLE SQL-statement before, 
# make sure that this automatically generated code is 
# compatible with your own code. If SQL code is incompatible,
# it is not possible to use these generated sources successfully.
# (Changing VARCHAR column lenghts will not break code.)

CREATE TABLE typeacteur (
      typ_id bigint NOT NULL,
      typ_lib varchar(255),
PRIMARY KEY(typ_id),
INDEX typeacteur_typ_id_INDEX (typ_id));


