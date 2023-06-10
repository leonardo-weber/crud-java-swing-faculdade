package model.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

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
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmCadastro = new JMenuItem("Cadastro");
		mnNewMenu.add(mntmCadastro);
		
		JMenu mnNewMenu_1 = new JMenu("Carros");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmListagem = new JMenuItem("Listagem");
		mnNewMenu_1.add(mntmListagem);
		
		JMenuItem mntmCadastro_1 = new JMenuItem("Cadastro");
		mnNewMenu_1.add(mntmCadastro_1);
		
		JMenu mnNewMenu_2 = new JMenu("Locação");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmListagem_1 = new JMenuItem("Listagem");
		mnNewMenu_2.add(mntmListagem_1);
		
		JMenuItem mntmCadastro_1_1 = new JMenuItem("Cadastro");
		mnNewMenu_2.add(mntmCadastro_1_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

}
