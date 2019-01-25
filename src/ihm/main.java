package ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import modele.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao_d.localiteDao;
import Dao_d.typeacteurDao;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main extends JFrame {
	
	private JFrame frmMain;
	private static acteur paramActeur;
	private JPanel contentPane;
	private JTextField txt_prenom;
	private JTextField txt_nom;
	private JTextField txt_ville;
	private JTextField txt_type;

	/**
	 * Create the frame.
	 */
	
	public void initialiser() {
		frmMain = new JFrame();
		frmMain.getContentPane().setEnabled(false);
		frmMain.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmMain.setTitle("Principale");
		frmMain.setBounds(100, 100, 460, 313);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.getContentPane().setLayout(null);
		
		
		
		JLabel lbl_prenom = new JLabel("Pr\u00E9nom :");
		lbl_prenom.setBounds(10, 26, 57, 17);
		frmMain.getContentPane().add(lbl_prenom);
		lbl_prenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lbl_nom = new JLabel("Nom :");
		lbl_nom.setBounds(10, 45, 38, 17);
		frmMain.getContentPane().add(lbl_nom);
		lbl_nom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lbl_localite = new JLabel("Localit\u00E9 :");
		lbl_localite.setBounds(10, 65, 54, 17);
		frmMain.getContentPane().add(lbl_localite);
		lbl_localite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lbl_type = new JLabel("Type :");
		lbl_type.setBounds(10, 86, 40, 17);
		frmMain.getContentPane().add(lbl_type);
		lbl_type.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_prenom = new JTextField();
		txt_prenom.setBounds(92, 26, 126, 20);
		frmMain.getContentPane().add(txt_prenom);
		txt_prenom.setEditable(false);
		txt_prenom.setColumns(15);
		lbl_prenom.setLabelFor(txt_prenom);
		
		txt_nom = new JTextField();
		txt_nom.setBounds(93, 48, 126, 20);
		frmMain.getContentPane().add(txt_nom);
		txt_nom.setEditable(false);
		txt_nom.setColumns(15);
		lbl_nom.setLabelFor(txt_nom);
		
		txt_ville = new JTextField();
		txt_ville.setBounds(93, 70, 126, 20);
		frmMain.getContentPane().add(txt_ville);
		txt_ville.setEditable(false);
		txt_ville.setColumns(15);
		lbl_localite.setLabelFor(txt_ville);
		
		txt_type = new JTextField();
		txt_type.setBounds(91, 90, 126, 20);
		frmMain.getContentPane().add(txt_type);
		txt_type.setEditable(false);
		txt_type.setColumns(15);
		lbl_type.setLabelFor(txt_type);
		
		JButton btnDconnection = new JButton("D\u00E9connection");
		btnDconnection.setBounds(309, 0, 125, 23);
		frmMain.getContentPane().add(btnDconnection);
		
		JButton btnModification = new JButton("Modification");
		btnModification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inscription frmModif = new inscription(paramActeur);
			}
		});
		btnModification.setBounds(174, 0, 125, 23);
		frmMain.getContentPane().add(btnModification);
		
		JButton btn_rech = new JButton("Rechercher");
		btn_rech.setBounds(309, 240, 125, 23);
		frmMain.getContentPane().add(btn_rech);
		
		afficherInfos();
		choixPanel();
		frmMain.setVisible(true);
	}
	
	public main(acteur a) {
		setParam(a);
		initialiser();
	}
	
	public static void choixPanel() {
		String[] typesAdmin = {"secrétaire","",""};
		List<String> listeTypes = new ArrayList<String>(Arrays.asList(typesAdmin));
		
		typeacteur type = new typeacteur();
		typeacteurDao typeDao = new typeacteurDao();
		type = typeDao.retourne(paramActeur.getTyp_id());
		if(listeTypes.contains(type) == true) {
			System.out.println("Admin");
		} else {
			System.out.println("Autres");
		}
		
		
	}
	
	public void panelAdmin() {
		
	}
	
	public void panelUser() {
		
	}
	
	public static void setParam(acteur param) {
		paramActeur = param;
	}

	public void afficherInfos() {
		txt_prenom.setText(paramActeur.getAct_pre());
		txt_nom.setText(paramActeur.getAct_nom());
		localiteDao dao_localite = new localiteDao();
		typeacteurDao dao_type = new typeacteurDao();
		typeacteur type = new typeacteur();
		localite loc = new localite();
		type = dao_type.retourne(paramActeur.getTyp_id());
		loc = dao_localite.retourne(paramActeur.getLoc_ins());
		
		txt_ville.setText(loc.getLoc_lib());
		txt_type.setText(type.getTyp_lib());
	}
}
