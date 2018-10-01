package com.zycus.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class AuditLog implements Serializable {
	private static final long serialVersionUID = 1L;
	private String user;
	private Date date;
	private Long account;
	private String message;
	
	public AuditLog(Long id, String user, Date date, Long account, String message) {
		super();
		this.user = user;
		this.date = date;
		this.account = account;
		this.message = message;
	}

	public AuditLog() {
		super();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getAccount() {
		return account;
	}

	public void setAccount(Long account) {
		this.account = account;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
