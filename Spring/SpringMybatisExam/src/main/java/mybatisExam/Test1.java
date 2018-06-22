package mybatisExam;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test1 {
	
	private SqlSession sqlSession;

	public Test1(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}
	
	public void selectOne(){//결과 하나일때
		int count=sqlSession.selectOne("exam.test.SingerMapper.getSingerCount");
		System.out.println("그룹수 : "+count);
	}
	
	public void selectOne1(String name){//결과 하나일때
		int count=sqlSession.selectOne("exam.test.SingerMapper.getSingerMember",name);
		System.out.println("그룹 멤버수 : "+count);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("beans.xml");
		
		Test1 t= ctx.getBean("test1",Test1.class);
		t.selectOne();
		t.selectOne1("EXO");
	}
}
