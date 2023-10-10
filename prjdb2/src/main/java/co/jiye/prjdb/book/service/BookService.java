package co.jiye.prjdb.book.service;

import java.util.List;

public interface BookService {
	List<BookVO> bookList();
	int bookSelect(BookVO vo);
	int bookInsert(BookVO vo);
	int bookDelete(BookVO vo);
}
