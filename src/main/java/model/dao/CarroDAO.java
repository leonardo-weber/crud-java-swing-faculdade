package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.CarroVO;

public class CarroDAO {
	
	public CarroVO cadastrarCarro(CarroVO carro) {
		
		String query ="INSERT INTO nometabela () VALUES (?, ?, ?, ?, ?)";
		
		Connection connection = Banco.getConnection();
		PreparedStatement statement = Banco.getPreparedStatementWithPk(connection, query);
		
		try {
			statement.setInt(1, carro.getTipocarro());
			statement.setString(2, carro.getNome());
			statement.setString(3, carro.getCpf());
			statement.setObject(4, carro.getDataNasci());
			statement.setString(5, carro.getEmail());
			statement.setDouble(6, carro.getSalariol());
			statement.setString(7, carro.getLogin());
			statement.setString(8, carro.getSenha());
			statement.execute();
			ResultSet resultado = statement.getGeneratedKeys();	
			if(resultado.next()) {
				carro.setIdcarro(Integer.parseInt(resultado.getString(1)));
			}
		} catch (SQLException erro) {
			System.out.println("CarroDAO - Erro ao executar a query do método cadastrarCarro");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(statement);
			Banco.closeConnection(connection);
		}
		
		return carro;
		
	}
	
	public boolean deletarCarro(CarroVO carro) {
		
		Connection connection = Banco.getConnection();
		Statement statement = Banco.getStatement(connection);
		
		boolean retorno = false;
		
		String query = "DELETE FROM usuario " + "WHERE idusuario = " + carro.getIdUsuario();
		
		try {
			if(statement.executeUpdate(query) == 1) {
				retorno = true;                                                                      
			}
		} catch (SQLException erro) {
			System.out.println("CarroDAO - Erro ao executar a query do método deletarCarro");
			System.out.println("Erro: " + erro.getMessage());	
		} finally {
			Banco.closeStatement(statement);
			Banco.closeConnection(connection);
		}
		
		return retorno;
		
	}

	public boolean atualizarCarro(CarroVO carro) {
	
		Connection connection = Banco.getConnection();
		Statement statement = Banco.getStatement(connection);
		
		boolean retorno = false;
		
		String query = "UPDATE usuario SET nome = '" + carro.getNome()
				+ "', email = '" + carro.getEmail()
				+ "', salariol = " + carro.getSalariol()
				+ ", login = '" + carro.getLogin()
				+ "', senha = '" + carro.getSenha()
				+ "' WHERE idusuario = " + carro.getIdUsuario();
		 
		try {
			if(statement.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("CarroDAO - Erro ao executar a query do método atualizarCarro");
			System.out.println("Erro: " + erro.getMessage());	
		} finally {
			Banco.closeStatement(statement);
			Banco.closeConnection(connection);
		}
		
		return retorno;
	
	}

}
