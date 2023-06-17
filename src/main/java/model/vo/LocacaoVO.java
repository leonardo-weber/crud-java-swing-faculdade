package model.vo;

import java.time.LocalDateTime;

public class LocacaoVO {
	private int id;
	private CarroVO carro;
	private ClienteVO cliente;
	private LocalDateTime data_inicio;
	private LocalDateTime data_fim;
	private int valor;
	
	public LocacaoVO() {
		super();
	}
	
	public LocacaoVO(int id, CarroVO carro, ClienteVO cliente, LocalDateTime data_inicio, LocalDateTime data_fim,
			int valor) {
		super();
		this.id = id;
		this.carro = carro;
		this.cliente = cliente;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
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
	
	public LocalDateTime getData_inicio() {
		return data_inicio;
	}
	
	public void setData_inicio(LocalDateTime data_inicio) {
		this.data_inicio = data_inicio;
	}
	
	public LocalDateTime getData_fim() {
		return data_fim;
	}
	
	public void setData_fim(LocalDateTime data_fim) {
		this.data_fim = data_fim;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
}