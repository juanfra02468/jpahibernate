package centripio.ecommerce;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import centripio.ecommerce.entity.Customer;

public class Querys {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		// JPQL = Java Persistence Query Language
//		Query query_1 = em.createQuery("SELECT e from Customer e where e.id = :id"); //SELECT * FROM customers
//		query_1.setParameter("id", 4L);
//		List<Customer> customers = query_1.getResultList();
		
		
		TypedQuery<Customer> query_1 = em.createQuery("SELECT e from Customer e where e.firstname = :firstname", Customer.class); //SELECT * FROM customers
		query_1.setParameter("firstname", "Juan");
		List<Customer> customers = query_1.getResultList();
		
		for(Customer current : customers) {
			System.out.println(current.getFirstname());
		}
	}
}
