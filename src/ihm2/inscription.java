package ihm2;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JPanel;

public class inscription {

	private JFrame frmInscription;
	private JTextField act_nom;
	private JTextField act_pre;
	private JTextPane txtpnEntrezLeMot;
	private JTextPane txtpnMotDePasse;
	private JTextField act_log;
	private JTextField mdp_pw;
	private JTextField mdp_pw1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		frmInscription.setBounds(100, 100, 821, 484);
		frmInscription.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInscription.getContentPane().setLayout(null);
		
		act_nom = new JTextField();
		act_nom.setBounds(149, 36, 170, 20);
		frmInscription.getContentPane().add(act_nom);
		act_nom.setColumns(10);
		
		JTextPane txtpnnom = new JTextPane();
		txtpnnom.setBackground(Color.LIGHT_GRAY);
		txtpnnom.setText("Nom:");
		txtpnnom.setBounds(10, 36, 115, 20);
		frmInscription.getContentPane().add(txtpnnom);
		
		JTextPane txtpnPrenom = new JTextPane();
		txtpnPrenom.setBackground(Color.LIGHT_GRAY);
		txtpnPrenom.setText("Prenom:");
		txtpnPrenom.setBounds(10, 70, 115, 20);
		frmInscription.getContentPane().add(txtpnPrenom);
		
		act_pre = new JTextField();
		act_pre.setBounds(149, 70, 170, 20);
		frmInscription.getContentPane().add(act_pre);
		act_pre.setColumns(10);
		
		JTextPane txtpnLogin = new JTextPane();
		txtpnLogin.setBackground(Color.LIGHT_GRAY);
		txtpnLogin.setText("Votre login:");
		txtpnLogin.setBounds(10, 287, 115, 20);
		frmInscription.getContentPane().add(txtpnLogin);
		
		txtpnEntrezLeMot = new JTextPane();
		txtpnEntrezLeMot.setBackground(Color.LIGHT_GRAY);
		txtpnEntrezLeMot.setText("Retapez le mot de passe:");
		txtpnEntrezLeMot.setBounds(10, 349, 129, 20);
		frmInscription.getContentPane().add(txtpnEntrezLeMot);
		
		txtpnMotDePasse = new JTextPane();
		txtpnMotDePasse.setBackground(Color.LIGHT_GRAY);
		txtpnMotDePasse.setText("Mot de passe:");
		txtpnMotDePasse.setBounds(10, 318, 115, 20);
		frmInscription.getContentPane().add(txtpnMotDePasse);
		
		act_log = new JTextField();
		act_log.setBounds(149, 287, 170, 20);
		frmInscription.getContentPane().add(act_log);
		act_log.setColumns(10);
		
		mdp_pw = new JTextField();
		mdp_pw.setBounds(149, 318, 170, 20);
		frmInscription.getContentPane().add(mdp_pw);
		mdp_pw.setColumns(10);
		
		mdp_pw1 = new JTextField();
		mdp_pw1.setBounds(149, 350, 170, 20);
		frmInscription.getContentPane().add(mdp_pw1);
		mdp_pw1.setColumns(10);
		
		JButton btn_valider = new JButton("Valider");
		btn_valider.setBounds(95, 391, 89, 23);
		frmInscription.getContentPane().add(btn_valider);
		
		JButton btn_annuler = new JButton("Annuler");
		btn_annuler.setBounds(230, 391, 89, 23);
		frmInscription.getContentPane().add(btn_annuler);
		
		JTextPane txtpnGroupe = new JTextPane();
		txtpnGroupe.setBackground(Color.LIGHT_GRAY);
		txtpnGroupe.setText("Groupe:");
		txtpnGroupe.setBounds(360, 36, 97, 20);
		frmInscription.getContentPane().add(txtpnGroupe);
		
		JRadioButton rdbtnOui = new JRadioButton("Oui");
		rdbtnOui.setBackground(Color.LIGHT_GRAY);
		rdbtnOui.setBounds(463, 36, 60, 23);
		frmInscription.getContentPane().add(rdbtnOui);
		
		JRadioButton rdbtnNon = new JRadioButton("Non");
		rdbtnNon.setBackground(Color.LIGHT_GRAY);
		rdbtnNon.setBounds(525, 36, 60, 23);
		frmInscription.getContentPane().add(rdbtnNon);
		
		JTextPane txtpnCatgorie = new JTextPane();
		txtpnCatgorie.setBackground(Color.LIGHT_GRAY);
		txtpnCatgorie.setText("Cat\u00E9gorie:");
		txtpnCatgorie.setBounds(360, 70, 97, 20);
		frmInscription.getContentPane().add(txtpnCatgorie);
		
		JTextPane txtpnSiAutre = new JTextPane();
		txtpnSiAutre.setBackground(Color.LIGHT_GRAY);
		txtpnSiAutre.setForeground(Color.BLACK);
		txtpnSiAutre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnSiAutre.setText(" Si autre:");
		txtpnSiAutre.setBounds(397, 101, 60, 20);
		frmInscription.getContentPane().add(txtpnSiAutre);
		
		JTextPane txtpnService = new JTextPane();
		txtpnService.setBackground(Color.LIGHT_GRAY);
		txtpnService.setText("Service:");
		txtpnService.setBounds(360, 132, 97, 20);
		frmInscription.getContentPane().add(txtpnService);
		
		JTextPane txtpnSiAutre_1 = new JTextPane();
		txtpnSiAutre_1.setBackground(Color.LIGHT_GRAY);
		txtpnSiAutre_1.setText("Si autre:");
		txtpnSiAutre_1.setBounds(397, 163, 60, 20);
		frmInscription.getContentPane().add(txtpnSiAutre_1);
		
		textField = new JTextField();
		textField.setBounds(463, 70, 140, 20);
		frmInscription.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(463, 101, 140, 20);
		frmInscription.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(463, 132, 140, 20);
		frmInscription.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(463, 163, 140, 20);
		frmInscription.getContentPane().add(textField_3);
		
		JTextPane txtpnTarifDemand = new JTextPane();
		txtpnTarifDemand.setText("Tarif demand\u00E9:");
		txtpnTarifDemand.setBackground(Color.LIGHT_GRAY);
		txtpnTarifDemand.setBounds(360, 194, 97, 20);
		frmInscription.getContentPane().add(txtpnTarifDemand);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(463, 194, 140, 20);
		frmInscription.getContentPane().add(textField_4);
		
		JRadioButton rdbtnheure = new JRadioButton("/heure");
		rdbtnheure.setBackground(Color.LIGHT_GRAY);
		rdbtnheure.setBounds(651, 194, 65, 23);
		frmInscription.getContentPane().add(rdbtnheure);
		
		JRadioButton rdbtnForfait = new JRadioButton("forfait");
		rdbtnForfait.setBackground(Color.LIGHT_GRAY);
		rdbtnForfait.setBounds(724, 194, 60, 23);
		frmInscription.getContentPane().add(rdbtnForfait);
		
		JPanel panel = new JPanel();
		panel.setBounds(360, 225, 424, 189);
		frmInscription.getContentPane().add(panel);
		
		JTextPane txtpnFonction = new JTextPane();
		txtpnFonction.setText("Fonction:");
		txtpnFonction.setBackground(Color.LIGHT_GRAY);
		txtpnFonction.setBounds(10, 256, 115, 20);
		frmInscription.getContentPane().add(txtpnFonction);
		
		JComboBox ser_lib = new JComboBox();
		ser_lib.setBounds(149, 256, 170, 20);
		frmInscription.getContentPane().add(ser_lib);
		
		JTextPane txtpnMembreDuGroupe = new JTextPane();
		txtpnMembreDuGroupe.setText("Membre du groupe:");
		txtpnMembreDuGroupe.setBackground(Color.LIGHT_GRAY);
		txtpnMembreDuGroupe.setBounds(10, 225, 115, 20);
		frmInscription.getContentPane().add(txtpnMembreDuGroupe);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(149, 225, 170, 20);
		frmInscription.getContentPane().add(comboBox);
		
		JTextPane txtpnNumeroDeTlphone = new JTextPane();
		txtpnNumeroDeTlphone.setText("Numero de t\u00E9l\u00E9phone:");
		txtpnNumeroDeTlphone.setBackground(Color.LIGHT_GRAY);
		txtpnNumeroDeTlphone.setBounds(10, 101, 115, 20);
		frmInscription.getContentPane().add(txtpnNumeroDeTlphone);
		
		JList list = new JList();
		list.setBounds(149, 101, 170, 20);
		frmInscription.getContentPane().add(list);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setText("Email:");
		txtpnEmail.setBackground(Color.LIGHT_GRAY);
		txtpnEmail.setBounds(10, 132, 115, 20);
		frmInscription.getContentPane().add(txtpnEmail);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(149, 132, 170, 20);
		frmInscription.getContentPane().add(textField_5);
		
		JTextPane txtpnCodePostal = new JTextPane();
		txtpnCodePostal.setText("Code postal:");
		txtpnCodePostal.setBackground(Color.LIGHT_GRAY);
		txtpnCodePostal.setBounds(10, 163, 115, 20);
		frmInscription.getContentPane().add(txtpnCodePostal);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(149, 163, 170, 20);
		frmInscription.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(149, 194, 170, 20);
		frmInscription.getContentPane().add(comboBox_2);
		
		JTextPane txtpnLocalit = new JTextPane();
		txtpnLocalit.setText("Localit\u00E9:");
		txtpnLocalit.setBackground(Color.LIGHT_GRAY);
		txtpnLocalit.setBounds(10, 194, 115, 20);
		frmInscription.getContentPane().add(txtpnLocalit);
	}
}
