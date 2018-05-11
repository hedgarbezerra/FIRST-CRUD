package main;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import JDBC.Conexao;
import net.proteanit.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Dimension;
import javax.swing.UIManager;

public class FuncTable extends JFrame {
	private JPanel contentPane;
	private JTextField nomefield;
	private JTextField funcfield;
	private JTable table;
	Attdados att = new Attdados();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncTable frame = new FuncTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FuncTable() {
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/images/lol.png")));
		setBackground(Color.WHITE);
		setTitle("Accountant - Pesquisa de Funcion\u00E1rios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 224, 479);
		panel.setBorder(null);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Home.class.getResource("/images/f40d6c7bd68e4a62494605192e357713.jpg")));
		label.setBounds(-220, -13, 598, 816);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("Pesquisar funcion\u00E1rio por nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(234, 11, 220, 14);
		contentPane.add(lblNewLabel);
		
		nomefield = new JTextField();
		nomefield.setBounds(234, 36, 590, 26);
		contentPane.add(nomefield);
		nomefield.setColumns(10);
		
		funcfield = new JTextField();		
		funcfield.setColumns(10);
		funcfield.setBounds(234, 98, 590, 26);
		contentPane.add(funcfield);
		
		
		JLabel lblPesquisarFuncionrioPor = new JLabel("Pesquisar funcion\u00E1rio por fun\u00E7\u00E3o");
		lblPesquisarFuncionrioPor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPesquisarFuncionrioPor.setBounds(234, 73, 199, 14);
		contentPane.add(lblPesquisarFuncionrioPor);
		
		
		Button button = new Button("Pesquisar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection dbConnection = null;		
			   Statement stmt = null;
			
			   if(!nomefield.getText().equals("")) {	 
				   String sql = " SELECT ID,SUBSTR(cpf, 1, 3) || '.' || SUBSTR(cpf, 4, 3) || '.' || SUBSTR(cpf, 7, 3) || '-' ||"
							  +"SUBSTR(cpf, 10) AS CPF,INITCAP(NOME) as NOME,PROF AS CARGO "
							  + ",SALARIO AS SALÁRIO, SUBSTR(TELE,1,2)||'-'|| SUBSTR(TELE,3) AS TELEFONE ,"
							  +"TO_CHAR(DT_CAD,'DD/MM/YYYY') AS ADMISSÃO, TO_CHAR(DT_NASC,'DD/MM/YYYY') AS NASCIMENTO  FROM FUNCIONARIOS  WHERE NOME LIKE '%" +nomefield.getText()+"%' ORDER BY NOME";
				 try{
					   dbConnection = Conexao.getDBConnection();
				      stmt = dbConnection.createStatement();     
				      PreparedStatement pstmt = dbConnection.prepareStatement(sql);
				    
				      ResultSet rs = pstmt.executeQuery(sql);			
					
				      table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch (SQLException e) {
					   throw new RuntimeException(e.getMessage());
				   }
				   
			   }
			 else if (!funcfield.getText().equals("")) {
				 String sql = "SELECT ID,SUBSTR(cpf, 1, 3) || '.' || SUBSTR(cpf, 4, 3) || '.' || SUBSTR(cpf, 7, 3) || '-' ||"
						  +"SUBSTR(cpf, 10) AS CPF,INITCAP(NOME) as NOME,PROF AS CARGO "
						  + ",SALARIO AS SALÁRIO,SUBSTR(TELE,1,2)||'-'|| SUBSTR(TELE,3) AS TELEFONE ,"
						  +"TO_CHAR(DT_CAD,'DD/MM/YYYY') AS ADMISSÃO, TO_CHAR(DT_NASC,'DD/MM/YYYY') AS NASCIMENTO  FROM FUNCIONARIOS  WHERE PROF LIKE '%"+funcfield.getText()+"%' ORDER BY NOME";
				 try{
					
					   dbConnection = Conexao.getDBConnection();
				      stmt = dbConnection.createStatement();      
				      PreparedStatement pstmt = dbConnection.prepareStatement(sql);				      
				      ResultSet rs = pstmt.executeQuery(sql);				
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch (SQLException e) {
					   throw new RuntimeException(e.getMessage());
				   }
				   
				   
			   }else {
				   try{
					
				   dbConnection = Conexao.getDBConnection();
			      stmt = dbConnection.createStatement();
			  String sql = "SELECT ID,SUBSTR(cpf, 1, 3) || '.' || SUBSTR(cpf, 4, 3) || '.' || SUBSTR(cpf, 7, 3) || '-' ||"
					  +"SUBSTR(cpf, 10) AS CPF,INITCAP(NOME) as NOME,PROF AS CARGO ,SALARIO AS SALÁRIO,SUBSTR(TELE,1,2)||'-'|| SUBSTR(TELE,3) AS TELEFONE ,"
					  +"TO_CHAR(DT_CAD,'DD/MM/YYYY') AS ADMISSÃO, TO_CHAR(DT_NASC,'DD/MM/YYYY') AS NASCIMENTO FROM FUNCIONARIOS ORDER BY NOME ASC";
			      PreparedStatement pstmt = dbConnection.prepareStatement(sql);     
			      ResultSet rs = pstmt.executeQuery(sql);
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				   }catch (SQLException e) {
					   throw new RuntimeException(e.getMessage());
			   }
				   
			}  
			   }
			
			
		});
		   
	
		
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(506, 418, 157, 51);
		contentPane.add(button);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(239, 135, 645, 267);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 645, 267);
		panel_1.add(scrollPane_1);
		
		table = new JTable();
		table.setToolTipText("Clique no ID para ver informa\u00E7\u00F5es detalhadas");
		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        int col = table.columnAtPoint(point);
		        if (mouseEvent.getClickCount() == 2) {     	
		        	Object o = (Object)table.getValueAt(row, col) ;
		        	String id = o.toString();
		        	Dados telinha = new Dados(id);        	
		        	
		        	telinha.setVisible(true);
		        	
		        }  	
		    }
		});
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane_1.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setVisible(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {

			}
		));
		
		Button button_1 = new Button("Cadastrar");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadFunc cad = new CadFunc();
				cad.setVisible(true);
				dispose();
			}
		});
		button_1.setBackground(SystemColor.activeCaption);
		button_1.setBounds(238, 418, 145, 51);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Deletar");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Del delete = new Del();
				delete.setVisible(true);
			}
		});
		button_2.setBackground(SystemColor.activeCaption);
		button_2.setBounds(747, 408, 137, 26);
		contentPane.add(button_2);
		
		Button button_3 = new Button("Atualizar");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				att.setVisible(true);
			}
		});
		button_3.setBackground(SystemColor.activeCaption);
		button_3.setBounds(747, 440, 137, 26);
		contentPane.add(button_3);
	}
}
