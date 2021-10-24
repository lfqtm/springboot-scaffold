package com.springboot.bean;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
public class Car implements InitializingBean, DisposableBean {
	private String brand;
	@Value("#{30-2}")
	private int age;
	private String driver;

	public void init() {
		System.out.println("init ... ");
	}

	public void destory() {
		System.out.println("destory ... ");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("InitializingBean init ... ");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("DisposableBean destory ... ");
	}

	@PostConstruct
	public void initByJsr() {
		System.out.println("PostConstruct init ... ");
	}

	@PreDestroy
	public void destoryByJsr() {
		System.out.println("PreDestroy destory ... ");
	}
}
