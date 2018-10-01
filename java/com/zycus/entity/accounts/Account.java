package com.zycus.entity.accounts;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zycus.entity.cards.Card;

@Entity
@Table(name = "ACCOUNTS")
public class Account implements Comparable <Account> {
	
	@Id
	@Column(name = "ACCOUNT_PK")
	private Long primaryKey;
	
	@Column(name = "ACCOUNT_NUMBER")
	private Long accountNumber;
	
	@Column(name = "ACCOUNT_HOLDER")
	private String holderName;
	
	@Column(name = "ACCOUNT_TYPE")
	private String accountType;
	
	@Column(name = "AMOUNT")
	private Double amount;
	
	@Column(name = "OPENING_DATE")
	private Long openingDate;
	
	@OneToMany(mappedBy = "account")
	@JsonIgnore
	private List <Card> connectedCards;
	
	public Account() {
		super();
	}

	public Account(Long primaryKey, Long accountNumber, String holderName, String accountType, Double amount,
			Long openingDate, List<Card> connectedCards) {
		super();
		this.primaryKey = primaryKey;
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.accountType = accountType;
		this.amount = amount;
		this.openingDate = openingDate;
		this.connectedCards = connectedCards;
	}

	public Long getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(Long primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Long openingDate) {
		this.openingDate = openingDate;
	}

	public List<Card> getConnectedCards() {
		return connectedCards;
	}

	public void setConnectedCards(List<Card> connectedCards) {
		this.connectedCards = connectedCards;
	}

	public int compareTo(Account otherAccount) {
		 return holderName.compareTo(otherAccount.holderName);
	}
}
