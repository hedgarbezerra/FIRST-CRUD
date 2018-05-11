package main;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import java.awt.TextField;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import JDBC.Conexao;
import JDBC.JDBCDelete;
import modelos.Funcionario;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Del extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField idfield;

	
	public Del() {
		
		
		
		setBackground(Color.WHITE);
		setTitle("Remover dados pelo ID");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Del.class.getResource("/images/lol.png")));
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 252);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button button = new Button("Apagar os dados");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						if(idfield.getText().equals("") /*|| idfield.getText().StringUtils.isNumeric()*/) {
					
					
				}else {	
					Funcionario fun = new Funcionario();
					fun.setId(idfield.getText());
						try{
				
				   JDBCDelete.delete(fun);
				
			}catch (SQLException q) {
				   throw new RuntimeException(q.getMessage());
			   }
						dispose();
				}
			}
		});
		button.setBounds(102, 174, 118, 44);
		contentPane.add(button);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBackground(SystemColor.activeCaption);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 562, 60);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				
			}
		));
		scrollPane.setViewportView(table);
		
		JTextPane txtpnSeEssesSo = new JTextPane();
		txtpnSeEssesSo.setText("Se esses s\u00E3o os dados do funcion\u00E1rio que deseja excluir do sistema,clique no bot\u00E3o abaixo.");
		txtpnSeEssesSo.setBounds(46, 134, 261, 34);
		contentPane.add(txtpnSeEssesSo);
		
		JLabel lblIdDoFuncionrio = new JLabel("ID do Funcion\u00E1rio");
		lblIdDoFuncionrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdDoFuncionrio.setBounds(180, 11, 237, 14);
		contentPane.add(lblIdDoFuncionrio);
		
		idfield = new JTextField();
		idfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				Connection dbConnection = null;		
				   Statement stmt = null;
				   String sql = "SELECT ID,SUBSTR(cpf, 1, 3) || '.' || SUBSTR(cpf, 4, 3) || '.' || SUBSTR(cpf, 7, 3) || '-' ||"
							  +"SUBSTR(cpf, 10) AS CPF,INITCAP(NOME) as NOME,PROF AS PROFISSÃO "
							  + ",SALARIO AS SALÁRIO,SUBSTR(TELE,1,2)||'-'|| SUBSTR(TELE,3) AS TELEFONE ,"
							  +"TO_CHAR(DT_CAD,'DD/MM/YYYY') AS ADMISSÃO, TO_CHAR(DT_NASC,'DD/MM/YYYY') AS NASCIMENTO FROM FUNCIONARIOS WHERE Id= '"+idfield.getText()+"'";
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
		});
		idfield.setBounds(250, 32, 86, 20);
		contentPane.add(idfield);
		idfield.setColumns(10);
		
		Button button_1 = new Button("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBackground(SystemColor.activeCaption);
		button_1.setBounds(396, 171, 118, 44);
		contentPane.add(button_1);
		
		JTextPane txtpnCasoQueiraCancelar = new JTextPane();
		txtpnCasoQueiraCancelar.setText("Caso queira cancelar a opera\u00E7\u00E3o,clique em cancelar.");
		txtpnCasoQueiraCancelar.setBounds(381, 134, 191, 34);
		contentPane.add(txtpnCasoQueiraCancelar);
	}
}
