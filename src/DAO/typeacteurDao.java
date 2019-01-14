package DAO;



import java.sql.*;
import java.util.*;

import modele.typeacteur;

import java.math.*;




public class typeacteurDao {


    public typeacteur createValueObject() {
          return new typeacteur();
    }

    public typeacteur getObject(Connection conn, int typ_id) throws notFoundException, SQLException {

          typeacteur valueObject = createValueObject();
          valueObject.setTyp_id(typ_id);
          load(conn, valueObject);
          return valueObject;
    }

   public void load(Connection conn, typeacteur valueObject) throws notFoundException, SQLException {

          String sql = "SELECT * FROM typeacteur WHERE (typ_id = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, valueObject.getTyp_id()); 

               singleQuery(conn, stmt, valueObject);

          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    public List loadAll(Connection conn) throws SQLException {

          String sql = "SELECT * FROM typeacteur ORDER BY typ_id ASC ";
          List searchResults = listQuery(conn, conn.prepareStatement(sql));

          return searchResults;
    }

    public synchronized void create(Connection conn, typeacteur valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO typeacteur ( typ_id, typ_lib) VALUES (?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setInt(1, valueObject.getTyp_id()); 
               stmt.setString(2, valueObject.getTyp_lib()); 

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

    public void save(Connection conn, typeacteur valueObject) 
          throws notFoundException, SQLException {

          String sql = "UPDATE typeacteur SET typ_lib = ? WHERE (typ_id = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getTyp_lib()); 

              stmt.setInt(2, valueObject.getTyp_id()); 

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

    public void delete(Connection conn, typeacteur valueObject) 
          throws notFoundException, SQLException {

          String sql = "DELETE FROM typeacteur WHERE (typ_id = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getTyp_id()); 

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

          String sql = "DELETE FROM typeacteur";
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

          String sql = "SELECT count(*) FROM typeacteur";
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

    public List searchMatching(Connection conn, typeacteur valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM typeacteur WHERE 1=1 ");

          if (valueObject.getTyp_id() != 0) {
              if (first) { first = false; }
              sql.append("AND typ_id = ").append(valueObject.getTyp_id()).append(" ");
          }

          if (valueObject.getTyp_lib() != null) {
              if (first) { first = false; }
              sql.append("AND typ_lib LIKE '").append(valueObject.getTyp_lib()).append("%' ");
          }


          sql.append("ORDER BY typ_id ASC ");

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


    protected void singleQuery(Connection conn, PreparedStatement stmt, typeacteur valueObject) 
          throws notFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setTyp_id(result.getInt("typ_id")); 
                   valueObject.setTyp_lib(result.getString("typ_lib")); 

              } else {
                    //System.out.println("typeacteur Object Not Found!");
                    throw new notFoundException("typeacteur Object Not Found!");
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
                   typeacteur temp = createValueObject();

                   temp.setTyp_id(result.getInt("typ_id")); 
                   temp.setTyp_lib(result.getString("typ_lib")); 

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
