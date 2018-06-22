package exam.product.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import exam.product.vo.ProductVo;

@Component
//@Component 스프링이 대신 객체를 만들어준다. 실제로 영속성 처리하는 클래스
public class ProductDaoImpl implements ProductDao {

	private Map<String, ProductVo> map = new HashMap<String,ProductVo>();//key, value
	
	@Override
	public ProductVo selectById(String id) {
		// TODO Auto-generated method stub
		return map.get(id);
	}

	@Override
	public void insert(ProductVo product) {
		// TODO Auto-generated method stub
		map.put(product.getId(), product);
	}

	@Override
	public void update(ProductVo product) {//동일한 키가 있으면 덮어쓰기
		// TODO Auto-generated method stub
		map.put(product.getId(), product);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		map.remove(id);
	}

	@Override
	public Collection<ProductVo> selectAll() {
		// TODO Auto-generated method stub
		return map.values();
	}

}
