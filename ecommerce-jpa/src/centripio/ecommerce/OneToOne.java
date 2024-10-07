package centripio.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import centripio.ecommerce.entity.Customer;
import centripio.ecommerce.entity.Order;
import centripio.ecommerce.entity.OrderLine;
import centripio.ecommerce.entity.Payment;
import centripio.ecommerce.entity.enums.PayMethod;

public class OneToOne {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		Customer customer1 = em.find(Customer.class, 1L);

		Order order1 = new Order();
		
		order1.setCustomer(customer1);		
		em.persist(order1);
		
		for(int i=0; i<10; i++) {
			OrderLine line = new OrderLine();
			//line.setProduct("PRODUCT " + (i+1));
			line.setQuantity(i+1d);
			line.setUnitPrice((i+1)*10d);
			order1.addLines(line);
			
			em.persist(line);
		}
		
		
		Payment payment1 = new Payment();
		payment1.setAmount(order1.getTotal());
		payment1.setPaymethod(PayMethod.CREDIT);
		order1.setPayment(payment1);
		
		em.persist(payment1);
		
		em.persist(order1);
		
		em.getTransaction().commit();
		
		em.detach(order1);
		em.detach(payment1);
		
		Order order2 = em.find(Order.class, 1L);
		System.out.println(order2.getPayment().getPaymethod());
		
	}
}
