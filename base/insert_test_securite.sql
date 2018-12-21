use version_2;
-- Mot de Passe = Identifiant codé en base64
insert into mdp values
("Acteur1","QWN0ZXVyMQ=="),
("Acteur2","QWN0ZXVyMg=="),
("Acteur3","QWN0ZXVyMw=="),
("Acteur4","QWN0ZXVyNA=="),
("Acteur5","QWN0ZXVyNQ==");

-- Droits par identifiant/ecran selon CRUD P
-- soit Create, Read, Update, Delete, Printing 
-- droits = "00000" si non trouvé dans la base
insert into droits values
("Acteur1","ecran1","01000"),
("Acteur1","ecran2","11111"),
("Acteur1","ecran3","01001"),
("Acteur2","ecran2","11111"),
("Acteur3","ecran2","11111"),
("Acteur3","ecran3","01001"),
("Acteur5","ecran1","01000");
