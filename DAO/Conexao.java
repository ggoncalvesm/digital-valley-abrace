package DAO;

public class Conexao {
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	public class Conexao {

	//construtor - toda vez que esta classe � instanciada cria uma conex�o
	    public Connection getConnection() { 
	    	try 
	    	{ 
	    		return DriverManager.getConnection( "jdbc:mysql://localhost/fj21", "root", "");//realizar conex�o com o derby
	    	} 
	    	catch (SQLException e) 
	    	{ 
	    		throw new RuntimeException(e);
	    	} 
	    }
	}
}
