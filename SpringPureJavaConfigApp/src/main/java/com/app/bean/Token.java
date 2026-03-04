package com.app.bean;

public class Token {
	public Integer code;

	public Token() {
		System.out.println("Token class construcor created by spring f/w using @Bean");
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Token [code=" + code + "]";
	}
}
