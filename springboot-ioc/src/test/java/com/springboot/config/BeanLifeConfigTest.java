package com.springboot.config;

import com.springboot.bean.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration()
public class BeanLifeConfigTest {

	/**
	 * 对象创建时
	 *  单实例：在容器启动时创建，非lazy方式
	 *  多实例：每次获取时创建
	 *
	 * 初始化方法
	 *  对象创建完成，并赋值好，调用初始化方法
	 *
	 * 销毁
	 *  单实例：容器关闭时
	 *  多实例：容器不会关联这个bean，不会主动销毁这个方法
	 */
	@Test
	public void testBeanLife() {
		AnnotationConfigApplicationContext ioc
				= new AnnotationConfigApplicationContext(BeanLifeConfig.class);

		Car car = ioc.getBean("car", Car.class);
		ioc.close();
	}

	@Test
	public void testBeanLifeWithInitializingBeanAndDisposableBean() {
		AnnotationConfigApplicationContext ioc
				= new AnnotationConfigApplicationContext(BeanLifeConfig.class);

		Car car = ioc.getBean("getCar2", Car.class);
		ioc.close();
	}

	@Test
	public void testAnnotationValue() {
		AnnotationConfigApplicationContext ioc
				= new AnnotationConfigApplicationContext(BeanLifeConfig.class);

		Car car = ioc.getBean("car", Car.class);
		System.out.println("car = " + car);

		ConfigurableEnvironment env = ioc.getEnvironment();
		String property = env.getProperty("person.name");
		System.out.println("name = " + property);
	}
}
