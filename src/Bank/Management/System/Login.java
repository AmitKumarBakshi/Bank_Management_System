package Bank.Management.System;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel label1,label2,label3,label4;    //globally declare
    JTextField card_No;
    JPasswordField password1;
    JButton signup,signin,clear;

    Login(){
        super("Bank of Baroda");

        setLayout(null);
        setSize(850,480);
        setLocation(300,150);
        setUndecorated(true);

        ImageIcon BLogo = new ImageIcon(ClassLoader.getSystemResource("icons/bank_logo.png"));
        Image BLogo_set = BLogo.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon BLogo_final = new ImageIcon(BLogo_set);
        JLabel Icon = new JLabel(BLogo_final);
        Icon.setBounds(368,5,100,100);
        add(Icon);

        ImageIcon card = new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));
        Image card_set = card.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
        ImageIcon card_final = new ImageIcon(card_set);
        JLabel card_Icon = new JLabel(card_final);
        card_Icon.setBounds(120,394,100,100);
        add(card_Icon);

        ImageIcon BN = new ImageIcon(ClassLoader.getSystemResource("icons/logo1.png"));
        Image BN_set = BN.getImage().getScaledInstance(100,30,Image.SCALE_DEFAULT);
        ImageIcon BN_final = new ImageIcon(BN_set);
        JLabel BN_Icon = new JLabel(BN_final);
        BN_Icon.setBounds(20,0,100,100);
        add(BN_Icon);

        ImageIcon UPI = new ImageIcon(ClassLoader.getSystemResource("icons/UPI.png"));
        Image UPI_set = UPI.getImage().getScaledInstance(100,40,Image.SCALE_DEFAULT);
        ImageIcon UPI_final = new ImageIcon(UPI_set);
        JLabel UPI_Icon = new JLabel(UPI_final);
        UPI_Icon.setBounds(425,395,100,100);
        add(UPI_Icon);

        label1 = new JLabel("WELCOME TO BOB WORLD");
        label1.setForeground(Color.orange);
        label1.setFont(new Font("AvantGarde",Font.BOLD,32));
        label1.setBounds(210,125,450,40);
        add(label1);

        label2 = new JLabel("Card No.");
        label2.setForeground(Color.white);
        label2.setFont(new Font("Railway",Font.BOLD,24));
        label2.setBounds(210,185,450,40);
        add(label2);

        card_No = new JTextField(15);
        card_No.setBounds(325,190,230,30);
        card_No.setFont(new Font("AvantGarde",Font.BOLD,14));
        add(card_No);

        label3 = new JLabel("PIN ");
        label3.setForeground(Color.white);
        label3.setFont(new Font("Railway",Font.BOLD,24));
        label3.setBounds(210,245,450,40);
        add(label3);

        label4 = new JLabel("Powered by | ");
        label4.setForeground(Color.gray);
        label4.setFont(new Font("AvantGarde",Font.ITALIC,12));
        label4.setBounds(350,418,450,50);
        add(label4);

        password1 = new JPasswordField(15);
        password1.setBounds(325,250,230,30);
        password1.setFont(new Font("AvantGarde",Font.BOLD,14));
        add(password1);

        signin = new JButton("SIGN IN");
        signin.setBackground(Color.black);
        signin.setForeground(Color.BLUE);
        signin.setFont(new Font("Arial",Font.BOLD,12));
        signin.setBounds(350,300,75,25);
        signin.addActionListener(this);
        add(signin);

        clear = new JButton("CLEAR");
        clear.setBackground(Color.black);
        clear.setForeground(Color.red);
        clear.setFont(new Font("Arial",Font.BOLD,12));
        clear.setBounds(450,300,75,25);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.green);
        signup.setFont(new Font("Arial",Font.BOLD,12));
        signup.setBounds(350,340,175,25);
        signup.addActionListener(this);
        add(signup);

        ImageIcon BG = new ImageIcon(ClassLoader.getSystemResource("icons/Banner.png"));
        Image BG_set = BG.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon BG_final = new ImageIcon(BG_set);
        JLabel BG_Icon = new JLabel(BG_final);
        BG_Icon.setBounds(0,0,850,480);
        add(BG_Icon);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==signin){
                JDBCconnection connect = new JDBCconnection();
                String cardNo = card_No.getText();
                String pinNo = password1.getText();
                String query = "SELECT * FROM login WHERE Card_No = '"+cardNo+"' AND PIN_No = '"+pinNo+"'";
                ResultSet resultSet = connect.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new Transaction(pinNo);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card No. and PIN");
                }

            }
            else if(e.getSource()==clear){
                card_No.setText("");
                password1.setText("");
            }
            else if(e.getSource()==signup){
                new SignUp();
                setVisible(false);
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
