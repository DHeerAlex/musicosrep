package ihm_d;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tableAdmin {
	
	private static JFrame FrameAdmin;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initilaize();
	}
	
	public static void initilaize() {
		FrameAdmin = new JFrame();
		FrameAdmin.getContentPane().setBackground(Color.LIGHT_GRAY);
		FrameAdmin.setBounds(750, 250, 800, 546);
		FrameAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrameAdmin.getContentPane().setLayout(null);
		
		JButton btn_modifier = new JButton("Modifier");
		btn_modifier.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_modifier.setBounds(306, 473, 116, 23);
		FrameAdmin.getContentPane().add(btn_modifier);
		
		JButton btn_supprimer = new JButton("Supprimer");
		btn_supprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_supprimer.setBounds(471, 473, 129, 23);
		FrameAdmin.getContentPane().add(btn_supprimer);
		
		JButton btn_annuler = new JButton("Annuler");
		btn_annuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_annuler.setBounds(641, 473, 111, 23);
		FrameAdmin.getContentPane().add(btn_annuler);
		btn_annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameAdmin.setVisible(false);
			}
		});
		
		
		
		
		FrameAdmin.setVisible(true);
	}
}
