package entity;

import java.util.Date;

public class userEntity {
	private String Customer_ID;
	private Date Date_of_Birth;
	private String Mobile;
	private String First_Name;
	private String Last_Name;
	private String Account_ID;
	private String Email;
	
	
	public userEntity(String customer_ID, Date date_of_Birth, String mobile, String first_Name, String last_Name,
			String account_ID, String email) {
		Customer_ID = customer_ID;
		Date_of_Birth = date_of_Birth;
		Mobile = mobile;
		First_Name = first_Name;
		Last_Name = last_Name;
		Account_ID = account_ID;
		Email = email;
	}
	public String getCustomer_ID() {
		return Customer_ID;
	}
	public void setCustomer_ID(String customer_ID) {
		Customer_ID = customer_ID;
	}
	public Date getDate_of_Birth() {
		return Date_of_Birth;
	}
	public void setDate_of_Birth(Date date_of_Birth) {
		Date_of_Birth = date_of_Birth;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getAccount_ID() {
		return Account_ID;
	}
	public void setAccount_ID(String account_ID) {
		Account_ID = account_ID;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
	@Override
	public String toString() {
		return "userEntity [Customer_ID=" + Customer_ID + ", Date_of_Birth=" + Date_of_Birth + ", Mobile=" + Mobile
				+ ", First_Name=" + First_Name + ", Last_Name=" + Last_Name + ", Account_ID=" + Account_ID + ", Email="
				+ Email + "]";
	}
	
	

}
