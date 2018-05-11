package main;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import JDBC.JDBCUpdate;
import modelos.Funcionario;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Attdados extends JFrame {
	private JPanel contentPane;
	private JTextField nomefield;
	private JTextField cpfield;
	private JTextField telfield;
	private JTextField profield;
	private JTextField emailfield;
	private JTextField salfield;
	private JTextField idfield;
	private JTextField DTNASC;
	private JTextField textField;

	

	public Attdados() {
		setTitle("Atualizar Dados pelo ID");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Del.class.getResource("/images/lol.png")));
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 269);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
			    "Imagens", ImageIO.getReaderFileSuffixes());
		chooser.addChoosableFileFilter(imageFilter);
		chooser.setAcceptAllFileFilterUsed(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 594, 241);
		contentPane.add(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(null);
		JTextField textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(187, 183, 223, 20);
		panel_1.add(textField);
		

		Button foto = new Button("Foto");
		foto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		foto.setBackground(SystemColor.activeCaption);
		foto.setBounds(251, 143, 96, 34);
		panel_1.add(foto);
		foto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(null)) {			
					File a = chooser.getSelectedFile();
					String b = a.getAbsolutePath();	
					textField.setText(b);
				}
			}
		});
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setBounds(59, 9, 83, 14);
		panel_1.add(lblNome);
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(460, 9, 84, 14);
		panel_1.add(lblCpf);
		lblCpf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setBounds(59, 54, 83, 14);
		panel_1.add(lblTelefone);
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(264, 54, 83, 14);
		panel_1.add(lblEmail);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblProfisso = new JLabel("CARGO");
		lblProfisso.setBounds(465, 54, 79, 14);
		panel_1.add(lblProfisso);
		lblProfisso.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(264, 90, 66, 14);
		lblId.setToolTipText("Insirir ID para identificar o funcion\u00E1rio");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblId);
		
		JLabel lblSalrio = new JLabel("SAL\u00C1RIO");
		lblSalrio.setBounds(264, 9, 83, 14);
		lblSalrio.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblSalrio);
		
		DTNASC = new JTextField();
		DTNASC.setColumns(10);
		DTNASC.setBounds(422, 113, 160, 20);
		panel_1.add(DTNASC);
		
		JLabel NASCIMEN = new JLabel("NASCIMENTO");
		NASCIMEN.setHorizontalAlignment(SwingConstants.CENTER);
		NASCIMEN.setBounds(461, 99, 83, 14);
		panel_1.add(NASCIMEN);
		
		
		Button button_1 = new Button("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		Button button = new Button("Atualizar dados");
		button.setBounds(32, 191, 118, 44);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File a = chooser.getSelectedFile();
				String b = a.getAbsolutePath();
				
				if(emailfield.getText().equals("")|| salfield.getText().equals("") || profield.getText().equals("")
					||	telfield.getText().equals("") ||nomefield.getText().equals("") ||cpfield.getText().equals("")||
					idfield.getText().equals("") || DTNASC.getText().equals("") ) {
					
					JOptionPane.showMessageDialog(null,"Existem campos vazios,insira todos os dados.");			
				
				}else if(cpfield.getText().length() >11 ||telfield.getText().length() >11){
					JOptionPane.showMessageDialog(null, "Os campos do CPF ou Telefone contêm dados excedentes.");
				
				}else {
					Funcionario fun = new Funcionario();
				
					
					fun.setId(idfield.getText());
					fun.setData(DTNASC.getText());
					fun.setCpf(cpfield.getText());
					fun.setNome(nomefield.getText());
					fun.setEmail(emailfield.getText());
					fun.setProf(profield.getText());
					fun.setTele(telfield.getText());
					fun.setSal(Double.parseDouble(salfield.getText()));
					
						try{
							Path filePath = Paths.get(b);	
							byte[] foto = Files.readAllBytes(filePath);
							
						  JDBCUpdate.update(fun);
							
						}catch (SQLException x) {
							   throw new RuntimeException(x.getMessage());
						   } catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dispose();
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBackground(SystemColor.activeCaption);
		panel_1.add(button);
		
		nomefield = new JTextField();
		nomefield.setBounds(20, 23, 160, 20);
		panel_1.add(nomefield);
		nomefield.setColumns(10);
		
		cpfield = new JTextField();
		cpfield.setBounds(422, 23, 160, 20);
		cpfield.setColumns(10);
		panel_1.add(cpfield);
		
		telfield = new JTextField();
		telfield.setBounds(20, 68, 160, 20);
		telfield.setColumns(10);
		panel_1.add(telfield);
		
		profield = new JTextField();
		profield.setBounds(422, 68, 160, 20);
		profield.setColumns(10);
		panel_1.add(profield);
		
		emailfield = new JTextField();
		emailfield.setBounds(220, 68, 160, 20);
		emailfield.setColumns(10);
		panel_1.add(emailfield);
		
		salfield = new JTextField();
		salfield.setBounds(220, 23, 160, 20);
		salfield.setColumns(10);
		panel_1.add(salfield);
		
		idfield = new JTextField();
		idfield.setBounds(274, 103, 52, 20);
		idfield.setColumns(10);
		panel_1.add(idfield);
		
		Button button_2 = new Button("Cancelar");
		button_2.setBounds(451, 191, 118, 44);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_2.setBackground(SystemColor.activeCaption);
		panel_1.add(button_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(451, 143, 131, 34);
		textPane.setText("Caso queira cancelar a opera\u00E7\u00E3o,clique em cancelar.");
		panel_1.add(textPane);
		
		JTextPane txtpnVerifiqueSeEstes = new JTextPane();
		txtpnVerifiqueSeEstes.setBounds(20, 124, 154, 55);
		txtpnVerifiqueSeEstes.setText("Verifique se estes s\u00E3o os dados corretos e referentes ao ID desejado para atualizar.");
		
		panel_1.add(txtpnVerifiqueSeEstes);
		
	
	
		
		
	   
		
	}
}
