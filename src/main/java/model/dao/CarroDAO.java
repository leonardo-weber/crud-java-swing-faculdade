package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.CarroVO;

public class CarroDAO {
	
	public CarroVO cadastrarCarro(CarroVO carro) {
		
		String query ="INSERT INTO CARRO (MARCA, MODELO, ANO, PLACA) VALUES (?, ?, ?, ?)";
		
		Connection connection = Banco.getConnection();
		PreparedStatement statement = Banco.getPreparedStatementWithPk(connection, query);
		
		try {
			statement.setString(1, carro.getMarca());
			statement.setString(2, carro.getModelo());
			statement.setString(3, carro.getPlaca());
			statement.setString(4, carro.getAno());
			statement.execute();
			ResultSet resultado = statement.getGeneratedKeys();	
			if(resultado.next()) {
				carro.setId(Integer.parseInt(resultado.getString(1)));
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
				+ "' WHERE IDCARRO = " + carro.getId();
		 
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
				CarroVO carro = new CarroVO();
				carro.setMarca(resultado.getString(2));
				carro.setModelo(resultado.getString(3));
				carro.setAno(resultado.getString(4));
				carro.setPlaca(resultado.getString(5));
				listaCarros.add(carro);
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

}
