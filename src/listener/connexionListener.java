package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import db.DB_Connection;
import Dao_d.mdpDao;
import Dao_d.acteurDao;
import ihm_d.FicheUtilisateur;
import modele.acteur;
import modele.mdp;

public class connexionListener  implements ActionListener {
	
	private mdp leParam;
	
	public connexionListener(mdp param) {
		leParam = param;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			DB_Connection conn = new DB_Connection();
			Connection laCo = conn.get_connection();
			
			List liste = new ArrayList();
			mdpDao leDao = new mdpDao();
			liste = leDao.listeMdps();
			
			for(int index = 0;index < liste.size();index++) {
				mdp leMdp = (mdp)liste.get(index);
				String liste_login = leMdp.getmdp_log();
				String liste_pass = leMdp.getmdp_pw();
				
				//System.out.println(leMdp.toString());
				
				String param_login = leParam.getmdp_log();
				String param_pass = leParam.getmdp_pw();
				
				if(liste_login.compareTo(param_login) == 0 && liste_pass.compareTo(param_pass) == 0) {
					seConnecter(leParam);
				}
			}
			
			
		} 
		catch(Exception ex) {
			ex.getMessage();
		}
	}
	
	
	public void seConnecter(mdp value) {
		// si tous les champs sont remplis
		try {
			DB_Connection conn = new DB_Connection();
			Connection laCo = conn.get_connection();
			
			mdpDao leDao_mdp = new mdpDao();
			acteurDao leDao_acteur = new acteurDao();
			acteur acteur = new acteur();
			
			if(leDao_acteur.retourne(value.getmdp_log()) != null) {
				acteur = leDao_acteur.retourne(value.getmdp_log());
				FicheUtilisateur index = new FicheUtilisateur(acteur);
			}
			
		} 
		catch(Exception ex) {
			ex.getMessage();
		}
   }
}
