package centripio.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import centripio.ecommerce.entity.enums.PayMethod;

@Entity
@Table(name="payment")
public class Payment {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@OneToOne
	@JoinColumn(name="fk_order", nullable=false, updatable=false, unique=true)
	private Order order;
	
	@Enumerated(EnumType.STRING)
	@Column(name="pay_method", nullable=false)
	private PayMethod paymethod;
	
	@Column(name="amount", nullable=false)
	private Double amount = 0d;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public PayMethod getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(PayMethod paymethod) {
		this.paymethod = paymethod;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	
}
