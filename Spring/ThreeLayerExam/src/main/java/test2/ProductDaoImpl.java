package test2;


public class ProductDaoImpl implements ProductDao {

	@Override
	public Product getProduct() {
		//�����δ� ���⼭ DBó����
		return new Product("����",100);
	}

}
