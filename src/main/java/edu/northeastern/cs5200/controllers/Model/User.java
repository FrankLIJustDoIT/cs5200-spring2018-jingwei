package edu.northeastern.cs5200.controllers.Model;

import java.sql.Date;

public class User extends Person{
	private boolean userAgreement;
	private String userKey;
	
	public User(int id, String firstname, String lastname, String username, String password, 
				String email, Date dob, boolean userAgreement, String userKey) {
		super(id, firstname, lastname, username, password, email, dob);
		this.userAgreement = userAgreement;
		this.userKey = userKey;
	}
	
	public boolean getUserAgreement(){
		return userAgreement;
	} 
	public void setUserAgreement(boolean userAgreement){
		this.userAgreement = userAgreement;
	}
	
	public String getUserKey(){
		return userKey;
	}
	public void setUserKey(String userkey){
		this.userKey = userkey;
	}
}
