package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.FuncionarioVO;

public class FuncionarioDAO {
	
	public FuncionarioVO cadastrarFuncionario(FuncionarioVO funcionario) {
		
		String query ="INSERT INTO FUNCIONARIO (NOME, SENHA, TELEFONE, CPF) VALUES (?, ?, ?, ?)";
		
		Connection connection = Banco.getConnection();
		PreparedStatement statement = Banco.getPreparedStatementWithPk(connection, query);
		
		try {
			statement.setString(1, funcionario.getNome());
			statement.setString(2, funcionario.getSenha());
			statement.setString(3, funcionario.getTelefone());
			statement.setObject(4, funcionario.getCPF());
			statement.execute();
			ResultSet resultado = statement.getGeneratedKeys();
			if(resultado.next()) {
				funcionario.setId(Integer.parseInt(resultado.getString(1)));
			}
		} catch (SQLException erro) {
			System.out.println("FuncionarioDAO - Erro ao executar a query do método cadastrarFuncionario");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(statement);
			Banco.closeConnection(connection);
		}
		
		return funcionario;
		
		
	}
	
	public boolean deletarFuncionario(FuncionarioVO funcionario) {
		
		Connection connection = Banco.getConnection();
		Statement statement = Banco.getStatement(connection);
		
		boolean retorno = false;
		
		String query = "DELETE FROM FUNCIONARIO " + "WHERE IDFUNCIONARIO = " + funcionario.getId();
		
		try {
			if(statement.executeUpdate(query) == 1) {
				retorno = true;                                                                      
			}
		} catch (SQLException erro) {
			System.out.println("FuncionarioDAO - Erro ao executar a query do método deletarFuncionario");
			System.out.println("Erro: " + erro.getMessage());	
		} finally {
			Banco.closeStatement(statement);
			Banco.closeConnection(connection);
		}
		
		return retorno;
		
	}

	public boolean atualizarFuncionario(FuncionarioVO funcionario) {
	
		Connection connection = Banco.getConnection();
		Statement statement = Banco.getStatement(connection);
		boolean retorno = false;
		
		String query = "UPDATE FUNCIONARIO SET nome = '" + funcionario.getNome()
				+ "', senha = '" + funcionario.getSenha()
				+ "', telefone = " + funcionario.getTelefone()
				+ ", cpf = '" + funcionario.getCPF()
				+ "' WHERE IDFUNCIONARIO = " + funcionario.getId();
		 
		try {
			if(statement.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("FuncionarioDAO - Erro ao executar a query do método atualizarFuncionario");
			System.out.println("Erro: " + erro.getMessage());	
		} finally {
			Banco.closeStatement(statement);
			Banco.closeConnection(connection);
		}
		
		return retorno;
	
	}
	
	public FuncionarioVO checarFuncionarioValido(FuncionarioVO funcionario) {
		
		Connection connection = Banco.getConnection();
		Statement statement = Banco.getStatement(connection); 
		ResultSet resultado = null;
		
		String query = "SELECT * "
				+ "FROM FUNCIONARIO f "
				+ "WHERE f.nome like '" + funcionario.getNome() + "' "
				+ "AND f.senha = " + funcionario.getSenha();
		
		try {
			resultado = statement.executeQuery(query);
		} catch (SQLException erro) {
			System.out.println("FUncionarioDAO - Erro ao executar a query do método checarFuncionarioValido");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(statement);
			Banco.closeConnection(connection);
		}
		
		return funcionario;
	
	}

}
