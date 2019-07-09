package servlets;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;
import database.*;


@WebServlet("/ProcessLogin")
public class ProcessLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ServletContext context;
	public void init(ServletConfig config) {
		context = config.getServletContext();
	}
	
    public ProcessLogin() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		UserDAO userDAO = new UserDAO();
		
		Admin a = userDAO.getAdminByEmail(email);	
		Child c = userDAO.getChildByEmail(email);
		Parent p = userDAO.getParentByEmail(email);
		
		if(a != null) {
			if(a != null) {
				if(a.getEmail().equalsIgnoreCase(email) && a.getPassword().equals(password)) {
					session.removeAttribute("message");
					session.setAttribute("admin", a);
					response.sendRedirect("views/AdminHome.jsp");
				}
			}
		}
		else if(p != null ) {
			if(p.getEmail().equalsIgnoreCase(email) && p.getPassword().equals(password)) {
				session.removeAttribute("message");
				session.setAttribute("parent", p);
				String key = "parentChat"+p.getId();
				context.setAttribute(key, p);
				response.sendRedirect("views/ParentHome.jsp");
			}
		}
		else if(c != null) {
			if(c != null) {
				if( c.getEmail().equalsIgnoreCase(email) && c.getPassword().equals(password) ){
					session.removeAttribute("message");
					session.setAttribute("child", c);
					String key = "childChat"+c.getId();
					context.setAttribute(key, c);
					response.sendRedirect("views/ChildHome.jsp");
				}
			}
		}
		else {
			session.setAttribute("message", "Invalid credentials");
			response.sendRedirect("views/Login.jsp");
		}
		
	}

}