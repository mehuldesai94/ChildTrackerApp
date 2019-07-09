package servlets;
import database.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ProcessChildByParent")
public class ProcessChildByParent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcessChildByParent() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parentId = request.getParameter("parentId");
		String childId = request.getParameter("childId");
		String option = request.getParameter("option");
		UserDAO userDAO = new UserDAO();
		HttpSession session = request.getSession();
		session.setAttribute("parentIdEditChild", parentId);
		session.setAttribute("childIdEditChild", childId);
		
		switch(option) {
			case "delete":
				userDAO.deleteChildById(Integer.valueOf(childId));
				response.sendRedirect("views/ParentHome.jsp");
				break;
			
			case "edit":
				response.sendRedirect("views/EditChildByParent.jsp");
				break;
			}
	}

}









