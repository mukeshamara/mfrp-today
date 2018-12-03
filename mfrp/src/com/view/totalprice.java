package com.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.model.User;
import com.dao.*;
/**
 * Servlet implementation class totalprice
 */
@WebServlet("/totalprice.do")
public class totalprice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public totalprice() {
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
		String userid=request.getParameter("user_id");
		HttpSession hs=request.getSession();
		hs.setAttribute("id", userid);
		
UserDAO dao=new UserDAO();
		
		try
		{
		User u=dao.search(userid);
		PaymentDAO dao1=new PaymentDAO();
		
		if(u!=null)
		{
			request.setAttribute("id", userid);
			double price=dao1.totalprice(userid);
			
			hs.setAttribute("toprice",price);
		RequestDispatcher rd=request.getRequestDispatcher("payment.jsp");
		rd.forward(request, response);
		}
		else
		{
			request.setAttribute("errmsg", "<font color='red'>You did not booked any books><br/>");
			RequestDispatcher rd=request.getRequestDispatcher("lo.jsp");
			rd.forward(request, response);
		}
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
