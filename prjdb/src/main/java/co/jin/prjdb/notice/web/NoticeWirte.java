package co.jin.prjdb.notice.web;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.jin.prjdb.common.ThumbNail;
import co.jin.prjdb.common.ViewResolve;
import co.jin.prjdb.notice.service.NoticeService;
import co.jin.prjdb.notice.service.NoticeVO;
import co.jin.prjdb.notice.serviceImpl.NoticeServiceImpl;

@WebServlet("/noticewrite.do")
public class NoticeWirte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeWirte() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 업로드 처리(Notice)
		ThumbNail thumbNail = new ThumbNail();
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		String saveDir = getServletContext().getRealPath("attech/notice"); //운영서버에 올릴때는 뺄것(실무)
		
		int maxSize = 1024 *1024 * 100; //100Mbyte
		MultipartRequest multi = new MultipartRequest(
				request,
				saveDir, //저장할공간
				maxSize, //최대사이즈
				"utf-8", //엔코딩타입
				new DefaultFileRenamePolicy()); //같은이름일때 자동으로 이름을 바꿔주는것
		
		String imgFileName = multi.getOriginalFileName("imgfile"); //원본파일명
		String realImg = multi.getFilesystemName("imgfile"); //저장되는 파일명
		
		vo.setNoticeImage(realImg); //이미지 파일 명을 저장한다.
		
		String filePath = saveDir + File.separator + imgFileName;
		String thumb = thumbNail.makeThumbNail(filePath);

		System.out.println(thumb + "==================");
		
		
		String attech = multi.getOriginalFileName("attechfile");
		if(attech != null) {
			String attechFile = multi.getFilesystemName("attechfile");
			vo.setNoticeAttech(attechFile);
		}
		vo.setNoticeWriter(multi.getParameter("noticeWriter"));
		vo.setNoticeDate(LocalDate.parse(multi.getParameter("noticeDate")));
		vo.setNoticeTitle(multi.getParameter("noticeTitle"));
		vo.setNoticeContent(multi.getParameter("noticeContent"));
		vo.setNoticeWriterName(multi.getParameter("noticeWirterName"));
		
		int n = dao.noticeInsert(vo);
		if (n != 0) {
			response.sendRedirect("noticeselectlist.do");
		}else {
			request.setAttribute("massage", "게시글 등록이 실패했습니다.");
			String page = "notice/noticemessage";
			ViewResolve.views(request, response, page);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
