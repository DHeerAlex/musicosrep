# SQL command to create the table: 
# Remember to correct VARCHAR column lengths to proper values 
# and add additional indexes for your own extensions.

# If you had prepaired CREATE TABLE SQL-statement before, 
# make sure that this automatically generated code is 
# compatible with your own code. If SQL code is incompatible,
# it is not possible to use these generated sources successfully.
# (Changing VARCHAR column lenghts will not break code.)

CREATE TABLE droits (
      dro_log varchar(255) NOT NULL,
      dro_app varchar(255),
      dro_aut varchar(255),
PRIMARY KEY(dro_log),
INDEX droits_dro_log_INDEX (dro_log));

