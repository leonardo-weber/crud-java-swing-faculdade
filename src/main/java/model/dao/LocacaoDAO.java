package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.vo.FuncionarioVO;
import model.vo.LocacaoVO;

public class LocacaoDAO {
	
	public LocacaoVO cadastrarLocacao(LocacaoVO locacao) {
		
		String query ="INSERT INTO LOCACAO (DATA_INICIO, DATA_FIM, VALOR, IDCARRO, IDCLIENTE) VALUES (?, ?, ?, ?, ?)";
		
		Connection connection = Banco.getConnection();
		PreparedStatement statement = Banco.getPreparedStatementWithPk(connection, query);
		
		try {
			statement.setTimestamp(1, Timestamp.valueOf(locacao.getDataInicial()));
			statement.setTimestamp(2, Timestamp.valueOf(locacao.getDataFinal()));
			statement.setInt(3, locacao.getValor());
			statement.setInt(4,  locacao.getCarro().getId());
			statement.setInt(5,  locacao.getCliente().getId());
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
		
		String query = "DELETE FROM LOCACAO " + "WHERE IDLOCACAO = " + locacao.getId();
		
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
		
		String query = "UPDATE LOCACAO SET DATA_INICIO = '" + locacao.getDataInicial()
				+ "', DATA_FIM = '" + locacao.getDataFinal()
				+ "', MODELO = " + locacao.getCarro()
				+ "', VALOR = " + locacao.getValor()
				+ "', IDCARRO = " + locacao.getCarro().getId()
				+ "', IDCLIENTE = " + locacao.getCliente().getId()
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
	
public List<LocacaoVO> consultarListaLocacao () {
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<LocacaoVO> listaLocacao = new ArrayList<LocacaoVO>(); 
		

		String query = "SELECT * FROM LOCACAO";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				LocacaoVO locacao = new LocacaoVO();
				locacao.setId(Integer.parseInt(resultado.getString(1)));
				locacao.setDataInicial(LocalDateTime.parse(resultado.getString(4)));
				locacao.setDataFinal(LocalDateTime.parse(resultado.getString(5)));
				locacao.setValor(Integer.parseInt(resultado.getString(6)));
			}
		} catch (SQLException erro) {
			System.out.println("LocacaoDAO - Erro ao executar a query do método consultarListaLocacao");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

          return listaLocacao;
		
	}

}
