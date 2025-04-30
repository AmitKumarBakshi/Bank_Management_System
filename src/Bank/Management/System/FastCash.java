package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton rs10000,rs5000,rs500,rs100,rs2000,rs1000,BackB;
    String pin;
    FastCash(String pin){
        setLayout(null);
        setSize(1370,730);
        setLocation(0,0);
        setUndecorated(true);

        this.pin = pin;

        ImageIcon ATM = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image ATM_set = ATM.getImage().getScaledInstance(1363,690,Image.SCALE_DEFAULT);
        ImageIcon ATM_final = new ImageIcon(ATM_set);
        JLabel Machine = new JLabel(ATM_final);
        Machine.setBounds(0,0,1363,690);
        add(Machine);

        JLabel label1 = new JLabel("SELECT YOUR WITHDRAWAL AMOUNT");
        label1.setBounds(375,130,400,35);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setForeground(new Color(75,198,255));
        Machine.add(label1);

        rs2000 = new JButton("Rs. 2000");
        rs2000.setBounds(615,225,170,26);
        rs2000.setFont(new Font("System",Font.BOLD,14));
        rs2000.setBackground(new Color(0));
        rs2000.setForeground(new Color(0, 255, 0));
        rs2000.addActionListener(this);
        Machine.add(rs2000);

        rs5000 = new JButton("Rs. 5000");
        rs5000.setBounds(615,264,170,26);
        rs5000.setFont(new Font("System",Font.BOLD,14));
        rs5000.setBackground(new Color(0));
        rs5000.setForeground(new Color(0, 255, 0));
        rs5000.addActionListener(this);
        Machine.add(rs5000);

        rs10000 = new JButton("Rs. 10000");
        rs10000.setBounds(615,303,170,26);
        rs10000.setFont(new Font("System",Font.BOLD,14));
        rs10000.setBackground(new Color(0));
        rs10000.setForeground(new Color(0, 255, 0));
        rs10000.addActionListener(this);
        Machine.add(rs10000);

        BackB = new JButton("BACK");
        BackB.setBounds(615,342,170,26);
        BackB.setFont(new Font("System",Font.BOLD,14));
        BackB.setBackground(new Color(0));
        BackB.setForeground(new Color(237, 103, 7));
        BackB.addActionListener(this);
        Machine.add(BackB);

        rs100 = new JButton("Rs. 100");
        rs100.setBounds(295,225,170,26);
        rs100.setFont(new Font("System",Font.BOLD,14));
        rs100.setBackground(new Color(0));
        rs100.setForeground(new Color(0, 255, 0));
        rs100.addActionListener(this);
        Machine.add(rs100);

        rs500 = new JButton("Rs. 500");
        rs500.setBounds(295,264,170,26);
        rs500.setFont(new Font("System",Font.BOLD,14));
        rs500.setBackground(new Color(0));
        rs500.setForeground(new Color(0, 255, 0));
        rs500.addActionListener(this);
        Machine.add(rs500);

        rs1000 = new JButton("Rs. 1000");
        rs1000.setBounds(295,303,170,26);
        rs1000.setFont(new Font("System",Font.BOLD,14));
        rs1000.setBackground(new Color(0));
        rs1000.setForeground(new Color(0, 255, 0));
        rs1000.addActionListener(this);
        Machine.add(rs1000);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==BackB){
            setVisible(false);
            new Transaction(pin);
        }else{
            String Amount = ((JButton)e.getSource()).getText().substring(4);
            JDBCconnection connect = new JDBCconnection();
            Date date = new Date();
            try {
                ResultSet resultSet = connect.statement.executeQuery("SELECT * FROM bank WHERE PIN = '"+pin+"'");
                int balance =0;
                while (resultSet.next()){
                    if(resultSet.getString("Type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("Amount"));
                    }else{
                        balance -= Integer.parseInt(resultSet.getString("Amount"));
                    }
                }
                //String num = "17";

                if(e.getSource() != BackB && balance < Integer.parseInt(Amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                connect.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdraw','"+Amount+"') ");
                JOptionPane.showMessageDialog(null, "Rs. " + Amount + " Withdraw Successfully");
            }catch (Exception E){
                E.printStackTrace();
            }

            setVisible(false);
            new Transaction(pin);
        }


    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
