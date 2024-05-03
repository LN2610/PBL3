package staff;

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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;




public class Bill_Manage extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane, panel;
    private JTable table;
    private DefaultTableModel model;
    private JButton edit, issue, addBtn, btnUpdate;
    public void createPDF(String[] rowData, int SelectedRow, String[] content, String[] name, String[] quantity) {

        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            PDFont font = null;
            try {
                font = PDType0Font.load(document, new File("D:\\PBL\\PBL3\\src\\font\\arial-unicode-ms.ttf"));
            } catch (IOException e) {
            	JOptionPane.showMessageDialog(null, "Not found! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            float fontSize = 12;
            float leading = 1.5f * fontSize;
            float margin = 50;
            float yStart = page.getMediaBox().getHeight() - margin;
            float yPosition = yStart;
            String separator = "--------------------------------------------";
            // Viết dữ liệu hàng đã chọn vào tài liệu PDF
            String[] combine = new String[content.length];
            for(int i = 0; i < content.length; i++) {
            	if (i < rowData.length) {
                    combine[i] = content[i] + ": " + rowData[i];
                } else {
                    combine[i] = content[i] + ":";
                }
            }
            for (String data : combine) {

            	contentStream.beginText();
                contentStream.setFont(font, fontSize);
                contentStream.newLineAtOffset(margin, yPosition);
                contentStream.showText(data);
                contentStream.endText();
                yPosition -= leading;
 
                contentStream.beginText();
                contentStream.setFont(font, fontSize);
                contentStream.newLineAtOffset(margin, yPosition);
                contentStream.showText(separator);
                contentStream.endText();
                yPosition -= leading;
           }
           

            String[] combineFood = new String[name.length];
            for(int i = 0; i < name.length; i++) {
            	combineFood[i] = i + 1 + ".  " + name[i] + " - " + "SL: " + quantity[i];
            }
            for (String data : combineFood) {
                contentStream.beginText();
                contentStream.setFont(font, fontSize);
                contentStream.newLineAtOffset(margin, yPosition);
                contentStream.showText(data);
                contentStream.endText();
                yPosition -= leading;
            }
            // Đóng content stream
            contentStream.close();
            // Lưu tài liệu PDF ra file
            document.save(table.getValueAt(SelectedRow, 0).toString()+".pdf");
            // Đóng tài liệu PDF
            document.close();
            JOptionPane.showMessageDialog(null, "PDF file exported successfully.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error exporting PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public Bill_Manage() {
        setTitle("Hoá đơn");
        setSize(1900,1000);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        model = new DefaultTableModel();
        
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(115, 324, 880, 331);
        contentPane.add(panel);
        panel.setLayout(null);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(44, 168, 1203, 112);
        contentPane.add(scrollPane);
        scrollPane.setEnabled(false);
        scrollPane.setPreferredSize(new Dimension(600, 400)); 
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(996, 338, 112, 218);
        contentPane.add(panel_1);
        panel_1.setBackground(Color.WHITE);
        panel_1.setLayout(null);
        
        addBtn = new JButton("Thêm");
        addBtn.setBounds(16, 28, 90, 29);
        panel_1.add(addBtn);
        
        issue = new JButton("Xuất");
        issue.setBounds(16, 89, 90, 29);
        panel_1.add(issue);
        
        edit = new JButton("Xem");
        edit.setBounds(16, 128, 90, 29);
        panel_1.add(edit);
        
        btnUpdate = new JButton("Cập nhật");
        btnUpdate.setBounds(16, 167, 90, 29);
        panel_1.add(btnUpdate);
        
        JLabel lblNewLabel = new JLabel("Xuất hóa đơn");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(44, 94, 226, 47);
        contentPane.add(lblNewLabel);
        
        btnUpdate.addActionListener(this);
        edit.addActionListener(this);
        issue.addActionListener(this);
        addBtn.addActionListener(this);
        
        updateTable();
    }

    private void updateTable() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/data"; 
            Connection con = DriverManager.getConnection(url, "root", "");
            String sql = "SELECT * FROM bill ";
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
    public void editBill(Object[] rowData, Object billID) {
    	panel.removeAll();
        JTextField[] textFields = new JTextField[5];
        JTextArea textArea = new JTextArea();
        String[] columnNames = {"Bill_ID", "Time", "Total", "Table_ID", "Emp_ID", "List"};
        for (int i = 0; i < columnNames.length; i++) {
            JLabel label = new JLabel(columnNames[i] + ":");
            label.setBounds(10, 10 + 25 * i, 100, 20);
            panel.add(label);
            if(i == columnNames.length - 1) {
            	try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "");
                    String query =
                    		"SELECT fdc.Name, od.Quantity "
                    		+ "FROM food_drink AS fdc "
                    		+ "JOIN order_details AS od ON fdc.id = od.item_ID "
                    		+ "JOIN bill AS b ON od.bill_ID = b.bill_ID "
                    		+ "WHERE b.bill_ID = ?";
                    PreparedStatement pstmt = con.prepareStatement(query);
                    pstmt.setString(1, billID.toString());
           
                    ResultSet rs = pstmt.executeQuery();
                    StringBuilder result = new StringBuilder();
                    while (rs.next()) {
                        result.append(rs.getString("Name")).append(" ");
                        result.append(rs.getString("Quantity")).append("\n");
                    }
                    textArea.setText(result.toString());
                    rs.close();
                    pstmt.close();
                    con.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            	textArea.setBounds(120,10 + 25*i, 200, 50);
            	textArea.setBackground(Color.white);
            	panel.add(textArea);
            } else {
            	textFields[i] = new JTextField();
            	textFields[i].setBounds(120, 10 + 25 * i, 200, 20);
            	if(i < rowData.length) {
            		textFields[i].setText(rowData[i].toString());
            }
            panel.add(textFields[i]);
            }
        }
//        btnUpdate.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "");
//                    String sql = "UPDATE bill SET Time=?, Total=?, Status=?, Phone=?, Table_ID=?, Emp_ID=? WHERE Bill_ID=?";
//                    PreparedStatement pstmt = con.prepareStatement(sql);
//                    for (int i = 1; i < columnNames.length; i++) { 
//                        pstmt.setString(i, textFields[i].getText());
//                    }
//                    pstmt.setString(textFields.length, textFields[0].getText());
//                    int rowsAffected = pstmt.executeUpdate();
//                    if (rowsAffected > 0) {
//                        JOptionPane.showMessageDialog(null, "Data updated successfully.");
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Data update failed.");
//                    }
//                    pstmt.close();
//                    con.close();
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//                }
//            }
//        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "");
                    String sqlBill = "UPDATE bill SET Time=?, Total=?, Table_ID=?, Emp_ID=? WHERE Bill_ID=?";
                    String sqlFoodDrink = "UPDATE food_drink SET Quantity=? WHERE Name=?";
                    PreparedStatement pstmtBill = con.prepareStatement(sqlBill);
                    for (int i = 1; i < columnNames.length; i++) { 
                        pstmtBill.setString(i, textFields[i].getText());
                    }
                    pstmtBill.setString(columnNames.length, textFields[0].getText());
                    int rowsAffectedBill = pstmtBill.executeUpdate();
                    pstmtBill.close();
                    PreparedStatement pstmtFoodDrink = con.prepareStatement(sqlFoodDrink);
                    pstmtFoodDrink.setString(1, textFields[8].getText()); // Quantity
                    pstmtFoodDrink.setString(2, textFields[7].getText()); // Name
                    int rowsAffectedFoodDrink = pstmtFoodDrink.executeUpdate();
                    pstmtFoodDrink.close();
                    if (rowsAffectedBill > 0 && rowsAffectedFoodDrink > 0) {
                        JOptionPane.showMessageDialog(null, "Data updated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Data update failed.");
                    }
                    con.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        contentPane.revalidate();
        contentPane.repaint();
    }
    public int getCurrentBillID() {
        int currentBillID = 0;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "");
            String sql = "SELECT MAX(bill_ID) FROM bill";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                currentBillID = rs.getInt(1);
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return currentBillID;
    }

    
    public void addBill() {
    	int currentBillID = getCurrentBillID();
    	currentBillID++;
    	LocalDateTime currentDateTime = LocalDateTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
    	panel.removeAll();
        JTextField[] textFields = new JTextField[5];
        String[] columnNames = {"Bill_ID", "Time", "Total", "Table_ID", "Emp_ID"};
        for (int i = 0; i < columnNames.length; i++) {
            JLabel label = new JLabel(columnNames[i] + ":");
            label.setBounds(10, 10 + 25 * i, 100, 20);
            panel.add(label);
            textFields[i] = new JTextField();
            textFields[i].setBounds(120, 10 + 25 * i, 200, 20);
            panel.add(textFields[i]);
            if (i == 0) {
            	textFields[i].setText(String.valueOf(currentBillID));
            	textFields[i].setEditable(false); 
            }
            if(i == 1) {
            	textFields[i].setText(formattedDateTime);
            	textFields[i].setEditable(false);
            }
        panel.add(textFields[i]);
        }
        JButton btnAddBill = new JButton("Thêm");
        JButton btnCancel = new JButton("Huỷ");
        btnAddBill.setBounds(10, 10 + 25 * columnNames.length, 100, 20);
        btnAddBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String[] values = new String[5];
                    for (int i = 0; i < textFields.length; i++) {
                        values[i] = textFields[i].getText();
                    }
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "");
                    String sql = "INSERT INTO bill (Bill_ID, Time, Total,Table_ID, Emp_ID) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = con.prepareStatement(sql);
                    for (int i = 0; i < values.length; i++) {
                        pstmt.setString(i + 1, values[i]);
                    }
                    int rowsAffected = pstmt.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "New bill added successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add new bill.");
                    }
                    pstmt.close();
                    con.close();
                    updateTable(); 
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnCancel.setBounds(120, 10 + 25 * (columnNames.length), 100, 20);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
        panel.add(btnAddBill);
        panel.add(btnCancel);
        panel.revalidate();
        panel.repaint();
        
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
                Object billID = rowData[0];
                Component[] components = contentPane.getComponents();
                for (Component component : components) {
                    if (component instanceof JTextField) {
                        contentPane.remove(component);
                    }
                }
                editBill(rowData, billID);
			
        }
		}  
	        if (e.getSource() == issue) {
	        	
	        	int selectedRow = table.getSelectedRow();
	            if (selectedRow != -1) {
	                String[] rowData = new String[table.getColumnCount()];
	                String[] content = {"Mã bill", "Thời gian", "Thành tiền", "Bàn", "Mã NV"};
	                for (int i = 0; i < table.getColumnCount(); i++) {
	                    rowData[i] = table.getValueAt(selectedRow, i).toString();
	                }
	                Object billID = table.getValueAt(selectedRow, 0);
	                String[] name = null;
	                String[] quantity = null;
	                try {
	                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "");
	                    String query = "SELECT fdc.Name, od.Quantity "
	                                 + "FROM food_drink AS fdc "
	                                 + "JOIN order_details AS od ON fdc.id = od.item_ID "
	                                 + "JOIN bill AS b ON od.bill_ID = b.bill_ID "
	                                 + "WHERE b.bill_ID = ?";
	                    PreparedStatement pstmt = con.prepareStatement(query);
	                    pstmt.setString(1, billID.toString());
	                    ResultSet rs = pstmt.executeQuery();
	                    // Đếm số lượng hàng trong ResultSet
	                    rs.last(); // Di chuyển tới hàng cuối cùng
	                    int numRows = rs.getRow(); // Lấy chỉ số hàng hiện tại
	                    rs.beforeFirst(); // Di chuyển về hàng đầu tiên
	                    // Khởi tạo mảng với số phần tử là số hàng trong ResultSet
	                    name = new String[numRows];
	                    quantity = new String[numRows];
	                    int index = 0;
	                    while (rs.next()) {
	                        name[index] = rs.getString("Name");
	                        quantity[index] = rs.getString("Quantity");
	                        index++;
	                    }
	                    rs.close();
	                    pstmt.close();
	                    con.close();
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	                }
	                createPDF(rowData, selectedRow, content, name, quantity);
	            } else {
	                JOptionPane.showMessageDialog(null, "Please select a row to export.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	        if(e.getSource() == addBtn) {
	        	addBill();
	        }
	    }
  	}
