package com.learning.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Staff;
import com.learning.entity.Account;
import com.learning.entity.Beneficiary;
import com.learning.entity.Customer;
import com.learning.entity.Transaction;
import com.learning.repo.AccountRepo;
import com.learning.repo.BeneficiaryRepo;
import com.learning.repo.CustomerRepo;
import com.learning.repo.StaffRepo;
import com.learning.repo.TransactionRepo;

@Service
public class StaffService {
	  @Autowired
	  StaffRepo staffRepo;
	  
	  @Autowired
	  BeneficiaryRepo beneficiaryRepo;
	  
	  @Autowired
	  AccountRepo accountRepo;
	  
	  @Autowired
	  CustomerRepo customerRepo;
	  @Autowired
	  TransactionRepo transactionRepo;
	  
public List<Transaction> getBalanceInfo(int customerid){
		  
		  
		  
		  return transactionRepo.AccountStatement(customerid);
	  }
	  public List<Beneficiary> getBeneficaryforApproval(){
		  
		  return beneficiaryRepo.FindBenficiaryForApproval();
		  
	  }
	  public List<Account> getAccountforApproval(){
		  return accountRepo.FindAccountForApproval();
		  	  
	  }
	  
	  public List<Customer> getAllCustomers(){
		  return customerRepo.findAll();
		  
		  
		  
	  }
	  
	  public Customer getcustomerByid(Long customerId) {
		  return customerRepo.findById(customerId).get();
		  
		  
	  }
	  public Account getaccountByid(Long accountId) {
		  return accountRepo.findById(accountId).get();
		  
		  
	  }
	 
		
	  
	public List<Beneficiary> getBenficiarybyId(long customerid){
		
		
		return beneficiaryRepo.FindBenficiaryForCustomer(customerid);
		
		
		
	}
	public void saveBeneficiary(Beneficiary beneficiary) {
		
		
		beneficiaryRepo.save(beneficiary);
	}
	
  public List<Account> getAccountbyId(long customerid){
		
		
		return accountRepo.FindAccountForCustomer(customerid);
		
		
		
	}
	public void saveAccount(Account account) {
		
		
		accountRepo.save(account);
	}
	
	
public void saveCustomer(Customer customer) {
		
		
		customerRepo.save(customer);
	}
public void saveTransaction(Transaction transaction) {
	
	// TODO Auto-generated method stub
	transactionRepo.save(transaction);
}
public List<Transaction> getAllTransaction() {
	// TODO Auto-generated method stub
	return transactionRepo.findAll();
}
public List<Staff> allStaff() {
	// TODO Auto-generated method stub
	return staffRepo.findAll();
}
	
public Beneficiary getBeneficaryByBenId(long beneficiaryId) {
	// TODO Auto-generated method stub
	return beneficiaryRepo.findById( beneficiaryId).get();
}
		  
	  



}
