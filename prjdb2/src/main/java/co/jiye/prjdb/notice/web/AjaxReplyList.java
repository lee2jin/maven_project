package co.jiye.prjdb.notice.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.jiye.prjdb.notice.service.ReplyService;
import co.jiye.prjdb.notice.service.ReplyVO;
import co.jiye.prjdb.notice.serviceImpl.ReplyServiceImpl;

@WebServlet("/AjaxReplyList.do")
public class AjaxReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxReplyList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String nid = request.getParameter("nid");
		
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.listReply(Integer.parseInt(nid));
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json =objectMapper.writeValueAsString(list);
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out =  response.getWriter();
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
