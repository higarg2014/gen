package reports.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeneratorApplication {

	public static void main(String[] args) {
		System.out.println("application started");
		SpringApplication.run(GeneratorApplication.class, args);
	}
}
