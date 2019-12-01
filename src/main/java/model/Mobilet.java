package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mobilet database table.
 * 
 */
@Entity
@NamedQuery(name="Mobilet.findAll", query="SELECT m FROM Mobilet m")
public class Mobilet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int mobileT_ID;

	private int agent_ID;

	private BigDecimal amount;

	@Temporal(TemporalType.DATE)
	private Date date_of_mobileT;

	//bi-directional many-to-many association to Account
	@ManyToMany
	@JoinTable(
		name="makes_mobilet"
		, joinColumns={
			@JoinColumn(name="mobileT_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="account_ID")
			}
		)
	private List<Account> accounts;

	public Mobilet() {
	}

	public int getMobileT_ID() {
		return this.mobileT_ID;
	}

	public void setMobileT_ID(int mobileT_ID) {
		this.mobileT_ID = mobileT_ID;
	}

	public int getAgent_ID() {
		return this.agent_ID;
	}

	public void setAgent_ID(int agent_ID) {
		this.agent_ID = agent_ID;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getDate_of_mobileT() {
		return this.date_of_mobileT;
	}

	public void setDate_of_mobileT(Date date_of_mobileT) {
		this.date_of_mobileT = date_of_mobileT;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}