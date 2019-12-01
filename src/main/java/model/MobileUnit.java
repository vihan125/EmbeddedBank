package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the mobile_unit database table.
 * 
 */
@Entity
@Table(name="mobile_unit")
@NamedQuery(name="MobileUnit.findAll", query="SELECT m FROM MobileUnit m")
public class MobileUnit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MU_ID")
	private int muId;

	private int agent_ID;

	private BigDecimal balance;

	//bi-directional many-to-one association to MobileBankingAccount
	@OneToMany(mappedBy="mobileUnit")
	private List<MobileBankingAccount> mobileBankingAccounts;

	public MobileUnit() {
	}

	public int getMuId() {
		return this.muId;
	}

	public void setMuId(int muId) {
		this.muId = muId;
	}

	public int getAgent_ID() {
		return this.agent_ID;
	}

	public void setAgent_ID(int agent_ID) {
		this.agent_ID = agent_ID;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public List<MobileBankingAccount> getMobileBankingAccounts() {
		return this.mobileBankingAccounts;
	}

	public void setMobileBankingAccounts(List<MobileBankingAccount> mobileBankingAccounts) {
		this.mobileBankingAccounts = mobileBankingAccounts;
	}

	public MobileBankingAccount addMobileBankingAccount(MobileBankingAccount mobileBankingAccount) {
		getMobileBankingAccounts().add(mobileBankingAccount);
		mobileBankingAccount.setMobileUnit(this);

		return mobileBankingAccount;
	}

	public MobileBankingAccount removeMobileBankingAccount(MobileBankingAccount mobileBankingAccount) {
		getMobileBankingAccounts().remove(mobileBankingAccount);
		mobileBankingAccount.setMobileUnit(null);

		return mobileBankingAccount;
	}

}