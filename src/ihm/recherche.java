package ihm;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class recherche {

	private JFrame frmRechercheActeur;
	private JTable table;
	private JTextField idAct;
	private JTextField loc_lib;
	private JTextField ser_lib;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recherche window = new recherche();
					window.frmRechercheActeur.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public recherche() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRechercheActeur = new JFrame();
		frmRechercheActeur.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmRechercheActeur.setTitle("Recherche Acteur");
		frmRechercheActeur.setBounds(100, 100, 632, 546);
		frmRechercheActeur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRechercheActeur.getContentPane().setLayout(null);
		
		JTextPane txtpnNom = new JTextPane();
		txtpnNom.setBackground(Color.LIGHT_GRAY);
		txtpnNom.setText("Nom");
		txtpnNom.setBounds(10, 28, 48, 20);
		frmRechercheActeur.getContentPane().add(txtpnNom);
		
		JTextPane txtpnVille = new JTextPane();
		txtpnVille.setBackground(Color.LIGHT_GRAY);
		txtpnVille.setText("Ville");
		txtpnVille.setBounds(10, 59, 48, 20);
		frmRechercheActeur.getContentPane().add(txtpnVille);
		
		JTextPane txtpnService = new JTextPane();
		txtpnService.setBackground(Color.LIGHT_GRAY);
		txtpnService.setText("Service");
		txtpnService.setBounds(10, 90, 48, 20);
		frmRechercheActeur.getContentPane().add(txtpnService);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setBounds(10, 151, 89, 23);
		frmRechercheActeur.getContentPane().add(btnRechercher);
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.setBounds(109, 151, 89, 23);
		frmRechercheActeur.getContentPane().add(btnEffacer);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setBounds(237, 29, 358, 467);
		frmRechercheActeur.getContentPane().add(table);
		
		idAct = new JTextField();
		idAct.setBounds(81, 28, 86, 20);
		frmRechercheActeur.getContentPane().add(idAct);
		idAct.setColumns(10);
		
		loc_lib = new JTextField();
		loc_lib.setBounds(81, 59, 86, 20);
		frmRechercheActeur.getContentPane().add(loc_lib);
		loc_lib.setColumns(10);
		
		ser_lib = new JTextField();
		ser_lib.setBounds(81, 90, 86, 20);
		frmRechercheActeur.getContentPane().add(ser_lib);
		ser_lib.setColumns(10);
	}
}
