package in.pw.ioi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.pw.ioi.dao.IProductDao;
import in.pw.ioi.model.Product;

@Service("service")
public class ProductService {
	
	@Autowired
	private IProductDao productDao;
	
	@Transactional
	public void saveAllProducts(List<Product> products) {
		productDao.saveListOfProducts(products);
	}
}
