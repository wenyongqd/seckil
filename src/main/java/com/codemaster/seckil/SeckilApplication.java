package com.codemaster.seckil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class SeckilApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeckilApplication.class, args);
	}

}
