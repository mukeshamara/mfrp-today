package com.view;
import com.dao.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getbooks
 */
@WebServlet("/GetBooks")
public class getbooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getbooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String  fromid=request.getParameter("fromloc");
		List<Integer> booksincart=new ArrayList<>();
		booksincart=BooksDAO.findbooks(fromid);
		List<String> bookdetails=new ArrayList<>();
		String y="";
		System.out.println(booksincart.size());
		for(int x:booksincart)
		{
			y=BooksDAO.search(x);
			bookdetails.add(y);
		}
		 response.setContentType("application/json");

         response.setCharacterEncoding("utf-8");

         PrintWriter out = response.getWriter();

         out.println("[");

         for(int i=0;i<bookdetails.size();i++)

         {

                         System.out.println(bookdetails.get(i));

                         if(i==bookdetails.size()-1)

                                         out.println(bookdetails.get(i));

                         else

                                         out.println(bookdetails.get(i)+",");

                        

         }

         out.println("]");

         ServletContext ctx = request.getServletContext();

         ctx.log("Retrived "+bookdetails.size()+" books for "+fromid);
		
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

        String fromloc = request.getParameter("fromloc");
        response.setContentType("application/json");

        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();

        /*for(int i=0;i<res.size();i++)

        {

                        if(i==res.size()-1)

                                        out.println(res.get(i));

                        else

                                        out.println(res.get(i)+",");

                       

        }*/

        out.println("size: "+fromloc);
	}
}
