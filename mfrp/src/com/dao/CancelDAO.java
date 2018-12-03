package com.dao;
import java.sql.*;
public class CancelDAO {

	public int cancellation(String or_id) throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		int rs=0;
		try
		{
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
				
			
			String query="delete from order_payment_screen where order_id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,or_id);
			rs=ps.executeUpdate();
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
		return rs;
	}
	
	
	public int deletefromcart(String cus_id) throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		int rs=0;
		try
		{
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
				
			
			String query="delete from add_to_cart where customer_id=? and price_per_book>0";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,cus_id);
			rs=ps.executeUpdate();
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
		return rs;
	}
	
	
}
