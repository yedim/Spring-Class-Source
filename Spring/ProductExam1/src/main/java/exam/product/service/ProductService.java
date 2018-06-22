package exam.product.service;

import java.util.Collection;

import exam.product.vo.ProductVo;

public interface ProductService {

	//��ǰ���
	public void registerProdcut(ProductVo productVo);
	//�ϳ��� ��ǰ �˻�
	public ProductVo getProduct(String id);
	//��ǰ ���� ����
	public void changeProductPrice(ProductVo product);
	//��ü ��ǰ ��ȸ
	public Collection<ProductVo> getProducts();
	//��ǰ ����
	public void removeProduct(String id);
}
