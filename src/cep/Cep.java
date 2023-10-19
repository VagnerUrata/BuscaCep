package cep;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;

public class Cep extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JLabel lblUf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cep frame = new Cep();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cep() {
		setTitle("Busca Cep");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cep.class.getResource("/img/home.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cep");
		lblNewLabel.setBounds(12, 35, 70, 15);
		contentPane.add(lblNewLabel);
		
		txtCep = new JTextField();
		txtCep.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCep.setBounds(92, 33, 114, 19);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblEndere = new JLabel("Endereço");
		lblEndere.setBounds(12, 79, 70, 15);
		contentPane.add(lblEndere);
		
		JLabel lblNewLabel_1 = new JLabel("Bairro");
		lblNewLabel_1.setBounds(12, 119, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(92, 77, 301, 19);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(92, 117, 301, 19);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cidade");
		lblNewLabel_2.setBounds(12, 159, 70, 15);
		contentPane.add(lblNewLabel_2);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(92, 157, 206, 19);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		lblUf = new JLabel("UF");
		lblUf.setBounds(316, 159, 18, 15);
		contentPane.add(lblUf);
		
		JComboBox cboUf = new JComboBox();
		cboUf.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboUf.setBounds(341, 154, 52, 24);
		contentPane.add(cboUf);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(12, 215, 117, 25);
		contentPane.add(btnLimpar);
		
		JButton btnCep = new JButton("Buscar");
		btnCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtCep.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o CEP");
					txtCep.requestFocus();
				} else {
					//buscar Cep
				}
			}
		});
		btnCep.setBounds(276, 215, 117, 25);
		contentPane.add(btnCep);
		
		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setToolTipText("Sobre");
		btnSobre.setIcon(new ImageIcon(Cep.class.getResource("/img/about.png")));
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBorder(null);
		btnSobre.setBackground(SystemColor.control);
		btnSobre.setBounds(345, 12, 48, 48);
		contentPane.add(btnSobre);
		
		/*Uso da Biblioteca Atxy2k para validacao do calpo txtCep */
		RestrictedTextField validar = new RestrictedTextField(txtCep);
		validar.setOnlyNums(true);
		validar.setLimit(8);
	}
}
