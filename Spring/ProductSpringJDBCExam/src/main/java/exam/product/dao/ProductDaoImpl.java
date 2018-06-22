package exam.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import exam.product.vo.ProductVo;

//어노테이션
@Component
//@Component어노테이션은 스프링이 대신 객체를 생성해준다.
// 실제로 영속성 처리하는 클래스
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ProductDaoImpl() {
	}
		
	@Override
	public ProductVo selectById(String id) {

		String sql
		 = "select * from product where id=?";
		
		List<ProductVo> products
		= jdbcTemplate.query(sql, 
				new RowMapper<ProductVo>() {
					public ProductVo mapRow(ResultSet rs, int rowNum)
						throws SQLException{
						
						ProductVo product = new ProductVo();
						String name = rs.getString("name");
						int price = rs.getInt("price");
						Date registerDate = rs.getTimestamp("registerDate");
						product.setId(id);
						product.setName(name);
						product.setPrice(price);
						product.setRegisterDate(registerDate);
						
						return product;
					}
				}, id);
		
		return products.isEmpty() ? null : products.get(0);
	}

	@Override
	public void insert(ProductVo product) {
		
		String sql 
		=  "insert into product (id, name, price, registerDate) " 
		                     +  "values(?, ?, ?, ?) ";
		
		jdbcTemplate.update(sql, product.getId(),
								product.getName(),
								product.getPrice(),
				new Timestamp(product.getRegisterDate().getTime()));
	}

	@Override
	public void update(ProductVo product) {
		
		String sql
		= "update product set name=?, price=?, registerDate=? "
		+ "where id=?";
		
		jdbcTemplate.update(sql, product.getName(),
								product.getPrice(),
				new Timestamp(product.getRegisterDate().getTime()),
				product.getId());		
	}

	@Override
	public void delete(String id) {

		String sql 
		= "delete from product where id=?";
		
		jdbcTemplate.update(sql, id);
	}

	@Override
	public Collection<ProductVo> selectAll() {
		
		String sql = "select * from product";
		
		List<ProductVo> products
		= jdbcTemplate.query(sql, 
				new RowMapper<ProductVo>() {
					public ProductVo mapRow(ResultSet rs, int rowNum)
						throws SQLException{
						
						ProductVo product = new ProductVo();
						String id = rs.getString("id");
						String name = rs.getString("name");
						int price = rs.getInt("price");
						Date registerDate = rs.getTimestamp("registerDate");
						product.setId(id);
						product.setName(name);
						product.setPrice(price);
						product.setRegisterDate(registerDate);
						
						return product;
					}
				});	
		
		return products;
	}

}