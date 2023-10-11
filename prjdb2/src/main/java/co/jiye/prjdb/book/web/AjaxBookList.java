package co.jiye.prjdb.book.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
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

@WebServlet("/ajaxbooklist.do")
public class AjaxBookList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxBookList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookService dao = new BookServiceImpl();
		List<BookVO> books = dao.bookList();
		String param = request.getParameter("param");
		
		if(param == null) {
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(books);
			
			response.setContentType("text/json;charset=utf-8"); // 한글깨짐방지

			PrintWriter out = response.getWriter(); // json 문자열로 반환해줌
			out.print(json);
		}else {
			String json = "{\"data\":[";
			json += "]}";
			Map<String, Object>map = new HashMap<>();
			map.put("data", books);
			
			ObjectMapper objectMapper = new ObjectMapper(); // LocalDate 쓰면 registerModule 넣어줘야함
			json = objectMapper.writeValueAsString(map); // 객체를 스트링으로 바꿔줌
			
			
			response.setContentType("text/json;charset=utf-8"); // 한글깨짐방지
			PrintWriter out = response.getWriter(); // json 문자열로 반환해줌
			out.print(json);


		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
