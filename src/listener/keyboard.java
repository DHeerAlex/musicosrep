package listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyboard implements KeyListener{
	
	private String chaine;
	
	// Saisie des touches tap�es au clavier
		public void keyPressed(KeyEvent evt) {
			//System.out.println(evt.getKeyChar()+" a �t� enfonc�e");
			
		}

		public void keyTyped(KeyEvent evt) { 
			//System.out.println(evt.getKeyChar()+" a �t� press�e");
			
		}

		public void keyReleased(KeyEvent evt) { 
			//System.out.println(evt.getKeyChar()+" a �t� relev�e");
			String event = "";
			String lettre = "";
			
			event = Character.toString(evt.getKeyChar());
			char eventChar = evt.getKeyChar();
			
			System.out.println("event "+event);
			
			lettre = event;
			/*
			System.out.println();
			System.out.println("lettre = event");
			System.out.println();
			*/
			//System.out.println("lettre "+lettre);
			//System.out.println("event "+event);
			
			setString(lettre);
			if(getString() == lettre) {
				System.out.println("oui");
				
			} else {
				System.out.println("non");
			}
			//concatener(lettre);
			/*
			System.out.println();
			System.out.println("chaine = chaine.concat(lettre);");
			System.out.println();
			
			*/
			System.out.println(chaine);
			
			
		}
		
		public String getString() {
			return chaine;
		}
		
		public void setString(String newV) {
			chaine = newV;
		}
		
		public void concatener(String newV) {
			chaine = chaine.concat(newV);
		}
}
