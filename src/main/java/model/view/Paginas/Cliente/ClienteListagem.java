package model.view.Paginas.Cliente;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class ClienteListagem extends JPanel {

	public ClienteListagem() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		
		JLabel lblNewLabel = new JLabel("Cliente Listagem");
		add(lblNewLabel);

	}

}
