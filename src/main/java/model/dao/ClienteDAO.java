package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.ClienteVO;

public class ClienteDAO {
	
	public ClienteVO cadastrarCliente(ClienteVO cliente) {
		
		String query ="INSERT INTO CLIENTE (NOME, CPF, TELEFONE) VALUES (?, ?, ?, ?, ?)";
		
		Connection connection = Banco.getConnection();
		PreparedStatement statement = Banco.getPreparedStatementWithPk(connection, query);
		
		try {
			statement.setInt(1, cliente.getTipocliente());
			statement.setString(2, cliente.getNome());
			statement.setString(3, cliente.getCpf());
			statement.setObject(4, cliente.getDataNasci());
			statement.setString(5, cliente.getEmail());
			statement.setDouble(6, cliente.getSalariol());
			statement.setString(7, cliente.getLogin());
			statement.setString(8, cliente.getSenha());
			statement.execute();
			ResultSet resultado = statement.getGeneratedKeys();	
			if(resultado.next()) {
				cliente.setIdcliente(Integer.parseInt(resultado.getString(1)));
			}
		} catch (SQLException erro) {
			System.out.println("ClienteDAO - Erro ao executar a query do método cadastrarcliente");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(statement);
			Banco.closeConnection(connection);
		}
		
		return cliente;
		
	}
	
	public boolean deletarCliente(ClienteVO cliente) {
		
		Connection connection = Banco.getConnection();
		Statement statement = Banco.getStatement(connection);
		
		boolean retorno = false;
		
		String query = "DELETE FROM CLIENTE " + "WHERE IDCLIENTE = " + cliente.getIdUsuario();
		
		try {
			if(statement.executeUpdate(query) == 1) {
				retorno = true;                                                                      
			}
		} catch (SQLException erro) {
			System.out.println("ClienteDAO - Erro ao executar a query do método deletarcliente");
			System.out.println("Erro: " + erro.getMessage());	
		} finally {
			Banco.closeStatement(statement);
			Banco.closeConnection(connection);
		}
		
		return retorno;
		
	}

	public boolean atualizarCliente(ClienteVO cliente) {
		
		Connection connection = Banco.getConnection();
		Statement statement = Banco.getStatement(connection);
		
		boolean retorno = false;
		
		String query = "UPDATE CLIENTE SET nome = '" + cliente.getNome()
				+ "', email = '" + cliente.getEmail()
				+ "', salariol = " + cliente.getSalariol()
				+ ", login = '" + cliente.getLogin()
				+ "', senha = '" + cliente.getSenha()
				+ "' WHERE IDCLIENTE = " + cliente.getIdUsuario();
		 
		try {
			if(statement.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("ClienteDAO - Erro ao executar a query do método atualizarCliente");
			System.out.println("Erro: " + erro.getMessage());	
		} finally {
			Banco.closeStatement(statement);
			Banco.closeConnection(connection);
		}
		
		return retorno;
	
	
	}

}
