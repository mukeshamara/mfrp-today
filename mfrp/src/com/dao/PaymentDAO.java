package com.dao;
import java.sql.*;
import com.model.Addintocart;

public class PaymentDAO {

	public double totalprice(String username) throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		double pri=0;
		
		try
		{
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
				Statement stmt=con.createStatement();
			String query="select sum(price_per_book) from add_to_cart where customer_id='"+username+"'";
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{
				pri=rs.getDouble(1);
			}
			System.out.println(pri);
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
		return pri;
	}
	
}
