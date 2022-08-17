package Score;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/findScore")
public class FindScore extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String score_num = req.getParameter("score_num");
		StudentScoreDao dao = new StudentScoreDao();
		StudentScore ss = dao.tablemember(score_num);
		
		req.setAttribute("score", ss);
		req.getRequestDispatcher("viewScore/viewScoreupdate.jsp").forward(req, resp);
	}

}
