package model.bo;

import java.util.List;

import model.dao.CarroDAO;
import model.vo.CarroVO;

public class CarroBO {
	
	CarroDAO CarroDAO = new CarroDAO();
	
	public CarroVO cadastrarCarro(CarroVO carro) {
		return CarroDAO.cadastrarCarro(carro);
	}
	
	public List<CarroVO> consultarListaCarros() {
		return CarroDAO.consultarListaCarros();
	}
	
	public boolean deletarCarro(CarroVO carro) {
		return CarroDAO.deletarCarro(carro);
	}

	public boolean atualizarCarro(CarroVO carro) {
		return CarroDAO.atualizarCarro(carro);
	}
	
	public CarroVO consultarCarroPorID(int id) {
		return CarroDAO.consultarCarroPorID(id);
	}
	
	public boolean atualizarDisponibilidadeCarro(int id, boolean disponibilidade) {
		return CarroDAO.atualizarDisponibilidadeCarro(id, disponibilidade);
	}
	
}
