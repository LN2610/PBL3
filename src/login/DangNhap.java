package login;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;


public class DangNhap extends JFrame implements ActionListener {
	private boolean isAdmin;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public DangNhap(boolean isAdmin) {
        setTitle("Đăng Nhập");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300); // Increase width to accommodate the image
        setLayout(new GridBagLayout());
        
        // Initialize components
        this.isAdmin = isAdmin;
        JLabel usernameLabel = new JLabel("Tên đăng nhập: ");
        JLabel passwordLabel = new JLabel("Mật khẩu: ");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Đăng Nhập");

        // Add components to the frame
        GridBagConstraints gbcImage = new GridBagConstraints();
        gbcImage.gridx = 0;
        gbcImage.gridy = 0;
        gbcImage.gridheight = 3;
        gbcImage.anchor = GridBagConstraints.WEST;
        add(createImagePanel(), gbcImage);

        // Add username components
        GridBagConstraints gbcUsernameLabel = new GridBagConstraints();
        gbcUsernameLabel.gridx = 1;
        gbcUsernameLabel.gridy = 0;
        gbcUsernameLabel.anchor = GridBagConstraints.EAST;
        //gbcUsernameLabel.insets = new Insets(0, 10, 0, 0); // Padding for left side
        add(usernameLabel, gbcUsernameLabel);

        GridBagConstraints gbcUsernameField = new GridBagConstraints();
        gbcUsernameField.gridx = 2;
        gbcUsernameField.gridy = 0;
        gbcUsernameField.fill = GridBagConstraints.HORIZONTAL;
        gbcUsernameField.weightx = 1; // Make the text field expand horizontally
        //gbcUsernameField.insets = new Insets(0, 0, 0, 10); // Padding for right side
        add(usernameField, gbcUsernameField);

        // Add password components
        GridBagConstraints gbcPasswordLabel = new GridBagConstraints();
        gbcPasswordLabel.gridx = 1;
        gbcPasswordLabel.gridy = 1;
        gbcPasswordLabel.anchor = GridBagConstraints.EAST;
        //gbcPasswordLabel.insets = new Insets(0, 10, 0, 0); // Padding for left side
        add(passwordLabel, gbcPasswordLabel);

        GridBagConstraints gbcPasswordField = new GridBagConstraints();
        gbcPasswordField.gridx = 2;
        gbcPasswordField.gridy = 1;
        gbcPasswordField.fill = GridBagConstraints.HORIZONTAL;
        gbcPasswordField.weightx = 1; // Make the text field expand horizontally
        //gbcPasswordField.insets = new Insets(0, 0, 0, 10); // Padding for right side
        add(passwordField, gbcPasswordField);

        // Add login button
        GridBagConstraints gbcLoginButton = new GridBagConstraints();
        gbcLoginButton.gridx = 2;
        gbcLoginButton.gridy = 2;
        gbcLoginButton.anchor = GridBagConstraints.WEST;
        add(loginButton, gbcLoginButton);

        // Attach action listener to the login button
        loginButton.addActionListener(this);

        // Set location relative to null to center the window on the screen
        setLocationRelativeTo(null);

        setVisible(true);
    }

    private JPanel createImagePanel() {
        // Load the image from package
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/logo.png"));
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);  // transform it back

        // Create a panel to hold the image label
        JPanel imagePanel = new JPanel();
        JLabel imageLabel = new JLabel(imageIcon);
        imagePanel.add(imageLabel);

        return imagePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Perform authentication (dummy example, replace with your authentication logic)
            if (isAdmin) {
                if (username.equals("admin") && password.equals("admin")) {
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công với tư cách Admin!");
                } else {
                    JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không đúng!");
                }
            } else {
                if (username.equals("employee") && password.equals("employee")) {
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công với tư cách Nhân viên!");
                } else {
                    JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không đúng!");
                }
            }
        }
    }

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> new DangNhap(true)); 
    }
}
