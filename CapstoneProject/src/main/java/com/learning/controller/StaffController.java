package com.learning.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.learning.entity.Account;
import com.learning.entity.Beneficiary;
import com.learning.entity.Customer;
import com.learning.entity.Staff;
import com.learning.entity.Transaction;
import com.learning.service.StaffService;

@RestController
@CrossOrigin
@RequestMapping("/api/staff")
public class StaffController {

	@Autowired
	StaffService staffService;
	@GetMapping("/account/{accountNo}")
	public List<Transaction> getAcctStatement(@PathVariable("accountNo") int accountNO) {
		return staffService.getBalanceInfo(accountNO);
		
		
		
	}
	@GetMapping("/getstaff")
	public List<Staff>getStaff(){
		return staffService.allStaff();
		
		
	}
	
	@GetMapping("/test")
	public List<Transaction> getAllTransaction(){
		return staffService.getAllTransaction();
		
		
		
	}
	@GetMapping("/account")
	public Account getAccountById(@RequestBody long accountid){
		return staffService.getaccountByid(accountid);
		
		
		
	}
	
	@GetMapping("/beneficiary/approval")
	public List<Beneficiary> getBeneficiaryforApproval() {
		
		return staffService.getBeneficaryforApproval();
		
	}
	
	@GetMapping("/customer/search/{accountid}")
	public String getCustomerByAccountId(@PathVariable("accountid") long accountid) {
		Account acc= new Account();
		acc=staffService.getaccountByid(accountid);
	    Customer cust=new Customer();
		cust=acc.getCustomer();
		String name=cust.getFullName();
		return name;
		
	}
	
	@PutMapping("/beneficiary/approve")
	public ResponseEntity<List<Beneficiary>> approveBeneficiary(@RequestBody int customerid) {
		List<Beneficiary> listBen= new ArrayList<>();
		List<Beneficiary> listBen2= new ArrayList<>();
		
		
		listBen=staffService.getBenficiarybyId(customerid);
		Beneficiary beneficiary=null;
		for (int i = 0; i < listBen.size(); i++) {
			beneficiary=listBen.get(i);
			beneficiary.setApproved(true);
			staffService.saveBeneficiary(beneficiary);
			listBen2.add(beneficiary);
		}
		 return ResponseEntity.ok(listBen2);
	}
	
	@PutMapping("/beneficiary/change/status")
	public ResponseEntity<Beneficiary> changeStatus(@RequestBody int beneficiaryId){
		Beneficiary Ben = new Beneficiary();
		Ben=staffService.getBeneficaryByBenId(beneficiaryId);
		if(Ben.isApproved()==true) {
			Ben.setApproved(false);
			staffService.saveBeneficiary(Ben);
			
		}
		else if(Ben.isApproved()==false) {
			Ben.setApproved(true);
			staffService.saveBeneficiary(Ben);
			
		}
		return ResponseEntity.ok(Ben);
		
		
	}
	
	@GetMapping("/account/approval")
	public List<Account> getAcctApprove() {
		return staffService.getAccountforApproval();
		
	}
	@PutMapping("/account/change/status")
	public ResponseEntity<Account> changeStatusAccount(@RequestBody long accountId){
		 Account acc=new Account();
		acc=staffService.getaccountByid(accountId);
		if(acc.isAccountStatus()==true) {
			acc.setAccountStatus(false);
			staffService.saveAccount(acc);
			
		}
		else if(acc.isAccountStatus()==false) {
			acc.setAccountStatus(true);
			staffService.saveAccount(acc);
			
		}
		return ResponseEntity.ok(acc);
	}
	
	@PutMapping("/account/approve")
	public ResponseEntity<List<Account>> approveAccts(@RequestBody int customerid) {
		List<Account> listAcc= new ArrayList<>();
		List<Account> listAcc2= new ArrayList<>();
		
		
	          
		listAcc=staffService.getAccountbyId(customerid);
		Account account=null;
		for(int i=0; i< listAcc.size();i++) {
			account=listAcc.get(i);
			account.setAccountStatus(true);
			staffService.saveAccount(account);
			listAcc2.add(account);
			
		}
		return ResponseEntity.ok(listAcc2);
		
		
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return staffService.getAllCustomers();
		
		
	}
	@PutMapping("/customer")
	public ResponseEntity<Customer> approveEnableCustomer(@RequestBody long customerid) {
		Customer customer= new Customer();
		customer=staffService.getcustomerByid(customerid);
		if (customer.isStatus()==true) {
			customer.setStatus(false);
			staffService.saveCustomer(customer);
			return ResponseEntity.ok(customer);
			
		}
		else if(customer.isStatus()==false) {
			customer.setStatus(true);
			staffService.saveCustomer(customer);
			return ResponseEntity.ok(customer);
			
			
		}
		return ResponseEntity.ok(customer);
		
		
	}
	@GetMapping("/customer/{customerId}")
	public Customer getCustomersWithId(@PathVariable("customerId") Long customerId) {
		return staffService.getcustomerByid(customerId);
		
		
		
	}
	@PutMapping("/transfer")
	public ResponseEntity<Transaction> Transfer(@RequestBody Transaction transactionDetails) {
		
		Transaction transaction= new Transaction();
		Account account1= new Account();
		Account account2= new Account();
		transaction=transactionDetails;
		staffService.saveTransaction(transaction);
		double money=transaction.getAmount();
	  
		account1=staffService.getaccountByid(transaction.getFromAccountNo());
		
		account2=staffService.getaccountByid(transaction.getToAccountNo());
		
		
		if(transaction.isTransactionType()==false) {
			
			account1.setAccountBalance(account1.getAccountBalance()-money);
			account2.setAccountBalance(account2.getAccountBalance()+money);
			staffService.saveAccount(account2);
			staffService.saveAccount(account1);
			return ResponseEntity.ok(transaction);
			
		}
		else if(transaction.isTransactionType()==true) {
			
			account1.setAccountBalance(account1.getAccountBalance()+money);
			account2.setAccountBalance(account2.getAccountBalance()-money);
			
			
			staffService.saveAccount(account2);
			staffService.saveAccount(account1);
			return ResponseEntity.ok(transaction);
			
		}
		
		return ResponseEntity.ok(transaction);
		
		
	}
	
	
	
	
    
    @GetMapping("/account/info/{accountid}")
    public Account getAccountById(@PathVariable("accountid") int accountid){
            return staffService.getaccountByid((long) accountid);
            
            
            
    }
	
	
	
}
