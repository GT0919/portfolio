package Score;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listScore3")
public class ListScore3 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentScoreDao dao = new StudentScoreDao();
		ArrayList<StudentScore> list = dao.table();
		
		req.setAttribute("list1", list);
		req.getRequestDispatcher("/listStudent.20_").forward(req, resp);
		
	}

}
