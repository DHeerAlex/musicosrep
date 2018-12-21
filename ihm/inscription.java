package ihm;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class inscription {

	private JFrame frmInscription;
	private JTextField act_nom;
	private JTextField act_pre;
	private JTextField act_mai;
	private JTextPane txtpnEntrezLeMot;
	private JTextPane txtpnMotDePasse;
	private JTextField act_log;
	private JTextField mdp_pw;
	private JTextField mdp_pw1;

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
		txtpnType.setBounds(10, 132, 115, 20);
		frmInscription.getContentPane().add(txtpnType);
		
		JTextPane txtpnCodePostal = new JTextPane();
		txtpnCodePostal.setBackground(Color.LIGHT_GRAY);
		txtpnCodePostal.setText("Code postal");
		txtpnCodePostal.setBounds(10, 101, 115, 20);
		frmInscription.getContentPane().add(txtpnCodePostal);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setBackground(Color.LIGHT_GRAY);
		txtpnEmail.setText("Email");
		txtpnEmail.setBounds(10, 194, 115, 20);
		frmInscription.getContentPane().add(txtpnEmail);
		
		JTextPane txtpnNumeroDeTlphone = new JTextPane();
		txtpnNumeroDeTlphone.setBackground(Color.LIGHT_GRAY);
		txtpnNumeroDeTlphone.setText("Numero de t\u00E9l\u00E9phone");
		txtpnNumeroDeTlphone.setBounds(10, 163, 115, 20);
		frmInscription.getContentPane().add(txtpnNumeroDeTlphone);
		
		act_pre = new JTextField();
		act_pre.setBounds(149, 70, 211, 20);
		frmInscription.getContentPane().add(act_pre);
		act_pre.setColumns(10);
		
		act_mai = new JTextField();
		act_mai.setBounds(149, 194, 211, 20);
		frmInscription.getContentPane().add(act_mai);
		act_mai.setColumns(10);
		
		JTextPane txtpnLogin = new JTextPane();
		txtpnLogin.setBackground(Color.LIGHT_GRAY);
		txtpnLogin.setText("Votre login");
		txtpnLogin.setBounds(10, 225, 115, 20);
		frmInscription.getContentPane().add(txtpnLogin);
		
		txtpnEntrezLeMot = new JTextPane();
		txtpnEntrezLeMot.setBackground(Color.LIGHT_GRAY);
		txtpnEntrezLeMot.setText("Retapez le mot de passe");
		txtpnEntrezLeMot.setBounds(10, 287, 129, 20);
		frmInscription.getContentPane().add(txtpnEntrezLeMot);
		
		txtpnMotDePasse = new JTextPane();
		txtpnMotDePasse.setBackground(Color.LIGHT_GRAY);
		txtpnMotDePasse.setText("Mot de passe");
		txtpnMotDePasse.setBounds(10, 256, 115, 20);
		frmInscription.getContentPane().add(txtpnMotDePasse);
		
		act_log = new JTextField();
		act_log.setBounds(149, 225, 211, 20);
		frmInscription.getContentPane().add(act_log);
		act_log.setColumns(10);
		
		mdp_pw = new JTextField();
		mdp_pw.setBounds(149, 256, 211, 20);
		frmInscription.getContentPane().add(mdp_pw);
		mdp_pw.setColumns(10);
		
		mdp_pw1 = new JTextField();
		mdp_pw1.setBounds(149, 287, 211, 20);
		frmInscription.getContentPane().add(mdp_pw1);
		mdp_pw1.setColumns(10);
		
		JList act_tel = new JList();
		act_tel.setBounds(149, 163, 211, 20);
		frmInscription.getContentPane().add(act_tel);
		
		JComboBox loc_cp = new JComboBox();
		loc_cp.setBounds(149, 101, 211, 20);
		frmInscription.getContentPane().add(loc_cp);
		
		JComboBox ser_lib = new JComboBox();
		ser_lib.setBounds(149, 132, 211, 20);
		frmInscription.getContentPane().add(ser_lib);
		
		JButton btn_valider = new JButton("Valider");
		btn_valider.setBounds(95, 391, 89, 23);
		frmInscription.getContentPane().add(btn_valider);
		
		JButton btn_annuler = new JButton("Annuler");
		btn_annuler.setBounds(231, 391, 89, 23);
		frmInscription.getContentPane().add(btn_annuler);
	}
}
