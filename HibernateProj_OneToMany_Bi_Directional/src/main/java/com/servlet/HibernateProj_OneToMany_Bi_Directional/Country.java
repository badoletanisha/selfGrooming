package com.servlet.HibernateProj_OneToMany_Bi_Directional;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Country {
	@Id
	int countryId;
	String countryName;
	String continent;
	String countryPopulation;
	String countryPresident;
	String countryPrimeMinister;
	@OneToMany(mappedBy = "country")
	List<State> listState ;
	
	public List<State> getListState() {
		return listState;
	}
	public void setListState(List<State> listState) {
		this.listState = listState;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getCountryPopulation() {
		return countryPopulation;
	}
	public void setCountryPopulation(String countryPopulation) {
		this.countryPopulation = countryPopulation;
	}
	public String getCountryPresident() {
		return countryPresident;
	}
	public void setCountryPresident(String countryPresident) {
		this.countryPresident = countryPresident;
	}
	public String getCountryPrimeMinister() {
		return countryPrimeMinister;
	}
	public void setCountryPrimeMinister(String countryPrimeMinister) {
		this.countryPrimeMinister = countryPrimeMinister;
	}
	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + ", continent=" + continent
				+ ", countryPopulation=" + countryPopulation + ", countryPresident=" + countryPresident
				+ ", countryPrimeMinister=" + countryPrimeMinister + "]";
	}

}
