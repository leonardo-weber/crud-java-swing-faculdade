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
	private JButton btnEditar;
	
	CarroController carroController = new CarroController();
	
	private JTable tabelaCarros;
	private ArrayList<CarroVO> listaCarros; 
	private String[] colunasTabelas = { "Marca", "Modelo", "Ano", "Placa", "Cor", "Disponibilidade", "Ativo" } ;
	private String[] opcoesDisponibilidade = { "Disponível", "Indisponível" };
	 
	private CarroVO carroSelecionado;
	
	private JComboBox comboBoxDisponibilidade;
	private JButton btnLimparFiltro;
	
	private void inicializarTabela() {
		tabelaCarros.setModel(new DefaultTableModel(new Object[][] { colunasTabelas, }, colunasTabelas));
	}
	
	private void popularTabelaCarros() {	
		this.inicializarTabela();
		DefaultTableModel model = (DefaultTableModel) tabelaCarros.getModel();
		for (CarroVO carro: listaCarros) {
			String disponibilidadeCarro = carro.getDisponibilidade() == false ? "Indisponível" : "Disponível";
			Object[] novaLinhaDaTabela = new Object[colunasTabelas.length];
			novaLinhaDaTabela[0] = carro.getMarca();
			novaLinhaDaTabela[1] = carro.getModelo();
;			novaLinhaDaTabela[2] = carro.getAno();
			novaLinhaDaTabela[3] = carro.getPlaca();
			novaLinhaDaTabela[4] = carro.getCor();
			novaLinhaDaTabela[5] = disponibilidadeCarro;
			novaLinhaDaTabela[6] = carro.getAtivo();

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
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(603, 375, 117, 25);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarListaCarros();
			}
		});
		add(btnPesquisar);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setBounds(468, 375, 117, 25);
		btnEditar.setEnabled(false);
		add(btnEditar);
	
		tabelaCarros = new JTable();
		tabelaCarros.setBounds(26, 81, 694, 252);
		add(tabelaCarros);
		
		comboBoxDisponibilidade = new JComboBox(opcoesDisponibilidade);
		comboBoxDisponibilidade.setBounds(540, 28, 180, 24);
		comboBoxDisponibilidade.setSelectedIndex(-1);
		add(comboBoxDisponibilidade);
		
		btnLimparFiltro = new JButton("Limpar Filtro");
		btnLimparFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxDisponibilidade.setSelectedIndex(-1);
				listaCarros = (ArrayList<CarroVO>) carroController.consultarListaCarros();
				popularTabelaCarros();
			}
		});
		btnLimparFiltro.setBounds(354, 28, 162, 25);
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
		btnDesativar.setBounds(333, 375, 117, 25);
		add(btnDesativar);
		
		tabelaCarros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int indiceSelecionado = tabelaCarros.getSelectedRow();

				if (indiceSelecionado > 0) {
					btnEditar.setEnabled(true);
					btnDesativar.setEnabled(true);
					carroSelecionado = listaCarros.get(indiceSelecionado - 1);
					
					if (carroSelecionado.getAtivo()) {
						btnDesativar.setText("Desativar");
					} else {
						btnDesativar.setText("Ativar");
					}
				} else {
					btnEditar.setEnabled(false);
					btnDesativar.setEnabled(true);
				}
			}
		});
			
		this.inicializarTabela();

	}
}
