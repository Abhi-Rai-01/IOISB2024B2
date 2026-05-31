package in.pw.ioi;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.pw.ioi.config.AppConfig;
import in.pw.ioi.dao.ProductDao;
import in.pw.ioi.model.Product;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext cfg = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ProductDao dao = cfg.getBean("dao", ProductDao.class);
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the productId of the product to be searched: ");
		int productId = scanner.nextInt();
		Product result = dao.getProductById(productId);
		
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
