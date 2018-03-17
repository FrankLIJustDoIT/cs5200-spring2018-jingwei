package edu.northeastern.cs5200.controllers.Model;

import java.util.*;
import java.sql.Date;

public class Developer extends Person{
	private String developerKey;
	private List<Website> websites = new ArrayList<>(); 

	public Developer(int id, String firstname, String lastname, String username, String password,
					String email, Date dob, String developerKey){
		super(id, firstname, lastname, username, password, email, dob);
		this.developerKey = developerKey;
	}
	
	public String getDeveloperKey(){
		return developerKey;
	}
	public void setDeveloperKey(String developerKey){
		this.developerKey = developerKey;
	}
	
	public List<Website> getWebsites(){
		return websites;
	}
	public void setWebsites(List<Website> websites){
		this.websites = websites;
	}
	
	public void addWebsite(Website website){
		websites.add(website);
	}
	public void removeWebsite(Website website){
		websites.remove(website);
	}
}
