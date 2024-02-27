package Atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
public class withdraw extends JFrame implements ActionListener
    {
        JTextField amount;
        JButton b1,b2;
        String pin;
        withdraw(String pin)
        {
            this.pin=pin;
            setLayout(null);
            //atm image
            String imagePath = "src\\Atm\\atm.jpg" ;
            ImageIcon i1 = new ImageIcon(imagePath);
            Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel label=new JLabel(i3);
            label.setBounds(0,0,900,900);
            add(label);
            //Amount to be withdrawn
            JLabel text=new JLabel("Enter the amount you want to withdraw:");
            text.setForeground(Color.WHITE);
            text.setFont(new Font("System",Font.BOLD,16));
            text.setBounds(170,300,400,20);
            label.add(text);
            //textfield for amount to be withdrawn
            amount=new JTextField();
            amount.setFont(new Font("Raleway",Font.BOLD,22));
            amount.setBounds(170,330,320,25);
            label.add(amount);
            //withdraw button
            b1=new JButton("Withdraw");
            b1.setBounds(355,485,150,30);
            b1.addActionListener(this);
            label.add(b1);
            //back button
            b2=new JButton("Back");
            b2.setBounds(355,520,150,30);
            b2.addActionListener(this);
            label.add(b2);
            //Jframe
            setSize(900, 900);
            setLocation(300, 0);
            setVisible(true);

        }
        public  void actionPerformed(ActionEvent ae)
        {
            String amt=amount.getText();
            if(ae.getSource()==b1)
            {
                if(amt.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
                    return;
                }
                try
                {
                    conn cn=new conn();
                    try
                    {
                        String q1="SELECT * FROM operation WHERE pin='"+pin+"'";
                        ResultSet rs=cn.s.executeQuery(q1);
                        int balance =0;
                        while(rs.next())
                        {
                            if(rs.getString("type").equals("deposit"))
                            {
                                balance=balance+Integer.parseInt(rs.getString("amount"));
                            }
                            else
                            {
                                balance=balance-Integer.parseInt(rs.getString("amount"));
                            }

                        }
                        if (balance<Integer.parseInt(amt))
                        {
                            JOptionPane.showMessageDialog(null,"Insufficient Balance");
                            return;
                        }
                        Date date=new Date();
                        String q2="insert into operation values('"+pin+"','"+date+"','withdraw','"+amt+"')";
                        cn.s.executeUpdate(q2);
                        JOptionPane.showMessageDialog(null,"Rs "+amt+" withdrawn successfully");
                        setVisible(false);
                        new transaction(pin).setVisible(true);
                 }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }catch (Exception e)
                {
                    e.printStackTrace();
                }


            }
            else if(ae.getSource()==b2)
            {
                setVisible(false);
                new transaction(pin).setVisible(true);
            }
        }
    }


