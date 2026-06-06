package loan.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

//Correct import
import loan.ui.LoanStore;

public class AddLoanFrame extends JFrame {

    private JPanel contentPane;
    private JTextField txtName;
    private JTextField txtAmount;

    public AddLoanFrame() {

        setTitle("Add Loan");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 300);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //Title
        JLabel lblTitle = new JLabel("Add Loan");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBounds(130, 10, 150, 30);
        contentPane.add(lblTitle);

        //Name Label
        JLabel lblName = new JLabel("Customer Name:");
        lblName.setBounds(40, 70, 120, 25);
        contentPane.add(lblName);

        //Name Field
        txtName = new JTextField();
        txtName.setBounds(170, 70, 150, 25);
        contentPane.add(txtName);

        //Amount Label
        JLabel lblAmount = new JLabel("Loan Amount:");
        lblAmount.setBounds(40, 110, 120, 25);
        contentPane.add(lblAmount);

        //Amount Field
        txtAmount = new JTextField();
        txtAmount.setBounds(170, 110, 150, 25);
        contentPane.add(txtAmount);

        //Save Button
        JButton btnSave = new JButton("Save");
        btnSave.setBounds(140, 160, 100, 30);
        contentPane.add(btnSave);

        //EVENT HANDLING + VALIDATION + SAVE
        btnSave.addActionListener(e -> {
            try {
                String name = txtName.getText().trim();
                double amount = Double.parseDouble(txtAmount.getText().trim());

                if (name.isEmpty()) {
                    throw new Exception("Name cannot be empty!");
                }
                if (amount <= 0) {
                    throw new Exception("Amount must be positive!");
                }

                //SAVE DATA (CORRECT)
                LoanStore.loans.add(new String[]{name, String.valueOf(amount)});

                JOptionPane.showMessageDialog(this, "Loan Added Successfully!");

                // Clear fields
                txtName.setText("");
                txtAmount.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter valid numeric amount!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        //Back Button
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(140, 200, 100, 30);
        contentPane.add(btnBack);

        btnBack.addActionListener(e -> dispose());
    }
}