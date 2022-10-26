package za.ac.cput.views;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class PaymentPage extends JFrame {

    JTextPane txtPane;
    String input = JOptionPane.showInputDialog("Enter Order Number:");

    public PaymentPage() {

        txtPane = new JTextPane();
        printNewReceipt();
    }

    public void printNewReceipt() {


        String orderNum = input;
        double total = 0;

        String url = "jdbc:mysql://localhost:3306/thechowloungedatabase";
        String user = "root";
        String pass = "password";

        try {

            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myStat = myConn.createStatement();
            String sql = "SELECT * FROM restaurant_order WHERE order_id = '"+orderNum+"' ";
            ResultSet rs = myStat.executeQuery(sql);

            ArrayList<Object> items = new ArrayList<Object>();
            ArrayList<Double> amounts = new ArrayList<Double>();


            while(rs.next()) {

                String item = String.format("%-15s %18s\n", rs.getString("order_Item"),"R " + rs.getDouble("amount"));
                double amount = rs.getDouble("amount");
                items.add(item);
                amounts.add(amount);

                for (int i = 0; i < items.size(); i++) {
                    items.get(i);
                }

                total = amounts.stream()
                        .mapToDouble(Double::doubleValue)
                        .sum();

                for (int y = 0; y < amounts.size(); y++) {
                    amounts.get(y);
                    //total += amounts.get(y);
                }
            }
            String itemList = items.toString();
            itemList = itemList.substring(1, itemList.length() - 1);
            itemList = itemList.replace(",","");
            String price = amounts.toString();
            price = price.substring(1, price.length() -1);

            String prntLine = String.format("%5s\n","______________________________");
            String prntDotLine = String.format("%5s\n","_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
            String prntName = String.format("%30s\n", "The ChowLounge");
            String prntHead = String.format("%-15s %19s\n", "Item", "Price");
            String prntVal = String.format("%-15s %15s\n", "______", "_____");
            String prntTotal = String.format("%-15s %14s\n", "Total Amount:", "R " + total);

            String outputHead = prntDotLine + prntName + prntDotLine;
            String output = prntHead + prntVal;
            String outputBottom = prntDotLine + prntTotal + prntDotLine;



            txtPane.setText(outputHead+ output + itemList + outputBottom);
            JOptionPane.showMessageDialog(null, new JScrollPane(txtPane));

        }   catch (SQLException a) {
            a.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PaymentPage();
    }
}
