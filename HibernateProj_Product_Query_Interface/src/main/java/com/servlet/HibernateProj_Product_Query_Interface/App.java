package com.servlet.HibernateProj_Product_Query_Interface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
						Product product =new Product();
						product.setIdProduct(7);
						product.setNameProduct("audi X3");
						product.setBrandProduct("audi");
						product.setPriceProduct(1700);
						product.setCategoryProduct("TOY");
						product.setStatusProduct("In Stock");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tanisha");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		ProductService ps= new ProductService();
			ps.addProduct(product);
		//		ps.findProductById(1);
		//      ps.findProductByName("Watch");
		//      ps.findProductBetweenPrice(1500,11000);
		//		ps.findProductByCategory("Analog");
		//		ps.findProductByStatus("pending order");
//		ps.findProductPriceByName("Watch");
//				ps.deleteProductByBrand("Titan");
		//		em.persist(product);
		em.close();

	}
}
