package com.stage.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class SpringbootbackendApplication implements CommandLineRunner{
     
	public static Logger logger = LoggerFactory.getLogger(SpringbootbackendApplication.class);
	

	public static void main(String[] args) {
		
		logger.info("this is a info message");
	    logger.warn("this is a warn message");
		logger.error("this is a error message");
		SpringApplication.run(SpringbootbackendApplication.class, args);
		
	
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
