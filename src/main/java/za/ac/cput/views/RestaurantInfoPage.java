package za.ac.cput.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RestaurantInfoPage extends JFrame {

    JFrame frame;
    JPanel pnlNorth, pnlCenter, pnlSouth;
    JLabel lblHeading, lblName, lblAddress, lblPhone;
    JTable tblRes;
    DefaultTableModel DTM;
    JScrollPane resScroll;
    String[] coloumnNames = {"ID", "Name", "Street", "Suburb", "City", "Province", "zip Code", "Phone",};
    Object[][] tblData = {{null, null, null, null, null, null, null, null,}};
    JButton btnBack;
    Font ftHead;

    public RestaurantInfoPage() {
        frame = new JFrame("Restaurant Management System");
        pnlNorth = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();
        lblHeading = new JLabel("Restaurant Information");
        lblName = new JLabel("Restaurant Name: ");
        lblAddress = new JLabel("Restaurant Address: ");
        lblPhone = new JLabel("Restaurant Phone : ");
        btnBack = new JButton("Back");
        tblRes = new JTable(tblData, coloumnNames);
        DTM = new DefaultTableModel();
        resScroll = new JScrollPane(tblRes);
        ftHead = new Font(Font.SANS_SERIF, Font.BOLD, 25);

        tblRes.setFillsViewportHeight(true);
        resScroll.setPreferredSize(new Dimension(900,600));
        lblHeading.setFont(ftHead);

        TableColumn tblColumn = null;
        for (int i = 0; i < 8; i++) {
            tblColumn = tblRes.getColumnModel().getColumn(i);
            tblColumn.setPreferredWidth(150);
        }

        this.setGui();
        this.getData();
    }

    public void setGui() {

        frame.add(BorderLayout.NORTH, pnlNorth);
        frame.add(BorderLayout.CENTER, pnlCenter);
        frame.add(BorderLayout.SOUTH, pnlSouth);

        pnlNorth.add(lblHeading);

        pnlCenter.add(tblRes.getTableHeader(), BorderLayout.PAGE_START);
        pnlCenter.add(resScroll, BorderLayout.CENTER);

        pnlSouth.add(btnBack);


        btnBack.addActionListener(buttonActions());

        frame.setTitle("Login page");
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public void getData() {

        DefaultTableModel DTMRes = new DefaultTableModel();
        Object[] coloumn = {"ID", "Name", "Street", "Suburb", "City", "Province", "zip Code", "Phone"};
        DTMRes.setColumnIdentifiers(coloumn);
        tblRes.setModel(DTMRes);

        String url = "jdbc:mysql://localhost:3306/thechowloungedb";
        String user = "root";
        String pass = "password";

        try{
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStat = myConn.createStatement();
            String sql = "SELECT * FROM restaurantinfo";
            ResultSet rs = myStat.executeQuery(sql);

            while (rs.next()) {
                Object d[] = {rs.getInt("res_id"), rs.getString("res_name"),
                        rs.getString("res_StreetAddress"), rs.getString("res_Suburb"),
                        rs.getString("res_City"), rs.getString("res_Province"),
                        rs.getInt("res_zipCode"), rs.getInt("res_Phone")};
                DTMRes.addRow(d);
            }
        } catch (SQLException a){
            a.printStackTrace();
        }
    }

    public ActionListener buttonActions() {

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DashboardPage();
                frame.dispose();
            }
        });

        return null;
    }

    public static void main(String[] args) {
        new RestaurantInfoPage();
    }
}
