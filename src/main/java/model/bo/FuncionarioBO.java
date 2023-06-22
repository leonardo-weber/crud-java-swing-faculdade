package model.bo;

import java.util.List;

import model.dao.FuncionarioDAO;
import model.vo.CarroVO;
import model.vo.FuncionarioVO;

public class FuncionarioBO {
	
	FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
	
	public FuncionarioVO cadastrarFuncionario(FuncionarioVO funcionario) {
		return FuncionarioDAO.cadastrarFuncionario(funcionario); 
	}
	
	public List<FuncionarioVO> consultarListaFuncionarios() {
		return FuncionarioDAO.consultarListaFuncionarios();
	}
	
	public FuncionarioVO checarFuncionarioValido(FuncionarioVO funcionario) {
		return FuncionarioDAO.checarFuncionarioValido(funcionario);
	}
	
	public boolean deletarFuncionario(FuncionarioVO funcionario) {
		return FuncionarioDAO.deletarFuncionario(funcionario);
	}

	public boolean atualizarFuncionario(FuncionarioVO funcionario) {
		return FuncionarioDAO.atualizarFuncionario(funcionario);
	}

}
