package model.vo;

import java.time.LocalDateTime;

public class LocacaoVO {
	private int id;
	private CarroVO carro;
	private ClienteVO cliente;
	private LocalDateTime dataInicial;
	private LocalDateTime dataFinal;
	private int valor;
	
	public LocacaoVO() {
		super();
	}
	
	public LocacaoVO(int id, CarroVO carro, ClienteVO cliente, LocalDateTime dataInicial, LocalDateTime dataFinal,
			int valor) {
		super();
		this.id = id;
		this.carro = carro;
		this.cliente = cliente;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.valor = valor;
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
	
	public LocalDateTime getDataInicial() {
		return dataInicial;
	}
	
	public void setDataInicial(LocalDateTime dataInicial) {
		this.dataInicial = dataInicial;
	}
	
	public LocalDateTime getDataFinal() {
		return dataFinal;
	}
	
	public void setDataFinal(LocalDateTime dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
}