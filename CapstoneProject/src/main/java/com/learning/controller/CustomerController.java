package com.learning.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Account;
import com.learning.entity.Beneficiary;
import com.learning.entity.Customer;
import com.learning.repo.AccountRepo;
import com.learning.repo.BeneficiaryRepo;
import com.learning.repo.CustomerRepo;

@RestController
@CrossOrigin
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	AccountRepo accountRepo;
	@Autowired
	BeneficiaryRepo beneficiaryRepo;

	@PostMapping("/register")
	public Customer registerCustomer(@RequestBody Customer customer) {
		return customerRepo.save(customer);
	}
	
	@GetMapping("/getcustomers")
	public List<Customer> getAllCustomer() {
		return customerRepo.findAll();
	}
	
	@PostMapping("/{customerId}/postaccount")
	public Account createAccount(@RequestBody Account account, @PathVariable Long customerId) {
		account.setCustomer(getCustomerByCustomerId(customerId));
		return accountRepo.save(account);
	}
	
	@GetMapping("/{customerId}/getaccount")
	public List<Account> getAccountByCustomerId(@PathVariable Long customerId) {
		List<Account> list = new ArrayList<>();
		List<Account> temp = new ArrayList<>();
		temp = accountRepo.findAll();
		for (Account a : temp) {
			if (a.getCustomer().getCustomerId() == customerId) {
				list.add(a);
			}
		}
		return list;
	}

	@GetMapping("/{customerId}")
	public Customer getCustomerByCustomerId(@PathVariable Long customerId) {
		// changes retrieved customer from Optional type to Customer type
		Optional<Customer> temp = customerRepo.findById(customerId);
		Customer customer = temp.get();
		return customer;
	}

	@PutMapping("/{customerId}")
	public Customer updateCustomer(@RequestBody Customer updatedCustomer, @PathVariable Long customerId) {
		Customer currentCustomer = getCustomerByCustomerId(customerId);
		
		// update old values with new updated values
		currentCustomer.setFullName(updatedCustomer.getFullName());
		currentCustomer.setUserName(updatedCustomer.getUserName());
		currentCustomer.setPassword(updatedCustomer.getPassword());
		currentCustomer.setPhone(updatedCustomer.getPhone());
		currentCustomer.setSecretQuestion(updatedCustomer.getSecretQuestion());
		currentCustomer.setSecretAnswer(updatedCustomer.getSecretAnswer());
		currentCustomer.setStatus(updatedCustomer.isStatus());

		return customerRepo.save(currentCustomer);
	}

	@GetMapping("/{customerId}/account/{accountNumber}")
	public Optional<Account> getCustomerWithAccountId(@PathVariable Long accountNumber) {
		return accountRepo.findById(accountNumber);
	}

	@PostMapping("/{customerId}/beneficiary")
	public Beneficiary addBeneficiary(@RequestBody Beneficiary beneficiary, @PathVariable Long customerId) {
		beneficiary.setCustomer(getCustomerByCustomerId(customerId));
		return beneficiaryRepo.save(beneficiary);
	}

	@GetMapping("/{customerId}/getbeneficiary")
	public List<Beneficiary> getBeneficiaryByCustomerId(@RequestBody Beneficiary beneficiary, @PathVariable Long customerId) {
		List<Beneficiary> returnList = new ArrayList<>();
		List<Beneficiary> temp = new ArrayList<>();
		temp = beneficiaryRepo.findAll();
		for(Beneficiary b : temp) {
			if(b.getCustomer().getCustomerId() == customerId) {
				returnList.add(b);
			}
		}
		return returnList;
	}

	@DeleteMapping("/{customerId}/beneficiary/{beneficiaryId}")
	public void deleteBeneficiary(@PathVariable long beneficiaryId) {
		List<Beneficiary> list = new ArrayList<>();
		list = beneficiaryRepo.findAll();
		for(Beneficiary b : list) {
			if(b.getBeneficiaryId() == beneficiaryId) {
				beneficiaryRepo.delete(b);
			}
		}
		
		
		
	}
}