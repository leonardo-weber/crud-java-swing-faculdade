package model.view.Paginas.Carro;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class CarroListagem extends JPanel {

	public CarroListagem() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		
		JLabel lblNewLabel = new JLabel("Carro Listagem");
		add(lblNewLabel);

	}

}
