package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class Msg extends JFrame {
	JTextArea textArea = new JTextArea();
	private JPanel contentPane;
	int x,y;


	public Msg() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 x = e.getX();
				 y = e.getY();
				
				
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent evt) {
				setLocation (evt.getXOnScreen()-x,evt.getYOnScreen()-y);
			}
		});
		setUndecorated(true);	
		setLocationRelativeTo(this);
		
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 371, 129);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel.setBackground(new Color(95, 158, 160));
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				panel.setBackground(new Color(0, 128, 128));
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		panel.setLayout(null);
		panel.setForeground(SystemColor.textHighlight);
		panel.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(131, 87, 110, 31);
		contentPane.add(panel);
		
		JLabel lblConfirmar = new JLabel("Confirmar");
		lblConfirmar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmar.setForeground(Color.WHITE);
		lblConfirmar.setFont(new Font("Roboto", Font.BOLD, 12));
		lblConfirmar.setBounds(10, 0, 90, 31);
		panel.add(lblConfirmar);
		
		JLabel lblNewLabel = new JLabel("New label");

		lblNewLabel.setBounds(299, 87, 61, 31);
		contentPane.add(lblNewLabel);
		ImageIcon icone = new ImageIcon(new ImageIcon ("C:\\Users\\Hed\\Desktop\\1.png").getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),java.awt.Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(icone);
		
		
		textArea.setBorder(new LineBorder(new Color(51, 153, 255), 1, true));
		textArea.setBackground(Color.WHITE);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setForeground(Color.DARK_GRAY);
		textArea.setFont(new Font("Roboto", Font.PLAIN, 13));
		textArea.setEditable(false);
		textArea.setBounds(10, 11, 350, 65);
		contentPane.add(textArea);
		
	}
	public void Mensa(String txt) {
		try {
			 Msg msg = new Msg();
			 msg.textArea.setText(txt);
			msg.setVisible(true);
			msg.setLocationRelativeTo(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
