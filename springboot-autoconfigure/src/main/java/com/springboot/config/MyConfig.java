package com.springboot.config;

import com.springboot.pojo.Person;
import com.springboot.pojo.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类默认单实例的 (proxyBeanMethods = true);在调用时会默认检查容器中是否存在bean
 *
 * 组件没有依赖关系时一般设置为false,启动快
 * 有依赖的话默认就行
 *
 * 例如: person依赖pet
 *
 */
@Configuration(proxyBeanMethods = false)
public class MyConfig {

	@Bean("tom")
	public Pet getPet() {
		return new Pet("旺财", 3);
	}

	@Bean
	public Person getPerson() {
		Pet pet = new Pet("旺财", 3);
		return new Person("3", "校长", "10", pet);
	}

}
