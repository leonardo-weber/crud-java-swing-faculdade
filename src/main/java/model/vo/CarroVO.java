package model.vo;

public class CarroVO {
	
	private int id;
	private String marca;
	private String modelo;
	private String placa;
	private String ano;
	private String cor;
	
	public CarroVO(int id, String marca, String modelo, String placa, String ano, String cor) {
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
	
	@Override
	public String toString() {
		return marca + " / " + modelo + " / " + ano;
	}
	
	
}