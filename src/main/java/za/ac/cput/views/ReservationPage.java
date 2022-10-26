package za.ac.cput.views;

import com.google.gson.Gson;
import okhttp3.*;
import za.ac.cput.domain.restaurant.Reservation;
import za.ac.cput.factory.restaurant.ReservationFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Statement;

public class ReservationPage extends JFrame implements ActionListener {


    private JPanel panelNorth, panelCenter, panelSouth;
    private JFrame frame;
    private JLabel lblTitle, lblName, lblDate, lblAmount, lblPeoplePax, lblTblNum;
    private JTextField txtName, txtDate, txtAmount, txtPeoplePax, txtTblNum;
    private JLabel lblRequiredName, lblRequiredDate, lblRequiredAmount, lblRequiredPeoplePax, lblRequiredTblNum;
    private JButton btnReserve, btnClear, btnExit;
    private Font ftTitle, ftRequired, ftMain;
    private Box box;


    public ReservationPage() {
        super("Restaurant Management System");
        frame = new JFrame();
        panelNorth = new JPanel();
        panelNorth.setBackground(Color.white);
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelCenter.setBackground(new Color(3, 252, 240));
        box = Box.createVerticalBox();

        lblTitle = new JLabel("Make a reservation", SwingConstants.CENTER);
        lblTitle.setForeground(Color.black);

        lblName = new JLabel("Name:");
        txtName = new JTextField();
        lblDate = new JLabel("Date:");
        txtDate = new JTextField();
        lblAmount = new JLabel("Amount:");
        txtAmount = new JTextField();
        lblPeoplePax = new JLabel("Amount of people(pax):");
        txtPeoplePax = new JTextField();
        lblTblNum = new JLabel("Table Number:");
        txtTblNum = new JTextField();
        lblRequiredName = new JLabel("Name is required");
        lblRequiredName.setForeground(Color.RED);
        lblRequiredName.setVisible(false);
        lblRequiredDate = new JLabel("Date is required");
        lblRequiredDate.setForeground(Color.RED);
        lblRequiredDate.setVisible(false);
        lblRequiredAmount = new JLabel("Amount is required");
        lblRequiredAmount.setForeground(Color.RED);
        lblRequiredAmount.setVisible(false);
        lblRequiredPeoplePax = new JLabel("Amount of people is required");
        lblRequiredPeoplePax.setForeground(Color.RED);
        lblRequiredPeoplePax.setVisible(false);
        lblRequiredTblNum = new JLabel("Table number is required");
        lblRequiredTblNum.setForeground(Color.RED);
        lblRequiredTblNum.setVisible(false);

        btnReserve = new JButton("Make a reservation");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");
        ftTitle = new Font("Arial", Font.BOLD, 20);
        ftMain = new Font("Arial", Font.PLAIN, 15);
        ftRequired = new Font("Italic", Font.BOLD, 12);

        this.setGUI();

    }

    public void setGUI() {
        panelNorth.setLayout(new GridLayout(1, 1));
        panelCenter.setLayout(new GridLayout(7, 3));
        panelSouth.setLayout(new GridLayout(1, 3));
        panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER));


        lblTitle.setFont(ftTitle);
        lblName.setFont(ftMain);
        lblDate.setFont(ftMain);
        lblAmount.setFont(ftMain);
        lblPeoplePax.setFont(ftMain);
        lblTblNum.setFont(ftMain);

        btnReserve.setFont(ftMain);
        btnClear.setFont(ftMain);
        btnExit.setFont(ftMain);
        lblRequiredName.setFont(ftRequired);
        lblRequiredDate.setFont(ftRequired);
        lblRequiredAmount.setFont(ftRequired);
        lblRequiredPeoplePax.setFont(ftRequired);
        lblRequiredTblNum.setFont(ftRequired);

        panelNorth.add(lblTitle);
        panelCenter.add(lblName);
        panelCenter.add(txtName);
        panelCenter.add(lblRequiredName);

        panelCenter.add(lblDate);
        panelCenter.add(txtDate);
        panelCenter.add(lblRequiredDate);

        panelCenter.add(lblAmount);
        panelCenter.add(txtAmount);
        panelCenter.add(lblRequiredAmount);

        panelCenter.add(lblPeoplePax);
        panelCenter.add(txtPeoplePax);
        panelCenter.add(lblRequiredPeoplePax);

        panelCenter.add(lblTblNum);
        panelCenter.add(txtTblNum);
        panelCenter.add(lblRequiredTblNum);


        panelSouth.add(btnReserve);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);


        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);

        btnReserve.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Make a reservation")) {

            if ((txtName.getText().length() == 0) || (txtDate.getText().length() == 0) || (txtAmount.getText().length() == 0) || (txtPeoplePax.getText().length() == 0) || (txtTblNum.getText().length() == 0)) {

                lblRequiredName.setVisible(true);
                lblRequiredDate.setVisible(true);
                lblRequiredAmount.setVisible(true);
                lblRequiredPeoplePax.setVisible(true);
                lblRequiredTblNum.setVisible(true);


            } else {


                String url = "jdbc:mysql://localhost:3306/thechowloungedatabase";
                String user = "root";
                String pass = "password";

                String name = txtName.getText();
                String date = txtDate.getText();
                String amount = txtAmount.getText();
                String peoplePax = txtPeoplePax.getText();
                String tblNum = txtTblNum.getText();

                try{

                    java.sql.Connection myConn = DriverManager.getConnection(url, user, pass);

                    Statement myStat = myConn.createStatement();

                String sql = "INSERT INTO reservation values ( '" + name + "', '" + date + "','" + amount + "','" + peoplePax + "','" + tblNum + "')";

                myStat.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, "Welcome " + name + " ,your reservation has been created!");

                myConn.close();
                new ReservationPage();
                frame.dispose();


            }
                catch(Exception ex){
                System.out.println(ex);

                JOptionPane.showMessageDialog(rootPane, "Your reservation has been made ");

                if ((txtName.getText().length() == 0) || (txtDate.getText().length() == 0) || (txtAmount.getText().length() == 0) || (txtPeoplePax.getText().length() == 0) || (txtTblNum.getText().length() == 0)) {
                    JOptionPane.showMessageDialog(null, "Your info is incomplete");
                }

            }
        }


        } else if (e.getActionCommand().equals("Clear")) {
            txtName.setText("");
            txtDate.setText("");
            txtAmount.setText("");
            txtPeoplePax.setText("");
            txtTblNum.setText("");
            txtName.requestFocus();
            if ((txtName.getText().length() == 0) || (txtDate.getText().length() == 0) || (txtAmount.getText().length() == 0) || (txtPeoplePax.getText().length() == 0) || (txtTblNum.getText().length() == 0)) {
                JOptionPane.showMessageDialog(null, "Your info is incomplete");

                lblRequiredName.setVisible(true);
                lblRequiredDate.setVisible(true);
                lblRequiredAmount.setVisible(true);
                lblRequiredPeoplePax.setVisible(true);
                lblRequiredTblNum.setVisible(true);
            }

        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);

        }
    }


    public static void main(String [] args){
        new ReservationPage();

    }

}
