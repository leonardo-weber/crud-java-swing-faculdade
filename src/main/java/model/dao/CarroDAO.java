package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.vo.CarroVO;
import model.vo.ClienteVO;

public class CarroDAO {
	
	public CarroVO cadastrarCarro(CarroVO carro) {
		
		String query ="INSERT INTO CARRO (MARCA, MODELO, ANO, PLACA, COR, DISPONIBILIDADE, ATIVO) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		Connection connection = Banco.getConnection();
		PreparedStatement statement = Banco.getPreparedStatementWithPk(connection, query);
		
		try {
			statement.setString(1, carro.getMarca());
			statement.setString(2, carro.getModelo());
			statement.setString(3, carro.getAno());
			statement.setString(4, carro.getPlaca());
			statement.setString(5, carro.getCor());
			statement.setBoolean(6,  true);
			statement.setBoolean(7,  true);
			statement.execute();
			ResultSet resultado = statement.getGeneratedKeys();	
			if(resultado.next()) {
				carro.setId(Integer.parseInt(resultado.getString(1)));
				JOptionPane.showMessageDialog(null, "Carro Cadastrado com sucesso!");
			}
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Falha ao cadastrar carro!");
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
		
		String query = "DELETE FROM CARRO " + "WHERE IDCARRO = " + carro.getId();
		
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
		
		String query = "UPDATE CARRO SET marca = '" + carro.getMarca()
				+ "', modelo = '" + carro.getModelo()
				+ "', ano = " + carro.getAno()
				+ ", placa = '" + carro.getPlaca()
				+ "', cor = '" + carro.getCor()
				+ "', disponibilidade = " + carro.getDisponibilidade()
				+ ", ativo = " + carro.getAtivo()
				+ " WHERE IDCARRO = " + carro.getId();
		
		System.out.println(query);  
		
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
	
	public List<CarroVO> consultarListaCarros() {
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		ArrayList<CarroVO> listaCarros = new ArrayList<CarroVO>(); 		

		String query = "SELECT * FROM CARRO"; 
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				CarroVO carroVO = new CarroVO();
				carroVO.setId(Integer.parseInt(resultado.getString(1)));
				carroVO.setMarca(resultado.getString(2));
				carroVO.setModelo(resultado.getString(3));
				carroVO.setAno(resultado.getString(4));
				carroVO.setPlaca(resultado.getString(5));
				carroVO.setCor(resultado.getString(6));
				carroVO.setDisponibilidade(resultado.getBoolean(7));
				carroVO.setAtivo(resultado.getBoolean(8));
				listaCarros.add(carroVO);
			}
		} catch (SQLException erro) {
			System.out.println("CarroDA0 - Erro ao executar a query do método consultarListaCarros");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

          return listaCarros;
		
	}
	
	public List<CarroVO> consultarCarrosComFiltroDeDisponibilidade(boolean disponibilidade) {
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		ArrayList<CarroVO> listaCarros = new ArrayList<CarroVO>(); 		

		String query = "SELECT * FROM CARRO WHERE DISPONIBILIDADE = " + disponibilidade; 
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				CarroVO carroVO = new CarroVO();
				carroVO.setId(Integer.parseInt(resultado.getString(1)));
				carroVO.setMarca(resultado.getString(2));
				carroVO.setModelo(resultado.getString(3));
				carroVO.setAno(resultado.getString(4));
				carroVO.setPlaca(resultado.getString(5));
				carroVO.setCor(resultado.getString(6));
				carroVO.setDisponibilidade(resultado.getBoolean(7));
				carroVO.setAtivo(resultado.getBoolean(8));
				listaCarros.add(carroVO);
			}
		} catch (SQLException erro) {
			System.out.println("CarroDA0 - Erro ao executar a query do método consultarListaCarros");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

          return listaCarros;
		
	}
	
	public List<CarroVO> consultarCarrosDisponiveisEAtivos() {
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		ArrayList<CarroVO> listaCarros = new ArrayList<CarroVO>(); 		

		String query = "SELECT * FROM CARRO WHERE DISPONIBILIDADE = TRUE AND ATIVO = TRUE"; 
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				CarroVO carroVO = new CarroVO();
				carroVO.setId(Integer.parseInt(resultado.getString(1)));
				carroVO.setMarca(resultado.getString(2));
				carroVO.setModelo(resultado.getString(3));
				carroVO.setAno(resultado.getString(4));
				carroVO.setPlaca(resultado.getString(5));
				carroVO.setCor(resultado.getString(6));
				carroVO.setDisponibilidade(resultado.getBoolean(7));
				carroVO.setAtivo(resultado.getBoolean(8));
				listaCarros.add(carroVO);
			}
		} catch (SQLException erro) {
			System.out.println("CarroDA0 - Erro ao executar a query do método consultarListaCarros");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

          return listaCarros;
		
	}
	
	public List<CarroVO> consultarCarrosAtivosEmFrota() {
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		ArrayList<CarroVO> listaCarros = new ArrayList<CarroVO>(); 		

		String query = "SELECT * FROM CARRO WHERE ATIVO = TRUE"; 
	
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				CarroVO carroVO = new CarroVO();
				carroVO.setId(Integer.parseInt(resultado.getString(1)));
				carroVO.setMarca(resultado.getString(2));
				carroVO.setModelo(resultado.getString(3));
				carroVO.setAno(resultado.getString(4));
				carroVO.setPlaca(resultado.getString(5));
				carroVO.setCor(resultado.getString(6));
				carroVO.setDisponibilidade(resultado.getBoolean(7));
				carroVO.setAtivo(resultado.getBoolean(8));
				listaCarros.add(carroVO);
			}
		} catch (SQLException erro) {
			System.out.println("CarroDA0 - Erro ao executar a query do método consultarListaCarros");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

          return listaCarros;
		
	}
	
	public CarroVO consultarCarroPorID (int id) {
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		CarroVO carro = new CarroVO();
		
		String query = "SELECT * FROM CARRO WHERE IDCARRO = " + id;
		
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				carro.setId(Integer.parseInt(resultado.getString(1)));
				carro.setMarca(resultado.getString(2));
				carro.setModelo(resultado.getString(3));
				carro.setAno(resultado.getString(4));
				carro.setPlaca(resultado.getString(5));
				carro.setCor(resultado.getString(6));
				carro.setDisponibilidade(resultado.getBoolean(7));
				carro.setAtivo(resultado.getBoolean(8));
			} else {
				JOptionPane.showMessageDialog(null, "Cliente não encontrado"); 
			}
		} catch (SQLException erro) {
			System.out.println("CarroDAO - Erro ao executar a query do método consultarCarroPorID");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

          return carro;
		
	}
	
	public boolean atualizarDisponibilidadeCarro(int id, boolean disponibilidade) {
				
		Connection connection = Banco.getConnection();
		Statement statement = Banco.getStatement(connection);
		boolean retorno = false;
		
		String query = "UPDATE CARRO SET DISPONIBILIDADE = " + disponibilidade + " WHERE IDCARRO = " + id;
		 
		try {
			if(statement.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("CarroDAO - Erro ao executar a query do método atualizarDisponibilidadeCarro");
			System.out.println("Erro: " + erro.getMessage());	
		} finally {
			Banco.closeStatement(statement);
			Banco.closeConnection(connection);
		}
		
		return retorno;
	
	}
	
	public boolean atualizarStatusCarro(int id, boolean status) {
		
		Connection connection = Banco.getConnection();
		Statement statement = Banco.getStatement(connection);
		boolean retorno = false;
		
		String query = "UPDATE CARRO SET ATIVO = " + status + " WHERE IDCARRO = " + id;
		 
		try {
			if(statement.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("CarroDAO - Erro ao executar a query do método atualizarStatusCarro");
			System.out.println("Erro: " + erro.getMessage());	
		} finally {
			Banco.closeStatement(statement);
			Banco.closeConnection(connection);
		}
		
		return retorno;
	
	}

}
