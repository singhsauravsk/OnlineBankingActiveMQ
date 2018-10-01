package com.zycus.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zycus.entity.accounts.Account;
import com.zycus.entity.users.User;
import com.zycus.repository.UserRepository;

@Service
@Transactional
public class UserService implements Services<User, String> {

	@Autowired
	UserRepository userRepository;
	
	@CacheEvict(value = "allUsers.cache", allEntries = true)
	public void addNew(User t, HttpServletRequest request) {
		userRepository.save(t);
	}

	@Cacheable(value = "allUsers.cache")
	public Iterable<User> fetchAll() {
		return userRepository.findAll();
	}

	public User fetchById(String id) {
		return userRepository.findById(id).get();
	}
	
	public boolean validateUser(User user, HttpServletRequest request) {
		
		try {
			User fetchedUser = userRepository.findById(user.getUsername()).get();
				
			if(fetchedUser == null) {
				return false;
			}
			else if(fetchedUser.equals(user)) {
				request.getSession().setAttribute("adminName", fetchedUser.getName());
				
				return true;
			}
			else {
				return false;
			}
		} catch(NoSuchElementException e) {
			System.out.println(e.getMessage());
			
			return false;
		}
	}

	public List <User> fetchAllSorted() {
		return null;
	}

	public List <User> fetchByForeignKey(Account account) {
		return null;
	}
}
