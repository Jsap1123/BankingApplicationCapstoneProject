package com.learning.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;
	private String reason;
	private long fromAccountNo;
	private long toAccountNo;
	private double amount;
	private Date date;
	private boolean transactionType;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public long getFromAccountNo() {
		return fromAccountNo;
	}
	public void setFromAccountNo(long fromAccountNo) {
		this.fromAccountNo = fromAccountNo;
	}
	public long getToAccountNo() {
		return toAccountNo;
	}
	public void setToAccountNo(long toAccountNo) {
		this.toAccountNo = toAccountNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isTransactionType() {
		return transactionType;
	}
	public void setTransactionType(boolean transactionType) {
		this.transactionType = transactionType;
	}
	public Transaction(long id, String reason, long fromAccountNo, long toAccountNo, double amount, Date date,
			boolean transactionType) {
		super();
		this.id = id;
		this.reason = reason;
		this.fromAccountNo = fromAccountNo;
		this.toAccountNo = toAccountNo;
		this.amount = amount;
		this.date = date;
		this.transactionType = transactionType;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
