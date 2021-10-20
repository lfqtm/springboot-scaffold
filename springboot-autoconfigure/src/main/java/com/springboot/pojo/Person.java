package com.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
	private String eid;
	private String name;
	private String level;
	private Pet pet;
}
