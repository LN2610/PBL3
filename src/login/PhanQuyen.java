package login;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhanQuyen extends JFrame implements ActionListener {
	
	private JPanel contentPane;
    private JButton adminButton;
    private JButton employeeButton;
    private JButton exit;
    private dangnhap1 dangNhapWindow; 
    private boolean isAdmin;

    public PhanQuyen() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		adminButton = new JButton("Admin");
		adminButton.setForeground(new Color(128, 0, 0));
		adminButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		adminButton.setBounds(92, 56, 197, 87);
		contentPane.add(adminButton);
		
		employeeButton = new JButton("Employee");
		employeeButton.setForeground(new Color(128, 0, 0));
		employeeButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		employeeButton.setBounds(440, 56, 197, 87);
		contentPane.add(employeeButton);
		
		exit = new JButton("Exit");
		exit.setForeground(new Color(128, 0, 0));
		exit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		exit.setBounds(254, 225, 197, 87);
		contentPane.add(exit);
        
       
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
            dangNhapWindow = new dangnhap1(isAdmin);
            dispose(); //
        } else if (e.getSource() == employeeButton) {
            isAdmin = false;
            dangNhapWindow = new dangnhap1(isAdmin); 
            dispose(); 
        }
        else if (e.getSource() == exit)
        	System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PhanQuyen::new);
    }
}
