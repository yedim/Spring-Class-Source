package exam.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class SelectTest2 {
	private JdbcTemplate jdbcTemplate;

	public SelectTest2(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Singer> query(int member)
	{
		String query = "select * from singer_group where member=?";
		
		List<Singer> singers = jdbcTemplate.query(query, new RowMapper<Singer>(){
			public Singer mapRow(ResultSet rs, int rowNum)throws SQLException{
				Singer s = new Singer();
				s.setName(rs.getString("name"));
				s.setMember(rs.getInt("member"));
				
				return s;
			}
		},member);
		return singers;
	}
	
	public Singer queryForObject(String name)
	{
		String query = "select * from singer_group where name=?";//queryForObject�� ������ ����� �ϳ� �־�� �ǰ�, query�� �־ ��� �ȴ�. query�� ���� ���.
		Singer singer = jdbcTemplate.queryForObject(query, 
				new BeanPropertyRowMapper<Singer>(Singer.class),name);//�̸��� ������ query�޼ҵ�ó�� setName setMember���ص� ��.
		
		return singer;
	}
	
	public List<Singer> query1(int member){
		String query = "select * from singer_group where member=?";
		List<Singer> singers = jdbcTemplate.query(query, new BeanPropertyRowMapper<Singer>(Singer.class),member);
		
		return singers;
	}
	
	public void update(String name)
	{
		String query ="update singer_group set member=6 where name=?";
		
		int updateCount = jdbcTemplate.update(query, name);
		System.out.println(updateCount+"���� ���ڵ尡 ������.");
	}
	
	public void update(Singer singer)
	{
		String query ="update singer_group set member=? where name=?";
		int updateCount = jdbcTemplate.update(query, singer.getMember(),singer.getName());
		
		System.out.println(updateCount + "���� ���ڵ尡 ������.");
	}
	
	public void insert(Singer singer){
		String query = "insert into singer_group values(?, ?)";
		int count = jdbcTemplate.update(query,singer.getName(),singer.getMember());
		System.out.println(count + "���� ���ڵ尡 ������.");
	}
	
	public void delete(String name){
		String query = "delete from singer_group where name=?";
		int count = jdbcTemplate.update(query,name);
		System.out.println(count + "���� ���ڵ尡 ������.");
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("beans.xml");
		
		SelectTest2 selectTest2 = ctx.getBean("selectTest2", SelectTest2.class);
		
		List<Singer> singers = selectTest2.query(7);
		for(Singer singer:singers){
			System.out.println(singer);
		}
		
		Singer singer = selectTest2.queryForObject("EXO");
		System.out.println(singer);
		
		List<Singer> singers1 = selectTest2.query(7);
		for(Singer singer1:singers1){
			System.out.println(singer1);
		}
		
		selectTest2.update("�ҳ�ô�");
		
		selectTest2.update(new Singer("�ҳ�ô�",7));
		
		selectTest2.insert(new Singer("���",5));
	
		selectTest2.delete("���");
	}
}
