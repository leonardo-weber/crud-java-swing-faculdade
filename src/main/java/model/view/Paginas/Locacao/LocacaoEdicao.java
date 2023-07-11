package model.view.Paginas.Locacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
import model.vo.FuncionarioVO;
import model.vo.LocacaoVO;

public class LocacaoEdicao extends JPanel {
	
	private DatePicker dataLocacaoDatePicker;
	private DatePicker dataPrevistaDevolucaoDatePicker;
	private JTextField valorTextField;
	
	private JLabel titleLabel;
	private JLabel dataInicialLabel;
	private JLabel dataFinalLabel;
	private JLabel valorLabel;
	private JLabel carroLabel;
	private JLabel lblLocacoesCadastradas;
	
	private JButton editarLocacaoButton;
	private JButton limparCamposBotao;
	
	private JComboBox comboBoxCarro;
	private JComboBox comboBoxLocacoesCadastradas;
	
	private ClienteVO cliente;
	private CarroVO carro;
	private double valor;
	
	private List<CarroVO> listaCarros;
	private List<LocacaoVO> listaLocacoesCadastradas;
	
	
	private String CPFSemMascara;
	
	CarroController carroController = new CarroController();
	ClienteController clienteController = new ClienteController();

	LocacaoVO locacaoVO = new LocacaoVO();
	LocacaoController locacaoController = new LocacaoController();
	
	private MaskFormatter mascaraCPF;
	private JLabel carroLabel_1;
	
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
	
	public LocacaoEdicao() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		listaLocacoesCadastradas = locacaoController.consultarListaLocacao();
		
		comboBoxLocacoesCadastradas = new JComboBox(listaLocacoesCadastradas.toArray());
		comboBoxLocacoesCadastradas.setSelectedIndex(-1);
		comboBoxLocacoesCadastradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionario = (FuncionarioVO) comboBoxLocacoesCadastradas.getSelectedItem();
				preencherCamposFuncionario();
			}
		});
		comboBoxLocacoesCadastradas.setBounds(253, 68, 449, 24);
		add(comboBoxLocacoesCadastradas);
		
		lblLocacoesCadastradas = new JLabel("Funcionários Cadastrados");
		lblLocacoesCadastradas.setBounds(26, 73, 209, 15);
		add(lblLocacoesCadastradas);
		
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
		carroLabel.setBounds(26, 201, 70, 15);
		add(carroLabel);
		
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
		
		editarLocacaoButton = new JButton("Editar Locação");
		editarLocacaoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		editarLocacaoButton.setBounds(376, 388, 357, 25);
		add(editarLocacaoButton);
		
		limparCamposBotao = new JButton("Limpar campos");
		limparCamposBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCamposForm();
			}
		});
		limparCamposBotao.setBounds(26, 388, 331, 25);
		add(limparCamposBotao);
		
		carroLabel_1 = new JLabel("Carro");
		carroLabel_1.setBounds(26, 244, 70, 15);
		add(carroLabel_1);
		
		JComboBox comboBoxCarro_1 = new JComboBox(new Object[]{});
		comboBoxCarro_1.setSelectedIndex(-1);
		comboBoxCarro_1.setBounds(226, 239, 476, 24);
		add(comboBoxCarro_1);
				

	}
}
