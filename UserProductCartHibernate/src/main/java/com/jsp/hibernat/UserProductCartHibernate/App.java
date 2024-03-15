package com.jsp.hibernat.UserProductCartHibernate;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AppService ps=new AppService();
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("1.Add Product\n2.Add User\n3.Add Product To The Cart\n4.Remove Product From The Cart\n5.View Cart\n6.Exit");
    	System.out.println("Enter your choice");
    	int ch=scanner.nextInt();
    	switch(ch)
    	{
    		case 1:ps.addProduct();
    			break;
    		case 2:ps.addUser();
    			break;
    		case 3:ps.addProductToCart();
    			break;
    		case 4:ps.removeProductFromCart();
    			break;
    		case 5:ps.viewCart();
    			break;
    		case 6:System.exit(0);
    			break;
    		default:System.out.println("Invalid choice");
    			break;
    	}
    }
    }

