package co.jiye.prjdb.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolve {
	public static void forward(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		String prefix = "WEB-INF/views/";
		String suffix=".jsp";
		String viewPage = prefix + page + suffix;
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	public static void views(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		String jsppage = "WEB-INF/views/"+page+".jsp";
		
		
		RequestDispatcher dispatcher= request.getRequestDispatcher(jsppage);
		dispatcher.forward(request, response);
	}
}
