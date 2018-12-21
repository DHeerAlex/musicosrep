package DAO;



import java.sql.*;
import java.util.*;
import java.math.*;



public class serviceDao {

    public service createValueObject() {
          return new service();
    }

    public service getObject(Connection conn, int ser_id) throws notFoundException, SQLException {

          service valueObject = createValueObject();
          valueObject.setSer_id(ser_id);
          load(conn, valueObject);
          return valueObject;
    }

    public void load(Connection conn, service valueObject) throws notFoundException, SQLException {

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

    public List loadAll(Connection conn) throws SQLException {

          String sql = "SELECT * FROM service ORDER BY ser_id ASC ";
          List searchResults = listQuery(conn, conn.prepareStatement(sql));

          return searchResults;
    }

    public synchronized void create(Connection conn, service valueObject) throws SQLException {

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

    public void save(Connection conn, service valueObject) 
          throws notFoundException, SQLException {

          String sql = "UPDATE service SET ser_lib = ? WHERE (ser_id = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getSer_lib()); 

              stmt.setInt(2, valueObject.getSer_id()); 

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

    public void delete(Connection conn, service valueObject) 
          throws notFoundException, SQLException {

          String sql = "DELETE FROM service WHERE (ser_id = ? ) ";
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

    public List searchMatching(Connection conn, service valueObject) throws SQLException {

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


    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {

          int result = stmt.executeUpdate();

          return result;
    }


    protected void singleQuery(Connection conn, PreparedStatement stmt, service valueObject) 
          throws notFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setSer_id(result.getInt("ser_id")); 
                   valueObject.setSer_lib(result.getString("ser_lib")); 

              } else {
                    //System.out.println("service Object Not Found!");
                    throw new notFoundException("service Object Not Found!");
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
                   service temp = createValueObject();

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
