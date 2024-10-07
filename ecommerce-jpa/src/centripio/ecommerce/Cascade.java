package centripio.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import centripio.ecommerce.entity.Customer;
import centripio.ecommerce.entity.Order;
import centripio.ecommerce.entity.OrderLine;
import centripio.ecommerce.entity.Payment;
import centripio.ecommerce.entity.Product;
import centripio.ecommerce.entity.enums.PayMethod;

public class Cascade {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Payment payment1 = new Payment();
		payment1.setAmount(100d);
		payment1.setPaymethod(PayMethod.CASH);
		
		Customer customer1 = em.find(Customer.class, 1L);
		
		Order order1 = new Order();
		order1.setCustomer(customer1);
		order1.setPayment(payment1);
		
		Product product1 = em.find(Product.class, 1L);
		
		for (int i = 0; i < 10; i++) {
			OrderLine line = new OrderLine();
			line.setProduct(product1);
			line.setQuantity(i+1d);
			line.setUnitPrice(product1.getPrice());
			order1.addLines(line);
		}
		
		em.persist(order1);
		
		em.getTransaction().commit();
	}
}
