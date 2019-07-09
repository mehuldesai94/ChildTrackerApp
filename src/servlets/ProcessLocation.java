package servlets;
import database.*;
import beans.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ProcessLocation")
public class ProcessLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProcessLocation() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDAO userDAO = new UserDAO();
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		
		Child child = (Child) session.getAttribute("child");
		
		
		Location location = new Location();
		location.setLatitude(latitude);
		location.setLongitude(longitude);
		location.setLocationId(child.getId());
		
		userDAO.insertLocationByChildId(location);
		/*
		location.setLocationId(1);
		
	
		userDAO.updateLocation(location);*/
		
	}

}
