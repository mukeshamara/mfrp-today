package com.view;
import com.dao.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println(11111);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserDAO dao=new UserDAO();
		System.out.println("hjqwgd");
		
		try
		{
		User u=new UserDAO().search(username);
		HttpSession hs=request.getSession();
		hs.setAttribute("xyz", u);
		//Long name=u.getUserid();
		//System.out.println(name);
		//request.setAttribute("errmsg", "font color='red'>User not found><br/>");
		// for this in jsp file we can directly mention it as ${errmsg} then it will print the error message.
		if(u!=null)
		{
		RequestDispatcher rd=request.getRequestDispatcher("lo.jsp");
		rd.forward(request, response);
		}
		else
		{
			request.setAttribute("errmsg", "font color='red'>User not found><br/>");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		//servelet context-we use applicationscope
		}catch(Exception ex)
		{
			System.out.println(ex);
		}

}
}
//<%= request.getParameter("name") %>
