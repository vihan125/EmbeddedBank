package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the fd_type database table.
 * 
 */
@Entity
@Table(name="fd_type")
@NamedQuery(name="FdType.findAll", query="SELECT f FROM FdType f")
public class FdType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int FD_type_ID;

	@Column(name="interest_rate")
	private BigDecimal interestRate;

	private String name;

	//bi-directional many-to-one association to FixedDeposit
	@OneToMany(mappedBy="fdType")
	private List<FixedDeposit> fixedDeposits;

	public FdType() {
	}

	public int getFD_type_ID() {
		return this.FD_type_ID;
	}

	public void setFD_type_ID(int FD_type_ID) {
		this.FD_type_ID = FD_type_ID;
	}

	public BigDecimal getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FixedDeposit> getFixedDeposits() {
		return this.fixedDeposits;
	}

	public void setFixedDeposits(List<FixedDeposit> fixedDeposits) {
		this.fixedDeposits = fixedDeposits;
	}

	public FixedDeposit addFixedDeposit(FixedDeposit fixedDeposit) {
		getFixedDeposits().add(fixedDeposit);
		fixedDeposit.setFdType(this);

		return fixedDeposit;
	}

	public FixedDeposit removeFixedDeposit(FixedDeposit fixedDeposit) {
		getFixedDeposits().remove(fixedDeposit);
		fixedDeposit.setFdType(null);

		return fixedDeposit;
	}

}