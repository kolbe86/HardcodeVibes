package de.nak.librarymgmt.model;

import java.util.Date;

/**
 * The Lending Process POJO
 * 
 * @author Kowk Bond Chu
 */

public class LendingProcess {

	private long lendingProcessID;
	private long borrowerID;
	private long publicationID;
	private Date issueDate;
	private Date returnDate;
	private int ExtensionOfTimeLevel;

	/**
	 * private Enum<DunningLevel> dunningLevel; private Enum<Status> status;
	 */
	
	
	public long getLendingProcessID() {
		return lendingProcessID;
	}

	public void setLendingProcessID(long lendingProcessID) {
		this.lendingProcessID = lendingProcessID;
	}

	public long getBorrowerID() {
		return borrowerID;
	}

	public void setBorrowerID(long borrowerID) {
		this.borrowerID = borrowerID;
	}

	public long getPublicationID() {
		return publicationID;
	}

	public void setPublicationID(long publicationID) {
		this.publicationID = publicationID;
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
		return ExtensionOfTimeLevel;
	}

	public void setExtensionOfTimeLevel(int extensionOfTimeLevel) {
		ExtensionOfTimeLevel = extensionOfTimeLevel;
	}

}
