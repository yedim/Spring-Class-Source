package exam.product.service;

import java.util.Collection;

import exam.product.vo.ProductVo;

public interface ProductService {

	//제품등록
	public void registerProdcut(ProductVo productVo);
	//하나의 제품 검색
	public ProductVo getProduct(String id);
	//제품 가격 수정
	public void changeProductPrice(ProductVo product);
	//전체 제품 조회
	public Collection<ProductVo> getProducts();
	//제품 삭제
	public void removeProduct(String id);
}
