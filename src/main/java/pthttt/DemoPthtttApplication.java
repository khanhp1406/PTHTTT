package pthttt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"pthttt.controller"})
public class DemoPthtttApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoPthtttApplication.class, args);
	}

}
