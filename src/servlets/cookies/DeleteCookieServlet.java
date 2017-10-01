package servlets.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);

		resp.setContentType("text/html");
		PrintWriter out = ((ServletResponse) req).getWriter();

		try {
			Cookie cookies[] = req.getCookies();
			out.print("Deleted cookie are:");
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
				out.println("Cookie name: " + cookie.getName());
			}

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
