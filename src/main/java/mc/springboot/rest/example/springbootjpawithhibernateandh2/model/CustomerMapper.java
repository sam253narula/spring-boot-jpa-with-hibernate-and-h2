package mc.springboot.rest.example.springbootjpawithhibernateandh2.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public final class CustomerMapper implements RowMapper<Customer> {
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getLong("id"));
		customer.setName(rs.getString("name"));
		customer.setAge(rs.getInt("age"));
		return customer;
	}
}
