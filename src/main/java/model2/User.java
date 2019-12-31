package model2;

import java.sql.Date;


public class User {
	
	private int customer_ID;
	private Date dateOfBirth;
	private String email;
	private String firstName;
	private String lastName;

	public User() {
	}
	
	

	public User(int customer_ID, Date dateOfBirth, String email, String firstName, String lastName) {
		super();
		this.customer_ID = customer_ID;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public int getCustomer_ID() {
		return this.customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [customer_ID=" + customer_ID + ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}

	

}