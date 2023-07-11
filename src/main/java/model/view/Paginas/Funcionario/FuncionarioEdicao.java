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
import model.vo.ClienteVO;
import model.vo.FuncionarioVO;

public class FuncionarioEdicao extends JPanel {
	
	private JTextField nameTextField;
	private JTextField passwordTextField;
	private JFormattedTextField phoneTextField;
	private JFormattedTextField cpfTextField;
	private DatePicker dataNascimentoDatePicker;
	private JTextField ativoTextField;
	
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
	
	private MaskFormatter mascaraCPF;
	private MaskFormatter mascaraTelefone;
	
	private FuncionarioVO funcionario;
	
	private List<FuncionarioVO> listaFuncionariosCadastrados;
	
	public void editarDadosFuncionario (FuncionarioController funcionarioController) {
		funcionario.setNome(nameTextField.getText());
		funcionario.setCPF(cpfTextField.getText());
		funcionario.setSenha(passwordTextField.getText());
		funcionario.setDataNascimento(dataNascimentoDatePicker.getDate());
		funcionario.setAtivo(Boolean.parseBoolean(ativoTextField.getText()));
		funcionario.setTelefone(phoneTextField.getText());
		
		boolean funcionarioCadastrado = funcionarioController.atualizarFuncionario(funcionario);
		
		if (funcionarioCadastrado) {
			JOptionPane.showMessageDialog(null, "Dados do funcionário foram atualizados com sucesso");
		}
	}

	public void limparCampos() {
		nameTextField.setText("");
		passwordTextField.setText("");
		phoneTextField.setText("");
		cpfTextField.setText("");
		dataNascimentoDatePicker.setText("");
		ativoTextField.setText("");
		comboBoxSexo.setSelectedIndex(-1);
		comboBoxFuncionariosCadastrados.setSelectedIndex(-1);
	}
	
	public void preencherCamposFuncionario () {
		nameTextField.setText(funcionario.getNome());
		passwordTextField.setText(funcionario.getSenha());
		cpfTextField.setText(funcionario.getCPF());
		phoneTextField.setText(funcionario.getTelefone());
		comboBoxSexo.setSelectedItem(funcionario.getSexo());
		dataNascimentoDatePicker.setText(funcionario.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		ativoTextField.setText(Boolean.toString(funcionario.getAtivo()));
	}

	public FuncionarioEdicao() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		String[] listaSexos = {"Masculino", "Feminimo"};
		
		final FuncionarioController funcionarioController = new FuncionarioController();
		listaFuncionariosCadastrados = funcionarioController.consultarListaFuncionariosComFiltragemDeStatus(true);
		
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
		
		editarFuncionarioButton = new JButton("Editar funcionário");
		editarFuncionarioButton.setBounds(420, 388, 282, 25);
		editarFuncionarioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarDadosFuncionario(funcionarioController);
				limparCampos();
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
		
		ativoTextField = new JTextField();
		ativoTextField.setColumns(10);
		ativoTextField.setBounds(118, 290, 584, 19);
		add(ativoTextField);
	

	}
}
