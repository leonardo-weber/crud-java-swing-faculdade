package model.view.Paginas.Carro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import controller.CarroController;
import model.vo.CarroVO;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class CarroEdicao extends JPanel {
	
	private JTextField marcaTextField;
	private JTextField modeloTextField;
	private JFormattedTextField anoTextField;
	private JTextField placaTextField;
	private JTextField corTextField;
	
	private JLabel titleLabel;
	private JLabel marcaLabel;
	private JLabel modeloLabel;
	private JLabel anoLabel;
	private JLabel placaLabel;
	private JLabel corLabel;
	private JLabel lblDisponibilidade;
	private JLabel lblAtivo;
	
	private JButton editarCarroButton;
	private JButton limparCamposBotao;
	
	private JComboBox comboBoxCarrosCadastrados;
	private JLabel lblCarrosCadastrados;
	
	private List<CarroVO> listaCarrosCadastrados;
	private CarroVO carro;
	private JComboBox comboBoxDisponibilidade;
	private JComboBox comboBoxAtivo;
	
	private MaskFormatter mascaraAno;
	
	public void atualizarDadosCarro (CarroController carroController) {
		
		boolean disponibilidade = comboBoxDisponibilidade.getSelectedItem() == "Disponível" ? true : false;
		boolean ativo = comboBoxAtivo.getSelectedItem() == "Em frota" ? true : false;
		
		carro.setMarca(marcaTextField.getText());
		carro.setModelo(modeloTextField.getText());
		carro.setAno(anoTextField.getText());
		carro.setPlaca(placaTextField.getText());
		carro.setCor(corTextField.getText());
		carro.setDisponibilidade(disponibilidade);
		carro.setAtivo(ativo);
		
		boolean carroCadastrado = carroController.atualizarCarro(carro);
		
		if (carroCadastrado) {
			JOptionPane.showMessageDialog(null, "Dados do carro foram atualizados com sucesso");
		}
		
	}
	
	public void limparCampos () {
		marcaTextField.setText("");
		modeloTextField.setText("");
		anoTextField.setText("");
		placaTextField.setText("");
		corTextField.setText("");
		comboBoxDisponibilidade.setSelectedIndex(-1);
		comboBoxAtivo.setSelectedIndex(-1);
	}
	
	public void preencherCamposCarro () {
		
		String disponibilidadeCarro = carro.getDisponibilidade()  ? "Disponível" : "Indisponível";
		String ativoCarro = carro.getAtivo() ? "Em frota" : "Fora de frota";
		
		marcaTextField.setText(carro.getMarca());
		modeloTextField.setText(carro.getModelo());
		anoTextField.setText(carro.getAno());
		placaTextField.setText(carro.getPlaca());
		corTextField.setText(carro.getCor());
		comboBoxDisponibilidade.setSelectedItem(disponibilidadeCarro);
		comboBoxAtivo.setSelectedItem(ativoCarro);
	}

	public CarroEdicao() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		try {
			mascaraAno = new MaskFormatter("####");
		} catch (ParseException e1) {
			System.out.println("Erro ao inicializar variável do campo Ano");
		}
		
		mascaraAno.setValueContainsLiteralCharacters(false);
		
		final CarroController carroController = new CarroController();
		listaCarrosCadastrados = carroController.consultarListaCarros();
		
		String[] listaDisponibilidade = {"Disponível" , "Indisponível"};
		String[] listaAtivo = {"Em frota" , "Fora de frota"};
		
		titleLabel = new JLabel("Edição de carros");
		titleLabel.setBounds(26, 11, 136, 58);
		add(titleLabel);
		
		comboBoxCarrosCadastrados = new JComboBox(listaCarrosCadastrados.toArray());
		comboBoxCarrosCadastrados.setSelectedIndex(-1);
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
		marcaTextField.setBounds(226, 104, 476, 19);
		add(marcaTextField);
		marcaTextField.setColumns(10);
		
		modeloTextField = new JTextField();
		modeloTextField.setBounds(226, 138, 476, 19);
		modeloTextField.setColumns(10);
		add(modeloTextField);
		
		anoTextField = new JFormattedTextField(mascaraAno);
		anoTextField.setBounds(226, 172, 476, 19);
		anoTextField.setColumns(10);
		add(anoTextField);
		
		corTextField = new JTextField();
		corTextField.setColumns(10);
		corTextField.setBounds(226, 234, 476, 19);
		add(corTextField);
		
		corLabel = new JLabel("Cor");
		corLabel.setBounds(26, 236, 70, 15);
		add(corLabel);
		
		placaLabel = new JLabel("Placa");
		placaLabel.setBounds(26, 205, 70, 15);
		add(placaLabel);
		
		placaTextField = new JTextField();
		placaTextField.setColumns(10);
		placaTextField.setBounds(226, 203, 476, 19);
		add(placaTextField);
		
		editarCarroButton = new JButton("Editar carro");
		editarCarroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarDadosCarro(carroController);
				limparCampos();
			}
		});
		
		editarCarroButton.setBounds(420, 388, 282, 25);
		add(editarCarroButton);
				
		limparCamposBotao = new JButton("Limpar campos");
		limparCamposBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		limparCamposBotao.setBounds(420, 351, 282, 25);
		add(limparCamposBotao);
				
		lblDisponibilidade = new JLabel("Disponibilidade");
		lblDisponibilidade.setBounds(26, 270, 165, 15);
		add(lblDisponibilidade);
		
		lblAtivo = new JLabel("Ativo");
		lblAtivo.setBounds(26, 304, 70, 15);
		add(lblAtivo);
		
		comboBoxDisponibilidade = new JComboBox(listaDisponibilidade);
		comboBoxDisponibilidade.setSelectedIndex(-1);
		comboBoxDisponibilidade.setBounds(226, 265, 476, 24);
		add(comboBoxDisponibilidade);
		
		comboBoxAtivo = new JComboBox(listaAtivo);
		comboBoxAtivo.setSelectedIndex(-1);
		comboBoxAtivo.setBounds(226, 299, 476, 24);
		add(comboBoxAtivo);


	}
}
