package listener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class focusListen implements FocusListener{

	private keyboard clavier;
	
	
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().toString() == "cp") {
		System.out.println("oui "+e.getSource().toString());
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

}
