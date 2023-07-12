package model.view.Paginas.Carro;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import controller.CarroController;
import model.bo.CarroBO;
import model.vo.CarroVO;
import model.vo.FuncionarioVO;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JComboBox;

public class CarroListagem extends JPanel {
	
	private JLabel titleLabel;
	private JButton btnPesquisar;
	
	CarroController carroController = new CarroController();
	
	private JTable tabelaCarros;
	private ArrayList<CarroVO> listaCarros; 
	private String[] colunasTabelas = { "Marca", "Modelo", "Ano", "Placa", "Cor", "Disponibilidade", "Ativo" } ;
	private String[] opcoesDisponibilidadeLocacao = { "Disponível", "Indisponível" };
	private String[] opcoesEstadoFrota = { "Em frota", "Fora de frota" };
	
	 
	private CarroVO carroSelecionado;
	
	private JComboBox comboBoxDisponibilidade;
	private JComboBox comboBoxEstadoFrota;
	private JButton btnLimparFiltro;
	
	private void inicializarTabela() {
		tabelaCarros.setModel(new DefaultTableModel(new Object[][] { colunasTabelas, }, colunasTabelas));
	}
	
	private void popularTabelaCarros() {	
		this.inicializarTabela();
		DefaultTableModel model = (DefaultTableModel) tabelaCarros.getModel();
		for (CarroVO carro: listaCarros) {
			String disponibilidadeCarro = carro.getDisponibilidade() == false ? "Indisponível" : "Disponível";
			String atividadeCarro = carro.getAtivo() == false ? "Fora de frota" : "Em frota";
			Object[] novaLinhaDaTabela = new Object[colunasTabelas.length];
			novaLinhaDaTabela[0] = carro.getMarca();
			novaLinhaDaTabela[1] = carro.getModelo();
;			novaLinhaDaTabela[2] = carro.getAno();
			novaLinhaDaTabela[3] = carro.getPlaca();
			novaLinhaDaTabela[4] = carro.getCor();
			novaLinhaDaTabela[5] = disponibilidadeCarro;
			novaLinhaDaTabela[6] = atividadeCarro;

			model.addRow(novaLinhaDaTabela);
		}
	}

	private void pesquisarListaCarros () {
		
		String valorComboBoxDisponibilidade = comboBoxDisponibilidade.getSelectedItem() != null ? comboBoxDisponibilidade.getSelectedItem().toString() : null;
		
		boolean filtragemPorCarrosDisponiveis = false;
		boolean filtragemPorCarrosIndisponiveis = false;
		
		if (valorComboBoxDisponibilidade != null) {
			filtragemPorCarrosDisponiveis = valorComboBoxDisponibilidade.equals("Disponível");
			filtragemPorCarrosIndisponiveis = valorComboBoxDisponibilidade.equals("Indisponível");
		}
		
		
		try {
			
			if (filtragemPorCarrosDisponiveis) {
				listaCarros = (ArrayList<CarroVO>) carroController.consultarCarrosComFiltroDeDisponibilidade(true);
			} else if (filtragemPorCarrosIndisponiveis) {
				listaCarros = (ArrayList<CarroVO>) carroController.consultarCarrosComFiltroDeDisponibilidade(false);
			} else {
				listaCarros = (ArrayList<CarroVO>) carroController.consultarListaCarros();
			}
			
			popularTabelaCarros();
			
			if (listaCarros.size() == 0) {
				JOptionPane.showMessageDialog(null, "Não existem registros de carros no banco");
			}
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "erro");
		}
	}

	public CarroListagem() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		titleLabel = new JLabel("Listagem de carros");
		titleLabel.setBounds(26, 11, 214, 58);
		add(titleLabel);
		
		comboBoxDisponibilidade = new JComboBox(opcoesDisponibilidadeLocacao);
		comboBoxEstadoFrota = new JComboBox(opcoesEstadoFrota);
			
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(603, 375, 117, 25);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarListaCarros();
			}
		});
		add(btnPesquisar);
	
		tabelaCarros = new JTable();
		tabelaCarros.setBounds(26, 81, 694, 252);
		add(tabelaCarros);
		
		btnLimparFiltro = new JButton("Limpar Filtro");
		btnLimparFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxDisponibilidade.setSelectedIndex(-1);
				comboBoxEstadoFrota.setSelectedIndex(-1);
				listaCarros = (ArrayList<CarroVO>) carroController.consultarListaCarros();
				btnLimparFiltro.setEnabled(false);
				popularTabelaCarros();
			}
		});
		btnLimparFiltro.setEnabled(false);
		btnLimparFiltro.setBounds(310, 45, 162, 25);
		add(btnLimparFiltro);
		
		final JButton btnDesativar = new JButton("Alterar status");
		btnDesativar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (carroSelecionado.getAtivo()) {
					carroController.desativarStatusCarro(carroSelecionado.getId());
				} else {
					carroController.ativarStatusCarro(carroSelecionado.getId());
				}
			}
		});
		btnDesativar.setEnabled(false);
		btnDesativar.setBounds(448, 375, 143, 25);
		add(btnDesativar);
		
		comboBoxDisponibilidade.setBounds(484, 45, 236, 24);
		comboBoxDisponibilidade.setSelectedIndex(-1);
		add(comboBoxDisponibilidade);
		
	
		JLabel lblDisponibilidadeDeLocao = new JLabel("DIsponibilidade De Locação");
		lblDisponibilidadeDeLocao.setBounds(523, 18, 236, 15);
		add(lblDisponibilidadeDeLocao);
		
		tabelaCarros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int indiceSelecionado = tabelaCarros.getSelectedRow();

				if (indiceSelecionado > 0) {
					btnDesativar.setEnabled(true);
					carroSelecionado = listaCarros.get(indiceSelecionado - 1);
					
					if (carroSelecionado.getAtivo()) {
						btnDesativar.setText("Desativar");
					} else {
						btnDesativar.setText("Ativar");
					}
				} else {
					btnDesativar.setEnabled(false);
				}
			}
		});
		
		comboBoxDisponibilidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxDisponibilidade.getSelectedIndex() > -1) {
					btnLimparFiltro.setEnabled(true);
				}
			}
		});
		
		this.inicializarTabela();

	}
}
