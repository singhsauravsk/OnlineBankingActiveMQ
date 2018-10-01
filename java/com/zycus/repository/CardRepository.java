package com.zycus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zycus.entity.accounts.Account;
import com.zycus.entity.cards.Card;

public interface CardRepository extends CrudRepository <Card, Long>{

	@Query(value = "select c from Card c where c.account = :account")
	List <Card> findByForeignKey(@Param("account") Account account);
}
