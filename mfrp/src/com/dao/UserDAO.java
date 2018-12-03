package com.dao;

import java.sql.*;
import com.model.*;
public class UserDAO {

	public User search(String id) throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		User u1=null;
		try
		{
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
				Statement stmt=con.createStatement();
				int id1=Integer.parseInt(id);
		
			String query="select customer_id,password FROM customer_registration where customer_id='"+id+"'";
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{
				Long userid=rs.getLong(1);
				String userpass=rs.getString(2);
				u1=new User(userid,userpass);
			}
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
		finally
		{
			try
			{
				if(con!=null)
				{
					con.close();
					
				}
			}catch(Exception ex1)
			{
			System.out.println("closed");	
			}
		}
		return u1;
	}
	
}
