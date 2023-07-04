package model.view.Paginas.Funcionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import com.jgoodies.forms.layout.FormLayout;
import com.github.lgooddatepicker.components.DatePicker;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.FuncionarioController;
import model.vo.FuncionarioVO;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class FuncionarioCadastro extends JPanel {
	
	private JTextField nameTextField;
	private JTextField passwordTextField;
	private JFormattedTextField phoneTextField;
	private JFormattedTextField cpfTextField;
	private DatePicker dataNascimentoDatePicker;
	
	private JLabel titleLabel;
	private JLabel nameLabel;
	private JLabel passwordLabel;
	private JLabel phoneLabel;
	private JLabel cpfLabel;
	private JLabel sexoLabel;
	private JLabel dataNascimentoLabel;
	
	private JButton cadastrarFuncionarioButton;
	private JButton btnLimparCampos;
	
	private JComboBox comboBoxSexo;
	
	private MaskFormatter mascaraCPF;
	private MaskFormatter mascaraTelefone;
	
	FuncionarioVO funcionarioVO = new FuncionarioVO();
	FuncionarioController funcionarioController = new FuncionarioController(); 
	
	public void limparCampos() {
		nameTextField.setText("");
		passwordTextField.setText("");
		phoneTextField.setText("");
		cpfTextField.setText("");
		dataNascimentoDatePicker.setText("");
		comboBoxSexo.setSelectedIndex(-1);
	}

	public FuncionarioCadastro() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		String[] listaSexos = {"Masculino", "Feminimo"};
		
		try {
			mascaraCPF = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			System.out.println("Erro ao inicializar variável do campo CPF");
		}
		
		try {
			mascaraTelefone = new MaskFormatter("(##) - #####-####");
		} catch (ParseException e1) {
			System.out.println("Erro ao inicializar variável de máscara do campo Telefone");
		}
		
		mascaraCPF.setValueContainsLiteralCharacters(false);
		mascaraTelefone.setValueContainsLiteralCharacters(false);
		
		titleLabel = new JLabel("Cadastro de Funcionário");
		titleLabel.setBounds(26, 11, 174, 58);
		add(titleLabel);
		
		nameLabel = new JLabel("Nome");
		nameLabel.setBounds(26, 106, 70, 15);
		add(nameLabel);
		
		passwordLabel = new JLabel("Senha");
		passwordLabel.setBounds(26, 140, 70, 15);
		add(passwordLabel);
		
		cpfLabel = new JLabel("CPF");
		cpfLabel.setBounds(26, 174, 70, 15);
		add(cpfLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(118, 104, 584, 19);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(118, 138, 584, 19);
		passwordTextField.setColumns(10);
		add(passwordTextField);
		
		cpfTextField = new JFormattedTextField(mascaraCPF);
		cpfTextField.setBounds(118, 172, 584, 19);
		cpfTextField.setColumns(10);
		add(cpfTextField);
			
		phoneLabel = new JLabel("Telefone");
		phoneLabel.setBounds(26, 234, 70, 15);
		add(phoneLabel);
		
		phoneTextField = new JFormattedTextField(mascaraTelefone);
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(118, 232, 584, 19);
		add(phoneTextField);
		
		dataNascimentoDatePicker = new DatePicker();
		dataNascimentoDatePicker.setBounds(118, 259, 584, 19);
		add(dataNascimentoDatePicker);
		
		dataNascimentoLabel = new JLabel("Data Nascimento");
		dataNascimentoLabel.setBounds(26, 261, 70, 15);
		add(dataNascimentoLabel);
		
		comboBoxSexo = new JComboBox(listaSexos);
		comboBoxSexo.setBounds(118, 201, 584, 24);
		comboBoxSexo.setSelectedIndex(-1);
		add(comboBoxSexo);
		
		sexoLabel = new JLabel("Sexo");
		sexoLabel.setBounds(26, 203, 70, 15);
		add(sexoLabel);
		
		cadastrarFuncionarioButton = new JButton("Cadastrar funcionário");
		cadastrarFuncionarioButton.setBounds(420, 388, 282, 25);
		cadastrarFuncionarioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String cpfSemMascara = (String) mascaraCPF.stringToValue(cpfTextField.getText());
					funcionarioVO.setCPF(cpfSemMascara);
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao converter o valor de CPF para valor sem máscara", "Erro", JOptionPane.ERROR_MESSAGE); 
				}
	
				try {
					String telefoneSemMascara = (String) mascaraTelefone.stringToValue(phoneTextField.getText());
					funcionarioVO.setTelefone(telefoneSemMascara);
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao converter o valor de Telefone para valor sem máscara", "Erro", JOptionPane.ERROR_MESSAGE); 
				}
				
				
				funcionarioVO.setNome(nameTextField.getText());
				funcionarioVO.setSenha(passwordTextField.getText());
				funcionarioVO.setDataNascimento(dataNascimentoDatePicker.getDate());
				funcionarioVO.setSexo(comboBoxSexo.getSelectedItem() != null ? comboBoxSexo.getSelectedItem().toString() : null);
				
				try {
					funcionarioController.cadastrarFuncionario(funcionarioVO);
					limparCampos();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o funcionário");
				}
				
			}
		});
		add(cadastrarFuncionarioButton);
		
		btnLimparCampos = new JButton("Limpar campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimparCampos.setBounds(420, 349, 282, 25);
		add(btnLimparCampos);
	
	}
}
