package listener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class codeP_listen {
	private JTextField champ_txt;
	private JComboBox cbx;
	private JButton btn;
	private btnListener btnListen = new btnListener();
	private comboListen comboL = new comboListen();
	private keyboard clavier = new keyboard();
	
	public void action(JTextField champ,JComboBox combo,JButton bouton) {
		setAll(champ, combo, bouton);
		btn.addMouseListener(btnListen);
		DocListener doc = new DocListener();
		champ_txt.getDocument().addDocumentListener(doc);
		doc.updateData(cbx, comboL, clavier);
		//System.out.println(champ_txt);
	}
	
	public void setAll(JTextField champ,JComboBox combo,JButton bouton) {
		btn = bouton;
		champ_txt = champ;
		cbx = combo;
	}
	
	public class DocListener implements DocumentListener{
		
		public void updateData(JComboBox combo,comboListen comboL,keyboard clavier) {
	        // mise à jour de l'attribut data
			int longueur_max = 5;
			if(champ_txt.getText().isEmpty()) {
				comboL.remplir_cbx_villes(combo);
			} else {
				if(champ_txt.getText().length() <= longueur_max) {
					System.out.println(champ_txt.getText());
					comboL.remplir_cbx_villes(champ_txt.getText(), combo);
				} else {
					System.out.println("trop long");
				}
			}
	    }
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			//System.out.println(e);
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			updateData(cbx, comboL, clavier);
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			updateData(cbx, comboL, clavier);
		}
		
	}
}
