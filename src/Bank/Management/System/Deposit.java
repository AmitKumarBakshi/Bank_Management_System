package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pass_pin;
    JTextField amount;
    JButton DepositB,BackB;
    Deposit(String pass_pin){
        this.pass_pin=pass_pin;
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

        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setBounds(375,130,400,35);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setForeground(new Color(75,198,255));
        Machine.add(label1);

        JLabel label2 = new JLabel("Minimum Amount to Deposit is Rs. 500");
        label2.setBounds(375,160,400,35);
        label2.setFont(new Font("System",Font.BOLD,14));
        label2.setForeground(new Color(146, 219, 37));
        Machine.add(label2);

        amount = new JTextField();
        amount.setBounds(375,190,315,30);
        amount.setFont(new Font("System",Font.BOLD,16));
        amount.setBackground(new Color(137, 141, 152, 207));
        amount.setForeground(Color.white);
        Machine.add(amount);

        DepositB = new JButton("DEPOSIT");
        DepositB.setBounds(675,302,105,26);
        DepositB.setFont(new Font("System",Font.BOLD,16));
        DepositB.setBackground(new Color(0));
        DepositB.setForeground(new Color(0, 255, 0));
        DepositB.addActionListener(this);
        Machine.add(DepositB);

        BackB = new JButton("BACK");
        BackB.setBounds(675,343,105,26);
        BackB.setFont(new Font("System",Font.BOLD,16));
        BackB.setBackground(new Color(0));
        BackB.setForeground(new Color(237, 103, 7));
        BackB.addActionListener(this);
        Machine.add(BackB);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Amount = amount.getText();
        Date date = new Date();
        try{
            if(e.getSource()==DepositB){
                if (amount.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter Your Amount");
                    return;
                }
                if (Integer.parseInt(Amount)<500) {
                    JOptionPane.showMessageDialog(null,"Minimum Deposit Amount is Rs. 500");
                    return;
                }
                else {
                    JDBCconnection conn = new JDBCconnection();
                    String query = "insert into bank values('"+pass_pin+"','"+date+"','Deposit','"+Amount+"')";
                    conn.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs. "+Amount+" Deposit Successfully");
                    new Transaction(pass_pin);
                    setVisible(false);
                }
            } if (e.getSource()==BackB) {
                setVisible(false);
                new Transaction(pass_pin);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposit("");

    }
}
