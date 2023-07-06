package model.bo;

import java.util.ArrayList;
import java.util.List;

import model.dao.FuncionarioDAO;
import model.vo.CarroVO;
import model.vo.FuncionarioVO;

public class FuncionarioBO {
	
	FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
	
	public boolean cadastrarFuncionario(FuncionarioVO funcionario) {
		return FuncionarioDAO.cadastrarFuncionario(funcionario); 
	}
	
	public List<FuncionarioVO> consultarListaFuncionarios() {
		return FuncionarioDAO.consultarListaFuncionarios();
	}
	
	public boolean checarFuncionarioValido(FuncionarioVO funcionario) {
		return FuncionarioDAO.checarFuncionarioValido(funcionario);
	}
	
	public boolean deletarFuncionario(FuncionarioVO funcionario) {
		return FuncionarioDAO.deletarFuncionario(funcionario);
	}

	public boolean desativarFuncionario(FuncionarioVO funcionario) {
		return FuncionarioDAO.atualizarStatusFuncionario(funcionario, false);
	}

	public boolean ativarFuncionario(FuncionarioVO funcionario) {
		return FuncionarioDAO.atualizarStatusFuncionario(funcionario, true);
	}

	public ArrayList<FuncionarioVO> consultarListaFuncionariosComFiltragemDeStatus (boolean status) {
		return FuncionarioDAO.consultarListaFuncionariosComFiltragemDeStatus(status);
	}
	
	public boolean atualizarFuncionario(FuncionarioVO funcionario) {
		return FuncionarioDAO.atualizarFuncionario(funcionario);
	}

}
