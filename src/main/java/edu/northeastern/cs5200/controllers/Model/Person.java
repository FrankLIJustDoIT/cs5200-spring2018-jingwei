package edu.northeastern.cs5200.controllers.Model;

import java.util.*;
import java.sql.Date;

public class Person {
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private Date dob;
	private List<Phone> phones = new ArrayList<>();
	private List<Address> addresses = new ArrayList<>();
	
	public Person(int id, String firstname, String lastname, String username, String password,
					String email, Date dob){
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
	}
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	
	public String getFirstname(){
		return firstname;
	}
	public void setFirstname(String firstname){
		this.firstname = firstname;    
	}
	
	public String getLastname(){
		return lastname;
	}
	public void setLastname(String lastname){
		this.lastname = lastname;
	}
	
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	
	public Date getDob(){
		return dob;
	}
	public void setDob(Date dob){
		this.dob = dob;
	}
	
	public List<Phone> getPhones(){
		return phones;
	}
	public void setPhones(List<Phone> phones){
		this.phones = phones;
	}
	
	public List<Address> getAddress(){
		return addresses;
	}
	public void setAddress(List<Address> addresses){
		this.addresses = addresses;
	}
	
	public void addPhone(Phone phone){
		phones.add(phone);
	}
	public void removePhone(Phone phone){
		phones.remove(phone);
	}
	
	public void addAddress(Address address){
		addresses.add(address);
	}
	public void removeAddress(Address address){
		addresses.remove(address);
	}
}
