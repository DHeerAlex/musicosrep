package ihm_d;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Component;

public class proposition {

	private JFrame frmProposition;
	private JTextField textField;
	private JTextField txt_tarif;
	private JTextField textField_1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					proposition window = new proposition();
					window.frmProposition.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public proposition() {
		initialize();
	}

	private void initialize() {
		frmProposition = new JFrame();
		frmProposition.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		
		
		JPanel panel_sud = new JPanel();
		frmProposition.getContentPane().add(panel_sud, BorderLayout.SOUTH);
		
		JPanel panel_cntr = new JPanel();
		frmProposition.getContentPane().add(panel_cntr, BorderLayout.CENTER);
		panel_cntr.setLayout(new BoxLayout(panel_cntr, BoxLayout.X_AXIS));
		
		JComboBox cbx_service = new JComboBox();
		panel_cntr.add(cbx_service);
		
		JRadioButton rdbtn_heure = new JRadioButton("/ heure");
		panel_cntr.add(rdbtn_heure);
		
		JPanel panel_lbl = new JPanel();
		panel_cntr.add(panel_lbl);
		panel_lbl.setLayout(new BoxLayout(panel_lbl, BoxLayout.Y_AXIS));
		
		JLabel lbl_Service = new JLabel("Service :");
		lbl_Service.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel_lbl.add(lbl_Service);
		
		JLabel lbl_tarif = new JLabel("Tarif :");
		panel_lbl.add(lbl_tarif);
		
		txt_tarif = new JTextField();
		txt_tarif.setColumns(10);
		panel_cntr.add(txt_tarif);
		
		JRadioButton rdbtn_jour = new JRadioButton("/ jour");
		frmProposition.setTitle("Proposition des services");
		frmProposition.setBounds(100, 100, 450, 300);
		frmProposition.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
}
