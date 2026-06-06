package loan.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ViewLoanFrame extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;

    public ViewLoanFrame() {

        setTitle("View Loans");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //Title
        JLabel lblTitle = new JLabel("All Loans");
        lblTitle.setBounds(180, 10, 100, 25);
        contentPane.add(lblTitle);

        //Table
        String[] columns = {"Customer Name", "Amount"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 50, 370, 150);
        contentPane.add(scrollPane);

        //Back Button
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(160, 220, 100, 30);
        contentPane.add(btnBack);

        btnBack.addActionListener(e -> dispose());

        //Load Data into Table
        loadData();
    }

    // METHOD TO LOAD DATA
    private void loadData() {

        model.setRowCount(0);

        for (String[] loan : LoanStore.loans) {
            model.addRow(loan);
        }
    }
}
