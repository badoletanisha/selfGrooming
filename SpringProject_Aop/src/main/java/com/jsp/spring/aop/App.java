package com.jsp.spring.aop;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.jsp.spring.aop.entity.Animal;



@Configurable
@ComponentScan("com.jsp.spring.aop")
@EnableAspectJAutoProxy
public class App 
{
    public static void main( String[] args )
    {
     ApplicationContext ac=new AnnotationConfigApplicationContext(App.class);
     Animal animal = ac.getBean(Animal.class);
     System.out.println(animal.getTiger().getAnimalType());
    }
}
