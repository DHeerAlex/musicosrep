package vue;

import control.*;
import javax.swing.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;


public class frm_co extends JFrame implements Observer{
	
	private connexionListener conn_listen = new connexionListener();
	
	JTextField txt_login;
	JTextField txt_mdp;
	JButton btn_insc = new JButton("Inscription");
	JButton btn_conn = new JButton("Connection");
	
	public frm_co() {
		btn_insc = new JButton("Inscription");
		btn_conn = new JButton("Connection");
		
		
		init();
	}
	
	public void init() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setTitle("Acceuil");
		setSize(450,300);
		JPanel panel_central = new JPanel();
		panel_central.setBorder(new EmptyBorder(20, 20, 20, 20));
		FlowLayout flowLayout = (FlowLayout) panel_central.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(24);
		getContentPane().add(panel_central, BorderLayout.CENTER);
		
		JPanel panel_lbl = new JPanel();
		panel_lbl.setSize(new Dimension(300, 300));
		panel_lbl.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_central.add(panel_lbl);
		panel_lbl.setLayout(new GridLayout(2, 1, 6, 5));
		
		JLabel lbl_login = new JLabel("Login");
		lbl_login.setVerticalAlignment(SwingConstants.TOP);
		lbl_login.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_lbl.add(lbl_login);
		lbl_login.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		
		JLabel lbl_mdp = new JLabel("Mot de passe");
		lbl_mdp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_mdp.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel_lbl.add(lbl_mdp);
		
		JPanel panel_chp = new JPanel();
		panel_central.add(panel_chp);
		panel_chp.setLayout(new GridLayout(2, 1, 5, 5));
		
		txt_login = new JTextField();
		txt_login.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_login.setAlignmentY(Component.TOP_ALIGNMENT);
		lbl_login.setLabelFor(txt_login);
		panel_chp.add(txt_login);
		txt_login.setColumns(10);
		
		txt_mdp = new JTextField();
		txt_mdp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_mdp.setLabelFor(txt_mdp);
		panel_chp.add(txt_mdp);
		txt_mdp.setColumns(10);
		
		JPanel panel_btn = new JPanel();
		panel_btn.setBorder(new EmptyBorder(25, 45, 0, 45));
		panel_central.add(panel_btn);
		panel_btn.setLayout(new GridLayout(1, 2, 5, 5));
		
		btn_insc = new JButton();
		btn_insc.setName("Inscription");
		btn_insc.setText("Inscription");
		btn_insc.addActionListener(null);
		btn_insc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_btn.add(btn_insc);
		btn_insc.setBounds(5, 5, 83, 23);
		
		btn_conn = new JButton();
		btn_conn.setName("Connection");
		btn_conn.setText("Connection");
		btn_conn.addActionListener(conn_listen);
		btn_conn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_btn.add(btn_conn);
		btn_conn.setBounds(93, 5, 87, 23);
		
		setVisible(true);
	}
	
	public JTextField getLogin() {
		return txt_login;
	}
	
	public JTextField getPassword() {
		return txt_mdp;
	}
	
	public JButton getInscription() {
		return btn_insc;
	}
	
	public JButton getConnection() {
		return btn_conn;
	}
	
	public void update(Observable modele,Object fd) {
		
	}
	
}
