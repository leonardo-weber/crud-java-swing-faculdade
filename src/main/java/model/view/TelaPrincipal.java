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
import model.view.Paginas.Locacao.LocacaoDevolucao;
import model.view.Paginas.Locacao.LocacaoListagem;
import model.view.Paginas.Sobre.SobreLogOut;

import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel title;
	private JLabel subtitle;
	
	private CarroCadastro cadastroDeCarros = new CarroCadastro();
	private CarroListagem listagemDeCarros = new CarroListagem();
	
	private ClienteCadastro cadastroDeCliente = new ClienteCadastro();
	private ClienteListagem listagemDeCliente = new ClienteListagem();
	
	private FuncionarioCadastro cadastroDeFuncionario = new FuncionarioCadastro();
	private FuncionarioListagem listagemDeFuncionario = new FuncionarioListagem();
	
	private LocacaoCadastro cadastroDeLocacao = new LocacaoCadastro();
	private LocacaoListagem listagemDeLocacao = new LocacaoListagem();
	private LocacaoDevolucao devolucaoDeLocacao = new LocacaoDevolucao();
	
	private SobreLogOut sobreLogOut = new SobreLogOut();
	
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
		
		JMenuItem menuItemLocacaoDevolucao = new JMenuItem("Devolução");
		menuItemLocacaoDevolucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(devolucaoDeLocacao);
				revalidate();
			}
		});
		menuItemLocacao.add(menuItemLocacaoDevolucao);
		
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
		
		JMenu menuItemSobre = new JMenu("Sobre");
		menuBar.add(menuItemSobre);
		
		JMenuItem menuItemSobreLogOut = new JMenuItem("Log Out");
		menuItemSobreLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sobreLogOut.setVisible(true);
			}
		});
		menuItemSobre.add(menuItemSobreLogOut);
		
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		title = new JLabel("BASTOS");
		title.setFont(new Font("Dialog", Font.BOLD, 41));
		title.setBounds(268, 146, 288, 49);
		contentPane.add(title);
		
		subtitle = new JLabel("ALUGUEL DE CARROS");
		subtitle.setFont(new Font("Dialog", Font.BOLD, 20));
		subtitle.setBounds(240, 207, 288, 24);
		contentPane.add(subtitle);
	}

}
