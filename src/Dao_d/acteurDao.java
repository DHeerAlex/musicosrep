package Dao_d;



import java.sql.*;
import java.util.*;

import db.*;
import modele.acteur;

import java.math.*;




public class acteurDao {

	private DB_Connection laCo = new DB_Connection();
	private Connection conn = laCo.get_connection();
	private PreparedStatement stmt = null;
	
	
    public void ajouter(acteur newA) {
    	try {
            String sql = "INSERT INTO acteur ( act_log, act_nom, act_pre, "
            + "act_tel, act_mai, act_pho, "
            + "act_grp, act_ok, loc_ins, "
            + "typ_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            try {
				stmt = conn.prepareStatement(sql);
           
	            stmt.setString(1, newA.getAct_log()); 
	            stmt.setString(2, newA.getAct_nom()); 
	            stmt.setString(3, newA.getAct_pre()); 
	            stmt.setString(4, newA.getAct_tel()); 
	            stmt.setString(5, newA.getAct_mai()); 
	            stmt.setString(6, newA.getAct_pho()); 
	            stmt.setString(7, newA.getAct_grp()); 
	            stmt.setInt(8, newA.getAct_ok()); 
	            stmt.setString(9, newA.getLoc_ins()); 
	            stmt.setInt(10, newA.getTyp_id()); 
	
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

    public void modifier(acteur oldA) {
    	try {
            String sql = "UPDATE acteur SET act_nom = ?, act_pre = ?, "
            + "act_tel = ?, act_mai = ?, act_pho = ?, "
            + "act_grp = ?, act_ok = ?, loc_ins = ?, "
            + "typ_id = ? WHERE act_log = ?";
            try {
				stmt = conn.prepareStatement(sql);
           
	            stmt.setString(10, oldA.getAct_log()); 
	            stmt.setString(1, oldA.getAct_nom()); 
	            stmt.setString(2, oldA.getAct_pre()); 
	            stmt.setString(3, oldA.getAct_tel()); 
	            stmt.setString(4, oldA.getAct_mai()); 
	            stmt.setString(5, oldA.getAct_pho()); 
	            stmt.setString(6, oldA.getAct_grp()); 
	            stmt.setInt(7, oldA.getAct_ok()); 
	            stmt.setString(8, oldA.getLoc_ins()); 
	            stmt.setInt(9, oldA.getTyp_id());
	
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
    
    public void supprimer(acteur oldA) {
    	try {
            String sql = "DELETE FROM acteur WHERE act_log = ?";
            try {
				stmt = conn.prepareStatement(sql);
           
	            stmt.setString(1, oldA.getAct_log());
	
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
    
    public List<acteur> listeActeurs() {
    	List<acteur> newListe = new ArrayList();
    	String sql = "SELECT * FROM acteur";
    	try {
    		Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sql);
    	    while(res.next()) {
    	    	acteur retourne = new acteur();
    	    	  retourne.setAll(
    	    			  res.getString(1),
    	    			  res.getString(2),
    	    			  res.getString(3),
    	    			  res.getString(4),
    	    			  res.getString(5),
    	    			  res.getString(6),
    	    			  res.getString(7),
    	    			  res.getInt(8),
    	    			  res.getString(9),
    	    			  res.getInt(10));
    	    	  newListe.add(retourne);
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return newListe;
    }
    
    public acteur retourne(String log) {
    	acteur retourne = new acteur();
    	try {
        	stmt = conn.prepareStatement("SELECT * FROM acteur WHERE act_log = ?"); 
        	stmt.setString(1,log); 
    	      
    	      ResultSet res = stmt.executeQuery();
    	      while(res.next()) {
    	    	  retourne.setAll(
    	    			  res.getString(1),
    	    			  res.getString(2),
    	    			  res.getString(3),
    	    			  res.getString(4),
    	    			  res.getString(5),
    	    			  res.getString(6),
    	    			  res.getString(7),
    	    			  res.getInt(8),
    	    			  res.getString(9),
    	    			  res.getInt(10));
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return retourne;
    }
    
    public int nbActeurs() {
    	int nb = -1;
    	String sql = "SELECT count(*) AS nbActeurs FROM acteur";
    	
    	try {
        	Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sql);
			  
			  
			if(res.next()) {
				nb = res.getInt("nbActeurs");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
    	
    	return nb;
    }
    
    public boolean existe(acteur A) {
    	boolean exists = false;
    	
		try {
			stmt = conn.prepareStatement("SELECT * FROM acteur WHERE act_log = ?"); 
			stmt.setString(1,A.getAct_log()); 
	      
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
