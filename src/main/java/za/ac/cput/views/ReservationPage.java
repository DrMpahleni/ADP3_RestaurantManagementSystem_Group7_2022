package za.ac.cput.views;

import com.google.gson.Gson;
import okhttp3.*;
import za.ac.cput.domain.restaurant.Reservation;
import za.ac.cput.factory.restaurant.ReservationFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ReservationPage extends JFrame implements ActionListener {


    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();

    private JPanel panelNorth, panelCenter, panelSouth;

    private JLabel lblTitle, lblName, lblDate, lblAmount, lblPeoplePax, lblTblNum;
    private JTextField txtName, txtDate, txtAmount, txtPeoplePax, txtTblNum;
    private JLabel lblRequiredName, lblRequiredDate, lblRequiredAmount, lblRequiredPeoplePax, lblRequiredTblNum;
    private JButton btnReserve, btnClear, btnExit;
    private Font ftTitle, ftRequired, ftMain;
    private Box box;


    public ReservationPage() {
        super("Restaurant Management System");
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
        panelCenter.setLayout(new GridLayout(6, 6));
        panelSouth.setLayout(new GridLayout(1, 3));


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

        panelCenter.add(lblDate);
        panelCenter.add(txtDate);
        panelCenter.add(lblAmount);
        panelCenter.add(txtAmount);
        panelCenter.add(lblPeoplePax);
        panelCenter.add(txtPeoplePax);
        panelCenter.add(lblTblNum);
        panelCenter.add(txtTblNum);


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
        if (e.getActionCommand().equals("Create")) {
            reservation(txtName.getText(),txtDate.getText(), txtAmount.getText(), txtPeoplePax.getText(), txtTblNum.getText());
            JOptionPane.showMessageDialog(null, "Reservation has been created!");

        } else if (e.getActionCommand().equals("Clear")) {
            txtName.setText("");
            txtDate.setText("");
            txtAmount.setText("");
            txtPeoplePax.setText("");
            txtTblNum.setText("");

        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);

        }
    }

    public void reservation(String name, String date, String amount, String peoplePax, String tblNum ) {
        try {
            final String URL = "http://localhost:8080/reservation/create";
            Reservation reservation = new ReservationFactory().createReservation(name, date, amount, peoplePax, tblNum);
            Gson g = new Gson();
            String jsonString = g.toJson(reservation);
            String s = post(URL, jsonString);
            if (s != null)
                JOptionPane.showMessageDialog(null, "Reservation has been created!");
            else
                JOptionPane.showMessageDialog(null, "Reservation not created");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }


    public String post(final String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON,json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
    public static void main(String [] args){
        new ReservationPage();

    }

}
