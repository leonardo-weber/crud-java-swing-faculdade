package model.view.Paginas.Locacao;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;

import model.bo.LocacaoBO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LocacaoListagem extends JPanel {

	private JLabel titleLabel;
	private JButton btnNewButton;
	private JTable tabelaLocacao;
	
	private JButton btnEditar;
	private JButton btnAtualizar;
	LocacaoBO locacaoBO = new LocacaoBO();

	public LocacaoListagem() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		titleLabel = new JLabel("Listagem de locações");
		titleLabel.setBounds(26, 11, 646, 58);
		add(titleLabel);
		
		btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					locacaoBO.consultarListaLocacao();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "erro");
				}
				
			}
		});
		btnNewButton.setBounds(572, 375, 117, 25);
		add(btnNewButton);
		
		tabelaLocacao = new JTable();
		tabelaLocacao.setBounds(26, 81, 663, 252);
		add(tabelaLocacao);
		
		btnEditar = new JButton("Deletar");
		btnEditar.setBounds(443, 375, 117, 25);
		add(btnEditar);
		
		btnAtualizar = new JButton("Editar");
		btnAtualizar.setBounds(314, 375, 117, 25);
		add(btnAtualizar);

	}

}
