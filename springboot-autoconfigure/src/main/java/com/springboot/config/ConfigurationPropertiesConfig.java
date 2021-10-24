package com.springboot.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jyy")
@Data
@ToString
public class ConfigurationPropertiesConfig {

	private String id;
	private String name;

}
