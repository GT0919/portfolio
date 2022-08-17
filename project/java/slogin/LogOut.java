package slogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogOut extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;utf-8");
		 response.setCharacterEncoding("UTF-8"); 
		
		HttpSession session = request.getSession();		
		// 세션 지우기
		session.invalidate();
		
		
		
		response.sendRedirect("html/login.html");
		
		
	}
}
