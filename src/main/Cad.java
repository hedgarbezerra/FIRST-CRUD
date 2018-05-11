package main;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
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
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import JDBC.JDBCInsertC;
import modelos.Chefe;

import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "unused", "serial" })
public class Cad extends JFrame {
	
	private JPanel contentPane;
	private JTextField userfield;

	public Cad() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/images/lol.png")));
		setResizable(false);
		setBackground(Color.WHITE);
		setTitle("Accountant - Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 507);
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
		
		
		userfield = new JTextField();
		userfield.setText("Insira seu usu\u00E1rio");
		userfield.setHorizontalAlignment(SwingConstants.CENTER);
		userfield.setColumns(10);
		userfield.setBounds(280, 33, 325, 37);
		contentPane.add(userfield);
		userfield.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				userfield.setText("");
			}	
		});
	
		JLabel lblLogin = new JLabel("Usu\u00E1rio");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogin.setBounds(280, 0, 46, 21);
		contentPane.add(lblLogin);
		
		JTextField emailfield = new JTextField();
		emailfield.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				emailfield.setText("");
			}
		});
		emailfield.setHorizontalAlignment(SwingConstants.CENTER);
		emailfield.setText("Insira seu email");
		emailfield.setColumns(10);
		emailfield.setBounds(280, 193, 325, 37);
		contentPane.add(emailfield);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(280, 161, 46, 21);
		contentPane.add(lblEmail);
		
		JLabel lblInsiraSuaSenha = new JLabel("Insira sua senha");
		lblInsiraSuaSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInsiraSuaSenha.setBounds(281, 241, 149, 21);
		contentPane.add(lblInsiraSuaSenha);
		
		JLabel lblConfirmeASenha = new JLabel("Confirme a senha");
		lblConfirmeASenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmeASenha.setBounds(280, 321, 222, 21);
		contentPane.add(lblConfirmeASenha);
		
		JTextField nomefield = new JTextField();
		nomefield.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				nomefield.setText("");
			}
		});
		nomefield.setHorizontalAlignment(SwingConstants.CENTER);
		nomefield.setText("Insira seu nome");
		nomefield.setColumns(10);
		nomefield.setBounds(280, 113, 325, 37);
		contentPane.add(nomefield);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(280, 81, 58, 21);
		contentPane.add(lblNome);
		
		JPasswordField pass1 = new JPasswordField();
		pass1.setToolTipText("Senha deve conter letras e n\u00FAmeros");
		pass1.setDropMode(DropMode.INSERT);
		pass1.setBounds(280, 273, 325, 37);
		contentPane.add(pass1);
		
		JPasswordField pass2 = new JPasswordField();
		pass2.setDropMode(DropMode.INSERT);
		pass2.setBounds(280, 357, 325, 37);
		contentPane.add(pass2);
		
		Button button = new Button("Cadastrar");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if(userfield.getText().equals("")||nomefield.getText().equals("") ||emailfield.getText().equals("")|| pass1.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Existem campos vazios, preencha-os.");
					
				}else {
					Chefe chefe = new Chefe();
					if(pass1.getText().equals(pass2.getText())) {
						
						chefe.setUsuario(userfield.getText());
						chefe.setNome(nomefield.getText());
					chefe.setEmail(emailfield.getText());
						chefe.setSenha(pass1.getText());
						try {
							JDBCInsertC.insert(chefe);
						}
						catch (SQLException e) {
							e.printStackTrace();
						}	
					}else {
					JOptionPane.showMessageDialog(null,"As senhas não correspondem.");
				}
					dispose();
					Home inicio = new Home();
					inicio.setVisible(true);
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));

		button.setBackground(SystemColor.activeCaption);
		button.setBounds(381, 424, 170, 45);
		contentPane.add(button);
		
		
		
	}
}
