package model.view.Autenticacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;

import controller.FuncionarioController;
import model.view.TelaPrincipal;
import model.vo.FuncionarioVO;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	
	private JTextField nameInputField;
	private JFormattedTextField cpfInputField;
	private JFormattedTextField phoneInputField;
	private JTextField passwordInputField;
	private DatePicker dataNascimentoDatePicker;
	
	private JLabel nameLabel;
	private JLabel cpfLabel;
	private JLabel phoneLabel;
	private JLabel passwordLabel;
	private JLabel dataNascimentoLabel;
	
	FuncionarioVO funcionarioVO = new FuncionarioVO();
	FuncionarioController funcionarioController = new FuncionarioController();
	
	private JComboBox comboBoxSexo;
	private boolean funcionarioCadastrado;
	
	private MaskFormatter mascaraCPF;
	private MaskFormatter mascaraTelefone;
	
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
		
		try {
			mascaraCPF = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			System.out.println("Erro ao inicializar variável do campo CPF");
		}
		
		try {
			mascaraTelefone = new MaskFormatter("(##) -#####-####");
		} catch (ParseException e1) {
			System.out.println("Erro ao inicializar variável de máscara do campo Telefone");
		}
		
		mascaraCPF.setValueContainsLiteralCharacters(false);
		mascaraTelefone.setValueContainsLiteralCharacters(false);
		
		
		String[] listaSexos = {"Masculino", "Feminimo"};
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(45, 362, 309, 64);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String cpfSemMascara = (String) mascaraCPF.stringToValue(cpfInputField.getText());
					funcionarioVO.setCPF(cpfSemMascara);
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao converter o valor de CPF para valor sem máscara", "Erro", JOptionPane.ERROR_MESSAGE); 
				}
	
				try {
					String telefoneSemMascara = (String) mascaraTelefone.stringToValue(phoneInputField.getText());
					funcionarioVO.setTelefone(telefoneSemMascara);
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao converter o valor de Telefone para valor sem máscara", "Erro", JOptionPane.ERROR_MESSAGE); 
				}
	
				
				funcionarioVO.setNome(nameInputField.getText());
				funcionarioVO.setSenha(passwordInputField.getText());
				funcionarioVO.setDataNascimento(dataNascimentoDatePicker.getDate());
				funcionarioVO.setSexo(comboBoxSexo.getSelectedItem() != null ? comboBoxSexo.getSelectedItem().toString() : null);
				
			
				try {
					funcionarioCadastrado = funcionarioController.cadastrarFuncionario(funcionarioVO);
					if (funcionarioCadastrado) {
						TelaPrincipal principal = new TelaPrincipal();
						dispose();
						principal.setVisible(true);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário");
				}			
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(392, 362, 309, 64);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin login = new TelaLogin();
				dispose();
				login.setVisible(true);
			}
		});
		contentPane.add(btnVoltar);
		
		nameInputField = new JTextField();
		nameInputField.setBounds(201, 52, 500, 19);
		contentPane.add(nameInputField);
		nameInputField.setColumns(10);
		
		nameLabel = new JLabel("NOME");
		nameLabel.setBounds(45, 52, 100, 19);
		nameLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPane.add(nameLabel);
		
		cpfInputField = new JFormattedTextField(mascaraCPF);
		cpfInputField.setBounds(201, 142, 500, 19);
		cpfInputField.setColumns(10);
		contentPane.add(cpfInputField);
		
		cpfLabel = new JLabel("CPF");
		cpfLabel.setBounds(45, 142, 100, 19);
		cpfLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPane.add(cpfLabel);
		
		phoneInputField = new JFormattedTextField(mascaraTelefone);
		phoneInputField.setBounds(201, 190, 500, 19);
		phoneInputField.setColumns(10);
		contentPane.add(phoneInputField);
		
		phoneLabel = new JLabel("TELEFONE");
		phoneLabel.setBounds(45, 190, 163, 19);
		phoneLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPane.add(phoneLabel);
		
		passwordInputField = new JTextField();
		passwordInputField.setBounds(201, 95, 500, 19);
		passwordInputField.setColumns(10);
		contentPane.add(passwordInputField);
		
		passwordLabel = new JLabel("SENHA");
		passwordLabel.setBounds(45, 95, 121, 19);
		passwordLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPane.add(passwordLabel);
		
		JLabel lblSexo = new JLabel("SEXO");
		lblSexo.setBounds(45, 285, 163, 19);
		lblSexo.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPane.add(lblSexo);
		
		comboBoxSexo = new JComboBox(listaSexos);
		comboBoxSexo.setBounds(201, 282, 500, 24);
		comboBoxSexo.setSelectedIndex(-1);
		contentPane.add(comboBoxSexo);
		
		dataNascimentoDatePicker = new DatePicker();
		dataNascimentoDatePicker.setBounds(201, 239, 500, 19);
		contentPane.add(dataNascimentoDatePicker);
		
		dataNascimentoLabel = new JLabel("Data Nascimento");
		dataNascimentoLabel.setBounds(45, 236, 132, 24);
		dataNascimentoLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPane.add(dataNascimentoLabel);
	}
}
