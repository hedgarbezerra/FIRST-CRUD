package JDBC;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 import org.eclipse.wb.swing.*;
public class Conexao {
 
	// Para conexão ao oracle
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USER = "HED";
	private static final String DB_PASSWORD = "HED";
	
	// Para conexão mysql
	/*static final String DB_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_CONNECTION = "jdbc:mysql://localhost/cliente";
	static final String DB_USER = "root";
	static final String DB_PASSWORD = "root";*/
 
	public static Connection getDBConnection() {
 
		Connection dbConnection = null;
 
		try {
 
			Class.forName(DB_DRIVER);
 
		} catch (ClassNotFoundException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		return dbConnection;
 
	}
 
}
