package com.learning.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="beneficiary")
public class Beneficiary {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private long beneficiaryId;
	private long beneficiaryAccountNo; 
	private String beneficiaryName;  
	private boolean active;
	private boolean isApproved;
	
	private Date addedDate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customer_id", nullable = false)
	@JsonIgnore
	private Customer customer;
	public long getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	public long getBeneficiaryAccountNo() {
		return beneficiaryAccountNo;
	}
	public void setBeneficiaryAccountNo(long beneficiaryAccountNo) {
		this.beneficiaryAccountNo = beneficiaryAccountNo;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Beneficiary(long beneficiaryId, long beneficiaryAccountNo, String beneficiaryName, boolean active,
			boolean isApproved, Date addedDate, Customer customer) {
		super();
		this.beneficiaryId = beneficiaryId;
		this.beneficiaryAccountNo = beneficiaryAccountNo;
		this.beneficiaryName = beneficiaryName;
		this.active = active;
		this.isApproved = isApproved;
		this.addedDate = addedDate;
		this.customer = customer;
	}
	public Beneficiary() {
		super();
	}

	

}
