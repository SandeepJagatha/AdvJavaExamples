package servlets.httpSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		// get parameters from request object.
		String userName = req.getParameter("userName").trim();
		String password = req.getParameter("password").trim();

		// check for null and empty values.
		if (userName == null || userName.equals("") || password == null || password.equals("")) {
			out.print("Please enter both username " + "and password. <br/><br/>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html");
			requestDispatcher.include(req, resp);
		} // Check for valid username and password.
		else if (userName.equals("jai") && password.equals("1234")) {
			HttpSession session = req.getSession();
			session.setAttribute("userName", userName);
			session.setAttribute("password", password);
			out.println("Logged in successfully.<br/>");
			out.println("Click on the below link to see " + "the values of Username and Password.<br/>");
			out.println("<a href='DisplaySessionValueServlet'>" + "Click here</a>");
			out.close();
		} else {
			out.print("Wrong username or password. <br/><br/>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html");
			requestDispatcher.include(req, resp);
		}

	}

}
