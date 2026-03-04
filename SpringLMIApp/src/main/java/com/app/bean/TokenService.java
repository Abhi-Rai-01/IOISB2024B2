package com.app.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class TokenService {
	
	@Autowired
	private Token token;
	
	public Token getToken() {
		token = getMyToken();
		return token;
	}
	
	@Lookup
	public Token getMyToken() {
		//..........  (CGILIB because of @Lookup)  ..........//
		return token;
	}
	
	@Override
	public String toString() {
		return "TokenService [token=" + token + "]";
	}
}
