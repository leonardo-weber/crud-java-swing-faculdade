package model.bo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import model.dao.LocacaoDAO;
import model.vo.LocacaoVO;

public class LocacaoBO {
	
	LocacaoDAO LocacaoDAO = new LocacaoDAO();
	
	public LocacaoVO cadastrarLocacao(LocacaoVO locacao) {
		return LocacaoDAO.cadastrarLocacao(locacao);
	}
	
	public List<LocacaoVO> consultarListaLocacao() {
		return LocacaoDAO.consultarListaLocacao();
	}
	
	public ArrayList<LocacaoVO> buscarLocacaoPorCPF(String cpf) {
		return LocacaoDAO.buscarLocacaoPorCPF(cpf);
	}
	
	public boolean deletarLocacao(LocacaoVO locacao) {
		return LocacaoDAO.deletarLocacao(locacao);
	}
	
	public boolean atualizarLocacao(LocacaoVO locacao) {
		return LocacaoDAO.atualizarLocacao(locacao);
	}
	
	public boolean cadastrarDevolucao(LocacaoVO locacao) {
		return LocacaoDAO.cadastrarDevolucao(locacao);
	}
	
	public LocacaoVO consultarLocacaoPorID(int id) {
		return LocacaoDAO.consultarLocacaoPorID(id);
	}
		
	public int calcularValor(LocalDate dataLocacao, LocalDate dataDevolucao) {
		int duracaoAluguel = (int) ChronoUnit.DAYS.between(dataLocacao, dataDevolucao);
		int valorBase = 100;
		return Math.round(valorBase + (duracaoAluguel * 5));
	}
	
	public int calcularAtraso(LocalDate dataDevolucaoEfetiva, LocalDate dataDevolucaoPrevista) {
		return (int) ChronoUnit.DAYS.between(dataDevolucaoPrevista, dataDevolucaoEfetiva);
	}
	
	public int calcularMulta (LocacaoVO locacao, LocalDate dataEfetivaDevolucao) { 
		int diasAtrasados = calcularAtraso(dataEfetivaDevolucao, locacao.getDataPrevistaDevolucao()); 
		System.out.println(diasAtrasados);
		int valorTotalMulta = diasAtrasados > 0 ? locacao.getValorPrevisto() + diasAtrasados * 10 : 0;
		return valorTotalMulta;
	}
	
	public int calcularValorEfetivo(int valorPrevisto, int multa) {
		return valorPrevisto + multa;
	}
}
