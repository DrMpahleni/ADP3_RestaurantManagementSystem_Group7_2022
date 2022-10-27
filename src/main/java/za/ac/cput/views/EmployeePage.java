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
    JButton btnEmployees, btnBack, btnAdd;
    Font ftHead;

    String[] columnNames = {"Employee Id", "First Name", "Last Name", "Gender", "Employee Race", "Contact", "Contact Type", "Job",
            "Job Description", "Position"};
    Object[][] tblData = {{null, null, null, null, null, null, null, null, null, null}};
    Object[] column = {"Employee Id", "First Name", "Last Name", "Gender", "Employee Race", "Contact", "Contact Type", "Job",
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
        btnAdd = new JButton("Add");
        ftHead = new Font(Font.SANS_SERIF, Font.BOLD, 25);

        lblHead.setFont(ftHead);
        tblEmployee.setFillsViewportHeight(true);
        scrollEmployee.setPreferredSize(new Dimension(900, 600));


        TableColumn tblColumn = null;
        for (int i = 0; i < 10; i++) {
            tblColumn = tblEmployee.getColumnModel().getColumn(i);
            tblColumn.setPreferredWidth(200);
        }

        this.setGui();
    }

    public void setGui() {
        frame.add(BorderLayout.NORTH, pnlNorth);
        frame.add(BorderLayout.CENTER, pnlCenter);
        frame.add(BorderLayout.SOUTH, pnlSouth);

        pnlNorth.setBackground(new Color(0, 106, 255));
        pnlCenter.setBackground(new Color(0, 106, 255));
        pnlSouth.setBackground(new Color(0, 106, 255));

        pnlNorth.add(lblHead);

        pnlCenter.add(tblEmployee.getTableHeader(), BorderLayout.PAGE_START);
        pnlCenter.add(scrollEmployee, BorderLayout.CENTER);

        pnlSouth.add(btnAdd);
        pnlSouth.add(btnEmployees);
        pnlSouth.add(btnBack);


        btnEmployees.addActionListener(buttonActions());

        frame.setTitle("Employee List");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public ActionListener buttonActions() {

        btnEmployees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mdlTable.setColumnIdentifiers(column);
                tblEmployee.setModel(mdlTable);

                String url = "jdbc:mysql://localhost:3306/thechowloungedatabase";
                String user = "root";
                String pass = "password";

                try {
                    java.sql.Connection myConn = DriverManager.getConnection(url, user, pass);
                    Statement mySat = myConn.createStatement();
                    String sql = "SELECT * FROM users";
                    ResultSet rs = mySat.executeQuery(sql);

                    while (rs.next()) {
                        Object d[] = {rs.getString("Employee Id"),
                                rs.getString("First Name"),
                                rs.getString("Last Name"),
                                rs.getString("Gender"),
                                rs.getString("Employee Race"),
                                rs.getString("Contact"),
                                rs.getString("Contact Type"),
                                rs.getString("Job"),
                                rs.getString("Job Description"),
                                rs.getString("Position")};
                        mdlTable.addRow(d);
                    }

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new DashboardPage();
                frame.dispose();
            }
        });

    btnAdd.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new AddEmployee();
            frame.dispose();
        }
    });
        return null;
}

    public static void main(String[] args) {
        new EmployeePage();
    }
}
