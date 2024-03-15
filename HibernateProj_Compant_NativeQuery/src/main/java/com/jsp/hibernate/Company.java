package com.jsp.hibernate;

public class Company {
	private int companyId;
	private String companyName;
	private String companyCeo;
	private String categoryType;
	private int employeeId;
	private String companyBranchName ;
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyCeo() {
		return companyCeo;
	}
	public void setCompanyCeo(String companyCeo) {
		this.companyCeo = companyCeo;
	}
	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getCompanyBranchName() {
		return companyBranchName;
	}
	public void setCompanyBranchName(String companyBranchName) {
		this.companyBranchName = companyBranchName;
	}

}
