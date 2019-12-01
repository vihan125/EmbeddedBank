package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mobile_banking_account database table.
 * 
 */
@Entity
@Table(name="mobile_banking_account")
@NamedQuery(name="MobileBankingAccount.findAll", query="SELECT m FROM MobileBankingAccount m")
public class MobileBankingAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MBA_ID")
	private int mbaId;

	private String password;

	//bi-directional many-to-one association to MobileUnit
	@ManyToOne
	@JoinColumn(name="MU_ID")
	private MobileUnit mobileUnit;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="customer_ID")
	private User user;

	public MobileBankingAccount() {
	}

	public int getMbaId() {
		return this.mbaId;
	}

	public void setMbaId(int mbaId) {
		this.mbaId = mbaId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MobileUnit getMobileUnit() {
		return this.mobileUnit;
	}

	public void setMobileUnit(MobileUnit mobileUnit) {
		this.mobileUnit = mobileUnit;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}