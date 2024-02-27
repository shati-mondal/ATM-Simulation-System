package Atm;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
public class signup1 extends JFrame implements ActionListener {
    long random;
    JTextField n1,n2,n5,n7,n8,n9,n10;
    JButton next;
    JRadioButton male,female,married,unmarried;
    JDateChooser datechooser;
    signup1() {
        setLayout(null);
        //generate random number
        Random ran=new Random();
        random=Math.abs((ran.nextLong()% 9000L)+1000L);

        //application form number
        JLabel formno=new JLabel("APPLICATION FORM NO."+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        //personal details
        JLabel personalDetails=new JLabel("page1.Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        //Name
        JLabel name =new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);
        //textfield for name
        n1 =new JTextField();
        n1.setFont(new Font("Raleway",Font.BOLD,14));
        n1.setBounds(300,140,400,30);
        add(n1);

        //Father's name
        JLabel father_name =new JLabel("Father's Name:");
        father_name.setFont(new Font("Raleway",Font.BOLD,20));
        father_name.setBounds(100,190,200,30);
        add(father_name);
        //textfield for father's name
        n2 =new JTextField();
        n2.setFont(new Font("Raleway",Font.BOLD,14));
        n2.setBounds(300,190,400,30);
        add(n2);

        //date of birth
        JLabel dob =new JLabel("D.O.B(dd/mm//yy):");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        //textfield for date of birth
        //calendar
        datechooser=new JDateChooser();
        datechooser.setBorder(new LineBorder(new Color(0,0,0),1,true));
        datechooser.setBounds(300,240,400,30);
        datechooser.setForeground(new Color(105,105,105));
        add(datechooser);

        //gender
        JLabel gender =new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        //textfield for gender
        //jradio button for male
        male=new JRadioButton("MALE");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        //jradio button for female
        female=new JRadioButton("FEMALE");
        female.setBounds(450,290,90,30);
        female.setBackground(Color.WHITE);
        add(female);
        //to select only one button/option
        ButtonGroup g1=new ButtonGroup();
        g1.add(male);
        g1.add(female);

        //email
        JLabel email =new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        //textfield for email
        n5 =new JTextField();
        n5.setFont(new Font("Raleway",Font.BOLD,14));
        n5.setBounds(300,340,400,30);
        add(n5);

        //Marital status
        JLabel m_status =new JLabel("Marital status:");
        m_status.setFont(new Font("Raleway",Font.BOLD,20));
        m_status.setBounds(100,390,200,30);
        add(m_status);
        //textfield for maritial status
        //jradio button for married status
        married=new JRadioButton("MARRIED");
        married.setBounds(300,390,90,30);
        married.setBackground(Color.WHITE);
        add(married);
        //jradio button for unmarried status
        unmarried=new JRadioButton("UNMARRIED");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        //to select only one button/option
        ButtonGroup m1=new ButtonGroup();
        m1.add(married);
        m1.add(unmarried);

        //Address
        JLabel address =new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,100,30);
        add(address);
        //textfield for address
        n7 =new JTextField();
        n7.setFont(new Font("Raleway",Font.BOLD,14));
        n7.setBounds(300,440,400,30);
        add(n7);

        //city
        JLabel city =new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,100,30);
        add(city);
        //textfield for city
        n8 =new JTextField();
        n8.setFont(new Font("Raleway",Font.BOLD,14));
        n8.setBounds(300,490,400,30);
        add(n8);

        //pin code
        JLabel pin =new JLabel("Pin code:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,540,100,30);
        add(pin);
        //textfield for pincode
        n9=new JTextField();
        n9.setFont(new Font("Raleway",Font.BOLD,14));
        n9.setBounds(300,540,400,30);
        add(n9);

        //state
        JLabel state =new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,590,100,30);
        add(state);
        //textfield for state
        n10 =new JTextField();
        n10.setFont(new Font("Raleway",Font.BOLD,14));
        n10.setBounds(300,590,400,30);
        add(n10);

        //add next button
        JButton next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(300, 0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String formno=""+ random;
        String name=n1.getText();
        String fname=n2.getText();
        String dob=((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected())
        {
            gender="Male";
        }
        else if (female.isSelected())
        {
            gender="Female";
        }
        String email=n5.getText();
        String marital=null;
        if(married.isSelected())
        {
            marital="Married";
        }
        else if (unmarried.isSelected())
        {
            marital="Unmarried";
        }
        String address=n7.getText();
        String city=n8.getText();
        String pincode=n9.getText();
        String state=n10.getText();
        try
        {
            if(n9.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Fills are required");
            }
            else
            {
                conn cn=new conn();
                //inserting  values into signup1 table (Mysql)
                try{
                String query="insert into signup1 values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";

                cn.s.executeUpdate(query);
                setVisible(false);
               new signup2(formno).setVisible(true);
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }
        }
        catch(SQLSyntaxErrorException e)
        {
           JOptionPane.showMessageDialog (null,"Error"+e.getMessage());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
