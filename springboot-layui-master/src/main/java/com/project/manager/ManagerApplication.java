package com.project.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.project.manager.dao")
@EnableTransactionManagement
public class ManagerApplication {


	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);
	}
}
