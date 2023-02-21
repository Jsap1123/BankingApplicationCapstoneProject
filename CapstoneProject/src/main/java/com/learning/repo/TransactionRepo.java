package com.learning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.entity.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
	@Query(value="select distinct * from Transaction where :account.customer_id=transaction.fromAccountNo or :account.customer_id=transaction.toAccountNo order by date desc;",nativeQuery=true)
	public List<Transaction> AccountStatement(@Param("account.customer_id")int customerid );
	

}
