package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import main.Msg;
import modelos.Chefe;

public class JDBCLogin {
	static boolean confirm;
	public static void Login(Chefe chefe) throws SQLException {
		String sql = "select * from CHEFE where usuario = ? AND senha = ? ";
		Connection dbConnection = null;
		Statement statement = null;
		try {
			dbConnection = Conexao.getDBConnection();
			
			PreparedStatement pstmt = dbConnection.prepareStatement(sql);	
			pstmt.setString(1,chefe.getUsuario() );
		    pstmt.setString(2, chefe.getSenha());
		    ResultSet rs= pstmt.executeQuery();	
		    
			if (rs.next()) {
				String txt = "Login efetuado com sucesso. ";
				Msg msg = new Msg();
				msg.Mensa(txt);
				confirm = true;
			}else {	
				String txt = "Senha ou usuário incorretos.";
				Msg msg = new Msg();
				msg.Mensa(txt);
				confirm = false;
			}
		}
			
		catch(Exception a){
			String txt = a.toString();
			Msg msg = new Msg();
			msg.Mensa(txt);
		}
		
		
	}
	public static boolean isConfirm() {
		return confirm;
	}
	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}
	
}
					
		    
		
		
