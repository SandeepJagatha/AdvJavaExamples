package servlets.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// get parameters from request object.
		String userName = request.getParameter("userName").trim();
		String password = request.getParameter("password").trim();

		// check for null and empty values.
		if (userName == null || userName.equals("") || password == null || password.equals("")) {
			out.print("Please enter both username " + "and password. <br/><br/>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login3.html");
			requestDispatcher.include(request, response);
		} // Check for valid username and password.
		else if (userName.equals("test") && password.equals("1234")) {
			chain.doFilter(request, response);
		} else {
			out.print("Wrong username or password. <br/><br/>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login3.html");
			requestDispatcher.include(request, response);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
