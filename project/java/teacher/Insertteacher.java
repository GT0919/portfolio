package teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertPtable")
public class Insertteacher extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String pnumber = req.getParameter("pnumber");
		String p_id = req.getParameter("p_id");
		String p_pw = req.getParameter("p_pw");
		String p_name =req.getParameter("p_name");
		String main =req.getParameter("class");
		String ban =req.getParameter("ban");
		
		TeacherTable ta =new TeacherTable(pnumber, p_id, p_pw, p_name, main, ban);
		TeacherTableDao dao = new TeacherTableDao();
		dao.inserttable(ta);
		
		resp.sendRedirect("/project/html/login.html");
	
	}

}