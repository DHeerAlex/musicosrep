package Dao_d;



import java.sql.*;
import java.util.*;
import db.*;
import modele.typeacteur;

import java.math.*;




public class typeacteurDao {
	
	private DB_Connection laCo = new DB_Connection();
	private Connection conn = laCo.get_connection();
	private PreparedStatement stmt = null;

	public void ajouter(typeacteur newA) {
    	try {
            String sql = "INSERT INTO typeacteur ( typ_id, typ_lib) "
            + " VALUES (?, ?) ";
            try {
				stmt = conn.prepareStatement(sql);
           
	            stmt.setInt(1, newA.getTyp_id()); 
	            stmt.setString(2, newA.getTyp_lib());
	
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

    public void modifier(typeacteur oldA) {
    	try {
            String sql = "UPDATE typeacteur SET typ_lib = ?"
            + " WHERE typ_id = ?";
            try {
				stmt = conn.prepareStatement(sql);
           
				stmt.setInt(1, oldA.getTyp_id());
	            stmt.setString(2, oldA.getTyp_lib()); 
	            
	
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
    
    public void supprimer(typeacteur oldA) {
    	try {
            String sql = "DELETE FROM typeacteur WHERE typ_id = ?";
            try {
				stmt = conn.prepareStatement(sql);
           
	            stmt.setInt(1, oldA.getTyp_id());
	
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
    
    public List<typeacteur> listeTypes() {
    	List<typeacteur> newListe = new ArrayList();
    	String sql = "SELECT * FROM typeacteur";
    	try {
    		Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sql);
    	    while(res.next()) {
    	    	typeacteur retourne = new typeacteur();
    	    	  retourne.setAll(res.getInt(1), res.getString(2));
    	    	  newListe.add(retourne);
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return newListe;
    }
    
    public typeacteur retourne(int id) {
    	typeacteur retourne = new typeacteur();
    	try {
        	stmt = conn.prepareStatement("SELECT * FROM typeacteur WHERE typ_id = ?"); 
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
    
    public typeacteur retourne(String libelle) {
    	typeacteur retourne = new typeacteur();
    	try {
        	stmt = conn.prepareStatement("SELECT * FROM typeacteur WHERE typ_lib = ?"); 
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
    
    public int nbTypes() {
    	int nb = -1;
    	String sql = "SELECT count(*) AS nbTypes FROM typeacteur";
    	
    	try {
        	Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sql);
			  
			  
			if(res.next()) {
				nb = res.getInt("nbTypes");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
    	
    	return nb;
    }
    
    public boolean existe(typeacteur A) {
    	boolean exists = false;
    	
		try {
			stmt = conn.prepareStatement("SELECT * FROM typeacteur WHERE typ_id = ?"); 
			stmt.setInt(1, A.getTyp_id());
	      
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
