package mc.springboot.rest.example.springbootjpawithhibernateandh2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootJpaWithHibernateAndH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaWithHibernateAndH2Application.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
