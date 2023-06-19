package model.view.Paginas.Funcionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.FuncionarioController;
import model.vo.FuncionarioVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FuncionarioCadastro extends JPanel {
	
	private JTextField nameTextField;
	private JTextField passwordTextField;
	private JTextField phoneTextField;
	private JTextField cpfTextField;
	
	private JLabel titleLabel;
	private JLabel nameLabel;
	private JLabel passwordLabel;
	private JLabel phoneLabel;
	private JLabel cpfLabel;
	
	private JButton cadastrarFuncionarioButton;
	
	FuncionarioVO funcionarioVO = new FuncionarioVO();
	FuncionarioController funcionarioController = new FuncionarioController(); 

	public FuncionarioCadastro() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
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
		
		cpfTextField = new JTextField();
		cpfTextField.setBounds(118, 172, 584, 19);
		cpfTextField.setColumns(10);
		add(cpfTextField);
		
		cadastrarFuncionarioButton = new JButton("Cadastrar funcionário");
		cadastrarFuncionarioButton.setBounds(420, 414, 282, 25);
		cadastrarFuncionarioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				funcionarioVO.setNome(nameTextField.getText());
				funcionarioVO.setSenha(passwordTextField.getText());
				funcionarioVO.setTelefone(phoneTextField.getText());
				funcionarioVO.setCPF(cpfTextField.getText());
				
				try {
					funcionarioController.cadastrarFuncionario(funcionarioVO);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "erro");
				}
				
			}
		});
		
		phoneLabel = new JLabel("Telefone");
		phoneLabel.setBounds(26, 205, 70, 15);
		add(phoneLabel);
		add(cadastrarFuncionarioButton);
		
		phoneTextField = new JTextField();
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(118, 203, 584, 19);
		add(phoneTextField);

	}
}
