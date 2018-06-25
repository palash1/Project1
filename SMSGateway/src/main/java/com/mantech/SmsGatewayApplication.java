package com.mantech;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SmsGatewayApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		/*PrintStream o=null;
		try {
			o = new PrintStream(new File("H:/New folder/aa.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setOut(o);*/
		SpringApplication.run(SmsGatewayApplication.class, args);
	}
}
