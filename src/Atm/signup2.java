package Atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class signup2 extends JFrame implements ActionListener
{
    JComboBox t1,t2,t3,t4,t5;
    JTextField t6,t7;
    JRadioButton s_yes,s_no,ea_yes,ea_no;
    String formno;
    JButton next;
    signup2(String formno)
    {
        this.formno=formno;
        setLayout(null);
        //set title
        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2");

        //additional details
        JLabel additional_details=new JLabel("Page 2:Additional Details");
        additional_details.setFont(new Font("Raleway",Font.BOLD,20));
        additional_details.setBounds(290,80,400,30);
        add(additional_details);

        //religion
        JLabel rel=new JLabel("Religion:");
        rel.setFont(new Font("Raleway",Font.BOLD,20));
        rel.setBounds(100,140,100,30);
        add(rel);
        //combo box for religion
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Others"};
        t1=new JComboBox(valReligion);
        t1.setBounds(300,140,400,30);
        t1.setBackground(Color.WHITE);
        add(t1);

        //category
        JLabel category=new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);
        //combo box for category
        String valCategory[]={"General","OBC","SC","ST"};
        t2=new JComboBox(valCategory);
        t2.setBounds(300,190,400,30);
        t2.setBackground(Color.WHITE);
        add(t2);

        //income
        JLabel income =new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);
        //combo box for income
        String valIncome[]={"null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
        t3=new JComboBox(valIncome);
        t3.setBounds(300,240,400,30);
        t3.setBackground(Color.WHITE);
        add(t3);


        //education
        JLabel edu=new JLabel("Educational");
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        edu.setBounds(100,290,200,30);
        add(edu);
        //qualification
        JLabel quali=new JLabel("Qualification:");
        quali.setFont(new Font("Raleway",Font.BOLD,20));
        quali.setBounds(100,315,200,30);
        add(quali);
        //combo box for education qualifiaction
        String valEdu[]={"Non-Graduate","Graduate","Post-Graduate","Doctrare","Others"};
        t4=new JComboBox(valEdu);
        t4.setBounds(300,315,400,30);
        t4.setBackground(Color.WHITE);
        add(t4);

        //occupation
        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,390,200,30);
        add(occupation);
        //combo box for occupation
        String valOccu[]={"Salaried","Self-Employeed","Business","Student","Retired","Others"};
        t5=new JComboBox(valOccu);
        t5.setBounds(300,390,400,30);
        t5.setBackground(Color.WHITE);
        add(t5);

        //PAN number
        JLabel pan=new JLabel("PAN:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);
        //Textfield for Pan number
        t6 =new JTextField();
        t6.setFont(new Font("Raleway",Font.BOLD,14));
        t6.setBounds(300,440,400,30);
        add(t6);

        //adhar number
        JLabel adhar=new JLabel("Aadhar number:");
        adhar.setFont(new Font("Raleway",Font.BOLD,20));
        adhar.setBounds(100,490,200,30);
        add(adhar);
        //textfield for adhar number
        t7 =new JTextField();
        t7.setFont(new Font("Raleway",Font.BOLD,14));
        t7.setBounds(300,490,400,30);
        add(t7);

        //senior citizen
        JLabel s_citizen=new JLabel("Senior Citizen:");
        s_citizen.setFont(new Font("Raleway",Font.BOLD,20));
        s_citizen.setBounds(100,540,200,30);
        add(s_citizen);;
        //jradio button for senior citizen
        //for yes
        s_yes=new JRadioButton("Yes");
        s_yes.setBounds(300,540,100,30);
        s_yes.setBackground(Color.WHITE);
        add(s_yes);
        //for no
        s_no=new JRadioButton("No");
        s_no.setBounds(450,540,100,30);
        s_no.setBackground(Color.WHITE);
        add(s_no);
        //buttongroup for yes and no
        ButtonGroup senior_citizen=new ButtonGroup();
        senior_citizen.add(s_yes);
        senior_citizen.add(s_no);

        //Existing account
        JLabel exist_acc=new JLabel("Existing Account:");
        exist_acc.setFont(new Font("Raleway",Font.BOLD,20));
        exist_acc.setBounds(100,590,200,30);
        add(exist_acc);
        //j radio button for existing acc
        //for yes
        ea_yes=new JRadioButton("Yes");
        ea_yes.setBounds(300,590,100,30);
        ea_yes.setBackground(Color.WHITE);
        add(ea_yes);
        //for no
         ea_no=new JRadioButton("No");
        ea_no.setBounds(450,590,100,30);
        ea_no.setBackground(Color.WHITE);
        add(ea_no);
        //buttongroup for yes and no
        ButtonGroup existing_account=new ButtonGroup();
        existing_account.add(ea_yes);
        existing_account.add(ea_no);
        //next button
        JButton next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        //creating jframe
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(300, 0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String s_religion=(String) t1.getSelectedItem();
        String s_category=(String) t2.getSelectedItem();
        String s_income=(String) t3.getSelectedItem();
        String s_edu_qualification=(String)t4.getSelectedItem();
        String s_occupation=(String) t5.getSelectedItem();
        String s_pan=t6.getText();
        String s_aadhar=t7.getText();
        String s_citizen=null;
        if(s_yes.isSelected())
        {
            s_citizen = "Yes";
        }
        else if(s_no.isSelected())
        {
            s_citizen="No";
        }
        String s_exist_acc=null;
        if(ea_yes.isSelected())
        {
            s_exist_acc="Yes";
        }
        else if(ea_no.isSelected())
        {
            s_exist_acc="No";
        }
        try {
            if (t6.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all your details");
            } else {
                conn cn = new conn();
                //inserting  values into signup2 table (Mysql)
                String query = "insert into signup2 values('" + formno + "','" + s_religion + "','" + s_category + "','" + s_income + "','" + s_edu_qualification + "','" + s_occupation + "','" + s_pan + "','" + s_aadhar + "','" + s_citizen + "','" + s_exist_acc + "')";
                try {
                    cn.s.executeUpdate(query);//fire the query

                    setVisible(false);
                    new signup3(formno).setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


