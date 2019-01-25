package ihm2;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;

public class connection {

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
		frmConnection.setBounds(100, 100, 346, 243);
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
			}
		});
		btnConnection.setBounds(164, 106, 89, 23);
		frmConnection.getContentPane().add(btnConnection);
		
		btnInscription = new JButton("inscription");
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInscription.setBounds(22, 106, 89, 23);
		frmConnection.getContentPane().add(btnInscription);
		
		JTextPane txtpnLogin = new JTextPane();
		txtpnLogin.setBackground(Color.LIGHT_GRAY);
		txtpnLogin.setText("Login");
		txtpnLogin.setBounds(22, 44, 70, 20);
		frmConnection.getContentPane().add(txtpnLogin);
		
		JTextPane txtpnMotDePasse = new JTextPane();
		txtpnMotDePasse.setBackground(Color.LIGHT_GRAY);
		txtpnMotDePasse.setText("Mot de passe");
		txtpnMotDePasse.setBounds(22, 75, 70, 20);
		frmConnection.getContentPane().add(txtpnMotDePasse);
	}
}
