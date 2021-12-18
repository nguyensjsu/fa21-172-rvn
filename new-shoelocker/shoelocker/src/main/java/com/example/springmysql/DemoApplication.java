package com.example.springmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import java.sql.*;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;




@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class DemoApplication {

	
	public static void main(String[] args) {	
		System.out.println("MYSQL_HOST: " + System.getenv("MYSQL_HOST"));

		SpringApplication.run(DemoApplication.class, args);
	}



}
