package com.jsp.hibernate;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;



public class CompanyService {
	
	
public Session  getSession() {
	SessionFactory sf=new Configuration().configure().addAnnotatedClass(Company.class).buildSessionFactory();
    Session session = sf.openSession();
    return session;
}
	
	
public void	addCompany(Company company){
	Session session =getSession();
	Transaction t =session.beginTransaction();
	session.save(company);
	t.commit();
	
}	public void findCompanyId(int compId) {
	String q="select * from Company where compId="+compId;
	Session session=getSession();
	Transaction tran = session.beginTransaction();
	NativeQuery query = session.createNativeQuery(q,Company.class);
	List<Company> list = query.list();
	for(Company comp:list)
	{
		System.out.println(comp);
	}
	tran.commit();
	session.close();
	
}
public void findCompanyByName(String compName) {
	String q="select * from Company where compName=?";
	Session session=getSession();
	Transaction tran = session.beginTransaction();
	NativeQuery query = session.createNativeQuery(q,Company.class);
	query.setParameter(1, compName);
	List<Company> list = query.list();
	for(Company comp:list)
	{
		System.out.println(comp);
	}
	tran.commit();
	session.close();
}
public void findCompanyByCeo(String compCeo) {
	String q="select * from Company where compCeo=?";
	Session session=getSession();
	Transaction tran = session.beginTransaction();
	NativeQuery query = session.createNativeQuery(q,Company.class);
	query.setParameter(1, compCeo);
	List<Company> list = query.list();
	for(Company comp:list)
	{
		System.out.println(comp);
	}
	tran.commit();
	session.close();
}
public void findCompanyByType(String compType) {

	String q="select * from Company where compType=?";
	Session session=getSession();
	Transaction tran = session.beginTransaction();
	NativeQuery query = session.createNativeQuery(q,Company.class);
	query.setParameter(1, compType);
	List<Company> list = query.list();
	for(Company comp:list)
	{
		System.out.println(comp);
	}
	tran.commit();
	session.close();
}
public void updateNoEmpById(int compId,int noOfEmp) {
	String q="update Company set totNoOfEmployees=? where compId=?";
	Session session=getSession();
	Transaction tran = session.beginTransaction();
	NativeQuery query = session.createNativeQuery(q,Company.class);
	query.setParameter(1,noOfEmp);
	query.setParameter(2, compId);
	System.out.println(query.executeUpdate()+" Data Updated");
	tran.commit();
	session.close();
	
}
public void updateNoOfBranchesByName(int noOfBranches, String compName) {
	String q="update Company set noOfBranches=? where compName=?";
	Session session=getSession();
	Transaction tran = session.beginTransaction();
	NativeQuery query = session.createNativeQuery(q,Company.class);
	query.setParameter(1,noOfBranches);
	query.setParameter(2, compName);
	System.out.println(query.executeUpdate()+" Data Updated");
	tran.commit();
	session.close();
	
}
public void deleteCompanyByName(String compName) {

	String q="delete from Company where compName=?";
	Session session=getSession();
	Transaction tran = session.beginTransaction();
	NativeQuery query = session.createNativeQuery(q,Company.class);
	query.setParameter(1,compName);
	System.out.println(query.executeUpdate()+" Data Deleted");
	tran.commit();
	session.close();
}
public void deleteCompanyByType(String compType) {
	String q="delete from Company where compType=?";
	Session session=getSession();
	Transaction tran = session.beginTransaction();
	NativeQuery query = session.createNativeQuery(q,Company.class);
	query.setParameter(1,compType);
	System.out.println(query.executeUpdate()+" Data Deleted");
	tran.commit();
	session.close();		
}
}