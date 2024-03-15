package com.jsp.hibernat.Hibernateproject_Actor_Moviedb_ManyToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

public class MovieService {
	public static EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tanisha");
		EntityManager em = emf.createEntityManager();
		return em;

	}
	Scanner sc =new Scanner(System.in);
	public void addMovie() {
		Scanner sc = new Scanner(System.in);
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
    
		et.begin();

		Movie m = new Movie();

		System.out.println("Enter MovieId:");
		m.setMovieId(sc.nextInt());

		System.out.println("Enter MovieTitle:");
		m.setMovieTitle(sc.next());

		System.out.println("Enter MovieGenre:");
		m.setMovieGenre(sc.next());

		System.out.println("Enter MovieDirector:");
		m.setMovieDirector(sc.next());

		System.out.println("Enter BoxOfficeCollection:");
		m.setBoxOfficeCollection(sc.next());

		System.out.println("Enter BoxOfficeVerdict:");
		m.setBoxOfficeVerdict(sc.next());

		System.out.println("Enter MovieLanguage:");
		m.setMovieLanguage(sc.next());

		Query query = em.createQuery("FROM Actor");
		List<Actor> actors = query.getResultList();

		System.out.println("Available Actors:");
		for (Actor a : actors) {
			System.out.println(a);
		}

		System.out.println("Enter Actor IDs separated by commas:");
		String str = sc.next();

		String[] ids = str.split(",");
		List<Actor> selectedActors = new ArrayList<>();
		for (String id : ids) {
			int actorId = Integer.parseInt(id);
			Actor actor = em.find(Actor.class, actorId);
			if(actor != null) {
				selectedActors.add(actor);
				actor.getMovies().add(actor);

			}
			else {
				System.out.println("Actor with ID \" + actorId + \" not found.");
			}

			m.seActors(selectedActors);
			em.persist(m);
			et.commit();
		}
	}

	public void findMoviesById() {
		System.out.println("Enter MovieID");
		String movieId = sc.next();

		EntityManager em =getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
		Root<Movie> root = cq.from(Movie.class);
		cq.select(root);
		cq.where(cb.equal(root.get("movieId"),movieId));
		Query query =em.createQuery(cq);
		Movie movie=(Movie)query.getSingleResult();
		System.out.println(movie);
		et.commit();
		em.close();

	}

	public void findMoviesByName() {
		System.out.println("Enter Movie Title");
		String movietitle = sc.next();
		EntityManager em =getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Movie> query = cb.createQuery(Movie.class);
		Root<Movie> root = query.from(Movie.class);
		query.select(root);
		query.where(cb.equal(root.get("movieTitle"),movietitle));
		TypedQuery<Movie> query2 = em.createQuery(query);
		List<Movie> resultList = query2.getResultList();
		for(Movie a :resultList) {
			System.out.println(a);
		}
	}

	public void findAllMoviesByDirector() {
		EntityManager em =getEntityManager();
		EntityTransaction et =em.getTransaction();
		et.begin();
		System.out.println(" Enter the Director Name");
		String director =sc.next();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
		Root<Movie> root = cq.from(Movie.class);
		cq.select(root);
		cq.where(cb.equal(root.get("movieDirector"),director));
		Query query =em.createQuery(cq);
		List<Movie> list =query.getResultList();
		for(Movie movie : list) {
			System.out.println(movie);
		}
		et.commit();
		em.close();
	}

	public void findAllMoviesByGenre() {
		EntityManager em =getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		System.out.println("Enter the Genre");
		String movieGenre=sc.next();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
		Root<Movie> root = cq.from(Movie.class);
		cq.select(root);
		cq.where(cb.equal( root.get("movieGenre"), movieGenre));
		Query query =em.createQuery(cq);
		List<Movie> list =query.getResultList();
		for(Movie movie : list) {
			System.out.println(movie);
		}
		et.commit();
		em.close();
	}

	public void findAllMoviesByActorName() {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		System.out.println("Enter the Movie Title");
		String movieTitle = sc.next();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
		Root<Movie> root = cq.from(Movie.class);
		cq.select(root);
		cq.where(cb.equal(root.get("movieTitle"), movieTitle));
		Query query = em.createQuery(cq);
		List<Movie> list = query.getResultList();

		for(Movie movie : list) {
			System.out.println(movie);
		}
		et.commit();
		em.close();
	}

	public void updateAllMoviesByBoxofficeCollection() {

		EntityManager em =getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaUpdate<Movie> cu = cb.createCriteriaUpdate(Movie.class);
		Root<Movie> root = cu.from(Movie.class);
		cu.set("boxOfficeVerdict","Super-Hit");
		cu.where(cb.between(root.get("boxOfficeCollection"), 200, 500));
		System.out.println(em.createQuery(cu).executeUpdate()+"Movie Updated");
		et.commit();
		em.close();
	}

	public void deleteMovieByName() {

		EntityManager em =getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		System.out.println("Enter the Movie Name");
		String movieTitle =sc.next();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaDelete<Movie> cd = cb.createCriteriaDelete(Movie.class);
		Root<Movie> root = cd.from(Movie.class);
		cd.where(cb.equal(root.get("movieTitle"), movieTitle));
		System.out.println(em.createQuery(cd).executeUpdate()+ "Movie Delete");
		et.commit();
		em.close();
	}

	public void deleteAllMovieByDirector() {
		EntityManager em =getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		System.out.print("Enter the Director Name");
		String movieDirector = sc.next();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaDelete<Movie> cd = cb.createCriteriaDelete(Movie.class);
		Root<Movie> root = cd.from(Movie.class);
		cd.where(cb.equal(root.get("movieDirector"), movieDirector));
		System.out.println(em.createQuery(cd).executeUpdate()+"Movie Delete");
		et.commit();
		em.close();

	}

	public void deleteAllMovieByActorName() {
		EntityManager em =getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		System.out.println("enter the Actor Name");
		String actorName = sc.next();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaDelete<Movie> cd = cb.createCriteriaDelete(Movie.class);
		Root<Movie> root = cd.from(Movie.class);
		Join<Movie, Actor> join = root.join("actors");
		cd.where(cb.equal(root.get("actorName"), actorName));
		System.out.println(em.createQuery(cd).executeUpdate()+"Movie Deleted");


	}
}

