package ihm;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;

public class FicheUtilisateur {

	private JFrame frmFicheUtilisateur;
	private JTextField act_nom;
	private JTextField act_pre;
	private JTextField loc_cp;
	private JTextField ser_lib;
	private JTextField act_tel;
	private JTextField act_mai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FicheUtilisateur window = new FicheUtilisateur();
					window.frmFicheUtilisateur.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FicheUtilisateur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFicheUtilisateur = new JFrame();
		frmFicheUtilisateur.setTitle("Fiche utilisateur");
		frmFicheUtilisateur.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmFicheUtilisateur.setBounds(100, 100, 450, 300);
		frmFicheUtilisateur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextPane txtpnNom = new JTextPane();
		txtpnNom.setBackground(Color.LIGHT_GRAY);
		txtpnNom.setText("Nom:");
		
		JTextPane txtpnPrnom = new JTextPane();
		txtpnPrnom.setBackground(Color.LIGHT_GRAY);
		txtpnPrnom.setText("Pr\u00E9nom:");
		
		JTextPane txtpnCodePostal = new JTextPane();
		txtpnCodePostal.setBackground(Color.LIGHT_GRAY);
		txtpnCodePostal.setText("Code postal:");
		
		JTextPane txtpnFonction = new JTextPane();
		txtpnFonction.setBackground(Color.LIGHT_GRAY);
		txtpnFonction.setText("Fonction:");
		
		JTextPane txtpnNumroDeTlphone = new JTextPane();
		txtpnNumroDeTlphone.setBackground(Color.LIGHT_GRAY);
		txtpnNumroDeTlphone.setText("Num\u00E9ro de t\u00E9l\u00E9phone:");
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setBackground(Color.LIGHT_GRAY);
		txtpnEmail.setText("Email:");
		
		JButton btnValider = new JButton("Valider");
		
		JButton btnAnnuler = new JButton("Annuler");
		
		act_nom = new JTextField();
		act_nom.setColumns(10);
		
		act_pre = new JTextField();
		act_pre.setColumns(10);
		
		loc_cp = new JTextField();
		loc_cp.setColumns(10);
		
		ser_lib = new JTextField();
		ser_lib.setColumns(10);
		
		act_tel = new JTextField();
		act_tel.setColumns(10);
		
		act_mai = new JTextField();
		act_mai.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmFicheUtilisateur.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnPrnom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnCodePostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnFonction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(56)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(act_nom, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
								.addComponent(act_pre)
								.addComponent(loc_cp)
								.addComponent(ser_lib)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnNumroDeTlphone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnValider))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAnnuler)
								.addComponent(act_tel, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
								.addComponent(act_mai, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))))
					.addGap(154))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtpnNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtpnPrnom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(act_nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(act_pre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtpnCodePostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtpnFonction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(loc_cp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ser_lib, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtpnNumroDeTlphone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(act_tel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(act_mai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnValider)
						.addComponent(btnAnnuler))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		frmFicheUtilisateur.getContentPane().setLayout(groupLayout);
	}
}
