package com.jsp.spring.aop.entity;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Tiger {
	@Value("wild Animal")
	private String animalType;

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}


}
