package model.view.Paginas.Cliente;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import model.bo.ClienteBO;
import model.vo.ClienteVO;
import model.vo.FuncionarioVO;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ClienteListagem extends JPanel {

	private JLabel titleLabel;
	
	private JTable tabelaClientes;
	private ArrayList<ClienteVO> clientes; 
	private String[] colunasTabelas = {"Nome", "CPF", "Telefone", "CNH"};
	
	ClienteBO clienteBO = new ClienteBO();
	private JButton btnEditar;
	private JButton btnAtualizar;
	
	private void inicializarTabela() {
		tabelaClientes.setModel(new DefaultTableModel(new Object[][] { colunasTabelas, }, colunasTabelas));
	}
	
	private void popularTabelaFuncionarios() {	
		DefaultTableModel model = (DefaultTableModel) tabelaClientes.getModel();
		for (ClienteVO cliente : clientes) {
			Object[] novaLinhaDaTabela = new Object[colunasTabelas.length];
			novaLinhaDaTabela[0] = cliente.getNome();
			novaLinhaDaTabela[1] = cliente.getCPF();
			novaLinhaDaTabela[2] = cliente.getTelefone();
			novaLinhaDaTabela[3] = cliente.getCNH();

			model.addRow(novaLinhaDaTabela);
		}
	}

	public ClienteListagem() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
	
		titleLabel = new JLabel("Listagem de clientes");
		titleLabel.setBounds(26, 11, 662, 58);
		add(titleLabel);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					clientes = (ArrayList<ClienteVO>) clienteBO.consultarListaClientes();
					popularTabelaFuncionarios();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "erro");
				}
				
			}
		});
		btnPesquisar.setBounds(572, 375, 117, 25);
		add(btnPesquisar);
		
		tabelaClientes = new JTable();
		tabelaClientes.setBounds(26, 81, 663, 252);
		add(tabelaClientes);
		
		btnEditar = new JButton("Deletar");
		btnEditar.setBounds(443, 375, 117, 25);
		add(btnEditar);
		
		btnAtualizar = new JButton("Editar");
		btnAtualizar.setBounds(314, 375, 117, 25);
		add(btnAtualizar);
		
		this.inicializarTabela();

	}
}
