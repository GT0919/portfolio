package slogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/orders")
public class ListOrder  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		 
		  response.setContentType("text/html;utf-8");
		  response.setCharacterEncoding("UTF-8");
		   
		   
		  PrintWriter out  =response.getWriter();
		  HttpSession session = request.getSession();   // 세션을 가져오는 구문	
		  String id  =  (String) session.getAttribute("id");
		  if( id == null) {
			   response.sendRedirect("login.html");
		  }else {
			   response.sendRedirect("orders.html");
		  }
		
	}
}
