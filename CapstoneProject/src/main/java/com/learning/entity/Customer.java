package com.learning.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	private String fullName;
	private String userName;
	private String password;
	private String phone;
	private int secretQuestion;
	private String secretAnswer;
	private boolean status;
	
	@OneToMany(mappedBy="customer")
    private Set<Beneficiary> beneficiaries;
	@OneToMany(mappedBy="customer")
    private Set<Account> accounts;
	
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSecretQuestion() {
		return secretQuestion;
	}
	public void setSecretQuestion(int secretQuestion) {
		this.secretQuestion = secretQuestion;
	}
	public String getSecretAnswer() {
		return secretAnswer;
	}
	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Set<Beneficiary> getBeneficiaries() {
		return beneficiaries;
	}
	public void setBeneficiaries(Set<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}
	public Set<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	public Customer(long customerId, String fullName, String userName, String password, String phone,
			int secretQuestion, String secretAnswer, boolean status, Set<Beneficiary> beneficiaries,
			Set<Account> accounts) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.secretQuestion = secretQuestion;
		this.secretAnswer = secretAnswer;
		this.status = status;
		this.beneficiaries = beneficiaries;
		this.accounts = accounts;
	}
	public Customer() {
		super();
	}

	
	
	
}
