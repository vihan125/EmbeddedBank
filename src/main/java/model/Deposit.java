package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the deposits database table.
 * 
 */
@Entity
@Table(name="deposits")
@NamedQuery(name="Deposit.findAll", query="SELECT d FROM Deposit d")
public class Deposit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int deposit_ID;

	private BigDecimal amount;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_deposit")
	private Date dateOfDeposit;

	//bi-directional many-to-many association to Account
	@ManyToMany
	@JoinTable(
		name="makes_deposit"
		, joinColumns={
			@JoinColumn(name="deposit_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="account_ID")
			}
		)
	private List<Account> accounts;

	public Deposit() {
	}

	public int getDeposit_ID() {
		return this.deposit_ID;
	}

	public void setDeposit_ID(int deposit_ID) {
		this.deposit_ID = deposit_ID;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getDateOfDeposit() {
		return this.dateOfDeposit;
	}

	public void setDateOfDeposit(Date dateOfDeposit) {
		this.dateOfDeposit = dateOfDeposit;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}