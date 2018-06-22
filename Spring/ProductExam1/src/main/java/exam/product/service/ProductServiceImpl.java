package exam.product.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import exam.product.dao.ProductDao;
import exam.product.vo.ProductVo;

@Component

//비즈니스 로직을 실제 구현한 클래스
public class ProductServiceImpl implements ProductService {
	//서비스는 DAO에 의존함.
	//따라서 ProductDao객체를 주입해야함
	//(1) 생성자를 통해서 주입
	//(2) 세터를 통해서 주입
	
	@Autowired //자동으로 객체와 객체를 연결(constructor arg 대신 쓰는거야)
	private ProductDao productDao;
	
	//생성자를 통해 ProductDao 객체 주입
	public ProductServiceImpl(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	//세터를 통한 ProductDao객체 주입.
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public void registerProdcut(ProductVo newProduct) {
		// productDao에게 위임
		ProductVo product = productDao.selectById(newProduct.getId());
		if(product!=null)
		{
			throw new AlreadyExistingProductException();
		}
		newProduct.setRegisterDate(new Date());
		productDao.insert(newProduct);
	}

	@Override
	public ProductVo getProduct(String id) {
		// TODO Auto-generated method stub
		ProductVo product = productDao.selectById(id);
		if(product==null)
		{
			throw new ProductNotFoundException();
		}
		return product;

	}

	@Override
	public void changeProductPrice(ProductVo updateproduct) {
		// TODO Auto-generated method stub
		ProductVo product = productDao.selectById(updateproduct.getId());
		
		if(product==null)
		{
			throw new ProductNotFoundException();
		}
		updateproduct.setName(product.getName());
		updateproduct.setRegisterDate(product.getRegisterDate());
		
		productDao.update(updateproduct);
	}

	@Override
	public Collection<ProductVo> getProducts() {
		// TODO Auto-generated method stub
		return productDao.selectAll();
	}

	public void removeProduct(String id)
	{
		ProductVo product=productDao.selectById(id);
		
		if(product ==null)
		{
			throw new ProductNotFoundException();
		}
		productDao.delete(id);
	}
}
