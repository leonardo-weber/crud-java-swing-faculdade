package model.view.Paginas.Cliente;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class ClienteCadastro extends JPanel {

	public ClienteCadastro() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		
		JLabel lblNewLabel = new JLabel("Cliente Cadastro");
		add(lblNewLabel);

	}

}
