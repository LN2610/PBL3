package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class dangnhap1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangnhap1 window = new dangnhap1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public dangnhap1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\PBL\\PBL3\\bin\\image\\logo.png"));
		lblNewLabel.setBounds(-50, -50, 450, 450);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 70));
		lblNewLabel_1.setBounds(507, 24, 206, 59);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(427, 134, 349, 113);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 2, 20, 20));
		
		JLabel lblNewLabel_3 = new JLabel("    USER NAME");
		lblNewLabel_3.setForeground(new Color(233, 150, 122));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(textField);
		textField.setColumns(15);
		
		JLabel lblNewLabel_2 = new JLabel("    PASSWORD");
		lblNewLabel_2.setForeground(new Color(233, 150, 122));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(textField_1);
		textField_1.setColumns(15);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setForeground(new Color(165, 42, 42));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(507, 276, 206, 59);
		frame.getContentPane().add(btnNewButton);
	}
}
