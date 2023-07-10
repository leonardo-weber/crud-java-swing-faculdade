package model.view.Paginas.Carro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import controller.CarroController;
import model.vo.CarroVO;

import javax.swing.JComboBox;

public class CarroEdicao extends JPanel {
	
	private JTextField marcaTextField;
	private JTextField modeloTextField;
	private JTextField anoTextField;
	private JTextField placaTextField;
	private JTextField corTextField;
	
	private JLabel titleLabel;
	private JLabel marcaLabel;
	private JLabel modeloLabel;
	private JLabel anoLabel;
	private JLabel placaLabel;
	private JLabel corLabel;
	
	private JButton cadastrarCarroButton;
	private JButton limparCamposBotao;
	
	private JComboBox comboBoxCarrosCadastrados;
	private JLabel lblCarrosCadastrados;
	
	private List<CarroVO> listaCarrosCadastrados;
	private CarroVO carro;
	
	public void preencherCamposCarro () {
		marcaTextField.setText(carro.getMarca());
		modeloTextField.setText(carro.getModelo());
		anoTextField.setText(carro.getAno());
		placaTextField.setText(carro.getPlaca());
		corTextField.setText(carro.getCor());
	}

	public CarroEdicao() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		CarroController carroController = new CarroController();
		listaCarrosCadastrados = carroController.consultarListaCarros();
		
		titleLabel = new JLabel("Cadastro de carros");
		titleLabel.setBounds(26, 11, 136, 58);
		add(titleLabel);
		
		marcaLabel = new JLabel("Marca");
		marcaLabel.setBounds(26, 106, 70, 15);
		add(marcaLabel);
		
		modeloLabel = new JLabel("Modelo");
		modeloLabel.setBounds(26, 140, 70, 15);
		add(modeloLabel);
		
		anoLabel = new JLabel("Ano de fabricação");
		anoLabel.setBounds(26, 174, 165, 15);
		add(anoLabel);
		
		marcaTextField = new JTextField();
		marcaTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		marcaTextField.setBounds(226, 104, 476, 19);
		add(marcaTextField);
		marcaTextField.setColumns(10);
		
		modeloTextField = new JTextField();
		modeloTextField.setBounds(226, 138, 476, 19);
		modeloTextField.setColumns(10);
		add(modeloTextField);
		
		anoTextField = new JTextField();
		anoTextField.setBounds(226, 172, 476, 19);
		anoTextField.setColumns(10);
		add(anoTextField);
		
		corTextField = new JTextField();
		corTextField.setColumns(10);
		corTextField.setBounds(226, 234, 476, 19);
		add(corTextField);
		
		corLabel = new JLabel("Cor");
		corLabel.setBounds(26, 232, 70, 15);
		add(corLabel);
		
		placaLabel = new JLabel("Placa");
		placaLabel.setBounds(26, 205, 70, 15);
		add(placaLabel);
		
		placaTextField = new JTextField();
		placaTextField.setColumns(10);
		placaTextField.setBounds(226, 203, 476, 19);
		add(placaTextField);
		
		cadastrarCarroButton = new JButton("Cadastrar carro");
		cadastrarCarroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		
		cadastrarCarroButton.setBounds(420, 388, 282, 25);
		add(cadastrarCarroButton);
				
		limparCamposBotao = new JButton("Limpar campos");
		limparCamposBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		limparCamposBotao.setBounds(420, 351, 282, 25);
		add(limparCamposBotao);
		
		comboBoxCarrosCadastrados = new JComboBox(listaCarrosCadastrados.toArray());
		comboBoxCarrosCadastrados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carro = (CarroVO) comboBoxCarrosCadastrados.getSelectedItem();
				preencherCamposCarro();
			}
		});
		comboBoxCarrosCadastrados.setBounds(226, 68, 476, 24);
		add(comboBoxCarrosCadastrados);
		
		lblCarrosCadastrados = new JLabel("Carros Cadastrados");
		lblCarrosCadastrados.setBounds(26, 73, 154, 15);
		add(lblCarrosCadastrados);


	}
}
