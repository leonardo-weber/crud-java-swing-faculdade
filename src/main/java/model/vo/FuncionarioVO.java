package model.vo;

import java.time.LocalDate;

public class FuncionarioVO {
	
	private int id;
	private String nome;
	private String telefone;
	private String cpf;
	private String senha;
	private String sexo;
	private LocalDate dataNascimento;
	private boolean ativo;
	
	public FuncionarioVO() {
		super();
	}
	
	public FuncionarioVO(int id, String nome, String telefone, String cpf, String senha, String sexo, LocalDate dataNascimento, boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.senha = senha;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.ativo = ativo;
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
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public boolean getAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public String toString() {
		return nome + " / " + telefone + " / " + cpf + " / " + sexo + " / " + dataNascimento;
	}

}
