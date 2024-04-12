package data_cache;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDTB.connect;

public class Drink_Cache {
    public static List<Integer> Drink_ID = new ArrayList<>();
    public static List<String> Drink_Name = new ArrayList<>();
    public static List<Integer> Drink_Price = new ArrayList<>();
    public static List<Integer> Drink_Quantity = new ArrayList<>();

    public Drink_Cache() throws SQLException {
        connect connector = new connect();
        Connection conn = connector.connection;
        if (conn != null) {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM drink_category";
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                Drink_ID.add(resultSet.getInt("Drink_ID"));
                Drink_Name.add(resultSet.getString("Name"));
                Drink_Price.add(resultSet.getInt("Price"));
                Drink_Quantity.add(resultSet.getInt("Quantity"));
            }
            resultSet.close();
            stmt.close();
            if (conn != null) {
                conn.close();
            }
        }
    }
}
