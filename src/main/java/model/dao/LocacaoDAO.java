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
import java.util.Collections;
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
		
		
		String query = "INSERT INTO LOCACAO (DATA_LOCACAO, DATA_PREVISTA_DEVOLUCAO, VALOR_PREVISTO, ESTADO, IDCARRO, IDCLIENTE) VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection connection = Banco.getConnection();
		PreparedStatement statement = Banco.getPreparedStatementWithPk(connection, query);
				
		try {	
			statement.setDate(1, Date.valueOf(locacao.getDataLocacao()));
			statement.setDate(2, Date.valueOf(locacao.getDataPrevistaDevolucao()));
			statement.setInt(3, locacao.getValorPrevisto());
			statement.setBoolean(4,  false);
			statement.setInt(5,  locacao.getCarro().getId());
			statement.setInt(6,  locacao.getCliente().getId());
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

	public boolean atualizarDevolucaoLocacaoFinalizada(LocacaoVO locacao) {
	
		Connection connection = Banco.getConnection();
		Statement statement = Banco.getStatement(connection);
				
		boolean retorno = false;
		
		String query = "UPDATE LOCACAO SET DATA_LOCACAO = '" + locacao.getDataLocacao()
				+ "', DATA_PREVISTA_DEVOLUCAO = '" + locacao.getDataPrevistaDevolucao()
				+ "', DATA_EFETIVA_DEVOLUCAO = '" + locacao.getDataEfetivaDevolucao()
				+ "', VALOR_PREVISTO = '" + locacao.getValorPrevisto()
				+ "', VALOR_EFETIVO = '" + locacao.getValorEfetivo()
				+ "', MULTA = '" + locacao.getMulta()
				+ "', ESTADO = " + true				
				+ ", IDCLIENTE = '" + locacao.getCliente().getId()
				+ "', IDCARRO = '" + locacao.getCarro().getId()
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
	
	public boolean cadastrarDevolucao (LocacaoVO locacao) {
		
		boolean locacaoAtualizada = atualizarDevolucaoLocacaoFinalizada(locacao);
		boolean carroDevolvido;
		CarroController carroController = new CarroController();
		
		int carroID = locacao.getCarro().getId();
		carroDevolvido = carroController.setDevolucaoCarro(carroID);
		
		if (locacaoAtualizada && carroDevolvido) {
			JOptionPane.showMessageDialog(null, "Devolução cadastrada com sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "Falha ao cadastrar devolução");
		}
		
		return locacaoAtualizada;
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
				
				boolean valorEfetivoNull = resultado.getString(8) == null;
				boolean dataEfetivaNull = resultado.getString(6) == null;
				boolean multaNull = resultado.getString(9) == null;
								
				ClienteVO cliente = clienteController.consultarClientePorID(Integer.parseInt(resultado.getString(2)));
				CarroVO carro = carroController.consultarCarroPorID(Integer.parseInt(resultado.getString(3)));
				
				LocacaoVO locacao = new LocacaoVO();
				
				String valorPrevisto = new DecimalFormat("#").format(Double.parseDouble(resultado.getString(7)));
				String valorEfetivo = !valorEfetivoNull ? new DecimalFormat("#").format(Double.parseDouble(resultado.getString(8))) : null;
				
				boolean valorMultaZerado = !multaNull ? resultado.getString(9).equals("0.0") : false;
								
				carroController.setLocacaoCarro(Integer.parseInt(resultado.getString(3)));
								
				
				locacao.setId(Integer.parseInt(resultado.getString(1)));
				locacao.setCliente(cliente);
				locacao.setCarro(carro);
				locacao.setDataLocacao(LocalDate.parse(resultado.getString(4), DateTimeFormatter.ofPattern("yyy-MM-dd")));
				locacao.setDataPrevistaDevolucao(LocalDate.parse(resultado.getString(5), DateTimeFormatter.ofPattern("yyy-MM-dd")));
				locacao.setDataEfetivaDevolucao(!dataEfetivaNull ? LocalDate.parse(resultado.getString(6), DateTimeFormatter.ofPattern("yyyy-MM-dd")) : LocalDate.parse(resultado.getString(5), DateTimeFormatter.ofPattern("yyy-MM-dd")));
				locacao.setValorPrevisto(Integer.parseInt(valorPrevisto));
				locacao.setValorEfetivo(!valorEfetivoNull ? Integer.parseInt(valorEfetivo) : Integer.parseInt(valorPrevisto));
				locacao.setMulta(valorMultaZerado || multaNull ? 0 : Integer.parseInt(resultado.getString(9)));
				locacao.setEstado(Boolean.parseBoolean(resultado.getString(10)));
				listaLocacao.add(locacao);
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
	
	public ArrayList<LocacaoVO> buscarLocacaoPorCPF(String cpf) {
		
		List<LocacaoVO> listaTodasLocacoes = consultarListaLocacao();
		
		ArrayList<LocacaoVO> listaLocacoesPorCPF = new ArrayList<LocacaoVO>(); 
		
		for (LocacaoVO locacao: listaTodasLocacoes) {
			if (locacao.getCliente().getCPF().equals(cpf)) {
				listaLocacoesPorCPF.add(locacao);
			}
		}
		
		if (listaLocacoesPorCPF.size() == 0) {
			JOptionPane.showMessageDialog(null, "Não foi encontrado nenhuma locação aberta com esse CPF"); 
		}
		
		return listaLocacoesPorCPF;
		
	}
	
	public LocacaoVO consultarLocacaoPorID (int id) {
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		LocacaoVO locacao = new LocacaoVO();
		
		ClienteController clienteController = new ClienteController();
		CarroController carroController = new CarroController();
		
		
		String query = "SELECT * FROM LOCACAO WHERE IDLOCACAO = " + id;
		
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				
				ClienteVO cliente = clienteController.consultarClientePorID(Integer.parseInt(resultado.getString(2)));
				CarroVO carro = carroController.consultarCarroPorID(Integer.parseInt(resultado.getString(3)));
				
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
				locacao.setMulta(0);
				locacao.setEstado(Boolean.parseBoolean(resultado.getString(10)));
			} else {
				JOptionPane.showMessageDialog(null, "Cliente não encontrado"); 
			}
		} catch (SQLException erro) {
			System.out.println("LocacaoDAO - Erro ao executar a query do método consultarCarroPorID");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

          return locacao;
		
	}

}
