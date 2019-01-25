package listener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import DAO.DB_Connection;
import Dao_d.acteurDao;
import Dao_d.localiteDao;
import Dao_d.serviceDao;
import modele.acteur;
import modele.localite;
import modele.service;

public class rechercheEvent extends AbstractTableModel{
	private DB_Connection laCo = new DB_Connection();
	private Connection conn = laCo.get_connection();
	private PreparedStatement stmt = null;
	
	private String str_acteur;
	private String str_localite;
	private String str_service;
	
	private acteur acteur;
	private localite localite;
	private service service;
	
	private String[] entetes;
	private List<String[]> donnees;
	private JButton bouton;
	
	public void main(String log,String loc,String serv) {
		setTxt_acteur(log);
		setTxt_loc(loc);
		setTxt_serv(serv);
		acteur = StrToActeur(str_acteur);
		localite = StrToLocalite(str_localite);
		service = StrToService(str_service);
		
		
	}
	
	public String[] entetes() {
		String[] entetes = {"Nom Prénom","Ville Code Postal","Détails"};
		
		return entetes;
	}
	
	public DefaultTableModel faireTableau() {
		// entetes
		
		DefaultTableModel dModele = new DefaultTableModel();
		for(String colonne : entetes()) {
			dModele.addColumn(colonne);
		}
		
		donnees = new ArrayList<String[]>();
		//conditions pour les requetes et les données
		/*
		if(acteur != null) {
			donnees = requeteParActeur(acteur.getAct_log());
		} else if(localite != null) {
			donnees = requeteParVille(localite.getLoc_ins());
		} else if(service != null) {
			donnees = requeteParService(service.getSer_lib());
		} else {
			*/
			donnees = requete();
		//}
		for(String[] ligne : donnees) {
			dModele.addRow(ligne);
		}
		
		return dModele;
	}
	
	public List<String[]> requete() {
		List<String[]> newliste = new ArrayList<String[]>();
		String sql="Select * from musicosrep2.recherche";
		try {
			stmt = conn.prepareStatement(sql);
	           
			ResultSet res = stmt.executeQuery(sql);
    	    while(res.next()) {
    	    	
    	    	String log = res.getString("act_log");
    	    	String prenom = res.getString("act_pre");
    	    	String nom = res.getString("act_nom");
    	    	String ville = res.getString("loc_lib");
    	    	String cp = res.getString("loc_cp");
    	    	
    	    	String[] ligne = {prenom + " " + nom,ville + " " + cp,log};
    	    	
    	    	newliste.add(ligne);
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return newliste; 
	}
	
	public List<String[]> requeteParService(String param) {
		List<String[]> newliste = new ArrayList<String[]>();
		String sql="Select * from recherche where ser_lib Like '?%'";
		try {
			stmt = conn.prepareStatement(sql);
	           
            stmt.setString(1, param);
			ResultSet res = stmt.executeQuery(sql);
    	    while(res.next()) {
    	    	
    	    	String prenom = res.getString("act_pre");
    	    	String nom = res.getString("act_nom");
    	    	String ville = res.getString("loc_lib");
    	    	String cp = res.getString("loc_cp");
    	    	
    	    	String[] ligne = {prenom + " " + nom,ville + " " + cp};
    	    	
    	    	newliste.add(ligne);
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return newliste; 
	}
	
	public List<String[]> requeteParVille(String param) {
		List<String[]> newliste = new ArrayList<String[]>();
		String sql="Select * from recherche where loc_ins Like '?%'";
		try {
			stmt = conn.prepareStatement(sql);
	           
            stmt.setString(1, param);
			ResultSet res = stmt.executeQuery(sql);
    	    while(res.next()) {
    	    	
    	    	String prenom = res.getString("act_pre");
    	    	String nom = res.getString("act_nom");
    	    	String ville = res.getString("loc_lib");
    	    	String cp = res.getString("loc_cp");
    	    	
    	    	String[] ligne = {prenom + " " + nom,ville + " " + cp};
    	    	
    	    	newliste.add(ligne);
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return newliste; 
	}
	
	public List<String[]> requeteParActeur(String param) {
		List<String[]> newliste = new ArrayList<String[]>();
		String sql="Select * from recherche where act_log Like '?%'";
		try {
			stmt = conn.prepareStatement(sql);
	           
            stmt.setString(1, param);
			ResultSet res = stmt.executeQuery(sql);
    	    while(res.next()) {
    	    	
    	    	String prenom = res.getString("act_pre");
    	    	String nom = res.getString("act_nom");
    	    	String ville = res.getString("loc_lib");
    	    	String cp = res.getString("loc_cp");
    	    	
    	    	String[] ligne = {prenom + " " + nom,ville + " " + cp};
    	    	
    	    	newliste.add(ligne);
    	      }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	return newliste; 
	}
	
	public void setTxt_acteur(String log) {
		this.str_acteur = log;
	}
	
	public void setTxt_loc(String loc) {
		this.str_localite = loc;
	}

	public void setTxt_serv(String serv) {
		this.str_service = serv;
	}
	
	public acteur StrToActeur(String log) {
		acteur retourne = new acteur();
		acteurDao leDao = new acteurDao();
		retourne = leDao.retourne(log);
		return retourne;
	}
	
	public localite StrToLocalite(String loc) {
		localite retourne = new localite();
		localiteDao leDao = new localiteDao();
		retourne = leDao.retourne(loc);
		return retourne;		
	}

	public service StrToService(String serv) {
		service retourne = new service();
		serviceDao leDao = new serviceDao();
		retourne = leDao.retourne(serv);
		return retourne;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return donnees.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		entetes = entetes();
		return entetes.length;
	}
	
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
