package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.CarroController;
import controller.ClienteController;
import model.vo.CarroVO;
import model.vo.ClienteVO;
import model.vo.FuncionarioVO;
import model.vo.LocacaoVO;

public class LocacaoDAO {
	
	public LocacaoVO cadastrarLocacao(LocacaoVO locacao) {
		
		
		String query = "INSERT INTO LOCACAO (DATA_LOCACAO, DATA_PREVISTA_DEVOLUCAO, VALOR_PREVISTO, IDCARRO, IDCLIENTE) VALUES (?, ?, ?, ?, ?)";
		
		Connection connection = Banco.getConnection();
		PreparedStatement statement = Banco.getPreparedStatementWithPk(connection, query);
				
		try {	
			statement.setDate(1, Date.valueOf(locacao.getDataLocacao()));
			statement.setDate(2, Date.valueOf(locacao.getDataPrevistaDevolucao()));
			statement.setInt(3, locacao.getValorPrevisto());
			statement.setInt(4,  locacao.getCarro().getId());
			statement.setInt(5,  locacao.getCliente().getId());
			statement.execute();
			ResultSet resultado = statement.getGeneratedKeys();	
			if(resultado.next()) {
				locacao.setId(Integer.parseInt(resultado.getString(1)));
				JOptionPane.showMessageDialog(null, "Locação cadastrada com sucesso");
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
		
		ClienteController clienteController = new ClienteController();
		CarroController carroController = new CarroController();
		
		String query = "SELECT * FROM LOCACAO";
	
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) { 				
				
				ClienteVO cliente = clienteController.consultarClientePorID(Integer.parseInt(resultado.getString(2)));
				CarroVO carro = carroController.consultarCarroPorID(Integer.parseInt(resultado.getString(3)));
				
				
				LocacaoVO locacao = new LocacaoVO();
				
				String valorPrevisto = new DecimalFormat("#").format(Double.parseDouble(resultado.getString(7)));
				String valorEfetivo = new DecimalFormat("#").format(Double.parseDouble(resultado.getString(8)));
				
				locacao.setId(Integer.parseInt(resultado.getString(1)));
				locacao.setCliente(cliente);
				locacao.setCarro(carro);
				locacao.setDataLocacao(LocalDate.parse(resultado.getString(4), DateTimeFormatter.ofPattern("yyy-MM-dd")));
				locacao.setDataPrevistaDevolucao(LocalDate.parse(resultado.getString(5), DateTimeFormatter.ofPattern("yyy-MM-dd")));
				locacao.setDataEfetivaDevolucao(LocalDate.parse(resultado.getString(6), DateTimeFormatter.ofPattern("yyy-MM-dd")));
				locacao.setValorPrevisto(Integer.parseInt(valorPrevisto));
				locacao.setValorEfetivo(Integer.parseInt(valorEfetivo));
				locacao.setMulta(Integer.parseInt(resultado.getString(9)));
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
