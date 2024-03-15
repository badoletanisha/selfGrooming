package com.servlet.HibernateProj_Product_Query_Interface;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
private int idProduct;
private String nameProduct;
private String brandProduct;
private String categoryProduct;
private int priceProduct;
private String statusProduct;
public int getIdProduct() {
	return idProduct;
}
public void setIdProduct(int idProduct) {
	this.idProduct = idProduct;
}
public String getNameProduct() {
	return nameProduct;
}
public void setNameProduct(String nameProduct) {
	this.nameProduct = nameProduct;
}
public String getBrandProduct() {
	return brandProduct;
}
public void setBrandProduct(String brandProduct) {
	this.brandProduct = brandProduct;
}
public String getCategoryProduct() {
	return categoryProduct;
}
public void setCategoryProduct(String categoryProduct) {
	this.categoryProduct = categoryProduct;
}
public int getPriceProduct() {
	return priceProduct;
}
public void setPriceProduct(int priceProduct) {
	this.priceProduct = priceProduct;
}
public String getStatusProduct() {
	return statusProduct;
}
public void setStatusProduct(String statusProduct) {
	this.statusProduct = statusProduct;
}

}
