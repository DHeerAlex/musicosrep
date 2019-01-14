package ihm;


import java.awt.EventQueue;
import java.sql.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;

import listener.*;
import modele.mdp;
import DAO.*;

public class connection extends JFrame{

	private JFrame frmConnection;
	private JTextField login;
	private JTextField mot_de_passe;
	private JButton btnInscription;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					connection window = new connection();
					window.frmConnection.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public connection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConnection = new JFrame();
		frmConnection.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmConnection.setTitle("connection");
		frmConnection.setBounds(100, 100, 460, 313);
		frmConnection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConnection.getContentPane().setLayout(null);
		
		login = new JTextField();
		login.setBounds(164, 44, 131, 20);
		frmConnection.getContentPane().add(login);
		login.setColumns(10);
		
		mot_de_passe = new JTextField();
		mot_de_passe.setBounds(164, 75, 131, 20);
		frmConnection.getContentPane().add(mot_de_passe);
		mot_de_passe.setColumns(10);
		
		JButton btnConnection = new JButton("Connexion");
		btnConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String txt_login = login.getText();
					String txt_pass = mot_de_passe.getText();
					String pass_hash = Base64.getEncoder().encodeToString(txt_pass.getBytes());
					mdp param = new mdp();
					param.setAll(txt_login, pass_hash);
					
					ActionEvent a = null;
					connexionListener au = new connexionListener(param);

					au.actionPerformed(a);		
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnConnection.setBounds(164, 106, 131, 23);
		frmConnection.getContentPane().add(btnConnection);
		
		btnInscription = new JButton("Inscription");
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConnection.setVisible(false);
				inscription frm_insc = new inscription();
				frm_insc.main(null);
			}
		});
		btnInscription.setBounds(22, 106, 117, 23);
		frmConnection.getContentPane().add(btnInscription);
		
		JTextPane txtpnLogin = new JTextPane();
		txtpnLogin.setBackground(Color.LIGHT_GRAY);
		txtpnLogin.setText("Login");
		txtpnLogin.setBounds(22, 44, 117, 20);
		txtpnLogin.setEditable(false);
		frmConnection.getContentPane().add(txtpnLogin);
		
		JTextPane txtpnMotDePasse = new JTextPane();
		txtpnMotDePasse.setBackground(Color.LIGHT_GRAY);
		txtpnMotDePasse.setText("Mot de passe");
		txtpnMotDePasse.setBounds(22, 75, 117, 20);
		txtpnMotDePasse.setEditable(false);
		frmConnection.getContentPane().add(txtpnMotDePasse);
	}
}
