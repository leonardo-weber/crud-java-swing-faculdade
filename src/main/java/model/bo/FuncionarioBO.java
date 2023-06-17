package model.bo;

import model.dao.FuncionarioDAO;
import model.vo.FuncionarioVO;

public class FuncionarioBO {
	
	FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
	
	public FuncionarioVO cadastrarCarro(FuncionarioVO funcionario) throws CpfJaUtilizadoException {
		
		if (userDAO.cpfJaUtilizado(carro.getCpf())) {
			throw new CpfJaUtilizadoException("Este CPF já está cadastrado!");
		}
		
		return FuncionarioDAO.cadastrarFuncionario(funcionario);
	}
	
	public boolean deletarCarro(FuncionarioVO funcionario) {
		return FuncionarioDAO.deletarFuncionario(funcionario);
	}

	public boolean atualizarCarro(FuncionarioVO funcionario) {
		return FuncionarioDAO.atualizarFuncionario(funcionario);
	}

}
