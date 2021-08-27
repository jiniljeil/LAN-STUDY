package com.security.ghost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SecureCodingApplication {
	
	//@Override
	//protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	//	return builder.sources(SecureCodingApplication.class);
	//}
	
   public static void main(String[] args) {
      SpringApplication.run(SecureCodingApplication.class, args);
   }

}
