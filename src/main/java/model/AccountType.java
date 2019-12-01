package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the account_type database table.
 * 
 */
@Entity
@Table(name="account_type")
@NamedQuery(name="AccountType.findAll", query="SELECT a FROM AccountType a")
public class AccountType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int acc_type_ID;

	@Column(name="interest_rate")
	private BigDecimal interestRate;

	@Column(name="minimum_balance")
	private BigDecimal minimumBalance;

	private String name;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="accountType")
	private List<Account> accounts;

	public AccountType() {
	}

	public int getAcc_type_ID() {
		return this.acc_type_ID;
	}

	public void setAcc_type_ID(int acc_type_ID) {
		this.acc_type_ID = acc_type_ID;
	}

	public BigDecimal getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public BigDecimal getMinimumBalance() {
		return this.minimumBalance;
	}

	public void setMinimumBalance(BigDecimal minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setAccountType(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setAccountType(null);

		return account;
	}

}