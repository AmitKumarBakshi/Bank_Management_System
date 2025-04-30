package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    String pin;
    JTextField amount;
    JButton WithdrawB,BackB;
    Withdraw(String pass_pin){
        this.pin=pass_pin;
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

        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS RS. 15,000");
        label1.setBounds(390,130,400,35);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setForeground(new Color(75,198,255));
        Machine.add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setBounds(375,170,400,35);
        label2.setFont(new Font("System",Font.BOLD,14));
        label2.setForeground(new Color(146, 219, 37));
        Machine.add(label2);

        amount = new JTextField();
        amount.setBounds(375,200,315,25);
        amount.setFont(new Font("System",Font.BOLD,16));
        amount.setBackground(new Color(137, 141, 152, 207));
        amount.setForeground(Color.white);
        Machine.add(amount);

        WithdrawB = new JButton("WITHDRAW");
        WithdrawB.setBounds(660,302,125,26);
        WithdrawB.setFont(new Font("System",Font.BOLD,16));
        WithdrawB.setBackground(new Color(0));
        WithdrawB.setForeground(new Color(0, 255, 0));
        WithdrawB.addActionListener(this);
        Machine.add(WithdrawB);

        BackB = new JButton("BACK");
        BackB.setBounds(660,343,125,26);
        BackB.setFont(new Font("System",Font.BOLD,16));
        BackB.setBackground(new Color(0));
        BackB.setForeground(new Color(237, 103, 7));
        BackB.addActionListener(this);
        Machine.add(BackB);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String Amount = amount.getText();
            Date date = new Date();
            if(e.getSource()==WithdrawB){
            if (amount.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Withdrawal Amount");
                return;
            }if(Integer.parseInt(Amount)>15000){
                JOptionPane.showMessageDialog(null,"Maximum Withdrawal Amount is Rs. 15000");
                return;
                }

            else {
                JDBCconnection connect = new JDBCconnection();
                String query = "SELECT * FROM bank WHERE PIN = '" + pin + "'";
                ResultSet resultSet = connect.statement.executeQuery(query);
                int balance = 0;
                while (resultSet.next()) {
                    if (resultSet.getString("Type").equals("Deposit")) {
                        balance = balance + Integer.parseInt(resultSet.getString("Amount"));
                    } else {
                        balance = balance - Integer.parseInt(resultSet.getString("Amount"));
                    }
                }
                if (balance < Integer.parseInt(Amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                connect.statement.executeUpdate("insert into bank values('" + pin + "','" + date + "','Withdraw','" + Amount + "')");
                JOptionPane.showMessageDialog(null, "Rs. " + Amount + " Withdraw Successfully");
                new Transaction(pin);
                setVisible(false);

            }
        }else if(e.getSource()==BackB){
                setVisible(false);
                new Transaction(pin);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}
