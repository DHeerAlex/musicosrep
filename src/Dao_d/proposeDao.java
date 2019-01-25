package Dao_d;



import java.sql.*;
import java.util.*;

import db.*;
import modele.propose;

import java.math.*;



public class proposeDao {

	private DB_Connection laCo = new DB_Connection();
	private Connection conn = laCo.get_connection();
	private PreparedStatement stmt = null;
	
	public void ajouter(propose newP) {
    	try {
            String sql = "INSERT INTO propose ( ser_id, act_log, pro_tar, pro_typ) VALUES (?, ?, ?, ?) ";
            try {
				stmt = conn.prepareStatement(sql);
           
	            stmt.setInt(1, newP.getSer_id()); 
	            stmt.setString(2, newP.getAct_log());
	            stmt.setBigDecimal(3, newP.getPro_tar());
	            stmt.setString(4, newP.getPro_typ());
	
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
	
	public void modifier(propose oldP) {
    	try {
            String sql = "UPDATE propose SET pro_tar = ?, pro_typ = ? WHERE (ser_id = ? and act_log = ?) ";
            try {
				stmt = conn.prepareStatement(sql);
           
				stmt.setInt(3, oldP.getSer_id()); 
	            stmt.setString(4, oldP.getAct_log());
	            stmt.setBigDecimal(1, oldP.getPro_tar());
	            stmt.setString(2, oldP.getPro_typ());
	            
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
	
	public void supprimer(propose oldP) {
    	try {
            String sql = "DELETE FROM propose WHERE (ser_id = ? and act_log = ?) ";
            try {
				stmt = conn.prepareStatement(sql);
           
				stmt.setInt(1, oldP.getSer_id()); 
	            stmt.setString(2, oldP.getAct_log());
	
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
	
    public List<propose> listeProposes() {
    	List<propose> newListe = new ArrayList();
    	String sql = "SELECT * FROM propose";
    	try {
    		Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sql);
    	    while(res.next()) {
    	    	propose retourne = new propose();
    	    	retourne.setAll(res.getInt(1), res.getString(2), res.getBigDecimal(3), res.getString(4));
    	    	  newListe.add(retourne);
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return newListe;
    }
	
	public propose retourne(int ser_id) {
    	propose retourne = new propose();
    	try {
        	stmt = conn.prepareStatement("SELECT * FROM propose WHERE ser_id = ?"); 
        	stmt.setInt(1,ser_id); 
    	      
    	      ResultSet res = stmt.executeQuery();
    	      while(res.next()) {
    	    	  retourne.setAll(res.getInt(1), res.getString(2), res.getBigDecimal(3), res.getString(4));
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return retourne;
    }

	public propose retourne(String act_log) {
    	propose retourne = new propose();
    	try {
        	stmt = conn.prepareStatement("SELECT * FROM propose WHERE act_log = ?"); 
        	stmt.setString(1,act_log); 
    	      
    	      ResultSet res = stmt.executeQuery();
    	      while(res.next()) {
    	    	  retourne.setAll(res.getInt(1), res.getString(2), res.getBigDecimal(3), res.getString(4));
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return retourne;
    }
	
	public propose retourne(int ser_id, String act_log) {
    	propose retourne = new propose();
    	try {
        	stmt = conn.prepareStatement("SELECT * FROM propose WHERE ser_id = ? and act_log = ?"); 
        	stmt.setInt(1,ser_id); 
        	stmt.setString(2,act_log); 
    	      
    	      ResultSet res = stmt.executeQuery();
    	      while(res.next()) {
    	    	  retourne.setAll(res.getInt(1), res.getString(2), res.getBigDecimal(3), res.getString(4));
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return retourne;
    }
	
	public int nbProposes() {
    	int nb = -1;
    	String sql = "SELECT count(*) AS nbproposes FROM propose";
    	
    	try {
        	Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sql);
			  
			  
			if(res.next()) {
				nb = res.getInt("nbproposes");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
    	
    	return nb;
    }

	public boolean existe(propose S) {
    	boolean exists = false;
    	
		try {
			stmt = conn.prepareStatement("SELECT * FROM propose WHERE ser_id = ?"); 
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
