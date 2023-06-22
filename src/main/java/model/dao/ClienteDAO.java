package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.CarroVO;
import model.vo.ClienteVO;

public class ClienteDAO {
	
	public ClienteVO cadastrarCliente(ClienteVO cliente) {
		
		String query ="INSERT INTO CLIENTE (NOME, CPF, TELEFONE, CNH) VALUES (?, ?, ?, ?)";
		
		Connection connection = Banco.getConnection();
		PreparedStatement statement = Banco.getPreparedStatementWithPk(connection, query);
		
		try {
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getCPF());
			statement.setString(3, cliente.getTelefone());
			statement.setObject(4, cliente.getCNH());
			statement.execute();
			ResultSet resultado = statement.getGeneratedKeys();	
			if(resultado.next()) {
				cliente.setId(Integer.parseInt(resultado.getString(1)));
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
		
		String query = "DELETE FROM CLIENTE " + "WHERE IDCLIENTE = " + cliente.getId();
		
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
				+ "', cpf = " + cliente.getCPF()
				+ ", telefone = '" + cliente.getTelefone()
				+ "', cnh = '" + cliente.getCNH()
				+ "' WHERE IDCLIENTE = " + cliente.getId();
		 
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
	
	public List<ClienteVO> consultarListaClientes () {
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ClienteVO> listaClientes = new ArrayList<ClienteVO>(); 
		

		String query = "SELECT * FROM CLIENTE";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				ClienteVO cliente = new ClienteVO();
				cliente.setNome(resultado.getString(2));
				cliente.setCPF(resultado.getString(3));
				cliente.setTelefone(resultado.getString(4));
				cliente.setCNH(resultado.getString(5));
				listaClientes.add(cliente);
			}
		} catch (SQLException erro) {
			System.out.println("ClienteDAO - Erro ao executar a query do método consultarListaClientes");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

          return listaClientes;
		
	}

}
