package controller;

import model.bo.FuncionarioBO;
import model.vo.FuncionarioVO;
import utils.ValidarCamposFormulario;

public class LoginController {
	
	FuncionarioBO funcionarioBO = new FuncionarioBO();
	
	public FuncionarioVO realizarLogin (FuncionarioVO funcionario) {
		
		boolean loginAutorizado = false;
		boolean camposValidos = this.validarCamposLoginForm(funcionario);
		
		if (camposValidos) {		
			return funcionarioBO.checarFuncionarioValido(funcionario);
		} else return null;
		
	}
	
	private boolean validarCamposLoginForm (FuncionarioVO funcionario) {
		
		boolean valido = true;
		
		boolean login = ValidarCamposFormulario.validacao(funcionario.getNome());
		boolean senha = ValidarCamposFormulario.validacao(funcionario.getSenha());
		
		boolean[] campos = { login, senha };
		
		for (int i = 0; i < campos.length; i++) {
			if (campos[i] == false) {
				valido = false;
			}
		}
		
		return valido;
		
	}

}
