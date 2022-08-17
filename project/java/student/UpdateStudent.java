package student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateStudent.27")
public class UpdateStudent extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		StudentDao dao = new StudentDao();
		
		dao.updatePassword(id, pw);
		
		resp.sendRedirect("kds-view/confirm.jsp");
		
		
		
	}
	
}
