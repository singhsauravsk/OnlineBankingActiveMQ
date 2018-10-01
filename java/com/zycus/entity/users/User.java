package com.zycus.entity.users;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
	
	@Id
	private String username;
	private String password;
	private String name;
	
	public User() {
		super();
	}

	public User(String username, String password, String name) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		
		if (password == null) {
			
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		
		if (username == null) {
			
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		
		return true;
	}
}
