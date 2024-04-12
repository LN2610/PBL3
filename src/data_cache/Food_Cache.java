package data_cache;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDTB.connect;

public class Food_Cache {
		public static List<Integer> FID = new ArrayList<>();
		public static List<String>  FName = new ArrayList<>();;
		public static List<Integer>  FPrice = new ArrayList<>();;
		public static List<Integer>  FQuantity = new ArrayList<>();
		public Food_Cache() throws SQLException {	
			connect connector = new connect();
	        Connection conn = connector.connection;
			if( conn != null) {
			
				Statement stmt = conn.createStatement();
	        	String sql = "SELECT * FROM food_category";
	        	ResultSet resultSet = stmt.executeQuery(sql);
	        	while (resultSet.next()) {
	        		FID.add(resultSet.getInt("Food_ID"));
	        		FName.add(resultSet.getString("Name"));
	        		FPrice.add(resultSet.getInt("Price"));
	        		FQuantity.add(resultSet.getInt("Quantity"));
	        	}	
	        resultSet.close();
	        stmt.close();
	        if(conn != null) {
	        	conn.close();
	        }
			}
		}
}
