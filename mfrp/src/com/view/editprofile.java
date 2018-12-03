package com.view;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;
import com.model.newuserdetails;

/**
 * Servlet implementation class editprofile
 */
@WebServlet("/editprofile.do")
public class editprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editprofile() {
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
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		newuserdetails ud=null;
		// TODO Auto-generated method stub
		String previous_id=request.getParameter("previous_id");
		String edited_id=request.getParameter("editedid");
		String newusername=request.getParameter("name");
		String newuserdob=request.getParameter("dob");
		String newuserpass=request.getParameter("pass");
		String newuseremail=request.getParameter("email");
		String newusernumber=request.getParameter("number");
		try
		{
		Date date=sdf.parse(newuserdob);
		ud=new newuserdetails(newusername,newuserpass,date,newusernumber,newuseremail);
		
		EditprofileDAO dao=new EditprofileDAO();
		int x=dao.editprofile(previous_id,edited_id,ud);
		if(x>0)
		{
			request.setAttribute("errmsg6", "<font color='red'>Succesfully you have edited your profile.><br/>");
			RequestDispatcher rd=request.getRequestDispatcher("editprofile.jsp");
			rd.forward(request, response);
		}
	}catch(Exception ex)
	{
		System.out.println(ex);
	}
	}
}
