package csse;

import csse.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("csse")
public class Application {
    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
