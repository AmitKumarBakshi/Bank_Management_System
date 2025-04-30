package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JLabel label2;
    JButton BackB;
    String pin;
    BalanceEnquiry(String pin){
        this.pin = pin;
        setLayout(null);
        setSize(1370,730);
        setLocation(0,0);
        setUndecorated(true);

        ImageIcon ATM = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image ATM_set = ATM.getImage().getScaledInstance(1363,690,Image.SCALE_DEFAULT);
        ImageIcon ATM_final = new ImageIcon(ATM_set);
        JLabel Machine = new JLabel(ATM_final);
        Machine.setBounds(0,0,1363,690);
        add(Machine);

        JLabel label1 = new JLabel("Your Current Balance is Rs. ");
        label1.setBounds(375,130,400,35);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setForeground(new Color(75,198,255));
        Machine.add(label1);

        label2 = new JLabel();
        label2.setBounds(375,170,400,35);
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setForeground(new Color(0,255,0));
        Machine.add(label2);

        BackB = new JButton("BACK");
        BackB.setBounds(660,343,125,26);
        BackB.setFont(new Font("System",Font.BOLD,16));
        BackB.setBackground(new Color(0));
        BackB.setForeground(new Color(237, 103, 7));
        BackB.addActionListener(this);
        Machine.add(BackB);

        int balance =0;
        try{
            JDBCconnection connect = new JDBCconnection();
            ResultSet resultSet = connect.statement.executeQuery("SELECT * FROM bank WHERE PIN = '"+pin+"'");
            while (resultSet.next()){
                if (resultSet.getString("Type").equals("Deposit")) {
                    balance = balance + Integer.parseInt(resultSet.getString("Amount"));
                } else {
                    balance = balance - Integer.parseInt(resultSet.getString("Amount"));
                }
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        label2.setText(""+balance);


        setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transaction(pin);

    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
