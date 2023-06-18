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

public class CarroCadastro extends JPanel {

	private JTextField marcaTextField;
	private JTextField modeloTextField;
	private JTextField anoTextField;
	private JTextField placaTextField;
	
	private JLabel titleLabel;
	private JLabel marcaLabel;
	private JLabel modeloLabel;
	private JLabel anoLabel;
	private JLabel placaLabel;
	
	private JButton cadastrarCarroButton;
	
	CarroVO carroVO = new CarroVO();
	CarroController carroController = new CarroController();
	
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
		anoLabel.setBounds(26, 174, 70, 15);
		add(anoLabel);
		
		marcaTextField = new JTextField();
		marcaTextField.setBounds(118, 104, 584, 19);
		add(marcaTextField);
		marcaTextField.setColumns(10);
		
		modeloTextField = new JTextField();
		modeloTextField.setBounds(118, 138, 584, 19);
		modeloTextField.setColumns(10);
		add(modeloTextField);
		
		anoTextField = new JTextField();
		anoTextField.setBounds(118, 172, 584, 19);
		anoTextField.setColumns(10);
		add(anoTextField);
		
		placaLabel = new JLabel("Placa");
		placaLabel.setBounds(26, 213, 70, 15);
		add(placaLabel);
		
		cadastrarCarroButton = new JButton("Cadastrar carro");
		cadastrarCarroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				carroVO.setMarca(modeloTextField.getText());
				carroVO.setModelo(anoTextField.getText());
				carroVO.setPlaca(placaTextField.getText());
				carroVO.setAno(anoTextField.getText());
				
				try {
					carroController.cadastrarCarro(carroVO);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "erro");
				}
				
				
				
			}
		});
		
		cadastrarCarroButton.setBounds(420, 396, 282, 25);
		add(cadastrarCarroButton);
		
		placaTextField = new JTextField();
		placaTextField.setColumns(10);
		placaTextField.setBounds(118, 211, 584, 19);
		add(placaTextField);

	}

}
