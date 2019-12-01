package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fixed_deposit database table.
 * 
 */
@Entity
@Table(name="fixed_deposit")
@NamedQuery(name="FixedDeposit.findAll", query="SELECT f FROM FixedDeposit f")
public class FixedDeposit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FD_ID")
	private int fdId;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="account_ID")
	private Account account;

	//bi-directional many-to-one association to FdType
	@ManyToOne
	@JoinColumn(name="FD_type_ID")
	private FdType fdType;

	public FixedDeposit() {
	}

	public int getFdId() {
		return this.fdId;
	}

	public void setFdId(int fdId) {
		this.fdId = fdId;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public FdType getFdType() {
		return this.fdType;
	}

	public void setFdType(FdType fdType) {
		this.fdType = fdType;
	}

}