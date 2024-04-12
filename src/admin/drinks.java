package admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import data_cache.Food_Cache;
import data_cache.Drink_Cache;
public class drinks extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public drinks() throws SQLException {
		setBounds(0, 0, 666, 621);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbl1 = new JLabel("THỨC UỐNG");
		lbl1.setBackground(Color.LIGHT_GRAY);
		lbl1.setFont(new Font("Times New Roman", Font.BOLD, 60));
		lbl1.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl1);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		
		JButton btnThem = new JButton("Thêm món");
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(btnThem);
		
		JButton btnSua = new JButton("Sửa món");
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa món");
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(btnXoa);
		
		new Drink_Cache();
		Object[][] data = new Object[Drink_Cache.Drink_ID.size()][4];
		for (int i = 0; i < Drink_Cache.Drink_ID.size(); i++) {
		    data[i][0] = Drink_Cache.Drink_ID.get(i); 
		    data[i][1] = Drink_Cache.Drink_Name.get(i); 
		    data[i][2] = Drink_Cache.Drink_Price.get(i); 
		    data[i][3] = Drink_Cache.Drink_Quantity.get(i);
		}

        String[] columnNames = {"ID", "Tên món", "Giá (VND)","Số lượng sẵn"};
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(600, 400));
        JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}

}
