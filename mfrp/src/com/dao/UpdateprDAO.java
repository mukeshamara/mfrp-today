package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateprDAO {

	public static int update(double price,int quanneeded,int bo_id)

    {

		// List<String> books = new ArrayList<>();
		 Connection con=null;
		 PreparedStatement ps = null;
         int rs = 0;
         String url = "jdbc:mysql://localhost:3306/mfrpproject";
         String user="root";
         String pass="root";
         String query = "update add_to_cart set quantity_needed=?,price_per_book=? where book_id=?";
         String val="";
         double topr=quanneeded*price;
         try

         {

                         Class.forName("com.mysql.jdbc.Driver");

                         con = DriverManager.getConnection(url,user,pass);

                         ps = con.prepareStatement(query);
                         ps.setInt(1, quanneeded);
                         ps.setDouble(2,topr);
                         ps.setInt(3, bo_id);
                         rs = ps.executeUpdate();
    
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

         return rs;

}

	
	 public static int reserve(int booid,int qct)

     {

                     int res=0;

                     Connection con=null;

                     PreparedStatement ps = null;

                     String url = "jdbc:mysql://localhost:3306/mfrpproject";

                     String user="root";

                     String pass="root";

                     String query = "update product set quantity=quantity-? where book_id=?";

                     try

                     {

                                     Class.forName("com.mysql.jdbc.Driver");

                                     con = DriverManager.getConnection(url,user,pass);

                                     ps = con.prepareStatement(query);

                                     ps.setInt(1, qct);

                                     ps.setInt(2, booid);

                                    

                                     res = ps.executeUpdate();

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

                    

                     return res;

     }

    
	
}
