package com.zycus.aspects;

import java.util.Date;

import javax.jms.Queue;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.zycus.dto.AuditLog;
import com.zycus.entity.accounts.Account;
import com.zycus.entity.cards.Card;

@Aspect
@Component
public class AuditLogAspect {

	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	Queue queue;
	
	@Autowired
	AuditLog log;
	
	@After(value = "execution(* com.zycus.services.*.*(..)) and args(account, request)")
	public void updateLogAccount(JoinPoint joinPoint, Account account, HttpServletRequest request) {
		String message = "Account is created with account number " + account.getAccountNumber() + " and with amount Rs." + account.getAmount();
		
		log.setAccount(account.getAccountNumber());
		log.setMessage(message);
		log.setUser((String)request.getSession().getAttribute("adminName"));
		log.setDate(new Date());
		
		jmsTemplate.convertAndSend(queue, log);
	}
	
	@After(value = "execution(* com.zycus.services.*.*(..)) and args(card, request)")
	public void updateLogCard(JoinPoint joinPoint, Card card, HttpServletRequest request) {
		String message = "Card is created with card number " + card.getCardNumber() + " and with maximum limit of Rs." + card.getMaximumLimit();
		
		log.setAccount(card.getAccount().getAccountNumber());
		log.setMessage(message);
		log.setUser((String)request.getSession().getAttribute("adminName"));
		log.setDate(new Date());
		
		jmsTemplate.convertAndSend(queue, log);
	}
}
