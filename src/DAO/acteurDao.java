package DAO;



import java.sql.*;
import java.util.*;

import DAO.acteur;

import java.math.*;




public class acteurDao {

    public acteur createValueObject() {
          return new acteur();
    }

    public acteur getObject(Connection conn, String act_log) throws notFoundException, SQLException {

          acteur valueObject = createValueObject();
          valueObject.setAct_log(act_log);
          load(conn, valueObject);
          return valueObject;
    }

    public void load(Connection conn, acteur valueObject) throws notFoundException, SQLException {

          if (valueObject.getAct_log() == null) {
               //System.out.println("Can not select without Primary-Key!");
               throw new notFoundException("Can not select without Primary-Key!");
          }

          String sql = "SELECT * FROM acteur WHERE (act_log = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setString(1, valueObject.getAct_log()); 

               singleQuery(conn, stmt, valueObject);

          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }

    public List loadAll(Connection conn) throws SQLException {

          String sql = "SELECT * FROM acteur ORDER BY act_log ASC ";
          List searchResults = listQuery(conn, conn.prepareStatement(sql));

          return searchResults;
    }

    public synchronized void create(Connection conn, acteur valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO acteur ( act_log, act_nom, act_pre, "
               + "act_tel, act_mai, act_pho, "
               + "act_grp, act_ok, loc_ins, "
               + "typ_id, act_log_acteur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setString(1, valueObject.getAct_log()); 
               stmt.setString(2, valueObject.getAct_nom()); 
               stmt.setString(3, valueObject.getAct_pre()); 
               stmt.setString(4, valueObject.getAct_tel()); 
               stmt.setString(5, valueObject.getAct_mai()); 
               stmt.setString(6, valueObject.getAct_pho()); 
               stmt.setString(7, valueObject.getAct_grp()); 
               stmt.setInt(8, valueObject.getAct_ok()); 
               stmt.setString(9, valueObject.getLoc_ins()); 
               stmt.setInt(10, valueObject.getTyp_id()); 
               stmt.setString(11, valueObject.getAct_log_acteur()); 

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

    public void save(Connection conn, acteur valueObject) 
          throws notFoundException, SQLException {

          String sql = "UPDATE acteur SET act_nom = ?, act_pre = ?, act_tel = ?, "
               + "act_mai = ?, act_pho = ?, act_grp = ?, "
               + "act_ok = ?, loc_ins = ?, typ_id = ?, "
               + "act_log_acteur = ? WHERE (act_log = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getAct_nom()); 
              stmt.setString(2, valueObject.getAct_pre()); 
              stmt.setString(3, valueObject.getAct_tel()); 
              stmt.setString(4, valueObject.getAct_mai()); 
              stmt.setString(5, valueObject.getAct_pho()); 
              stmt.setString(6, valueObject.getAct_grp()); 
              stmt.setInt(7, valueObject.getAct_ok()); 
              stmt.setString(8, valueObject.getLoc_ins()); 
              stmt.setInt(9, valueObject.getTyp_id()); 
              stmt.setString(10, valueObject.getAct_log_acteur()); 

              stmt.setString(11, valueObject.getAct_log()); 

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

    public void delete(Connection conn, acteur valueObject) 
          throws notFoundException, SQLException {

          if (valueObject.getAct_log() == null) {
               //System.out.println("Can not delete without Primary-Key!");
               throw new notFoundException("Can not delete without Primary-Key!");
          }

          String sql = "DELETE FROM acteur WHERE (act_log = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, valueObject.getAct_log()); 

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

          String sql = "DELETE FROM acteur";
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

          String sql = "SELECT count(*) FROM acteur";
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

    public List searchMatching(Connection conn, acteur valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM acteur WHERE 1=1 ");

          if (valueObject.getAct_log() != null) {
              if (first) { first = false; }
              sql.append("AND act_log LIKE '").append(valueObject.getAct_log()).append("%' ");
          }

          if (valueObject.getAct_nom() != null) {
              if (first) { first = false; }
              sql.append("AND act_nom LIKE '").append(valueObject.getAct_nom()).append("%' ");
          }

          if (valueObject.getAct_pre() != null) {
              if (first) { first = false; }
              sql.append("AND act_pre LIKE '").append(valueObject.getAct_pre()).append("%' ");
          }

          if (valueObject.getAct_tel() != null) {
              if (first) { first = false; }
              sql.append("AND act_tel LIKE '").append(valueObject.getAct_tel()).append("%' ");
          }

          if (valueObject.getAct_mai() != null) {
              if (first) { first = false; }
              sql.append("AND act_mai LIKE '").append(valueObject.getAct_mai()).append("%' ");
          }

          if (valueObject.getAct_pho() != null) {
              if (first) { first = false; }
              sql.append("AND act_pho LIKE '").append(valueObject.getAct_pho()).append("%' ");
          }

          if (valueObject.getAct_grp() != null) {
              if (first) { first = false; }
              sql.append("AND act_grp LIKE '").append(valueObject.getAct_grp()).append("%' ");
          }

          if (valueObject.getAct_ok() != 0) {
              if (first) { first = false; }
              sql.append("AND act_ok = ").append(valueObject.getAct_ok()).append(" ");
          }

          if (valueObject.getLoc_ins() != null) {
              if (first) { first = false; }
              sql.append("AND loc_ins LIKE '").append(valueObject.getLoc_ins()).append("%' ");
          }

          if (valueObject.getTyp_id() != 0) {
              if (first) { first = false; }
              sql.append("AND typ_id = ").append(valueObject.getTyp_id()).append(" ");
          }

          if (valueObject.getAct_log_acteur() != null) {
              if (first) { first = false; }
              sql.append("AND act_log_acteur LIKE '").append(valueObject.getAct_log_acteur()).append("%' ");
          }


          sql.append("ORDER BY act_log ASC ");

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

    protected void singleQuery(Connection conn, PreparedStatement stmt, acteur valueObject) 
          throws notFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setAct_log(result.getString("act_log")); 
                   valueObject.setAct_nom(result.getString("act_nom")); 
                   valueObject.setAct_pre(result.getString("act_pre")); 
                   valueObject.setAct_tel(result.getString("act_tel")); 
                   valueObject.setAct_mai(result.getString("act_mai")); 
                   valueObject.setAct_pho(result.getString("act_pho")); 
                   valueObject.setAct_grp(result.getString("act_grp")); 
                   valueObject.setAct_ok(result.getInt("act_ok")); 
                   valueObject.setLoc_ins(result.getString("loc_ins")); 
                   valueObject.setTyp_id(result.getInt("typ_id")); 
                   valueObject.setAct_log_acteur(result.getString("act_log_acteur")); 

              } else {
                    //System.out.println("acteur Object Not Found!");
                    throw new notFoundException("acteur Object Not Found!");
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
                   acteur temp = createValueObject();

                   temp.setAct_log(result.getString("act_log")); 
                   temp.setAct_nom(result.getString("act_nom")); 
                   temp.setAct_pre(result.getString("act_pre")); 
                   temp.setAct_tel(result.getString("act_tel")); 
                   temp.setAct_mai(result.getString("act_mai")); 
                   temp.setAct_pho(result.getString("act_pho")); 
                   temp.setAct_grp(result.getString("act_grp")); 
                   temp.setAct_ok(result.getInt("act_ok")); 
                   temp.setLoc_ins(result.getString("loc_ins")); 
                   temp.setTyp_id(result.getInt("typ_id")); 
                   temp.setAct_log_acteur(result.getString("act_log_acteur")); 

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
