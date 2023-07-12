package model.view.Paginas.Funcionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;

import controller.FuncionarioController;
import model.vo.FuncionarioVO;

public class FuncionarioEdicao extends JPanel {
	
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
	private JLabel lblFuncionariosCadastrados;
	private JLabel lblAtivo;
	
	private JButton editarFuncionarioButton;
	private JButton btnLimparCampos;
	
	private JComboBox comboBoxSexo;
	private JComboBox comboBoxFuncionariosCadastrados;
	private JComboBox comboBoxAtivo;
	
	private MaskFormatter mascaraCPF;
	private MaskFormatter mascaraTelefone;
	
	private FuncionarioVO funcionario;
	
	private List<FuncionarioVO> listaFuncionariosCadastrados;
	
	public void editarDadosFuncionario (FuncionarioController funcionarioController) {
		
		
		try {
			String cpfSemMascara = (String) mascaraCPF.stringToValue(cpfTextField.getText());
			funcionario.setCPF(cpfSemMascara);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Erro ao converter o valor de CPF para valor sem máscara", "Erro", JOptionPane.ERROR_MESSAGE); 
		}

		try {
			String telefoneSemMascara = (String) mascaraTelefone.stringToValue(phoneTextField.getText());
			funcionario.setTelefone(telefoneSemMascara);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Erro ao converter o valor de Telefone para valor sem máscara", "Erro", JOptionPane.ERROR_MESSAGE); 
		}
		
		funcionario.setNome(nameTextField.getText());
		funcionario.setSenha(passwordTextField.getText());
		funcionario.setSexo(comboBoxSexo.getSelectedItem().toString());
		funcionario.setDataNascimento(dataNascimentoDatePicker.getDate());
		funcionario.setAtivo(comboBoxAtivo.getSelectedItem() == "Empregado" ? true : false);
		
		boolean funcionarioCadastrado = funcionarioController.atualizarFuncionario(funcionario);
		
		if (funcionarioCadastrado) {
			JOptionPane.showMessageDialog(null, "Dados do funcionário foram atualizados com sucesso");
			limparCampos();
		}
	}

	public void limparCampos() {
		nameTextField.setText("");
		passwordTextField.setText("");
		phoneTextField.setText("");
		cpfTextField.setText("");
		dataNascimentoDatePicker.setText("");
		comboBoxAtivo.setSelectedIndex(-1);
		comboBoxSexo.setSelectedIndex(-1);
	}
	
	public void preencherCamposFuncionario () {
		nameTextField.setText(funcionario.getNome());
		passwordTextField.setText(funcionario.getSenha());
		cpfTextField.setText(funcionario.getCPF());
		phoneTextField.setText(funcionario.getTelefone());
		comboBoxSexo.setSelectedItem(funcionario.getSexo());
		dataNascimentoDatePicker.setText(funcionario.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		comboBoxAtivo.setSelectedItem(funcionario.getAtivo() ? "Empregado" : "Não empregado");
	}

	public FuncionarioEdicao() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		String[] listaSexos = {"Masculino", "Feminimo"};
		String[] listaAtivo =  {"Empregado", "Não empregado"};
		
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
		
		final FuncionarioController funcionarioController = new FuncionarioController();
		listaFuncionariosCadastrados = funcionarioController.consultarListaFuncionarios();
		
		comboBoxFuncionariosCadastrados = new JComboBox(listaFuncionariosCadastrados.toArray());
		comboBoxFuncionariosCadastrados.setSelectedIndex(-1);
		comboBoxFuncionariosCadastrados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionario = (FuncionarioVO) comboBoxFuncionariosCadastrados.getSelectedItem();
				preencherCamposFuncionario();
			}
		});
		comboBoxFuncionariosCadastrados.setBounds(253, 68, 449, 24);
		add(comboBoxFuncionariosCadastrados);
		
		lblFuncionariosCadastrados = new JLabel("Funcionários Cadastrados");
		lblFuncionariosCadastrados.setBounds(26, 73, 209, 15);
		add(lblFuncionariosCadastrados);
		
		titleLabel = new JLabel("Edição de Funcionário");
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
		nameTextField.setBounds(253, 104, 449, 19);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(253, 138, 449, 19);
		passwordTextField.setColumns(10);
		add(passwordTextField);
		
		cpfTextField = new JFormattedTextField(mascaraCPF);
		cpfTextField.setBounds(253, 172, 449, 19);
		cpfTextField.setColumns(10);
		add(cpfTextField);
			
		phoneLabel = new JLabel("Telefone");
		phoneLabel.setBounds(26, 234, 70, 15);
		add(phoneLabel);
		
		phoneTextField = new JFormattedTextField(mascaraTelefone);
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(253, 232, 449, 19);
		add(phoneTextField);
		
		dataNascimentoDatePicker = new DatePicker();
		dataNascimentoDatePicker.setBounds(253, 259, 449, 19);
		add(dataNascimentoDatePicker);
		
		dataNascimentoLabel = new JLabel("Data Nascimento");
		dataNascimentoLabel.setBounds(26, 261, 209, 15);
		add(dataNascimentoLabel);
		
		comboBoxSexo = new JComboBox(listaSexos);
		comboBoxSexo.setBounds(253, 201, 449, 24);
		comboBoxSexo.setSelectedIndex(-1);
		add(comboBoxSexo);
		
		sexoLabel = new JLabel("Sexo");
		sexoLabel.setBounds(26, 203, 70, 15);
		add(sexoLabel);
		
		editarFuncionarioButton = new JButton("Editar funcionário");
		editarFuncionarioButton.setBounds(420, 388, 282, 25);
		editarFuncionarioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarDadosFuncionario(funcionarioController);
			}
		});
		add(editarFuncionarioButton);
		
		btnLimparCampos = new JButton("Limpar campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimparCampos.setBounds(420, 349, 282, 25);
		add(btnLimparCampos);
		
		lblAtivo = new JLabel("Ativo");
		lblAtivo.setBounds(26, 288, 70, 15);
		add(lblAtivo);
		
		comboBoxAtivo = new JComboBox(listaAtivo);
		comboBoxAtivo.setSelectedIndex(-1);
		comboBoxAtivo.setBounds(253, 290, 449, 24);
		add(comboBoxAtivo);
	

	}
}
