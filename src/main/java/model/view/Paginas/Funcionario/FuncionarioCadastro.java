package model.view.Paginas.Funcionario;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class FuncionarioCadastro extends JPanel {
	
	private JTextField nameTextField;
	private JTextField phoneTextField;
	private JTextField cpfTextField;
	
	private JLabel titleLabel;
	private JLabel nameLabel;
	private JLabel phoneLabel;
	private JLabel cpfLabel;

	public FuncionarioCadastro() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("26px"),
				ColumnSpec.decode("70px"),
				ColumnSpec.decode("22px"),
				ColumnSpec.decode("302px"),
				ColumnSpec.decode("282px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,},
			new RowSpec[] {
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("58px"),
				RowSpec.decode("35px"),
				RowSpec.decode("19px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("19px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("19px"),
				RowSpec.decode("80px"),
				RowSpec.decode("25px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		titleLabel = new JLabel("Cadastro de Funcionário");
		add(titleLabel, "2, 2, 3, 1, left, fill");
		
		nameLabel = new JLabel("Nome");
		add(nameLabel, "2, 4, fill, center");
		
		phoneLabel = new JLabel("Telefone");
		add(phoneLabel, "2, 6, fill, center");
		
		cpfLabel = new JLabel("CPF");
		add(cpfLabel, "2, 8, fill, center");
		
		nameTextField = new JTextField();
		add(nameTextField, "4, 4, 2, 1, fill, top");
		nameTextField.setColumns(10);
		
		phoneTextField = new JTextField();
		phoneTextField.setColumns(10);
		add(phoneTextField, "4, 6, 2, 1, fill, top");
		
		cpfTextField = new JTextField();
		cpfTextField.setColumns(10);
		add(cpfTextField, "4, 8, 2, 1, fill, top");
		
		JButton btnNewButton = new JButton("Cadastrar funcionário");
		add(btnNewButton, "5, 24, fill, top");

	}
}
