
package com.learning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learning.entity.Account;
import com.learning.entity.Beneficiary;
@Transactional
@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
	@Query(value="Select * from account where account.accountStatus=0",nativeQuery=true)
	public List<Account> FindAccountForApproval();
	
	@Query(value="Select * from account where account.accountStatus=0 and account.customer_id=:customerid",nativeQuery=true)
	public List<Account> FindAccountForCustomer(@Param("customerid")long customerid );

}
