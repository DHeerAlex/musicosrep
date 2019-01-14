package DAO;



import java.sql.*;
import java.util.*;

import modele.propose;

import java.math.*;


 

public class proposeDao {



    public propose createValueObject() {
          return new propose();
    }


    public propose getObject(Connection conn, int ser_id) throws notFoundException, SQLException {

          propose valueObject = createValueObject();
          valueObject.setSer_id(ser_id);
          load(conn, valueObject);
          return valueObject;
    }


    public void load(Connection conn, propose valueObject) throws notFoundException, SQLException {

          String sql = "SELECT * FROM propose WHERE (ser_id = ? ) "; 
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

    public List loadAll(Connection conn) throws SQLException {

          String sql = "SELECT * FROM propose ORDER BY ser_id ASC ";
          List searchResults = listQuery(conn, conn.prepareStatement(sql));

          return searchResults;
    }


    public synchronized void create(Connection conn, propose valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO propose ( ser_id, act_log, pro_tar, "
               + "pro_typ) VALUES (?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setInt(1, valueObject.getSer_id()); 
               stmt.setString(2, valueObject.getAct_log()); 
               stmt.setBigDecimal(3, valueObject.getPro_tar()); 
               stmt.setString(4, valueObject.getPro_typ()); 

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

    public void save(Connection conn, propose valueObject) 
          throws notFoundException, SQLException {

          String sql = "UPDATE propose SET act_log = ?, pro_tar = ?, pro_typ = ? WHERE (ser_id = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getAct_log()); 
              stmt.setBigDecimal(2, valueObject.getPro_tar()); 
              stmt.setString(3, valueObject.getPro_typ()); 

              stmt.setInt(4, valueObject.getSer_id()); 

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

    public void delete(Connection conn, propose valueObject) 
          throws notFoundException, SQLException {

          String sql = "DELETE FROM propose WHERE (ser_id = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getSer_id()); 

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

          String sql = "DELETE FROM propose";
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

          String sql = "SELECT count(*) FROM propose";
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

    public List searchMatching(Connection conn, propose valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM propose WHERE 1=1 ");

          if (valueObject.getSer_id() != 0) {
              if (first) { first = false; }
              sql.append("AND ser_id = ").append(valueObject.getSer_id()).append(" ");
          }

          if (valueObject.getAct_log() != null) {
              if (first) { first = false; }
              sql.append("AND act_log LIKE '").append(valueObject.getAct_log()).append("%' ");
          }

          if (valueObject.getPro_tar() != null) {
              if (first) { first = false; }
              sql.append("AND pro_tar = '").append(valueObject.getPro_tar()).append("' ");
          }

          if (valueObject.getPro_typ() != null) {
              if (first) { first = false; }
              sql.append("AND pro_typ LIKE '").append(valueObject.getPro_typ()).append("%' ");
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

    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {

          int result = stmt.executeUpdate();

          return result;
    }


    protected void singleQuery(Connection conn, PreparedStatement stmt, propose valueObject) 
          throws notFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setSer_id(result.getInt("ser_id")); 
                   valueObject.setAct_log(result.getString("act_log")); 
                   valueObject.setPro_tar(result.getBigDecimal("pro_tar")); 
                   valueObject.setPro_typ(result.getString("pro_typ")); 

              } else {
                    //System.out.println("propose Object Not Found!");
                    throw new notFoundException("propose Object Not Found!");
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
                   propose temp = createValueObject();

                   temp.setSer_id(result.getInt("ser_id")); 
                   temp.setAct_log(result.getString("act_log")); 
                   temp.setPro_tar(result.getBigDecimal("pro_tar")); 
                   temp.setPro_typ(result.getString("pro_typ")); 

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
