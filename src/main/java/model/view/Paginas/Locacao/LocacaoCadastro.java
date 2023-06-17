package model.view.Paginas.Locacao;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class LocacaoCadastro extends JPanel {
	
	private JTextField titleTextField;
	private JTextField dataInicialTextField;
	private JTextField dataFinalTextField;
	private JTextField valorTextField;
	
	private JLabel titleLabel;
	private JLabel dataInicialLabel;
	private JLabel dataFinalLabel;
	private JLabel valorLabel;

	public LocacaoCadastro() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		titleLabel = new JLabel("Cadastro de Locação de Carros");
		titleLabel.setBounds(26, 11, 222, 58);
		add(titleLabel);
		
		dataInicialLabel = new JLabel("Data inicial da locação");
		dataInicialLabel.setBounds(26, 106, 167, 15);
		add(dataInicialLabel);
		
		dataFinalLabel = new JLabel("Data final da locação");
		dataFinalLabel.setBounds(26, 140, 167, 15);
		add(dataFinalLabel);
		
		valorLabel = new JLabel("Valor");
		valorLabel.setBounds(26, 174, 70, 15);
		add(valorLabel);
		
		titleTextField = new JTextField();
		titleTextField.setBounds(226, 104, 476, 19);
		add(titleTextField);
		titleTextField.setColumns(10);
		
		dataInicialTextField = new JTextField();
		dataInicialTextField.setBounds(226, 138, 476, 19);
		dataInicialTextField.setColumns(10);
		add(dataInicialTextField);
		
		dataFinalTextField = new JTextField();
		dataFinalTextField.setBounds(226, 172, 476, 19);
		dataFinalTextField.setColumns(10);
		add(dataFinalTextField);
		
		JLabel lblNome_1_1_1 = new JLabel("Modelo");
		lblNome_1_1_1.setBounds(26, 205, 70, 15);
		add(lblNome_1_1_1);
		
		JButton btnNewButton = new JButton("Cadastrar Locação");
		btnNewButton.setBounds(420, 391, 282, 25);
		add(btnNewButton);
		
		valorTextField = new JTextField();
		valorTextField.setColumns(10);
		valorTextField.setBounds(226, 203, 476, 19);
		add(valorTextField);

	}

}
