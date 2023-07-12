package model.view.Paginas.Cliente;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;
import model.vo.ClienteVO;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ClienteListagem extends JPanel {

	private JLabel titleLabel;
 	
	private JTable tabelaClientes;
	private ArrayList<ClienteVO> listaClientes; 
	private String[] colunasTabelas = {"Nome", "CPF", "Telefone", "CNH", "Sexo", "Data de Nascimento",};
	
	ClienteController clienteController = new ClienteController();
			
	private void inicializarTabela() {
		tabelaClientes.setModel(new DefaultTableModel(new Object[][] { colunasTabelas, }, colunasTabelas));
	}
	
	private void popularTabelaFuncionarios() {
		this.inicializarTabela();
		DefaultTableModel model = (DefaultTableModel) tabelaClientes.getModel();
		for (ClienteVO cliente : listaClientes) {
			Object[] novaLinhaDaTabela = new Object[colunasTabelas.length];
			novaLinhaDaTabela[0] = cliente.getNome();
			novaLinhaDaTabela[1] = cliente.getCPF();
			novaLinhaDaTabela[2] = cliente.getTelefone();
			novaLinhaDaTabela[3] = cliente.getCNH();
			novaLinhaDaTabela[4] = cliente.getSexo();
			novaLinhaDaTabela[5] = cliente.getDataNascimento();

			model.addRow(novaLinhaDaTabela);
		}
	}
		
	public void pesquisarListaClientes () {
		try {
			listaClientes = (ArrayList<ClienteVO>) clienteController.consultarListaClientes();
			popularTabelaFuncionarios();
			
			if (listaClientes.size() == 0) {
				JOptionPane.showMessageDialog(null, "Não existem registros de clientes no banco");
			}
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "erro");
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
				pesquisarListaClientes();			
			}
		});
		btnPesquisar.setBounds(603, 375, 117, 25);
		add(btnPesquisar);
		
		tabelaClientes = new JTable();
		tabelaClientes.setBounds(26, 81, 694, 252);
		add(tabelaClientes);
		
		this.inicializarTabela();

	}
}
