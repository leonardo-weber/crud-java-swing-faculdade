package model.bo;

import model.dao.CarroDAO;
import model.vo.CarroVO;

public class CarroBO {
	
	CarroDAO CarroDAO = new CarroDAO();
	
	public CarroVO cadastrarCarro(CarroVO carro) {
		return CarroDAO.cadastrarCarro(carro);
	}
	
	public boolean deletarCarro(CarroVO carro) {
		return CarroDAO.deletarCarro(carro);
	}

	public boolean atualizarCarro(CarroVO carro) {
		return CarroDAO.atualizarCarro(carro);
	}
	
}
