package model.view.Autenticacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(45, 362, 309, 64);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin login = new TelaLogin();
				dispose();
				login.setVisible(true);
			}
		});
		btnVoltar.setBounds(392, 362, 309, 64);
		contentPane.add(btnVoltar);
		
		textField = new JTextField();
		textField.setBounds(224, 90, 477, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNome.setBounds(56, 86, 100, 33);
		contentPane.add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(224, 166, 477, 33);
		contentPane.add(textField_1);
		
		JLabel lblNome_1 = new JLabel("CPF");
		lblNome_1.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNome_1.setBounds(56, 162, 100, 33);
		contentPane.add(lblNome_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(224, 249, 478, 33);
		contentPane.add(textField_2);
		
		JLabel lblNome_2 = new JLabel("TELEFONE");
		lblNome_2.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNome_2.setBounds(56, 245, 163, 33);
		contentPane.add(lblNome_2);
	}
}
