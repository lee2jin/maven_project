package co.jin.project.memver.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jin.project.common.ViewResolve;
import co.jin.project.memver.service.MemberService;
import co.jin.project.memver.service.MemberVO;
import co.jin.project.memver.serviceImpl.MemberServiceImpl;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		// Service 객체 생성 > dao
		// MemberVo 생성
		// vo 넘어온 값 담고
		String id = request.getParameter("memberId");
		String password = request.getParameter("memberPassword");		
		//dao 호출  
		vo=dao.memberSelect(vo);
		//결과처리
		if(vo != null) {
			request.setAttribute("message", "로그인 성공");
		}else {
			request.setAttribute("message", "로그인 실패");
		}		
		String page = "member/membermessage";
		ViewResolve.views(request, response, page);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
