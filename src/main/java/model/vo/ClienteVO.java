package model.vo;

public class ClienteVO {
	
	private int id;
	private String nome;
	private String cnh;
	private String cpf;
	private String telefone;
	
	public ClienteVO(int id, String nome, String cnh, String cpf, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnh = cnh;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public ClienteVO() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCNH() {
		return cnh;
	}
	
	public void setCNH(String cnh) {
		this.cnh = cnh;
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return nome + " / " + cpf + " / " + cnh;
	}

}
