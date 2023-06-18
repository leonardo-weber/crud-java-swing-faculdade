package model.view.Paginas.Locacao;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import controller.LocacaoController;
import model.vo.LocacaoVO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LocacaoCadastro extends JPanel {
	
	private JTextField dataInicialTextField;
	private JTextField dataFinalTextField;
	private JTextField valorTextField;
	private JTextField modeloTextField;
	
	private JLabel titleLabel;
	private JLabel dataInicialLabel;
	private JLabel dataFinalLabel;
	private JLabel valorLabel;
	private JLabel modeloLabel;
	
	private JButton cadastrarLocacaoButton;

	LocacaoVO locacaoVO = new LocacaoVO();
	LocacaoController locacaoController = new LocacaoController();

	public LocacaoCadastro() {
		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
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
		
		dataInicialTextField = new JTextField();
		dataInicialTextField.setBounds(226, 104, 476, 19);
		add(dataInicialTextField);
		dataInicialTextField.setColumns(10);
		
		dataFinalTextField = new JTextField();
		dataFinalTextField.setBounds(226, 138, 476, 19);
		dataFinalTextField.setColumns(10);
		add(dataFinalTextField);
		
		valorTextField = new JTextField();
		valorTextField.setBounds(226, 172, 476, 19);
		valorTextField.setColumns(10);
		add(valorTextField);
		
		modeloLabel = new JLabel("Modelo");
		modeloLabel.setBounds(26, 205, 70, 15);
		add(modeloLabel);
		
		cadastrarLocacaoButton = new JButton("Cadastrar Locação");
		cadastrarLocacaoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				locacaoVO.getData_inicio(dataInicialTextField.getText());
				locacaoVO.getData_fim(dataFinalTextField.getText());
				locacaoVO.getCarro(modeloTextField.getText());

				try {
					locacaoController.cadastrarLocacao(locacaoVO);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "erro");
				}
				
			}
		});
		cadastrarLocacaoButton.setBounds(420, 391, 282, 25);
		add(cadastrarLocacaoButton);
		
		modeloTextField = new JTextField();
		modeloTextField.setColumns(10);
		modeloTextField.setBounds(226, 203, 476, 19);
		add(modeloTextField);

	}

}
