package Atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.sql.ResultSet;

public class fastcash  extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, back;
    String pin;

    fastcash(String pin) {
        this.pin = pin;
        String imagePath = "src\\Atm\\atm.jpg";
        ImageIcon i1 = new ImageIcon(imagePath);
        Image i2 = i1.getImage().getScaledInstance(960, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);
        //
        JLabel text = new JLabel("Please Select Withdraw Amount");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        label.add(text);
        //
        b1 = new JButton("Rs 100");
        b1.setBounds(140, 385, 150, 30);
        b1.addActionListener(this);
        label.add(b1);
        //
        b2 = new JButton("Rs 500");
        b2.setBounds(355, 385, 150, 30);
        b2.addActionListener(this);
        label.add(b2);
        //
        b3 = new JButton("Rs 1000");
        b3.setBounds(140, 425, 150, 30);
        b3.addActionListener(this);
        label.add(b3);
        //
        b4 = new JButton("Rs 2000");
        b4.setBounds(355, 425, 150, 30);
        b4.addActionListener(this);
        label.add(b4);
        //
        b5 = new JButton("Rs 5000");
        b5.setBounds(140, 465, 150, 30);
        b5.addActionListener(this);
        label.add(b5);
        //
        b6 = new JButton("Rs 10000");
        b6.setBounds(355, 465, 150, 30);
        b6.addActionListener(this);
        label.add(b6);
        //
        back = new JButton("Back");
        back.setBounds(250, 500, 150, 30);
        back.addActionListener(this);
        label.add(back);
        //
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new transaction(pin).setVisible(true);
        } else {
            try {
                String amt = ((JButton) ae.getSource()).getText().substring(3);
                conn cn = new conn();
                String q1 = "SELECT  * FROM operation WHERE pin ='" + pin + "'";
                ResultSet rs = cn.s.executeQuery(q1);
                int balance = 0;
                while (rs.next()) {
                    String amountString = rs.getString("amount");
                    if (amountString != null && !amountString.isEmpty()) {
                        try {
                            balance += Integer.parseInt(amountString);
                        } catch (NumberFormatException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        try {
                            balance += Integer.parseInt(amountString);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                    if (balance < Integer.parseInt(amt)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    Date date = new Date();
                    String q2 = "insert into operation values('" + pin + "','" + date + "','withdraw','" + amt + "')";
                    cn.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Rs " + amt + "Debited Successfully");
                    setVisible(false);
                    new transaction(pin).setVisible(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
    /*public  void actionPerformed(ActionEvent ae){
        if (ae.getSource()==back){
            setVisible(false);
            new transaction(pin).setVisible(true);
        }else{
            try{
                String amt = ((JButton)ae.getSource()).getText().substring(3);
                conn cn = new conn();
                try{
                    String q1 = "SELECT * FROM operation WHERE pin='"+pin+"'";
                    ResultSet rs = cn.s.executeQuery(q1);
                    long balance = 0;
                    while (rs.next()){
                        if(rs.getString("type").equals("deposit")){
                            balance = balance + Long.parseLong(rs.getString("amount"));
                        }else{
                            balance = balance - Long.parseLong(rs.getString("amount"));
                        }
                    }
                    if (balance<Long.parseLong(amt)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }
                    Date date = new Date()
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    }*/



