package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePin extends JFrame implements ActionListener {
    JButton ChangeB,BackB;
    JPasswordField newPIN,reenterPIN;
    String pin;
    ChangePin(String pin){
        setLayout(null);
        setSize(1370,730);
        setLocation(0,0);
        setUndecorated(true);

        this.pin=pin;

        ImageIcon ATM = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image ATM_set = ATM.getImage().getScaledInstance(1363,690,Image.SCALE_DEFAULT);
        ImageIcon ATM_final = new ImageIcon(ATM_set);
        JLabel Machine = new JLabel(ATM_final);
        Machine.setBounds(0,0,1363,690);
        add(Machine);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setBounds(450,130,200,35);
        label1.setFont(new Font("System",Font.BOLD,18));
        label1.setForeground(new Color(75,198,255));
        Machine.add(label1);

        JLabel label2 = new JLabel("New PIN");
        label2.setBounds(380,170,400,35);
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setForeground(new Color(146, 219, 37));
        Machine.add(label2);

        newPIN = new JPasswordField();
        newPIN.setBounds(380,200,250,25);
        newPIN.setFont(new Font("System",Font.BOLD,16));
        newPIN.setBackground(new Color(137, 141, 152, 207));
        newPIN.setForeground(Color.black);
        Machine.add(newPIN);

        JLabel label3 = new JLabel("Confirm New PIN");
        label3.setBounds(380,225,400,35);
        label3.setFont(new Font("System",Font.BOLD,16));
        label3.setForeground(new Color(146, 219, 37));
        Machine.add(label3);

        reenterPIN = new JPasswordField();
        reenterPIN.setBounds(380,255,250,25);
        reenterPIN.setFont(new Font("System",Font.BOLD,16));
        reenterPIN.setBackground(new Color(137, 141, 152, 207));
        reenterPIN.setForeground(Color.black);
        Machine.add(reenterPIN);


        ChangeB = new JButton("CHANGE");
        ChangeB.setBounds(675,302,105,26);
        ChangeB.setFont(new Font("System",Font.BOLD,16));
        ChangeB.setBackground(new Color(0,0,0));
        ChangeB.setForeground(new Color(255, 215, 0));
        ChangeB.addActionListener(this);
        Machine.add(ChangeB);

        BackB = new JButton("BACK");
        BackB.setBounds(675,343,105,26);
        BackB.setFont(new Font("System",Font.BOLD,16));
        BackB.setBackground(new Color(0,0,0));
        BackB.setForeground(new Color(237, 103, 7));
        BackB.addActionListener(this);
        Machine.add(BackB);



        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String PIN1 = newPIN.getText();
            String PIN2 = reenterPIN.getText();
            if(!PIN1.equals(PIN2)){
                JOptionPane.showMessageDialog(null,"Does't match the PIN");
                return;
            }
            if(e.getSource()==ChangeB){
                if(PIN1.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter new PIN");
                    return;
                }
                if(PIN2.equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter new PIN");
                    return;
                }

                JDBCconnection connect = new JDBCconnection();
                String query1 = "UPDATE bank SET PIN = '"+PIN1+"' WHERE PIN = '"+pin+"'";
                String query2 = "UPDATE login SET PIN_No = '"+PIN1+"' WHERE PIN_No = '"+pin+"'";
                String query3 = "UPDATE signupthree SET PIN_No = '"+PIN1+"' WHERE PIN_No = '"+pin+"'";

                connect.statement.executeUpdate(query1);
                connect.statement.executeUpdate(query2);
                connect.statement.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN Change Successfully");
                setVisible(false);
                new Transaction(pin);
            } else if (e.getSource()==BackB) {
                new Transaction(pin);
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChangePin("");
    }
}
