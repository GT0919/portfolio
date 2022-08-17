package Score;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listScore")
public class ListScore extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentScoreDao dao = new StudentScoreDao();
		ArrayList<StudentScore> list = dao.table();
		PrintWriter out = resp.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("<table>");
		
		for(int i=0; i<list.size(); i++) {
			out.print("<tr><td>");
			out.print(list.get(i).toString());
			out.print("</tr></td>");
			
			
		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}

}
