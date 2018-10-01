package com.zycus.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.zycus.entity.accounts.Account;
import com.zycus.entity.cards.Card;
import com.zycus.repository.CardRepository;

@Service
@Transactional
public class CardService implements Services <Card, Long> {

	@Autowired
	CardRepository cardRepository;
	
	@Caching(evict = {
			@CacheEvict(value = "allCards.cache", allEntries = true),
			@CacheEvict(value = "allCardsByFK.cache", allEntries = true)})
	public void addNew(Card card, HttpServletRequest request) {
		card.setExpiryDate(System.currentTimeMillis() + 453216217699l);
		card.setPrimaryKey(System.nanoTime());
		card.setCardNumber(System.currentTimeMillis() % 10000000000000000l);
		
		cardRepository.save(card);
	}

	@Cacheable(value = "allCards.cache")
	public Iterable<Card> fetchAll() {
		return cardRepository.findAll();
	}

	public Card fetchById(Long id) {
		return cardRepository.findById(id).get();
	}

	public boolean validateUser(Card t, HttpServletRequest request) {
		return false;
	}

	public List<Card> fetchAllSorted() {
		return null;
	}

	@Cacheable(value = "allCardsByFK.cache")
	public List <Card> fetchByForeignKey(Account account) {
		return cardRepository.findByForeignKey(account);
	}
}
