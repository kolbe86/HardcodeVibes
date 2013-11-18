package de.nak.librarymgmt.model;

import java.io.Serializable;
import java.util.Date;

import de.nak.librarymgmt.util.DunningLevelE;
import de.nak.librarymgmt.util.StatusE;

/**
 * The Lending Process POJO
 * 
 */

public class LendingProcess implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * the id of the lending process
	 */
	private long lendingProcessID;
	/**
	 * the borrower of the lending process
	 */
	private Borrower borrower;
	/**
	 * the publication lended
	 */
	private Publication publication;
	/**
	 * the issue date of the lending
	 */
	private Date issueDate;
	/**
	 * the return date of the lending
	 */
	private Date returnDate;
	/**
	 * the level of the extension
	 */
	private int extensionOfTimeLevel;
	/**
	 * the status of the lending process
	 */
	private StatusE status;
	/**
	 * the dunning level of the lending process
	 */
	private DunningLevelE dunningLevel;

	public long getLendingProcessID() {
		return lendingProcessID;
	}

	public void setLendingProcessID(long lendingProcessID) {
		this.lendingProcessID = lendingProcessID;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getExtensionOfTimeLevel() {
		return extensionOfTimeLevel;
	}

	public void setExtensionOfTimeLevel(int extensionOfTimeLevel) {
		this.extensionOfTimeLevel = extensionOfTimeLevel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public DunningLevelE getDunningLevel() {
		return dunningLevel;
	}

	public void setDunningLevel(DunningLevelE dunningLevel) {
		this.dunningLevel = dunningLevel;
	}

	public StatusE getStatus() {
		return status;
	}

	public void setStatus(StatusE status) {
		this.status = status;
	}

}
