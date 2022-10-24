package za.ac.cput.views;
/*
    Position Class
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */
import za.ac.cput.domain.menu.MenuItem;
import za.ac.cput.util.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menu extends JFrame implements ActionListener {

    DashboardPage dashboard;
    private Client client;
    private JPanel panelEast, panelWest;

    private JTextArea orders;
    private JLabel lblOrder, lblItems;
    private JComboBox<String> menuItems;
    private JButton back, order, add;

    public Menu(){
        super("Menu by Hlumelo");
        client = new Client();
        this.panelEast = new JPanel();
        this.panelWest = new JPanel();
        this.orders = new JTextArea();
        this.lblOrder = new JLabel("Order");
        this.lblItems = new JLabel("Items");
        this.menuItems = new JComboBox<>();
        this.back = new JButton("Back");
        this.order = new JButton("Order");
        this.add = new JButton("Add");

        setUp();
    }

    private void loadItems(){
        ArrayList<MenuItem> items = client.getAllMenuItems();
        if(items != null && items.size()>0){
            items.forEach(i -> this.menuItems.addItem(i.getMenuItemID()+" "+i.getPrice()+" "+i.getPortion()));
        }
        else{
            this.menuItems.addItem("***empty***");
        }
    }

    private void setUp(){
        this.setPreferredSize(new Dimension(800, 400));
        panelEast.setLayout(new GridLayout(4, 1));
        panelWest.setLayout(new GridLayout(3, 1));

        panelEast.add(back);
        panelEast.add(lblItems);
        panelEast.add(menuItems);
        panelEast.add(add);

        panelWest.add(lblOrder);
        panelWest.add(orders);
        panelWest.add(order);

        this.add(panelEast, BorderLayout.WEST);
        this.add(panelWest, BorderLayout.EAST);

        lblItems.setHorizontalAlignment(JLabel.CENTER);
        lblOrder.setHorizontalAlignment(JLabel.CENTER);

        back.addActionListener(this);
        order.addActionListener(this);
        add.addActionListener(this);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        loadItems();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Back")){
            dashboard = new DashboardPage();
            this.dispose();
        }
    }
}
