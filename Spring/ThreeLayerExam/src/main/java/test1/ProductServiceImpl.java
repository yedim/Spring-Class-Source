package test1;

public class ProductServiceImpl implements ProductService {

	//서비스 레이어는 DAO레이어에 의존함
	private ProductDao productDao;
	
	//세터를 통해 DAO주입
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
		
	@Override
	public Product getProduct() {
		// TODO Auto-generated method stub
		return productDao.getProduct();
	}
	
	

}
