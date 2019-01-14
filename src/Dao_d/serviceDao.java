package Dao_d;



import java.sql.*;
import java.util.*;

import db.*;
import modele.service;

import java.math.*;



public class serviceDao {

	private DB_Connection laCo = new DB_Connection();
	private Connection conn = laCo.get_connection();
	private PreparedStatement stmt = null;
	
	public void ajouter(service newS) {
    	try {
            String sql = "INSERT INTO service ( ser_id, ser_lib) VALUES (?, ?) ";
            try {
				stmt = conn.prepareStatement(sql);
           
	            stmt.setInt(1, newS.getSer_id()); 
	            stmt.setString(2, newS.getSer_lib());
	
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
	
	public void modifier(service oldS) {
    	try {
            String sql = "UPDATE service SET ser_lib = ? WHERE (ser_id = ? ) ";
            try {
				stmt = conn.prepareStatement(sql);
           
				stmt.setString(1, oldS.getSer_lib()); 
	            stmt.setInt(2, oldS.getSer_id());
	            
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
	
	public void supprimer(service oldS) {
    	try {
            String sql = "DELETE FROM service WHERE (ser_id = ? ) ";
            try {
				stmt = conn.prepareStatement(sql);
           
				stmt.setInt(1, oldS.getSer_id());
	
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
	
    public List<service> listeServices() {
    	List<service> newListe = new ArrayList();
    	String sql = "SELECT * FROM service";
    	try {
    		Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sql);
    	    while(res.next()) {
    	    	service retourne = new service();
    	    	  retourne.setAll(res.getInt(1), res.getString(2));
    	    	  newListe.add(retourne);
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return newListe;
    }
	
	public service retourne(int id) {
    	service retourne = new service();
    	try {
        	stmt = conn.prepareStatement("SELECT * FROM service WHERE ser_id = ?"); 
        	stmt.setInt(1,id); 
    	      
    	      ResultSet res = stmt.executeQuery();
    	      while(res.next()) {
    	    	  retourne.setAll(res.getInt(1), res.getString(2));
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return retourne;
    }

	public service retourne(String libelle) {
    	service retourne = new service();
    	try {
        	stmt = conn.prepareStatement("SELECT * FROM service WHERE ser_lib = ?"); 
        	stmt.setString(1,libelle); 
    	      
    	      ResultSet res = stmt.executeQuery();
    	      while(res.next()) {
    	    	  retourne.setAll(res.getInt(1), res.getString(2));
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return retourne;
    }
	
	public int nbServices() {
    	int nb = -1;
    	String sql = "SELECT count(*) AS nbServices FROM service";
    	
    	try {
        	Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sql);
			  
			  
			if(res.next()) {
				nb = res.getInt("nbServices");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
    	
    	return nb;
    }

	public boolean existe(service S) {
    	boolean exists = false;
    	
		try {
			stmt = conn.prepareStatement("SELECT * FROM service WHERE ser_id = ?"); 
			stmt.setInt(1, S.getSer_id());
	      
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
