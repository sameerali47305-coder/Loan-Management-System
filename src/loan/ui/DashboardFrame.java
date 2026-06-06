package loan.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class DashboardFrame extends JFrame {

    private JPanel contentPane;

    public DashboardFrame() {

        setTitle("Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 350);

        contentPane = new JPanel();
        contentPane.setLayout(null); // IMPORTANT
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //Title
        JLabel lblTitle = new JLabel("RBS LOAN SYSTEM");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBounds(90, 20, 250, 30);
        contentPane.add(lblTitle);

        //Add Loan Button
        JButton btnAddLoan = new JButton("Add Loan");
        btnAddLoan.setBounds(120, 80, 150, 30);
        contentPane.add(btnAddLoan);

        //View Loan Button
        JButton btnViewLoan = new JButton("View Loans");
        btnViewLoan.setBounds(120, 130, 150, 30);
        contentPane.add(btnViewLoan);

        //Remove Loan Button
        JButton btnRemoveLoan = new JButton("Remove Loan");
        btnRemoveLoan.setBounds(120, 180, 150, 30);
        contentPane.add(btnRemoveLoan);

        // Button
        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(120, 230, 150, 30);
        contentPane.add(btnLogout);

        // ================= EVENTS =================

        //Add Loan
        btnAddLoan.addActionListener(e -> {
            new AddLoanFrame().setVisible(true);
        });

        //View Loans
        btnViewLoan.addActionListener(e -> {
            new ViewLoanFrame().setVisible(true);
        });

        //Remove Loan 
        btnRemoveLoan.addActionListener(e -> {

            if (LoanStore.loans.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No loans to delete!");
                return;
            }

            //Create list display
            String[] options = new String[LoanStore.loans.size()];

            for (int i = 0; i < LoanStore.loans.size(); i++) {
                String[] loan = LoanStore.loans.get(i);
                options[i] = i + " - " + loan[0] + " (Rs " + loan[1] + ")";
            }

            //Show selection dialog
            String selected = (String) JOptionPane.showInputDialog(
                    null,
                    "Select loan to delete:",
                    "Delete Loan",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (selected != null) {
                int index = Integer.parseInt(selected.split(" - ")[0]);

                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    LoanStore.loans.remove(index);
                    JOptionPane.showMessageDialog(null, "Loan Deleted!");
                }
            }
        });

        //Logout
        btnLogout.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                dispose(); // close dashboard
                new LoginFrame().setVisible(true);
            }
        });
    }
}