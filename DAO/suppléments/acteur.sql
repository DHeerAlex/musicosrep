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
