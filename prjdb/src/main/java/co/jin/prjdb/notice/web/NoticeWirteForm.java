package co.jin.prjdb.notice.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jin.prjdb.common.ViewResolve;

@WebServlet("/noticewriteform.do")
public class NoticeWirteForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeWirteForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "notice/noticewriteform";
		ViewResolve.views(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}