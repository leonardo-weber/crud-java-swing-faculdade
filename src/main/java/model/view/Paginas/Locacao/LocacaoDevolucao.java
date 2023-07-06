package model.view.Paginas.Locacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.github.lgooddatepicker.components.DatePicker;

import controller.LocacaoController;
import model.vo.LocacaoVO;

public class LocacaoDevolucao extends JPanel {
	
	private JLabel tituloLabel;
	
	LocacaoController locacaoController = new LocacaoController();
	private LocacaoVO locacao;
	
	private JLabel idLocacaoLabel;
	private JLabel dataLocacaoLabel;
	private JLabel dataDevolucaoLabel;
	private JLabel valorPrevistoLabel;
	private JLabel valorEfetivoLabel;
	private JLabel valorMultaLabel;
	private JLabel valorCarroLabel;
	private JLabel nomeClienteLabel;
	private JLabel telefoneClienteLabel;
	private JLabel cpfClienteLabel;
	
	private JTextField idLocacaoTextField;
	private DatePicker dataLocacaoDatePicker;
	private DatePicker dataDevolucaoEfetivaDatePicker;
	private DatePicker dataDevolucaoPrevistaDatePicker;
	private JTextField valorPrevistoTextField;
	private JTextField valorEfetivoTextField;
	private JTextField valorMultaTextField;
	private JTextField valorCarroTextField;
	private JTextField nomeClienteTextField;
	private JTextField telefoneClienteTextField;
	private JTextField cpfClienteTextField;
	
	private JButton cadastrarDevolucaoButton;
	private JButton buscarLocacaoButton;
	private JButton btnLimparCampos;
	private JLabel dataDevolucaoPrevista;
	
	public void cadastrarDevolucao () {
		
		try {
			
			locacaoController.cadastrarDevolucao(locacao);

		} catch (Exception e ) {
			System.out.println("erro");
		}
		
	}
	
	public void limparCamposForm () {
		idLocacaoTextField.setText("");
		dataLocacaoDatePicker.setText("");
		dataDevolucaoPrevistaDatePicker.setText("");
		dataDevolucaoEfetivaDatePicker.setText("");
		valorPrevistoTextField.setText("");
		valorEfetivoTextField.setText("");
		valorMultaTextField.setText("");
		valorCarroTextField.setText("");
		nomeClienteTextField.setText("");
		telefoneClienteTextField.setText("");
		cpfClienteTextField.setText("");		
	}
	
	public void preencherCamposLocacao () {
		
		Date dataDeHoje = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
		String dataDevolucaoEfetiva = dateFormat.format(dataDeHoje);
		
		int valorMulta = locacaoController.calcularMulta(locacao, LocalDate.now());
		int valorEfetivo = locacaoController.calcularValorEfetivo(locacao.getValorPrevisto(), valorMulta);
		
		dataLocacaoDatePicker.setText(locacao.getDataLocacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		dataDevolucaoPrevistaDatePicker.setText(locacao.getDataEfetivaDevolucao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		dataDevolucaoEfetivaDatePicker.setText(dataDevolucaoEfetiva);
		valorPrevistoTextField.setText(Integer.toString(locacao.getValorPrevisto()));
		valorMultaTextField.setText(Integer.toString(valorMulta));
		valorEfetivoTextField.setText(Integer.toString(valorEfetivo));
		valorCarroTextField.setText(locacao.getCarro().toString());
		nomeClienteTextField.setText(locacao.getCliente().getNome());
		telefoneClienteTextField.setText(locacao.getCliente().getTelefone());
		cpfClienteTextField.setText(locacao.getCliente().getCPF());
	}
	
	public LocacaoDevolucao() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		tituloLabel = new JLabel("Devolução de Locação de Carros");
		tituloLabel.setBounds(26, 11, 421, 58);
		add(tituloLabel);
		
		cadastrarDevolucaoButton = new JButton("Cadastrar Devolução");
		cadastrarDevolucaoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarDevolucao();
				limparCamposForm();
			}
		});
		cadastrarDevolucaoButton.setBounds(448, 120, 237, 25);
		add(cadastrarDevolucaoButton);
		
		idLocacaoLabel = new JLabel("Identificador da locação");
		idLocacaoLabel.setBounds(26, 78, 237, 15);
		add(idLocacaoLabel);
		
		idLocacaoTextField = new JTextField();
		idLocacaoTextField.setBounds(26, 105, 176, 19);
		add(idLocacaoTextField);
		idLocacaoTextField.setColumns(10);
				
		dataLocacaoLabel = new JLabel("Data da Locação");
		dataLocacaoLabel.setBounds(26, 173, 237, 15);
		add(dataLocacaoLabel);
		
		dataDevolucaoLabel = new JLabel("Data da Devolução Efetiva");
		dataDevolucaoLabel.setBounds(26, 292, 237, 15);
		add(dataDevolucaoLabel);
		
		dataDevolucaoEfetivaDatePicker = new DatePicker();
		dataDevolucaoEfetivaDatePicker.setBounds(26, 319, 200, 19);
		add(dataDevolucaoEfetivaDatePicker);
		
		valorPrevistoLabel = new JLabel("Valor Previsto");
		valorPrevistoLabel.setBounds(26, 350, 237, 15);
		add(valorPrevistoLabel);
		
		valorPrevistoTextField = new JTextField();
		valorPrevistoTextField.setColumns(10);
		valorPrevistoTextField.setBounds(26, 377, 176, 19);
		add(valorPrevistoTextField);
		
		valorEfetivoLabel = new JLabel("Valor Efetivo");
		valorEfetivoLabel.setBounds(275, 292, 237, 15);
		add(valorEfetivoLabel);
		
		valorEfetivoTextField = new JTextField();
		valorEfetivoTextField.setColumns(10);
		valorEfetivoTextField.setBounds(271, 319, 176, 19);
		add(valorEfetivoTextField);
		
		valorMultaLabel = new JLabel("Valor Multa");
		valorMultaLabel.setBounds(275, 234, 237, 15);
		add(valorMultaLabel);
		
		valorMultaTextField = new JTextField();
		valorMultaTextField.setColumns(10);
		valorMultaTextField.setBounds(275, 261, 176, 19);
		add(valorMultaTextField);
		
		valorCarroLabel = new JLabel("Carro");
		valorCarroLabel.setBounds(271, 350, 237, 15);
		add(valorCarroLabel);
		
		valorCarroTextField = new JTextField();
		valorCarroTextField.setColumns(10);
		valorCarroTextField.setBounds(271, 377, 176, 19);
		add(valorCarroTextField);
		
		nomeClienteLabel = new JLabel("Nome do Cliente");
		nomeClienteLabel.setBounds(509, 234, 237, 15);
		add(nomeClienteLabel);
		
		nomeClienteTextField = new JTextField();
		nomeClienteTextField.setColumns(10);
		nomeClienteTextField.setBounds(509, 261, 176, 19);
		add(nomeClienteTextField);
		
		telefoneClienteLabel = new JLabel("Telefone do Cliente");
		telefoneClienteLabel.setBounds(509, 292, 237, 15);
		add(telefoneClienteLabel);
		
		telefoneClienteTextField = new JTextField();
		telefoneClienteTextField.setColumns(10);
		telefoneClienteTextField.setBounds(509, 319, 176, 19);
		add(telefoneClienteTextField);
		
		cpfClienteLabel = new JLabel("CPF do cliente");
		cpfClienteLabel.setBounds(509, 350, 237, 15);
		add(cpfClienteLabel);
		
		cpfClienteTextField = new JTextField();
		cpfClienteTextField.setColumns(10);
		add(cpfClienteTextField);
		
		btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCamposForm();
			}
		});
		btnLimparCampos.setBounds(448, 154, 237, 25);
		add(btnLimparCampos);
		
		buscarLocacaoButton = new JButton("Buscar locação");
		buscarLocacaoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				locacao = locacaoController.consultarLocacaoPorID(Integer.parseInt(idLocacaoTextField.getText()));
				preencherCamposLocacao();
			}
		});
		buscarLocacaoButton.setBounds(26, 136, 176, 25);
		add(buscarLocacaoButton);
		
		dataLocacaoDatePicker = new DatePicker();
		dataLocacaoDatePicker.setBounds(26, 200, 200, 19);
		add(dataLocacaoDatePicker);
		
		cpfClienteTextField = new JTextField();
		cpfClienteTextField.setColumns(10);
		cpfClienteTextField.setBounds(509, 377, 176, 19);
		add(cpfClienteTextField);
		
		dataDevolucaoPrevista = new JLabel("Data da Devolução Prevista");
		dataDevolucaoPrevista.setBounds(26, 234, 237, 15);
		add(dataDevolucaoPrevista);
		
		dataDevolucaoPrevistaDatePicker = new DatePicker();
		dataDevolucaoPrevistaDatePicker.setBounds(26, 261, 200, 19);
		add(dataDevolucaoPrevistaDatePicker);

	}
}
