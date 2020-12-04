package mainapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@SpringBootApplication
@EntityScan(basePackages = "model")
@ComponentScan(basePackages = {"controller", "repository"})
@EnableSolrRepositories("repository")
public class SpringDataSolrApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataSolrApplication.class, args);
		System.out.println("Server is running!!!");
	}
}
