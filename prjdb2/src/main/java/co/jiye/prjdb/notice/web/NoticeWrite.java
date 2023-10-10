package co.jiye.prjdb.notice.web;

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

import co.jiye.prjdb.common.ThumbNail;
import co.jiye.prjdb.common.ViewResolve;
import co.jiye.prjdb.notice.service.NoticeService;
import co.jiye.prjdb.notice.service.NoticeVO;
import co.jiye.prjdb.notice.serviceImpl.NoticeServiceImpl;

@WebServlet("/noticewrite.do")
public class NoticeWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeWrite() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파일 업로드 처리(Notice)
		ThumbNail thumbNail= new ThumbNail(); //썸네일
		NoticeService dao= new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		String saveDir = getServletContext().getRealPath("attech/notice");
		int maxSize = 1024 * 1024 * 100;// 100Mbyte
		
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, "utf-8",
				new DefaultFileRenamePolicy());
		String imgFileName = multi.getOriginalFileName("imgfile"); //원본파일명
		String realImg = multi.getFilesystemName("imgfile"); // 저장되는 파일명
		
		vo.setNoticeImage(realImg); //이미지 파일 명을 저장
		String attech= multi.getOriginalFileName("attechfile");
		if(attech != null) {
			String attechFile = multi.getFilesystemName("attechfile");
			vo.setNoticeAttech(attechFile);
		}
		String fileExt=imgFileName.substring(imgFileName.lastIndexOf(".")+1); //확장자 명
		
		vo.setNoticeThumb(thumbNail.makeThumbnail(saveDir+File.separator+imgFileName, imgFileName, fileExt,saveDir+File.separator));
		vo.setNoticeWriter(multi.getParameter("noticeWriter"));
		vo.setNoticeDate(LocalDate.parse(multi.getParameter("noticeDate")));
		vo.setNoticeTitle(multi.getParameter("noticeTitle"));
		vo.setNoticeSubject(multi.getParameter("noticeSubject"));
		vo.setNoticeWriterName(multi.getParameter("noticeWriterName"));
		
		int n= dao.noticeInsert(vo);
		if(n!=0) {
			response.sendRedirect("noticeselectlist.do");
		} else {
			request.setAttribute("message", "게시글 등록이 실패했습니다.");
			String page = "notice/noticemessage";
			ViewResolve.views(request, response, page);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
