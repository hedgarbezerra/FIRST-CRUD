package main;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import JDBC.Conexao;
import JDBC.JDBCLogin;
import modelos.Chefe;
import modelos.Funcionario;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Scanner;
import javax.swing.Timer;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings({ "serial", "unused" })
public class Home extends JFrame {
	File buffer = new File ("C:\\save.txt");
	Connection dbConnection = null;
	Statement statement = null;
	FuncTable func = new FuncTable();
	Cad cad = new Cad();
	Chefe chefe= new Chefe();
	private JPanel contentPane;
	private JTextField txtInsiraSeuUsurio;
	private JPasswordField passwordField;
	String txt;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					
					Home frame = new Home();
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	/**
	 * Create the frame.
	 * @param <OraclePreparedStatement>
	 */
	public  Home() {
		
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/images/lol.png")));
		setAutoRequestFocus(true);
		setResizable(true);
		setBackground(Color.WHITE);
		setTitle("Accountant - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 475);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 245, 479);
		panel.setBorder(null);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Home.class.getResource("/images/f40d6c7bd68e4a62494605192e357713.jpg")));
		label.setBounds(-220, -13, 598, 816);
		panel.add(label);
		Button button1 = new Button("Login");
		button1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				String sql = "select * from CHEFE where usuario = '"+txtInsiraSeuUsurio.getText()+"' AND senha = '"+passwordField.getText()+"'";
				
				if(txtInsiraSeuUsurio.getText().equals("") && passwordField.getText().equals("") ) {
					
					txt ="O campo do usuário e da senha não foram preenchidos! ";
					Msg msg = new Msg();
					msg.Mensa(txt);
				}
				else if (passwordField.getText().equals("")) {
					
					txt ="O campo da senha não foi preenchido! ";
					Msg msg = new Msg();
					msg.Mensa(txt);
				}
				else if (txtInsiraSeuUsurio.getText().equals("")) {
					txt = "O campo do usuário não foi preenchido! ";
					Msg msg = new Msg();
					msg.Mensa(txt);
					txt = "O campo do usuário não foi preenchido! ";
				}
				else {
					chefe.setUsuario(txtInsiraSeuUsurio.getText());
					chefe.setSenha(passwordField.getText());
					try {
						
						JDBCLogin.Login(chefe);
				
						if(JDBCLogin.isConfirm() == true) {
						func.setVisible(true);
						dispose();
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		button1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
		button1.setBackground(SystemColor.activeCaption);
		button1.setBounds(354, 297, 195, 44);
		contentPane.add(button1);
		
		
		Button button = new Button("Cadastrar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {		
			cad.setVisible(true);		
			}
		});
		
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(354, 367, 195, 44);
		contentPane.add(button);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsurio.setBounds(255, 55, 46, 14);
		contentPane.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(255, 139, 46, 14);
		contentPane.add(lblSenha);
		
		JRadioButton rdbtnSalvarUsurio = new JRadioButton("Lembrar de mim?");
		rdbtnSalvarUsurio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 if(rdbtnSalvarUsurio.isSelected()){
	                  Salvarsenha(); 
	                  
	               }		
			}
		});
		
		rdbtnSalvarUsurio.setActionCommand("salvar");
		rdbtnSalvarUsurio.setBackground(Color.WHITE);
		rdbtnSalvarUsurio.setBounds(517, 204, 130, 23);
		contentPane.add(rdbtnSalvarUsurio);
		
		txtInsiraSeuUsurio = new JTextField();
		txtInsiraSeuUsurio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtInsiraSeuUsurio.setText("");
			}
		});
	
		txtInsiraSeuUsurio.setHorizontalAlignment(SwingConstants.CENTER);
		txtInsiraSeuUsurio.setText("Insira seu usu\u00E1rio");
		txtInsiraSeuUsurio.setBounds(255, 80, 392, 33);
		contentPane.add(txtInsiraSeuUsurio);
		txtInsiraSeuUsurio.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordField.setText("");	
			}
		});
		passwordField.setBounds(255, 164, 392, 33);
		contentPane.add(passwordField);
		Up();

	}
	
	 public void Salvarsenha(){      
	        try {
	            if(!buffer.exists()) buffer.createNewFile();  
	            BufferedWriter bw = new BufferedWriter(new FileWriter(buffer.getAbsolutePath()));
	            bw.write(txtInsiraSeuUsurio.getText()); 
	            bw.newLine(); 
	            bw.write(passwordField.getPassword()); 
	            bw.close(); 

	        } catch (IOException e) { e.printStackTrace(); }        

	 }
	
	  public  void Up(){

	        try {
	          if(buffer.exists()){   

	            Scanner scan = new Scanner(buffer);  

	            txtInsiraSeuUsurio.setText(scan.nextLine());  
	            passwordField.setText(scan.nextLine()); 
	            scan.close();
	          }

	        } catch (FileNotFoundException e) {         
	            e.printStackTrace();
	        }                

	   }
}
