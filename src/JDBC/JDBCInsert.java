
package JDBC;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
 
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JOptionPane;

import main.Msg;
import modelos.Funcionario;
import oracle.sql.BFILE;

public class JDBCInsert {
	
	//private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 
	public static void insert(Funcionario fun) throws SQLException, ParseException {
 
		Connection dbConnection = null;
		Statement statement = null;
		
		String insertTableSQL = "INSERT INTO FUNCIONARIOS(ID,CPF,NOME,EMAIL,PROF,SALARIO,TELE,DT_NASC,FOTO) VALUES(FUNCSEQ.NEXTVAL, ?, ?, ? ,?, ?, ?, ?,?) ";
 
		try{
			dbConnection = Conexao.getDBConnection();
			
			PreparedStatement pstmt = dbConnection.prepareStatement(insertTableSQL);
			DateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");
			Date fd = formatter.parse(fun.getData());
			java.sql.Date dtnasc = new java.sql.Date(fd.getTime());
			pstmt.setBytes(8,fun.getFoto());
			pstmt.setDate(7,dtnasc);		
			pstmt.setString(6,fun.getTele());
			pstmt.setDouble(5, fun.getSal());
			pstmt.setString(4,fun.getProf());
			pstmt.setString(3, fun.getEmail());
			pstmt.setString(2, fun.getNome());
			pstmt.setString(1, fun.getCpf());
		    		   
		    pstmt.executeUpdate();
 
		} finally {
 
			if (statement != null) {
				statement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
		String txt = "Cadastro efetuado com sucesso ";
		Msg msg = new Msg();
		msg.Mensa(txt);
	}
}
