package slogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.Student;
import student.StudentDao;
import teacher.TeacherTable;
import teacher.TeacherTableDao;


@WebServlet("/loginok")
public class Login  extends HttpServlet{
	
   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setContentType("text/html;utf-8");
		   response.setCharacterEncoding("UTF-8");
		   
		   String id = request.getParameter("loginid");
		   String pw=request.getParameter("loginpw");
		   HttpSession session = request.getSession();   // 세션을 가져오는 구문		   
		   session.setAttribute("id", id);
		   session.setAttribute("pw", pw);
		 
		   
		   StudentDao dao = new StudentDao();
		   ArrayList<Student> list =  dao.listMembers();
		   PrintWriter out = response.getWriter();
		   for(int i=0; i<list.size(); i++) {
				
				if(list.get(i).getId().equals(id) ) {
				
					if(list.get(i).getPw().equals( session.getAttribute("pw"))) {
						Student s = dao.getStudent(id);
						request.setAttribute("protable", s);
						request.getRequestDispatcher("/html/s_main.html").forward(request, response);
					}else {
						//out.print("<script>alert('비밀번호 오류.')</script>");
						//request.getRequestDispatcher("/html/login.html").forward(request, response);
						out.println("<script language='javascript'>");
								out.println("alert('비밀번호가 잘못입력됐습니다.')");
								out.println("</script>");
						response.sendRedirect("html/login.html");
					}
				}
				
				
			}
		   
		  // response.sendRedirect("html/s_main.html");
	}
	
}



