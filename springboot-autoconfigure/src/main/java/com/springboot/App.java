package com.springboot;

import com.springboot.config.MyConfig;
import com.springboot.pojo.Person;
import com.springboot.pojo.Pet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Map;

//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.springboot")
public class App {

    public static void main(String[] args) {
	    ConfigurableApplicationContext run = SpringApplication.run(App.class, args);


	    MyConfig myConfig = run.getBean(MyConfig.class);
	    System.out.println("myConfig = " + myConfig);

	    Pet pet3 = myConfig.getPet();
	    Pet pet4 = myConfig.getPet();
	    System.out.println("通过config方法获取的 pet3 = pet4 ?" + (pet3 == pet4));

	    /*
	    当MyConfig.class中的@Configuration(proxyBeanMethods = false)时
	    myConfig = com.springboot.config.MyConfig@5b6e8f77
			通过config方法获取的 pet3 = pet4 ?false
	     */

      /*
	    当MyConfig.class中的@Configuration(proxyBeanMethods = true) (默认) 时
	    myConfig = com.springboot.config.MyConfig$$EnhancerBySpringCGLIB$$43a11984@759d81f3
			通过config方法获取的 pet3 = pet4 ?true

			保持组件单实例
	     */


	    Person p1 = myConfig.getPerson();
	    Person p2 = myConfig.getPerson();


	    System.out.println("p1和p2的pet ?" + (p1.getPet() == p2.getPet()));


	    System.out.println("++++++++");

	    //获取import组件
	    String[] beanNamesForType = run.getBeanNamesForType(Pet.class);
	    for (String s : beanNamesForType) {
		    System.out.println("s = " + s);
	    }

	    Map<String, Pet> beansOfType = run.getBeansOfType(Pet.class);
	    System.out.println("beansOfType = " + beansOfType);
    }
}
