package centripio.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import centripio.ecommerce.entity.Customer;
import centripio.ecommerce.entity.Order;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		/*em.getTransaction().begin();
		Customer customer_1 = em.find(Customer.class, 1L);
		em.remove(customer_1);
		em.getTransaction().commit();*/
		
		em.getTransaction().begin();
		Order order1 = em.find(Order.class, 1L);
		em.remove(order1);
		em.getTransaction().commit();
	}
}
