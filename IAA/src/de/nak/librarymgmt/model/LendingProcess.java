package de.nak.librarymgmt.model;

import java.io.Serializable;
import java.util.Date;

/**
 * The Lending Process POJO
 * 
 * @author Kowk Bond Chu
 */

public class LendingProcess implements Serializable {

	private static final long serialVersionUID = 1L;
	private long lendingProcessID;
	/*
	 * private Borrower borrower;
	 * private long publicationID;
	 */
	private Date issueDate;
	private Date returnDate;
	private int extensionOfTimeLevel;

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

/*	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
*/
	/**
	 * private Enum<DunningLevel> dunningLevel; private Enum<Status> status;
	 */

}
