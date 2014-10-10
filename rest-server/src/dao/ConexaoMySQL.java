package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
	public static String status = "N�o conectou...";
	
	public ConexaoMySQL() {}
	
	public static java.sql.Connection getConexaoMySQL() {
		Connection connection = null;
	
		try { 
			String driverName = "com.mysql.jdbc.Driver"; 
			Class.forName(driverName);
			  
			String url = "jdbc:mysql://php-italoluz.rhcloud.com:3306/app"; //jdbc:mysql://php-italoluz.rhcloud.com/php 
			String username = "root"; //adminVWdn31p
			String password = ""; //hgmygUv9xHB6 
			
			connection = DriverManager.getConnection(url, username, password);
			
			if (connection != null) 
				status = ("STATUS--->Conectado com sucesso!");
			else 
				status = ("STATUS--->N�o foi possivel realizar conex�o"); 
			
			return connection;
		}
		catch (ClassNotFoundException e) {
			System.out.println("O driver expecificado nao foi encontrado."); 
			return null;			
		}catch (SQLException e) {
			System.out.println("Nao foi possivel conectar ao Banco de Dados."); 
			return null;
		}
	}
	
	public static String statusConection() { return status; }
	
	public static boolean FecharConexao() { 
		try { 
				ConexaoMySQL.getConexaoMySQL().close(); 
				return true; 
			} catch (SQLException e) { 
				return false; 
			} 
	}
	
	public static java.sql.Connection ReiniciarConexao() { 
		FecharConexao(); 
		return ConexaoMySQL.getConexaoMySQL(); 
	}
	
	public static void main(String[] args) throws SQLException {
		ConexaoMySQL conexao = new ConexaoMySQL();
		conexao.getConexaoMySQL();
		System.out.println(conexao.statusConection());
		conexao.FecharConexao();	
	}

}
