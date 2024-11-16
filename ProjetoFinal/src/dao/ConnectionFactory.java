package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Classe responsável pela criação de conexões com o banco MySQL.
public class ConnectionFactory {
	
	//variaveis
	private static final String url = "jdbc:mysql://localhost:3306/bd_banco_malvader?useTimeZone=true&serverTimeZone=UTC&useSSL=false";
	private static final String usuario = "root";
	private static final String senha = "admin";
	private static final String driver = "com.mysql.cj.jdbc.Driver";
		    
	//Configuração das propriedades useTimeZone, serverTimeZone e SSL.
	//metodo para conectar
	public static Connection conectar() throws SQLException {
		Connection conexao = null;
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, usuario, senha);
		} catch (ClassNotFoundException e) {
			System.out.println("Falha ao registrar o driver: " + e.getMessage());
			} 
		return conexao;
	}
	
	//metodo para desconectar
	public static void close(Connection conexao) throws SQLException{
		if(conexao != null){
			conexao.close();
		}
	}    
}

