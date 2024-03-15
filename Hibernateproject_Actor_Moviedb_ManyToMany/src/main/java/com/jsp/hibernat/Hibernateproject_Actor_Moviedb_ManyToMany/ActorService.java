package com.jsp.hibernat.Hibernateproject_Actor_Moviedb_ManyToMany;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;


public class ActorService {
	public static EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tanisha");
		EntityManager em = emf.createEntityManager();
		return em;

	}
	Scanner sc =new Scanner(System.in);

	public void addActor() {

		System.out.println("Enter ActorId");
		int actorId = sc.nextInt();
		System.out.println("Enter ActorName");
		String actorName = sc.next();
		System.out.println("Enter ActorAge");
		int actorAge = sc.nextInt();
		System.out.println("Enter actorAddrress");
		String actorAddrress = sc.next();
		System.out.println("Enter industry");
		String industry = sc.next();
		System.out.println("Enter natinality");
		String natinality = sc.next();

		EntityManager em= getEntityManager();
		EntityTransaction et = em.getTransaction();

		Actor actor =new Actor();
		actor.setActorId(actorId);
		actor.setActorName(actorName);
		actor.setActorAge(actorAge);
		actor.setActorAddrress(actorAddrress);
		actor.setIndustry(industry);
		actor.setNatinality(natinality);
		et.begin();
		em.persist(actor);

		et.commit();
		em.close();
	}


	public void findActorByName() {
		System.out.println("Enter Actor Name");
		String actorName = sc.next();
		EntityManager em =getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Actor> query = cb.createQuery(Actor.class);
		Root<Actor> root = query.from(Actor.class);
		query.select(root);
		query.where(cb.equal(root.get("actorName"),actorName));
		TypedQuery<Actor> query2 = em.createQuery(query);
		List<Actor> resultList = query2.getResultList();
		for(Actor a :resultList) {
			System.out.println(a);
		}
	}

	public void findActorByIndustry() {
		System.out.println("Enter Actor Industry");
		String industry = sc.next();
		EntityManager em =getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Actor> query = cb.createQuery(Actor.class);
		Root<Actor> root = query.from(Actor.class);
		query.select(root);
		query.where(cb.equal(root.get("industry"),industry));
		TypedQuery<Actor> query2 = em.createQuery(query);
		List<Actor> resultList = query2.getResultList();
		for(Actor a :resultList) {
			System.out.println(a);
		}
	}

	public void findActorByMovieTitle() {

		EntityManager em =getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		CriteriaBuilder cb =em.getCriteriaBuilder();
		CriteriaQuery<Actor> query = cb.createQuery(Actor.class);
		Root<Actor> root = query.from(Actor.class);
		query.select(root);


	}

	public void findAllActorsBetweenAge() {

		EntityManager em =getEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		System.out.println("Enter min Age of Actor");
		int minAge =sc.nextInt();
		System.out.println("Enter max Age of Actor");
		int maxAge =sc.nextInt();
		CriteriaBuilder cb =em.getCriteriaBuilder();
		CriteriaQuery<Actor> query = cb.createQuery(Actor.class);
		Root<Actor> root = query.from(Actor.class);
		query.select(root);

		query.where(cb.between(root.get("actorAge"), minAge, maxAge));
		TypedQuery<Actor> query2 = em.createQuery(query);
		List<Actor> resultList = query2.getResultList();
		for(Actor a :resultList) {
			System.out.println(a);
		}

	}

	public void updateActorAgeById() {
		EntityManager em =getEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		System.out.println("Enter the Actor Id");
		int actorId = sc.nextInt();
		System.out.println("Enter the Actor Age");
		int actorAge = sc.nextInt();
		CriteriaBuilder cb =em.getCriteriaBuilder();
		CriteriaUpdate<Actor> query = cb.createCriteriaUpdate(Actor.class);
		Root<Actor> root = query.from(Actor.class);
		query.set("actorAge", actorAge);
		query.where(cb.equal(root.get("actorId"), actorId));
		System.out.println(em.createQuery( query).executeUpdate()+" Updated");
		et.commit();
		em.close();
	}

	public void updateAllActorIndustryByAddress() {
		EntityManager em =getEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		System.out.println("Enter the Actor Address");
		int actorAddress = sc.nextInt();
		
		CriteriaBuilder cb =em.getCriteriaBuilder();
		CriteriaUpdate<Actor> query = cb.createCriteriaUpdate(Actor.class);
		Root<Actor> root = query.from(Actor.class);
		query.set("actorAddress", actorAddress);
		query.where(cb.equal(root.get("actorAddress"), actorAddress));
		System.out.println(em.createQuery( query).executeUpdate()+" Updated");
		et.commit();
		em.close();

	}

	public void deleteActorByName() {
		EntityManager em =getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		System.out.println("Enter the Actor Name");
		String actorName = sc.next();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaDelete<Actor> cd = cb.createCriteriaDelete(Actor.class);
		Root<Actor> root = cd.from(Actor.class);
		cd.where(cb.equal(root.get("actorName"), actorName));
		System.out.println(em.createQuery(cd).executeUpdate()+"Actor Deleted");
		et.commit();
		em.close();

	}

	public void deleteAllActorByMoviesName() {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.commit();
		System.out.println("Enter Movie Name");
		String movieTitle =sc.next();
		et.begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaDelete<Actor> cd = cb.createCriteriaDelete(Actor.class);
		Root<Actor> root = cd.from(Actor.class);
		Join<Actor, Movie> join = root.join("movieTitle");
		cd.where(cb.equal(root.get("movieTitle"), movieTitle));
		System.out.println(em.createQuery(cd).executeUpdate()+"Actor Deleted");

		et.commit();
		em.close();

	}}

