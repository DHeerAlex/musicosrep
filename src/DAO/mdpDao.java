package DAO;



import java.sql.*;
import java.util.*;

import modele.mdp;

import java.math.*;



public class mdpDao {


    public mdp createValueObject() {
          return new mdp();
    }

    public mdp getObject(Connection conn, String mdp_log) throws notFoundException, SQLException {

          mdp valueObject = createValueObject();
          valueObject.setmdp_log(mdp_log);
          load(conn, valueObject);
          return valueObject;
    }

    public void load(Connection conn, mdp valueObject) throws notFoundException, SQLException {

          if (valueObject.getmdp_log() == null) {
               //System.out.println("Can not select without Primary-Key!");
               throw new notFoundException("Can not select without Primary-Key!");
          }

          String sql = "SELECT * FROM mdp WHERE (mdp_log = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setString(1, valueObject.getmdp_log()); 

               singleQuery(conn, stmt, valueObject);

          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }

    public List loadAll(Connection conn) throws SQLException {

          String sql = "SELECT * FROM mdp ORDER BY mdp_log ASC ";
          List searchResults = listQuery(conn, conn.prepareStatement(sql));

          return searchResults;
    }

    public synchronized void create(Connection conn, mdp valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO mdp ( mdp_log, mdp_pw) VALUES (?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setString(1, valueObject.getmdp_log()); 
               stmt.setString(2, valueObject.getmdp_pw()); 

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

    public void save(Connection conn, mdp valueObject) 
          throws notFoundException, SQLException {

          String sql = "UPDATE mdp SET mdp_pw = ? WHERE (mdp_log = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getmdp_pw()); 

              stmt.setString(2, valueObject.getmdp_log()); 

              int rowcount = databaseUpdate(conn, stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be saved! (PrimaryKey not found)");
                   throw new notFoundException("Object could not be saved! (PrimaryKey not found)");
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

    public void delete(Connection conn, mdp valueObject) 
          throws notFoundException, SQLException {

          if (valueObject.getmdp_log() == null) {
               //System.out.println("Can not delete without Primary-Key!");
               throw new notFoundException("Can not delete without Primary-Key!");
          }

          String sql = "DELETE FROM mdp WHERE (mdp_log = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getmdp_log()); 

              int rowcount = databaseUpdate(conn, stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be deleted (PrimaryKey not found)");
                   throw new notFoundException("Object could not be deleted! (PrimaryKey not found)");
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

    public void deleteAll(Connection conn) throws SQLException {

          String sql = "DELETE FROM mdp";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              int rowcount = databaseUpdate(conn, stmt);
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }

    public int countAll(Connection conn) throws SQLException {

          String sql = "SELECT count(*) FROM mdp";
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

    public List searchMatching(Connection conn, mdp valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM mdp WHERE 1=1 ");

          if (valueObject.getmdp_log() != null) {
              if (first) { first = false; }
              sql.append("AND mdp_log LIKE '").append(valueObject.getmdp_log()).append("%' ");
          }

          if (valueObject.getmdp_pw() != null) {
              if (first) { first = false; }
              sql.append("AND mdp_pw LIKE '").append(valueObject.getmdp_pw()).append("%' ");
          }


          sql.append("ORDER BY mdp_log ASC ");

          // Prevent accidential full table results.
          // Use loadAll if all rows must be returned.
          if (first)
               searchResults = new ArrayList();
          else
               searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

          return searchResults;
    }

    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {

          int result = stmt.executeUpdate();

          return result;
    }

    protected void singleQuery(Connection conn, PreparedStatement stmt, mdp valueObject) 
          throws notFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setmdp_log(result.getString("mdp_log")); 
                   valueObject.setmdp_pw(result.getString("mdp_pw")); 

              } else {
                    //System.out.println("mdp Object Not Found!");
                    throw new notFoundException("mdp Object Not Found!");
              }
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
    }

    protected List listQuery(Connection conn, PreparedStatement stmt) throws SQLException {

          ArrayList searchResults = new ArrayList();
          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              while (result.next()) {
                   mdp temp = createValueObject();

                   temp.setmdp_log(result.getString("mdp_log")); 
                   temp.setmdp_pw(result.getString("mdp_pw")); 

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
