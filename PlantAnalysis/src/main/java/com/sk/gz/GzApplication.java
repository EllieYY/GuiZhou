package com.sk.gz;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan(value = "com.sk.gz.dao")
@SpringBootApplication
public class GzApplication {

	public static void main(String[] args) {
		SpringApplication.run(GzApplication.class, args);
	}

}
