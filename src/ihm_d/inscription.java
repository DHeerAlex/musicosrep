package ihm_d;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

import Dao_d.*;
import listener.inscriptionListener;
import modele.*;
import listener.*;

import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Base64;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class inscription {

	private static acteur paramActeur;
	
	private JFrame frmInscription;
	private JTextField act_nom;
	private JTextField act_pre;
	private JTextField act_mai;
	private JLabel txtpnEntrezLeMot;
	private JLabel txtpnMotDePasse;
	private JTextField act_log;
	private JTextField loc_cp;
	private JTextField mdp_pw;
	private JTextField mdp_pw1;
	private JTextField act_tel;
	private JComboBox loc_ville;
	private JComboBox typ_lib;

	/**
	 * Create the application.
	 * @wbp.parser.constructor
	 */
	public inscription() {
		init_insc();
	}
	/**
	 * Create the application
	 * @wbp.parser.constructor
	 */
	public inscription(acteur A) {
		paramActeur = A;
		init_modif();
		afficherInfos();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void init_insc() {
		frmInscription = new JFrame();
		frmInscription.setTitle("Inscription");
		frmInscription.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmInscription.setBounds(100, 100, 557, 484);
		frmInscription.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInscription.getContentPane().setLayout(null);
		
		comboListen comboL = new comboListen();
		
		
		act_nom = new JTextField();
		act_nom.setBounds(180, 36, 211, 20);
		frmInscription.getContentPane().add(act_nom);
		act_nom.setColumns(10);
		
		JLabel txtpnnom = new JLabel();
		txtpnnom.setBackground(Color.LIGHT_GRAY);
		txtpnnom.setText("Nom");
		txtpnnom.setBounds(10, 36, 150, 20);
		frmInscription.getContentPane().add(txtpnnom);
		
		JLabel txtpnPrenom = new JLabel();
		txtpnPrenom.setBackground(Color.LIGHT_GRAY);
		txtpnPrenom.setText("Prenom");
		txtpnPrenom.setBounds(10, 70, 150, 20);
		frmInscription.getContentPane().add(txtpnPrenom);
		
		JLabel txtpnType = new JLabel();
		txtpnType.setBackground(Color.LIGHT_GRAY);
		txtpnType.setText("Fonction");
		txtpnType.setBounds(10, 160, 150, 20);
		frmInscription.getContentPane().add(txtpnType);
		
		JLabel txtpnCodePostal = new JLabel();
		txtpnCodePostal.setBackground(Color.LIGHT_GRAY);
		txtpnCodePostal.setText("Code postal");
		txtpnCodePostal.setBounds(10, 101, 150, 20);
		frmInscription.getContentPane().add(txtpnCodePostal);
		
		JLabel txtpnEmail = new JLabel();
		txtpnEmail.setBackground(Color.LIGHT_GRAY);
		txtpnEmail.setText("Email");
		txtpnEmail.setBounds(10, 222, 150, 20);
		frmInscription.getContentPane().add(txtpnEmail);
		
		JLabel txtpnNumeroDeTlphone = new JLabel();
		txtpnNumeroDeTlphone.setBackground(Color.LIGHT_GRAY);
		txtpnNumeroDeTlphone.setText("Numero de t\u00E9l\u00E9phone");
		txtpnNumeroDeTlphone.setBounds(10, 191, 150, 20);
		frmInscription.getContentPane().add(txtpnNumeroDeTlphone);
		
		act_pre = new JTextField();
		act_pre.setBounds(180, 70, 211, 20);
		frmInscription.getContentPane().add(act_pre);
		act_pre.setColumns(10);
		
		act_mai = new JTextField();
		act_mai.setBounds(180, 222, 211, 20);
		frmInscription.getContentPane().add(act_mai);
		act_mai.setColumns(10);
		
		JLabel txtpnLogin = new JLabel();
		txtpnLogin.setBackground(Color.LIGHT_GRAY);
		txtpnLogin.setText("Votre login");
		txtpnLogin.setBounds(10, 253, 150, 20);
		frmInscription.getContentPane().add(txtpnLogin);
		
		txtpnEntrezLeMot = new JLabel();
		txtpnEntrezLeMot.setBackground(Color.LIGHT_GRAY);
		txtpnEntrezLeMot.setText("Retapez le mot de passe");
		txtpnEntrezLeMot.setBounds(10, 315, 150, 20);
		frmInscription.getContentPane().add(txtpnEntrezLeMot);
		
		txtpnMotDePasse = new JLabel();
		txtpnMotDePasse.setBackground(Color.LIGHT_GRAY);
		txtpnMotDePasse.setText("Mot de passe");
		txtpnMotDePasse.setBounds(10, 284, 150, 20);
		frmInscription.getContentPane().add(txtpnMotDePasse);
		
		act_log = new JTextField();
		act_log.setBounds(180, 253, 211, 20);
		frmInscription.getContentPane().add(act_log);
		act_log.setColumns(10);
		
		mdp_pw = new JTextField();
		mdp_pw.setBounds(180, 284, 211, 20);
		frmInscription.getContentPane().add(mdp_pw);
		mdp_pw.setColumns(10);
		
		mdp_pw1 = new JTextField();
		mdp_pw1.setBounds(180, 315, 211, 20);
		frmInscription.getContentPane().add(mdp_pw1);
		mdp_pw1.setColumns(10);
		
		codeP_listen listener_cp = new codeP_listen();
		
		loc_cp = new JTextField();
		loc_cp.setBounds(180, 101, 211, 20);
		frmInscription.getContentPane().add(loc_cp);
		loc_cp.setColumns(10);
		loc_cp.setName("cp");
		
		loc_ville = new JComboBox();
		
		loc_ville.setMaximumRowCount(3);
		loc_ville.setBounds(180, 129, 211, 20);
		frmInscription.getContentPane().add(loc_ville);
		
		
		
		
		typ_lib = new JComboBox();
		typ_lib.setMaximumRowCount(3);
		comboL.remplir_cbx_types(typ_lib);
		typ_lib.setBounds(180, 160, 211, 20);
		frmInscription.getContentPane().add(typ_lib);
		
		JButton btn_valider = new JButton("Valider");
		btn_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					mdp Mdp1 = new mdp();
					mdp Mdp2 = new mdp();
					acteur Acteur = new acteur();
					typeacteur Type = new typeacteur();
					localite Loc = new localite();
					
					String txt_nom = act_nom.getText();
					String txt_prenom = act_pre.getText();
					String txt_mail = act_mai.getText();
					String txt_tel = act_tel.getText();
					
					String txt_login = act_log.getText();
					String txt_pass = mdp_pw.getText();
					String txt_pass2 = mdp_pw1.getText();
					
					String txt_ville = loc_ville.getSelectedItem().toString();
					String txt_type = typ_lib.getSelectedItem().toString();
					
					Acteur.setAct_log(txt_login);
					Acteur.setAct_nom(txt_nom);
					Acteur.setAct_pre(txt_prenom);
					Acteur.setAct_mai(txt_mail);
					Acteur.setAct_tel(txt_tel);
					
					Mdp1.setmdp_pw(txt_pass);
					Mdp2.setmdp_pw(txt_pass2);
					
					Loc.setLoc_lib(txt_ville);
					Type.setTyp_lib(txt_type);
					
					if(txt_pass != null && txt_pass2 != null) {
						ActionEvent a = null;
						inscriptionListener au = new inscriptionListener(Mdp1, Mdp2, Type, Loc, Acteur);
	
						au.actionPerformed(a);	
					} else {
						JOptionPane.showMessageDialog(frmInscription, "Les mots de passe doivent être saisis", "Mots de passe non saisis", JOptionPane.WARNING_MESSAGE);
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btn_valider.setBounds(95, 391, 89, 23);
		frmInscription.getContentPane().add(btn_valider);
		
		JButton btn_annuler = new JButton("Annuler");
		btn_annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmInscription.setVisible(false);
				connection frm_conn = new connection();
				frm_conn.main(null);
			}
		});
		btn_annuler.setBounds(231, 391, 89, 23);
		frmInscription.getContentPane().add(btn_annuler);
		
		act_tel = new JTextField();
		act_tel.setBounds(180, 191, 211, 20);
		frmInscription.getContentPane().add(act_tel);
		act_tel.setColumns(10);
		
		JLabel txtpn_ville = new JLabel();
		txtpn_ville.setBackground(Color.LIGHT_GRAY);
		txtpn_ville.setText("Ville");
		txtpn_ville.setBounds(10, 132, 150, 20);
		frmInscription.getContentPane().add(txtpn_ville);
		
		JButton btn_actualiser = new JButton("Actualiser");
		btn_actualiser.setName("Actualiser");
		btn_actualiser.setBounds(420, 191, 105, 20);
		frmInscription.getContentPane().add(btn_actualiser);
		
		// action pour le code postal
		listener_cp.action(loc_cp, loc_ville, btn_actualiser);
		
		frmInscription.setVisible(true);
	}
	
	private void init_modif() {
		frmInscription = new JFrame();
		frmInscription.setTitle("Modification");
		frmInscription.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmInscription.setBounds(100, 100, 557, 484);
		frmInscription.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInscription.getContentPane().setLayout(null);
		
		comboListen comboL = new comboListen();
		
		
		act_nom = new JTextField();
		act_nom.setBounds(180, 36, 211, 20);
		frmInscription.getContentPane().add(act_nom);
		act_nom.setColumns(10);
		
		JLabel txtpnnom = new JLabel();
		txtpnnom.setBackground(Color.LIGHT_GRAY);
		txtpnnom.setText("Nom");
		txtpnnom.setBounds(10, 36, 150, 20);
		frmInscription.getContentPane().add(txtpnnom);
		
		JLabel txtpnPrenom = new JLabel();
		txtpnPrenom.setBackground(Color.LIGHT_GRAY);
		txtpnPrenom.setText("Prenom");
		txtpnPrenom.setBounds(10, 70, 150, 20);
		frmInscription.getContentPane().add(txtpnPrenom);
		
		JLabel txtpnType = new JLabel();
		txtpnType.setBackground(Color.LIGHT_GRAY);
		txtpnType.setText("Fonction");
		txtpnType.setBounds(10, 160, 150, 20);
		frmInscription.getContentPane().add(txtpnType);
		
		JLabel txtpnCodePostal = new JLabel();
		txtpnCodePostal.setBackground(Color.LIGHT_GRAY);
		txtpnCodePostal.setText("Code postal");
		txtpnCodePostal.setBounds(10, 101, 150, 20);
		frmInscription.getContentPane().add(txtpnCodePostal);
		
		JLabel txtpnEmail = new JLabel();
		txtpnEmail.setBackground(Color.LIGHT_GRAY);
		txtpnEmail.setText("Email");
		txtpnEmail.setBounds(10, 222, 150, 20);
		frmInscription.getContentPane().add(txtpnEmail);
		
		JLabel txtpnNumeroDeTlphone = new JLabel();
		txtpnNumeroDeTlphone.setBackground(Color.LIGHT_GRAY);
		txtpnNumeroDeTlphone.setText("Numero de t\u00E9l\u00E9phone");
		txtpnNumeroDeTlphone.setBounds(10, 191, 150, 20);
		frmInscription.getContentPane().add(txtpnNumeroDeTlphone);
		
		act_pre = new JTextField();
		act_pre.setBounds(180, 70, 211, 20);
		frmInscription.getContentPane().add(act_pre);
		act_pre.setColumns(10);
		
		act_mai = new JTextField();
		act_mai.setBounds(180, 222, 211, 20);
		frmInscription.getContentPane().add(act_mai);
		act_mai.setColumns(10);
		
		JLabel txtpnLogin = new JLabel();
		txtpnLogin.setBackground(Color.LIGHT_GRAY);
		txtpnLogin.setText("Votre login");
		txtpnLogin.setBounds(10, 253, 150, 20);
		frmInscription.getContentPane().add(txtpnLogin);
		
		txtpnEntrezLeMot = new JLabel();
		txtpnEntrezLeMot.setBackground(Color.LIGHT_GRAY);
		txtpnEntrezLeMot.setText("Retapez le mot de passe");
		txtpnEntrezLeMot.setBounds(10, 315, 150, 20);
		frmInscription.getContentPane().add(txtpnEntrezLeMot);
		
		txtpnMotDePasse = new JLabel();
		txtpnMotDePasse.setBackground(Color.LIGHT_GRAY);
		txtpnMotDePasse.setText("Mot de passe");
		txtpnMotDePasse.setBounds(10, 284, 150, 20);
		frmInscription.getContentPane().add(txtpnMotDePasse);
		
		act_log = new JTextField();
		act_log.setBounds(180, 253, 211, 20);
		act_log.setEditable(false);
		frmInscription.getContentPane().add(act_log);
		act_log.setColumns(10);
		
		mdp_pw = new JTextField();
		mdp_pw.setBounds(180, 284, 211, 20);
		frmInscription.getContentPane().add(mdp_pw);
		mdp_pw.setColumns(10);
		
		codeP_listen listener_cp = new codeP_listen();
		
		loc_cp = new JTextField();
		loc_cp.setBounds(180, 101, 211, 20);
		frmInscription.getContentPane().add(loc_cp);
		loc_cp.setColumns(10);
		loc_cp.setName("cp");
		
		loc_ville = new JComboBox();
		
		loc_ville.setMaximumRowCount(3);
		loc_ville.setBounds(180, 129, 211, 20);
		frmInscription.getContentPane().add(loc_ville);
		
		
		
		
		typ_lib = new JComboBox();
		typ_lib.setMaximumRowCount(3);
		comboL.remplir_cbx_types(typ_lib);
		typ_lib.setBounds(180, 160, 211, 20);
		frmInscription.getContentPane().add(typ_lib);
		
		JButton btn_modifier = new JButton("Modifier");
		btn_modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					mdp Mdp1 = new mdp();
					mdp Mdp2 = new mdp();
					acteur Acteur = new acteur();
					typeacteur Type = new typeacteur();
					localite Loc = new localite();
					
					String txt_nom = act_nom.getText();
					String txt_prenom = act_pre.getText();
					String txt_mail = act_mai.getText();
					String txt_tel = act_tel.getText();
					
					String txt_login = act_log.getText();
					String txt_pass = mdp_pw.getText();
					
					String txt_ville = loc_ville.getSelectedItem().toString();
					String txt_type = typ_lib.getSelectedItem().toString();
					
					Acteur.setAct_log(txt_login);
					Acteur.setAct_nom(txt_nom);
					Acteur.setAct_pre(txt_prenom);
					Acteur.setAct_mai(txt_mail);
					Acteur.setAct_tel(txt_tel);
					
					Mdp1.setmdp_pw(txt_pass);
					Mdp2.setmdp_pw(txt_pass);
					
					Loc.setLoc_lib(txt_ville);
					Type.setTyp_lib(txt_type);
					
					ActionEvent a = null;
					inscriptionListener au = new inscriptionListener(Mdp1, Mdp2, Type, Loc, Acteur);
	
					au.actionPerformed(a);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btn_modifier.setBounds(95, 391, 89, 23);
		frmInscription.getContentPane().add(btn_modifier);
		
		JButton btn_annuler = new JButton("Annuler");
		btn_annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmInscription.setVisible(false);
			}
		});
		btn_annuler.setBounds(231, 391, 89, 23);
		frmInscription.getContentPane().add(btn_annuler);
		
		act_tel = new JTextField();
		act_tel.setBounds(180, 191, 211, 20);
		frmInscription.getContentPane().add(act_tel);
		act_tel.setColumns(10);
		
		JLabel txtpn_ville = new JLabel();
		txtpn_ville.setBackground(Color.LIGHT_GRAY);
		txtpn_ville.setText("Ville");
		txtpn_ville.setBounds(10, 132, 150, 20);
		frmInscription.getContentPane().add(txtpn_ville);
		
		JButton btn_actualiser = new JButton("Actualiser");
		btn_actualiser.setName("Actualiser");
		btn_actualiser.setBounds(420, 191, 105, 20);
		frmInscription.getContentPane().add(btn_actualiser);
		
		// action pour le code postal
		listener_cp.action(loc_cp, loc_ville, btn_actualiser);
		
		frmInscription.setVisible(true);
	}
	
	public void afficherInfos() {
		localiteDao dao_localite = new localiteDao();
		typeacteurDao dao_type = new typeacteurDao();
		mdpDao dao_mdp = new mdpDao();
		mdp mdp = new mdp();
		typeacteur type = new typeacteur();
		localite loc = new localite();
		type = dao_type.retourne(paramActeur.getTyp_id());
		loc = dao_localite.retourne(paramActeur.getLoc_ins());
		mdp = dao_mdp.retourne(paramActeur.getAct_log());
		
		act_pre.setText(paramActeur.getAct_pre());
		act_nom.setText(paramActeur.getAct_nom());
		
		act_tel.setText(paramActeur.getAct_tel());
		act_mai.setText(paramActeur.getAct_mai());
		act_log.setText(paramActeur.getAct_log());
		loc_cp.setText(loc.getLoc_cp());
		
		loc_ville.setSelectedItem(loc.getLoc_lib());
		typ_lib.setSelectedItem(type.getTyp_lib());
		
		byte[] bytes = Base64.getDecoder().decode(mdp.getmdp_pw());
		//String decoder = new String(bytes);
		
		String decoder = mdp.getmdp_pw();
		
		mdp_pw.setText(decoder);
		
		
		
		
	}
}
