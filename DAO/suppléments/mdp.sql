# SQL command to create the table: 
# Remember to correct VARCHAR column lengths to proper values 
# and add additional indexes for your own extensions.

# If you had prepaired CREATE TABLE SQL-statement before, 
# make sure that this automatically generated code is 
# compatible with your own code. If SQL code is incompatible,
# it is not possible to use these generated sources successfully.
# (Changing VARCHAR column lenghts will not break code.)

CREATE TABLE mdp (
      mdp_log varchar(255) NOT NULL,
      mdp_pw varchar(255),
PRIMARY KEY(mdp_log),
INDEX mdp_mdp_log_INDEX (mdp_log));
