package test3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class ProductMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("beans2.xml");
		
		ProductService productService = ctx.getBean("service",ProductService.class);
		
		Product product = productService.getProduct();
		System.out.println(product);
	}
}
