package ihm;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

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

public class inscription {

	private JFrame frmInscription;
	private JTextField act_nom;
	private JTextField act_pre;
	private JTextField act_mai;
	private JTextPane txtpnEntrezLeMot;
	private JTextPane txtpnMotDePasse;
	private JTextField act_log;
	private JTextField loc_cp;
	private JTextField mdp_pw;
	private JTextField mdp_pw1;
	private JTextField act_tel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inscription window = new inscription();
					window.frmInscription.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public inscription() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInscription = new JFrame();
		frmInscription.setTitle("Inscription");
		frmInscription.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmInscription.setBounds(100, 100, 430, 484);
		frmInscription.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInscription.getContentPane().setLayout(null);
		
		comboListen comboL = new comboListen();
		
		
		act_nom = new JTextField();
		act_nom.setBounds(149, 36, 211, 20);
		frmInscription.getContentPane().add(act_nom);
		act_nom.setColumns(10);
		
		JTextPane txtpnnom = new JTextPane();
		txtpnnom.setBackground(Color.LIGHT_GRAY);
		txtpnnom.setText("Nom");
		txtpnnom.setBounds(10, 36, 115, 20);
		frmInscription.getContentPane().add(txtpnnom);
		
		JTextPane txtpnPrenom = new JTextPane();
		txtpnPrenom.setBackground(Color.LIGHT_GRAY);
		txtpnPrenom.setText("Prenom");
		txtpnPrenom.setBounds(10, 70, 115, 20);
		frmInscription.getContentPane().add(txtpnPrenom);
		
		JTextPane txtpnType = new JTextPane();
		txtpnType.setBackground(Color.LIGHT_GRAY);
		txtpnType.setText("Fonction");
		txtpnType.setBounds(10, 160, 115, 20);
		frmInscription.getContentPane().add(txtpnType);
		
		JTextPane txtpnCodePostal = new JTextPane();
		txtpnCodePostal.setBackground(Color.LIGHT_GRAY);
		txtpnCodePostal.setText("Code postal");
		txtpnCodePostal.setBounds(10, 101, 115, 20);
		frmInscription.getContentPane().add(txtpnCodePostal);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setBackground(Color.LIGHT_GRAY);
		txtpnEmail.setText("Email");
		txtpnEmail.setBounds(10, 222, 115, 20);
		frmInscription.getContentPane().add(txtpnEmail);
		
		JTextPane txtpnNumeroDeTlphone = new JTextPane();
		txtpnNumeroDeTlphone.setBackground(Color.LIGHT_GRAY);
		txtpnNumeroDeTlphone.setText("Numero de t\u00E9l\u00E9phone");
		txtpnNumeroDeTlphone.setBounds(10, 191, 115, 20);
		frmInscription.getContentPane().add(txtpnNumeroDeTlphone);
		
		act_pre = new JTextField();
		act_pre.setBounds(149, 70, 211, 20);
		frmInscription.getContentPane().add(act_pre);
		act_pre.setColumns(10);
		
		act_mai = new JTextField();
		act_mai.setBounds(149, 222, 211, 20);
		frmInscription.getContentPane().add(act_mai);
		act_mai.setColumns(10);
		
		JTextPane txtpnLogin = new JTextPane();
		txtpnLogin.setBackground(Color.LIGHT_GRAY);
		txtpnLogin.setText("Votre login");
		txtpnLogin.setBounds(10, 253, 115, 20);
		frmInscription.getContentPane().add(txtpnLogin);
		
		txtpnEntrezLeMot = new JTextPane();
		txtpnEntrezLeMot.setBackground(Color.LIGHT_GRAY);
		txtpnEntrezLeMot.setText("Retapez le mot de passe");
		txtpnEntrezLeMot.setBounds(10, 315, 129, 20);
		frmInscription.getContentPane().add(txtpnEntrezLeMot);
		
		txtpnMotDePasse = new JTextPane();
		txtpnMotDePasse.setBackground(Color.LIGHT_GRAY);
		txtpnMotDePasse.setText("Mot de passe");
		txtpnMotDePasse.setBounds(10, 284, 115, 20);
		frmInscription.getContentPane().add(txtpnMotDePasse);
		
		act_log = new JTextField();
		act_log.setBounds(149, 253, 211, 20);
		frmInscription.getContentPane().add(act_log);
		act_log.setColumns(10);
		
		mdp_pw = new JTextField();
		mdp_pw.setBounds(149, 284, 211, 20);
		frmInscription.getContentPane().add(mdp_pw);
		mdp_pw.setColumns(10);
		
		mdp_pw1 = new JTextField();
		mdp_pw1.setBounds(149, 315, 211, 20);
		frmInscription.getContentPane().add(mdp_pw1);
		mdp_pw1.setColumns(10);
		
		keyboard action = new keyboard();
		
		loc_cp = new JTextField();
		loc_cp.setBounds(149, 101, 211, 20);
		frmInscription.getContentPane().add(loc_cp);
		loc_cp.setColumns(10);
		
		loc_cp.addKeyListener(action);
		
		JComboBox loc_ville = new JComboBox();
		comboL.remplir_cbx_villes(loc_ville);
		loc_ville.setMaximumRowCount(3);
		loc_ville.setBounds(149, 129, 211, 20);
		frmInscription.getContentPane().add(loc_ville);
		
		
		
		JComboBox typ_lib = new JComboBox();
		typ_lib.setMaximumRowCount(3);
		comboL.remplir_cbx_types(typ_lib);
		typ_lib.setBounds(149, 160, 211, 20);
		frmInscription.getContentPane().add(typ_lib);
		
		JButton btn_valider = new JButton("Valider");
		btn_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String txt_nom = act_nom.getText();
					String txt_prenom = act_pre.getText();
					String txt_mail = act_mai.getText();
					String txt_tel = act_tel.getText();
					
					String txt_login = act_log.getText();
					String txt_pass = mdp_pw.getText();
					String txt_pass2 = mdp_pw1.getText();
					String txt_ville = loc_ville.getSelectedItem().toString();
					String txt_type = typ_lib.getSelectedItem().toString();
					
					typeacteur leType = new typeacteur();
					typeacteurDao leTypeDao = new typeacteurDao();
					
					leType = leTypeDao.retourne(txt_type);
					
					System.out.println("nom : "+txt_nom+" - prenom : "+txt_prenom+" - mail : "+txt_mail);
					System.out.println("tel : "+txt_tel);
					
					System.out.println("login : "+txt_login);
					System.out.println("ville : "+txt_ville+" - type : "+txt_type);
					
					/*
					String pass_hash = Base64.getEncoder().encodeToString(txt_pass.getBytes());
					String pass2_hash = Base64.getEncoder().encodeToString(txt_pass2.getBytes());
					
					mdp param = new mdp();
					if(pass_hash == pass2_hash && txt_pass == txt_pass2) {
						
						param.setAll(txt_login, pass_hash);
						
						ActionEvent a = null;
						inscriptionListener au = new inscriptionListener(param);
	
						au.actionPerformed(a);	
					} else {
						JOptionPane.showMessageDialog(frmInscription, "Les mots de passe doivent correspondre", "Mots de passe non identique", JOptionPane.WARNING_MESSAGE);
					}
					*/
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
				frm_conn.setVisible(true);
			}
		});
		btn_annuler.setBounds(231, 391, 89, 23);
		frmInscription.getContentPane().add(btn_annuler);
		
		act_tel = new JTextField();
		act_tel.setBounds(149, 191, 211, 20);
		frmInscription.getContentPane().add(act_tel);
		act_tel.setColumns(10);
		
		JTextPane txtpn_ville = new JTextPane();
		txtpn_ville.setBackground(Color.LIGHT_GRAY);
		txtpn_ville.setText("Ville");
		txtpn_ville.setBounds(10, 132, 81, 20);
		frmInscription.getContentPane().add(txtpn_ville);
	}
}
