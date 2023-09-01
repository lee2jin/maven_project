package co.jin.project.memver.serviceImpl;

import org.apache.ibatis.session.SqlSession;

import co.jin.project.common.DataSource;
import co.jin.project.memver.mapper.MemberMapper;
import co.jin.project.memver.service.MemberService;
import co.jin.project.memver.service.MemberVO;

public class MemberServiceImpl implements MemberService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private MemberMapper map = SqlSession.getMapper(MemberMapper.class);
	
	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
