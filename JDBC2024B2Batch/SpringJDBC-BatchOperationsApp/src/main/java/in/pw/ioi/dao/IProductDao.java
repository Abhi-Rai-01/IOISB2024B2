package in.pw.ioi.dao;

import java.util.List;

import in.pw.ioi.model.Product;

public interface IProductDao {
	public void saveListOfProducts(List<Product> products);
}
