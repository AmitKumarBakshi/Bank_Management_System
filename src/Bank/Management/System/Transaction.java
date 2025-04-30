package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JButton DepositB,WithdrawB,MiniStatementB,BalenceEqB,FastcashB,PinchangeB,ExitB;
    String pinNo;
    Transaction(String pinNo){
        setLayout(null);
        setSize(1370,730);
        setLocation(0,0);
        setUndecorated(true);

        this.pinNo = pinNo;

        ImageIcon ATM = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image ATM_set = ATM.getImage().getScaledInstance(1363,690,Image.SCALE_DEFAULT);
        ImageIcon ATM_final = new ImageIcon(ATM_set);
        JLabel Machine = new JLabel(ATM_final);
        Machine.setBounds(0,0,1363,690);
        add(Machine);

        JLabel label1 = new JLabel("PLEASE SELECT YOUR TRANSACTION");
        label1.setBounds(375,130,400,35);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setForeground(new Color(75,198,255));
        Machine.add(label1);

        FastcashB = new JButton("FAST CASH");
        FastcashB.setBounds(615,225,170,26);
        FastcashB.setFont(new Font("System",Font.BOLD,14));
        FastcashB.setBackground(new Color(0));
        FastcashB.setForeground(new Color(0, 255, 0));
        FastcashB.addActionListener(this);
        Machine.add(FastcashB);

        WithdrawB = new JButton("WITHDRAW");
        WithdrawB.setBounds(615,264,170,26);
        WithdrawB.setFont(new Font("System",Font.BOLD,14));
        WithdrawB.setBackground(new Color(0));
        WithdrawB.setForeground(new Color(0, 255, 0));
        WithdrawB.addActionListener(this);
        Machine.add(WithdrawB);

        DepositB = new JButton("DEPOSIT");
        DepositB.setBounds(615,303,170,26);
        DepositB.setFont(new Font("System",Font.BOLD,14));
        DepositB.setBackground(new Color(0));
        DepositB.setForeground(new Color(0, 255, 0));
        DepositB.addActionListener(this);
        Machine.add(DepositB);

        ExitB = new JButton("EXIT");
        ExitB.setBounds(615,342,170,26);
        ExitB.setFont(new Font("System",Font.BOLD,14));
        ExitB.setBackground(new Color(0));
        ExitB.setForeground(new Color(255, 0, 0));
        ExitB.addActionListener(this);
        Machine.add(ExitB);

        BalenceEqB = new JButton("BALANCE ENQUIRY");
        BalenceEqB.setBounds(295,225,170,26);
        BalenceEqB.setFont(new Font("System",Font.BOLD,14));
        BalenceEqB.setBackground(new Color(0));
        BalenceEqB.setForeground(new Color(0, 255, 0));
        BalenceEqB.addActionListener(this);
        Machine.add(BalenceEqB);

        MiniStatementB = new JButton("MINI STATEMENT");
        MiniStatementB.setBounds(295,264,170,26);
        MiniStatementB.setFont(new Font("System",Font.BOLD,14));
        MiniStatementB.setBackground(new Color(0));
        MiniStatementB.setForeground(new Color(0, 255, 0));
        MiniStatementB.addActionListener(this);
        Machine.add(MiniStatementB);

        PinchangeB = new JButton("PIN CHANGE");
        PinchangeB.setBounds(295,303,170,26);
        PinchangeB.setFont(new Font("System",Font.BOLD,14));
        PinchangeB.setBackground(new Color(0));
        PinchangeB.setForeground(new Color(237, 103, 7));
        PinchangeB.addActionListener(this);
        Machine.add(PinchangeB);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==DepositB){
            new Deposit(pinNo);
            setVisible(false);
        } else if (e.getSource()==WithdrawB) {
            new Withdraw(pinNo);
            setVisible(false);
        } else if (e.getSource()==BalenceEqB) {
            new BalanceEnquiry(pinNo);
            setVisible(false);
        } else if (e.getSource()==FastcashB) {
            new FastCash(pinNo);
            setVisible(false);
        } else if (e.getSource()==PinchangeB) {
            new ChangePin(pinNo);
            setVisible(false);
        } else if (e.getSource()==MiniStatementB) {
            new MiniStatement(pinNo);
            setVisible(false);
        } else if (e.getSource() == ExitB) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
