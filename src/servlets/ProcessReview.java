package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import database.UserDAO;


@WebServlet("/ProcessReview")
public class ProcessReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProcessReview() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reviewText = request.getParameter("review");
		String parentId = request.getParameter("parentId");
		String reviewId = request.getParameter("reviewId");
		String option = request.getParameter("option");
		HttpSession session = request.getSession();
		UserDAO userDAO = new UserDAO();
		String admin = request.getParameter("admin");
		
		switch(option) {
		case "submit":
			if(reviewText != null) {
				session.removeAttribute("emptyReview");
				userDAO.insertReview(Integer.valueOf(parentId), reviewText);
				response.sendRedirect("views/Review.jsp");
			}
			else {
				session.setAttribute("emptyReview", "Review cannot be empty");
				response.sendRedirect("views/Review.jsp");
			}
			break;
		case "delete":
			userDAO.deleteReview(Integer.valueOf(reviewId));
			if(admin != null) {
				response.sendRedirect("views/AdminReview.jsp");
			}
			else {
				response.sendRedirect("views/Review.jsp");
			}
			break;
		}
		
	}

}









