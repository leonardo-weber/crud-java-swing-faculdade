package model.view.Paginas.Locacao;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class LocacaoCadastro extends JPanel {

	public LocacaoCadastro() {
		setBackground(UIManager.getColor("Button.darkShadow"));
		
		JLabel lblNewLabel = new JLabel("Locacao Cadastro");
		add(lblNewLabel);

	}

}
