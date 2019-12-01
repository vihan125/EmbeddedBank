package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int customer_ID;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	//bi-directional many-to-one association to ContactNo
	@OneToMany(mappedBy="user")
	private List<ContactNo> contactNos;

	//bi-directional many-to-one association to MobileBankingAccount
	@OneToMany(mappedBy="user")
	private List<MobileBankingAccount> mobileBankingAccounts;

	//bi-directional many-to-many association to Account
	@ManyToMany
	@JoinTable(
		name="own_by"
		, joinColumns={
			@JoinColumn(name="customer_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="account_ID")
			}
		)
	private List<Account> accounts;

	public User() {
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

	public List<ContactNo> getContactNos() {
		return this.contactNos;
	}

	public void setContactNos(List<ContactNo> contactNos) {
		this.contactNos = contactNos;
	}

	public ContactNo addContactNo(ContactNo contactNo) {
		getContactNos().add(contactNo);
		contactNo.setUser(this);

		return contactNo;
	}

	public ContactNo removeContactNo(ContactNo contactNo) {
		getContactNos().remove(contactNo);
		contactNo.setUser(null);

		return contactNo;
	}

	public List<MobileBankingAccount> getMobileBankingAccounts() {
		return this.mobileBankingAccounts;
	}

	public void setMobileBankingAccounts(List<MobileBankingAccount> mobileBankingAccounts) {
		this.mobileBankingAccounts = mobileBankingAccounts;
	}

	public MobileBankingAccount addMobileBankingAccount(MobileBankingAccount mobileBankingAccount) {
		getMobileBankingAccounts().add(mobileBankingAccount);
		mobileBankingAccount.setUser(this);

		return mobileBankingAccount;
	}

	public MobileBankingAccount removeMobileBankingAccount(MobileBankingAccount mobileBankingAccount) {
		getMobileBankingAccounts().remove(mobileBankingAccount);
		mobileBankingAccount.setUser(null);

		return mobileBankingAccount;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}