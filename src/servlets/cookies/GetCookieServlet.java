package servlets.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doPost(request, response);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			Cookie cookies[] = request.getCookies();
			for (Cookie cookie : cookies) {
				out.println("Cookie Name: " + cookie.getName());
				out.println("Cookie Value: " + cookie.getValue());
				out.println("");
			}

			out.println("Click on the below button to delete cookies.");
			out.print("<form action='DeleteCookieServlet' method='POST'>");
			out.print("<input type='submit' value='Delete Cookies'>");
			out.print("</form>");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
