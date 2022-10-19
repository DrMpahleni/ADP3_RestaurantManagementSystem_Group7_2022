/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package za.ac.cput.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author bongi
 */
public class supplierPage extends javax.swing.JFrame implements ActionListener {


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtSupplierAddress;
    private javax.swing.JTextField txtSupplierEmail;
    private javax.swing.JTextField txtSupplierName;
    private javax.swing.JTextField txtSupplierPhone;
    private Font ft1,ft2;
    Connection connection = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    // End of variables declaration



    /**
     * Creates new form NewJFrame
     */
    public supplierPage() {

        //initializeMenu();
        ft2 = new Font("Arial", Font.PLAIN, 22);
        ft1 = new Font("Arial", Font.BOLD, 32);
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSupplierName = new javax.swing.JTextField();
        txtSupplierEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSupplierPhone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSupplierAddress = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6= new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);


        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        initComponents();
        initializeMenu();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        jTable1.setColumnSelectionAllowed(true);



        jLabel1.setFont(ft2);
        jLabel6.setFont(ft1);
        jLabel1.setText("New supplier");

        jLabel2.setText("Supplier Name");

        jLabel3.setText("SupplierEmail");

        jLabel4.setText("Supplier Phone");

        jLabel5.setText("Supplier Address");

        jButton1.setText("ADD");
        jButton2.setText("Clear");

        jButton3.setText("Exit");
        jButton6.setText("Load Data");

        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
        jButton5.addActionListener(this);
        jButton6.addActionListener(this);


        jLabel6.setText("List of Suppliers ");


        jButton4.setText("Delete");

        jButton5.setText("Update");


        jLabel7.setText("Name Required");


        jLabel8.setText("Email required");


        jLabel9.setText("Phone  required");


        jLabel10.setText("Address  required");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null},
                        {null,null, null, null, null}
                },
                new String [] {
                        "ID", "Name", "Email", "Phone", "Address"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(14, 14, 14))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSupplierPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                    .addComponent(txtSupplierName)
                                    .addComponent(txtSupplierEmail)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSupplierAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(193, 193, 193))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel6)
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSupplierEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSupplierPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSupplierAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5))
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        this.setVisible(true);
    }// </editor-fold>
    private void initializeMenu(){

        Object columns[] = {"ID", "Name", "Email", "Phone", "Address"};
        defaultTableModel.setColumnIdentifiers(columns);
        jTable1.setModel(defaultTableModel);

        loadMenuData();

    }
    private void loadMenuData() {
        String url = "jdbc:mysql://localhost:3306/restaurantManagementTestSystem";

        String user = "root";
        String pass = "Mpa@5999";


        String query;
        query = "select  s.supplierID,s.supplierName,s.supplierEmail,s.supplierPhone,s.supplierAddress from supplier s";


        try {
            connection = DriverManager.getConnection(url, user, pass);
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Object columnData1[] = new Object[5];
            while (rs.next()) {
                columnData1[0] = rs.getInt("supplierID");
                columnData1[1] = rs.getString("supplierName");
                columnData1[2] = rs.getString("supplierEmail");
                columnData1[3] = rs.getString("supplierPhone");
                columnData1[4] = rs.getString("supplierAddress");

                defaultTableModel.addRow(columnData1);

            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    private void ADData() {
        String url = "jdbc:mysql://localhost:3306/restaurantManagementTestSystem";

        String user = "root";
        String pass = "Mpa@5999";


        String query2;
        query2 = "    INSERT INTO  supplier (\n" +
                "                        supplierID,\n" +
                "                        supplierName ,\n" +
                "                        supplierEmail,\n" +
                "                        supplierPhone,\n" +
                "                        supplierAddress\n" +
                "                ) VALUES (6,"+txtSupplierName.getText()+","+txtSupplierEmail.getText()+","+txtSupplierPhone.getText()+","+txtSupplierPhone.getText()+")";



        //Supplier supplier = new Supplier.Builder().setSupplierName(txtSupplierName.getText()).setSupplierEmail(txtSupplierEmail.getText()).setSupplierPhone(txtSupplierPhone.getText()).setSupplierAddress(txtSupplierPhone.getText()).build();


        try {
            connection = DriverManager.getConnection(url, user, pass);
            ps = connection.prepareStatement(query2);
            rs = ps.executeQuery();
            Object columnData1[] = new Object[5];

            while (rs.next()) {
                columnData1[0] = rs.getInt("supplierID");
                columnData1[1] = rs.getString("supplierName");
                columnData1[2] = rs.getString("supplierEmail");
                columnData1[3] = rs.getString("supplierPhone");
                columnData1[4] = rs.getString("supplierAddress");

                defaultTableModel.addRow(columnData1);
                connection.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private boolean isInputValid() {
        boolean valid = true;
        if (txtSupplierName.getText().equals("")) {
            jLabel7.setVisible(true);
            txtSupplierName.requestFocus();
            valid = false;
        }
        else
            jLabel7.setVisible(false);

        if (txtSupplierEmail.getText().equals("")) {
            jLabel8.setVisible(true);
            txtSupplierEmail.requestFocus();
            valid = false;
        }
        else
            jLabel8.setVisible(false);

        if (txtSupplierPhone.getText().equals("")) {
            jLabel9.setVisible(true);
            txtSupplierPhone.requestFocus();
            valid = false;
        }
        else
            jLabel9.setVisible(false);

        if (txtSupplierAddress.getText().equals("")) {
            jLabel10.setVisible(true);
            txtSupplierAddress.requestFocus();
            valid = false;
        }else
            jLabel10.setVisible(false);

        return valid;
    }

    private void clearForm() {
        txtSupplierName.setText("");
        jLabel7.setVisible(false);
        txtSupplierEmail.setText("");
        jLabel8.setVisible(false);
        txtSupplierPhone.setText("");
        jLabel9.setVisible(false);
        txtSupplierAddress.setText("");
        jLabel10.setVisible(false);
        txtSupplierName.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("ADD")) {
            if (isInputValid()) {
                // save to file
                ADData();
                //loadMenuData();
                clearForm();
            }
        }
        else if (e.getActionCommand().equals("Clear")) {
            clearForm();
        }
        else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }else if (e.getActionCommand().equals("Update")) {
            loadMenuData();
        }else if (e.getActionCommand().equals("Delete")) {
            loadMenuData();;
        }



    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //new  NewJFrame().initComponents();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(supplierPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(supplierPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(supplierPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(supplierPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new supplierPage().setVisible(true);
            }
        });
   }
}
