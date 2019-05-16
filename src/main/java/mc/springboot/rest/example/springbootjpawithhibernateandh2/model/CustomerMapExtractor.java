package mc.springboot.rest.example.springbootjpawithhibernateandh2.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.ResultSetExtractor;

public class CustomerMapExtractor
		implements
			ResultSetExtractor<Map<String, List<String>>> {
	@Override
	public Map<String, List<String>> extractData(ResultSet rs)
			throws SQLException {
		Map<String, List<String>> CustomersMap = new HashMap<>();
		while (rs.next()) {
			Long id = rs.getLong("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			List<String> Customers = CustomersMap.get(name);
			if (Customers == null) {
				List<String> newCustomers = new ArrayList<>();
				CustomersMap.put(name, newCustomers);
			} else {
				Customers.add(name);
			}
		}
		return CustomersMap;
	}
}