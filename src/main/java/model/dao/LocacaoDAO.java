package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.LocacaoVO;

public class LocacaoDAO {
	
	public LocacaoVO cadastrarLocacao(LocacaoVO locacao) {
		
		String query ="INSERT INTO LOCACAO (DATA_INICIO, DATA_FIM, MODELO, VALOR) VALUES (?, ?, ?, ?, ?)";
		
		Connection connection = Banco.getConnection();
		PreparedStatement statement = Banco.getPreparedStatementWithPk(connection, query);
		
		try {
			statement.setDate(1, locacao.getData_inicio());
			statement.setDate(2, locacao.getData_fim());
			statement.setInt(3, locacao.getValor());
			statement.execute();
			ResultSet resultado = statement.getGeneratedKeys();	
			if(resultado.next()) {
				locacao.setId(Integer.parseInt(resultado.getString(1)));
			}
		} catch (SQLException erro) {
			System.out.println("LocacaoDAO - Erro ao executar a query do método cadastrarlocacao");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(statement);
			Banco.closeConnection(connection);
		}
		
		return locacao;
		
	}
	
	public boolean deletarLocacao(LocacaoVO locacao) {
		
		Connection connection = Banco.getConnection();
		Statement statement = Banco.getStatement(connection);
		
		boolean retorno = false;
		
		String query = "DELETE FROM LOCACAO " + "WHERE IDLOCACAO = " + locacao.getIdUsuario();
		
		try {
			if(statement.executeUpdate(query) == 1) {
				retorno = true;                                                                      
			}
		} catch (SQLException erro) {
			System.out.println("LocacaoDAO - Erro ao executar a query do método deletarlocacao");
			System.out.println("Erro: " + erro.getMessage());	
		} finally {
			Banco.closeStatement(statement);
			Banco.closeConnection(connection);
		}
		
		return retorno;
		
	}

	public boolean atualizarLocacao(LocacaoVO locacao) {
	
		Connection connection = Banco.getConnection();
		Statement statement = Banco.getStatement(connection);
		
		boolean retorno = false;
		
		String query = "UPDATE LOCACAO SET DATA_INICIO = '" + locacao.getData_inicio()
				+ "', DATA_FIM = '" + locacao.getData_fim()
				+ "', MODELO = " + locacao.getCarro()
				+ "', VALOR = " + locacao.getValor()
				+ "' WHERE IDLOCACAO = " + locacao.getId();
		 
		try {
			if(statement.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("locacaoDAO - Erro ao executar a query do método atualizarlocacao");
			System.out.println("Erro: " + erro.getMessage());	
		} finally {
			Banco.closeStatement(statement);
			Banco.closeConnection(connection);
		}
		
		return retorno;
	
	}

}
