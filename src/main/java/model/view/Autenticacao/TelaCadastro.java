package model.view.Autenticacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.view.TelaPrincipal;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	
	private JTextField nameInputField;
	private JTextField cpfInputField;
	private JTextField phoneInputField;
	
	private JLabel nameLabel;
	private JLabel cpfLabel;
	private JLabel phoneLabel;
	


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

	public TelaCadastro() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal
				telaPrincipal = new TelaPrincipal();
				dispose();
				telaPrincipal.setVisible(true);
			}
		});
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
		
		nameInputField = new JTextField();
		nameInputField.setBounds(224, 90, 477, 33);
		contentPane.add(nameInputField);
		nameInputField.setColumns(10);
		
		nameLabel = new JLabel("NOME");
		nameLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		nameLabel.setBounds(56, 86, 100, 33);
		contentPane.add(nameLabel);
		
		cpfInputField = new JTextField();
		cpfInputField.setColumns(10);
		cpfInputField.setBounds(224, 166, 477, 33);
		contentPane.add(cpfInputField);
		
		cpfLabel = new JLabel("CPF");
		cpfLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		cpfLabel.setBounds(56, 162, 100, 33);
		contentPane.add(cpfLabel);
		
		phoneInputField = new JTextField();
		phoneInputField.setColumns(10);
		phoneInputField.setBounds(224, 249, 478, 33);
		contentPane.add(phoneInputField);
		
		phoneLabel = new JLabel("TELEFONE");
		phoneLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		phoneLabel.setBounds(56, 245, 163, 33);
		contentPane.add(phoneLabel);
	}
}
