package model.view.Paginas.Funcionario;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class FuncionarioListagem extends JPanel {

	private JLabel titleLabel;
	
	private JButton deleteButton;
	private JButton editButton;

	public FuncionarioListagem() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		titleLabel = new JLabel("Listagem de funcionários");
		titleLabel.setBounds(26, 11, 647, 58);
		add(titleLabel);
		
		
		deleteButton = new JButton("Deletar");
		deleteButton.setBounds(40, 448, 302, 25);
		add(deleteButton);
		
		editButton = new JButton("Editar");
		editButton.setBounds(406, 448, 282, 25);
		add(editButton);

	}

}
