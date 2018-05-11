package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelos.Funcionario;


public class JDBCSelect {
   
   public static List<Funcionario> select() throws SQLException {
	   List<Funcionario> funcs = new ArrayList<>();
	   Connection dbConnection = null;
		Statement statement = null;
	   Statement stmt = null;
	   try{
		   dbConnection = Conexao.getDBConnection();
	      stmt = dbConnection.createStatement();
	    
	    
	      String sql = "SELECT ID, CPF,NOME,EMAIL,PROF,SALARIO,TELE,DT_CAD FROM FUNCIONARIOS";
	      PreparedStatement pstmt = dbConnection.prepareStatement(sql);
			
	      ResultSet rs = pstmt.executeQuery(sql);

	      while(rs.next()){
	    	 String id = rs.getString("ID");
	    	String cpf = rs.getString("CPF");
	    	String nome = rs.getString("NOME");
	    	String email = rs.getString("EMAIL");
	    	String prof = rs.getString("PROF");
	    	double sal = rs.getDouble("SALARIO");
	    	Date data = rs.getDate("CAD_DATA");
	    	String tele = rs.getString("TELE");
						    
			    Funcionario funcionario = new Funcionario(id,cpf,nome, email,prof, sal,tele,data );
			    funcs.add(funcionario);
			   
	      }
	     
	      rs.close();
	      stmt.close();
	      dbConnection.close();
	      return funcs;
	   } catch (SQLException e) {
		   throw new RuntimeException(e.getMessage());
	   }finally{
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }
	      try{
	         if(dbConnection!=null)
	        	 dbConnection.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }
	   }
	  
   }
   
   @SuppressWarnings("unused")
public static void main(String[] args) throws SQLException {
	   List<Funcionario> funcs = select();
	   for(Funcionario funcionario:funcs){
		   System.out.println(((Funcionario) funcs).getNome());
	   }
   }
}