package com.dao;
import java.sql.*;
import com.model.newuserdetails;
import com.view.*;

public class PayDAO {

	public int checkincart(String id,String or_id,double pr,String accno,String bankname,String ifsccode,double totalamount) throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		int rs=0;
		try
		{
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
			
			String query="insert into order_payment_screen values(?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, or_id);
			ps.setDouble(3,pr);
			ps.setString(4, accno);
			ps.setString(5, bankname);
			ps.setString(6,ifsccode);
			ps.setDouble(7,totalamount);
		rs=ps.executeUpdate();
		}catch(Exception ex)
		{
			System.out.println(ex+" 123");
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

	
	public String orderid() throws ClassNotFoundException, SQLException
	{
		newuserdetails u1=null;
		Connection con=null;
		String num="";
		try
		{
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
				Class.forName("com.mysql.jdbc.Driver");
				 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
				
		
			String query="select order_id from order_payment_screen order by 1 desc";
			Statement stmt=con.createStatement();
			ResultSet rs1=stmt.executeQuery(query);
			
			
	if(rs1.next())
	{
		String num1=rs1.getString(1);
		String a[]=num1.split("-");
		int r=Integer.parseInt(a[1]);
		r++;
		num=a[0]+"-"+Integer.toString(r);
		
	}
			
			
		}catch(Exception ex)
		{
			System.out.println(ex+"not here");
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
		
		return num;
	}
	
	
	
}
