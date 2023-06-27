package model.vo;

public class ClienteVO {
	
	private int id;
	private String nome;
	private String cnh;
	private String cpf;
	private String telefone;
	private String sexo;
	private String dataNascimento;
	
	public ClienteVO(int id, String nome, String cnh, String cpf, String telefone, String sexo, String dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnh = cnh;
		this.cpf = cpf;
		this.telefone = telefone;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
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
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public String toString() {
		return nome + " / " + cpf + " / " + cnh;
	}

}
