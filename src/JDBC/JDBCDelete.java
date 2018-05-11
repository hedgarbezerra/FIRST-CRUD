package JDBC;

 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import main.Msg;
import modelos.Funcionario; 
public class JDBCDelete {
 
 
	public static void delete(Funcionario fun) throws SQLException {
 
		Connection dbConnection = null;
		Statement statement = null;
 
		String deleteTableSQL = "DELETE from FUNCIONARIOS WHERE id = ?";
 
		try {
			dbConnection = Conexao.getDBConnection();
			
			PreparedStatement pstmt = dbConnection.prepareStatement(deleteTableSQL);
		    pstmt.setString(1, fun.getId());
		    pstmt.execute();
		   
		} finally {
 
			if (statement != null) {
				statement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
			 
		}
	
		String txt ="Exclusão efetuada com sucesso";
		Msg msg = new Msg();
		msg.Mensa(txt);
}
}
