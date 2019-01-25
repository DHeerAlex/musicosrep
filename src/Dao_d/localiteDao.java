package Dao_d;


import java.sql.*;
import java.util.*;

import db.*;
import listener.keyboard;
import modele.localite;

import java.math.*;



public class localiteDao {

	private DB_Connection laCo = new DB_Connection();
	private Connection conn = laCo.get_connection();
	private PreparedStatement stmt = null;
	
	public void ajouter(localite newL) {
    	try {
            String sql = "INSERT INTO localite ( loc_ins, loc_cp, loc_lib) "
            + "VALUES (?, ?, ?) ";
            try {
				stmt = conn.prepareStatement(sql);
           
	            stmt.setString(1, newL.getLoc_ins()); 
	            stmt.setString(2, newL.getLoc_cp()); 
	            stmt.setString(3, newL.getLoc_lib());
	
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

    public void modifier(localite oldL) {
    	try {
            String sql = "UPDATE localite SET loc_cp = ?, loc_lib = ?"
            + " WHERE loc_ins = ?";
            try {
				stmt = conn.prepareStatement(sql);
           
				stmt.setString(1, oldL.getLoc_cp()); 
	            stmt.setString(2, oldL.getLoc_lib());
	            stmt.setString(3, oldL.getLoc_ins()); 
	            
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
    
    public void supprimer(localite oldL) {
    	try {
            String sql = "DELETE FROM localite WHERE loc_ins = ?";
            try {
				stmt = conn.prepareStatement(sql);
           
				stmt.setString(1, oldL.getLoc_ins()); 
	
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
    
    public List<localite> listeVilles() {
    	List<localite> newListe = new ArrayList();
    	String sql = "SELECT * FROM localite";
    	try {
    		Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sql);
    	    while(res.next()) {
    	    	localite retourne = new localite();
    	    	  retourne.setAll(
    	    			  res.getString(1),
    	    			  res.getString(2),
    	    			  res.getString(3)
    	    			  );
    	    	  newListe.add(retourne);
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return newListe;
    }
    
    public localite retourne(String log) {
    	localite retourne = new localite();
    	try {
        	stmt = conn.prepareStatement("SELECT * FROM localite WHERE loc_ins = ?"); 
        	stmt.setString(1,log); 
    	      
    	      ResultSet res = stmt.executeQuery();
    	      while(res.next()) {
    	    	  retourne.setAll(
    	    			  res.getString(1),
    	    			  res.getString(2),
    	    			  res.getString(3)
    	    			  );
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return retourne;
    }
    
    public List<localite> rechercheAuto(String k) {
    	List<localite> newListe = new ArrayList();
    	try {
    		switch(k.length()) {
    		case 1:
    		
    		break;
    		case 2:
        		
        		break;
    		case 3:
        		
        		break;
    		case 4:
        		
        		break;
    		case 5:
        		
        		break;
    		
    		}
    		
    		
    		/*
        	stmt = conn.prepareStatement("SELECT * FROM localite WHERE loc_cp Like \"?%\""); 
        	stmt.setString(1,k);
        	System.out.println(stmt);
    	      ResultSet res = stmt.executeQuery();
    	      while(res.next()) {
    	    	  localite retourne = new localite();
    	    	  retourne.setAll(
    	    			  res.getString(1),
    	    			  res.getString(2),
    	    			  res.getString(3)
    	    			  );
    	    	  newListe.add(retourne);
    	      }
    	      */
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return newListe;
    }
    
    public int nbLocalites() {
    	int nb = -1;
    	String sql = "SELECT count(*) AS nbLocalites FROM localite";
    	
    	try {
        	Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sql);
			  
			  
			if(res.next()) {
				nb = res.getInt("nbLocalites");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
    	
    	return nb;
    }
    
    public boolean existe(localite L) {
    	boolean exists = false;
    	
		try {
			stmt = conn.prepareStatement("SELECT * FROM localite WHERE loc_ins = ?"); 
			stmt.setString(1, L.getLoc_ins()); 
	      
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

