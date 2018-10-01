package com.zycus.entity.cards;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zycus.entity.accounts.Account;

@Entity
@Table(name = "CARDS")
public class Card {
	
	@Id
	@Column(name = "CARD_PK")
	private Long primaryKey;
	
	@Column(name = "CARD_NUMBER")
	private Long cardNumber;
	
	@Column(name = "CARD_Type")
	private String cardType;

	@Column(name = "MAXIMUM_LIMIT")
	private Double maximumLimit;
	
	@Column(name = "EXPIRY_DATE")
	private Long expiryDate;
	
	@ManyToOne
	@JoinColumn(name = "ACCOUNT_FK")
	private Account account;
	
	public Card() {
		super();
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	public Long getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(Long primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Double getMaximumLimit() {
		return maximumLimit;
	}

	public void setMaximumLimit(Double maximumLimit) {
		this.maximumLimit = maximumLimit;
	}

	public Long getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Long expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
