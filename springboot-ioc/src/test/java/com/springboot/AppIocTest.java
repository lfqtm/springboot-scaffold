package com.springboot;

import com.springboot.bean.Ant;
import com.springboot.bean.Color;
import com.springboot.bean.ColorFactory;
import com.springboot.bean.Person;

import com.springboot.config.PersonConfig;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

@SpringBootTest
public class AppIocTest {

	@Test
	public void getBeanFromXml() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");
		Person person = context.getBean("person", Person.class);
		assertEquals(person, new Person(13, "小钱"));
	}

	@Test
	public void getBeanFromJava() {
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(PersonConfig.class);
		Person getPerson = acac.getBean("getPerson", Person.class); //默认为方法名获取
		Person getPerson1 = acac.getBean("getPerson", Person.class); //默认为方法名获取

		//@see PersonConfig#getPerson() scope指定为prototype
		assertNotSame(getPerson, getPerson1);

		//@see PersonConfig#getPerson() scope指定为singleton 默认
//		assertSame(getPerson, getPerson1);

//		assertEquals(getPerson, new Person(15, "小兰"));
	}

	@Test
	public void testLazy() {
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(PersonConfig.class);
		System.out.println("ioc加载完毕，准备获取ant");
		Ant getAnt = acac.getBean("getAnt", Ant.class);
		System.out.println("getAnt = " + getAnt);
	}

	@Test
	public void testCondition() {
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(PersonConfig.class);
		String[] names = ioc.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}

	@Test
	public void testFactoryBean() throws Exception {
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(PersonConfig.class);
		Color color = ioc.getBean("colorFactory", Color.class); //实际上返回了一个Color对象
		System.out.println("colorFactory = " + color);
		ColorFactory colorFactory = ioc.getBean("&colorFactory", ColorFactory.class); //加上&，返回的是工厂bean
		System.out.println("colorFactory = " + colorFactory);
		Color object = colorFactory.getObject();
		System.out.println("object = " + object);
	}


}
