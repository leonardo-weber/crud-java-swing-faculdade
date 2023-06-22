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
	private JButton btnDeletar;
	private JButton btnEditar;
	
	FuncionarioController funcionarioController = new FuncionarioController();
	
	private JTable tabelaFuncionarios;
	private ArrayList<FuncionarioVO> listaFuncionarios; 
	private String[] colunasTabelas = { "Nome", "Senha", "Telefone", "CPF" } ;
	
	private FuncionarioVO funcionarioSelecionado;
		
	private void inicializarTabela() {
		tabelaFuncionarios.setModel(new DefaultTableModel(new Object[][] { colunasTabelas, }, colunasTabelas));
	}
	
	private void popularTabelaFuncionarios() {	
		DefaultTableModel model = (DefaultTableModel) tabelaFuncionarios.getModel();
		for (FuncionarioVO func : listaFuncionarios) {
			Object[] novaLinhaDaTabela = new Object[colunasTabelas.length];
			novaLinhaDaTabela[0] = func.getNome();
			novaLinhaDaTabela[1] = func.getSenha();
			novaLinhaDaTabela[2] = func.getTelefone();
			novaLinhaDaTabela[3] = func.getCPF();

			model.addRow(novaLinhaDaTabela);
		}
	}
	
	private boolean deletarFuncionario () {
		return funcionarioController.excluirFuncionario(funcionarioSelecionado);
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
				
				try {
					listaFuncionarios = (ArrayList<FuncionarioVO>) funcionarioController.consultarListaFuncionarios();
					popularTabelaFuncionarios();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "erro");
				}
				
			}
		});
		
		btnPesquisar.setBounds(572, 375, 117, 25);
		add(btnPesquisar);
		
		tabelaFuncionarios = new JTable();
		tabelaFuncionarios.setBounds(26, 81, 663, 252);
		add(tabelaFuncionarios);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setEnabled(false);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarFuncionario();
			}
		});
		btnDeletar.setBounds(443, 375, 117, 25);
		add(btnDeletar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.setBounds(314, 375, 117, 25);
		add(btnEditar);
		
		tabelaFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int indiceSelecionado = tabelaFuncionarios.getSelectedRow();

				if (indiceSelecionado > 0) {
					btnEditar.setEnabled(true);
					btnDeletar.setEnabled(true);
					funcionarioSelecionado = listaFuncionarios.get(indiceSelecionado - 1);
				} else {
					btnEditar.setEnabled(false);
					btnDeletar.setEnabled(false);
				}
			}
		});
		
		this.inicializarTabela();

	}
}
