package servlets;

import java.io.IOException;
import beans.*;
import database.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ProcessRegisterChild")
public class ProcessRegisterChild extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProcessRegisterChild() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Parent p = (Parent)session.getAttribute("parent");
		Child child = new Child();
		UserDAO userDAO = new UserDAO();
		
		child.setFirstName(request.getParameter("firstName"));
		child.setLastName(request.getParameter("lastName"));
		child.setPassword(request.getParameter("password"));
		child.setBirthdate(request.getParameter("birthdate"));
		child.setGender(request.getParameter("gender"));
		child.setAddress(request.getParameter("address"));
		child.setPhone(request.getParameter("phone"));
		child.setEmail(request.getParameter("email"));
		child.setIsParent("false");
		child.setIsAdmin("false");
		child.setParentId(p.getId());
		
		if(!child.isRegisterValid()) {
			session.setAttribute("registerError", "All fields must be filled");
			response.sendRedirect("views/RegisterChild.jsp");
		}
		else {
			session.removeAttribute("registerError");
			userDAO.registerChild(child);
			response.sendRedirect("views/ParentHome.jsp");
		}
	}

}












