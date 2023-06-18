package controller;

import model.bo.LocacaoBO;
import model.vo.FuncionarioVO;
import model.vo.LocacaoVO;
import utils.ValidarCamposFormulario;

public class LocacaoController {
	
	LocacaoBO locacaoBO = new LocacaoBO();
	
	public LocacaoVO cadastrarLocacao(LocacaoVO locacao) throws CpfJaUtilizadoException, CampoInvalidoException {
        if (this.validarCamposCadastroLocacaoForm(locacao)) {
        	return locacaoBO.cadastrarLocacao(locacao);
        }
	}
	
	public boolean atualizarLocacao(LocacaoVO locacao) {
		return locacaoBO.atualizarLocacao(locacao);
	}
	
	public boolean excluirLocacao(LocacaoVO locacao) {
		return locacaoBO.deletarLocacao(locacao);
	}
	
	private boolean validarCamposCadastroLocacaoForm (LocacaoVO locacao) {
		
		boolean valido = true;
		
		boolean data_inicial = ValidarCamposFormulario.validacao(locacao.getData_inicio());
		boolean data_final = ValidarCamposFormulario.validacao(locacao.getData_fim());
		boolean carro = ValidarCamposFormulario.validacao(locacao.getCarro());
		boolean cliente = ValidarCamposFormulario.validacao(locacao.getCliente());
		boolean valor = ValidarCamposFormulario.validacao(locacao.getValor());
		
		boolean[] campos = { data_inicial, data_final, carro, cliente, valor };
				
		for (int i = 0; i < campos.length; i++) {
			if (campos[i] == false) {
				valido = false;
			}
		}

		return valido;
		
	}

}
