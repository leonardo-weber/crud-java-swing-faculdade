package controller;

import model.bo.ClienteBO;
import model.exception.CampoInvalidoException;
import model.vo.ClienteVO;
import utils.ValidarCamposFormulario;

public class ClienteController {
	
	ClienteBO clienteBO = new ClienteBO();
	
	public ClienteVO cadastrarCliente(ClienteVO cliente) throws CampoInvalidoException {
        if (this.validarCamposCadastroClienteForm(cliente)) {
        	return clienteBO.cadastrarCliente(cliente);
        } else {
        	return cliente;
        }
	}
	
	public boolean atualizarCliente(ClienteVO cliente) {
		return clienteBO.atualizarCliente(cliente);
	}
	
	public boolean excluirCliente(ClienteVO cliente) {
		return clienteBO.deletarCliente(cliente);
	}
	
	private boolean validarCamposCadastroClienteForm (ClienteVO cliente) {
		
		boolean valido = true;
		
		boolean nome = ValidarCamposFormulario.validacao(cliente.getNome());
		boolean telefone = ValidarCamposFormulario.validacao(cliente.getTelefone());
		boolean cpf = ValidarCamposFormulario.validacao(cliente.getCPF());
		boolean cnh = ValidarCamposFormulario.validacao(cliente.getCNH());
		
		boolean[] campos = { nome, telefone, cpf, cnh };
				
		for (int i = 0; i < campos.length; i++) {
			if (campos[i] == false) {
				valido = false;
			}
		}

		return valido;
		
	}

}
