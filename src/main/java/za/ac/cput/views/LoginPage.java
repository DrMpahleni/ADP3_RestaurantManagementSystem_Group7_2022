/*
    Position Class
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */
package za.ac.cput.views;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginPage extends JFrame {

    JFrame frame;
    JPanel pnlNorth, pnlWest, pnlCenter, pnlEast, pnlSouth;
    Box box, boxH;
    JLabel lblHeading, lblUsername, lblPassword;
    JTextField txtUsername;
    JPasswordField passPassword;
    JButton btnLogin, btnCreate, btnClear, btnExit;
    Font ftHead;

    public LoginPage() {

        frame = new JFrame("Restaurant Management System");
        pnlNorth = new JPanel();
        pnlWest = new JPanel();
        pnlCenter = new JPanel();
        pnlEast = new JPanel();
        pnlSouth = new JPanel();
        box = Box.createVerticalBox();
        boxH = Box.createHorizontalBox();
        lblHeading = new JLabel("WELCOME");
        lblUsername = new JLabel("Username: ");
        lblPassword = new JLabel("Password: ");
        txtUsername = new JTextField();
        passPassword = new JPasswordField();
        btnLogin = new JButton("LOGIN");
        btnCreate = new JButton("CREATE");
        btnClear = new JButton("CLEAR");
        btnExit = new JButton("EXIT");
        ftHead = new Font(Font.SANS_SERIF, Font.BOLD, 25);

        box.setSize(200, 500);
        lblUsername.setBounds(0, 0, 70, 20);
        txtUsername.setPreferredSize(new Dimension(193, 28));
        passPassword.setPreferredSize(new Dimension(193,28));
        lblHeading.setFont(ftHead);

        this.setGui();

    }

    public void setGui() {

        frame.add(BorderLayout.NORTH, pnlNorth);
        frame.add(BorderLayout.CENTER, pnlCenter);
        frame.add(BorderLayout.SOUTH, pnlSouth);

        // SETTING COMPONENTS TO TOP OF PAGE //

        pnlNorth.add(lblHeading);

        // SETTING COMPONENTS TO CENTER OF PAGE //

        pnlCenter.add(box);
        box.add(Box.createRigidArea(new Dimension(0, 200)));
        lblUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
        box.add(lblUsername);
        box.add(Box.createRigidArea(new Dimension(0, 20)));
        box.add(txtUsername);
        box.add(Box.createRigidArea(new Dimension(0, 20)));
        lblPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        box.add(lblPassword);
        box.add(Box.createRigidArea(new Dimension(0, 20)));
        box.add(passPassword);
        box.add(Box.createRigidArea(new Dimension(0, 20)));
        //box.add(btnLogin);
        box.add(boxH);
        boxH.add(btnLogin);
        boxH.add(Box.createHorizontalGlue());
        boxH.add(btnClear);

        //SETTING COMPONENTS TO BOTTOM OF PAGE //

        pnlSouth.add(btnExit);
        pnlSouth.add(btnCreate);

        //SETTING BUTTON ACTIONS//

        btnLogin.addActionListener(buttonActions());

        //CREATING FRAME//

        frame.setTitle("Login page");
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public ActionListener buttonActions() {

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String url = "jdbc:mysql://localhost:3306/rms";
                String user = "root";
                String pass = "password";

                try{

                    java.sql.Connection myConn = DriverManager.getConnection(url, user, pass);

                    String Username = txtUsername.getText();
                    String Password = passPassword.getText();

                    Statement myStat = myConn.createStatement();

                    String sql = "SELECT Name, Passcode FROM users WHERE Name ='"+Username+"'and Passcode ='"+Password+"'";

                    ResultSet result = myStat.executeQuery(sql);

                    if (result.next()){
                        //new dash();
                        frame.dispose();
                        JOptionPane.showMessageDialog(null, "Password correct");
                    }

                    else{
                        JOptionPane.showMessageDialog(null,"Username or Password is invalid");
                        txtUsername.setText("");
                        passPassword.setText("");
                    }

                    myConn.close();
                }
                catch(Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtUsername.setText("");
                passPassword.setText("");
            }
        });

        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        return null;
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
