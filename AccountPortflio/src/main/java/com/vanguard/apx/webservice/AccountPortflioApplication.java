package com.vanguard.apx.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AccountPortflioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountPortflioApplication.class, args);
	}

}
