package login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhanQuyen extends JFrame implements ActionListener {

    private JButton adminButton;
    private JButton employeeButton;
    private JButton exit;
    private DangNhap dangNhapWindow; 
    private boolean isAdmin;

    public PhanQuyen() {
        setTitle("Chọn Vai Trò");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new FlowLayout());
        
        adminButton = new JButton("Admin");
        employeeButton = new JButton("Nhân Viên");
        exit = new JButton ("Thoát");

        add(adminButton);
        add(employeeButton);
        add(exit);
        
       
        adminButton.addActionListener(this);
        employeeButton.addActionListener(this);
        exit.addActionListener(this);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminButton) {
            isAdmin = true;
            dangNhapWindow = new DangNhap(isAdmin);
            dispose(); //
        } else if (e.getSource() == employeeButton) {
            isAdmin = false;
            dangNhapWindow = new DangNhap(isAdmin); 
            dispose(); 
        }
        else if (e.getSource() == exit)
        	System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PhanQuyen::new);
    }
}
