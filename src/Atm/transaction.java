package Atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transaction  extends JFrame   implements ActionListener {
    JButton deposit,withdraw,mini,fastcash,Pin,balance,exit;
    String pin;
    transaction(String pin)
    {
        this.pin=pin;
        String imagePath = "src\\Atm\\atm.jpg" ;
        ImageIcon i1 = new ImageIcon(imagePath);
        Image i2 = i1.getImage().getScaledInstance(960, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);
        //
        JLabel text=new JLabel("Please Select your Transaction");
        text.setBounds(220,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        label.add(text);
        //
        deposit=new JButton("Deposit");
        deposit.setBounds(140,385,150,30);
        deposit.addActionListener(this);
        label.add(deposit);
        //
        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,385,150,30);
        withdraw.addActionListener(this);
        label.add(withdraw);
        //
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(140,425,150,30);
        fastcash.addActionListener(this);
        label.add(fastcash);
        //
        mini=new JButton("Mini Statement");
        mini.setBounds(355,425,150,30);
        mini.addActionListener(this);
        label.add(mini);
        //
        Pin=new JButton("Pin Change");
        Pin.setBounds(140,465,150,30);
        Pin.addActionListener(this);
        label.add(Pin);
        //
        balance=new JButton("Balance Enquiry");
        balance.setBounds(355,465,150,30);
        balance.addActionListener(this);
        label.add(balance);
        //
        exit=new JButton("Exit");
        exit.setBounds(140,500,150,30);
        exit.addActionListener(this);
        label.add(exit);
        //
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public  void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            System.exit(0);

        } else if (ae.getSource()==deposit) {
            setVisible(false);
            new deposit(pin).setVisible(true);
        } else if (ae.getSource()==withdraw) {
            setVisible(false);
            new withdraw(pin).setVisible(true);

        } else if (ae.getSource()==fastcash) {
            setVisible(false);
            new fastcash(pin).setVisible(true);
        } else if (ae.getSource()==balance) {
            setVisible(false);
            new balance_enquiry(pin).setVisible(true);
        } else if (ae.getSource()==mini) {
            new MiniStatement(pin).setVisible(true);
        }else if (ae.getSource()==Pin) {
            setVisible(false);
            new Pin_Change(pin).setVisible(true);
        }
    }
}
