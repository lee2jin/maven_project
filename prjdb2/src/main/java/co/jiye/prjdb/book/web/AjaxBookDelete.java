package co.jiye.prjdb.book.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.jiye.prjdb.book.service.BookService;
import co.jiye.prjdb.book.service.BookVO;
import co.jiye.prjdb.book.serviceImpl.BookServiceImpl;

@WebServlet("/ajaxbookdelete.do")
public class AjaxBookDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxBookDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bid");
		BookVO vo = new BookVO();
		vo.setBookId(bookId);
		System.out.println("..."+bookId);
		
		BookService dao = new BookServiceImpl();
		Map<String, Object> resultMap = new HashMap<>();
		int delete = dao.bookDelete(vo);
		
		if(delete != 0) {
			resultMap.put("retCode", "Success");
		}else {
			resultMap.put("retCode", "Fail");
		}
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(resultMap);
		
		response.setContentType("text/json; charset=utf-8");
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
