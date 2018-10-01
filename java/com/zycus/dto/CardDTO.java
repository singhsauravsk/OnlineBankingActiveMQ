package com.zycus.dto;

public class CardDTO {
	private Long foreignKey;
	private String cardType;
	private Double maximumLimit;
	
	public CardDTO() {
		super();
	}

	public CardDTO(Long foreignKey, String cardType, Double maximumLimit) {
		super();
		this.foreignKey = foreignKey;
		this.cardType = cardType;
		this.maximumLimit = maximumLimit;
	}

	public Long getForeignKey() {
		return foreignKey;
	}

	public void setForeignKey(Long foreignKey) {
		this.foreignKey = foreignKey;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Double getMaximumLimit() {
		return maximumLimit;
	}

	public void setMaximumLimit(Double maximumLimit) {
		this.maximumLimit = maximumLimit;
	}
}
