package model.view.Paginas.Funcionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
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
	
	private JComboBox comboBoxFuncionariosCadastrados;
	private JLabel lblFuncionariosCadastrados;
	
	private List<FuncionarioVO> listaFuncionariosCadastrados;
	

	public FuncionarioEdicao() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		String[] listaSexos = {"Masculino", "Feminimo"};
		
		FuncionarioController funcionarioController = new FuncionarioController();
		listaFuncionariosCadastrados = funcionarioController.consultarListaFuncionarios();
		
		comboBoxFuncionariosCadastrados = new JComboBox(listaFuncionariosCadastrados.toArray());
		comboBoxFuncionariosCadastrados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		cadastrarFuncionarioButton = new JButton("Cadastrar funcionário");
		cadastrarFuncionarioButton.setBounds(420, 388, 282, 25);
		cadastrarFuncionarioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
			}
		});
		add(cadastrarFuncionarioButton);
		
		btnLimparCampos = new JButton("Limpar campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		btnLimparCampos.setBounds(420, 349, 282, 25);
		add(btnLimparCampos);
	

	}

}
