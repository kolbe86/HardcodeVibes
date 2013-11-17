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
	private Set<Author> authors;
	private Set<Keyword> keywords;
	private PublicationType publicationType;
	private Date publicationDate;
	private ConditionE condition;
	private boolean distributed;
	private String isbn;
	private String publisher;
	private String issue;
	private String edition;

	public void initialize() {

		this.setTitle("Initial Title");
		this.setPublicationDate(new Date());
		this.setDistributed(false);
		this.setIsbn("Initial ISBN");
		this.setPublisher("InitialPublisher");
		this.setIssue("Initial Issue");
		this.setEdition("Initial Edition");
	}

	public String toString() {
		String publicationString;
		publicationString = "Titel: " + title + " :: " + "Datum: "
				+ publicationDate.toString() + " :: " + "Verliehen: "
				+ distributed;
		;

		return publicationString;

	}

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

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Set<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<Keyword> keywords) {
		this.keywords = keywords;
	}

	public PublicationType getPublicationType() {
		return publicationType;
	}

	public void setPublicationType(PublicationType publicationType) {
		this.publicationType = publicationType;
	}

	public Date getPublicationDate() {
		return publicationDate;
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

}
