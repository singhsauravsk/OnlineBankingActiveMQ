package com.zycus.dto;

public class CardViewDTO {
	private long foreignKey;

	public CardViewDTO() {
		super();
	}

	public CardViewDTO(long foreignKey) {
		super();
		this.foreignKey = foreignKey;
	}

	public long getForeignKey() {
		return foreignKey;
	}

	public void setForeignKey(long foreignKey) {
		this.foreignKey = foreignKey;
	}
}
