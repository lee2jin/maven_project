package co.jiye.prjdb.notice.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.jiye.prjdb.common.ViewResolve;
import co.jiye.prjdb.notice.service.NoticeService;
import co.jiye.prjdb.notice.service.NoticeVO;
import co.jiye.prjdb.notice.serviceImpl.NoticeServiceImpl;

@WebServlet("/noticeselectlist.do")
public class NoticeSelectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeSelectList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> notices = new ArrayList<NoticeVO>();
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("email");
		System.out.println(id);
		notices= dao.noticeSelectList();
		request.setAttribute("notices", notices);
		
		String page="notice/noticeselectlist";
		ViewResolve.views(request, response, page);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
