package model.view.Autenticacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.LoginController;
import model.view.TelaPrincipal;
import model.vo.FuncionarioVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	
	private JTextField loginInputField;
	private JTextField passwordInputField;
	
	private JButton loginButton;
	private JButton signupButton;
	
	private JLabel loginLabel;
	private JLabel passwordLabel;

	TelaCadastro cadastro = new TelaCadastro();
	TelaPrincipal principal = new TelaPrincipal();
	
	FuncionarioVO funcionarioVO = new FuncionarioVO();
	LoginController loginController = new LoginController();


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		loginLabel = new JLabel("LOGIN");
		loginLabel.setBounds(53, 128, 92, 36);
		loginLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		contentPane.add(loginLabel);
		
		loginInputField = new JTextField();
		loginInputField.setBounds(163, 128, 505, 36);
		contentPane.add(loginInputField);
		loginInputField.setColumns(10);
		
		passwordLabel = new JLabel("SENHA");
		passwordLabel.setBounds(53, 212, 92, 36);
		passwordLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		contentPane.add(passwordLabel);
		
		passwordInputField = new JTextField();
		passwordInputField.setBounds(163, 212, 505, 36);
		passwordInputField.setColumns(10);
		contentPane.add(passwordInputField);
		
		loginButton = new JButton("Entrar");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				funcionarioVO.setNome(loginInputField.getText());
				funcionarioVO.setSenha(passwordInputField.getText());
				
				try {
					loginController.realizarLogin(funcionarioVO);
					dispose();
					principal.setVisible(true);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "erro");
				}
				
			}
		});
		loginButton.setBounds(51, 370, 281, 51);
		contentPane.add(loginButton);
		
		signupButton = new JButton("Cadastro");
		signupButton.setBounds(387, 370, 281, 51);
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				cadastro.setVisible(true);
			}
		});
		contentPane.add(signupButton);
	}

}
