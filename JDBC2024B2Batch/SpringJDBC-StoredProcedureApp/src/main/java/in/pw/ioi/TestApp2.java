package in.pw.ioi;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.pw.ioi.config.AppConfig;
import in.pw.ioi.model.Product;
import in.pw.ioi.service.ProductService;

public class TestApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext cfg = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ProductService service = cfg.getBean("service", ProductService.class);
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the productId of the product to be searched: ");
		int productId = scanner.nextInt();
		Product result = service.getProductFromDaoUsingId(productId);
		
		if(result != null) {
			System.out.println(result);
		}
		else {
			System.out.println("Record not available for the given Id: "+productId);
		}
		
		scanner.close();
		cfg.close();
	}

}
