package com.springboot.config;

import com.springboot.bean.Ant;
import com.springboot.bean.Color;
import com.springboot.bean.ColorFactory;
import com.springboot.bean.Person;
import com.springboot.condition.LinuxCondition;
import com.springboot.condition.MyImportBeanDefinitionRegistrar;
import com.springboot.condition.MyImportSelector;
import com.springboot.condition.WindowsCondition;
import org.springframework.context.annotation.*;

@Configuration
@Import({Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class}) //引入bean的一种方式
public class PersonConfig {

	@Bean
	@Scope("prototype")
	public Person getPerson() {
		System.out.println("注入person");
		return new Person(15, "小兰");
	}

	@Bean
	@Lazy //懒加载，调用时加载
	public Ant getAnt() {
		System.out.println("注入ant");
		return new Ant(1, "安东尼");
	}

	@Bean("linus")
	@Conditional(LinuxCondition.class)
	public Person getLinuxPerson() {
		return new Person(54, "linus");
	}

	@Bean("bill")
	@Conditional(WindowsCondition.class)
	public Person getWindowsPerson() {
		return new Person(67, "bill");
	}

	@Bean("colorFactory")
	public ColorFactory getColorFactory() {
		return new ColorFactory();
	}
}
