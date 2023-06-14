package model.view.Paginas.Funcionario;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class FuncionarioCadastro extends JPanel {

	public FuncionarioCadastro() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		
		JLabel lblNewLabel = new JLabel(" Funcionário Cadastro ");
		add(lblNewLabel);

	}

}
