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
import model.vo.FuncionarioVO;

public class FuncionarioDAO {
	
	public FuncionarioVO cadastrarFuncionario(FuncionarioVO funcionario) {
		
		String query ="INSERT INTO FUNCIONARIO (NOME, SENHA, TELEFONE, CPF, SEXO, DATA_NASCIMENTO) VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection connection = Banco.getConnection();
		PreparedStatement statement = Banco.getPreparedStatementWithPk(connection, query);
		
		try {
			statement.setString(1, funcionario.getNome());
			statement.setString(2, funcionario.getSenha());
			statement.setString(3, funcionario.getTelefone());
			statement.setString(4, funcionario.getCPF());
			statement.setString(5, funcionario.getSexo());
			statement.setString(6, funcionario.getDataNascimento());
			statement.execute();	
			ResultSet resultado = statement.getGeneratedKeys();
			if(resultado.next()) {
				funcionario.setId(Integer.parseInt(resultado.getString(1)));
			}
		} catch (SQLException erro) {
			System.out.println("FuncionarioDAO - Erro ao executar a query do método cadastrarFuncionario");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(statement);
			Banco.closeConnection(connection);
		}
		
		return funcionario;
		
		
	}
	
	public boolean deletarFuncionario(FuncionarioVO funcionario) {
		
		Connection connection = Banco.getConnection();
		Statement statement = Banco.getStatement(connection);
		
		boolean retorno = false;
		
		String query = "DELETE FROM FUNCIONARIO " + "WHERE IDFUNCIONARIO = " + funcionario.getId();
		
		try {
			if(statement.executeUpdate(query) == 1) {
				retorno = true;                                                                      
			}
		} catch (SQLException erro) {
			System.out.println("FuncionarioDAO - Erro ao executar a query do método deletarFuncionario");
			System.out.println("Erro: " + erro.getMessage());	
		} finally {
			Banco.closeStatement(statement);
			Banco.closeConnection(connection);
		}
		
		return retorno;
		
	}

	public boolean atualizarFuncionario(FuncionarioVO funcionario) {
	
		Connection connection = Banco.getConnection();
		Statement statement = Banco.getStatement(connection);
		boolean retorno = false;
		
		String query = "UPDATE FUNCIONARIO SET nome = '" + funcionario.getNome()
				+ "', senha = '" + funcionario.getSenha()
				+ "', telefone = " + funcionario.getTelefone()
				+ ", cpf = '" + funcionario.getCPF()
				+ ", sexo = '" + funcionario.getSexo()
				+ ", data_nascimento = '" + funcionario.getDataNascimento()
				+ "' WHERE IDFUNCIONARIO = " + funcionario.getId();
		 
		try {
			if(statement.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("FuncionarioDAO - Erro ao executar a query do método atualizarFuncionario");
			System.out.println("Erro: " + erro.getMessage());	
		} finally {
			Banco.closeStatement(statement);
			Banco.closeConnection(connection);
		}
		
		return retorno;
	
	}
	
	public FuncionarioVO checarFuncionarioValido(FuncionarioVO funcionario) {
		
		Connection connection = Banco.getConnection();
		Statement statement = Banco.getStatement(connection); 
		ResultSet resultado = null;
		
		String query = "SELECT * "
				+ "FROM FUNCIONARIO f "
				+ "WHERE f.nome like '" + funcionario.getNome() + "' "
				+ "AND f.senha = " + funcionario.getSenha();
		
		try {
			resultado = statement.executeQuery(query);
		} catch (SQLException erro) {
			System.out.println("FUncionarioDAO - Erro ao executar a query do método checarFuncionarioValido");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(statement);
			Banco.closeConnection(connection);
		}
		
		return funcionario;
	
	}
	
	public List<FuncionarioVO> consultarListaFuncionarios () {
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		ArrayList<FuncionarioVO> listaFuncionarios = new ArrayList<FuncionarioVO>(); 
		FuncionarioVO funcionario = new FuncionarioVO();
		

		String query = "SELECT * FROM FUNCIONARIO";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				funcionario.setId(Integer.parseInt(resultado.getString(1)));
				funcionario.setNome(resultado.getString(2));
				funcionario.setSenha(resultado.getString(3));
				funcionario.setTelefone(resultado.getString(4));
				funcionario.setCPF(resultado.getString(5));
				funcionario.setSexo(resultado.getString(6));
				listaFuncionarios.add(funcionario);
			}
		} catch (SQLException erro) {
			System.out.println("FuncionarioDAO - Erro ao executar a query do método consultarListaFuncionarios");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

          return listaFuncionarios;
		
	}

}
