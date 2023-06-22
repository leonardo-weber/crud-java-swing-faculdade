package model.view.Paginas.Carro;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import model.bo.CarroBO;
import model.vo.CarroVO;
import model.vo.FuncionarioVO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CarroListagem extends JPanel {
	
	private JLabel titleLabel;
	private JButton btnPesquisar;
	
	CarroBO carroBO = new CarroBO();
	
	private JTable tabelaCarros;
	private ArrayList<CarroVO> listaCarros; 
	private String[] colunasTabelas = { "Marca", "Modelo", "Ano", "Placa" } ;
	private JButton btnDeletar;
	private JButton btnEditar;
	
	private void inicializarTabela() {
		tabelaCarros.setModel(new DefaultTableModel(new Object[][] { colunasTabelas, }, colunasTabelas));
	}
	
	private void popularTabelaFuncionarios() {	
		DefaultTableModel model = (DefaultTableModel) tabelaCarros.getModel();
		for (CarroVO carro: listaCarros) {
			Object[] novaLinhaDaTabela = new Object[colunasTabelas.length];
			novaLinhaDaTabela[0] = carro.getMarca();
			novaLinhaDaTabela[1] = carro.getModelo();
;			novaLinhaDaTabela[2] = carro.getAno();
			novaLinhaDaTabela[3] = carro.getPlaca();

			model.addRow(novaLinhaDaTabela);
		}
	}

	public CarroListagem() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		titleLabel = new JLabel("Listagem de carros");
		titleLabel.setBounds(26, 11, 696, 58);
		add(titleLabel);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					listaCarros = (ArrayList<CarroVO>) carroBO.consultarListaCarros();
					popularTabelaFuncionarios();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "erro");
				}
				
			}
		});
		btnPesquisar.setBounds(572, 375, 117, 25);
		add(btnPesquisar);
		
		tabelaCarros = new JTable();
		tabelaCarros.setBounds(26, 81, 663, 252);
		add(tabelaCarros);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(443, 375, 117, 25);
		add(btnDeletar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(314, 375, 117, 25);
		add(btnEditar);
		
		this.inicializarTabela();

	}
}
