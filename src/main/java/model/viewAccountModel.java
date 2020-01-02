package model;

import java.sql.Date;

public class viewAccountModel {
	private int customer_ID;
	private String email;
	private Date date_of_birth;
	private String first_name;
	private String last_name;
	private int balance;
	private String name;
	
	
	
	public int getCustomer_ID() {
		return customer_ID;
	}
	public String getEmail() {
		return email;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public int getBalance() {
		return balance;
	}
	public String getName() {
		return name;
	}
	
	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
