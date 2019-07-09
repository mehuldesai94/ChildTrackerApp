package servlets;
import database.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ProcessChild")
public class ProcessChild extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public ProcessChild() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		String childId =  request.getParameter("childId");
		String parentId = request.getParameter("parentId");
		HttpSession session = request.getSession();
		session.setAttribute("parentIdEditChild", parentId);
		session.setAttribute("childIdEditChild", childId);
		UserDAO userDAO = new UserDAO();
		switch(option) {
			case "delete":
				userDAO.deleteChildById(Integer.valueOf(childId));
				response.sendRedirect("views/AdminHome.jsp");
				break;
			case "edit":
				response.sendRedirect("views/EditChild.jsp");
				break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
