package com.springboot.config;

import com.springboot.pojo.Pet;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(Pet.class)
@Configuration
public class ImportConfig {
}
