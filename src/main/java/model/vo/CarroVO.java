package model.vo;

public class CarroVO {
	
	private int id;
	private String marca;
	private String modelo;
	private String placa;
	private int ano;
	
	public CarroVO(int id, String marca, String modelo, String placa, int ano) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.ano = ano;
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

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
	
}