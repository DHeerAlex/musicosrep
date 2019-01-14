package DAO;


import java.sql.*;
import java.util.*;

import modele.droits;

import java.math.*;



public class droitsDao {


    public droits createValueObject() {
          return new droits();
    }

    public droits getObject(Connection conn, String dro_log) throws notFoundException, SQLException {

          droits valueObject = createValueObject();
          valueObject.setDro_log(dro_log);
          load(conn, valueObject);
          return valueObject;
    }

    public void load(Connection conn, droits valueObject) throws notFoundException, SQLException {

          if (valueObject.getDro_log() == null) {
               //System.out.println("Can not select without Primary-Key!");
               throw new notFoundException("Can not select without Primary-Key!");
          }

          String sql = "SELECT * FROM droits WHERE (dro_log = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setString(1, valueObject.getDro_log()); 

               singleQuery(conn, stmt, valueObject);

          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }

    public List loadAll(Connection conn) throws SQLException {

          String sql = "SELECT * FROM droits ORDER BY dro_log ASC ";
          List searchResults = listQuery(conn, conn.prepareStatement(sql));

          return searchResults;
    }

    public synchronized void create(Connection conn, droits valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO droits ( dro_log, dro_app, dro_aut) VALUES (?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setString(1, valueObject.getDro_log()); 
               stmt.setString(2, valueObject.getDro_app()); 
               stmt.setString(3, valueObject.getDro_aut()); 

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

    public void save(Connection conn, droits valueObject) 
          throws notFoundException, SQLException {

          String sql = "UPDATE droits SET dro_app = ?, dro_aut = ? WHERE (dro_log = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getDro_app()); 
              stmt.setString(2, valueObject.getDro_aut()); 

              stmt.setString(3, valueObject.getDro_log()); 

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

    public void delete(Connection conn, droits valueObject) 
          throws notFoundException, SQLException {

          if (valueObject.getDro_log() == null) {
               //System.out.println("Can not delete without Primary-Key!");
               throw new notFoundException("Can not delete without Primary-Key!");
          }

          String sql = "DELETE FROM droits WHERE (dro_log = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getDro_log()); 

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

          String sql = "DELETE FROM droits";
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

          String sql = "SELECT count(*) FROM droits";
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

    public List searchMatching(Connection conn, droits valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM droits WHERE 1=1 ");

          if (valueObject.getDro_log() != null) {
              if (first) { first = false; }
              sql.append("AND dro_log LIKE '").append(valueObject.getDro_log()).append("%' ");
          }

          if (valueObject.getDro_app() != null) {
              if (first) { first = false; }
              sql.append("AND dro_app LIKE '").append(valueObject.getDro_app()).append("%' ");
          }

          if (valueObject.getDro_aut() != null) {
              if (first) { first = false; }
              sql.append("AND dro_aut LIKE '").append(valueObject.getDro_aut()).append("%' ");
          }


          sql.append("ORDER BY dro_log ASC ");

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

    protected void singleQuery(Connection conn, PreparedStatement stmt, droits valueObject) 
          throws notFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setDro_log(result.getString("dro_log")); 
                   valueObject.setDro_app(result.getString("dro_app")); 
                   valueObject.setDro_aut(result.getString("dro_aut")); 

              } else {
                    //System.out.println("droits Object Not Found!");
                    throw new notFoundException("droits Object Not Found!");
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
                   droits temp = createValueObject();

                   temp.setDro_log(result.getString("dro_log")); 
                   temp.setDro_app(result.getString("dro_app")); 
                   temp.setDro_aut(result.getString("dro_aut")); 

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

