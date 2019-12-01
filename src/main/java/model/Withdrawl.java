package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the withdrawls database table.
 * 
 */
@Entity
@Table(name="withdrawls")
@NamedQuery(name="Withdrawl.findAll", query="SELECT w FROM Withdrawl w")
public class Withdrawl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int withdrawl_ID;

	private BigDecimal amount;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_withdrawl")
	private Date dateOfWithdrawl;

	//bi-directional many-to-many association to Account
	@ManyToMany
	@JoinTable(
		name="makes_withdrawl"
		, joinColumns={
			@JoinColumn(name="withdrawl_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="account_ID")
			}
		)
	private List<Account> accounts;

	public Withdrawl() {
	}

	public int getWithdrawl_ID() {
		return this.withdrawl_ID;
	}

	public void setWithdrawl_ID(int withdrawl_ID) {
		this.withdrawl_ID = withdrawl_ID;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getDateOfWithdrawl() {
		return this.dateOfWithdrawl;
	}

	public void setDateOfWithdrawl(Date dateOfWithdrawl) {
		this.dateOfWithdrawl = dateOfWithdrawl;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}