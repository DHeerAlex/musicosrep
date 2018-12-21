# SQL command to create the table: 
# Remember to correct VARCHAR column lengths to proper values 
# and add additional indexes for your own extensions.

# If you had prepaired CREATE TABLE SQL-statement before, 
# make sure that this automatically generated code is 
# compatible with your own code. If SQL code is incompatible,
# it is not possible to use these generated sources successfully.
# (Changing VARCHAR column lenghts will not break code.)

CREATE TABLE propose (
      ser_id bigint NOT NULL,
      act_log varchar(255),
      pro_tar decimal,
      pro_typ varchar(255),
PRIMARY KEY(ser_id),
INDEX propose_ser_id_INDEX (ser_id));

