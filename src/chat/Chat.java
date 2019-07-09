package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.gson.Gson;

@WebServlet("/Chat")
public class Chat extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static PrintWriter writer;
	private static HttpSession session;
	private ServletContext context;
	
    public Chat() throws Exception {
    }
    
    public void init(ServletConfig config) {
    	context = config.getServletContext();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String key = /*hash()*/request.getParameter("parentEmail") + request.getParameter("childEmail");
		String key = request.getParameter("parentId") + request.getParameter("childId");
		PrintWriter out = response.getWriter();
		
		List<Message> messages =  (List<Message>) context.getAttribute(key);
		
		Gson gson = new Gson();
		
		// send JSON
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(gson.toJson(messages));
		out.flush();  // commit
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// create Message object and add it to the context
		String sender = request.getParameter("sender");
		String msg = request.getParameter("newMessage");
		String childId = request.getParameter("childId");
		Message message = new Message(sender, msg);
		
		String parent = request.getParameter("parent");
		String child = request.getParameter("child");

		String key = parent+child;
		List<Message> messages = (List<Message>) context.getAttribute(key);
		if (messages == null) {
			messages = new ArrayList();
		}
		messages.add(message);
		context.setAttribute(key, messages);

		// redirect to parent or child chat view
		
		
		if (sender.equals(parent)) {
			HttpSession session = request.getSession();
			session.setAttribute("SessionChildId", childId);
			response.sendRedirect("views/parentChat.jsp");
		} else {
			response.sendRedirect("views/childChat.jsp");
		}
	}

}