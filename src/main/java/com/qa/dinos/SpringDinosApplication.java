package com.qa.dinos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.qa.dinos.service.DinoService;
import com.qa.dinos.web.DinoController;

@SpringBootApplication
public class SpringDinosApplication {

	public static void main(String[] args) {
		// DONT DO THIS
		// DANGER DANGER DANGER
		// FOR DEMO PURPOSES ONLY
		ApplicationContext beanBag = SpringApplication.run(SpringDinosApplication.class, args);

		DinoController controller = beanBag.getBean(DinoController.class);
		System.out.println(controller);
		DinoService service = beanBag.getBean(DinoService.class);
		System.out.println(service);
	}

}
