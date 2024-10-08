package centripio.ecommerce.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import centripio.ecommerce.entity.enums.CustomerStatus;

@Entity
@Table(name="customers")
//@SequenceGenerator(name="customer_sec", sequenceName="", initialValue=1, allocationSize=1) Para Oracle
public class Customer {

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="customer_sec" ) Para Oracle
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="first_name", length=30, nullable=false)
	private String firstname;
	
	@Column(name="last_name", length=50, nullable=false)
	private String lastname;
	
	@Transient
	private String fullName;
	
	//@Temporal(TemporalType.DATE)
	@Column(name="birthday", nullable=false)
	private LocalDate birthday;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reg_date", nullable=false, updatable=false)
	private LocalDateTime regDate = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	@Column(name="status", nullable=false, length=8)
	private CustomerStatus status;
	
//	@Column(name="number", precision=10, scale=4) //Scale y precision para BigDecimal
//	private BigDecimal number;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public CustomerStatus getStatus() {
		return status;
	}
	public void setStatus(CustomerStatus status) {
		this.status = status;
	}
	
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
		setFullName(firstname + " " + lastname); 
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
