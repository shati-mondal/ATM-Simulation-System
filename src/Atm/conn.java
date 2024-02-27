package Atm;

import java.sql.*;

public class conn
{
    Connection c;
    Statement s;
    public conn()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");// Register the driver
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank_management","root","1234");//get connection with database
            s=c.createStatement();//Fire the query to sql server.
            System.out.println("Connection and Statement initialized successfully.");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
