package servlets.httpSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DisplaySessionValueServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		resp.setContentType("text/html"); 
    	PrintWriter out = ((ServletResponse) req).getWriter();
 
    	//get parameters from session object.
    	HttpSession session=req.getSession(false);  
        String userName =(String)session.getAttribute("userName");  
        String password =(String)session.getAttribute("password");  
 
    	out.println("Username: " + userName + "<br/><br/>");
    	out.println("Password: " + password);
 
    	out.close();
	}
}
