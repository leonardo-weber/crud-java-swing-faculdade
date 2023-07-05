package controller;

import java.util.List;

import model.bo.CarroBO;
import model.exception.CampoInvalidoException;
import model.vo.CarroVO;
import utils.ValidarCamposFormulario;
public class CarroController {
	
	CarroBO carroBO = new CarroBO();
	
	public CarroVO cadastrarCarro(CarroVO carro) throws CampoInvalidoException {
		if (this.validarCamposCadastroCarroForm(carro)) {
			return carroBO.cadastrarCarro(carro);
		} else {
			return carro;
		}
	}
	
	public boolean atualizarCarro(CarroVO carro) {
		return carroBO.atualizarCarro(carro);
	}
	
	public boolean excluirCarro(CarroVO carro) {
		return carroBO.deletarCarro(carro);
	}
	
	public List<CarroVO> consultarListaCarros() {
		return carroBO.consultarListaCarros();
	}
	
	public CarroVO consultarCarroPorID(int id) {
		return carroBO.consultarCarroPorID(id);
	} 
	
	public boolean setLocacaoCarro(int id, boolean disponibilidade) {
		return carroBO.atualizarDisponibilidadeCarro(id, false);
	}
	
	public boolean setDevolucaoCarro(int id, boolean disponibilidade) {
		return carroBO.atualizarDisponibilidadeCarro(id, true);
	}
		
	public boolean validarCamposCadastroCarroForm (CarroVO carro) {
		
		boolean valido = true;
		
		boolean marca = ValidarCamposFormulario.validacao(carro.getMarca());
		boolean ano = ValidarCamposFormulario.validacao(carro.getAno());
		boolean modelo = ValidarCamposFormulario.validacao(carro.getModelo());
		boolean placa = ValidarCamposFormulario.validacao(carro.getPlaca());
		boolean cor = ValidarCamposFormulario.validacao(carro.getCor());
		
		boolean[] campos = { marca, ano, modelo, placa, cor };
				
		for (int i = 0; i < campos.length; i++) {
			if (campos[i] == false) {
				valido = false;
			}
		}

		return valido;
		
	}
	
}
