package co.jin.prj.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jin.prj.common.ViewResolve;

@WebServlet("/adminhome.do")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminHome() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "management/adminhome";
		ViewResolve.forward(request, response, page);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
