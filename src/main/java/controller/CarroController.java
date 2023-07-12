package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.bo.CarroBO;
import model.vo.CarroVO;
import utils.ValidarCamposFormulario;
public class CarroController {
	
	CarroBO carroBO = new CarroBO();
	
	public CarroVO cadastrarCarro(CarroVO carro)  {
		if (this.validarCamposCadastroCarroForm(carro)) {
			return carroBO.cadastrarCarro(carro);
		} else {
			return carro;
		}
	}
	
	public boolean atualizarCarro(CarroVO carro) {
		if (this.validarCamposCadastroCarroForm(carro)) {
			return carroBO.atualizarCarro(carro);
		} else {
			return false;
		}
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
		boolean disponibilidade = ValidarCamposFormulario.validacao(Boolean.toString(carro.getDisponibilidade()));
		boolean ativo = ValidarCamposFormulario.validacao(Boolean.toString(carro.getAtivo()));
				
		boolean anoRegexValidacao = ValidarCamposFormulario.validarAno(carro.getAno());
		boolean placaRegexValidacao = ValidarCamposFormulario.validarPlacaCarro(carro.getPlaca());
		
		if (!anoRegexValidacao) {
			JOptionPane.showMessageDialog(null, "Ano Inválido!"); 
			return false;
		}
		
		if (!placaRegexValidacao) {
			JOptionPane.showMessageDialog(null, "Placa inválida!");
			return false;
		}
		
		boolean[] campos = { marca, ano, modelo, placa, cor, disponibilidade, ativo, anoRegexValidacao, placaRegexValidacao };
				
		for (int i = 0; i < campos.length; i++) {
			if (campos[i] == false) {
				valido = false;
			}
		}
		
		return valido;
		
	}
	
}
