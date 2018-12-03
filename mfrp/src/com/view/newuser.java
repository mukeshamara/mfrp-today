package com.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.*;

import com.dao.*;
import com.model.*;

/**
 * Servlet implementation class newuser
 */
@WebServlet("/newus.do")
public class newuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newuser() {
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
		newuserdetails ud=null;
		int x=0;
		String y="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		try
		{
		
		String newusername=request.getParameter("name");
		String newuserdob=request.getParameter("dob");
		String newuserpass=request.getParameter("pass");
		String newuseremail=request.getParameter("email");
		String newusernumber=request.getParameter("number");
		Date date=sdf.parse(newuserdob);
		//String fin=newusername+","+newuserdob+","+newuserpass+","+newuseremail+","+newusernumber;
		ud=new newuserdetails(newusername,newuserpass,date,newusernumber,newuseremail);
		
			newuserDAO dao=new newuserDAO();
			y=Integer.toString(dao.number());
			x=dao.insert(ud,y);
			request.setAttribute("customerid", y);
			if(x>0)
			{
				request.setAttribute("errmsg", "<font color='red'>Successfully registered.><br/>");
				RequestDispatcher rd=request.getRequestDispatcher("succesful.jsp");
				rd.forward(request, response);
			}
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	
	}

}
