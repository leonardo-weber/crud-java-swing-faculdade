package model.view.Paginas.Carro;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class CarroCadastro extends JPanel {

	public CarroCadastro() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		
		JLabel lblNewLabel = new JLabel("Carro Cadastro");
		add(lblNewLabel);

	}

}
