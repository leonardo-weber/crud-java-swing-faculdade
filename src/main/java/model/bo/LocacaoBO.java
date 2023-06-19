package model.bo;

import model.dao.LocacaoDAO;
import model.vo.LocacaoVO;

public class LocacaoBO {
	
	LocacaoDAO LocacaoDAO = new LocacaoDAO();
	
	public LocacaoVO cadastrarLocacao(LocacaoVO locacao) {
		return LocacaoDAO.cadastrarLocacao(locacao);
	}
	
	public boolean deletarLocacao(LocacaoVO locacao) {
		return LocacaoDAO.deletarLocacao(locacao);
	}

	public boolean atualizarLocacao(LocacaoVO locacao) {
		return LocacaoDAO.atualizarLocacao(locacao);
	}

}
