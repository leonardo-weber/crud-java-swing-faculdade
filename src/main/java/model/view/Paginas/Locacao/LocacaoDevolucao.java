package model.view.Paginas.Locacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class LocacaoDevolucao extends JPanel {
	
	private JLabel tituloLabel;
	
	private JButton cadastrarDevolucaoButton;
	
	public void cadastrarDevolucao () {
		
	}
	
	public void limparCamposForm () {
		
	}
	
	public LocacaoDevolucao() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		tituloLabel = new JLabel("Devolução de Locação de Carros");
		tituloLabel.setBounds(26, 11, 421, 58);
		add(tituloLabel);
		
		cadastrarDevolucaoButton = new JButton("Cadastrar Devolução");
		cadastrarDevolucaoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarDevolucao();
				limparCamposForm();
			}
		});
		cadastrarDevolucaoButton.setBounds(420, 388, 282, 25);
		add(cadastrarDevolucaoButton);

	}

}
