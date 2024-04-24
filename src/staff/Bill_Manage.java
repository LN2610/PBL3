package staff;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
public class Bill_Manage extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private JButton edit, issue;

    public Bill_Manage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 800, 400); 
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table); 
        scrollPane.setEnabled(false);
        scrollPane.setBounds(10, 11, 764, 272); 
        contentPane.add(scrollPane);
        scrollPane.setPreferredSize(new Dimension(600, 400)); 
        
        edit = new JButton("Edit");
        edit.setBounds(207, 310, 117, 29);
        contentPane.add(edit);
        
        issue = new JButton("Issue");
        issue.setBounds(460, 310, 117, 29);
        contentPane.add(issue);
        edit.addActionListener(this);
        issue.addActionListener(this);
        updateTable("", "");
    }

    private void updateTable(String searchBy, String searchText) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/data"; 
            Connection con = DriverManager.getConnection(url, "root", "");

            String sql = "SELECT * FROM Bills ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            model.setRowCount(0); 

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                model.addColumn(metaData.getColumnLabel(columnIndex));
                if (columnIndex == 2) {
                    table.getColumnModel().getColumn(columnIndex - 1).setWidth(400);
                }  

            }


            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
          
                model.addRow(row);
            } 

            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Bill_Manage frame = new Bill_Manage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public class EditWindow extends JFrame {
        private JPanel contentPane;
        private JTextField[] textFields = new JTextField[9];
        private Connection con;
        public EditWindow(Object[] rowData) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error connecting to database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setBounds(100, 100, 450, 300);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(new GridLayout(0, 2, 5, 5));
            String[] columnNames = {"Bill_ID", "Time", "Total", "Status", "Quantity", "Phone", "Table_ID", "Emp_ID", "Order_ID"};
            for (int i = 0; i < columnNames.length; i++) {
                JLabel label = new JLabel(columnNames[i] + ":");
                contentPane.add(label);
                textFields[i] = new JTextField();
                if (i < rowData.length) {
                    textFields[i].setText(rowData[i].toString());
                }
                contentPane.add(textFields[i]);
            }
            JButton btnOk = new JButton("OK");
            btnOk.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String sql = "UPDATE Bills SET Time=?, Total=?, Status=?, Quantity=?, Phone=?, Table_ID=?, Emp_ID=?, Order_ID=? WHERE Bill_ID=?";
                        PreparedStatement pstmt = con.prepareStatement(sql);
                        for (int i = 1; i < textFields.length; i++) {
                            pstmt.setString(i, textFields[i].getText());
                        }
                        pstmt.setString(textFields.length, textFields[0].getText());
                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Data updated successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Data update failed.");
                        }
                        pstmt.close();
                        dispose(); 
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            contentPane.add(btnOk); 
        }
        

        @Override
        public void dispose() {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error closing database connection: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            super.dispose();
        }
    }
 
    public class IssueWindow extends JFrame {
        private JPanel contentPane;
        private Connection con;
        public IssueWindow(Object[] rowData, String[] contents, Connection con, String orderDetail_ID, String foodName, String drinkName) {
            this.con = con;
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setBounds(100, 100, 450, 300);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(new GridLayout(rowData.length, 1, 5, 5));
            // Duyệt thông tin từ rowData và contents để hiển thị thông tin tương ứng
            for (int i = 0; i < rowData.length; i++) {
                String text = "";
                if (contents[i].equals("Food")) {
                    text = foodName;
                } else if (contents[i].equals("Drink")) {
                    text = drinkName;
                } else {
                    text = contents[i] + ": " + rowData[i].toString();
                }
                JLabel label = new JLabel(text + "\n");
                contentPane.add(label);
            }
            JButton btnIssue = new JButton("Issue");
            btnIssue.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Đã xuất bill");
                    dispose();
                }
            });
            contentPane.add(btnIssue);
        }
        // Thêm phương thức dispose để đóng kết nối
        @Override
        public void dispose() {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error closing database connection: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            super.dispose();
        }
    }
  





	@Override
	public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == edit) {
	            int selectedRow = table.getSelectedRow();
	            if (selectedRow != -1) {
	            	Object[] rowData = new Object[model.getColumnCount()];
	                for (int i = 0; i < model.getColumnCount(); i++) {
	                    rowData[i] = model.getValueAt(selectedRow, i);
	                } 
	                EditWindow editWindow = new EditWindow(rowData);
	                editWindow.setVisible(true);
	            } else {
	                JOptionPane.showMessageDialog(this, "Please select a row to edit.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } 
	        if (e.getSource() == issue) {
	            int selectedRow1 = table.getSelectedRow();
	            if (selectedRow1 != -1) {
	                Object[] rowData = new Object[model.getColumnCount()];
	                String[] contents = {"Bill ID", "Time", "Total", "Status", "Quantity", "Phone", "Table", "Employee", "Order"};
	                for (int i = 0; i < model.getColumnCount(); i++) {
	                    rowData[i] = model.getValueAt(selectedRow1, i);
	                }
	                Connection con = null;
	                String orderDetail_ID = rowData[model.getColumnCount() - 1].toString();
	                try {
	                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "");
	                    String query = "SELECT Food_category.Name, Drink_category.Name FROM Order_detail "
	                                 + "JOIN Food_category ON Order_detail.Food_ID = Food_category.Food_ID "
	                                 + "JOIN Drink_category ON Order_detail.Drink_ID = Drink_category.Drink_ID "
	                                 + "WHERE Order_detail.Order_ID = ?";
	                    PreparedStatement pstmt = con.prepareStatement(query);
	                    pstmt.setString(1, orderDetail_ID);
	                    ResultSet rs = pstmt.executeQuery();
	                    if (rs.next()) {
	                        String foodName = rs.getString("Name");
	                        String drinkName = rs.getString("Name");
	                        new IssueWindow(rowData, contents, con, orderDetail_ID, foodName, drinkName).setVisible(true);
	                    }
	                    rs.close();
	                    pstmt.close();
	                } catch (Exception ex) {
	                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	                } finally {
	                    if (con != null) {
	                        try {
	                            con.close();
	                        } catch (SQLException ex) {
	                            ex.printStackTrace();
	                        }
	                    }
	                }
	            } else {
	                JOptionPane.showMessageDialog(this, "Please select a row to issue.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }

	    }
}
