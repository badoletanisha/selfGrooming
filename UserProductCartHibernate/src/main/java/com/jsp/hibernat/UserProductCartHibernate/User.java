package com.jsp.hibernat.UserProductCartHibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
private int userId;
private String userName;
private String userEmail;
private String userAddress;

@OneToOne
private Cart cart;


public Cart getCart() {
	return cart;
}
public void setCart(Cart cart) {
	this.cart = cart;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public String getUserAddress() {
	return userAddress;
}
public void setUserAddress(String userAddress) {
	this.userAddress = userAddress;
}
@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userAddress="
			+ userAddress + "]";
}


}
