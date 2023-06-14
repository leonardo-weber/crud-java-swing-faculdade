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
		
		JMenu mnNewMenu = new JMenu("Funcionário");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Listagem");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(listagemDeFuncionario);
				revalidate();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmCadastro = new JMenuItem("Cadastro");
		mntmCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(cadastroDeFuncionario);
				revalidate();
			}
		});
		mnNewMenu.add(mntmCadastro);
		
		JMenu mnNewMenu_1 = new JMenu("Carros");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmListagem = new JMenuItem("Listagem");
		mntmListagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(listagemDeCarros);
				revalidate();
			}
		});
		mnNewMenu_1.add(mntmListagem);
		
		JMenuItem mntmCadastro_1 = new JMenuItem("Cadastro");
		mntmCadastro_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(cadastroDeCarros);
				revalidate();
			}
		});
		mnNewMenu_1.add(mntmCadastro_1);
		
		JMenu mnNewMenu_2 = new JMenu("Locação");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmListagem_1 = new JMenuItem("Listagem");
		mntmListagem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(listagemDeLocacao);
				revalidate();
			}
		});
		mnNewMenu_2.add(mntmListagem_1);
		
		JMenuItem mntmCadastro_1_1 = new JMenuItem("Cadastro");
		mntmCadastro_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(cadastroDeLocacao);
				revalidate();
			}
		});
		mnNewMenu_2.add(mntmCadastro_1_1);
		
		JMenu mnNewMenu_3 = new JMenu("Cliente");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listagem");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(listagemDeCliente);
				revalidate();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_1_2 = new JMenuItem("Cadastro");
		mntmNewMenuItem_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(cadastroDeCliente);
				revalidate();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_1_2);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

}
