package admin;

import java.net.ConnectException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import connectDTB.connect;
import data_cache.Drink_Cache;
import data_cache.Employee_Cache;
import data_cache.Food_Cache;

public class Chuc_Nang {
	private static connect conn = new connect();
	private static Connection connection = (Connection) conn.connection;
	public Chuc_Nang() {
		// TODO Auto-generated constructor stub
	}
	public static void Tim_kiem(String x, int y) throws SQLException {
		
		String sql = "SELECT Name, Price, Status FROM food_drink WHERE Classify = ? AND Name LIKE ?";
	    PreparedStatement prp = (PreparedStatement) connection.prepareStatement(sql);
	    prp.setInt(1, y);
	    prp.setString(2, "%" + x + "%");
		
		ResultSet result = prp.executeQuery();
		
		Object[] rowData = new Object[3];
		if(CTC.tableModel.getRowCount() > 0 ) {
			CTC.tableModel.setRowCount(0);
		}
		while(result.next()) {
			rowData[0] = result.getString("Name");
			rowData[1] = result.getInt("Price");
			rowData[2] = (result.getInt("Status") == 0) ? "Off" : "On";
			
			CTC.tableModel.addRow(rowData);
		}
		prp.close();	
	}
	public static void XoaMon(String tenMon, int id) throws SQLException {
	   
	    int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa món " + tenMon + " không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
	    
	    if (choice == JOptionPane.YES_OPTION) {
   
	            String sql = "DELETE FROM food_drink WHERE ID = ?";
	            PreparedStatement preparedStatement =(PreparedStatement) connection.prepareStatement(sql);
	            preparedStatement.setInt(1, id);
	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                JOptionPane.showMessageDialog(null, "Đã xóa món " + tenMon + " khỏi cơ sở dữ liệu.");
	               
	            } else {
	                JOptionPane.showMessageDialog(null, "Không có món " + tenMon + " trong cơ sở dữ liệu.");
	            }
	       
	        }
	    
	}
	public static void Them_mon(String name, int price, int classify, String status) throws SQLException {
		 String sql = "INSERT INTO food_drink (Name, Price, Classify, Status) VALUES (?, ?, ?, ?)";
		 PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
		 statement.setString(1,name); 
         statement.setInt(2, price); 
         statement.setInt(3, classify); 
         int x = (status.equalsIgnoreCase("On")) ? 1 : 0; 
         statement.setInt(4, x );
         statement.executeUpdate();
         statement.close();
		
	}
	public static void Cap_nhat(int id,String name, int newPrice, String status) throws SQLException {
	    String sql = "UPDATE food_drink SET Name = ?, Price = ?, Status = ? WHERE ID = ?";
	    PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
	    
	    statement.setString(1, name);
	    statement.setInt(2, newPrice);
	    int x = (status.equalsIgnoreCase("On")) ? 1 : 0; 
	    statement.setInt(3, x);
	    statement.setInt(4, id); 
	    
	    statement.executeUpdate();
	    statement.close();
	}

	
}
