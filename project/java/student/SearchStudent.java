package student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/searchstudent.20_")
public class SearchStudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = "a100";
		
		StudentDao dao = new StudentDao();
		
		Student s = dao.getStudent(id);
		
		//System.out.println(m.getM_birthday());
		//System.out.println(m.getM_name());
		
		req.setAttribute("student", s);
		
		req.getRequestDispatcher("/kds-view/studentview.jsp").forward(req, resp);
		
	}
}