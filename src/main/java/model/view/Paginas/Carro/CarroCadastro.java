package model.view.Paginas.Carro;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import controller.CarroController;
import model.vo.CarroVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

public class CarroCadastro extends JPanel {

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
	
	private JButton cadastrarCarroButton;
	private JButton limparCamposBotao;
	
	CarroVO carroVO = new CarroVO();
	CarroController carroController = new CarroController();
	
	private MaskFormatter mascaraAno;
	
	public void limparCamposForm () {
		marcaTextField.setText("");
		modeloTextField.setText("");
		anoTextField.setText("");
		placaTextField.setText("");
		corTextField.setText("");
	}
	
	public void cadastrarCarro () {
		
		carroVO.setMarca(marcaTextField.getText());
		carroVO.setModelo(modeloTextField.getText());
		carroVO.setPlaca(placaTextField.getText());
		carroVO.setAno(anoTextField.getText());
		carroVO.setCor(corTextField.getText());
					
		try {
			carroController.cadastrarCarro(carroVO);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o automóvel");
		}
	}
	
	public CarroCadastro() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		try {
			mascaraAno = new MaskFormatter("####");
		} catch (ParseException e1) {
			System.out.println("Erro ao inicializar variável do campo Ano");
		}
		
		mascaraAno.setValueContainsLiteralCharacters(false);
		
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
				cadastrarCarro();
				limparCamposForm();
			}
		});
		
		cadastrarCarroButton.setBounds(420, 388, 282, 25);
		add(cadastrarCarroButton);
				
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
