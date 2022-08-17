package Score;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.Student;
import student.StudentDao;
import teacher.TeacherTable;
import teacher.TeacherTableDao;

@WebServlet("/updateScore")
public class UpdateScore extends HttpServlet{
	
	
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
		
		StudentScoreDao dao = new StudentScoreDao();
		dao.updatetable(score_num, snumber, kor, eng, math);
		StudentScore ss = dao.tablemember(score_num);
		
		req.setAttribute("score", ss);
		StudentDao dao1 = new StudentDao();
		ArrayList<Student> list = dao1.listMembers();
		req.setAttribute("list", list);
		req.getRequestDispatcher("viewScore/viewScoreupdate.jsp").forward(req, resp);
		
	}
	

}
