package Score;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/fscore")
public class SfullScore extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		StudentScoreDao dao = new StudentScoreDao();
		
		ArrayList<StudentScore> list = dao.table();
		
		
			
			
			req.setAttribute("list", list);
			req.getRequestDispatcher("jsp/sRank.jsp").forward(req, resp);
			System.out.println("test");
			
		
		
		
	}
	
}
