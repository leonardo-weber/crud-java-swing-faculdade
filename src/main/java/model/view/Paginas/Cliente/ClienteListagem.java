package model.view.Paginas.Cliente;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;
import model.bo.ClienteBO;
import model.vo.CarroVO;
import model.vo.ClienteVO;
import model.vo.FuncionarioVO;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ClienteListagem extends JPanel {

	private JLabel titleLabel;
	private JButton btnEditar;
 	
	private JTable tabelaClientes;
	private ArrayList<ClienteVO> listaClientes; 
	private String[] colunasTabelas = {"Nome", "CNH", "CPF", "Sexo", "Telefone", "Data de Nascimento",};
	
	ClienteController clienteController = new ClienteController();
		
	private ClienteVO clienteSelecionado;
	
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
	
	private boolean deletarCliente () {
		return clienteController.excluirCliente(clienteSelecionado);
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
		
		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.setBounds(468, 375, 117, 25);
		add(btnEditar);
		
		tabelaClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int indiceSelecionado = tabelaClientes.getSelectedRow();

				if (indiceSelecionado > 0) {
					btnEditar.setEnabled(true);
					clienteSelecionado = listaClientes.get(indiceSelecionado - 1);
				} else {
					btnEditar.setEnabled(false);
				}
			}
		});
		
		this.inicializarTabela();

	}
}
