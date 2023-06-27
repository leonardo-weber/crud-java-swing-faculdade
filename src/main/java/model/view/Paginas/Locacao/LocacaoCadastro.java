package model.view.Paginas.Locacao;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import controller.CarroController;
import controller.ClienteController;
import controller.LocacaoController;
import model.vo.CarroVO;
import model.vo.ClienteVO;
import model.vo.LocacaoVO;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

public class LocacaoCadastro extends JPanel {
	
	private JFormattedTextField dataInicialTextField;
	private JFormattedTextField dataFinalTextField;
	private JTextField valorTextField;
	private JFormattedTextField cpfClienteTextField;
	
	private JTextField nomeClienteTextField;
	private JTextField telefoneClienteTextField;
	private JTextField cnhClienteTextField;
	
	private JLabel titleLabel;
	private JLabel dataInicialLabel;
	private JLabel dataFinalLabel;
	private JLabel valorLabel;
	private JLabel carroLabel;
	private JLabel cpfClienteLabel;
	
	private JLabel nomeClienteLabel;
	private JLabel telefoneClienteLabel;
	private JLabel cnhClienteLabel;
	
	private JButton cadastrarLocacaoButton;
	private JButton limparCamposBotao;
	private JButton btnBuscarCliente;
	
	private JComboBox comboBoxCarro;
	
	private ClienteVO cliente;
	
	private List<CarroVO> listaCarros;
	
	CarroController carroController = new CarroController();
	ClienteController clienteController = new ClienteController();

	LocacaoVO locacaoVO = new LocacaoVO();
	LocacaoController locacaoController = new LocacaoController();
	
	private MaskFormatter mascaraCPF;
	private MaskFormatter mascaraData;
	
	public void limparCamposForm () {
		dataInicialTextField.setText("");
		dataFinalTextField.setText("");
		valorTextField.setText("");
		cpfClienteTextField.setText("");
		nomeClienteTextField.setText("");
		telefoneClienteTextField.setText("");
		cnhClienteTextField.setText("");
	}
	
	public void preencherCamposCliente () {
		nomeClienteTextField.setText(cliente.getNome());
		telefoneClienteTextField.setText(cliente.getTelefone());
		cnhClienteTextField.setText(cliente.getCNH());
	} 
	
	public void cadastrarLocacao () {
		
		try {
			String cpfSemMascara = (String)  mascaraCPF.stringToValue(cpfClienteTextField.getText());
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Erro ao converter o CPF", "Erro", JOptionPane.ERROR_MESSAGE); 
		}
		
		locacaoVO.getDataPrevistaDevolucao(dataInicialTextField.getText());
		locacaoVO.getDataEfetivaDevolucao(dataFinalTextField.getText());
		locacaoVO.getCarro(modeloTextField.getText());
		locacaoVO.getCliente();
		locacaoVO.getCarro();

		try {
			 locacaoController.cadastrarLocacao(locacaoVO);
			 JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "erro");
		}
	}

	public LocacaoCadastro() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		try {
			mascaraCPF = new MaskFormatter("###.###.###-##");
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		mascaraCPF.setValueContainsLiteralCharacters(false);
		mascaraData.setValueContainsLiteralCharacters(false);
		
		listaCarros = carroController.consultarListaCarros();
				
		titleLabel = new JLabel("Cadastro de Locação de Carros");
		titleLabel.setBounds(26, 11, 222, 58);
		add(titleLabel);
		
		dataInicialLabel = new JLabel("Data inicial da locação");
		dataInicialLabel.setBounds(26, 106, 167, 15);
		add(dataInicialLabel);
		
		dataFinalLabel = new JLabel("Data final da locação");
		dataFinalLabel.setBounds(26, 140, 167, 15);
		add(dataFinalLabel);
		
		valorLabel = new JLabel("Valor");
		valorLabel.setBounds(26, 174, 70, 15);
		add(valorLabel);
		
		dataInicialTextField = new JFormattedTextField(mascaraData);
		dataInicialTextField.setBounds(226, 104, 476, 19);
		add(dataInicialTextField);
		dataInicialTextField.setColumns(10);
		
		dataFinalTextField = new JFormattedTextField(mascaraData);
		dataFinalTextField.setBounds(226, 138, 476, 19);
		dataFinalTextField.setColumns(10);
		add(dataFinalTextField);
		
		valorTextField = new JTextField();
		valorTextField.setBounds(226, 172, 476, 19);
		valorTextField.setColumns(10);
		add(valorTextField);
		
		carroLabel = new JLabel("Carro");
		carroLabel.setBounds(26, 205, 70, 15);
		add(carroLabel);
		
		cpfClienteLabel = new JLabel("CPF do Cliente");
		cpfClienteLabel.setBounds(26, 244, 102, 15);
		add(cpfClienteLabel);
					
		comboBoxCarro = new JComboBox(listaCarros.toArray());
		comboBoxCarro.setBounds(226, 203, 476, 24);
		add(comboBoxCarro);
		
		cadastrarLocacaoButton = new JButton("Cadastrar Locação");
		cadastrarLocacaoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarLocacao();
				limparCamposForm();
			}
		});
		cadastrarLocacaoButton.setBounds(420, 388, 282, 25);
		add(cadastrarLocacaoButton);
			
		nomeClienteLabel = new JLabel("Nome do cliente");
		nomeClienteLabel.setBounds(26, 340, 122, 15);
		add(nomeClienteLabel);
		
		nomeClienteTextField = new JTextField();
		nomeClienteTextField.setColumns(10);
		nomeClienteTextField.setBounds(190, 338, 107, 19);
		add(nomeClienteTextField);
		
		telefoneClienteTextField = new JTextField();
		telefoneClienteTextField.setColumns(10);
		telefoneClienteTextField.setBounds(190, 365, 107, 19);
		add(telefoneClienteTextField);
		
		telefoneClienteLabel = new JLabel("Telefone do cliente");
		telefoneClienteLabel.setBounds(26, 367, 146, 15);
		add(telefoneClienteLabel);
		
		cnhClienteLabel = new JLabel("CNH do cliente");
		cnhClienteLabel.setBounds(26, 393, 146, 15);
		add(cnhClienteLabel);
		
		cnhClienteTextField = new JTextField();
		cnhClienteTextField.setColumns(10);
		cnhClienteTextField.setBounds(190, 394, 107, 19);
		add(cnhClienteTextField);
		
		cpfClienteTextField = new JFormattedTextField(mascaraCPF);
		cpfClienteTextField.setColumns(10);
		cpfClienteTextField.setBounds(226, 242, 476, 19);
		add(cpfClienteTextField);
		
		btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente = clienteController.consultarClientePorCPF(cpfClienteTextField.getText());
				preencherCamposCliente();
			}
		});
		btnBuscarCliente.setBounds(534, 273, 167, 25);
		add(btnBuscarCliente);
		
		limparCamposBotao = new JButton("Limpar campos");
		limparCamposBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCamposForm();
			}
		});
		limparCamposBotao.setBounds(420, 351, 282, 25);
		add(limparCamposBotao);
				
		
	}
}

