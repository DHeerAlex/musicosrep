package Dao_d;



import java.sql.*;
import java.util.*;


import db.*;
import modele.mdp;

import java.math.*;



public class mdpDao {


    private DB_Connection laCo = new DB_Connection();
	private Connection conn = laCo.get_connection();
	private PreparedStatement stmt = null;
	
	public void ajouter(mdp newS) {
    	try {
            String sql = "INSERT INTO mdp ( mdp_log, mdp_pw) VALUES (?, ?) ";
            try {
				stmt = conn.prepareStatement(sql);
           
	            stmt.setString(1, newS.getmdp_log()); 
	            stmt.setString(2, newS.getmdp_pw());
	
	            int rowcount = stmt.executeUpdate();
	            if (rowcount != 1) {
	                 //System.out.println("PrimaryKey Error when updating DB!");
	                 throw new SQLException("PrimaryKey Error when updating DB!");
	            }
            } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void modifier(mdp oldS) {
    	try {
            String sql = "UPDATE mdp SET mdp_pw = ? WHERE (mdp_log = ? ) ";
            try {
				stmt = conn.prepareStatement(sql);
           
				stmt.setString(1, oldS.getmdp_pw()); 
	            stmt.setString(2, oldS.getmdp_log());
	            
	            int rowcount = stmt.executeUpdate();
	            if (rowcount != 1) {
	                 //System.out.println("PrimaryKey Error when updating DB!");
	                 throw new SQLException("PrimaryKey Error when updating DB!");
	            }
            } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	
	public void supprimer(mdp oldS) {
    	try {
            String sql = "DELETE FROM mdp WHERE (mdp_log = ? ) ";
            try {
				stmt = conn.prepareStatement(sql);
           
				stmt.setString(1, oldS.getmdp_log());
	
	            int rowcount = stmt.executeUpdate();
	            if (rowcount != 1) {
	                 //System.out.println("PrimaryKey Error when updating DB!");
	                 throw new SQLException("PrimaryKey Error when updating DB!");
	            }
            } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
    public List<mdp> listemdps() {
    	List<mdp> newListe = new ArrayList();
    	String sql = "SELECT * FROM mdp";
    	try {
    		Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sql);
    	    while(res.next()) {
    	    	mdp retourne = new mdp();
    	    	  retourne.setAll(res.getString(1), res.getString(2));
    	    	  newListe.add(retourne);
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return newListe;
    }
	
	public mdp retourne(String log) {
    	mdp retourne = new mdp();
    	try {
        	stmt = conn.prepareStatement("SELECT * FROM mdp WHERE mdp_log = ?"); 
        	stmt.setString(1,log); 
    	      
    	      ResultSet res = stmt.executeQuery();
    	      while(res.next()) {
    	    	  retourne.setAll(res.getString(1), res.getString(2));
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return retourne;
    }
	
	public int nbMdps() {
    	int nb = -1;
    	String sql = "SELECT count(*) AS nbMdps FROM mdp";
    	
    	try {
        	Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sql);
			  
			  
			if(res.next()) {
				nb = res.getInt("nbMdps");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
    	
    	return nb;
    }

	public boolean existe(mdp M) {
    	boolean exists = false;
    	
		try {
			stmt = conn.prepareStatement("SELECT * FROM mdp WHERE mdp_log = ? and mdp_pw = ?"); 
			stmt.setString(1, M.getmdp_log());
			stmt.setString(2, M.getmdp_pw());
	      
	      ResultSet res = stmt.executeQuery();
	      if(res.next()) {
	    	  exists = true;
	      } else {
	    	  exists = false;
	      }
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
    	return exists;
    }


}
