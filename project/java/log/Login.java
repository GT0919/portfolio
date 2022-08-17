package log;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teacher.TeacherTable;
import teacher.TeacherTableDao;

@WebServlet("/loginpro")
public class Login extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String id =req.getParameter("loginid");
		String pw=req.getParameter("loginpw");
		
		HttpSession session = req.getSession();
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);
		
		TeacherTableDao dao = new TeacherTableDao();
		ArrayList<TeacherTable> list =  dao.table();
		
		PrintWriter out = resp.getWriter();
		/*for(int i=0; i<list.size(); i++) {
			out.print(list.get(i).getp_id());
			out.print("\n");
			out.print(id);
		}*/
		
		for(int i=0; i<list.size(); i++) {
			//out.print(list.get(i).getp_name());
			if(list.get(i).getp_id().equals(id) ) {
				//out.print("id 성공");
				if(list.get(i).getp_pw().equals( session.getAttribute("pw"))) {
					TeacherTable p = dao.tablemember2(id);
					req.setAttribute("protable", p);
					req.getRequestDispatcher("/html/p_main.html").forward(req, resp);
				}else {
					out.print("<script>alert('비밀번호 오류.')</script>");
					req.getRequestDispatcher("/html/login.html").forward(req, resp);
				}
			}
			
		}
		out.print("<script>alert('아이디오류.')</script>");
		req.getRequestDispatcher("/html/login.html").forward(req, resp);
	
	}

}
