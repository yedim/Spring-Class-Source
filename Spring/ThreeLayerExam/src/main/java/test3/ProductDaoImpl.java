package test3;

import org.springframework.stereotype.Component;

@Component
public class ProductDaoImpl implements ProductDao {

	@Override
	public Product getProduct() {
		//�����δ� ���⼭ DBó����
		return new Product("����",100);
	}

}
