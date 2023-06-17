package model.view.Paginas.Cliente;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class ClienteListagem extends JPanel {

	private JLabel titleLabel;
	
	private JButton deleteButton;
	private JButton editButton;

	public ClienteListagem() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		titleLabel = new JLabel("Listagem de clientes");
		titleLabel.setBounds(26, 11, 662, 58);
		add(titleLabel);
		
		
		deleteButton = new JButton("Deletar");
		deleteButton.setBounds(40, 448, 302, 25);
		add(deleteButton);
		
		editButton = new JButton("Editar");
		editButton.setBounds(406, 448, 282, 25);
		add(editButton);

	}

}
