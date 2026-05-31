package in.pw.ioi;

import java.util.ArrayList;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.pw.ioi.config.AppConfig;
import in.pw.ioi.model.Product;
import in.pw.ioi.service.ProductService;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext cfg = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ProductService service = cfg.getBean("service", ProductService.class);
		
		ArrayList<Product> products = new ArrayList<>();
		products.add(new Product(4, "fossil", 35000, "chronography"));
		products.add(new Product(5, "tissot", 25000, "automatic"));
		products.add(new Product(6, "seiko", 32000, "chronography"));
		products.add(new Product(7, "guess", 31000, "analog"));
		products.add(new Product(8, "armani", 30000, "digital"));
		
		service.saveAllProducts(products);
		System.out.println("Products saved to database.........");
		cfg.close();
	}

}
