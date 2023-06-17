package model.bo;

import model.dao.ClienteDAO;
import model.vo.ClienteVO;

public class ClienteBO {
	
	ClienteDAO ClienteDAO = new ClienteDAO();
	
	public ClienteVO cadastrarCarro(ClienteVO cliente) throws CpfJaUtilizadoException {
		
		if (userDAO.cpfJaUtilizado(cliente.getCpf())) {
			throw new CpfJaUtilizadoException("Este CPF já está cadastrado!");
		}
		
		return ClienteDAO.cadastrarCliente(cliente);
	}
	
	public boolean deletarCarro(ClienteVO cliente) {
		return ClienteDAO.deletarCliente(cliente);
	}

	public boolean atualizarCarro(ClienteVO cliente) {
		return ClienteDAO.atualizarCliente(cliente);
	}

}
