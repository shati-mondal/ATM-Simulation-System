package Atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balance_enquiry  extends JFrame implements ActionListener {
    JButton back;
    String pin;
    balance_enquiry(String pin)
    {
        this.pin=pin;
        setLayout(null);
        String imagePath = "src\\Atm\\atm.jpg";
        ImageIcon i1 = new ImageIcon(imagePath);
        Image i2 = i1.getImage().getScaledInstance(960, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);
        //
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        label.add(back);



        int balance = 0;
                try {
                    conn cn = new conn();
                    String q2 = "SELECT  * FROM operation WHERE pin ='"+pin+"'";
                    ResultSet rs = cn.s.executeQuery(q2);
                    while (rs.next()) {
                        if (rs.getString("type").equals("deposit")) {
                            balance = balance + Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance = balance - Integer.parseInt(rs.getString("amount"));
                        }
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                JLabel text=new JLabel("Your current account balance is Rs "+balance);
                text.setForeground(Color.WHITE);
                text.setBounds(170,300,400,30);
                label.add(text);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==back) {
            setVisible(false);
            new transaction(pin).setVisible(true);
        }
    }
}
