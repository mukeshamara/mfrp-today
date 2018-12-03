package com.dao;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.*;


public class addtocartDAO {
	
	public int addintocart(long id,String book_id) throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		int rs=0;
		try
		{
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
				
			String query="insert into add_to_cart values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, 0);
			ps.setInt(2,Integer.parseInt(book_id));
			ps.setString(3, Long.toString(id));
		ps.setDouble(4, 0);
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
	
	public List<Addintocart> search() throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		int rs=0;
		List<Addintocart> cart=new ArrayList<>();
		try
		{
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
			Statement stmt=con.createStatement();	
			String query="select * from add_to_cart";
			ResultSet rs1=stmt.executeQuery(query);
			if(rs1.next())
			{
				Long quantity=rs1.getLong(1);
				Long book_id=rs1.getLong(2);
				String cus_id=rs1.getString(3);
				Double price=rs1.getDouble(4);
				Addintocart ad=new Addintocart(quantity, book_id, cus_id, price);
				cart.add(ad);
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
		return cart;
	}

public boolean checkincart(String book_id,long id2) throws ClassNotFoundException, SQLException
{
	Connection con=null;
	boolean rs=false;
	try
	{
			//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
		Statement stmt=con.createStatement();	
		int bookid=Integer.parseInt(book_id);
		String id=Long.toString(id2);
		String query="select * from add_to_cart where book_id="+bookid+" and customer_id='"+id+"'";
		ResultSet rs2=stmt.executeQuery(query);
		if(rs2.next())
		{
			rs=true;
		}
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


}

