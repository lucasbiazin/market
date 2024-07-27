package br.com.tbiazin.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.tbiazin.repository")
public
class MarketApplicationTests {

	 public static void main(String[] args) {
	        SpringApplication.run(MarketApplication.class, args);
	    }
}
