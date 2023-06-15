package model.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.view.Paginas.Carro.CarroCadastro;
import model.view.Paginas.Carro.CarroListagem;
import model.view.Paginas.Cliente.ClienteCadastro;
import model.view.Paginas.Cliente.ClienteListagem;
import model.view.Paginas.Funcionario.FuncionarioCadastro;
import model.view.Paginas.Funcionario.FuncionarioListagem;
import model.view.Paginas.Locacao.LocacaoCadastro;
import model.view.Paginas.Locacao.LocacaoListagem;

import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	
	private CarroCadastro cadastroDeCarros = new CarroCadastro();
	private CarroListagem listagemDeCarros = new CarroListagem();
	
	private ClienteCadastro cadastroDeCliente = new ClienteCadastro();
	private ClienteListagem listagemDeCliente = new ClienteListagem();
	
	private FuncionarioCadastro cadastroDeFuncionario = new FuncionarioCadastro();
	private FuncionarioListagem listagemDeFuncionario = new FuncionarioListagem();
	
	private LocacaoCadastro cadastroDeLocacao = new LocacaoCadastro();
	private LocacaoListagem listagemDeLocacao = new LocacaoListagem();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuItemFuncionario = new JMenu("Funcionário");
		menuBar.add(menuItemFuncionario);
		
		JMenuItem menuItemFuncionarioListagem = new JMenuItem("Listagem");
		menuItemFuncionarioListagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(listagemDeFuncionario);
				revalidate();
			}
		});
		menuItemFuncionario.add(menuItemFuncionarioListagem);
		
		JMenuItem menuItemFuncionarioCadastro = new JMenuItem("Cadastro");
		menuItemFuncionarioCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(cadastroDeFuncionario);
				revalidate();
			}
		});
		menuItemFuncionario.add(menuItemFuncionarioCadastro);
		
		JMenu menuItemCarros = new JMenu("Carros");
		menuBar.add(menuItemCarros);
		
		JMenuItem menuItemCarrosListagem = new JMenuItem("Listagem");
		menuItemCarrosListagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(listagemDeCarros);
				revalidate();
			}
		});
		menuItemCarros.add(menuItemCarrosListagem);
		
		JMenuItem menuItemCarrosCadastro = new JMenuItem("Cadastro");
		menuItemCarrosCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(cadastroDeCarros);
				revalidate();
			}
		});
		menuItemCarros.add(menuItemCarrosCadastro);
		
		JMenu menuItemLocacao = new JMenu("Locação");
		menuBar.add(menuItemLocacao);
		
		JMenuItem menuItemLocacaoListagem = new JMenuItem("Listagem");
		menuItemLocacaoListagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(listagemDeLocacao);
				revalidate();
			}
		});
		menuItemLocacao.add(menuItemLocacaoListagem);
		
		JMenuItem menuItemLocacaoCadastro = new JMenuItem("Cadastro");
		menuItemLocacaoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(cadastroDeLocacao);
				revalidate();
			}
		});
		menuItemLocacao.add(menuItemLocacaoCadastro);
		
		JMenu menuItemCliente = new JMenu("Cliente");
		menuBar.add(menuItemCliente);
		
		JMenuItem menuItemClienteListagem = new JMenuItem("Listagem");
		menuItemClienteListagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(listagemDeCliente);
				revalidate();
			}
		});
		menuItemCliente.add(menuItemClienteListagem);
		
		JMenuItem menuItemClienteCadastro = new JMenuItem("Cadastro");
		menuItemClienteCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(cadastroDeCliente);
				revalidate();
			}
		});
		menuItemCliente.add(menuItemClienteCadastro);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

}
