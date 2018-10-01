package com.zycus.dto;

public class AccountDTO {

	private String holderName;
	private String accountType;
	
	public AccountDTO() {
		super();
	}

	public AccountDTO(String holderName, String accountType) {
		super();
		this.holderName = holderName;
		this.accountType = accountType;
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
}
