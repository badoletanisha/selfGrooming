package com.jsp.hibernat.Hibernateproject_Actor_Moviedb_ManyToMany;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Actor {

	@Id
	private int actorId;
	private String actorName;
	private int actorAge;
	private String actorAddrress;
	private String industry;
	private String natinality;
	@ManyToMany(mappedBy = "selectedActors")
	private List<Movie> selectedActors;
	
	
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public int getActorAge() {
		return actorAge;
	}
	public void setActorAge(int actorAge) {
		this.actorAge = actorAge;
	}
	public String getActorAddrress() {
		return actorAddrress;
	}
	public void setActorAddrress(String actorAddrress) {
		this.actorAddrress = actorAddrress;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getNatinality() {
		return natinality;
	}
	public void setNatinality(String natinality) {
		this.natinality = natinality;
	}
	@Override
	public String toString() {
		return "Movie [actorId=" + actorId + ", actorName=" + actorName + ", actorAge=" + actorAge + ", actorAddrress="
				+ actorAddrress + ", industry=" + industry + ", natinality=" + natinality + "]";
	}
	public List<Actor> getMovies() {
		// TODO Auto-generated method stub
		return null;
	}
	public void seActors(List<Movie> selectedActors) {
		// TODO Auto-generated method stub
		this.selectedActors=selectedActors;
		
	}
	

}
