package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the contact_no database table.
 * 
 */
@Embeddable
public class ContactNoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int customer_ID;

	@Column(name="mobile_no")
	private int mobileNo;

	public ContactNoPK() {
	}
	public int getCustomer_ID() {
		return this.customer_ID;
	}
	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}
	public int getMobileNo() {
		return this.mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ContactNoPK)) {
			return false;
		}
		ContactNoPK castOther = (ContactNoPK)other;
		return 
			(this.customer_ID == castOther.customer_ID)
			&& (this.mobileNo == castOther.mobileNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.customer_ID;
		hash = hash * prime + this.mobileNo;
		
		return hash;
	}
}