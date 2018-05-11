package JDBC;

 import main.Msg;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date; 
import javax.swing.JOptionPane;

import modelos.Funcionario;
 
public class JDBCUpdate {
 
 
	public static void update(Funcionario fun) throws SQLException, ParseException {
 
		Connection dbConnection = null;
		Statement statement = null;
 
		String updateTableSQL = "UPDATE FUNCIONARIOS"
				+ " SET  CPF = ?,NOME = ?,EMAIL = ?, PROF = ?, SALARIO = ?, TELE = ?, DT_NASC = ? ,FOTO = ?  WHERE ID = ?";
				
 
		try {
			dbConnection = Conexao.getDBConnection();
			DateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");
			Date fd = formatter.parse(fun.getData());
			java.sql.Date dtnasc = new java.sql.Date(fd.getTime());
			PreparedStatement pstmt = dbConnection.prepareStatement(updateTableSQL);
			
			pstmt.setString(9,fun.getId());
			pstmt.setBytes(8,fun.getFoto());
			pstmt.setDate(7,dtnasc);
			pstmt.setString(6,fun.getTele());
			pstmt.setDouble(5,fun.getSal());
			pstmt.setString(4, fun.getProf());
			pstmt.setString(3, fun.getEmail());
			pstmt.setString(2, fun.getNome());
			pstmt.setString(1, fun.getCpf());
			pstmt.execute();
 
			 
			
 
		} finally {
 
			if (statement != null) {
				statement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
		
		
		}
		String txt ="Atualização foi efetuada com sucesso!";
		Msg msg = new Msg();
		msg.Mensa(txt);
		
		
	}
 
}
