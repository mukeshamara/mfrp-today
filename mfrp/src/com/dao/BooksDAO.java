package com.dao;
import java.util.*;
import java.sql.*;
public class BooksDAO {

	public static List<Integer> findbooks(String from)

    {
                    List<Integer> books = new ArrayList<>();
                    Connection con=null;
                    Statement stmt = null;
                    ResultSet rs = null;
                    String url = "jdbc:mysql://localhost:3306/mfrpproject";
                    String user="root";
                    String pass="root";
                    String query = "Select book_id from add_to_cart where customer_id='"+from+"'";
                    try
                    {

                                    Class.forName("com.mysql.jdbc.Driver");

                                    con = DriverManager.getConnection(url,user,pass);
                                    stmt=con.createStatement();
                                    rs = stmt.executeQuery(query);
                                    while(rs.next())
                                    {
                                    	int bid=rs.getInt(1);
                                    
                                    	books.add(bid);
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
             		return books;
                              
}
	
	public static String search(int bookid)

    {

		// List<String> books = new ArrayList<>();
		 Connection con=null;
		 PreparedStatement ps = null;
         ResultSet rs = null;
         String url = "jdbc:mysql://localhost:3306/mfrpproject";
         String user="root";
         String pass="root";
         String query = "Select book_id,book_name,price,quantity from product where book_id=?";
         String val="";
         try

         {

                         Class.forName("com.mysql.jdbc.Driver");

                         con = DriverManager.getConnection(url,user,pass);

                         ps = con.prepareStatement(query);

                         ps.setInt(1, bookid);
                         rs = ps.executeQuery();
                         
                         if(rs.next())

                         {
                        	 			val = "{\"bid\":\""+rs.getInt(1)+"\",";
                                         val+="\"bname\":\""+rs.getString(2)+"\",";
                                         val+="\"price\":\""+rs.getDouble(3)+"\",";
                                         val+="\"tobo\":\""+rs.getInt(4)+"\"}";

                         }

                        

         }catch(Exception ex)

         {

                         System.out.println("Exception at UserDAO find user method: "+ex);

         }

         finally

         {

                         try{

                                         if(con!=null)

                                         {

                                                         con.close();

                                         }

                         }catch(Exception ex2)

                         {

                                         System.out.println("Exception while closing conn at find user: "+ex2);

                         }

         }

         return val;

}

}
