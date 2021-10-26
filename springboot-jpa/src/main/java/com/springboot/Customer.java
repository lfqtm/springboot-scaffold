package com.springboot;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer")
public class Customer {

	/**
	 * @see GenerationType
	 * 配置主键的生产策略
	 *  IDENTITY:支持自增
	 *  SEQUENCE:支持序列
	 *  TABLE:新增表完成主键自增
	 *  AUTO:最优策略
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id")
	private Long custId;

	@Column(name = "cust_name")
	private String custName;

	@Column(name = "cust_source")
	private String custSource;

	@Column(name = "cust_level")
	private String custLevel;

	@Column(name = "cust_industry")
	private String custIndustry;

	@Column(name = "cust_phone")
	private String custPhone;

	@Column(name = "cust_address")
	private String custAddress;
}
