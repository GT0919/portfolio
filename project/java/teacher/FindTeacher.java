package teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/findPtable")
public class FindTeacher extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String pnumber = req.getParameter("pnumber");
		TeacherTableDao dao = new TeacherTableDao();
		TeacherTable p = dao.tablemember(pnumber);
		
		req.setAttribute("protable", p);
		req.getRequestDispatcher("viewP/viewPupdate.jsp").forward(req, resp);
	}

}
