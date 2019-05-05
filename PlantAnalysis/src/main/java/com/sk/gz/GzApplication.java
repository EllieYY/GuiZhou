package com.sk.gz;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@MapperScan(value = "com.sk.gz.dao")
@SpringBootApplication
public class GzApplication {

	public static void main(String[] args) {
		SpringApplication.run(GzApplication.class, args);
	}

}
