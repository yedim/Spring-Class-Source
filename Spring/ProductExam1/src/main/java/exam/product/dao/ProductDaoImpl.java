package exam.product.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import exam.product.vo.ProductVo;

@Component
//@Component �������� ��� ��ü�� ������ش�. ������ ���Ӽ� ó���ϴ� Ŭ����
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
	public void update(ProductVo product) {//������ Ű�� ������ �����
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
