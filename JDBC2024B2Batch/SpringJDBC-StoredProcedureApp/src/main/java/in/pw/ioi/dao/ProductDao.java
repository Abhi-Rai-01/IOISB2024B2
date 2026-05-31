package in.pw.ioi.dao;

import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import in.pw.ioi.model.Product;

@Repository("dao") //SQLException -----> DataAccessException
public class ProductDao {
	private SimpleJdbcCall simpleJdbcCall;

	@Autowired
	public ProductDao(JdbcTemplate jdbcTemplate) {
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("get_product_by_id")
							  .declareParameters(
							      // IN parameter
							   	  new SqlParameter("productId", Types.INTEGER),
							   	  //OUT parameter
							   	  new SqlOutParameter("productName", Types.VARCHAR),
							   	  new SqlOutParameter("productCost", Types.INTEGER),
							   	  new SqlOutParameter("productType", Types.VARCHAR)
							   
							  );// be very careful with the type mismatch
	}
	
	public Product getProductById(Integer productId) {
		MapSqlParameterSource params = new MapSqlParameterSource().addValue("productId", productId);
		
		Map<String, Object> out = simpleJdbcCall.execute(params);
		
		if (out.get("productName") == null) {
			return null;
		} else {
			String productName = (String) out.get("productName");
			Integer productCost = (Integer) out.get("productCost");
			String productType = (String) out.get("productType");
			
			Product product = new Product();
			product.setPid(productId);
			product.setPname(productName);
			product.setPcost(productCost);
			product.setPtype(productType);
			
			return product;
		}
	}
}
