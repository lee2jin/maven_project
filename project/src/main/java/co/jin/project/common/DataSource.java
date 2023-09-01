package co.jin.project.common;

import org.apache.ibatis.session.SqlSessionFactory;

public class DataSource {
	private static SqlSessionFactory sqlSessionFactory;
	private DataSource() {}
	
	public static SqlSessionFactory getInstance() {
		String resource = "mybais-config.xml"
	}
}
