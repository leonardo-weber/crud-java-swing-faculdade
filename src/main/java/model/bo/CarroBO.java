package model.bo;

import java.util.List;

import model.dao.CarroDAO;
import model.vo.CarroVO;

public class CarroBO {
	
	CarroDAO carroDAO = new CarroDAO();
	
	public CarroVO cadastrarCarro(CarroVO carro) {
		return carroDAO.cadastrarCarro(carro);
	}
	
	public List<CarroVO> consultarListaCarros() {
		return carroDAO.consultarListaCarros();
	}
	
	public List<CarroVO> consultarCarrosComFiltroDeDisponibilidade(boolean disponibilidade) {
		return carroDAO.consultarCarrosComFiltroDeDisponibilidade(disponibilidade);
	}
	
	public boolean ativarStatusCarro (int id) {
		return carroDAO.atualizarStatusCarro(id, true);
	}
	
	public boolean desativarStatusCarro (int id) {
		return carroDAO.atualizarStatusCarro(id, false);
	}

	public boolean atualizarCarro(CarroVO carro) {
		return carroDAO.atualizarCarro(carro);
	}
	
	public CarroVO consultarCarroPorID(int id) {
		return carroDAO.consultarCarroPorID(id);
	} 
	
	public boolean atualizarDisponibilidadeCarro(int id, boolean disponibilidade) {
		return carroDAO.atualizarDisponibilidadeCarro(id, disponibilidade);
	}
	
}
