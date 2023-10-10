package co.jiye.prjdb.book.map;

import java.util.List;

import co.jiye.prjdb.book.service.BookVO;

public interface BookMapper {
	List<BookVO> bookList();
	int bookSelect(BookVO vo);
	int bookInsert(BookVO vo);
	int bookDelete(BookVO vo);
}
