package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// no-argument constructor
	public InitParamExample() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// get ServletConfig object.
		ServletConfig config = getServletConfig();
		// get init parameter from ServletConfig object.
		String appUser = config.getInitParameter("appUser");

		out.print("<h1>Application User: " + appUser + "</h1>");

		out.close();
	}
}