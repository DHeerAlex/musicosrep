package ihm2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class accueil {

	private JFrame frmAccueil;
	private String logo;
	private String urllogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					accueil window = new accueil();
					((Window) window.frmAccueil).setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public accueil() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		frmAccueil = new JFrame();
		frmAccueil.setResizable(false);
		frmAccueil.setTitle("MusicosRep - Accueil");
		frmAccueil.setBounds(100, 100, 1280, 800);
		frmAccueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		File directory = new File (".");
		urllogo =  directory.getCanonicalPath() + "/src/mep/logo.jpg";
		
		System.out.println(logo + "      " + urllogo);
		
		ImageIcon image = new ImageIcon(urllogo);    
		JLabel lab = new JLabel(image);
		frmAccueil.getContentPane().add(lab);
		
		JLabel lblRepertoireDesArtistes = new JLabel("Repertoire des artistes");
		lblRepertoireDesArtistes.setForeground(Color.BLUE);
		lblRepertoireDesArtistes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 36));
		lblRepertoireDesArtistes.setHorizontalAlignment(SwingConstants.CENTER);
		frmAccueil.getContentPane().add(lblRepertoireDesArtistes, BorderLayout.NORTH);
	}

}
