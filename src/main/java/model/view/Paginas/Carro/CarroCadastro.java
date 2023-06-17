package model.view.Paginas.Carro;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class CarroCadastro extends JPanel {

	private JTextField titleTextField;
	private JTextField marcaTextField;
	private JTextField modeloTextField;
	private JTextField anoTextField;
	
	private JLabel titleLabel;
	private JLabel marcaLabel;
	private JLabel modeloLabel;
	private JLabel anoLabel;
	
	public CarroCadastro() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		titleLabel = new JLabel("Cadastro de carros");
		titleLabel.setBounds(26, 11, 136, 58);
		add(titleLabel);
		
		marcaLabel = new JLabel("Marca");
		marcaLabel.setBounds(26, 106, 70, 15);
		add(marcaLabel);
		
		modeloLabel = new JLabel("Modelo");
		modeloLabel.setBounds(26, 140, 70, 15);
		add(modeloLabel);
		
		anoLabel = new JLabel("Ano de fabricação");
		anoLabel.setBounds(26, 174, 70, 15);
		add(anoLabel);
		
		titleTextField = new JTextField();
		titleTextField.setBounds(118, 104, 584, 19);
		add(titleTextField);
		titleTextField.setColumns(10);
		
		marcaTextField = new JTextField();
		marcaTextField.setBounds(118, 138, 584, 19);
		marcaTextField.setColumns(10);
		add(marcaTextField);
		
		modeloTextField = new JTextField();
		modeloTextField.setBounds(118, 172, 584, 19);
		modeloTextField.setColumns(10);
		add(modeloTextField);
		
		JLabel lblNome_1_1_1 = new JLabel("Placa");
		lblNome_1_1_1.setBounds(26, 213, 70, 15);
		add(lblNome_1_1_1);
		
		JButton btnNewButton = new JButton("Cadastrar carro");
		btnNewButton.setBounds(420, 396, 282, 25);
		add(btnNewButton);
		
		anoTextField = new JTextField();
		anoTextField.setColumns(10);
		anoTextField.setBounds(118, 211, 584, 19);
		add(anoTextField);

	}

}
