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

public class CarroListagem extends JPanel {
	
	private JLabel titleLabel;
	private JButton btnPesquisar;
	private JButton btnEditar;
	
	CarroController carroController = new CarroController();
	
	private JTable tabelaCarros;
	private ArrayList<CarroVO> listaCarros; 
	private String[] colunasTabelas = { "Marca", "Modelo", "Ano", "Placa" } ;
	 
	private CarroVO carroSelecionado;
	
	private void inicializarTabela() {
		tabelaCarros.setModel(new DefaultTableModel(new Object[][] { colunasTabelas, }, colunasTabelas));
	}
	
	private void popularTabelaFuncionarios() {	
		this.inicializarTabela();
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
	
	private boolean deletarCarro () {
		return carroController.excluirCarro(carroSelecionado);
	}
	
	private void pesquisarListaCarros () {
		try {
			listaCarros = (ArrayList<CarroVO>) carroController.consultarListaCarros();
			popularTabelaFuncionarios();
			
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
		titleLabel.setBounds(26, 11, 702, 58);
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
		
		tabelaCarros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int indiceSelecionado = tabelaCarros.getSelectedRow();

				if (indiceSelecionado > 0) {
					btnEditar.setEnabled(true);
					carroSelecionado = listaCarros.get(indiceSelecionado - 1);
				} else {
					btnEditar.setEnabled(false);
				}
			}
		});
			
		this.inicializarTabela();

	}
}
