package ihm_d;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumn;

import listener.rechercheEvent;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class recherche {

	private JFrame frmRechercheActeur;
	private static JTable table;
	private static JTextField idAct;
	private static JTextField loc_lib;
	private static JTextField ser_lib;
	private static rechercheEvent RE = new rechercheEvent();

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
		frmRechercheActeur.setBounds(750, 250, 800, 546);
		frmRechercheActeur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRechercheActeur.getContentPane().setLayout(null);
		
		JTextPane txtpnNom = new JTextPane();
		txtpnNom.setEditable(false);
		txtpnNom.setBackground(Color.LIGHT_GRAY);
		txtpnNom.setText("Nom");
		txtpnNom.setBounds(10, 28, 48, 20);
		frmRechercheActeur.getContentPane().add(txtpnNom);
		
		JTextPane txtpnVille = new JTextPane();
		txtpnVille.setEditable(false);
		txtpnVille.setBackground(Color.LIGHT_GRAY);
		txtpnVille.setText("Ville");
		txtpnVille.setBounds(10, 59, 48, 20);
		frmRechercheActeur.getContentPane().add(txtpnVille);
		
		JTextPane txtpnService = new JTextPane();
		txtpnService.setEditable(false);
		txtpnService.setBackground(Color.LIGHT_GRAY);
		txtpnService.setText("Service");
		txtpnService.setBounds(10, 90, 48, 20);
		frmRechercheActeur.getContentPane().add(txtpnService);
		
		
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				effacer();
			}
		});
		btnEffacer.setBounds(138, 151, 89, 23);
		frmRechercheActeur.getContentPane().add(btnEffacer);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setBounds(237, 29, 540, 467);
		frmRechercheActeur.getContentPane().add(table);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rechercher();
			}
		});
		btnRechercher.setBounds(10, 151, 118, 23);
		frmRechercheActeur.getContentPane().add(btnRechercher);
		
		//idAct = act_nom
		idAct = new JTextField();
		idAct.setBounds(81, 28, 146, 20);
		frmRechercheActeur.getContentPane().add(idAct);
		idAct.setColumns(10);
		
		loc_lib = new JTextField();
		loc_lib.setBounds(81, 59, 146, 20);
		frmRechercheActeur.getContentPane().add(loc_lib);
		loc_lib.setColumns(10);
		
		ser_lib = new JTextField();
		ser_lib.setBounds(81, 90, 146, 20);
		frmRechercheActeur.getContentPane().add(ser_lib);
		ser_lib.setColumns(10);
	}
	
	public static void effacer() {
		idAct.setText(null);
		loc_lib.setText(null);
		ser_lib.setText(null);
		table.clearSelection();
	}
	
	public static void rechercher() {
		RE.main(idAct.getText(), loc_lib.getText(), ser_lib.getText());
		table.setModel(RE.faireTableau());
		table.getColumnModel().getColumn(0).setMinWidth(220);
		table.getColumnModel().getColumn(1).setMinWidth(220);
		table.setAutoResizeMode(table.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(25);
		
		for(int ligne = 0; ligne < table.getRowCount();ligne++) {
			JButton btn_details = new JButton("Détails");
			String log = table.getModel().getValueAt(ligne, 2).toString();
			//btn_details.setText(RE.getValueAt(ligne, 3).toString());
			System.out.println("log "+log);
			
			
			
		}
		
		
		
		
	}
	
}
