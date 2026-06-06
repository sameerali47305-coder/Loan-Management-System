package loan.ui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class LoginFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LoginFrame frame = new LoginFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LoginFrame() {
        setTitle("Loan Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);

        contentPane = new JPanel();
        contentPane.setLayout(null); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //Title
        JLabel lblTitle = new JLabel("              RBS_LOAN'S");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBounds(70, 20, 260, 30);
        contentPane.add(lblTitle);

        //Username Label
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 80, 80, 25);
        contentPane.add(lblUsername);

        //Username Field
        txtUsername = new JTextField();
        txtUsername.setBounds(110, 80, 190, 25);
        contentPane.add(txtUsername);

        //Password Label
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 120, 80, 25);
        contentPane.add(lblPassword);

        //Password Field
        txtPassword = new JPasswordField();
        txtPassword.setBounds(110, 120, 190, 25);
        contentPane.add(txtPassword);

        //Login Button
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(150, 170, 100, 30);
        contentPane.add(btnLogin);

        //Event Handling
        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            if (username.equals("sameer") && password.equals("234")) {
                JOptionPane.showMessageDialog(null, "Login Successful!");

                //OPEN DASHBOARD
                new DashboardFrame().setVisible(true);

                //CLOSE LOGIN WINDOW
                dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password!");
            }
        });
       
    }
}
