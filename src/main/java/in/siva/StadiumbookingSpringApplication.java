package in.siva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("in.siva")
public class StadiumbookingSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(StadiumbookingSpringApplication.class, args);
	}

}
