package model.view.Paginas.Cliente;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.ClienteController;
import model.vo.ClienteVO;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class ClienteCadastro extends JPanel {
	
	private JTextField nameTextField;
	private JFormattedTextField phoneTextField;
	private JFormattedTextField cpfTextField;
	private JFormattedTextField cnhTextField;
	private DatePicker dataNascimentoDatePicker;
	
	private JLabel titleLabel;
	private JLabel nameLabel;
	private JLabel phoneLabel;
	private JLabel cpfLabel;
	private JLabel cnhLabel;
	private JLabel sexoLabel;
	private JLabel dataNascimentoLabel;
	
	private JButton cadastrarClienteButton;
	private JComboBox comboBoxSexo;
	
	private MaskFormatter mascaraCNH;
	private MaskFormatter mascaraCPF;
	private MaskFormatter mascaraTelefone;
	
	ClienteVO clienteVO = new ClienteVO();
	ClienteController clienteController = new ClienteController();
	private JButton btnLimparCampos;
	
	public void limparCampos() {
		nameTextField.setText("");
		phoneTextField.setText("");
		cpfTextField.setText("");
		cnhTextField.setText("");
		dataNascimentoDatePicker.setText("");
		comboBoxSexo.setSelectedIndex(-1);
	}

	public ClienteCadastro() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
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
		
		try {
			mascaraCNH = new MaskFormatter("##########");
		} catch (ParseException e1) {
			System.out.println("Erro ao inicializar variável de máscara do campo CNH");
		}
		
		mascaraCPF.setValueContainsLiteralCharacters(false);
		mascaraTelefone.setValueContainsLiteralCharacters(false);
		mascaraCNH.setValueContainsLiteralCharacters(false);
		
		String[] listaSexos = {"Masculino", "Feminimo"};
		
		titleLabel = new JLabel("Cadastro de Clientes");
		titleLabel.setBounds(26, 11, 149, 58);
		add(titleLabel);
		
		nameLabel = new JLabel("Nome");
		nameLabel.setBounds(26, 106, 70, 15);
		add(nameLabel);
		
		phoneLabel = new JLabel("Telefone");
		phoneLabel.setBounds(26, 265, 70, 15);
		add(phoneLabel);
		
		cpfLabel = new JLabel("CPF");
		cpfLabel.setBounds(26, 172, 70, 15);
		add(cpfLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(118, 104, 584, 19);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		phoneTextField = new JFormattedTextField(mascaraTelefone);
		phoneTextField.setBounds(118, 263, 584, 19);
		phoneTextField.setColumns(10);
		add(phoneTextField);
		
		cpfTextField = new JFormattedTextField(mascaraCPF);
		cpfTextField.setBounds(118, 170, 584, 19);
		cpfTextField.setColumns(10);
		add(cpfTextField);
		
		cadastrarClienteButton = new JButton("Cadastrar Cliente");
		cadastrarClienteButton.setBounds(420, 388, 282, 25);
		cadastrarClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String cpfSemMascara = (String) mascaraCPF.stringToValue(cpfTextField.getText());
					clienteVO.setCPF(cpfSemMascara);
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao converter o valor de CPF para valor sem máscara", "Erro", JOptionPane.ERROR_MESSAGE); 
				}
	
				try {
					String telefoneSemMascara = (String) mascaraTelefone.stringToValue(phoneTextField.getText());
					clienteVO.setTelefone(telefoneSemMascara);
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao converter o valor de Telefone para valor sem máscara", "Erro", JOptionPane.ERROR_MESSAGE); 
				}
				
				clienteVO.setNome(nameTextField.getText());
				clienteVO.setCNH(cnhTextField.getText());
				clienteVO.setDataNascimento(dataNascimentoDatePicker.getDate());
				clienteVO.setSexo(comboBoxSexo.getSelectedItem() != null ? comboBoxSexo.getSelectedItem().toString() : null);
				
				try {
					clienteController.cadastrarCliente(clienteVO);
					limparCampos();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o cliente");
				}
				
			}
		});
		
		cnhLabel = new JLabel("CNH");
		cnhLabel.setBounds(26, 137, 70, 15);
		add(cnhLabel);
		add(cadastrarClienteButton);
		
		cnhTextField = new JFormattedTextField(mascaraCNH);
		cnhTextField.setColumns(10);
		cnhTextField.setBounds(118, 135, 584, 19);
		add(cnhTextField);
				
		dataNascimentoDatePicker = new DatePicker();
		dataNascimentoDatePicker.setBounds(118, 232, 584, 19);
		add(dataNascimentoDatePicker);
		
		dataNascimentoLabel = new JLabel("Data Nascimento");
		dataNascimentoLabel.setBounds(26, 234, 70, 15);
		add(dataNascimentoLabel);
		
		comboBoxSexo = new JComboBox(listaSexos);
		comboBoxSexo.setBounds(118, 201, 584, 24);
		comboBoxSexo.setSelectedIndex(-1);
		add(comboBoxSexo);
		
		sexoLabel = new JLabel("Sexo");
		sexoLabel.setBounds(26, 203, 70, 15);
		add(sexoLabel);
		
		btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimparCampos.setBounds(420, 351, 282, 25);
		add(btnLimparCampos);

	}
}
