package com.jsp.spring.aop.aspect.copy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AanimalAspects {


	//@Before("execution(public String getAnimalType())")	
	//@Before("execution(public * get*())")
	@Before("allGetters()")
	public void firstAdvice() {
		System.out.println("1st advice");
	}

	@Before("allGetters() ")
	public void secondAdvice() {
		System.out.println("2nd advice");
	}
	//@Pointcut("exicution(public String com.jsp.spring.aop.entity.Tiger.getAnimalType())")
	//	public void tigerGetAnimalTypeMethod() {
	//		
	//	}

	@Pointcut("execution( * get*(..))")
	public void allGetters() {

	}
	//@Pointcut("within(com.jsp.spring.aop.entity.Tiger)")
	//public void allMethodsOFCow() {
	//	
//}
}
