package model.view.Paginas.Cliente;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.ClienteController;
import model.vo.ClienteVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteCadastro extends JPanel {
	
	private JTextField nameTextField;
	private JTextField phoneTextField;
	private JTextField cpfTextField;
	private JTextField cnhTextField;
	
	private JLabel titleLabel;
	private JLabel nameLabel;
	private JLabel phoneLabel;
	private JLabel cpfLabel;
	private JLabel cnhLabel;
	
	private JButton cadastrarClienteButton;
	
	ClienteVO clienteVO = new ClienteVO();
	ClienteController clienteController = new ClienteController();

	public ClienteCadastro() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		titleLabel = new JLabel("Cadastro de Clientes");
		titleLabel.setBounds(26, 11, 149, 58);
		add(titleLabel);
		
		nameLabel = new JLabel("Nome");
		nameLabel.setBounds(26, 106, 70, 15);
		add(nameLabel);
		
		phoneLabel = new JLabel("Telefone");
		phoneLabel.setBounds(26, 140, 70, 15);
		add(phoneLabel);
		
		cpfLabel = new JLabel("CPF");
		cpfLabel.setBounds(26, 174, 70, 15);
		add(cpfLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(118, 104, 584, 19);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		phoneTextField = new JTextField();
		phoneTextField.setBounds(118, 138, 584, 19);
		phoneTextField.setColumns(10);
		add(phoneTextField);
		
		cpfTextField = new JTextField();
		cpfTextField.setBounds(118, 172, 584, 19);
		cpfTextField.setColumns(10);
		add(cpfTextField);
		
		cadastrarClienteButton = new JButton("Cadastrar Cliente");
		cadastrarClienteButton.setBounds(420, 414, 282, 25);
		cadastrarClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clienteVO.setNome(nameTextField.getText());
				clienteVO.setTelefone(phoneTextField.getText());
				clienteVO.setCPF(cpfTextField.getText());
				clienteVO.setCNH(cnhTextField.getText());
				
				try {
					clienteController.cadastrarCliente(clienteVO);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "erro");
				}
				
			}
		});
		
		cnhLabel = new JLabel("CNH");
		cnhLabel.setBounds(26, 205, 70, 15);
		add(cnhLabel);
		add(cadastrarClienteButton);
		
		cnhTextField = new JTextField();
		cnhTextField.setColumns(10);
		cnhTextField.setBounds(118, 203, 584, 19);
		add(cnhTextField);

	}
}
