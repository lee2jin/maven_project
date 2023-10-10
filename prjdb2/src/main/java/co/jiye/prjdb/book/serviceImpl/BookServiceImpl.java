package co.jiye.prjdb.book.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.jiye.prjdb.book.map.BookMapper;
import co.jiye.prjdb.book.service.BookService;
import co.jiye.prjdb.book.service.BookVO;
import co.jiye.prjdb.common.DataSource;

public class BookServiceImpl implements BookService {
	
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private BookMapper map = sqlSession.getMapper(BookMapper.class);

	@Override
	public int bookInsert(BookVO vo) {
		return map.bookInsert(vo);
	}

	@Override
	public int bookDelete(BookVO vo) {
		return map.bookDelete(vo);
	}

	@Override
	public int bookSelect(BookVO vo) {
		return bookSelect(vo);
	}


	@Override
	public List<BookVO> bookList() {
		return map.bookList();
	}
	
}
