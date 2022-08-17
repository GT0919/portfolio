package Score;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertScore")
public class InsertScore extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String score_num = req.getParameter("score_num");
		int snumber=Integer.parseInt( req.getParameter("snumber"));
		int kor=Integer.parseInt( req.getParameter("kor"));
		int eng=Integer.parseInt( req.getParameter("eng"));
		int math=Integer.parseInt( req.getParameter("math"));
		
		StudentScore ss =new StudentScore(score_num, snumber, kor, eng, math);
		StudentScoreDao dao = new StudentScoreDao();
		dao.inserttable(ss);
		
		resp.sendRedirect("viewScore/viewScoreinsert.jsp");
	
	}

}