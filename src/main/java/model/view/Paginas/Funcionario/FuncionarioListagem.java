package model.view.Paginas.Funcionario;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import model.bo.FuncionarioBO;
import model.vo.FuncionarioVO;


import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class FuncionarioListagem extends JPanel {

	private JLabel titleLabel;
	private JButton btnPesquisar;
	
	FuncionarioBO funcionarioBO = new FuncionarioBO();
	
	private JTable funcionariosTable;
	private ArrayList<FuncionarioVO> funcionarios; 
	private String[] colunasTabelas = { "Nome", "Senha", "Telefone", "CPF" } ;
	private JButton btnDeletar;
	private JButton btnEditar;
	
	private void inicializarTabela() {
		funcionariosTable.setModel(new DefaultTableModel(new Object[][] { colunasTabelas, }, colunasTabelas));
	}
	
	private void popularTabelaFuncionarios() {	
		DefaultTableModel model = (DefaultTableModel) funcionariosTable.getModel();
		for (FuncionarioVO func : funcionarios) {
			Object[] novaLinhaDaTabela = new Object[colunasTabelas.length];
			novaLinhaDaTabela[0] = func.getNome();
			novaLinhaDaTabela[1] = func.getSenha();
			novaLinhaDaTabela[2] = func.getTelefone();
			novaLinhaDaTabela[3] = func.getCPF();

			model.addRow(novaLinhaDaTabela);
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
				
				try {
					funcionarios = (ArrayList<FuncionarioVO>) funcionarioBO.consultarListaFuncionarios();
					popularTabelaFuncionarios();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "erro");
				}
				
			}
		});
		
		btnPesquisar.setBounds(572, 375, 117, 25);
		add(btnPesquisar);
		
		funcionariosTable = new JTable();
		funcionariosTable.setBounds(26, 81, 663, 252);
		add(funcionariosTable);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(443, 375, 117, 25);
		add(btnDeletar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(314, 375, 117, 25);
		add(btnEditar);
		
		this.inicializarTabela();

	}
}
