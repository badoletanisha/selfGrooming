package com.jsp.spring.aop.entity;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Animal {
	@Autowired
	private Cow cow;
	@Autowired
	private Tiger tiger;
	public Cow getCow() {
		return cow;
	}
	public void setCow(Cow cow) {
		this.cow = cow;
	}
	public Tiger getTiger() {
		return tiger;
	}
	public void setTiger(Tiger tiger) {
		this.tiger = tiger;
	}

}
