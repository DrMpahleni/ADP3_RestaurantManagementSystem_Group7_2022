package za.ac.cput.views;

/*
Order Management page
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderPage extends JFrame {
    JFrame frame;
    JPanel pnlNorth, pnlCenter, pnlSouth;
    JTable tblRestaurant_Order;
    DefaultTableModel mdlTable;
    JScrollPane scrollOrder;
    JLabel lblHead;

    JButton btnAdd,btnDisplay, btnDelete, btnPayment, btnBack;
    Font ftHead;
    String[] columnNames = {"Order Id", "Order Item", "Date", "Amount"};
    Object[][] tblData = {{null, null, null,null}};
    Object[] column = {"Order Id", "Order Item", "Date", "Amount"};

    public OrderPage() {
        frame = new JFrame();
        pnlNorth = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();


        tblRestaurant_Order = new JTable(tblData, columnNames);
        mdlTable = new DefaultTableModel();
        scrollOrder = new JScrollPane(tblRestaurant_Order);
        lblHead = new JLabel(" Manage Orders ");
        btnAdd = new JButton("Add");
        btnDisplay = new JButton("Display Order");
        btnDelete = new JButton("Delete");
        btnPayment = new JButton("Payment");
        btnBack = new JButton("Return");
        ftHead = new Font(Font.SANS_SERIF, Font.BOLD, 25);

        lblHead.setFont(ftHead);
        tblRestaurant_Order.setFillsViewportHeight(true);

        TableColumn tblColumn = null;
        for (int i = 0; i < 2; i++) {
            tblColumn = tblRestaurant_Order.getColumnModel().getColumn(i);
            tblColumn.setPreferredWidth(50);
        }

        this.setGui();
    }

    public void setGui() {
        frame.add(BorderLayout.NORTH, pnlNorth);
        frame.add(BorderLayout.CENTER, pnlCenter);
        frame.add(BorderLayout.SOUTH, pnlSouth);

        pnlNorth.add(lblHead);



        pnlCenter.add(tblRestaurant_Order.getTableHeader(), BorderLayout.PAGE_START);
        pnlCenter.add(scrollOrder,BorderLayout.CENTER);

        pnlSouth.add(btnAdd);
        pnlSouth.add(btnDisplay);
        pnlSouth.add(btnPayment);
        pnlSouth.add(btnDelete);
        pnlSouth.add(btnBack);

        btnDisplay.addActionListener(buttonActions());

        frame.setTitle("Restaurant Management System");
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public ActionListener buttonActions() {

        btnDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mdlTable.setColumnIdentifiers(column);
                tblRestaurant_Order.setModel(mdlTable);

                String url = "jdbc:mysql://localhost:3306/thechowloungedatabase";
                String user = "root";
                String pass = "password";

                try {
                    java.sql.Connection myConn = DriverManager.getConnection(url,user, pass);
                    Statement mySat = myConn.createStatement();
                    String sql = "SELECT * FROM restaurant_Order";
                    ResultSet rs = mySat.executeQuery(sql);

                    while(rs.next()) {
                        Object d[] = {rs.getString("Order Id"), rs.getString("Order Item"), rs.getString(" Date "), rs.getString(" Amount")};
                        mdlTable.addRow(d);
                    }

                }
                catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                // i = the index of the selected row
                int i = tblRestaurant_Order.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    mdlTable.removeRow(i);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });

        btnPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // new ;
            }
        });


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
        new OrderPage();

    }
}
