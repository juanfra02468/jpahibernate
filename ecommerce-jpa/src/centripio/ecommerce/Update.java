package centripio.ecommerce;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import centripio.ecommerce.entity.Customer;
import centripio.ecommerce.entity.enums.CustomerStatus;

public class Update {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = emFactory.createEntityManager();
		
//		em.getTransaction().begin();
//		
//		Customer customer_1 = em.find(Customer.class, 4L);
//		
//		customer_1.setFirstname("Ana");
//		customer_1.setLastname("Rodriguez");
//		
//		em.persist(customer_1); //Inserta o actualiza
//		
//		em.getTransaction().commit();
		
		
		em.getTransaction().begin();
		
		Customer customer1 = new Customer();
		customer1.setId(2L);
		customer1.setFirstname("Juan");
		customer1.setLastname("Hinojosa");
		customer1.setBirthday(LocalDate.now());
		customer1.setStatus(CustomerStatus.ACTIVE);
		em.merge(customer1);
		
		em.getTransaction().commit();
				
	}
}
