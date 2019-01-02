import modele.*;
import vue.*;
import dao.*;
import control.*;

import java.sql.SQLException;
import java.sql.Statement;


public class lanceur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		DB_Connection db = new DB_Connection();
		Statement stm = db.get_connection();
		}
		catch(Exception es) {
			es.getMessage();
		}
		mdpDao mdp_dao = new mdpDao();
		mdp classeMdp = new mdp();
		
		frm_co fenetreCo = new frm_co();
		
		connexionListener conn_listen = new connexionListener();
		
		conn_listen.setFrame(fenetreCo);
		
		//fenetreCo.addComponentListener();
		//fenetreCo.update(classeMdp, fenetreCo.getConnection());
		
		
	}

}
