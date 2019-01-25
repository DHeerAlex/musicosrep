package ihm2;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTextArea;
import java.awt.List;
import java.awt.TextArea;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.UIManager;

public class Annuaire {

	private JFrame frmAnnuaire;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Annuaire window = new Annuaire();
					window.frmAnnuaire.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Annuaire() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAnnuaire = new JFrame();
		frmAnnuaire.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmAnnuaire.setTitle("Annuaire");
		frmAnnuaire.setBounds(100, 100, 1288, 605);
		frmAnnuaire.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{112, 178, 45, 178, 45, 178, 67, 178, 52, 41, 7, 10, 58, 0};
		gridBagLayout.rowHeights = new int[]{30, 27, 31, 23, 20, 296, 23, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmAnnuaire.getContentPane().setLayout(gridBagLayout);
		
		JTextPane txtpnSelection = new JTextPane();
		txtpnSelection.setBackground(Color.LIGHT_GRAY);
		txtpnSelection.setText("selection");
		GridBagConstraints gbc_txtpnSelection = new GridBagConstraints();
		gbc_txtpnSelection.anchor = GridBagConstraints.NORTH;
		gbc_txtpnSelection.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnSelection.gridx = 0;
		gbc_txtpnSelection.gridy = 1;
		frmAnnuaire.getContentPane().add(txtpnSelection, gbc_txtpnSelection);
		
		JTextPane txtpnTypeDacteur = new JTextPane();
		txtpnTypeDacteur.setBackground(Color.LIGHT_GRAY);
		txtpnTypeDacteur.setText("Type d'acteur:");
		GridBagConstraints gbc_txtpnTypeDacteur = new GridBagConstraints();
		gbc_txtpnTypeDacteur.anchor = GridBagConstraints.NORTHEAST;
		gbc_txtpnTypeDacteur.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnTypeDacteur.gridx = 0;
		gbc_txtpnTypeDacteur.gridy = 3;
		frmAnnuaire.getContentPane().add(txtpnTypeDacteur, gbc_txtpnTypeDacteur);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.NORTH;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		frmAnnuaire.getContentPane().add(comboBox, gbc_comboBox);
		
		JTextPane txtpnService = new JTextPane();
		txtpnService.setBackground(Color.LIGHT_GRAY);
		txtpnService.setText("Service:");
		GridBagConstraints gbc_txtpnService = new GridBagConstraints();
		gbc_txtpnService.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtpnService.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnService.gridx = 2;
		gbc_txtpnService.gridy = 3;
		frmAnnuaire.getContentPane().add(txtpnService, gbc_txtpnService);
		
		JComboBox comboBox_2 = new JComboBox();
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.anchor = GridBagConstraints.NORTH;
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.gridx = 3;
		gbc_comboBox_2.gridy = 3;
		frmAnnuaire.getContentPane().add(comboBox_2, gbc_comboBox_2);
		
		JTextPane txtpnGroupe = new JTextPane();
		txtpnGroupe.setBackground(Color.LIGHT_GRAY);
		txtpnGroupe.setText("Groupe:");
		GridBagConstraints gbc_txtpnGroupe = new GridBagConstraints();
		gbc_txtpnGroupe.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtpnGroupe.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnGroupe.gridx = 4;
		gbc_txtpnGroupe.gridy = 3;
		frmAnnuaire.getContentPane().add(txtpnGroupe, gbc_txtpnGroupe);
		
		JComboBox comboBox_3 = new JComboBox();
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.anchor = GridBagConstraints.NORTH;
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.gridx = 5;
		gbc_comboBox_3.gridy = 3;
		frmAnnuaire.getContentPane().add(comboBox_3, gbc_comboBox_3);
		
		JTextPane txtpnCodePostal = new JTextPane();
		txtpnCodePostal.setBackground(Color.LIGHT_GRAY);
		txtpnCodePostal.setText("Code postal:");
		GridBagConstraints gbc_txtpnCodePostal = new GridBagConstraints();
		gbc_txtpnCodePostal.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtpnCodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnCodePostal.gridx = 6;
		gbc_txtpnCodePostal.gridy = 3;
		frmAnnuaire.getContentPane().add(txtpnCodePostal, gbc_txtpnCodePostal);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 7;
		gbc_textField.gridy = 3;
		frmAnnuaire.getContentPane().add(textField, gbc_textField);
		
		JTextPane txtpnActifs = new JTextPane();
		txtpnActifs.setBackground(Color.LIGHT_GRAY);
		txtpnActifs.setText("Actifs:");
		GridBagConstraints gbc_txtpnActifs = new GridBagConstraints();
		gbc_txtpnActifs.anchor = GridBagConstraints.NORTH;
		gbc_txtpnActifs.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpnActifs.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnActifs.gridx = 8;
		gbc_txtpnActifs.gridy = 3;
		frmAnnuaire.getContentPane().add(txtpnActifs, gbc_txtpnActifs);
		
		JRadioButton rdbtnOui = new JRadioButton("Oui");
		rdbtnOui.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_rdbtnOui = new GridBagConstraints();
		gbc_rdbtnOui.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnOui.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnOui.gridx = 9;
		gbc_rdbtnOui.gridy = 3;
		frmAnnuaire.getContentPane().add(rdbtnOui, gbc_rdbtnOui);
		
		JRadioButton rdbtnNon = new JRadioButton("Non");
		rdbtnNon.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_rdbtnNon = new GridBagConstraints();
		gbc_rdbtnNon.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnNon.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNon.gridwidth = 2;
		gbc_rdbtnNon.gridx = 10;
		gbc_rdbtnNon.gridy = 3;
		frmAnnuaire.getContentPane().add(rdbtnNon, gbc_rdbtnNon);
		
		JRadioButton rdbtnTous = new JRadioButton("Tous");
		rdbtnTous.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_rdbtnTous = new GridBagConstraints();
		gbc_rdbtnTous.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnTous.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnTous.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnTous.gridx = 12;
		gbc_rdbtnTous.gridy = 3;
		frmAnnuaire.getContentPane().add(rdbtnTous, gbc_rdbtnTous);
		
		JTextPane txtpnTrierPar = new JTextPane();
		txtpnTrierPar.setBackground(Color.LIGHT_GRAY);
		txtpnTrierPar.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtpnTrierPar.setText("Trier par:");
		GridBagConstraints gbc_txtpnTrierPar = new GridBagConstraints();
		gbc_txtpnTrierPar.anchor = GridBagConstraints.NORTH;
		gbc_txtpnTrierPar.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnTrierPar.gridx = 0;
		gbc_txtpnTrierPar.gridy = 4;
		frmAnnuaire.getContentPane().add(txtpnTrierPar, gbc_txtpnTrierPar);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.anchor = GridBagConstraints.NORTH;
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 4;
		frmAnnuaire.getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBackground(Color.WHITE);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.insets = new Insets(0, 0, 0, 5);
		gbc_tabbedPane.gridheight = 3;
		gbc_tabbedPane.gridwidth = 10;
		gbc_tabbedPane.gridx = 1;
		gbc_tabbedPane.gridy = 5;
		frmAnnuaire.getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		JButton btnValider = new JButton("Valider");
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.anchor = GridBagConstraints.SOUTH;
		gbc_btnValider.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnValider.insets = new Insets(0, 0, 5, 0);
		gbc_btnValider.gridwidth = 2;
		gbc_btnValider.gridx = 11;
		gbc_btnValider.gridy = 5;
		frmAnnuaire.getContentPane().add(btnValider, gbc_btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.anchor = GridBagConstraints.NORTH;
		gbc_btnAnnuler.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAnnuler.insets = new Insets(0, 0, 5, 0);
		gbc_btnAnnuler.gridwidth = 2;
		gbc_btnAnnuler.gridx = 11;
		gbc_btnAnnuler.gridy = 6;
		frmAnnuaire.getContentPane().add(btnAnnuler, gbc_btnAnnuler);
		
		JButton btnQuitter = new JButton("Quitter");
		GridBagConstraints gbc_btnQuitter = new GridBagConstraints();
		gbc_btnQuitter.anchor = GridBagConstraints.NORTH;
		gbc_btnQuitter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQuitter.gridwidth = 2;
		gbc_btnQuitter.gridx = 11;
		gbc_btnQuitter.gridy = 7;
		frmAnnuaire.getContentPane().add(btnQuitter, gbc_btnQuitter);
	}
}
