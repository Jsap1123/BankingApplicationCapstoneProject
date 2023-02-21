package com.learning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.learning.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
	
	

}
