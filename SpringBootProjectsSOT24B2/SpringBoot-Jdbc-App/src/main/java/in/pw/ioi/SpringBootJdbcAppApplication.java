package in.pw.ioi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootApplication
public class SpringBootJdbcAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringBootJdbcAppApplication.class, args);
		JdbcTemplate jdbcTemplate = container.getBean("jdbcTemplate", JdbcTemplate.class);
		System.out.println(jdbcTemplate);
		
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = container.getBean("namedParameterJdbcTemplate", NamedParameterJdbcTemplate.class);
		System.out.println(namedParameterJdbcTemplate);
	}
}
