package admin;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTable;
import data_cache.Food_Cache;

public class food extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public food() throws SQLException {
		setBounds(0, 0, 666, 621);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbl1 = new JLabel("MÓN ĂN");
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
		
		new Food_Cache();
		Object[][] data = new Object[Food_Cache.FID.size()][4];
		for (int i = 0; i < Food_Cache.FID.size(); i++) {
		    data[i][0] = Food_Cache.FID.get(i); 
		    data[i][1] = Food_Cache.FName.get(i); 
		    data[i][2] = Food_Cache.FPrice.get(i); 
		    data[i][3] = Food_Cache.FQuantity.get(i);
		    
		}

        String[] columnNames = {"ID", "Tên món", "Giá (VND)","Số lượng sẵn"};
        JTable table = new JTable(data, columnNames);
        table.getColumnModel().getColumn(0).setPreferredWidth(15);
        table.getColumnModel().getColumn(3).setPreferredWidth(15);
        
        table.setPreferredScrollableViewportSize(new Dimension(600, 400));
        JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);	
	}

}
