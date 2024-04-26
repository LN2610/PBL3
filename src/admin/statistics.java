package admin;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;

public class statistics extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public statistics() {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(830, 100, 700, 500);
		panel.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Quản lý thực đơn");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(215, 36, 452, 78);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(50, 222, 419, 53);
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField.setColumns(20);
		panel_1.add(textField);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(50, 285, 419, 53);
		panel.add(panel_1_1);
		panel_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã món");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panel_1_1.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_1.setColumns(20);
		panel_1_1.add(textField_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(50, 348, 419, 53);
		panel.add(panel_1_2);
		panel_1_2.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên món");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panel_1_2.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_2.setColumns(20);
		panel_1_2.add(textField_2);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBounds(50, 411, 419, 53);
		panel.add(panel_1_3);
		panel_1_3.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
		
		JLabel lblNewLabel_1_3 = new JLabel("Giá thành");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panel_1_3.add(lblNewLabel_1_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_3.setColumns(20);
		panel_1_3.add(textField_3);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setBounds(50, 474, 419, 53);
		panel.add(panel_1_4);
		panel_1_4.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
		
		JLabel lblNewLabel_1_4 = new JLabel("Số lượng");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panel_1_4.add(lblNewLabel_1_4);
		
		JSpinner spinner = new JSpinner();
		spinner.setPreferredSize(new Dimension(60, 30));
		spinner.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_1_4.add(spinner);
		
		JLabel lblDanhSchMn = new JLabel("Danh sách món");
		lblDanhSchMn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblDanhSchMn.setBounds(830, 12, 452, 78);
		panel.add(lblDanhSchMn);
		
		JButton btnNewButton = new JButton("Thêm món");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBackground(new Color(124, 252, 0));
		btnNewButton.setBounds(508, 285, 188, 39);
		panel.add(btnNewButton);
		
		JButton btnXaMn = new JButton("Xóa món");
		btnXaMn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnXaMn.setBackground(Color.RED);
		btnXaMn.setBounds(508, 348, 188, 39);
		panel.add(btnXaMn);
		
		JButton btnSaMn = new JButton("Sửa món");
		btnSaMn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnSaMn.setBackground(new Color(255, 215, 0));
		btnSaMn.setBounds(508, 411, 188, 39);
		panel.add(btnSaMn);
		
		JButton btnTmKim = new JButton("Tìm");
		btnTmKim.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnTmKim.setBackground(new Color(245, 255, 250));
		btnTmKim.setBounds(508, 222, 188, 39);
		panel.add(btnTmKim);
		
		JButton btntLi = new JButton("Đặt lại");
		btntLi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btntLi.setBackground(new Color(245, 255, 250));
		btntLi.setBounds(281, 620, 188, 39);
		panel.add(btntLi);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnThot.setBackground(new Color(245, 255, 250));
		btnThot.setBounds(508, 620, 188, 39);
		panel.add(btnThot);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		comboBox.setBounds(346, 124, 166, 39);
		panel.add(comboBox);
		
		JButton btnLu = new JButton("Lưu");
		btnLu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnLu.setBackground(new Color(245, 255, 250));
		btnLu.setBounds(50, 620, 188, 39);
		panel.add(btnLu);

	}

}
