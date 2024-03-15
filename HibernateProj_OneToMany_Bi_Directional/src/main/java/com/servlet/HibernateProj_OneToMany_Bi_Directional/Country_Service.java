package com.servlet.HibernateProj_OneToMany_Bi_Directional;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Country_Service {
	public static Session getSession()
	{
		SessionFactory sf= new Configuration().configure().addAnnotatedClass(State.class).addAnnotatedClass(Country.class).buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}
	
	public void addCountry(Country c)
	{
		Session session=getSession();
		Transaction tran = session.beginTransaction();
		session.save(c);
		tran.commit();
		session.close();
	}

	public void findCoutryById(int i) {
		Session session=getSession();
		Transaction tran = session.beginTransaction();
		Country country = session.find(Country.class, i);
		System.out.print(country);
		tran.commit();
		session.close();
	}

	 void findCountryByName(String cName) {
		 String q="from Country where countryName=:cName";
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		Query query = session.createQuery(q);
		query.setParameter("cName", cName);
		System.out.print(query.uniqueResult());
		tran.commit();
		session.close();
	}

	public void findCountryByContinent(String contName) {
		String q="from Country where continent=:contName";
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		Query query = session.createQuery(q);
		query.setParameter("contName", contName);
		List<Country> list = query.list();
		for(Country c:list)
		{
			System.out.println(c);
		}
		tran.commit();
		session.close();
	}

	public void findCountryByPresident(String president) {
		String q="from Country where countryPresident=:president";
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		Query query = session.createQuery(q);
		query.setParameter("president", president);
		System.out.print(query.uniqueResult());
		tran.commit();
		session.close();
	}

	public void findAllCountries() {
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		Query query = session.createQuery("from Country");
		List<Country> list = query.list();
		for(Country c:list)
		{
			System.out.println(c);
		}
		tran.commit();
		session.close();
	}

	public void deleteCountryById(int countryId) {
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		Country country = session.load(Country.class, countryId);
		session.delete(country);
		System.out.println("Deleted Successfully");
		tran.commit();
		session.close();
	}

	public void deleteCountryByName(String cName) {
		String q="from Country where countryName=:cName";
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		Query query = session.createQuery(q);
	    query.setParameter("cName", cName);
	    Country country =(Country) query.uniqueResult();
		session.delete(country);
		tran.commit();
		session.close();
		System.out.println("Deleted Successfully");
	}

	public void UpdatePresidentByCountryName(String president, String cName) {
		String q="from Country where countryName=:cName";
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		Query query = session.createQuery(q);
	    query.setParameter("cName", cName);
	    Country country =(Country) query.uniqueResult();
	    country.setCountryPresident(president);
	    session.update(country);
	    tran.commit();
		session.close();
		System.out.println("Updated Successfully");
	}

	public void addState(State s, int countryCode) {
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		Country country = session.load(Country.class, countryCode);
		if(country != null)
		{
			s.setCountry(country);
			session.save(s);
			tran.commit();
			session.close();
			System.out.println("State addes successfully");
		}
		else {
			System.out.println("coutry not found");
		}
	}

}
