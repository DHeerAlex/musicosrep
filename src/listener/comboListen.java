package listener;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import Dao_d.typeacteurDao;
import Dao_d.localiteDao;
import modele.localite;
import modele.typeacteur;


public class comboListen implements ActionListener {
	
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void remplir_cbx_types(JComboBox cbx){
		typeacteurDao leDao = new typeacteurDao();
		List<typeacteur> list = leDao.listeTypes();
		//for(int i=1;i<list.size();i++){
		for(typeacteur type : list){
			cbx.addItem(type.getTyp_lib());
		}
 
	}
	
	public static void remplir_cbx_villes(String valeur,JComboBox cbx){
		localiteDao leDao = new localiteDao();
		System.out.println("code postal :"+valeur);
		
		List<localite> list = leDao.rechercheAuto(valeur);
		for(localite type : list){
			cbx.addItem(type.getLoc_lib());
		}
	}
	
	public static void remplir_cbx_villes(JComboBox cbx){
		localiteDao leDao = new localiteDao();
		List<localite> list = leDao.listeVilles();
		for(localite type : list){
			cbx.addItem(type.getLoc_lib());
		}
	}
	
}
