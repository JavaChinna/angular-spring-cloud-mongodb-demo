package com.javachinna;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.javachinna")
@EnableEurekaClient
public class UserAuthServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplicationBuilder app = new SpringApplicationBuilder(UserAuthServiceApplication.class);
		app.run();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(UserAuthServiceApplication.class);
	}
}
