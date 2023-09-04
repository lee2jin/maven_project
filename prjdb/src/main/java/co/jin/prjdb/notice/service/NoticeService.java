package co.jin.prjdb.notice.service;

import java.util.List;

public interface NoticeService {
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	void noticeHitUpdate(int id); //조회수 증가
	
	List<NoticeVO> noticeSelectList(String key, String val); //검색을 위해서 두개의 값을 받음
	}
