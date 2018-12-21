use version_2;

insert into localite values 
("121","1234","Ville A"),
("105","7894","Ville B"),
("95632","1245","Ville C"),
("12316","78941","Ville D");

insert into service values 
(1,"Inauguration"),
(2,"Interprétation"),
(3,"Concert"),
(4,"Interview");

insert into typeActeur values 
(1,"chanteur"),
(2,"musicien"),
(3,"groupe"),
(4,"choeur"),
(5,"orchestre");

insert into acteur values 
("Acteur1","Acteur1","Acteur1","0770154438","mail1","photo1","",true,"121",1,"Acteur1"),
("Acteur2","Acteur2","Acteur2","0770154438","mail2","photo2","",true,"121",2,"Acteur2"),
("Acteur3","Acteur3","Acteur3","0770154438","mail3","photo3","",true,"121",3,"Acteur3"),
("Acteur4","Acteur4","Acteur4","0770154438","mail4","photo4","",true,"121",4,"Acteur4"),
("Acteur5","Acteur5","Acteur5","0770154438","mail5","photo5","",true,"121",5,"Acteur5");

insert into propose values 
(1,"Acteur5",0,"h"),
(3,"Acteur1",15.1,"j"),
(4,"Acteur3",12.7,"h"),
(2,"Acteur2",25,"j");