package model.view.Paginas.Carro;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.CarroController;
import model.vo.CarroVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CarroCadastro extends JPanel {

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
	
	CarroVO carroVO = new CarroVO();
	CarroController carroController = new CarroController();
	
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
			JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "erro");
		}
	}
	
	public CarroCadastro() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
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
		modeloTextField.addActionListener(new ActionListener() {
			public void keyTyped(KeyEvent e) {
			}
		});
		modeloTextField.setBounds(226, 138, 476, 19);
		modeloTextField.setColumns(10);
		add(modeloTextField);
		
		anoTextField = new JTextField();
		anoTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		anoTextField.setBounds(226, 172, 476, 19);
		anoTextField.setColumns(10);
		add(anoTextField);
		
		corTextField = new JTextField();
		corTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
		});
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
		placaTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
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
