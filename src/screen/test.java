package screen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class test {

	private JFrame frame;
	private JTextField txtMail;
	private JTextField txtMailNghialonggmailcom;
	private JTextField txtHotline;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
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
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new LineBorder(new Color(153, 153, 153), 7));
		panel.setBounds(0, 0, 534, 60);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("RESTAURANT MANAGEMENT ");
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(204, 204, 204));
		lblNewLabel.setFont(new Font("Algerian", Font.ITALIC, 35));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\jv_project\\PBL3\\src\\image\\logo250.png"));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setForeground(new Color(204, 204, 204));
		lblNewLabel_1.setBounds(534, 0, 250, 250);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 7, true));
		panel_1.setBounds(534, 249, 250, 212);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtMail = new JTextField();
		txtMail.setHorizontalAlignment(SwingConstants.CENTER);
		txtMail.setEditable(false);
		txtMail.setForeground(new Color(204, 204, 204));
		txtMail.setBackground(new Color(0, 0, 0));
		txtMail.setBounds(63, 13, 127, 32);
		panel_1.add(txtMail);
		txtMail.setFont(new Font("Arial", Font.BOLD, 22));
		txtMail.setText("Contact Us");
		
		txtMailNghialonggmailcom = new JTextField();
		txtMailNghialonggmailcom.setEditable(false);
		txtMailNghialonggmailcom.setForeground(new Color(255, 255, 255));
		txtMailNghialonggmailcom.setBackground(new Color(0, 0, 0));
		txtMailNghialonggmailcom.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMailNghialonggmailcom.setText("Mail: nghialong2610@gmail.com");
		txtMailNghialonggmailcom.setBounds(13, 56, 225, 22);
		panel_1.add(txtMailNghialonggmailcom);
		txtMailNghialonggmailcom.setColumns(10);
		
		txtHotline = new JTextField();
		txtHotline.setBounds(13, 89, 225, 22);
		panel_1.add(txtHotline);
		txtHotline.setText("Hotline: 0346099200");
		txtHotline.setForeground(Color.WHITE);
		txtHotline.setFont(new Font("Arial", Font.PLAIN, 14));
		txtHotline.setColumns(10);
		txtHotline.setBackground(Color.BLACK);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(8, 0, 230, 200);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("E:\\jv_project\\PBL3\\src\\image\\logo2.png"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBorder(new LineBorder(new Color(153, 153, 153), 10));
		panel_2.setBounds(0, 58, 534, 403);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("LOGIN");
		lblNewLabel_3.setBounds(204, 39, 125, 47);
		lblNewLabel_3.setForeground(new Color(153, 153, 153));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 40));
		panel_2.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(248, 120, 200, 50);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(248, 195, 200, 50);
		panel_2.add(textField_1);
		
		JLabel lblNewLabel_4 = new JLabel("User Name");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setForeground(new Color(204, 204, 204));
		lblNewLabel_4.setBounds(145, 118, 93, 50);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Password");
		lblNewLabel_4_1.setForeground(new Color(204, 204, 204));
		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4_1.setBackground(Color.WHITE);
		lblNewLabel_4_1.setBounds(145, 195, 93, 50);
		panel_2.add(lblNewLabel_4_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(219, 288, 89, 23);
		panel_2.add(btnNewButton);
	}
}
