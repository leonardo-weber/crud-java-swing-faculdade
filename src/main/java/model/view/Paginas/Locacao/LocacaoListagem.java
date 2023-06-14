package model.view.Paginas.Locacao;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class LocacaoListagem extends JPanel {

	public LocacaoListagem() {
		setBackground(UIManager.getColor("Button.darkShadow"));
		
		JLabel lblNewLabel = new JLabel("Locacao Listagem");
		add(lblNewLabel);

	}

}
