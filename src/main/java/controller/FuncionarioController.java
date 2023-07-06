package controller; 

import java.util.List;

import model.bo.FuncionarioBO;
import model.vo.ClienteVO;
import model.vo.FuncionarioVO;
import utils.ValidarCamposFormulario;

public class FuncionarioController {
	
	FuncionarioBO funcionarioBO = new FuncionarioBO();
	
	public boolean cadastrarFuncionario(FuncionarioVO funcionario) {
        if (this.validarCamposCadastroFuncionarioForm(funcionario)) {
        	return funcionarioBO.cadastrarFuncionario(funcionario);
        } else {
        	return false; 
        }
	}
	
	public boolean atualizarFuncionario(FuncionarioVO funcionario) {
		return funcionarioBO.atualizarFuncionario(funcionario);
	}
	
	public boolean excluirFuncionario(FuncionarioVO funcionario) {
		return funcionarioBO.deletarFuncionario(funcionario);
	}
	
	public boolean desativarFuncionario(FuncionarioVO funcionario) {
		return funcionarioBO.desativarFuncionario(funcionario);
	}
	
	public boolean ativarFuncionario(FuncionarioVO funcionario) {
		return funcionarioBO.ativarFuncionario(funcionario);
	}
	
	
	public List<FuncionarioVO> consultarListaFuncionarios () {
		return funcionarioBO.consultarListaFuncionarios();
	}
	
	public List<FuncionarioVO> consultarListaFuncionariosComFiltragemDeStatus (boolean status) {
		return funcionarioBO.consultarListaFuncionariosComFiltragemDeStatus(status);
	}
	
	public boolean validarCamposCadastroFuncionarioForm (FuncionarioVO funcionario) {
		
		boolean valido = true;
		
		boolean nome = ValidarCamposFormulario.validacao(funcionario.getNome());
		boolean senha = ValidarCamposFormulario.validacao(funcionario.getSenha());
		boolean telefone = ValidarCamposFormulario.validacao(funcionario.getTelefone());
		boolean cpf = ValidarCamposFormulario.validacao(funcionario.getCPF());
		boolean sexo = ValidarCamposFormulario.validacao(funcionario.getSexo());
		boolean dataNascimento = ValidarCamposFormulario.validacaoData(funcionario.getDataNascimento());
		
		boolean[] campos = { nome, senha, telefone, cpf, sexo, dataNascimento };
				
		for (int i = 0; i < campos.length; i++) {
			if (campos[i] == false) {
				valido = false;
			}
		}
		

		return valido;
		
	}

}
