package servlets;
import database.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ProcessParent")
public class ProcessParent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProcessParent() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		String parentId = request.getParameter("parentId");
		UserDAO userDAO = new UserDAO();
		HttpSession session = request.getSession();
		session.setAttribute("parentId", parentId);
		
		switch(option) {
			case "delete":
				userDAO.deleteParentById(Integer.valueOf(parentId));
				response.sendRedirect("views/UserList.jsp");
				break;
				
			case "edit":
				response.sendRedirect("views/EditParent.jsp");
				break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
