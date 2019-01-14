package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import DAO.*;
import modele.localite;


public class actions implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public static List<localite> getList_localisation(){
		try{
			List newListe = new ArrayList();
			DB_Connection conn = new DB_Connection();
			Connection laCo = conn.get_connection();
			List liste = new ArrayList();
			localiteDao leDao = new localiteDao();
			liste = leDao.loadAll(laCo);
			for(int id = 0; id < liste.size(); id++) {
				localite ville = (localite) liste.get(id);
				
				System.out.println(ville.getLoc_cp());
				System.out.println(ville.getLoc_lib());
				System.out.println(ville.getLoc_ins());
			}
			
			
			
			
			//return liste;
		}catch (Exception e){
			e.getMessage();
		}
 
		return null;
	}
}
