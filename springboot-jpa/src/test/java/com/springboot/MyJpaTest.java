package com.springboot;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MyJpaTest {

	@Test
	public void test() {


		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		// save
		Customer customer = new Customer();
		customer.setCustName("传智播客");
		customer.setCustIndustry("教育");

		entityManager.persist(customer);

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();

	}

}
