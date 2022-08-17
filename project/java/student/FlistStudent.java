package student;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/listStudent.20_")
public class FlistStudent extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		StudentDao dao = new StudentDao();
		
		ArrayList<Student> list = dao.listMembers();
		
		
			
			
			req.setAttribute("list", list);
			req.getRequestDispatcher("/jsp/pCheck.jsp").forward(req, resp);
			
		
		
		
	}
	
}
