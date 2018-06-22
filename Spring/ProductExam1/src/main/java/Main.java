import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import exam.product.ui.ProductUI;

public class Main {
	public static void main(String[] args)
	{
//		ProductDao productDao = new ProductDaoImpl();
//		ProductService productService = new ProductServiceImpl(productDao);
//		ProductUI productUI =new ProductUI();
//		productUI.setProductService(productService);
//		productUI.showMenu();
		
		ApplicationContext ctx = new GenericXmlApplicationContext("beans.xml");
		
		ProductUI productUI = (ProductUI)ctx.getBean("productUI");
		productUI.showMenu();
	}
}
