package ihm_d;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import modele.acteur;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;

public class gestion_droits {

	private acteur param;
	private JFrame frmGestionDesDroits;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestion_droits window = new gestion_droits();
					window.frmGestionDesDroits.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gestion_droits() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDesDroits = new JFrame();
		frmGestionDesDroits.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmGestionDesDroits.setTitle("Gestion des droits");
		frmGestionDesDroits.setBounds(100, 100, 450, 300);
		frmGestionDesDroits.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextPane txtpnIdentifiant = new JTextPane();
		txtpnIdentifiant.setBackground(Color.LIGHT_GRAY);
		txtpnIdentifiant.setText("Identifiant:");
		txtpnIdentifiant.setEditable(false);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnRechercher = new JButton("Rechercher");
		
		JTextPane txtpnEcran = new JTextPane();
		txtpnEcran.setBackground(Color.LIGHT_GRAY);
		txtpnEcran.setText("Ecran:");
		txtpnEcran.setEditable(false);
		
		JComboBox comboBox = new JComboBox();
		
		JTextPane txtpnDroits = new JTextPane();
		txtpnDroits.setBackground(Color.LIGHT_GRAY);
		txtpnDroits.setText("Droits:");
		txtpnDroits.setEditable(false);
		
		JRadioButton rdbtnCration = new JRadioButton("Cr\u00E9ation");
		rdbtnCration.setBackground(Color.LIGHT_GRAY);
		rdbtnCration.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JRadioButton rdbtnLecture = new JRadioButton("Lecture");
		rdbtnLecture.setBackground(Color.LIGHT_GRAY);
		rdbtnLecture.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JRadioButton rdbtnModification = new JRadioButton("Modification");
		rdbtnModification.setBackground(Color.LIGHT_GRAY);
		rdbtnModification.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JRadioButton rdbtnSuppression = new JRadioButton("Suppression");
		rdbtnSuppression.setBackground(Color.LIGHT_GRAY);
		rdbtnSuppression.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JRadioButton rdbtndition = new JRadioButton("\u00C9dition");
		rdbtndition.setBackground(Color.LIGHT_GRAY);
		rdbtndition.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnAnnuler = new JButton("Annuler");
		
		JButton btnSupprimer = new JButton("Supprimer");
		
		JButton btnModifier = new JButton("Modifier");
		GroupLayout groupLayout = new GroupLayout(frmGestionDesDroits.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtpnEcran, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtpnIdentifiant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRechercher))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtpnDroits, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(rdbtnCration, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rdbtnModification, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
								.addComponent(rdbtnLecture, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rdbtnSuppression, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
							.addComponent(rdbtndition, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(167, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(120, Short.MAX_VALUE)
					.addComponent(btnModifier, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSupprimer, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnRechercher))
						.addComponent(txtpnIdentifiant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnEcran, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnDroits, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnCration))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnLecture)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnModification))
						.addComponent(rdbtndition))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnSuppression)
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnnuler)
						.addComponent(btnSupprimer)
						.addComponent(btnModifier))
					.addContainerGap())
		);
		frmGestionDesDroits.getContentPane().setLayout(groupLayout);
	}
	
	public void afficherDroits(acteur param) {
		
	}

}
