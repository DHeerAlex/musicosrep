package ihm_d;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

import Dao_d.localiteDao;
import Dao_d.typeacteurDao;
import modele.acteur;
import modele.localite;
import modele.typeacteur;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class FicheUtilisateur {

	private static acteur paramActeur;
	private JFrame frmFicheUtilisateur;
	private JTextField act_nom;
	private JTextField act_pre;
	private JTextField loc_cp;
	private JTextField ser_lib;
	private JTextField act_tel;
	private JTextField act_mai;

	/**
	 * Create the application.
	 */
	public FicheUtilisateur(acteur param) {
		setParam(param);
		typeacteurDao dao_type = new typeacteurDao();
		typeacteur type = new typeacteur();
		type = dao_type.retourne(paramActeur.getTyp_id());
		List<Integer> idTypesAdmin = new ArrayList<Integer>() ;
		idTypesAdmin.add(1);
		idTypesAdmin.add(2);
		idTypesAdmin.add(3);
		
		int idTypeUser = type.getTyp_id();
		
		if(idTypesAdmin.contains(idTypeUser) == true) {
			administration();
			afficherInfos();
		} else {
			utilisateur();
			afficherInfos();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void utilisateur() {
		frmFicheUtilisateur = new JFrame();
		frmFicheUtilisateur.setTitle("Fiche utilisateur");
		frmFicheUtilisateur.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmFicheUtilisateur.setBounds(100, 100, 617, 332);
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
		
		JButton btn_deco = new JButton("D\u00E9connection");
		btn_deco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				connection frmConn = new connection();
				frmConn.main(null);
				frmFicheUtilisateur.setVisible(false);
			}
		});
		
		JButton btn_rech = new JButton("Rechercher");
		btn_rech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recherche frmRech = new recherche();
				frmRech.main(null);
			}
		});
		
		JButton btnOffre = new JButton("Offre");
		btnOffre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmFicheUtilisateur.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
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
										.addComponent(txtpnEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(act_tel, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
										.addComponent(act_mai, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))))
							.addGap(55)
							.addComponent(btn_deco))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnOffre)
							.addPreferredGap(ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
							.addComponent(btn_rech)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
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
								.addComponent(act_mai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btn_deco))
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_rech)
						.addComponent(btnOffre))
					.addContainerGap())
		);
		frmFicheUtilisateur.getContentPane().setLayout(groupLayout);
		
		frmFicheUtilisateur.setVisible(true);
	}
	
	private void administration() {
		frmFicheUtilisateur = new JFrame();
		frmFicheUtilisateur.setTitle("Fiche administrateur");
		frmFicheUtilisateur.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmFicheUtilisateur.setBounds(100, 100, 617, 332);
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
		
		JButton btn_deco = new JButton("D\u00E9connection");
		btn_deco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				connection frmConn = new connection();
				frmConn.main(null);
				frmFicheUtilisateur.setVisible(false);
			}
		});
		
		JButton btn_rech = new JButton("Rechercher");
		btn_rech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recherche frmRech = new recherche();
				frmRech.main(null);
			}
		});
		
		JButton btnGestionDroits = new JButton("Gestion des droits");
		btnGestionDroits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new gestion_droits();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmFicheUtilisateur.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
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
										.addComponent(txtpnEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(act_tel, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
										.addComponent(act_mai, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))))
							.addGap(55)
							.addComponent(btn_deco))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnGestionDroits)
							.addPreferredGap(ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
							.addComponent(btn_rech)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
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
								.addComponent(act_mai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btn_deco))
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_rech)
						.addComponent(btnGestionDroits))
					.addContainerGap())
		);
		frmFicheUtilisateur.getContentPane().setLayout(groupLayout);
		
		frmFicheUtilisateur.setVisible(true);
	}
	
	public static void setParam(acteur param) {
		paramActeur = param;
	}
	
	public void afficherInfos() {
		act_pre.setText(paramActeur.getAct_pre());
		act_nom.setText(paramActeur.getAct_nom());
		localiteDao dao_localite = new localiteDao();
		typeacteurDao dao_type = new typeacteurDao();
		typeacteur type = new typeacteur();
		localite loc = new localite();
		type = dao_type.retourne(paramActeur.getTyp_id());
		loc = dao_localite.retourne(paramActeur.getLoc_ins());
		
		act_tel.setText(paramActeur.getAct_tel());
		act_mai.setText(paramActeur.getAct_mai());
		loc_cp.setText(loc.getLoc_lib());
		ser_lib.setText(type.getTyp_lib());
	}
}
