package com.zycus.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zycus.entity.accounts.Account;

public interface Services <T, ID> {
	
	void addNew(T t, HttpServletRequest request);
	Iterable <T> fetchAll();
	T fetchById(ID id);
	boolean validateUser(T t, HttpServletRequest request);
	List <T> fetchAllSorted();
	List <T> fetchByForeignKey(Account account);
}
