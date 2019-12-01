package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int account_ID;

	private BigDecimal balance;

	//bi-directional many-to-one association to AccountType
	@ManyToOne
	@JoinColumn(name="acc_type_ID")
	private AccountType accountType;

	//bi-directional many-to-one association to FixedDeposit
	@OneToMany(mappedBy="account")
	private List<FixedDeposit> fixedDeposits;

	//bi-directional many-to-many association to Deposit
	@ManyToMany(mappedBy="accounts")
	private List<Deposit> deposits;

	//bi-directional many-to-many association to Mobilet
	@ManyToMany(mappedBy="accounts")
	private List<Mobilet> mobilets;

	//bi-directional many-to-many association to Withdrawl
	@ManyToMany(mappedBy="accounts")
	private List<Withdrawl> withdrawls;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="accounts")
	private List<User> users;

	public Account() {
	}

	public int getAccount_ID() {
		return this.account_ID;
	}

	public void setAccount_ID(int account_ID) {
		this.account_ID = account_ID;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public AccountType getAccountType() {
		return this.accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public List<FixedDeposit> getFixedDeposits() {
		return this.fixedDeposits;
	}

	public void setFixedDeposits(List<FixedDeposit> fixedDeposits) {
		this.fixedDeposits = fixedDeposits;
	}

	public FixedDeposit addFixedDeposit(FixedDeposit fixedDeposit) {
		getFixedDeposits().add(fixedDeposit);
		fixedDeposit.setAccount(this);

		return fixedDeposit;
	}

	public FixedDeposit removeFixedDeposit(FixedDeposit fixedDeposit) {
		getFixedDeposits().remove(fixedDeposit);
		fixedDeposit.setAccount(null);

		return fixedDeposit;
	}

	public List<Deposit> getDeposits() {
		return this.deposits;
	}

	public void setDeposits(List<Deposit> deposits) {
		this.deposits = deposits;
	}

	public List<Mobilet> getMobilets() {
		return this.mobilets;
	}

	public void setMobilets(List<Mobilet> mobilets) {
		this.mobilets = mobilets;
	}

	public List<Withdrawl> getWithdrawls() {
		return this.withdrawls;
	}

	public void setWithdrawls(List<Withdrawl> withdrawls) {
		this.withdrawls = withdrawls;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}