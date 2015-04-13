package Servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import JavaBean.DataBean;
import JavaBean.UserBean;

public class LogIn extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LogIn() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("12345");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String userType = request.getParameter("usertype");
		String name = request.getParameter("loginusername");	
		String password = request.getParameter("loginpassword");
		DataBean db = new DataBean();
		
		boolean isValid = true;
		if((name.equals(""))||(name==null)){isValid = false;}
		else if((password.equals(""))||(name==null)){isValid = false;}
<<<<<<< HEAD
		int userId = db.checkUserValid(name,password);
		if(userId==-1){isValid = false;}
		
		if(userType.equals("androidUser")){
			if(isValid){
				response.getOutputStream().print("ok");
=======
		if(!db.checkUserValid(name,password)){isValid = false;}
		
		if(userType.equals("androidUser")){
			if(isValid){
				response.getOutputStream().print("OK");
>>>>>>> origin/master
			}
			else{
				response.getOutputStream().print("notok");
			}
			//out.close();
		}
		else if(userType.equals("webUser")){
			if(isValid){
<<<<<<< HEAD
				HttpSession session =request.getSession();

				UserBean user = db.getUserByUserId(userId);
				session.setAttribute("user", user);

=======
>>>>>>> origin/master
				response.sendRedirect("navigator.jsp");
			}
			else{
				response.sendRedirect("index.jsp");
			}
		}
		db.closeConnection();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
