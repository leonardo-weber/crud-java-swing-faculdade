package model.view.Paginas.Locacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class LocacaoDevolucao extends JPanel {
	
	private JLabel tituloLabel;
	
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
	private JTextField dataLocacaoTextField;
	private JTextField dataDevolucaoTextField;
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
	private JTextField textField;
	
	public void cadastrarDevolucao () {
		
	}
	
	public void limparCamposForm () {
		
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
		idLocacaoLabel.setBounds(26, 96, 237, 15);
		add(idLocacaoLabel);
		
		idLocacaoTextField = new JTextField();
		idLocacaoTextField.setBounds(26, 123, 176, 19);
		add(idLocacaoTextField);
		idLocacaoTextField.setColumns(10);
				
		dataLocacaoLabel = new JLabel("Data da Locação");
		dataLocacaoLabel.setBounds(26, 234, 237, 15);
		add(dataLocacaoLabel);
		
		dataDevolucaoLabel = new JLabel("Data da Devolução");
		dataDevolucaoLabel.setBounds(26, 292, 237, 15);
		add(dataDevolucaoLabel);
		
		dataDevolucaoTextField = new JTextField();
		dataDevolucaoTextField.setColumns(10);
		dataDevolucaoTextField.setBounds(26, 319, 176, 19);
		add(dataDevolucaoTextField);
		
		valorPrevistoLabel = new JLabel("Valor Previsto");
		valorPrevistoLabel.setBounds(26, 350, 237, 15);
		add(valorPrevistoLabel);
		
		valorPrevistoTextField = new JTextField();
		valorPrevistoTextField.setColumns(10);
		valorPrevistoTextField.setBounds(26, 377, 176, 19);
		add(valorPrevistoTextField);
		
		valorEfetivoLabel = new JLabel("Valor Efetivo");
		valorEfetivoLabel.setBounds(271, 234, 237, 15);
		add(valorEfetivoLabel);
		
		valorEfetivoTextField = new JTextField();
		valorEfetivoTextField.setColumns(10);
		valorEfetivoTextField.setBounds(271, 261, 176, 19);
		add(valorEfetivoTextField);
		
		valorMultaLabel = new JLabel("Valor Multa");
		valorMultaLabel.setBounds(271, 292, 237, 15);
		add(valorMultaLabel);
		
		valorMultaTextField = new JTextField();
		valorMultaTextField.setColumns(10);
		valorMultaTextField.setBounds(271, 319, 176, 19);
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
		btnLimparCampos.setBounds(448, 154, 237, 25);
		add(btnLimparCampos);
		
		buscarLocacaoButton = new JButton("Buscar locação");
		buscarLocacaoButton.setBounds(26, 154, 176, 25);
		add(buscarLocacaoButton);
		
		dataLocacaoTextField = new JTextField();
		dataLocacaoTextField.setColumns(10);
		dataLocacaoTextField.setBounds(26, 261, 176, 19);
		add(dataLocacaoTextField);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(509, 377, 176, 19);
		add(textField);

	}
}
