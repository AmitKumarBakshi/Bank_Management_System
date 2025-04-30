package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp2 extends JFrame implements ActionListener {
    String formNo;
    JComboBox dropDown1,dropDown2,dropDown3,dropDown4,dropDown5,dropDown6;
    JTextField pan,aadhar;
    JRadioButton citizenButtonY,citizenButtonN,accountButtonN,accountButtonY;
    JButton next;

    SignUp2(String formNo){
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

        JLabel label1 = new JLabel("Page 2");
        label1.setBounds(200,30,600,30);
        label1.setFont(new Font("Raleway",Font.BOLD, 18));
        add(label1);

        JLabel label2= new JLabel("Additional Details");
        label2.setBounds(200,60,600,30);
        label2.setFont(new Font("Raleway",Font.BOLD,18));
        add(label2);

        JLabel label3= new JLabel("Religion");
        label3.setBounds(150,140,600,30);
        label3.setFont(new Font("Raleway",Font.BOLD,16));
        add(label3);

        String religion[]={"Hinduism","Christianity", "Islam", "Buddhism", "Sikhism", "Judaism","Shintoism","Other"};
        dropDown1 = new JComboBox(religion);
        dropDown1.setBounds(325,140,200,30);
        dropDown1.setFont(new Font("Raleway",Font.BOLD,14));
        add(dropDown1);

        JLabel label4= new JLabel("Category");
        label4.setBounds(150,190,600,30);
        label4.setFont(new Font("Raleway",Font.BOLD,16));
        add(label4);

        String category[]={"General","OBC", "SC", "ST","Other"};
        dropDown2 = new JComboBox(category);
        dropDown2.setBounds(325,190,200,30);
        dropDown2.setFont(new Font("Raleway",Font.BOLD,14));
        add(dropDown2);

        JLabel label5= new JLabel("Income");
        label5.setBounds(150,240,600,30);
        label5.setFont(new Font("Raleway",Font.BOLD,16));
        add(label5);

        String income[]={"0","<1 lack", "<2 lacks", "<5 lacks","Upto 10 lacks","Above 10 lacks"};
        dropDown3 = new JComboBox(income);
        dropDown3.setBounds(325,240,200,30);
        dropDown3.setFont(new Font("Raleway",Font.BOLD,14));
        add(dropDown3);

        JLabel label6= new JLabel("Education");
        label6.setBounds(150,290,600,30);
        label6.setFont(new Font("Raleway",Font.BOLD,16));
        add(label6);

        String education[]={"Secondary","Senior Secondary", "Undergraduate", "Postgraduate","Doctorate","Postdoctoral","Other"};
        dropDown4 = new JComboBox(education);
        dropDown4.setBounds(325,290,200,30);
        dropDown4.setFont(new Font("Raleway",Font.BOLD,14));
        add(dropDown4);

        JLabel label7= new JLabel("Occupation");
        label7.setBounds(150,340,600,30);
        label7.setFont(new Font("Raleway",Font.BOLD,16));
        add(label7);

        String occupation[]={"Student","Unemployed", "Self-employed", "Business","Retired","Part-time Worker","Other"};
        dropDown5 = new JComboBox(occupation);
        dropDown5.setBounds(325,340,200,30);
        dropDown5.setFont(new Font("Raleway",Font.BOLD,14));
        add(dropDown5);

        JLabel citizen = new JLabel("Senior Citizen");
        citizen.setBounds(150,390,200,30);
        citizen.setFont(new Font("Raleway",Font.BOLD,16));
        add(citizen);

        citizenButtonY = new JRadioButton("YES");
        citizenButtonY.setBounds(325,390,60,30);
        citizenButtonY.setBackground(new Color(174, 205, 199));
        citizenButtonY.setFont(new Font("Raleway",Font.BOLD,14));
        add(citizenButtonY);

        citizenButtonN = new JRadioButton("NO");
        citizenButtonN.setBounds(400,390,60,30);
        citizenButtonN.setBackground(new Color(174, 205, 199));
        citizenButtonN.setFont(new Font("Raleway",Font.BOLD,14));
        add(citizenButtonN);

        ButtonGroup citizenbuttonGroup = new ButtonGroup();
        citizenbuttonGroup = new ButtonGroup();
        citizenbuttonGroup.add(citizenButtonY);
        citizenbuttonGroup.add(citizenButtonN);

        JLabel ExAccount = new JLabel("Existing Account");
        ExAccount.setBounds(150,440,200,30);
        ExAccount.setFont(new Font("Raleway",Font.BOLD,16));
        add(ExAccount);

        accountButtonY = new JRadioButton("YES");
        accountButtonY.setBounds(325,440,60,30);
        accountButtonY.setBackground(new Color(174, 205, 199));
        accountButtonY.setFont(new Font("Raleway",Font.BOLD,14));
        add(accountButtonY);

        accountButtonN = new JRadioButton("NO");
        accountButtonN.setBounds(400,440,60,30);
        accountButtonN.setBackground(new Color(174, 205, 199));
        accountButtonN.setFont(new Font("Raleway",Font.BOLD,14));
        add(accountButtonN);

        ButtonGroup ExAccountbuttonGroup = new ButtonGroup();
        ExAccountbuttonGroup = new ButtonGroup();
        ExAccountbuttonGroup.add(accountButtonY);
        ExAccountbuttonGroup.add(accountButtonN);

        JLabel panNo = new JLabel("PAN Number");
        panNo.setBounds(150,490,200,30);
        panNo.setFont(new Font("Raleway",Font.BOLD,16));
        add(panNo);

        pan = new JTextField();
        pan.setBounds(325,490,200,30);
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        add(pan);

        JLabel adharNo = new JLabel("Aadhar Number");
        adharNo.setBounds(150,540,200,30);
        adharNo.setFont(new Font("Raleway",Font.BOLD,16));
        add(adharNo);

        aadhar = new JTextField();
        aadhar.setBounds(325,540,200,30);
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        add(aadhar);

        next = new JButton("Next");
        next.setBounds(442,580,80,32);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setForeground(Color.green);
        next.setBackground(Color.BLACK);
        next.addActionListener(this);
        add(next);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //String FR_No = formNo;
        String rel = (String) dropDown1.getSelectedItem();
        String cat = (String) dropDown2.getSelectedItem();
        String inc = (String) dropDown3.getSelectedItem();
        String edu = (String) dropDown4.getSelectedItem();
        String occ = (String) dropDown5.getSelectedItem();
        String sen_citi = null;
        if (citizenButtonY.isSelected()){
            sen_citi = "Yes";
        }
        else if(citizenButtonN.isSelected()){
            sen_citi = "No";
        }

        String ex_acc = null;
        if (accountButtonY.isSelected()){
            ex_acc = "Yes";
        }
        else if(accountButtonN.isSelected()){
            ex_acc = "No";
        }

        String Pan = pan.getText();
        String Aadhar = aadhar.getText();

        try{
            if(pan.getText().equals("") || aadhar.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all fields");
            }
            else{
                JDBCconnection connect = new JDBCconnection();
                String query = "insert into signUptwo values('"+formNo+"','"+rel+"','"+cat+"','"+inc+"','"+edu+"','"+occ+"','"+sen_citi+"','"+ex_acc+"','"+Pan+"','"+Aadhar+"')";
                connect.statement.executeUpdate(query);
                new SignUp3(formNo);
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }


    }

    public static void main(String[] args) {

        new SignUp2("");
    }
}
