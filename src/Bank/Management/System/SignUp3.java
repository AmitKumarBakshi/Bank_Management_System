package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp3 extends JFrame implements ActionListener {

    JComboBox accDrop;
    JCheckBox CB1,CB2,CB3,CB4,CB5,CB6;
    JButton submit,cancel;
    String formNo;

    SignUp3(String formNo){
        super("APPLICATION FORM");

        setLayout(null);
        setSize(680,700);
        setLocation(340,25);
        setUndecorated(true);
        getContentPane().setBackground(new Color(174, 205, 199, 255));

        ImageIcon BLogo = new ImageIcon(ClassLoader.getSystemResource("icons/logo2.png"));
        Image BLogo_set = BLogo.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon BLogo_final = new ImageIcon(BLogo_set);
        JLabel Icon = new JLabel(BLogo_final);
        Icon.setBounds(30,5,100,100);
        add(Icon);

        this.formNo=formNo;

        JLabel label0 = new JLabel("Form No.");
        label0.setBounds(525,10,80,30);
        label0.setFont(new Font("Raleway",Font.BOLD, 14));
        add(label0);

        JLabel fNo = new JLabel(formNo);
        fNo.setBounds(590,10,80,30);
        fNo.setFont(new Font("Raleway",Font.BOLD, 14));
        add(fNo);

        JLabel label1 = new JLabel("Page 3");
        label1.setBounds(200,30,600,30);
        label1.setFont(new Font("Raleway",Font.BOLD, 18));
        add(label1);

        JLabel label2= new JLabel("Account Details");
        label2.setBounds(200,60,600,30);
        label2.setFont(new Font("Raleway",Font.BOLD,18));
        add(label2);

        JLabel label3= new JLabel("Account Type:");
        label3.setBounds(100,140,600,30);
        label3.setFont(new Font("Raleway",Font.BOLD,18));
        add(label3);

        String accType[]={"Saving Account","Fixed Deposit", "Current Account", "Recurring Deposit"};
        accDrop = new JComboBox(accType);
        accDrop.setBounds(300,140,200,30);
        accDrop.setFont(new Font("Raleway",Font.BOLD,14));
        add(accDrop);

        JLabel label4= new JLabel("Cad Number:");
        label4.setBounds(100,200,200,30);
        label4.setFont(new Font("Raleway",Font.BOLD,18));
        add(label4);

        JLabel label5= new JLabel("(Your 16-digit Card number)");
        label5.setBounds(100,220,200,30);
        label5.setFont(new Font("Raleway",Font.BOLD,12));
        add(label5);

        JLabel label6= new JLabel("XXXX-XXXX-XXXX-3769");
        label6.setBounds(300,200,200,30);
        label6.setFont(new Font("Raleway",Font.BOLD,16));
        add(label6);

        JLabel label7= new JLabel("It would appear on ATM Card/Cheque Book & Statements");
        label7.setBounds(300,220,350,30);
        label7.setFont(new Font("Raleway",Font.BOLD,12));
        add(label7);

        JLabel label8= new JLabel("PIN:");
        label8.setBounds(100,280,200,30);
        label8.setFont(new Font("Raleway",Font.BOLD,18));
        add(label8);

        JLabel label9= new JLabel("(4-digit password)");
        label9.setBounds(100,300,200,30);
        label9.setFont(new Font("Raleway",Font.BOLD,12));
        add(label9);

        JLabel label10= new JLabel("XXXX");
        label10.setBounds(300,280,200,30);
        label10.setFont(new Font("Raleway",Font.BOLD,16));
        add(label10);

        JLabel label11= new JLabel("Services Required:");
        label11.setBounds(100,360,200,30);
        label11.setFont(new Font("Raleway",Font.BOLD,18));
        add(label11);

        CB1 = new JCheckBox("ATM Card");
        CB1.setBounds(105,400,100,30);
        CB1.setFont(new Font("Raleway",Font.BOLD,14));
        CB1.setBackground(new Color(174, 205, 199));
        add(CB1);

        CB2 = new JCheckBox("Internet Banking");
        CB2.setBounds(105,440,200,30);
        CB2.setFont(new Font("Raleway",Font.BOLD,14));
        CB2.setBackground(new Color(174, 205, 199));
        add(CB2);

        CB3 = new JCheckBox("Mobile Banking");
        CB3.setBounds(105,480,200,30);
        CB3.setFont(new Font("Raleway",Font.BOLD,14));
        CB3.setBackground(new Color(174, 205, 199));
        add(CB3);

        CB4 = new JCheckBox("Cheque Book");
        CB4.setBounds(335,400,300,30);
        CB4.setFont(new Font("Raleway",Font.BOLD,14));
        CB4.setBackground(new Color(174, 205, 199));
        add(CB4);

        CB5 = new JCheckBox("E-Statement");
        CB5.setBounds(335,440,300,30);
        CB5.setFont(new Font("Raleway",Font.BOLD,14));
        CB5.setBackground(new Color(174, 205, 199));
        add(CB5);

        CB6 = new JCheckBox("Email Alerts");
        CB6.setBounds(335,480,300,30);
        CB6.setFont(new Font("Raleway",Font.BOLD,14));
        CB6.setBackground(new Color(174, 205, 199));
        add(CB6);

        JCheckBox CB7 = new JCheckBox("All the information provided above are true and best to my knowledge",true);
        CB7.setBounds(100,550,900,20);
        CB7.setFont(new Font("Raleway",Font.BOLD,14));
        CB7.setBackground(new Color(174, 205, 199));
        add(CB7);

        cancel = new JButton("Cancel");
        cancel.setBounds(245,600,90,32);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setForeground(Color.red);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("Submit");
        submit.setBounds(355,600,90,32);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setForeground(Color.green);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String acc_Type = (String) accDrop.getSelectedItem();

        Random random = new Random();
        long first7 = (random.nextLong()%90000000L)+1624408000000000L;
        String card_no = ""+Math.abs(first7);

        long first3 = (random.nextLong()%9000L)+1000L;
        String pass_pin = ""+Math.abs(first3);

        String services ="";
        if(CB1.isSelected()){
            services= services+"ATM Card, ";
        }  if (CB2.isSelected()) {
            services= services+"Internet Banking, ";
        }  if (CB3.isSelected()) {
            services= services+"Mobile Banking, ";
        }  if (CB4.isSelected()) {
            services = services+"Cheque Book, ";
        }  if (CB5.isSelected()) {
            services = services+"Cheque Book, ";
        }  if (CB6.isSelected()) {
            services = services+"Email Alerts, ";
        }

        try{
            if(e.getSource()==submit){
                if (accDrop.equals("")){
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                }
                else{
                    JDBCconnection connect = new JDBCconnection();
                    String query1 = "insert into signUpthree values('"+formNo+"','"+acc_Type+"','"+card_no+"','"+pass_pin+"','"+services+"')";
                    String query2 = "insert into login values('"+formNo+"','"+card_no+"','"+pass_pin+"')";
                    connect.statement.executeUpdate(query1);
                    connect.statement.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number: "+card_no+"\nPIN Number: "+pass_pin);
                    new Deposit(pass_pin);
                    setVisible(false);
                }
            } else if (e.getSource()==cancel) {
                System.exit(0);
            }


        } catch (Exception E) {
            E.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new SignUp3("");
    }
}
