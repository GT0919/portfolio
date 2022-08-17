package student;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/listStudent.20_3")
public class FlistStudent3 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		StudentDao dao = new StudentDao();
		ArrayList<Student> list = dao.listMembers();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/findScore").forward(req, resp);
			
		
		
		
	}
	
}
