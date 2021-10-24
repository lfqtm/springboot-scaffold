package com.springboot.config;

import com.springboot.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:person.properties")
public class BeanLifeConfig {


	@Bean(name = "car", initMethod = "init", destroyMethod = "destory")
	public Car getCar() {
		return new Car();
	}

	@Bean
	public Car getCar2() {
		return new Car();
	}
}
