package com.zycus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zycus.entity.accounts.Account;

public interface AccountRepository extends CrudRepository <Account, Long>{
	
	@Query(value = "select acc from Account acc order by acc.holderName ASC")
	List <Account> findAllSorted();
}
