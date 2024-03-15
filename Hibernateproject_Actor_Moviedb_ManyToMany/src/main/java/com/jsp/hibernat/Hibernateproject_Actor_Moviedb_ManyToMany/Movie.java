package com.jsp.hibernat.Hibernateproject_Actor_Moviedb_ManyToMany;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Movie {
	@Id
	private int movieId;
	private String movieTitle;
	private String movieGenre;
	private String movieDirector;
	private String boxOfficeCollection;
	private String boxOfficeVerdict;
	private String movieLanguage;
	@ManyToMany
	private List<Actor> selectedActors = new ArrayList<Actor>();
	
	public List<Actor> getSelectedActors() {
		return selectedActors;
	}
	public void setSelectedActors(List<Actor> selectedActors) {
		this.selectedActors = selectedActors;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	public String getBoxOfficeCollection() {
		return boxOfficeCollection;
	}
	public void setBoxOfficeCollection(String boxOfficeCollection) {
		this.boxOfficeCollection = boxOfficeCollection;
	}
	public String getBoxOfficeVerdict() {
		return boxOfficeVerdict;
	}
	public void setBoxOfficeVerdict(String boxOfficeVerdict) {
		this.boxOfficeVerdict = boxOfficeVerdict;
	}
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	public void setMovieDirector(int nextInt) {
		// TODO Auto-generated method stub
		
	}
	public void seActors(List<Actor> selectedActors) {
		// TODO Auto-generated method stub
		this.seActors(selectedActors);
	}
	

	
	
	
}
