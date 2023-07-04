package model.view.Paginas.Funcionario;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import controller.FuncionarioController;
import model.vo.ClienteVO;
import model.vo.FuncionarioVO;


import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class FuncionarioListagem extends JPanel {

	private JLabel titleLabel;
	private JButton btnPesquisar;
	private JButton btnEditar;
	
	FuncionarioController funcionarioController = new FuncionarioController();
	
	private JTable tabelaFuncionarios;
	private ArrayList<FuncionarioVO> listaFuncionarios; 
	private String[] colunasTabelas = { "Nome", "Senha", "Telefone", "CPF", "Sexo", "Data Nascimento" } ;
	
	private FuncionarioVO funcionarioSelecionado;
		
	private void inicializarTabela() {
		tabelaFuncionarios.setModel(new DefaultTableModel(new Object[][] { colunasTabelas, }, colunasTabelas));
	}
	 
	private void popularTabelaFuncionarios() {	
		this.inicializarTabela();
		DefaultTableModel model = (DefaultTableModel) tabelaFuncionarios.getModel();
		for (FuncionarioVO func : listaFuncionarios) {
			Object[] novaLinhaDaTabela = new Object[colunasTabelas.length];
			novaLinhaDaTabela[0] = func.getNome();
			novaLinhaDaTabela[1] = func.getSenha();
			novaLinhaDaTabela[2] = func.getTelefone();
			novaLinhaDaTabela[3] = func.getCPF();
			novaLinhaDaTabela[4] = func.getSexo();
			novaLinhaDaTabela[5] = func.getDataNascimento();

			model.addRow(novaLinhaDaTabela);
		}
	}
	
	private void pesquisarListaFuncionarios () {
		try {
			listaFuncionarios = (ArrayList<FuncionarioVO>) funcionarioController.consultarListaFuncionarios();
			popularTabelaFuncionarios();
			
			if (listaFuncionarios.size() == 0) {
				JOptionPane.showMessageDialog(null, "Não existem registros de funcionários no banco");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "erro");
		}
	}
	

	public FuncionarioListagem() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		titleLabel = new JLabel("Listagem de funcionários");
		titleLabel.setBounds(26, 11, 647, 58);
		add(titleLabel);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarListaFuncionarios();			
			}
		});
		
		btnPesquisar.setBounds(603, 375, 117, 25);
		add(btnPesquisar);
		
		tabelaFuncionarios = new JTable();
		tabelaFuncionarios.setBounds(26, 81, 694, 252);
		add(tabelaFuncionarios);
		
		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.setBounds(468, 375, 117, 25);
		add(btnEditar);
		
		tabelaFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int indiceSelecionado = tabelaFuncionarios.getSelectedRow();

				if (indiceSelecionado > 0) {
					btnEditar.setEnabled(true);
					funcionarioSelecionado = listaFuncionarios.get(indiceSelecionado - 1);
				} else {
					btnEditar.setEnabled(false);
				}
			}
		});
		
		this.inicializarTabela();

	}
}
