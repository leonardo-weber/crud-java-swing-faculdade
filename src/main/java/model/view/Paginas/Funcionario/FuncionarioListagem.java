package model.view.Paginas.Funcionario;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class FuncionarioListagem extends JPanel {

	public FuncionarioListagem() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		
		JLabel lblNewLabel = new JLabel("Listagem Funcionário");
		add(lblNewLabel);

	}

}
