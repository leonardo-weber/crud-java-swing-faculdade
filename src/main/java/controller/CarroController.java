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
	
	public boolean ativarStatusCarro (int id) {
		return carroBO.ativarStatusCarro(id);
	}
	
	public boolean desativarStatusCarro (int id) {
		return carroBO.desativarStatusCarro(id);
	}
	
	public List<CarroVO> consultarListaCarros() {
		return carroBO.consultarListaCarros();
	}
	
	public List<CarroVO> consultarCarrosComFiltroDeDisponibilidade (boolean disponibilidade) {
		return carroBO.consultarCarrosComFiltroDeDisponibilidade(disponibilidade);
	} 
	
	public List<CarroVO> consultarCarrosAtivosEmFrota () {
		return carroBO.consultarCarrosAtivosEmFrota();
	} 
	
	public List<CarroVO> consultarCarrosDisponiveisEAtivos () {
		return carroBO.consultarCarrosDisponiveisEAtivos();
	}
	
	public CarroVO consultarCarroPorID(int id) {
		return carroBO.consultarCarroPorID(id);
	} 
	
	public boolean setLocacaoCarro(int id) {
		return carroBO.atualizarDisponibilidadeCarro(id, false);
	}
	
	public boolean setDevolucaoCarro(int id) {
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
