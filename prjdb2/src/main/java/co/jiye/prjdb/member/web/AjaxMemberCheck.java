package co.jiye.prjdb.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jiye.prjdb.member.service.MemberService;
import co.jiye.prjdb.member.service.MemberVO;
import co.jiye.prjdb.member.serviceImpl.MemberServiceImpl;

@WebServlet("/aJaxmembercheck.do")
public class AjaxMemberCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxMemberCheck() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService dao= new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("memberId"));
		vo = dao.memberSelect(vo);
		String str="Yes"; //사용가능한 아이디
		if(vo!= null) {
			str="No"; //이미 존재하는 아이디
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append(str);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
