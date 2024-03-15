package com.servlet.HibernateProj_OneToMany_Bi_Directional;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		//		Country c1 = new Country();
		//		c1.setCountryId(7);
		//		c1.setCountryName("Malasia");
		//		c1.setContinent("NorthAmerica");
		//		c1.setCountryPopulation("3.82 crores ");
		//		c1.setCountryPresident("kriss");
		//		c1.setCountryPrimeMinister("Justin Trudeau");
		//
		//		State s1 = new State();
		//		s1.setStateId(108);
		//		s1.setStateName("Yukon");
		//		s1.setStatePopulation(45148 );
		//		s1.setStateChiefMinister(" M. Duncan");
		//
		//
		//		Country c2 = new Country();
		//		c2.setCountryId(3);
		//		c2.setCountryName("Argentina");
		//		c2.setContinent("South America");
		//		c2.setCountryPopulation(" 47,225,000 lakhs ");
		//		c2.setCountryPresident("Patricia Bullrich");
		//		c2.setCountryPrimeMinister("Christopher Luxon ");
		//
		//		State s2 = new State();
		//		s2.setStateId(105);
		//		s2.setStateName("Chaco,");
		//		s2.setStatePopulation(1.95);
		//		s2.setStateChiefMinister(" Javier Milei");
		//
		//		c1.setListState(Arrays.asList(s1,s2));
		//		s1.setCountry(c1);
		//		s2.setCountry(c2);
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Country.class).addAnnotatedClass(State.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		//		session.save(c1);
		//		session.save(c2);
		//		session.save(s1);
		//		session.save(s2);


		CountryState cs =new CountryState();
		//		        cs.addCountry(c1);
		//        cs.findCoutryById(1);
		//        cs.findCountryByName("India");
		//        cs.findCountryByContinent("Asia");
		//        cs.findCountryByPresident("Robert");
		//        cs.findAllCountries();
		//        cs.deleteCountryById(3);
		//        cs.deleteCountryByName("New Zealand");
		//        cs.UpdatePresidentByCountryName( "Dropati murmu", "INDIA");

		Country_Service couService =new Country_Service();
		//		couService.addCountry( c2);
		//		couService.findCoutryById(1);
		//		couService.findCountryByName("Canada");
		//      couService.findCountryByContinent(null);
		//		couService.findCountryByPresident(null);
		//		couService.findAllCountries();
		//		couService.deleteCountryById(3);
		//		couService.deleteCountryByName("Canada");
		//		couService.UpdatePresidentByCountryName("president", "gheg");
		//		couService.addState(State, 102);
		
		State_Service ss = new State_Service();
		ss.findStateById(101);
//		ss.findCountryName("");
//		ss.findStateByCM("shivraj singh chohan");
//		ss.findStateByCountryId(1);
		
		transaction.commit();
		session.close();
	}
}
