package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.*;
import database.UserDAO;


@WebServlet("/ProcessEditChild")
public class ProcessEditChild extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ProcessEditChild() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String parentId = (String) session.getAttribute("parentIdEditChild");
		String childId = (String) session.getAttribute("childIdEditChild");
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
		child.setParentId(Integer.valueOf(parentId));
		child.setId(Integer.valueOf(childId));
	
		
		if(!child.isRegisterValid()) {
			session.setAttribute("registerError", "All fields must be filled");
			response.sendRedirect("views/EditChild.jsp");
		}
		else {
			userDAO.updateChild(child);
			response.sendRedirect("views/UserList.jsp");
		}
	}

}










