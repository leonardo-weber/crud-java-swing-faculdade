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

public class CarroListagem extends JPanel {
	
	private JLabel titleLabel;
	
	private JButton deleteButton;
	private JButton editButton;

	public CarroListagem() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		titleLabel = new JLabel("Listagem de carros");
		titleLabel.setBounds(26, 11, 696, 58);
		add(titleLabel);
		
		
		deleteButton = new JButton("Deletar");
		deleteButton.setBounds(40, 448, 302, 25);
		add(deleteButton);
		
		editButton = new JButton("Editar");
		editButton.setBounds(406, 448, 282, 25);
		add(editButton);

	}

}
