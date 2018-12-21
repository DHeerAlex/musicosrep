package Documentation;

import java.sql.*;
import java.util.*;
import java.math.*;

	/**
    * Objet d'accès aux données de service (DAO).
    * Cette classe contient toute la gestion de base de données nécessaire pour
    * stocker et récupérer en permanence des instances d'objet de service.
    */

public class ServiceDao {

	/**
    * createValueObject-method. Cette méthode est utilisée lorsque la classe Dao a besoin
    * créer une nouvelle instance d'objet de valeur. La raison pour laquelle cette méthode existe
    * est que parfois le programmeur peut vouloir étendre aussi la valeur valueObject
    * et ensuite cette méthode peut être remplacée pour renvoyer extended valueObject.
    * REMARQUE: Si vous étendez la classe valueObject, veillez à remplacer le
    * méthode clone () dedans!
    */

	  public Service createValueObject() {
          return new Service();
    }

    /**
	* méthode getObject. Cela va créer et charger le contenu valueObject de la base de données
    * en utilisant la clé primaire donnée comme identifiant. Cette méthode est juste une méthode de commodité
    * pour la méthode de chargement réelle qui accepte valueObject en tant que paramètre. Revenu
    * valueObject sera créé à l'aide de la méthode createValueObject (). 
    */
	
    public Service getObject(Connection conn, int ser_id) throws NotFoundException, SQLException {

          Service valueObject = createValueObject();
          valueObject.setSer_id(ser_id);
          load(conn, valueObject);
          return valueObject;
    }

    /**
	* méthode de chargement. Cela chargera le contenu valueObject de la base de données en utilisant
    * Clé primaire comme identifiant. La couche supérieure doit utiliser ceci pour que valueObject
    * instance est créée et seule la clé primaire doit être spécifiée. Alors appelez
    * cette méthode pour compléter d'autres informations persistantes. Cette méthode va
    * écraser tous les autres champs à l'exception de la clé primaire et des variables d'exécution possibles.
    * Si load ne trouve pas la ligne correspondante, une exception NotFoundException sera levée.
    *
    * @param conn Cette méthode nécessite une connexion à la base de données active.
    * @param valueObject Ce paramètre contient l'instance de la classe à charger.
    * Le champ de clé primaire doit être défini pour que cela fonctionne correctement.
	*/
	
    public void load(Connection conn, Service valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM service WHERE (ser_id = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, valueObject.getSer_id()); 

               singleQuery(conn, stmt, valueObject);

          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }

    /**
	* LoadAll-méthode. Ceci lira tout le contenu de la table de base de données et
    * Construire une liste contenant valueObjects. S'il vous plaît noter que cette méthode
    * consommera d'énormes quantités de ressources si la table a beaucoup de lignes.
    * Ceci ne devrait être utilisé que lorsque les tables cibles ne contiennent que de petites quantités
    * de données.
    *
    * @param conn Cette méthode nécessite une connexion à la base de données active.
	*/
	
    public List loadAll(Connection conn) throws SQLException {

          String sql = "SELECT * FROM service ORDER BY ser_id ASC ";
          List searchResults = listQuery(conn, conn.prepareStatement(sql));

          return searchResults;
    }

    /**
	* create-method. Cela créera une nouvelle ligne dans la base de données en fonction de
    * contenu de valueObject. Assurez-vous que les valeurs de toutes les colonnes NOT NULL sont
    * correctement spécifié. De plus, si cette table n'utilise pas de clé de substitution automatique
    * la clé primaire doit être spécifiée. Après la commande INSERT, cette méthode
    * relire la clé primaire générée dans valueObject si des clés de substitution automatiques
    * ont été utilisées.
    *
    * @param conn Cette méthode nécessite une connexion à la base de données active.
    * @param valueObject Ce paramètre contient l'instance de classe à créer.
    * Si les clés de substitution automatiques ne sont pas utilisées, la clé principale
    * Le champ doit être défini pour que cela fonctionne correctement.
	*/
	
    public synchronized void create(Connection conn, Service valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO service ( ser_id, ser_lib) VALUES (?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setInt(1, valueObject.getSer_id()); 
               stmt.setString(2, valueObject.getSer_lib()); 

               int rowcount = databaseUpdate(conn, stmt);
               if (rowcount != 1) {
                    //System.out.println("PrimaryKey Error when updating DB!");
                    throw new SQLException("PrimaryKey Error when updating DB!");
               }

          } finally {
              if (stmt != null)
                  stmt.close();
          }


    }

    /**
	* méthode de sauvegarde. Cette méthode sauvegardera l'état actuel de valueObject dans la base de données.
    * Enregistrer ne peut pas être utilisé pour créer de nouvelles instances dans la base de données, la couche supérieure doit
    * assurez-vous que la clé primaire est correctement spécifiée. La clé primaire indiquera
    * quelle instance va être mise à jour dans la base de données. Si sauvegarder ne trouve pas de correspondance
    * ligne, NotFoundException sera levée.
    *
    * @param conn Cette méthode nécessite une connexion à la base de données active.
    * @param valueObject Ce paramètre contient l'instance de classe à enregistrer.
    * Le champ de clé primaire doit être défini pour que cela fonctionne correctement.
	*/
	
    public void save(Connection conn, Service valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE service SET ser_lib = ? WHERE (ser_id = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getSer_lib()); 
              stmt.setInt(2, valueObject.getSer_id()); 

              int rowcount = databaseUpdate(conn, stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be saved! (PrimaryKey not found)");
                   throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
              }
              if (rowcount > 1) {
                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
              }
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }

    /**
	* delete-method. Cette méthode supprimera les informations de la base de données identifiées par
    * par clé primaire dans valueObject fourni. Une fois que valueObject a été supprimé, il ne peut plus
    * être restauré en appelant save. La restauration ne peut être effectuée que par la méthode create, mais si
    * la base de données utilise des clés de substitution automatiques, l’objet résultant sera différent
    * primaire-clé que ce qu'il était dans l'objet supprimé. Si delete ne trouve pas la ligne correspondante,
    * NotFoundException sera levée.
    *
    * @param conn Cette méthode nécessite une connexion à la base de données active.
    * @param valueObject Ce paramètre contient l'instance de la classe à supprimer.
    * Le champ de clé primaire doit être défini pour que cela fonctionne correctement.
	*/
	
    public void delete(Connection conn, Service valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM service WHERE (ser_id = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getSer_id()); 

              int rowcount = databaseUpdate(conn, stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be deleted (PrimaryKey not found)");
                   throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
              }
              if (rowcount > 1) {
                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
              }
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }

    /**
	* deleteAll-méthode. Cette méthode supprimera toutes les informations de la table qui correspond
    * ce couple Dao et ValueObject. Cela devrait être le moyen le plus efficace de vider la table.
    * Une fois que deleteAll a été appelé, aucun valueObject créé auparavant ne peut être
    * restauré en appelant save. La restauration ne peut être effectuée qu'avec la méthode create, mais si la base de données
    * utilise des clés de substitution automatiques, l'objet résultant aura une clé primaire différente
    * que ce que c'était dans l'objet supprimé. (Remarque, la mise en œuvre de cette méthode devrait
    * être différent avec des bases de données différentes.)
    *
    * @param conn Cette méthode nécessite une connexion à la base de données active.
	*/
	
    public void deleteAll(Connection conn) throws SQLException {

          String sql = "DELETE FROM service";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              int rowcount = databaseUpdate(conn, stmt);
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }

    /**
	* coutAll-méthode. Cette méthode retournera le nombre de toutes les lignes de la table qui correspond
    * ce Dao. L'implémentation exécutera simplement "select count (primarykey) from table".
    * Si table est vide, la valeur de retour est 0. Cette méthode doit être utilisée avant d'appeler
    * loadAll, pour s'assurer que la table n'a pas trop de lignes.
    *
    * @param conn Cette méthode nécessite une connexion à la base de données active.
	*/
	
    public int countAll(Connection conn) throws SQLException {

          String sql = "SELECT count(*) FROM service";
          PreparedStatement stmt = null;
          ResultSet result = null;
          int allRows = 0;

          try {
              stmt = conn.prepareStatement(sql);
              result = stmt.executeQuery();

              if (result.next())
                  allRows = result.getInt(1);
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
          return allRows;
    }

    /** 
	* méthode searchMatching. Cette méthode offre une capacité de recherche pour
    * obtenir la valeur valueObjects correspondante de la base de données. Cela fonctionne en recherchant tous
    * objets qui correspondent aux variables d'instance permanente d'un objet donné.
    * La couche supérieure devrait utiliser ceci en définissant certains paramètres dans valueObject
    * puis appelez searchMatching. Le résultat sera 0-N objets dans une liste,
    * tous correspondant à ces critères que vous avez spécifiés. Ces variables d'instance qui
    * ont des valeurs NULL sont exclues dans les critères de recherche.
    *
    * @param conn Cette méthode nécessite une connexion à la base de données active.
    * @param valueObject Ce paramètre contient l'instance de la classe sur laquelle la recherche sera basée.
    * Le champ de clé primaire ne doit pas être défini.
	*/
	
    public List searchMatching(Connection conn, Service valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM service WHERE 1=1 ");

          if (valueObject.getSer_id() != 0) {
              if (first) { first = false; }
              sql.append("AND ser_id = ").append(valueObject.getSer_id()).append(" ");
          }

          if (valueObject.getSer_lib() != null) {
              if (first) { first = false; }
              sql.append("AND ser_lib LIKE '").append(valueObject.getSer_lib()).append("%' ");
          }


          sql.append("ORDER BY ser_id ASC ");

          // Prevent accidential full table results.
          // Use loadAll if all rows must be returned.
          if (first)
               searchResults = new ArrayList();
          else
               searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

          return searchResults;
    }

    /** 
	* getDaogenVersion renverra des informations sur
    * générateur qui a créé ces sources.
	*/
	
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    /**
	* databaseUpdate-method. Cette méthode est une méthode d'assistance à usage interne. Il va exécuter
    * Tous les traitements de base de données qui vont changer les informations dans les tables. SELECT requêtes seront
    * ne pas être exécuté ici cependant. La valeur de retour indique combien de lignes ont été affectées.
    * Cette méthode s'assurera également que si le cache est utilisé, il sera réinitialisé lorsque les données seront modifiées.
    *
    * @param conn Cette méthode nécessite une connexion à la base de données active.
    * @param stmt Ce paramètre contient l'instruction SQL à exécuter.
	*/
	
    protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {

          int result = stmt.executeUpdate();

          return result;
    }

    /**
	* databaseQuery-method. Cette méthode est une méthode d'assistance à usage interne. Il va exécuter
    * toutes les requêtes de base de données qui renverront une seule ligne. Le résultat sera converti
    * à valueObject. Si aucune ligne n'a été trouvée, NotFoundException sera levée.
    *
    * @param conn Cette méthode nécessite une connexion à la base de données active.
    * @param stmt Ce paramètre contient l'instruction SQL à exécuter.
    * @param valueObject Instance de classe où les données résultantes seront stockées.
	*/
	
    protected void singleQuery(Connection conn, PreparedStatement stmt, Service valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setSer_id(result.getInt("ser_id")); 
                   valueObject.setSer_lib(result.getString("ser_lib")); 

              } else {
                    //System.out.println("Service Object Not Found!");
                    throw new NotFoundException("Service Object Not Found!");
              }
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
    }

    /**
	* databaseQuery-method. Cette méthode est une méthode d'assistance à usage interne. Il va exécuter
    * toutes les requêtes de base de données qui renverront plusieurs lignes. Le résultat sera converti
    * à la liste de valueObjects. Si aucune ligne n'a été trouvée, une liste vide sera retournée.
    *
    * @param conn Cette méthode nécessite une connexion à la base de données active.
    * @param stmt Ce paramètre contient l'instruction SQL à exécuter.
	*/
	
    protected List listQuery(Connection conn, PreparedStatement stmt) throws SQLException {

          ArrayList searchResults = new ArrayList();
          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              while (result.next()) {
                   Service temp = createValueObject();

                   temp.setSer_id(result.getInt("ser_id")); 
                   temp.setSer_lib(result.getString("ser_lib")); 

                   searchResults.add(temp);
              }

          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }

          return (List)searchResults;
    }
}
