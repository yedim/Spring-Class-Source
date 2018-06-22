package exam.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SelectTest {
	private JdbcTemplate jdbcTemplate;

	public SelectTest(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public void queryForObject()
	{
		String query="select count(*) from singer_group";
		int count= jdbcTemplate.queryForObject(query, Integer.class);
		System.out.println("�׷�� : "+count);
	}
	
	public void queryForObject(int member)
	{
		String query="select name from singer_group where member=?";
		String name =jdbcTemplate.queryForObject(query,String.class,member); //?�� member�� ���ڴ�.
		System.out.println(member+"�� �׷��̸�="+name);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("beans.xml");
		
		SelectTest selectTest = ctx.getBean("selectTest",SelectTest.class);
		selectTest.queryForObject();
		selectTest.queryForObject(13);
	}
}
