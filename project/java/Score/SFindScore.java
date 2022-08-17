package Score;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sfindScore")
public class SFindScore extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 HttpSession session = req.getSession();   // 세션을 가져오는 구문	
		   
		  
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String score_num = (String) session.getAttribute("id");
		StudentScoreDao dao = new StudentScoreDao();
		StudentScore ss = dao.Studenttablemember(score_num);
		
		req.setAttribute("score", ss);
		req.getRequestDispatcher("jsp/sCheck.jsp").forward(req, resp);
	
	}

}
