package Bank.Management.System;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener {

    Random APPLICATION_NO =new Random();
    long number =(APPLICATION_NO.nextLong()%9000L)+1000L;
    String random_no = " "+Math.abs(number);

    JTextField textname,fathername,Phone,Email,address,cityname,statename,pincode;
    JDateChooser dateChooser;
    JRadioButton MButton,FButton,OButton,marriageButton,UmarriageButton,OmarriageButton;
    JButton next,clear;
    ButtonGroup buttonGroup = new ButtonGroup();
    ButtonGroup MbuttonGroup = new ButtonGroup();

    SignUp(){

        super("APPLICATION FORM");

        setLayout(null);
        setSize(680,700);
        setLocation(340,25);
        setUndecorated(true);
        getContentPane().setBackground(new Color(247,246,166));

        ImageIcon BLogo = new ImageIcon(ClassLoader.getSystemResource("icons/logo2.png"));
        Image BLogo_set = BLogo.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon BLogo_final = new ImageIcon(BLogo_set);
        JLabel Icon = new JLabel(BLogo_final);
        Icon.setBounds(30,5,100,100);
        add(Icon);

        JLabel label1 = new JLabel("APPLICATION FORM NO."+random_no);
        label1.setBounds(160,25,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,32));
        label1.setForeground(Color.RED);
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setBounds(350,70,600,30);
        label2.setFont(new Font("Raleway",Font.BOLD, 20));
        add(label2);

        JLabel label3= new JLabel("Personal Details");
        label3.setBounds(295,100,600,30);
        label3.setFont(new Font("Raleway",Font.BOLD,20));
        add(label3);

        JLabel name = new JLabel("NAME");
        name.setBounds(100,160,100,30);
        name.setFont(new Font("Raleway",Font.BOLD,20));
        add(name);

        textname = new JTextField();
        textname.setBounds(300,160,320,30);
        textname.setFont(new Font("Raleway",Font.BOLD,14));
        add(textname);

        JLabel Fname = new JLabel("FATHER NAME");
        Fname.setBounds(100,200,150,30);
        Fname.setFont(new Font("Raleway",Font.BOLD,20));
        add(Fname);

        fathername = new JTextField();
        fathername.setBounds(300,200,320,30);
        fathername.setFont(new Font("Raleway",Font.BOLD,14));
        add(fathername);

        JLabel dob = new JLabel("DATE OF BIRTH");
        dob.setBounds(100,240,200,30);
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,320,30);
        dateChooser.setForeground(new Color(204,229,255));
        add(dateChooser);

        JLabel gen = new JLabel("GENDER");
        gen.setBounds(100,280,200,30);
        gen.setFont(new Font("Raleway",Font.BOLD,20));
        add(gen);

        MButton = new JRadioButton("Male");
        MButton.setBounds(300,280,100,30);
        MButton.setBackground(new Color(247,246,166));
        MButton.setFont(new Font("Raleway",Font.BOLD,14));
        add(MButton);

        FButton = new JRadioButton("Female");
        FButton.setBounds(400,280,100,30);
        FButton.setBackground(new Color(247,246,166));
        FButton.setFont(new Font("Raleway",Font.BOLD,14));
        add(FButton);

        OButton = new JRadioButton("Other");
        OButton.setBounds(500,280,100,30);
        OButton.setBackground(new Color(247,246,166));
        OButton.setFont(new Font("Raleway",Font.BOLD,14));
        add(OButton);

        //ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup = new ButtonGroup();
        buttonGroup.add(MButton);
        buttonGroup.add(FButton);
        buttonGroup.add(OButton);

        JLabel emailAddress = new JLabel("Email Address");
        emailAddress.setBounds(100,320,200,30);
        emailAddress.setFont(new Font("Raleway",Font.BOLD,20));
        add(emailAddress);

        Email = new JTextField();
        Email.setBounds(300,320,320,30);
        Email.setFont(new Font("Raleway",Font.BOLD,14));
        add(Email);

        JLabel PH = new JLabel("PHONE NO.");
        PH.setBounds(100,360,200,30);
        PH.setFont(new Font("Raleway",Font.BOLD,20));
        add(PH);

        Phone = new JTextField();
        Phone.setBounds(300,360,320,30);
        Phone.setFont(new Font("Raleway",Font.BOLD,14));
        add(Phone);

        JLabel MStatus = new JLabel("MARITAL STATUS");
        MStatus.setBounds(100,400,200,30);
        MStatus.setFont(new Font("Raleway",Font.BOLD,20));
        add(MStatus);

        marriageButton = new JRadioButton("Marriage");
        marriageButton.setBounds(300,400,100,30);
        marriageButton.setBackground(new Color(247,246,166));
        marriageButton.setFont(new Font("Raleway",Font.BOLD,14));
        add(marriageButton);

        UmarriageButton = new JRadioButton("Unmarriage");
        UmarriageButton.setBounds(400,400,120,30);
        UmarriageButton.setBackground(new Color(247,246,166));
        UmarriageButton.setFont(new Font("Raleway",Font.BOLD,14));
        add(UmarriageButton);

        OmarriageButton = new JRadioButton("Others");
        OmarriageButton.setBounds(520,400,100,30);
        OmarriageButton.setBackground(new Color(247,246,166));
        OmarriageButton.setFont(new Font("Raleway",Font.BOLD,14));
        add(OmarriageButton);

        //ButtonGroup MbuttonGroup = new ButtonGroup();
        MbuttonGroup = new ButtonGroup();
        MbuttonGroup.add(marriageButton);
        MbuttonGroup.add(UmarriageButton);
        MbuttonGroup.add(OmarriageButton);

        JLabel Add = new JLabel("ADDRESS");
        Add.setBounds(100,440,200,30);
        Add.setFont(new Font("Raleway",Font.BOLD,20));
        add(Add);

        address = new JTextField();
        address.setBounds(300,440,320,30);
        address.setFont(new Font("Raleway",Font.BOLD,14));
        add(address);

        JLabel city = new JLabel("CITY");
        city.setBounds(100,480,200,30);
        city.setFont(new Font("Raleway",Font.BOLD,20));
        add(city);

        cityname = new JTextField();
        cityname.setBounds(300,480,320,30);
        cityname.setFont(new Font("Raleway",Font.BOLD,14));
        add(cityname);

        JLabel state = new JLabel("STATE");
        state.setBounds(100,520,200,30);
        state.setFont(new Font("Raleway",Font.BOLD,20));
        add(state);

        statename = new JTextField();
        statename.setBounds(300,520,320,30);
        statename.setFont(new Font("Raleway",Font.BOLD,14));
        add(statename);

        JLabel pin = new JLabel("PIN CODE");
        pin.setBounds(100,560,200,30);
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        add(pin);

        pincode = new JTextField();
        pincode.setBounds(300,560,320,30);
        pincode.setFont(new Font("Raleway",Font.BOLD,14));
        add(pincode);

        next = new JButton("Next");
        next.setBounds(540,600,80,32);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setForeground(Color.green);
        next.setBackground(Color.BLACK);
        next.addActionListener(this);
        add(next);

        clear = new JButton("Clear");
        clear.setBounds(450,600,80,32);
        clear.setFont(new Font("Raleway",Font.BOLD,14));
        clear.setForeground(Color.red);
        clear.setBackground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formNo = random_no;
        String name = textname.getText();
        String Fname = fathername.getText();
        String ph = Phone.getText();
        String email = Email.getText();
        String add = address.getText();
        String city = cityname.getText();
        String state = statename.getText();
        String pin = pincode.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (MButton.isSelected()){
            gender = "Male";
        }
        else if(FButton.isSelected()){
            gender = "Female";
        }else {
            gender = "Other";
        }
        String marriage = null;
        if(marriageButton.isSelected()){
            marriage = "Married";
        } else if (UmarriageButton.isSelected()) {
            marriage = "Unmarried";
        }else{
            marriage = "Others";
        }

        try{
            if (e.getSource()==clear) {
                textname.setText("");
                fathername.setText("");
                dateChooser.setDate(null);
                buttonGroup.clearSelection();
                MbuttonGroup.clearSelection();
                Phone.setText("");
                Email.setText("");
                address.setText("");
                cityname.setText("");
                statename.setText("");
                pincode.setText("");
                JOptionPane.showMessageDialog(null,"Clear all fields");
            }
            if(textname.getText().equals("") || fathername.getText().equals("") || Phone.getText().equals("") || Email.getText().equals("") || address.getText().equals("") || cityname.getText().equals("") || statename.getText().equals("") || pincode.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please fill all fields");
            }
            else if(e.getSource()==next){
                JDBCconnection connect = new JDBCconnection();
                String query = "insert into signUp values('"+formNo+"','"+name+"','"+Fname+"','"+dob+"','"+gender+"','"+email+"','"+ph+"','"+marriage+"','"+add+"','"+city+"','"+state+"','"+pin+"')";
                connect.statement.executeUpdate(query);
                new SignUp2(formNo);
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
