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
		
		
		String query = "INSERT INTO LOCACAO (IDCLIENTE, IDCARRO, DATA_LOCACAO, DATA_PREVISTA_DEVOLUCAO, DATA_EFETIVA_DEVOLUCAO, VALOR_PREVISTO, VALOR_EFETIVO, MULTA) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection connection = Banco.getConnection();
		PreparedStatement statement = Banco.getPreparedStatementWithPk(connection, query);
		
		try {
			statement.setTimestamp(1, Timestamp.valueOf(locacao.getDataLocacao()));
			statement.setTimestamp(2, Timestamp.valueOf(locacao.getDataPrevistaDevolucao()));
			statement.setTimestamp(3, Timestamp.valueOf(locacao.getDataEfetivaDevolucao()));
			statement.setInt(3, locacao.getValorPrevisto());
			statement.setInt(4, locacao.getValorEfetivo());
			statement.setDouble(5, locacao.getMulta());
			statement.setInt(6,  locacao.getCarro().getId());
			statement.setInt(7,  locacao.getCliente().getId());
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
		
		String query = "UPDATE LOCACAO SET DATA_LOCACAO = '" + locacao.getDataLocacao()
				+ "', DATA_PREVISTA_DEVOLUCAO = '" + locacao.getDataPrevistaDevolucao()
				+ "', DATA_EFETIVA_DEVOLUCAO = " + locacao.getDataEfetivaDevolucao()
				+ "', VALOR_PREVISTO = " + locacao.getValorPrevisto()
				+ "', VALOR_EFETIVO = " + locacao.getValorEfetivo()
				+ "', MULTA = " + locacao.getMulta()
				+ "', IDCLIENTE = " + locacao.getMulta()
				+ "', IDCARRO = " + locacao.getCarro().getId()
				+ "' WHERE IDLOCACAO = " + locacao.getCliente().getId();
		 
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
				locacao.setCliente(resultado.getString(2));
				locacao.setCarro(resultado.getString(3));
				locacao.setDataLocacao(resultado.getString(4));
				locacao.setDataPrevistaDevolucao(resultado.getString(5));
				locacao.setDataEfetivaDevolucao(resultado.getString(5));
				locacao.setValorPrevisto(resultado.getString(6));
				locacao.setValorEfetivo(resultado.getString(7));
				locacao.setMulta(resultado.getString(8));
				locacao.setDisponibilidade(resultado.getString(9));
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
