package com.servlet.HibernateProj_Product_Query_Interface;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import javax.persistence.Query;




public class ProductService {

	public  EntityManager getEntityManager(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tanisha");
		EntityManager em = emf.createEntityManager();

		return em;

	}
	public void addProduct(Product product){
		String qi ="from Product";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tanisha");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et =em.getTransaction();
		et.begin();
		Query query =  em.createQuery(qi);
		List<Product> products = query.getResultList();
		for(Object obj: products) 
		{
			System.out.println("obj");
		}
		em.persist(products);

	}



	public void findProductById(int idProduct) {
		

	} 

	public void findProductByName(String nameProduct) {
			

	} 
	public void findProductBetweenPrice(int minPrice,int maxPrice) {
		
	} 
	public void findProductByCategory(String categoryProduct) {
		
	} 

	public void findProductByStatus(String statusProduct) {
		
	} 
	

	public void findProductPriceByName(String nameProduct) {
		
	} 

	public void deleteProductByBrand(String brandProduct) {

	} 

	public void deleteProductByCategory() {

	}
	

	/*use-JPA
	 * -QueryInterface
	 * Enable level-2
	 * cache memory
	 * 
	 * */
}
