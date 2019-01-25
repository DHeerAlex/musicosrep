package listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyboard implements KeyListener{
	
	private String cp_1 = null;
	private String cp_2 = null;
	private String cp_3 = null;
	private String cp_4 = null;
	private String cp_5 = null;
	
	// Saisie des touches tapées au clavier
		public void keyPressed(KeyEvent evt) {
			//System.out.println(evt.getKeyChar()+" a été enfoncée");
		}

		public void keyTyped(KeyEvent evt) { 
			//System.out.println(evt.getKeyChar()+" a été pressée");
			String event = "";
			
			event = Character.toString(evt.getKeyChar());
			char eventChar = evt.getKeyChar();
						
			if(cp_1 == null) {
				setCp_1(event);
			} else {
				if(cp_2 == null) {
					setCp_2(event);
				} else {
					if(cp_3 == null) {
						setCp_3(event);
					} else {
						if(cp_4 == null) {
							setCp_4(event);
						} else {
							if(cp_5 == null) {
								setCp_5(event);
							}
						}
					}
				}
			}
			System.out.println(cp_1 + "" + cp_2 + "" + cp_3 + "" + cp_4 + "" + cp_5);
		}

		public void keyReleased(KeyEvent evt) { 
			//System.out.println(evt.getKeyChar()+" a été relevée");
			
		}
		
		public String getCp_1() {
			return cp_1;
		}
		
		public void setCp_1(String newV) {
			cp_1 = newV;
		}
		
		public String getCp_2() {
			return cp_2;
		}
		
		public void setCp_2(String newV) {
			cp_2 = newV;
		}
		
		public String getCp_3() {
			return cp_3;
		}
		
		public void setCp_3(String newV) {
			cp_3 = newV;
		}
		
		public String getCp_4() {
			return cp_4;
		}
		
		public void setCp_4(String newV) {
			cp_4 = newV;
		}
		
		public String getCp_5() {
			return cp_5;
		}
		
		public void setCp_5(String newV) {
			cp_5 = newV;
		}
}
