package teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatePtable")
public class UpdateTeacher extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String pnumber = req.getParameter("pnumber");
		String p_pw = req.getParameter("p_pw");
		String p_name = req.getParameter("p_name");
		String main = req.getParameter("main");
		String ban = req.getParameter("ban");
		
		TeacherTableDao dao = new TeacherTableDao();
		dao.updatetable(pnumber,p_pw, p_name, main, ban);
		TeacherTable p = dao.tablemember(pnumber);
		req.setAttribute("protable", p);
		req.getRequestDispatcher("viewP/viewPupdate.jsp").forward(req, resp);
		
	}
	

}
