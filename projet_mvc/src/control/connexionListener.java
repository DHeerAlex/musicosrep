package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.frm_co;
import modele.mdp;
import dao.mdpDao;

public class connexionListener implements ActionListener {
	private frm_co laFrame;
	
	public void setFrame(frm_co newFrame) {
		laFrame = newFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//laFrame = frame();
		System.out.println(e.getSource());
		
		try {
			System.out.println(laFrame);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		// si la source du bouton vient de l'application 'Connexion'
		if(e.getSource() == "Connection") {
			System.out.println("ok");
			seConnecter(); 
		}
		
	}
	
	public void seConnecter() {
		// si tous les champs sont remplis
		System.out.println("connexion");
		
   }
}
