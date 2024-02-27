package Atm;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signup3  extends  JFrame implements ActionListener {
    JRadioButton  r1, r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7,c8;
    String formno;
    JButton submit,cancel;
    signup3(String formno)
    {
        //Account Details
        this.formno = formno;
        setLayout(null);
        JLabel acc_details=new JLabel("Page 3:Account Details");
        acc_details.setFont(new Font("Raleway",Font.BOLD,22));
        acc_details.setBounds(280,40,400,40);
        add(acc_details);

        //Account type
        JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        //radio button for savings account
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,150,20);
        add(r1);
        //radio button for fixed diposit account
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,250,20);
        add(r2);
        //radio button for current account
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,250,20);
        add(r3);
        //radio button for recurring diposit account
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4);
        //Button group for account type
        ButtonGroup g_account=new ButtonGroup();
        g_account.add(r1);
        g_account.add(r2);
        g_account.add(r3);
        g_account.add(r4);
        //card number
        JLabel card=new JLabel("Card number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        //Jlabel for  16 digit atm card number (example)
        JLabel number=new JLabel("XXXX-XXXX-XXXX-XXXX");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);
        JLabel card_detail=new JLabel("Enter your 16 digit card number");
        card_detail.setFont(new Font("Raleway",Font.BOLD,12));
        card_detail.setBounds(100,330,300,20);
        add(card_detail);
        //pin
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        //Example of 4 digit password
        JLabel p_number=new JLabel("XXXX");
        p_number.setFont(new Font("Raleway",Font.BOLD,22));
        p_number.setBounds(330,370,300,30);
        add(p_number);
        //Jlabel for 4 digit password
        JLabel pin_detail=new JLabel("Enter your 4 digit password");
        pin_detail.setFont(new Font("Raleway",Font.BOLD,12));
        pin_detail.setBounds(100,400,300,20);
        add(pin_detail);
        //services required
        JLabel service_required=new JLabel("Services Required:");
        service_required.setFont(new Font("Raleway",Font.BOLD,22));
        service_required.setBounds(100,450,300,20);
        add(service_required);
        //checkbox for services required
        //checkbox1 for atm card
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        //checkbox2 for internet banking
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        //checkbox3 for mobile banking
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
        //checkbox 4 for email and sms alert
        c4=new JCheckBox("Email and SMS alert");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
        //checkbox 5 for cheque book
        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        //checkbox 6 for E-statement
        c6=new JCheckBox("E-statements");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
        //
        c7=new JCheckBox("I hereby declare that the above entered details are correct  ");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,680,600,30);
        add(c7);
        //
        c8=new JCheckBox("As per the Bank Norms, when you are creating a new account,you have to deposit a minimum amount of Rs 500  ");
        c8.setBackground(Color.WHITE);
        c8.setFont(new Font("Raleway",Font.BOLD,12));
        c8.setBounds(100,640,650,30);
        add(c8);
        //submit button
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);
        //cancel button
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
        //JFrame
        getContentPane().setBackground(Color.WHITE);
        setSize(850,820);
        setLocation(300,0);
        setVisible(true);
    }
    public  void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==submit)
       {
           String acc_type=null;
           if(r1.isSelected()) {
               acc_type = "Savings Account";
           }
           else if(r2.isSelected())
           {
               acc_type="Fixed Deposit Account";
           }
           else if(r3.isSelected())
           {
               acc_type="Current Account";
           }
           else if(r4.isSelected())
           {
               acc_type="Recurring Deposit Account";
           }
           Random rn=new Random();
           String card=""+Math.abs((rn.nextLong()%90000000L)+5040936000000000L);
           String pin=""+Math.abs((rn.nextLong()%9000L)+1000L);
           String Facility="";
           if(c1.isSelected())
           {
               Facility=Facility+"ATM card";
           }
           else if (c2.isSelected())
           {
               Facility=Facility+"Internet Banking";
           }
           else if (c3.isSelected())
           {
               Facility=Facility+"Mobile Banking";
           }
           else if (c4.isSelected())
           {
               Facility=Facility+"Email and SMS alert";
           }
           else if (c5.isSelected())
           {
               Facility=Facility+"Cheque Book";
           }
           else if (c6.isSelected())
           {
               Facility=Facility+"E-statement";
           }
           try
           {
               if(c7.getText().equals(""))
               {
                   JOptionPane.showMessageDialog(null,"Fill all the required fields");
               }
               else
               {
                   //inserting values into signup3 table(Mysql)
                   conn cn=new conn();
                   String q1="insert into signup3 values('" + formno + "','" +acc_type + "','" + card+ "','" + pin + "','" +Facility+"' )";
                   String q2="insert into login values('" + formno + "','" + card+ "','" + pin + "')";
                   cn.s.executeUpdate(q1);
                   cn.s.executeUpdate(q2);
                   JOptionPane.showMessageDialog(null,"Card number :"+card+"\n Pin :"+pin);
                   setVisible(false);
                   new deposit(pin).setVisible(true);

               }
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }

       }

    }

    public static void main(String[] args) {
        new signup3("");

    }
}
