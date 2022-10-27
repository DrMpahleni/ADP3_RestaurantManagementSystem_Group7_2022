package za.ac.cput.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class AddEmployee extends JFrame{
    JFrame frame;
    JPanel pnlNorth, pnlCenter, pnlSouth;

    JLabel lblEmployeeId, lblFName, lblLName, lblGender, lblEmployeeRace,lblContact, lblContactType, lblJob, lblJobDescription, lblPosition;
    JLabel lblTitle,lblLogo;
    JTextField txtEmployeeId, txtFName, txtLName, txtGender, txtEmployeeRace,txtContact, txtJob, txtJobDescription, txtPosition;
    JComboBox <String> cmbContactType;
    String [] contactTypeOptions = {"Email", "Cell number"};
    JButton btnAdd, btnDelete, btnBack;
    Font font1;

    public AddEmployee() {
        frame = new JFrame();
        lblLogo = new JLabel();
        pnlNorth = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();
        lblTitle = new JLabel("EMPLOYEE LIST");
        lblEmployeeId = new JLabel("Employee ID");
        lblFName = new JLabel("First Name");
        lblLName = new JLabel("Last Name");
        lblGender = new JLabel("Gender");
        lblEmployeeRace = new JLabel("Employee Race");
        lblContact = new JLabel("Contact");
        lblContactType = new JLabel("Contact Type");
        lblJob = new JLabel("Job");
        lblJobDescription = new JLabel("Job Description");
        lblPosition = new JLabel("Position");
        txtEmployeeId = new JTextField();
        txtFName = new JTextField();
        txtLName = new JTextField();
        txtGender = new JTextField();
        txtEmployeeRace = new JTextField();
        txtContact = new JTextField();
        txtJob = new JTextField();
        txtJobDescription = new JTextField();
        txtPosition = new JTextField();
        cmbContactType = new JComboBox<>(contactTypeOptions);
        btnAdd = new JButton("Create");
        btnDelete = new JButton("Clear");
        btnBack = new JButton("Back");
        font1 = new Font(Font.SANS_SERIF, Font.BOLD, 20);

        this.setApp();
    }
    public void setApp(){
        pnlNorth.setLayout(new FlowLayout());
        pnlCenter.setLayout(new GridLayout(10, 3));
        pnlSouth.setLayout(new GridLayout(1, 5));

        pnlNorth.setBackground(new Color(0,106,255));
        pnlCenter.setBackground(new Color(0,106,255));
        pnlSouth.setBackground(new Color(0,106,255));


        pnlNorth.add(lblTitle);
        lblLogo.setFont(font1);

        pnlCenter.add(lblEmployeeId);
        pnlCenter.add(txtEmployeeId);

        pnlCenter.add(lblFName);
        pnlCenter.add(txtFName);

        pnlCenter.add(lblLName);
        pnlCenter.add(txtLName);

        pnlCenter.add(lblGender);
        pnlCenter.add(txtGender);

        pnlCenter.add(lblEmployeeRace);
        pnlCenter.add(txtEmployeeRace);

        pnlCenter.add(lblContact);
        pnlCenter.add(txtContact);

        pnlCenter.add(lblContactType);
        pnlCenter.add(cmbContactType);

        pnlCenter.add(lblJob);
        pnlCenter.add(txtJob);

        pnlCenter.add(lblJobDescription);
        pnlCenter.add(txtJobDescription);

        pnlCenter.add(lblPosition);
        pnlCenter.add(txtPosition);


        // add JButtons to the jframe
        pnlSouth.add(btnAdd);
        pnlSouth.add(btnDelete);
        pnlSouth.add(btnBack);

        frame.add(BorderLayout.NORTH, pnlNorth);
        frame.add(BorderLayout.CENTER, pnlCenter);
        frame.add(BorderLayout.SOUTH, pnlSouth);

        btnAdd.addActionListener(buttonActions());


        frame.setTitle("Employee Details");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private ActionListener buttonActions() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/thechowloungedatabase";
                String user = "root";
                String pass = "password";

                String employeeId = txtEmployeeId.getText();
                String fName = txtFName.getText();
                String lName = txtLName.getText();
                String gender = txtGender.getText();
                String employeeRace = txtEmployeeRace.getText();
                String contact = txtContact.getText();
                String contactType = cmbContactType.getItemAt(cmbContactType.getSelectedIndex());
                String contactTypeSelected = contactType;
                String job = txtJob.getText();
                String jobDescription = txtJobDescription.getText();
                String position = txtPosition.getText();


                try {

                    java.sql.Connection myConn = DriverManager.getConnection(url, user, pass);

                    Statement myStat = myConn.createStatement();

                    String sql = "INSERT INTO user_account values ('" + employeeId + "','" + fName + "','" + lName + "','" + gender + "','" + employeeRace + "','" + contact + "','"
                            + contactType + "','" + job + "','" + jobDescription + "','" + position + "' )";

                    myStat.executeUpdate(sql);

                    JOptionPane.showMessageDialog(null, "Contact Successfully Created");

                    myConn.close();
                    //new DashboardPage();
                    frame.dispose();


                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeePage();
                frame.dispose();
            }
        });
        return null;
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
