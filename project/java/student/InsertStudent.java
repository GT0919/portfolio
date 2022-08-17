package student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertStudent.27")
public class InsertStudent  extends HttpServlet{


	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;utf-8");
		
		String year =  request.getParameter("year");
		String month =request.getParameter("month");
		String day = request.getParameter("day");
		String result = year+month+day;
		
		
		
		
		int snumber= Integer.parseInt(request.getParameter("snumber"));
		String id = request.getParameter("id");
		String pw =request.getParameter("pw");
		String name=request.getParameter("name");
		String birthday=result;
		
		int ban = Integer.parseInt(request.getParameter("ban"));
		
		
					
		Student s = new Student(snumber, id, pw, name, birthday,ban);
		StudentDao dao = new StudentDao();
		dao.insertMember(s);	
		
		//다른 페이지로 이동
		response.sendRedirect("kds-view/confirm.jsp"); 
	}
	 
	
	
	 
}
