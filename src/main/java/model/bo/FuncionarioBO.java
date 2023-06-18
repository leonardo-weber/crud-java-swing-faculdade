package model.bo;

import model.dao.FuncionarioDAO;
import model.vo.FuncionarioVO;

public class FuncionarioBO {
	
	FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
	
	public FuncionarioVO cadastrarFuncionario(FuncionarioVO funcionario) {
		return FuncionarioDAO.cadastrarFuncionario(funcionario);
	}
	
	public boolean deletarFuncionario(FuncionarioVO funcionario) {
		return FuncionarioDAO.deletarFuncionario(funcionario);
	}

	public boolean atualizarFuncionario(FuncionarioVO funcionario) {
		return FuncionarioDAO.atualizarFuncionario(funcionario);
	}

}
