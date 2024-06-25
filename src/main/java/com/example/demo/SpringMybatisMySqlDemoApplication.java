package com.example.demo;

import java.util.List;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.domain.User;
import com.example.demo.repository.UserMapper;

@MappedTypes(User.class)
@MapperScan("com.example.demo.repository")
@SpringBootApplication
public class SpringMybatisMySqlDemoApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {		
		SpringApplication.run(SpringMybatisMySqlDemoApplication.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringMybatisMySqlDemoApplication.class);
    }
}
