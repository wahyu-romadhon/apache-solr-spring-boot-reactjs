package solrapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataSolrApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataSolrApplication.class, args);
		System.out.println("Server solr is running!!!");
	}
}
