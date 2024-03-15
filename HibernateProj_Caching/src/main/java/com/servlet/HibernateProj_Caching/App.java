package com.servlet.HibernateProj_Caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static void main( String[] args )
	{
		//       Product p = new Product();
		//       p.setProductId(1);
		//       p.setProductName("mobile");
		//       p.setProductPrice(1000);
		//     
		//       
		//       Product p1 = new Product();
		//       p1.setProductId(2);
		//       p1.setProductName("laptop");
		//       p1.setProductPrice(2000);


		Configuration cfg =new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory factory = cfg.buildSessionFactory();


		//       session 1
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		//    session.save(p);
		//    session.save(p1);

		Product p =session.get(Product.class, 1);
		System.out.println(p);

		Product p1 =session.get(Product.class, 1);
		System.out.println(p1);
		t.commit();
		session.close();
		System.out.println();

		//    session 1
		Session session2 = factory.openSession();
		Transaction t2 = session2.beginTransaction();
		

		Product p2 =session2.get(Product.class, 1);
		System.out.println(p2);

		Product p3 =session2.get(Product.class, 1);
		System.out.println(p3);
		t2.commit();
		session2.close();
	}
}
