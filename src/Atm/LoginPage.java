package Atm;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
public class LoginPage extends JFrame implements ActionListener {
    JButton b1,b2,b3;
    JTextField CR_text;
    JPasswordField Pin_text;
    LoginPage(){
        setLayout(null);
        setTitle("AUTOMATED TELLER MACHINE");
        // Logo icon set..
        String imagePath = "src\\Atm\\logo.jpg" ;
        ImageIcon i1 = new ImageIcon(imagePath);
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);


        //Add the text..
        JLabel l1 = new JLabel("Welcome To ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(200,40,450,40);
        add(l1);


        // Add card no component
        JLabel l2 = new JLabel("Card No");
        l2.setFont(new Font("Osward", Font.BOLD, 28));
        l2.setBounds(125,150,375,30);
        add(l2);
        //Add card no texfield
        CR_text = new JTextField(15);
        CR_text.setBounds(300,150,230,30);
        CR_text.setFont(new Font("Arial", Font.BOLD, 14));
        add(CR_text);

        //Add Pin component
        JLabel l3 = new JLabel("PIN");
        l3.setFont(new Font("Osward", Font.BOLD, 28));
        l3.setBounds(125,220,375,30);
        add(l3);
        //Add textfield for Pin
        Pin_text = new JPasswordField(15);
        Pin_text.setBounds(300, 220, 230, 30);
        Pin_text.setFont(new Font("Arial", Font.BOLD, 14));
        add(Pin_text);

        //creat button

        //add sign in button
        b1 = new JButton("SIGN IN");
        b1.setBounds(300,300,100,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
       //
        b1.addActionListener(this);
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        add(b1);

        //add sign up button
        b2 = new JButton("SIGN UP");
        b2.setBounds(430,300,100,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        add(b2);


        //add clear button
        b3 = new JButton("CLEAR");
        b3.setBounds(300,350,230,30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        add(b3);



        setSize(800, 480);
        setVisible(true);
        setLocation(550, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
    }

    //This method use to activate the button
    public void actionPerformed(ActionEvent ae)
    {
        //this if is used for clear button
        if(ae.getSource()==b3){
            CR_text.setText("");
            Pin_text.setText("");
        }
        else if(ae.getSource()==b2){
            setVisible(false);//login close
            new signup1().setVisible(true);//signup open
        } else if (ae.getSource()==b1) {
            conn cn=new conn();
            String card=CR_text.getText();
            String pin=Pin_text.getText();
            String q="(Select * from login where card_no='"+card+"' and pin_no ='"+pin+"')";
            try {
                ResultSet rs=cn.s.executeQuery(q);
                if(rs.next())
                {
                    setVisible(false);
                    new transaction(pin).setVisible(true);

                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect Card number or PIN");
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }



        }
    }
}

