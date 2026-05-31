package in.pw.ioi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.pw.ioi.dao.ProductDao;
import in.pw.ioi.model.Product;

@Service("service")
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Transactional(readOnly = true) // by default true only
	public Product getProductFromDaoUsingId(Integer productId) {
		return productDao.getProductById(productId);
	}
}
