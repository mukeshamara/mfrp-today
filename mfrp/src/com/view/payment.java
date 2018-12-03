package com.view;
import com.dao.*;

import java.io.*;

import com.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class payment
 */
@WebServlet("/payment.do")
public class payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payment() {
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
	
		String id=(String) hs.getAttribute("id");
		System.out.println(id);
		double pr=(double)hs.getAttribute("toprice");
		System.out.println(pr);
		String accno=request.getParameter("acc_no");
		String bankname=request.getParameter("bank_name");
		String ifsccode=request.getParameter("ifsc_code");
		double totalamount=Double.parseDouble(request.getParameter("amount"));
		try{
 		PayDAO dao=new PayDAO();
		String or_id=dao.orderid();
		hs.setAttribute("or_id",or_id);
		int r=dao.checkincart(id,or_id,pr,accno,bankname,ifsccode,totalamount);
		if(r>0)
		{
			request.setAttribute("errmsg2", "<font color='red'>You're Payment done successfully.><br/>");
			request.setAttribute("errmsg3", "<font color='red'>You have ordered the books successfully.><br/>");
			RequestDispatcher rd=request.getRequestDispatcher("Afterpayment.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("errmsg1", "<font color='red'>Please fill it again><br/>");
			RequestDispatcher rd=request.getRequestDispatcher("payment.jsp");
			rd.forward(request, response);
		}
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

}
