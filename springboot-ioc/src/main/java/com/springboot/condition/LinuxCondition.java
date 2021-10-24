package com.springboot.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment environment = context.getEnvironment();
		BeanDefinitionRegistry registry = context.getRegistry();
		String property = environment.getProperty("os.name");
		if (property.contains("Linux")) {
			return true;
		}
		return false;
	}
}
