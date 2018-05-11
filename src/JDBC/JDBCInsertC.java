package JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import main.Msg;
import modelos.Chefe;

public class JDBCInsertC {
	public static void insert(Chefe chefe) throws SQLException {
		 
		Connection dbConnection = null;
		Statement statement = null;
 
		String insertTableSQL = "INSERT INTO CHEFE(ID,USUARIO,NOME,EMAIL,SENHA) VALUES(FUNCSEQ.NEXTVAL, ?,?,?,?)";
 
		try{
			dbConnection = Conexao.getDBConnection();
			
			PreparedStatement pstmt = dbConnection.prepareStatement(insertTableSQL);
				
			pstmt.setString(4, chefe.getSenha());
			pstmt.setString(3, chefe.getEmail());
			pstmt.setString(2,chefe.getNome());
			pstmt.setString(1,chefe.getUsuario());
		   
		   
		    pstmt.executeUpdate();
 
		} finally {
 
			if (statement != null) {
				statement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
		String txt="O cadastro foi criado com sucesso. ";
		Msg msg = new Msg();
		msg.Mensa(txt);
	}

}
