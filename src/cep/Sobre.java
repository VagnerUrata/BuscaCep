package cep;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sobre extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setModal(true);
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setResizable(false);
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/home.png")));
		setBounds(150, 150, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Busca Cep - Ver 1.0");
		lblNewLabel.setBounds(12, 27, 146, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("@Author Vagner Urata");
		lblNewLabel_1.setBounds(12, 67, 185, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Web Service:");
		lblNewLabel_2.setBounds(12, 110, 97, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblWebService = new JLabel("republicavirtual.com.br");
		lblWebService.setForeground(SystemColor.textHighlight);
		lblWebService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://republicavirtual.com.br/");
			}
		});
		lblWebService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblWebService.setBounds(121, 110, 185, 15);
		getContentPane().add(lblWebService);
		
		JButton btnGitHub = new JButton("");
		btnGitHub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGitHub.setBorderPainted(false);
		btnGitHub.setIcon(new ImageIcon(Sobre.class.getResource("/img/Git.png")));
		btnGitHub.setBackground(SystemColor.control);
		btnGitHub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				link("https://github.com/VagnerUrata/BuscaCep");
			}
		});
		btnGitHub.setBounds(40, 165, 48, 48);
		getContentPane().add(btnGitHub);

	}
	
	private void link(String site) {
		Desktop desktop = Desktop.getDesktop();
		try {
			URI uri = new URI(site);
			desktop.browse(uri);
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
