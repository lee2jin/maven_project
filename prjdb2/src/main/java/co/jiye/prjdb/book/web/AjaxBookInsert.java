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

@WebServlet("/ajaxbookinsert.do")
public class AjaxBookInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxBookInsert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		String bookName = request.getParameter("bookName");
		String bookWriter = request.getParameter("bookWriter");
		String bookCom = request.getParameter("bookCom");
		String bookPrice = request.getParameter("bookPrice");
		System.out.println("book찍음"+bookId+bookName+bookWriter+bookCom+bookPrice);
		
		BookVO vo = new BookVO();
		vo.setBookId(bookId);
		vo.setBookName(bookName);
		vo.setBookWriter(bookWriter);
		vo.setBookCom(bookCom);
		vo.setBookPrice(Integer.valueOf(bookPrice));
		
		BookService dao = new BookServiceImpl();
		Map<String, Object> resultMap = new HashMap<>();
		int insert = dao.bookInsert(vo);
		
		if(insert != 0) {
			resultMap.put("retCode", "Success");
			resultMap.put("data", vo);
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
