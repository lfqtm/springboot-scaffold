package com.springboot.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ConfigurationPropertiesConfig.class)
public class MyConfigTest {

	@Autowired
	ConfigurationPropertiesConfig cpc;

	@Test
	public void testConfiguration() {
		System.out.println("cpc = " + cpc);


	}
}
