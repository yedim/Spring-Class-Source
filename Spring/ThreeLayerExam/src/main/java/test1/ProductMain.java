package test1;

public class ProductMain {
	public static void main(String[] args) {
		ProductDao productDao = new ProductDaoImpl();
		ProductService productService=new ProductServiceImpl();
		((ProductServiceImpl)productService).setProductDao(productDao);
		
		Product product = productService.getProduct();
		System.out.println(product);
	}
}
