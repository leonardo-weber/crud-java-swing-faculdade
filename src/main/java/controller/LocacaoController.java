package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.bo.LocacaoBO;
import model.exception.CampoInvalidoException;
import model.vo.FuncionarioVO;
import model.vo.LocacaoVO;
import utils.ValidarCamposFormulario;

public class LocacaoController {
	
	LocacaoBO locacaoBO = new LocacaoBO();
	
	public LocacaoVO cadastrarLocacao(LocacaoVO locacao) {
        if (this.validarCamposCadastroLocacaoForm(locacao)) {
        	return locacaoBO.cadastrarLocacao(locacao);
        } else {
        	return locacao;
        }
	}
	
	public boolean atualizarLocacao(LocacaoVO locacao) {
		return locacaoBO.atualizarLocacao(locacao);
	}
	
	public boolean excluirLocacao(LocacaoVO locacao) {
		return locacaoBO.deletarLocacao(locacao);
	}
	
	public boolean cadastrarDevolucao(LocacaoVO locacao) {
		return locacaoBO.cadastrarDevolucao(locacao);
	}
	
	public List<LocacaoVO> consultarListaLocacao () {
		return locacaoBO.consultarListaLocacao();
	}
	
	public LocacaoVO consultarLocacaoPorID(int id) {
		return locacaoBO.consultarLocacaoPorID(id);
	}
		
	public int calcularValor(LocalDate dataLocacao, LocalDate dataDevolucao) {
		return locacaoBO.calcularValor(dataLocacao, dataDevolucao);
	}
	
	public int calcularAtraso(LocalDate dataDevolucaoEfetiva, LocalDate dataDevolucaoPrevista) {
		return locacaoBO.calcularAtraso(dataDevolucaoEfetiva, dataDevolucaoPrevista);
	}
	
	public int calcularMulta(LocacaoVO locacao, LocalDate dataEfetivaDevolucao) {
		return locacaoBO.calcularMulta(locacao, dataEfetivaDevolucao);
	}
	
	public int calcularValorEfetivo (int valorPrevisto, int multa) {
		return locacaoBO.calcularValorEfetivo(valorPrevisto, multa);
	}
	
	private boolean validarCamposCadastroLocacaoForm (LocacaoVO locacao) {
		
		boolean valido = true;
		CarroController carroController = new CarroController();
		ClienteController clienteController = new ClienteController();
				
		boolean data_locacao = ValidarCamposFormulario.validacaoData(locacao.getDataLocacao());
		boolean data_prevista_devolucao = ValidarCamposFormulario.validacaoData(locacao.getDataPrevistaDevolucao());
		boolean valor = ValidarCamposFormulario.validacao(String.valueOf(locacao.getValorPrevisto()));
		boolean carro = carroController.validarCamposCadastroCarroForm(locacao.getCarro());
		boolean cliente = clienteController.validarCamposCadastroClienteForm(locacao.getCliente());
		
		boolean[] campos = { data_locacao, data_prevista_devolucao, valor, carro, cliente };				
		
		for (int i = 0; i < campos.length; i++) {
			if (campos[i] == false) {
				valido = false;
			}
		}
		
		return valido;
		
	}

}
