package de.nak.librarymgmt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import de.nak.librarymgmt.util.ConditionE;

public class Publication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long publicationID;
	private String title;
	private Set<String> authors;
	private Date publicationDate;
	private ConditionE condition;
	private boolean distributed;
	private boolean reserved;
	private PublicationType publicationType;
	private Set<Keyword> keywords;
	private LendingProcess lendingProcess;
	
//	nullable..
	private String isbn;
	private String publisher;
	private String issue;
	private String edition;
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
	public Set<String> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<String> authors) {
		this.authors = authors;
	}
<<<<<<< HEAD
	public Date getPublicationDate() {
		return publicationDate;
=======
	
	public void addAuthors(Set<String> authors) {
		this.authors.addAll(authors);
	}

	public Set<String> getKeywords() {
		return keywords;
>>>>>>> branch 'master' of ssh://git@github.com/kolbe86/HardcodeVibes.git
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public ConditionE getCondition() {
		return condition;
	}
	public void setCondition(ConditionE condition) {
		this.condition = condition;
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
	public Set<Keyword> getKeywords() {
		return keywords;
	}
	public void setKeywords(Set<Keyword> keywords) {
		this.keywords = keywords;
	}
	public LendingProcess getLendingProcess() {
		return lendingProcess;
	}
	public void setLendingProcess(LendingProcess lendingProcess) {
		this.lendingProcess = lendingProcess;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public PublicationType getPublicationType() {
		return publicationType;
	}
	public void setPublicationType(PublicationType publicationType) {
		this.publicationType = publicationType;
	}

}
