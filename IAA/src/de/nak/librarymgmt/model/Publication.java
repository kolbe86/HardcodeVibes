package de.nak.librarymgmt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public abstract class Publication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long publicationID;
	private String title;
	private Set<String> authors;
	private Date publicationDate;
	private Set<String> keywords;
	private String condition;
	private boolean distributed;
	private boolean reserved;
	private LendingProcess lendingProcess;

	public long getPublicationID() {
		return publicationID;
	}

	public void setPublicationID(long publicationID) {
		this.publicationID = publicationID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<String> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<String> authors) {
		this.authors = authors;
	}

	public Set<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<String> keywords) {
		this.keywords = keywords;
	}

	public boolean isDistributed() {
		return distributed;
	}

	public void setDistributed(boolean distributed) {
		this.distributed = distributed;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public LendingProcess getLendingProcess() {
		return lendingProcess;
	}

	public void setLendingProcess(LendingProcess lendingProcess) {
		this.lendingProcess = lendingProcess;
	}

}
