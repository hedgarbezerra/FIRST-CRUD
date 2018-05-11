package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import JDBC.Conexao;
import JDBC.JDBCDelete;
import modelos.Funcionario;
import net.proteanit.sql.DbUtils;

import javax.swing.border.CompoundBorder;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.DropMode;
import java.awt.Font;

public class Dados extends JFrame {
	private JPanel contentPane;
	static String id;
	private JTextField cpfield;
	private JTextField nomefield;
	private JTextField emailfield;
	private JTextField admfield;
	private JTextField nascfield;
	private JTextField telfield;
	private JTextField jobfield;
	private JTextField salfield;
	private JTextField idfield;

	public Dados(String id) {
		
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/images/lol.png")));
		setBackground(Color.WHITE);
		setTitle("Accountant - Dados selecionados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 445);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder());
		panel.setBounds(159, 9, 142, 129);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel foto = new JLabel("");
		foto.setBounds(10, 11, 122, 107);
		panel.add(foto);
		
		JLabel lblNewLabel_1 = new JLabel("NOME");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(171, 171, 113, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpf.setBounds(10, 215, 213, 14);
		contentPane.add(lblCpf);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(171, 138, 113, 14);
		contentPane.add(lblId);
		Button button = new Button("Sair");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(363, 360, 96, 37);
		contentPane.add(button);
		
		cpfield = new JTextField();
		cpfield.setHorizontalAlignment(SwingConstants.CENTER);
		cpfield.setBackground(Color.WHITE);
		cpfield.setEditable(false);
		cpfield.setBounds(10, 229, 213, 20);
		contentPane.add(cpfield);
		cpfield.setColumns(10);
		
		nomefield = new JTextField();
		nomefield.setHorizontalAlignment(SwingConstants.CENTER);
		nomefield.setEditable(false);
		nomefield.setColumns(10);
		nomefield.setBackground(Color.WHITE);
		nomefield.setBounds(10, 188, 449, 20);
		contentPane.add(nomefield);
		
		emailfield = new JTextField();
		emailfield.setHorizontalAlignment(SwingConstants.CENTER);
		emailfield.setEditable(false);
		emailfield.setColumns(10);
		emailfield.setBackground(Color.WHITE);
		emailfield.setBounds(246, 229, 213, 20);
		contentPane.add(emailfield);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(246, 215, 213, 14);
		contentPane.add(lblEmail);
		
		admfield = new JTextField();
		admfield.setHorizontalAlignment(SwingConstants.CENTER);
		admfield.setEditable(false);
		admfield.setColumns(10);
		admfield.setBackground(Color.WHITE);
		admfield.setBounds(10, 274, 100, 20);
		contentPane.add(admfield);
		
		JLabel lblAdmisso = new JLabel("ADMISS\u00C3O");
		lblAdmisso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmisso.setBounds(10, 260, 100, 14);
		contentPane.add(lblAdmisso);
		
		nascfield = new JTextField();
		nascfield.setHorizontalAlignment(SwingConstants.CENTER);
		nascfield.setEditable(false);
		nascfield.setColumns(10);
		nascfield.setBackground(Color.WHITE);
		nascfield.setBounds(123, 274, 100, 20);
		contentPane.add(nascfield);
		
		JLabel lblNascimento = new JLabel("NASCIMENTO");
		lblNascimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblNascimento.setBounds(123, 260, 100, 14);
		contentPane.add(lblNascimento);
		
		telfield = new JTextField();
		telfield.setHorizontalAlignment(SwingConstants.CENTER);
		telfield.setEditable(false);
		telfield.setColumns(10);
		telfield.setBackground(Color.WHITE);
		telfield.setBounds(246, 274, 213, 20);
		contentPane.add(telfield);
		
		JLabel lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setBounds(246, 260, 213, 14);
		contentPane.add(lblTelefone);
		
		jobfield = new JTextField();
		jobfield.setHorizontalAlignment(SwingConstants.TRAILING);
		jobfield.setEditable(false);
		jobfield.setColumns(10);
		jobfield.setBackground(Color.WHITE);
		jobfield.setBounds(93, 319, 130, 20);
		contentPane.add(jobfield);
		
		JLabel lblProfisso = new JLabel("CARGO");
		lblProfisso.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfisso.setBounds(87, 305, 136, 14);
		contentPane.add(lblProfisso);
		
		salfield = new JTextField();
		salfield.setHorizontalAlignment(SwingConstants.CENTER);
		salfield.setEditable(false);
		salfield.setColumns(10);
		salfield.setBackground(Color.WHITE);
		salfield.setBounds(246, 319, 130, 20);
		contentPane.add(salfield);
		
		JLabel lblSalrio = new JLabel("SAL\u00C1RIO");
		lblSalrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalrio.setBounds(246, 305, 128, 14);
		contentPane.add(lblSalrio);
		
		idfield = new JTextField();
		idfield.setHorizontalAlignment(SwingConstants.CENTER);
		idfield.setEditable(false);
		idfield.setColumns(10);
		idfield.setBackground(Color.WHITE);
		idfield.setBounds(171, 151, 113, 20);
		contentPane.add(idfield);
		idfield.setText(id);
		
		Button button_1 = new Button("Atualizar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Attdados att = new Attdados();
				att.setVisible(true);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBackground(SystemColor.activeCaption);
		button_1.setBounds(14, 360, 96, 37);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Deletar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a = JOptionPane.showConfirmDialog(null,"Deseja continuar com a exclusão? ");
			    Funcionario fun = new Funcionario();
				if(a == JOptionPane.YES_OPTION){
				fun.setId(idfield.getText());
				try {
					JDBCDelete.delete(fun);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				else if (a == JOptionPane.NO_OPTION) {
				    	
				    }	
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_2.setBackground(SystemColor.activeCaption);
		button_2.setBounds(188, 360, 96, 37);
		contentPane.add(button_2);
		
		Connection dbConnection = null;		
		  Statement stmt = null;
		  File image = new File("C:\\blob.jpeg");
		 try{
			  String sql = "SELECT ID,INITCAP(NOME) AS NOME, SUBSTR(cpf, 1, 3) || '.' || SUBSTR(cpf, 4, 3) || '.' || SUBSTR(cpf, 7, 3) || '-' ||" + 
			  		"SUBSTR(cpf, 10) AS CPF, EMAIL,PROF,SUBSTR(TELE,1,2)||'-'|| SUBSTR(TELE,3) AS TELE,TO_CHAR(DT_CAD,'DD/MM/YYYY')AS DT_CAD"
			  		+ ",SALARIO,TO_CHAR(DT_NASC,'DD/MM/YYYY') AS DT_NASC, FOTO  FROM FUNCIONARIOS WHERE ID = "+id;
			
			   dbConnection = Conexao.getDBConnection();
		      stmt = dbConnection.createStatement();      
		      PreparedStatement pstmt = dbConnection.prepareStatement(sql);	
		      
		      ResultSet rs = pstmt.executeQuery(sql);				
	
		      while(rs.next()) {		    	 
			    	String cpf1 = rs.getString("CPF");
			    	String nome1 = rs.getString("NOME");
			    	String email1 = rs.getString("EMAIL");
			    	String prof1 = rs.getString("PROF");
			    	String tele1 = rs.getString("TELE");
			    	String date = rs.getString("DT_CAD");
			    	String datanasc = rs.getString("DT_NASC");
			    	String sal = rs.getString("SALARIO");	    				    	
			        FileOutputStream output = new FileOutputStream(image);
			        byte[] buffer = new byte[1];
			        InputStream is = rs.getBinaryStream("FOTO");
			        while (is.read(buffer) > 0) {
			        	output.write(buffer);
			        }
			        output.close();
			    	salfield.setText(sal);
			    	jobfield.setText(prof1);
			    	nomefield.setText(nome1);
			    	nascfield.setText(datanasc);
			    	telfield.setText(tele1);
			    	cpfield.setText(cpf1);
			    	emailfield.setText(email1);
			    	admfield.setText(date);
		      }      
		   
		}catch (SQLException e) {
			   throw new RuntimeException(e.getMessage());
		   } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  String b = image.getAbsolutePath();
			ImageIcon icone = new ImageIcon(new ImageIcon (b).getImage().getScaledInstance(foto.getWidth(), foto.getHeight(),java.awt.Image.SCALE_SMOOTH));
			foto.setIcon(icone);
	}
}
