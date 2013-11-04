/**
 * 
 */
package de.nak.librarymgmt.model;

import java.util.Date;

/**
 * The lending process POJO.
 * 
 * @author Kowk Bond Chu
 */

public class LendingProcess {
	// ------------------------------ FIELDS ------------------------------

	/** The identifier. */
	private Long id;
	/** The outgoing date of the lending process. */
	private Date outgoingDate;
	/** The return date of the lending process. */
	private Date returnDate;
	/**
	 * private dunningLevel; private status;
	 */
	/** The extension Level of the lending process. */
	private int extensionLevel;
	/** The associated lender. */
	private Lender lender;
	/** The associated publication. */
	private Publication publication;

	// --------------------- GETTER / SETTER METHODS ---------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOutgoingDate() {
		return outgoingDate;
	}

	public void setOutgoingDate(Date outgoingDate) {
		this.outgoingDate = outgoingDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getExtensionLevel() {
		return extensionLevel;
	}

	public void setExtensionLevel(int extensionLevel) {
		this.extensionLevel = extensionLevel;
	}

	public Lender getLender() {
		return lender;
	}

	public void setLender(Lender lender) {
		this.lender = lender;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

}
