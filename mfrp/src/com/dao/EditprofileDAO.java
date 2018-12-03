package com.dao;
import java.sql.*;
import com.model.newuserdetails;

public class EditprofileDAO {

	public int editprofile(String pr_id,String ed_id,newuserdetails ud) throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		int rs=0;
		try
		{
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
			
				String query="insert into customer_registration values (?,?,?,?,?,?) where customer_id=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, ed_id);
				ps.setString(2,ud.getName());
				ps.setString(3, ud.getPass());
				ps.setDate(4, new java.sql.Date(ud.getDate().getTime()));
				ps.setString(5,ud.getNumber());
				ps.setString(6,ud.getEmail());
				ps.setString(7,pr_id);
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
	
}
