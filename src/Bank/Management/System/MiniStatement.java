package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    String pin;
    JButton Close;
    String space;
    MiniStatement(String pin){

        this.pin = pin;
        setLayout(null);
        setSize(350,600);
        setLocation(10,10);
        setUndecorated(true);
        getContentPane().setBackground(new Color(222, 230, 156));

        JLabel label1 = new JLabel();
        label1.setBounds(25,70,400,400);
        add(label1);

        JLabel label2 = new JLabel("BOB World");
        label2.setBounds(130,15,200,30);
        label2.setFont(new Font("System",Font.BOLD,16));
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20,50,300,30);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(25,450,200,30);
        label4.setFont(new Font("System",Font.BOLD,13));
        add(label4);

        try {
            JDBCconnection connect = new JDBCconnection();
            String query1 = "SELECT * FROM login WHERE PIN_No = '"+pin+"'";
            ResultSet resultSet = connect.statement.executeQuery(query1);
            while (resultSet.next()){
                label3.setText("Card Number: XXXX-XXXX-XXXX-"+resultSet.getString("Card_No").substring(12));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            int balance=0;
            JDBCconnection connect = new JDBCconnection();
            ResultSet resultSet = connect.statement.executeQuery("SELECT * FROM bank WHERE PIN = '"+pin+"'");
            while (resultSet.next()){
                String type = resultSet.getString("Type");
                String space = "";
                if(type.equals("Deposit")){
                    space = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
                } else if (type.equals("Withdraw")) {
                    space = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
                }
                label1.setText(label1.getText()+"<html>"+resultSet.getString("Date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+type+space+resultSet.getString("Amount")+"<br><html>");
                if(resultSet.getString("Type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("Amount"));
                }else{
                    balance -= Integer.parseInt(resultSet.getString("Amount"));
                }
            }
            label4.setText("Your Total Balance is Rs. "+balance);

        }catch (Exception e){
            e.printStackTrace();
        }

        Close = new JButton("CLOSE");
        Close.setBackground(Color.BLACK);
        Close.setForeground(Color.ORANGE);
        Close.setFont(new Font("Arial",Font.BOLD,13));
        Close.setBounds(200,490,80,30);
        Close.addActionListener(this);
        add(Close);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);

    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
