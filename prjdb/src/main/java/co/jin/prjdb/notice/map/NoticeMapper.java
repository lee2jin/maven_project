package co.jin.prjdb.notice.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jin.prjdb.notice.service.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	void noticeHitUpdate(int id); //조회수 증가
	
	//맵퍼 인터페이스는 매개변수가 2개 이상이면 @Param(넘어오는 변수명) 사용해줘야함
	List<NoticeVO> noticeSelectList(@Param("key")String key, @Param("val")String val);
}
