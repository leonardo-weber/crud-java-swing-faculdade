package controller; 

import model.bo.FuncionarioBO;
import model.vo.ClienteVO;
import model.vo.FuncionarioVO;
import utils.ValidarCamposFormulario;

public class FuncionarioController {
	
	FuncionarioBO funcionarioBO = new FuncionarioBO();
	
	public FuncionarioVO cadastrarFuncionario(FuncionarioVO funcionario) {
        if (this.validarCamposCadastroFuncionarioForm(funcionario)) {
        	return funcionarioBO.cadastrarFuncionario(funcionario);
        } else {
        	return funcionario; 
        }
	}
	
	public boolean atualizarFuncionario(FuncionarioVO funcionario) {
		return funcionarioBO.atualizarFuncionario(funcionario);
	}
	
	public boolean excluirFuncionario(FuncionarioVO funcionario) {
		return funcionarioBO.deletarFuncionario(funcionario);
	}
	
	private boolean validarCamposCadastroFuncionarioForm (FuncionarioVO funcionario) {
		
		boolean valido = true;
		String campoInvalido = null;
		
		boolean nome = ValidarCamposFormulario.validacao(funcionario.getNome());
		boolean telefone = ValidarCamposFormulario.validacao(funcionario.getTelefone());
		boolean cpf = ValidarCamposFormulario.validacao(funcionario.getCPF());
		
		boolean[] campos = { nome, telefone, cpf };
				
		for (int i = 0; i < campos.length; i++) {
			if (campos[i] == false) {
				valido = false;
			}
		}
		

		return valido;
		
	}

}
