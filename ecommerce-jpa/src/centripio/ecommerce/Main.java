package centripio.ecommerce;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import centripio.ecommerce.entity.Customer;
import centripio.ecommerce.entity.enums.CustomerStatus;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		
		em.getTransaction().begin();
		
		Customer customer1 = new Customer();
		customer1.setFirstname("Juanfra");
		customer1.setLastname("Garcia");
		customer1.setBirthday(LocalDate.now());
		customer1.setStatus(CustomerStatus.ACTIVE);
		em.persist(customer1);
		
		Customer customer2 = new Customer();
		customer2.setFirstname("Pepe");
		customer2.setLastname("Perez");
		customer2.setBirthday(LocalDate.now());
		customer2.setStatus(CustomerStatus.INACTIVE);
		em.persist(customer2);
		
		em.getTransaction().commit();
	}
}
