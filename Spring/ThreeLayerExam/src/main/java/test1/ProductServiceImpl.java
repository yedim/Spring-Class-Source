package test1;

public class ProductServiceImpl implements ProductService {

	//���� ���̾�� DAO���̾ ������
	private ProductDao productDao;
	
	//���͸� ���� DAO����
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
		
	@Override
	public Product getProduct() {
		// TODO Auto-generated method stub
		return productDao.getProduct();
	}
	
	

}
