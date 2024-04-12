package admin;

import javax.swing.*;

import connectDTB.connect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    private static JFrame frame;
    private static JMenuBar menuBar;
    private static JPanel panel;
    
    food faFood; 
    drinks dr; 
    employee ep;
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GUI window = new GUI();
                new connect();
                window.faFood = new food();
                window.dr = new drinks();
                window.ep = new employee();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public  GUI() {
    	 frame = new JFrame();
         frame.setTitle("ADMIN");
         frame.setBounds(0, 0, 700, 700);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         menuBar = new JMenuBar();
         frame.setJMenuBar(menuBar);

         JMenu mnQuanLy = new JMenu("Quản lý");
         menuBar.add(mnQuanLy);

         JMenuItem mntmMonAn = new JMenuItem("Món ăn");
         mnQuanLy.add(mntmMonAn);
         mntmMonAn.addActionListener(this);

         JMenuItem mntmThucUong = new JMenuItem("Thức uống");
         mnQuanLy.add(mntmThucUong);
         mntmThucUong.addActionListener(this);

         JMenuItem mntmNhanVien = new JMenuItem("Nhân viên");
         mnQuanLy.add(mntmNhanVien);
         
         JMenu mnNewMenu = new JMenu("Thống kê");
         menuBar.add(mnNewMenu);
         
         JMenuItem mntmDoanhthu = new JMenuItem("Doanh thu");
         mnNewMenu.add(mntmDoanhthu);
         
         JMenuItem mntmXuatThongKe = new JMenuItem("Xuất thống kê");
         mnNewMenu.add(mntmXuatThongKe);
         
         JMenu mnTuyChon = new JMenu("Tùy chọn");
         menuBar.add(mnTuyChon);
         
         JMenuItem mntmQuayLai = new JMenuItem("Quay lại");
         mnTuyChon.add(mntmQuayLai);
         
         JMenuItem mntmThoat = new JMenuItem("Thoát");
         mnTuyChon.add(mntmThoat);
         mntmThoat.addActionListener(this);
         frame.getContentPane().setLayout(null);
         
        panel = new JPanel();
         panel.setBounds(10, 10, 666, 621);
        
         frame.getContentPane().add(panel);
         mntmNhanVien.addActionListener(this);
    }
    private void add_panel(JPanel panel) {
    	frame.getContentPane().removeAll(); 
   	 	frame.getContentPane().add(panel);
   	 	frame.revalidate(); 
   	 	frame.repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        switch (command) {
            case "Món ăn":
            	 add_panel(faFood);
                break;
            case "Thức uống":
                add_panel(dr);
                break;
            case "Nhân viên":
                add_panel(ep);
                break;
            case "Doanh thu":
                // Xử lý khi người dùng chọn "Doanh thu"
                break;
            case "Xuất thống kê":
                // Xử lý khi người dùng chọn "Xuất thống kê"
                break;
            case "Quay lại":
                // Xử lý khi người dùng chọn "Quay lại"
                break;
            case "Thoát":
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
