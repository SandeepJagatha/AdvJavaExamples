package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextParamExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// no-argument constructor.
	public ContextParamExample() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// get ServletContext object.
		ServletContext context = getServletContext();
		// get context parameter from ServletContext object.
		String appUser = context.getInitParameter("appUser");

		out.print("<h1>Application User: " + appUser + "</h1>");

		out.close();
	}

}