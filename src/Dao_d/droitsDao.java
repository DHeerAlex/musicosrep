package Dao_d;


import java.sql.*;
import java.util.*;

import db.*;
import modele.droits;

import java.math.*;

public class droitsDao {

	private DB_Connection laCo = new DB_Connection();
	private Connection conn = laCo.get_connection();
	private PreparedStatement stmt = null;

	public void ajouter(droits newD) {
    	try {
            String sql = "INSERT INTO droits ( dro_log, dro_app,dro_aut) VALUES (?, ?, ?) ";
            try {
				stmt = conn.prepareStatement(sql);
           
	            stmt.setString(1, newD.getDro_log() ); 
	            stmt.setString(2, newD.getDro_app() );
	            stmt.setString(3, newD.getDro_aut() );
	            
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
	
	public void modifier(droits oldD) {
    	try {
            String sql = "UPDATE droits SET dro_aut = ? WHERE (dro_log = ? and dro_app = ?) ";
            try {
				stmt = conn.prepareStatement(sql);
           
				stmt.setString(2, oldD.getDro_log() ); 
	            stmt.setString(3, oldD.getDro_app() );
	            stmt.setString(1, oldD.getDro_aut() );
	            
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
	
	public void supprimer(droits oldD) {
    	try {
            String sql = "DELETE FROM droits WHERE (dro_log = ? and dro_app = ?) ";
            try {
				stmt = conn.prepareStatement(sql);
           
				stmt.setString(1, oldD.getDro_log() ); 
	            stmt.setString(2, oldD.getDro_app() );
	
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
	
    public List<droits> listeDroits() {
    	List<droits> newListe = new ArrayList();
    	String sql = "SELECT * FROM droits";
    	try {
    		Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sql);
    	    while(res.next()) {
    	    	droits retourne = new droits();
    	    	  retourne.setAll(res.getString(1), res.getString(2), res.getString(3));
    	    	  newListe.add(retourne);
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return newListe;
    }
	
	public droits retourne(String log) {
    	droits retourne = new droits();
    	try {
        	stmt = conn.prepareStatement("SELECT * FROM droits WHERE mdp_log = ?"); 
        	stmt.setString(1,log); 
    	      
    	      ResultSet res = stmt.executeQuery();
    	      while(res.next()) {
    	    	  retourne.setAll(res.getString(1), res.getString(2), res.getString(3));
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return retourne;
    }
	
	public int nbLiensDroits() {
    	int nb = -1;
    	String sql = "SELECT count(*) AS nbMdps FROM droits";
    	
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

	public boolean existe(droits M) {
    	boolean exists = false;
    	
		try {
			stmt = conn.prepareStatement("SELECT * FROM droits WHERE dro_log = ? and dro_app = ?"); 
			stmt.setString(1, M.getDro_log());
			stmt.setString(2, M.getDro_app());
	      
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

