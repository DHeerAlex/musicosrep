package DAO;


import java.sql.*;
import java.util.*;

import modele.localite;

import java.math.*;



public class localiteDao {

    public localite createValueObject() {
          return new localite();
    }

    public localite getObject(Connection conn, String loc_ins) throws notFoundException, SQLException {

          localite valueObject = createValueObject();
          valueObject.setLoc_ins(loc_ins);
          load(conn, valueObject);
          return valueObject;
    }

    public void load(Connection conn, localite valueObject) throws notFoundException, SQLException {

          if (valueObject.getLoc_ins() == null) {
               //System.out.println("Can not select without Primary-Key!");
               throw new notFoundException("Can not select without Primary-Key!");
          }

          String sql = "SELECT * FROM localite WHERE (loc_ins = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setString(1, valueObject.getLoc_ins()); 

               singleQuery(conn, stmt, valueObject);

          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }

    public List loadAll(Connection conn) throws SQLException {

          String sql = "SELECT * FROM localite ORDER BY loc_ins ASC ";
          List searchResults = listQuery(conn, conn.prepareStatement(sql));

          return searchResults;
    }


    public synchronized void create(Connection conn, localite valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO localite ( loc_ins, loc_cp, loc_lib) VALUES (?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setString(1, valueObject.getLoc_ins()); 
               stmt.setString(2, valueObject.getLoc_cp()); 
               stmt.setString(3, valueObject.getLoc_lib()); 

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

    public void save(Connection conn, localite valueObject) 
          throws notFoundException, SQLException {

          String sql = "UPDATE localite SET loc_cp = ?, loc_lib = ? WHERE (loc_ins = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getLoc_cp()); 
              stmt.setString(2, valueObject.getLoc_lib()); 

              stmt.setString(3, valueObject.getLoc_ins()); 

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

    public void delete(Connection conn, localite valueObject) 
          throws notFoundException, SQLException {

          if (valueObject.getLoc_ins() == null) {
               //System.out.println("Can not delete without Primary-Key!");
               throw new notFoundException("Can not delete without Primary-Key!");
          }

          String sql = "DELETE FROM localite WHERE (loc_ins = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getLoc_ins()); 

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

          String sql = "DELETE FROM localite";
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

          String sql = "SELECT count(*) FROM localite";
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

    public List searchMatching(Connection conn, localite valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM localite WHERE 1=1 ");

          if (valueObject.getLoc_ins() != null) {
              if (first) { first = false; }
              sql.append("AND loc_ins LIKE '").append(valueObject.getLoc_ins()).append("%' ");
          }

          if (valueObject.getLoc_cp() != null) {
              if (first) { first = false; }
              sql.append("AND loc_cp LIKE '").append(valueObject.getLoc_cp()).append("%' ");
          }

          if (valueObject.getLoc_lib() != null) {
              if (first) { first = false; }
              sql.append("AND loc_lib LIKE '").append(valueObject.getLoc_lib()).append("%' ");
          }


          sql.append("ORDER BY loc_ins ASC ");

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


    protected void singleQuery(Connection conn, PreparedStatement stmt, localite valueObject) 
          throws notFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setLoc_ins(result.getString("loc_ins")); 
                   valueObject.setLoc_cp(result.getString("loc_cp")); 
                   valueObject.setLoc_lib(result.getString("loc_lib")); 

              } else {
                    //System.out.println("localite Object Not Found!");
                    throw new notFoundException("localite Object Not Found!");
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
                   localite temp = createValueObject();

                   temp.setLoc_ins(result.getString("loc_ins")); 
                   temp.setLoc_cp(result.getString("loc_cp")); 
                   temp.setLoc_lib(result.getString("loc_lib")); 

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

