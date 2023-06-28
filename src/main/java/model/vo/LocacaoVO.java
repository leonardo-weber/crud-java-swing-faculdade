package model.vo;

import java.time.LocalDateTime;

public class LocacaoVO {
	private int id;
	private CarroVO carro;
	private ClienteVO cliente;
	private LocalDateTime dataLocacao;
	private LocalDateTime dataPrevistaDevolucao;
	private LocalDateTime dataEfetivaDevolucao;
	private int valorPrevisto;
	private int valorEfetivo;
	private double multa;
	private boolean disponibilidade;
	
	public LocacaoVO() {
		super();
	}
	
	public LocacaoVO (
			int id, 
			CarroVO carro, 
			ClienteVO cliente, 
			LocalDateTime dataLocacao, 
			LocalDateTime dataPrevistaDevolucao, 
			LocalDateTime dataEfetivaDevolucao, 
			int valorPrevisto,
			int valorEfetivo,
			int multa,
			boolean disponibilidade
	) {
		super();
		this.id = id;
		this.carro = carro;
		this.cliente = cliente;
		this.dataLocacao = dataLocacao;
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
		this.dataEfetivaDevolucao = dataEfetivaDevolucao;
		this.valorPrevisto = valorPrevisto;
		this.valorEfetivo = valorEfetivo;
		this.multa = multa;
		this.disponibilidade = disponibilidade;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public CarroVO getCarro() {
		return carro;
	}
	public void setCarro(CarroVO carro) {
		this.carro = carro;
	}
	
	public ClienteVO getCliente() {
		return cliente;
	}
	
	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}
	
	public LocalDateTime getDataLocacao() {
		return dataLocacao;
	}
	
	public void setDataLocacao(LocalDateTime dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	
	public LocalDateTime getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}
	
	public void setDataPrevistaDevolucao(LocalDateTime dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}
	
	public LocalDateTime getDataEfetivaDevolucao() {
		return dataEfetivaDevolucao;
	}
	
	public void setDataEfetivaDevolucao(LocalDateTime dataEfetivaDevolucao) {
		this.dataEfetivaDevolucao = dataEfetivaDevolucao;
	}
	
	public int getValorPrevisto() { 
		return valorPrevisto;
	}
	
	public void setValorPrevisto(int valor) {
		this.valorPrevisto = valor;
	}
	
	public int getValorEfetivo() {
		return valorEfetivo;
	}
	
	public void setValorEfetivo(int valorEfetivo) {
		this.valorEfetivo = valorEfetivo;
	}
	
	public double getMulta() {
		return multa;
	}
	
	public void setMulta(int multa) {
		this.multa = multa;
	}
	public boolean getDisponibilidade() {
		return disponibilidade;
	}
	
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
}