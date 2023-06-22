package model.bo;

import java.util.List;

import model.dao.ClienteDAO;
import model.vo.CarroVO;
import model.vo.ClienteVO;

public class ClienteBO {
	
	ClienteDAO ClienteDAO = new ClienteDAO();
	
	public ClienteVO cadastrarCliente(ClienteVO cliente) {
		return ClienteDAO.cadastrarCliente(cliente);
	}
	
	public List<ClienteVO> consultarListaClientes() {
		return ClienteDAO.consultarListaClientes();
	}
	
	public boolean deletarCliente(ClienteVO cliente) {
		return ClienteDAO.deletarCliente(cliente);
	}

	public boolean atualizarCliente(ClienteVO cliente) {
		return ClienteDAO.atualizarCliente(cliente);
	}

}
