package co.jiye.prjdb.notice.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jiye.prjdb.notice.service.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	void noticeHitUpdate(int id);
	List<NoticeVO> noticeSelectList(@Param("key") String key,@Param("val") String val);
}
