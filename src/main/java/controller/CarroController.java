package controller;

import model.bo.CarroBO;
import model.vo.CarroVO;
import utils.ValidarCamposFormulario;
import java.util.ArrayList;
import java.util.Collections;

public class CarroController {
	
	CarroBO carroBO = new CarroBO();
	
	public CarroVO cadastrarCarro(CarroVO carro) throws CpfJaUtilizadoException, CampoInvalidoException {
		if (this.validarCamposCadastroCarroForm(carro)) {
			return carroBO.cadastrarCarro(carro);
		}
	}
	
	public boolean atualizarCarro(CarroVO carro) {
		return carroBO.atualizarCarro(carro);
	}
	
	public boolean excluirCarro(CarroVO carro) {
		return carroBO.deletarCarro(carro);
	}
		
	private boolean validarCamposCadastroCarroForm (CarroVO carro) {
		
		boolean valido = true;
		
		boolean marca = ValidarCamposFormulario.validacao(carro.getMarca());
		boolean ano = ValidarCamposFormulario.validacao(Integer.toString(carro.getAno()));
		boolean modelo = ValidarCamposFormulario.validacao(carro.getModelo());
		boolean placa = ValidarCamposFormulario.validacao(carro.getPlaca());
		
		boolean[] campos = { marca, ano, modelo, placa };
				
		for (int i = 0; i < campos.length; i++) {
			if (campos[i] == false) {
				valido = false;
			}
		}

		return valido;
		
	}
	
}
