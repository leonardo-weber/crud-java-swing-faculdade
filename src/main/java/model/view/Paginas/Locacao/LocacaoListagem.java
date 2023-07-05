package model.view.Paginas.Locacao;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import controller.LocacaoController;
import model.bo.LocacaoBO;
import model.vo.FuncionarioVO;
import model.vo.LocacaoVO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class LocacaoListagem extends JPanel {

	private JLabel titleLabel;
	private JButton btnPesquisar;
	private JButton btnEditar;
	
	private JTable tabelaLocacao;
	private ArrayList<LocacaoVO> listaLocacoes; 
	private String[] colunasTabelas = { "Data Locação", "Data Devolução", "Dias de atraso", "Valor", "Multa", "Valor Final" } ;
	
	LocacaoController locacaoController = new LocacaoController();
	
	private void inicializarTabela() {
		tabelaLocacao.setModel(new DefaultTableModel(new Object[][] { colunasTabelas, }, colunasTabelas));
	}
	
	private void popularTabelaFuncionarios() {	
		this.inicializarTabela();
		DefaultTableModel model = (DefaultTableModel) tabelaLocacao.getModel();
		for (LocacaoVO locacao : listaLocacoes) {
			Object[] novaLinhaDaTabela = new Object[colunasTabelas.length];
			novaLinhaDaTabela[0] = locacao.getDataLocacao();
			novaLinhaDaTabela[1] = locacao.getDataPrevistaDevolucao();
			novaLinhaDaTabela[2] = locacaoController.calcularAtraso(locacao.getDataEfetivaDevolucao(),  locacao.getDataPrevistaDevolucao());
			novaLinhaDaTabela[3] = locacao.getValorPrevisto();
			novaLinhaDaTabela[4] = locacao.getMulta();
			novaLinhaDaTabela[5] = locacao.getValorEfetivo();
			
			model.addRow(novaLinhaDaTabela);
		}
	}
		
	private void pesquisarListaLocacoes () {
		listaLocacoes = (ArrayList<LocacaoVO>) locacaoController.consultarListaLocacao();
		popularTabelaFuncionarios();
	}

	public LocacaoListagem() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		titleLabel = new JLabel("Listagem de locações");
		titleLabel.setBounds(26, 11, 646, 58);
		add(titleLabel);
		
		btnPesquisar = new JButton("Pesquisar"); 
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarListaLocacoes();
			}
		});
		btnPesquisar.setBounds(603, 375, 117, 25);
		add(btnPesquisar);
		
		tabelaLocacao = new JTable();
		tabelaLocacao.setBounds(26, 81, 694, 252);
		add(tabelaLocacao);
			 
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setEnabled(false);
		btnEditar.setBounds(468, 375, 117, 25);
		add(btnEditar);
		
		this.inicializarTabela();

	}

}
