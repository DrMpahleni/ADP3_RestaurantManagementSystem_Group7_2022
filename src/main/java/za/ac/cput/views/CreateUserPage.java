package za.ac.cput.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateUserPage extends JFrame {

    JFrame frame;
    JPanel pnlNorth, pnlCenter, pnlSouth;
    Box boxVertical1, boxHorizontal1, boxHorizontal2, boxHorizontal3, boxHorizontal4;
    JLabel lblHeading, lblName, lblSurname, lblPassword1, lblId, lblRole;
    JTextField txtFirstName, txtLastName, txtPass1, txtId;
    JButton btnCreate, btnCancel;
    JComboBox<String>  cmbRoleBox;
    String [] roleOptions = {"Admin", "User"};
    Font ftHead;

    public CreateUserPage() {

        frame = new JFrame();
        pnlNorth = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();
        boxVertical1 = Box.createVerticalBox();
        boxHorizontal1 = Box.createHorizontalBox();
        boxHorizontal2 = Box.createHorizontalBox();
        boxHorizontal3 = Box.createHorizontalBox();
        boxHorizontal4 = Box.createHorizontalBox();
        lblHeading = new JLabel("Create User..");
        lblId = new JLabel("Id: ");
        lblName = new JLabel("First Name: ");
        lblSurname = new JLabel("Last Name: ");
        lblPassword1 = new JLabel("Password: ");
        lblRole = new JLabel("Role: ");
        txtFirstName = new JTextField();
        txtLastName = new JTextField();
        txtPass1 = new JTextField();
        txtId = new JTextField();
        btnCreate = new JButton("Create");
        btnCancel = new JButton("Cancel");
        cmbRoleBox = new JComboBox<>(roleOptions);
        ftHead = new Font(Font.SANS_SERIF, Font.BOLD, 25);

        lblHeading.setFont(ftHead);
        pnlCenter.setSize(900, 700);
        boxVertical1.setSize(900, 500);
        boxHorizontal1.setSize(800, 500);
        txtFirstName.setPreferredSize(new Dimension(193, 28));
        txtLastName.setPreferredSize(new Dimension(193, 28));
        txtPass1.setPreferredSize(new Dimension(193, 28));

        this.setGUI();
    }

    public void setGUI() {

        frame.add(BorderLayout.NORTH, pnlNorth);
        frame.add(BorderLayout.CENTER, pnlCenter);
        frame.add(BorderLayout.SOUTH, pnlSouth);

        pnlNorth.add(lblHeading);

        pnlCenter.add(boxVertical1);
        boxVertical1.add(Box.createRigidArea(new Dimension(0, 200)));
        boxVertical1.add(boxHorizontal1);
        boxHorizontal1.add(lblId);
        boxHorizontal1.add(Box.createRigidArea(new Dimension(110, 0)));
        boxHorizontal1.add(txtId);
        boxVertical1.add(Box.createRigidArea(new Dimension(0, 10)));

        boxVertical1.add(boxHorizontal2);
        boxHorizontal2.add(lblName);
        boxHorizontal2.add(Box.createRigidArea(new Dimension(57, 0)));
        boxHorizontal2.add(txtFirstName);
        boxVertical1.add(Box.createRigidArea(new Dimension(0, 10)));

        boxVertical1.add(boxHorizontal3);
        boxHorizontal3.add(lblPassword1);
        boxHorizontal3.add(Box.createRigidArea(new Dimension(60, 0)));
        boxHorizontal3.add(txtPass1);
        boxVertical1.add(Box.createRigidArea(new Dimension(0, 10)));

        boxVertical1.add(boxHorizontal4);
        boxHorizontal4.add(lblRole);
        boxHorizontal4.add(Box.createRigidArea(new Dimension(70, 0)));
        boxHorizontal4.add(cmbRoleBox);
        boxVertical1.add(Box.createRigidArea(new Dimension(0, 10)));

        pnlSouth.add(btnCreate);
        pnlSouth.add(btnCancel);

        btnCreate.addActionListener(buttonActions());

        frame.setTitle("Login page");
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public ActionListener buttonActions() {

        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String url = "jdbc:mysql://localhost:3306/rms";
                String user = "root";
                String pass = "password";

                String id = txtId.getText();
                String name = txtFirstName.getText();
                String pass1 = txtPass1.getText();
                String role = cmbRoleBox.getItemAt(cmbRoleBox.getSelectedIndex());
                String roleSelected = role;

                try {

                    java.sql.Connection myConn = DriverManager.getConnection(url, user, pass);

                    Statement myStat = myConn.createStatement();

                    String sql = "INSERT INTO user_account values ( '" +id+ "', '" + name+ "','" +pass1+"','" +roleSelected+"')";

                    myStat.executeUpdate(sql);

                    JOptionPane.showMessageDialog(null, "Welcome " + name + " ,your account has been created!");

                    myConn.close();
                    new LoginPage();
                    frame.dispose();


                }
                catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                frame.dispose();
            }
        });
        return null;
    }

    public static void main(String[] args) {
        new CreateUserPage();
    }
}
