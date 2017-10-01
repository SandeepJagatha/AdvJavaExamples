package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// get parameters from request object.
		String userName = request.getParameter("userName").trim();
		String password = request.getParameter("password").trim();

		// check for null and empty values.
		if (userName == null || userName.equals("") || password == null || password.equals("")) {
			out.print("Please enter both username" + " and password. <br/><br/>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
			requestDispatcher.include(request, response);
		} // Check for valid username and password.
		else if (userName.equals("testLogin") && password.equals("servlet")) {
			response.sendRedirect("/AdvJavaa/welcome.html");
		} else {
			out.print("Wrong username or password. <br/><br/>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
			requestDispatcher.include(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login2.html");
		requestDispatcher.include(request, response);
	}
}
