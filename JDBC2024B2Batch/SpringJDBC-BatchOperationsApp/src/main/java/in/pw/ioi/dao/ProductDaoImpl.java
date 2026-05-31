package in.pw.ioi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.pw.ioi.model.Product;


@Repository("dao") //SQLException -----> DataAccessException
public class ProductDaoImpl implements IProductDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveListOfProducts(List<Product> products) {
		// TODO Auto-generated method stub
		jdbcTemplate.batchUpdate("Insert into product(`pid`, `pname`, `pcost`, `ptype`) values(?, ?, ?, ?)",
								 products, 100,
								 (ps, product) -> {
									ps.setInt(1, product.getPid());
									ps.setString(2, product.getPname());
									ps.setInt(3, product.getPcost());
									ps.setString(4, product.getPtype());
								 });
	}
}
