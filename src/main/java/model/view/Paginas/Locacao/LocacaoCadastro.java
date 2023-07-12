package model.view.Paginas.Locacao;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;

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

import java.text.ParseException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LocacaoCadastro extends JPanel {
	
	private DatePicker dataLocacaoDatePicker;
	private DatePicker dataPrevistaDevolucaoDatePicker;
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
	private CarroVO carro;
	private double valor;
	
	private List<CarroVO> listaCarros;
	
	private String CPFSemMascara;
	
	CarroController carroController = new CarroController();
	ClienteController clienteController = new ClienteController();

	LocacaoVO locacaoVO = new LocacaoVO();
	LocacaoController locacaoController = new LocacaoController();
	
	private MaskFormatter mascaraCPF;
	
	public void limparCamposForm () {
		dataLocacaoDatePicker.setText("");
		dataPrevistaDevolucaoDatePicker.setText("");
		valorTextField.setText("");
		cpfClienteTextField.setText("");
		nomeClienteTextField.setText("");
		telefoneClienteTextField.setText("");
		cnhClienteTextField.setText("");
		comboBoxCarro.setSelectedIndex(-1);
	}
	
	public void preencherCamposCliente () {
		nomeClienteTextField.setText(cliente.getNome());
		telefoneClienteTextField.setText(cliente.getTelefone());
		cnhClienteTextField.setText(cliente.getCNH());
	} 
	
	public void cadastrarLocacao () {
		
		try {
			String CPFSemMascara = (String)  mascaraCPF.stringToValue(cpfClienteTextField.getText());
			cliente.setCPF(CPFSemMascara);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Erro ao converter o CPF", "Erro", JOptionPane.ERROR_MESSAGE); 
		}
				
		locacaoVO.setDataLocacao(dataLocacaoDatePicker.getDate());
		locacaoVO.setDataPrevistaDevolucao(dataPrevistaDevolucaoDatePicker.getDate());
		locacaoVO.setValorPrevisto(Integer.parseInt(valorTextField.getText()));
		locacaoVO.setCarro(carro);
		locacaoVO.setCliente(cliente);
		

		try {
			 locacaoController.cadastrarLocacao(locacaoVO);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}

	public LocacaoCadastro() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		try {
			mascaraCPF = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		mascaraCPF.setValueContainsLiteralCharacters(false);
		
		listaCarros = carroController.consultarCarrosDisponiveisEAtivos();
				
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
		
		dataLocacaoDatePicker = new DatePicker();
		dataLocacaoDatePicker.setBounds(226, 104, 476, 19);
		add(dataLocacaoDatePicker);
		
		dataPrevistaDevolucaoDatePicker = new DatePicker();
		dataPrevistaDevolucaoDatePicker.setBounds(226, 138, 476, 19);
		add(dataPrevistaDevolucaoDatePicker);
		
		valorTextField = new JTextField();
		valorTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				valor = locacaoController.calcularValor(dataLocacaoDatePicker.getDate(), dataPrevistaDevolucaoDatePicker.getDate());
				valorTextField.setText(Integer.toString((int) valor));
			}
		});
		valorTextField.setBounds(226, 172, 476, 19);
		valorTextField.setColumns(10);
		add(valorTextField);
		
		carroLabel = new JLabel("Carro");
		carroLabel.setBounds(26, 205, 70, 15);
		add(carroLabel);
		
		cpfClienteLabel = new JLabel("CPF do Cliente");
		cpfClienteLabel.setBounds(26, 244, 102, 15);
		add(cpfClienteLabel);
		
		String[] avisoComboBoxDisponibilidade = {"Não existem carros disponíveis no momento para locação"};
		final boolean comboBoxSemCarrosDisponiveis = listaCarros.toArray().length == 0;
					
		comboBoxCarro = new JComboBox((comboBoxSemCarrosDisponiveis ? avisoComboBoxDisponibilidade : listaCarros.toArray()));
		comboBoxCarro.setSelectedIndex(-1);
		comboBoxCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carro = (CarroVO) comboBoxCarro.getSelectedItem();
			}
		});
		comboBoxCarro.setBounds(226, 203, 476, 24);
		add(comboBoxCarro);
		
		cadastrarLocacaoButton = new JButton("Cadastrar Locação");
		cadastrarLocacaoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!comboBoxSemCarrosDisponiveis) {
					cadastrarLocacao();
					limparCamposForm();
				} else {
					JOptionPane.showMessageDialog(null, "Não existem carros disponíveis para cadastrar uma locação"); 
				}
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
				
				try {
					CPFSemMascara = (String) mascaraCPF.stringToValue(cpfClienteTextField.getText());
					cliente = clienteController.consultarClientePorCPF(CPFSemMascara);
					preencherCamposCliente();
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao converter o valor de CPF para valor sem máscara", "Erro", JOptionPane.ERROR_MESSAGE); 
				}
				
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

