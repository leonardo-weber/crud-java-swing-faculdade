package model.vo;

public class CarroVO {
	
	private int id;
	private String marca;
	private String modelo;
	private String placa;
	private String ano;
	private String cor;
	private boolean disponibilidade;
	private boolean ativo;
	
	public CarroVO(int id, String marca, String modelo, String placa, String ano, String cor, boolean disponibilidade, boolean ativo) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.ano = ano;
		this.disponibilidade = disponibilidade;
		this.ativo = ativo;
	}
	
	public CarroVO() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor= cor;
	}
	
	public boolean getDisponibilidade() {
		return disponibilidade;
	}
	
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	public boolean getAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public String toString() {
		return marca + " / " + modelo + " / " + ano + " / " + placa + " / " + cor;
	}
	
	
}