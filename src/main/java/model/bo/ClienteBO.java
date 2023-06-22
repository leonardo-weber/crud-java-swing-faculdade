package model.bo;

import java.util.List;

import model.dao.ClienteDAO;
import model.vo.CarroVO;
import model.vo.ClienteVO;

public class ClienteBO {
	
	ClienteDAO clienteDAO = new ClienteDAO();
	
	public ClienteVO cadastrarCliente(ClienteVO cliente) {
		return clienteDAO.cadastrarCliente(cliente);
	}
	
	public List<ClienteVO> consultarListaClientes() {
		return clienteDAO.consultarListaClientes();
	}
	
	public boolean deletarCliente(ClienteVO cliente) {
		return clienteDAO.deletarCliente(cliente);
	}

	public boolean atualizarCliente(ClienteVO cliente) {
		return clienteDAO.atualizarCliente(cliente);
	}
	
	public ClienteVO consultarClientePorCPF(String cpf) {
		return clienteDAO.consultarClientePorCPF(cpf);
	}

}
