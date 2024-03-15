package com.jsp.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App {
public static void main(String[] args) {
	Company c = new Company();
	c.setCompanyId(1);
	c.setCompanyName("IBM");
	c.setCompanyCeo("Arvind Krishna");
	c.setCategoryType("MNC");
	c.setCompanyBranchName("Bangaluru");
	c.setEmployeeId(101);
	
	CompanyService cs =new CompanyService();
	cs.addCompany(c);
	cs.findCompanyId(0);
	cs.findCompanyByName(null);
	cs.findCompanyByCeo(null);
	cs.deleteCompanyByName(null);
	cs.deleteCompanyByType(null);
	
	cs.deleteCompanyByName(null);
	
	cs.updateNoEmpById(0, 0);
	cs.updateNoOfBranchesByName(0, null);
}
}
