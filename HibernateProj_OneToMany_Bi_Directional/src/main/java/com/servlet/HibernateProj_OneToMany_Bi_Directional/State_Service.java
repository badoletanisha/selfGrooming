package com.servlet.HibernateProj_OneToMany_Bi_Directional;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class State_Service {
	public static Session getSession()
	{
		SessionFactory sf= new Configuration().configure().addAnnotatedClass(State.class).addAnnotatedClass(Country.class).buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}

	public void findStateById(int i) {
		Session session=getSession();
		Transaction tran = session.beginTransaction();
		State s = session.find(State.class, i);
		System.out.print(s);
		tran.commit();
		session.close();

	}

	public void findStateByName(String sName) {
		String q="from State where stateName=:sName";
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		Query query = session.createQuery(q);
		query.setParameter("sName", sName);
		System.out.print(query.uniqueResult());
		tran.commit();
		session.close();

	}

	public void findStateByCM(String cm) {
		String q="from State where stateCM=:cm";
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		Query query = session.createQuery(q);
		query.setParameter("cm", cm);
		System.out.print(query.uniqueResult());
		tran.commit();
		session.close();

	}

	public void findStateByCountryId(int countryId) {
		String q="from State s where s.country.countryId=:countryId";
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		Country country = session.find(Country.class, countryId);
		if(country!=null)
		{
			Query query = session.createQuery(q);
			query.setParameter("countryId", countryId);
			List<State> list = query.list();
			for(State s:list)
			{
				System.out.println(s);
			}
			tran.commit();
			session.close();
		}
		else
		{
			System.out.println("Country not found");
		}
	}

	public void findCountryName(String cName) {
		String q="from State s where s.country.countryName=:cName";
		Session session=getSession();
		Transaction tran=session.beginTransaction();
			Query query = session.createQuery(q);
			query.setParameter("cName", cName);
			List<State> list = query.list();
			for(State s:list)
			{
				System.out.println(s);
			}
			tran.commit();
			session.close();
	}

	public void updatePopulationByName(String sName,int population) {
		String q="from State where stateName=:sName";
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		Query query = session.createQuery(q);
	    query.setParameter("sName", sName);
	    State state =(State) query.uniqueResult();
	    state.setStatePopulation(population);
	    session.update(state);
	    tran.commit();
		session.close();
		System.out.println("Updated Successfully");
	}

	public void deleteStateByName(String sName) {
		String q="from State where stateName=:sName";
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		Query query = session.createQuery(q);
	    query.setParameter("sName", sName);
	    State state =(State) query.uniqueResult();
		session.delete(state);
		tran.commit();
		session.close();
		System.out.println("Deleted Successfully");
		
	}

}
