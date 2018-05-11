package main;
import java.awt.BorderLayout;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import JDBC.*;
import modelos.Funcionario;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.sun.prism.Image;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

@SuppressWarnings({ "unused", "serial" })
public class CadFunc extends JFrame {
	String b = null;
	Home home = new Home ();
	private JPanel contentPane;
	private JTextField datefield;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadFunc frame = new CadFunc();
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
	public CadFunc() {
		
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/images/lol.png")));
	
		setBackground(Color.WHITE);
		setTitle("Accountant - Cadastro de Funcion\u00E1rios");
		setBounds(100, 100, 700, 670);
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
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(255, 11, 165, 122);
		contentPane.add(panel_1);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setLayout(null);
		
		JLabel label1 = new JLabel("");
		label1.setBounds(10, 11, 145, 100);
		panel_1.add(label1);
				
		JTextField textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		textField.setBounds(448, 113, 223, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	
	
				
		Button button_1 = new Button("Foto");
		button_1.setBounds(506, 37, 116, 45);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(null)) {			
					File a = chooser.getSelectedFile();
					 b = a.getAbsolutePath();
					
					ImageIcon icone = new ImageIcon(new ImageIcon (b).getImage().getScaledInstance(label1.getWidth(), label1.getHeight(),java.awt.Image.SCALE_SMOOTH));
					label1.setIcon(icone);
					textField.setText(b);
						}
			
						
					}
				});
				button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				button_1.setBackground(SystemColor.activeCaption);
		
		JPanel panel = new JPanel();	
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 245, 636);
		panel.setBorder(null);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Home.class.getResource("/images/f40d6c7bd68e4a62494605192e357713.jpg")));
		label.setBounds(-205, -11, 450, 816);
		panel.add(label);
		
		
		JTextField txtInsiraONome = new JTextField();
		txtInsiraONome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtInsiraONome.setText("");
			}
		});
		txtInsiraONome.setHorizontalAlignment(SwingConstants.CENTER);
		txtInsiraONome.setText("Insira o nome do funcion\u00E1rio");
		txtInsiraONome.setBounds(255, 169, 416, 29);
		contentPane.add(txtInsiraONome);
		txtInsiraONome.setColumns(10);
		
		JTextField txtInsiraOCpf = new JTextField();
		txtInsiraOCpf.setToolTipText("Insira apenas n\u00FAmeros.");
		txtInsiraOCpf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInsiraOCpf.setText("");
			}
		});
		txtInsiraOCpf.setHorizontalAlignment(SwingConstants.CENTER);
		txtInsiraOCpf.setText("Insira o CPF");
		txtInsiraOCpf.setColumns(10);
		txtInsiraOCpf.setBounds(255, 234, 416, 29);
		contentPane.add(txtInsiraOCpf);
		
		JTextField txtInsiraOTelefone = new JTextField();
		txtInsiraOTelefone.setToolTipText("Insira apenas n\u00FAmeros.");
		txtInsiraOTelefone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInsiraOTelefone.setText("");
			}
		});
		txtInsiraOTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		txtInsiraOTelefone.setText("Insira o telefone");
		txtInsiraOTelefone.setColumns(10);
		txtInsiraOTelefone.setBounds(255, 301, 416, 29);
		contentPane.add(txtInsiraOTelefone);
		JTextField txtfuncao = new JTextField();
		txtfuncao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtfuncao.setText("");
			}
		});
		txtfuncao.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtfuncao.setText("Insira a fun\u00E7\u00E3o do funcion\u00E1rio");
		txtfuncao.setBounds(255, 432, 416, 29);
		contentPane.add(txtfuncao);
		txtfuncao.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CARGO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(255, 409, 90, 14);
		contentPane.add(lblNewLabel);
	

	
		
		JTextField txtInsiraOEmail = new JTextField();
		txtInsiraOEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInsiraOEmail.setText("");
			}
		});
		txtInsiraOEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtInsiraOEmail.setText("Insira o email");
		txtInsiraOEmail.setColumns(10);
		txtInsiraOEmail.setBounds(255, 369, 416, 29);
		contentPane.add(txtInsiraOEmail);
		
		JTextField txtSalario = new JTextField();
		txtSalario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtSalario.setText("");
				
			}
		});
		txtSalario.setHorizontalAlignment(SwingConstants.CENTER);
		txtSalario.setText("99999.99");
		txtSalario.setColumns(10);
		txtSalario.setBounds(255, 497, 179, 29);
		contentPane.add(txtSalario);
		
		JLabel lblNomeDoFuncionrio = new JLabel("NOME DO FUNCION\u00C1RIO");
		lblNomeDoFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDoFuncionrio.setBounds(255, 144, 179, 14);
		contentPane.add(lblNomeDoFuncionrio);
		
		JLabel lblEmail = new JLabel("CPF");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(255, 209, 179, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(255, 276, 179, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblSalrio = new JLabel("EMAIL");
		lblSalrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalrio.setBounds(255, 344, 179, 14);
		contentPane.add(lblSalrio);
		
		JLabel lblInsiraOSalrio = new JLabel("SAL\u00C1RIO");
		lblInsiraOSalrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInsiraOSalrio.setBounds(255, 472, 179, 14);
		contentPane.add(lblInsiraOSalrio);
		
		JLabel lblDataDeNascimento = new JLabel("DATA DE NASCIMENTO");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataDeNascimento.setBounds(482, 472, 179, 14);
		contentPane.add(lblDataDeNascimento);
		
		JTextField datefield = new JTextField();
		datefield.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			datefield.setText("");
			}
		});
		datefield.setText("30/11/1900");
		datefield.setHorizontalAlignment(SwingConstants.CENTER);
		datefield.setColumns(10);
		datefield.setBounds(482, 497, 179, 29);
		contentPane.add(datefield);
		
		
		Button button = new Button("Cadastrar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {						
				if(txtInsiraOCpf.getText().isEmpty() || txtInsiraONome.getText().isEmpty() ||
						txtInsiraOEmail.getText().isEmpty() ||txtfuncao.getText().isEmpty()|| txtInsiraOTelefone.getText().isEmpty() 
						||txtSalario.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(null, "Existe um ou mais campos vazios,preencha-os.");
				}
				else if(txtInsiraOCpf.getText().length() >11 ||txtInsiraOTelefone.getText().length() >11){
					JOptionPane.showMessageDialog(null, "Os campos do CPF ou Telefone contêm dados excedentes.");
				
				}else if(txtInsiraOCpf.getText().length() <11 ||txtInsiraOTelefone.getText().length() <10){
					JOptionPane.showMessageDialog(null, "Os campos do CPF ou Telefone não contem dados suficientes para o cadastro.");
				
				}
				else {	
				
				File a = chooser.getSelectedFile();	
				String b = a.getAbsolutePath();
				Funcionario fun = new Funcionario();
				
				File imagem = new File(b);
					
					try {						
						Path filePath = Paths.get(b);	
						byte[] foto = Files.readAllBytes(filePath);
						fun.setData(datefield.getText());
						fun.setCpf(txtInsiraOCpf.getText());
						fun.setNome(txtInsiraONome.getText());
						fun.setEmail(txtInsiraOEmail.getText());
						fun.setProf(txtfuncao.getText());
						fun.setTele(txtInsiraOTelefone.getText());
						fun.setSal(Double.parseDouble(txtSalario.getText()));
						
					try {
					JDBCInsert.insert(fun);				
					} 
				
					catch (SQLException e) {
					
					e.printStackTrace();
				}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int cont = JOptionPane.showConfirmDialog(null,"Deseja continuar a criar novos cadastros? ");
				    
				if(cont== JOptionPane.YES_OPTION){
					txtInsiraOCpf.setText("");
					txtInsiraONome.setText("");
					txtInsiraOEmail.setText("");
					txtfuncao.setText("");
					txtInsiraOTelefone.setText("");
					txtSalario.setText("");
				}
				else if (cont == JOptionPane.NO_OPTION) {
				    	FuncTable func = new FuncTable();
				    	func.setVisible(true);
				    	dispose();
				    }
				}
				
			}

			
		});
	
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(358, 566, 165, 45);
		contentPane.add(button);
		
		Button button_2 = new Button("Cancelar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FuncTable fun = new FuncTable();
		    	fun.setVisible(true);
		    	dispose();
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_2.setBackground(SystemColor.activeCaption);
		button_2.setBounds(604, 566, 67, 45);
		contentPane.add(button_2);
		
		
		
				
				
	
	
	}
}
