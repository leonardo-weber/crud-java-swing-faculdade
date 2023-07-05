package model.bo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import model.dao.LocacaoDAO;
import model.vo.FuncionarioVO;
import model.vo.LocacaoVO;

public class LocacaoBO {
	
	LocacaoDAO LocacaoDAO = new LocacaoDAO();
	
	public LocacaoVO cadastrarLocacao(LocacaoVO locacao) {
		return LocacaoDAO.cadastrarLocacao(locacao);
	}
	
	public List<LocacaoVO> consultarListaLocacao() {
		return LocacaoDAO.consultarListaLocacao();
	}
	
	public boolean deletarLocacao(LocacaoVO locacao) {
		return LocacaoDAO.deletarLocacao(locacao);
	}

	public boolean atualizarLocacao(LocacaoVO locacao) {
		return LocacaoDAO.atualizarLocacao(locacao);
	}
	
	public int calcularValor(LocalDate dataLocacao, LocalDate dataDevolucao) {
		int duracaoAluguel = (int) ChronoUnit.DAYS.between(dataLocacao, dataDevolucao);
		int valorBase = 100;
		return Math.round(valorBase + (duracaoAluguel * 5));
	}
	
	public int calcularAtraso(LocalDate dataDevolucaoEfetiva, LocalDate dataDevolucaoPrevista) {
		return (int) ChronoUnit.DAYS.between(dataDevolucaoEfetiva, dataDevolucaoPrevista);
	}

	public boolean cadastrarDevolucao(LocacaoVO locacao) {
		return LocacaoDAO.cadastrarDevolucao(locacao);
	}
}
