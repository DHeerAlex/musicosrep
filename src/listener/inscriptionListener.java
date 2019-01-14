package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import DAO.DB_Connection;
import DAO.mdpDao;
import modele.*;

public class inscriptionListener implements ActionListener {
	private mdp paramMdp1;
	private mdp paramMdp2;
	private acteur paramActeur;
	private typeacteur paramType;
	private localite paramLoc;
	
	
	public inscriptionListener(mdp m1,mdp m2,typeacteur t,localite l,acteur a) {
		paramMdp1 = m1;
		paramMdp2 = m2;
		paramType = t;
		paramLoc = l;
		paramActeur = a;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// si la source du bouton vient de l'application 'Inscription'
		try {
			String txt_nom = paramActeur.getAct_nom();
			String txt_prenom = paramActeur.getAct_pre();
			String txt_mail = paramActeur.getAct_mai();
			String txt_tel = paramActeur.getAct_tel();
			String txt_grp = paramActeur.getAct_grp();
			String txt_login = paramActeur.getAct_log();
			String txt_pass = paramMdp1.getmdp_pw();
			String txt_pass2 = paramMdp2.getmdp_pw();
			String txt_ville = paramLoc.getLoc_lib();
			String txt_type = paramType.getTyp_lib();
			
			DB_Connection conn = new DB_Connection();
			Connection laCo = conn.get_connection();
			
		} 
		catch(Exception ex) {
			ex.getMessage();
		}
		//if(e.getSource() == application) {
			Inscrire(); 
		//}
		
		
	}
	
	private void Inscrire() {
		// si tous les champs sont remplis
		
		System.out.println("inscription");
   }
}
