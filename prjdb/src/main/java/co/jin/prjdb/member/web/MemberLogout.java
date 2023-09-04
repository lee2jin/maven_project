package co.jin.prjdb.member.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.jin.prjdb.common.ViewResolve;

@WebServlet("/memberlogout.do")
public class MemberLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLogout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(); // 필요한 클래스 생성
		
		String name = (String)session.getAttribute("name"); //처리
		session.invalidate();//세션정보를 완전히 삭제한다
		
		request.setAttribute("message",name +"님 로그아웃 되었습니다"); //처리된 결과를 전달할 데이터 담고
		String page = "member/membermessage"; // 담은것을 보여줄 페이지 선택
		ViewResolve.views(request, response, page); //선택된 페이지를 ViewResolve를 통해 보여줌
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
