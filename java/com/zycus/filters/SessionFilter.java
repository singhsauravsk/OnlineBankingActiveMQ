package com.zycus.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class SessionFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		
		httpResponse.setHeader("Cache-Control", "no-cache, no-store");
        httpResponse.setHeader("Pragma", "no-cache");
        httpResponse.setDateHeader("Expires", 0);
		
        if(isLogout(httpRequest)) {
        	session.invalidate();
			httpResponse.sendRedirect("/login");
			
			return;
        }
        else if(isRestrictedGetUrls(httpRequest)) {
			session.invalidate();
			httpResponse.sendRedirect("/404error");
			
			return;
		}
		else if(isSessionDependentGetUrls(httpRequest) || isSessionDependentPostUrls(httpRequest)) { 
			
			if(isSessionExpired(httpRequest)) {
				httpResponse.sendRedirect("/session-expired");
				
				return;
			}
		}
		else if(isIdentifiedUrl(httpRequest)) {
			httpResponse.sendRedirect("/404error");
			
			return;
		}
		chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public boolean isSessionExpired(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if(session == null) {
			return true;
		}
		else {
			
			if(session.getAttribute("adminName") == null) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public boolean isRestrictedGetUrls(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String method = request.getMethod();
		
		return ((uri.equals("/account/add") || uri.equals("/card/add") || uri.equals("/card/view"))  && method.equals("GET"));
	}
	
	public boolean isSessionDependentPostUrls(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String method = request.getMethod();
		
		return ((uri.equals("/account/add") || uri.equals("/card/add") || uri.equals("/card/view")) && method.equals("POST"));
	}
	
	public boolean isSessionDependentGetUrls(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String method = request.getMethod();
		
		return ((uri.equals("/home") || uri.equals("/listCard")) && method.equals("GET"));
	}
	
	public boolean isIdentifiedUrl(HttpServletRequest request) {
		String uri = request.getRequestURI();
		
		return (!(uri.equals("/login")) && !(uri.equals("/404error")) && !(uri.equals("/session-expired")) && 
				!(uri.contains(".css")) && !(uri.contains(".js")) && !(uri.contains(".jpg")) && 
				!(uri.contains(".png")) && !(uri.contains(".ttf")) && !(uri.contains(".ico")));
	}
	
	public boolean isLogout(HttpServletRequest request) {
		String uri = request.getRequestURI();
		
		return uri.equals("/logout");
	}
}
