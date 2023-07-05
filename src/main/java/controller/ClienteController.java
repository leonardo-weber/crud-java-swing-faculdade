package controller;

import java.util.List;

import model.bo.ClienteBO;
import model.exception.CampoInvalidoException;
import model.vo.ClienteVO;
import utils.ValidarCamposFormulario;

public class ClienteController {
	
	ClienteBO clienteBO = new ClienteBO();
	
	public ClienteVO cadastrarCliente(ClienteVO cliente) {
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
	
	public List<ClienteVO> consultarListaClientes () {
		return clienteBO.consultarListaClientes();
	}
	
	public ClienteVO consultarClientePorCPF(String cpf) {
		return clienteBO.consultarClientePorCPF(cpf);
	}
	
	public ClienteVO consultarClientePorID(int id) {
		return clienteBO.consultarClientePorID(id);
	}
	
	public boolean validarCamposCadastroClienteForm (ClienteVO cliente) {
		
		boolean valido = true;
		
		boolean nome = ValidarCamposFormulario.validacao(cliente.getNome());
		boolean telefone = ValidarCamposFormulario.validacao(cliente.getTelefone());
		boolean cpf = ValidarCamposFormulario.validacao(cliente.getCPF());
		boolean cnh = ValidarCamposFormulario.validacao(cliente.getCNH());
		boolean sexo = ValidarCamposFormulario.validacao(cliente.getSexo());
		boolean dataNascimento = ValidarCamposFormulario.validacaoData(cliente.getDataNascimento());
		
		boolean[] campos = { nome, telefone, cpf, cnh, sexo, dataNascimento };
				
		for (int i = 0; i < campos.length; i++) {
			if (campos[i] == false) {
				valido = false;
			}
		}

		return valido;
		
	}

}
