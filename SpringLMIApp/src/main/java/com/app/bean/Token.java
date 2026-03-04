package com.app.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Token {
	
	@Value("#{new java.util.Random().nextInt(1000)}")
	public Integer code;

	@Override
	public String toString() {
		return "Token [code=" + code + "]";
	}
}
