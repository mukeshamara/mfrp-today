package com.view;
import java.util.*;
import com.dao.addtocartDAO;
import com.model.*;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addtocart
 */
@WebServlet("/cart.do")
public class addtocart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtocart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs=request.getSession();
		User u=(User)hs.getAttribute("xyz");
		String books[]=request.getParameterValues("book_id");
		
		addtocartDAO dao=new addtocartDAO();
		Addintocart addto=null;
		Long id=u.getUserid();
		int val=0;
		List<Addintocart> into=new ArrayList<>();
		for(int i=0;i<books.length;i++)
		{
			try {
				if(dao.checkincart(books[i],id))
				{
					request.setAttribute("already", books[i]);
					RequestDispatcher rd=request.getRequestDispatcher("info.jsp");
					rd.forward(request, response);
					break;
				}
				else
				{
				val=dao.addintocart(id,books[i]);
				into=dao.search();
				}
			} catch (Exception ex)
			{
				System.out.println(ex+" is here");
			}
			try
			{
				if(into!=null || !into.isEmpty())
				{
					request.setAttribute("intocart", into);
				RequestDispatcher rd=request.getRequestDispatcher("userincart.jsp");
				rd.forward(request, response);
				}
			}catch(Exception ex)
			{
				System.out.println(ex+" here");
			}
		}
	}
}