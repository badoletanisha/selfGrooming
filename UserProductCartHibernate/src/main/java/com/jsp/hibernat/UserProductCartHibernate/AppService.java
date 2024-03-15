package com.jsp.hibernat.UserProductCartHibernate;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class AppService {
	Product product=new Product();
	User user=new User();
	Cart cart=new Cart();
	Scanner sc=new Scanner(System.in);
	public Session getSession()
	{
		SessionFactory sf=new Configuration().configure().addAnnotatedClass(Product.class).addAnnotatedClass(User.class).addAnnotatedClass(Cart.class).buildSessionFactory();
		Session session=sf.openSession();
		return session;
	}

	public void addProduct() {
		System.out.println("Enter Product Id");
		product.setProductId(sc.nextInt());
		System.out.println("Enter the Product Name");
		product.setProductName(sc.next());
		System.out.println("Enter the Product Brand");
		product.setProductBrand(sc.next());
		System.out.println("Enter the Product price");
		product.setProductPrice(sc.nextInt());
		Session session=getSession();
		Transaction tran = session.beginTransaction();
		session.save(product);
		tran.commit();
		session.close();
		System.out.println("Produt Added Succesfully");
	}

	public void addUser() {
		System.out.println("Enter the User ID");
		user.setUserId(sc.nextInt());
		System.out.println("Enter the User Name");
		user.setUserName(sc.next());
		System.out.println("Enter the User Email");
		user.setUserEmail(sc.next());
		System.out.println("Enter the User Adress");
		user.setUserAddress(sc.next());
		user.setCart(cart);
		Session session = getSession();
		Transaction tran = session.beginTransaction();
		session.save(cart);
		session.save(user);
		tran.commit();
		session.close();
		System.out.println("User Added Successfully");
	}

	public void addProductToCart() {
		Session session = getSession();
		Transaction tran = session.beginTransaction();
		System.out.println("Enter the User Id");
		int userId=sc.nextInt();
		User user2 = session.find(User.class, userId);
		if(user2!=null)
		{
			cart = user2.getCart();
			System.out.println("Select the Product to be Added to the cart");
			Query query = session.createQuery("from Product");
			List<Product> list = query.list();
			for(Product p:list)
			{
				System.out.println(p);
			}
			System.out.println("Enter the product Id");
			String prdcts = sc.next();
			String[] prodct = prdcts.split(",");
			for(String p:prodct)
			{
				int i=Integer.parseInt(p);
				cart.getProducts().add(session.find(Product.class,i));
			}
			System.out.println("Product Added to Cart Successfully");
		}
		session.saveOrUpdate(user2);
		System.out.println("Product Added to Cart Successfully");

		tran.commit();	
	}

	public void removeProductFromCart() {

		Session session=getSession();
		Transaction tran = session.beginTransaction();
		System.out.println("Enter the user Id");
		int userId=sc.nextInt();
		user = session.find(User.class, userId);
		if(user!=null)
		{
			cart = user.getCart();
			System.out.println(cart);
			System.out.println("Enter product id You want delete");
			int productId=sc.nextInt();
			cart.getProducts().remove(session.find(Product.class, productId));
			System.out.println(" Product Removed from the cart");
		}
		tran.commit();
		session.close();
	}

	public void viewCart() {
		Session session=getSession();
		Transaction tran = session.beginTransaction();
		System.out.println("Enter the user Id");
		int userId=sc.nextInt();
		user = session.find(User.class, userId);
		if(user!=null)
		{
			cart = user.getCart();
			System.out.println(cart);
		}
		tran.commit();
		session.close();
	}
}


