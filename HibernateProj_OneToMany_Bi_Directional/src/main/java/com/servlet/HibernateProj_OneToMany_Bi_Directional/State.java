package com.servlet.HibernateProj_OneToMany_Bi_Directional;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class State {
	@Id
	int stateId;
	String stateName;
	double statePopulation;
	String stateChiefMinister;
	@ManyToOne
	private Country country;
	

	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public double getStatePopulation() {
		return statePopulation;
	}
	public void setStatePopulation(double statePopulation) {
		this.statePopulation = statePopulation;
	}
	public String getStateChiefMinister() {
		return stateChiefMinister;
	}
	public void setStateChiefMinister(String stateChiefMinister) {
		this.stateChiefMinister = stateChiefMinister;
	}
	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", stateName=" + stateName + ", statePopulation=" + statePopulation
				+ ", stateChiefMinister=" + stateChiefMinister + "]";
	}

}
