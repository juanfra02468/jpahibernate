package centripio.ecommerce;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import centripio.ecommerce.entity.Customer;
import centripio.ecommerce.entity.Order;
import centripio.ecommerce.entity.enums.Status;

public class ManyToOne {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Customer customer1 = em.find(Customer.class, 1L);
		
		Order order1 = new Order();
		order1.setCustomer(customer1);
		order1.setRedDate(LocalDateTime.now());
		order1.setStatus(Status.INACTIVE);
		order1.setTotal(100d);
		
		em.persist(order1);
		
		em.getTransaction().commit();
		
//		Order order1 = em.find(Order.class, 1L);
//		System.out.println(order1.getTotal() + ", " +order1.getCustomer().getFirstname());
	}
}
