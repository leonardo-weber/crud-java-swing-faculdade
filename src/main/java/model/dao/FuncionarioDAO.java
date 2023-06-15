package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.FuncionarioVO;

public class FuncionarioDAO {
	
	public FuncionarioVO cadastrarFuncionario(FuncionarioVO funcionario) {
		
		String query ="INSERT INTO nometabela () VALUES (?, ?, ?, ?, ?)";
		
		Connection connection = Banco.getConnection();
		PreparedStatement statement = Banco.getPreparedStatementWithPk(connection, query);
		
		try {
			statement.setInt(1, funcionario.getTipofuncionario());
			statement.setString(2, funcionario.getNome());
			statement.setString(3, funcionario.getCpf());
			statement.setObject(4, funcionario.getDataNasci());
			statement.setString(5, funcionario.getEmail());
			statement.setDouble(6, funcionario.getSalariol());
			statement.setString(7, funcionario.getLogin());
			statement.setString(8, funcionario.getSenha());
			statement.execute();
			ResultSet resultado = statement.getGeneratedKeys();	
			if(resultado.next()) {
				funcionario.setIdfuncionario(Integer.parseInt(resultado.getString(1)));
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
		
		String query = "DELETE FROM usuario " + "WHERE idusuario = " + funcionario.getIdUsuario();
		
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
		
		String query = "UPDATE usuario SET nome = '" + funcionario.getNome()
				+ "', email = '" + funcionario.getEmail()
				+ "', salariol = " + funcionario.getSalariol()
				+ ", login = '" + funcionario.getLogin()
				+ "', senha = '" + funcionario.getSenha()
				+ "' WHERE idusuario = " + funcionario.getIdUsuario();
		 
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

}