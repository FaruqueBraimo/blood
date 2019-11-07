package com.OptimizationBlood.blood;

import com.OptimizationBlood.blood.models.Dador;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class BloodApplication {

	private final static String ACCOUNT_SID = "ACf25404fa3da4d4986df7523deed096a0";
	private final static String AUTH_ID = "5c7fbbf758ecf6abdfaa2447affee243";


	static {
		Twilio.init(ACCOUNT_SID, AUTH_ID);
	}



	public void run(ApplicationArguments arg0) throws Exception {
		Message.creator(new PhoneNumber("25848828452"), new PhoneNumber("258846771216"),
				"Message from Spring Boot Application").create();
	}
	public static void main(String[] args) {
		SpringApplication.run(BloodApplication.class, args);
	}






}

