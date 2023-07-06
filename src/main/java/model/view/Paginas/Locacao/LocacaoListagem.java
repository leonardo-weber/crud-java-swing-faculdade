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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class LocacaoListagem extends JPanel {

	private JLabel titleLabel;
	private JButton btnPesquisar;
	private JButton btnEditar;
	
	private JTable tabelaLocacao;
	private ArrayList<LocacaoVO> listaLocacoes; 
	private LocacaoVO locacaoSelecionada;
	
	private String[] colunasTabelas = { "Data Locação", "Previsão Devolução", "Data Devolução", "Dias de atraso", "Valor", "Multa", "Valor Final", "Nome cliente", "CPF Cliente" } ;
	
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
			novaLinhaDaTabela[2] = locacao.getDataEfetivaDevolucao();
;			novaLinhaDaTabela[3] = locacaoController.calcularAtraso(locacao.getDataEfetivaDevolucao(),  locacao.getDataPrevistaDevolucao());
			novaLinhaDaTabela[4] = locacao.getValorPrevisto();
			novaLinhaDaTabela[5] = locacao.getMulta();
			novaLinhaDaTabela[6] = locacao.getValorEfetivo();
			novaLinhaDaTabela[7] = locacao.getCliente().getNome();
			novaLinhaDaTabela[8] = locacao.getCliente().getCPF();
			
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
		tabelaLocacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int indiceSelecionado = tabelaLocacao.getSelectedRow();

				if (indiceSelecionado > 0) {
					btnEditar.setEnabled(true);
					locacaoSelecionada = listaLocacoes.get(indiceSelecionado - 1);
				} else {
					btnEditar.setEnabled(false);
				}
			}
		});
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
