package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contact_no database table.
 * 
 */
@Entity
@Table(name="contact_no")
@NamedQuery(name="ContactNo.findAll", query="SELECT c FROM ContactNo c")
public class ContactNo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ContactNoPK id;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="customer_ID")
	private User user;

	public ContactNo() {
	}

	public ContactNoPK getId() {
		return this.id;
	}

	public void setId(ContactNoPK id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}