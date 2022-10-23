package za.ac.cput.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class EmployeePage {
    JFrame frame;
    JPanel pnlNorth, pnlCenter, pnlSouth;
    JTable tblEmployee;
    DefaultTableModel mdlTable;
    JScrollPane scrollEmployee;
    JLabel lblHead;
    JButton btnEmployees, btnBack;
    Font ftHead;
    String[] columnNames = {"Employee Id", "First Name", "Last Name", "Gender", "Employee Race","Contact", "Contact Type","Job",
            "Job Description", "Position"};
    Object[][] tblData = {{null, null}};
    Object[] column = {"Employee Id", "First Name", "Last Name", "Gender", "Employee Race","Contact", "Contact Type","Job",
            "Job Description", "Position"};

    public EmployeePage() {
        frame = new JFrame();
        pnlNorth = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();
        tblEmployee = new JTable(tblData, columnNames);
        mdlTable = new DefaultTableModel();
        scrollEmployee = new JScrollPane(tblEmployee);
        lblHead = new JLabel("Staff List");
        btnEmployees = new JButton("Employees");
        btnBack = new JButton("Return");
        ftHead = new Font(Font.SANS_SERIF, Font.BOLD, 25);

        lblHead.setFont(ftHead);
        tblEmployee.setFillsViewportHeight(true);

        TableColumn tblColumn = null;
        for (int i = 0; i < 10; i++) {
            tblColumn = tblEmployee.getColumnModel().getColumn(i);
            tblColumn.setPreferredWidth(140);
        }

        this.setGui();
    }

    public void setGui() {
        frame.add(BorderLayout.NORTH, pnlNorth);
        frame.add(BorderLayout.CENTER, pnlCenter);
        frame.add(BorderLayout.SOUTH, pnlSouth);

        pnlNorth.add(lblHead);

        pnlCenter.add(tblEmployee.getTableHeader(), BorderLayout.PAGE_START);
        pnlCenter.add(scrollEmployee,BorderLayout.CENTER);

        pnlSouth.add(btnEmployees);
        pnlSouth.add(btnBack);

        btnEmployees.addActionListener(buttonActions());

        frame.setTitle("Employee List");
        frame.setSize(1600, 800);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public ActionListener buttonActions() {

        btnEmployees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mdlTable.setColumnIdentifiers(column);
                tblEmployee.setModel(mdlTable);

                String url = "jdbc:mysql://localhost:3306/rms";
                String user = "root";
                String pass = "password";

                try {
                    java.sql.Connection myConn = DriverManager.getConnection(url,user, pass);
                    Statement mySat = myConn.createStatement();
                    String sql = "SELECT * FROM users";
                    ResultSet rs = mySat.executeQuery(sql);

                    while(rs.next()) {
                        Object d[] = {rs.getString("Employee Id"), rs.getString("First Name"),rs.getString("Last Name"),
                                rs.getString("Gender"),rs.getString("Employee Race"),rs.getString("Contact"), rs.getString("Contact Type"),
                        rs.getString("Job"), rs.getString("Job Description"),rs.getString("Position")};
                        mdlTable.addRow(d);
                    }

                }
                catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
            }
        });

        return null;
    }

    public static void main(String[] args) {
        new EmployeePage();
    }
}
