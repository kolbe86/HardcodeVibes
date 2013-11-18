package de.nak.librarymgmt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import de.nak.librarymgmt.util.ConditionE;

/**
 * 
 * the publication POJO
 */
public class Publication implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * the id of the publication
	 */
	private long publicationID;
	/**
	 * the title of the publication
	 */
	private String title;
	/**
	 * the authors of the publication
	 */
	private Set<Author> authors;
	/**
	 * the keywords for the publication
	 */
	private Set<Keyword> keywords;
	/**
	 * the type of the publication
	 */
	private PublicationType publicationType;
	/**
	 * the publication date
	 */
	private Date publicationDate;
	/**
	 * the condition of the publication
	 */
	private ConditionE condition;
	/**
	 * the status about the distribution
	 */
	private boolean distributed;
	/**
	 * the isbn of the publication
	 */
	private String isbn;
	/**
	 * the publisher of the publication
	 */
	private String publisher;
	/**
	 * the issue of the publication
	 */
	private String issue;
	/**
	 * the edition of the publication
	 */
	private String edition;

	/**
	 * the initialize method
	 */
	public void initialize() {

		this.setTitle("Initial Title");
		this.setPublicationDate(new Date());
		this.setDistributed(false);
		this.setIsbn("Initial ISBN");
		this.setPublisher("InitialPublisher");
		this.setIssue("Initial Issue");
		this.setEdition("Initial Edition");
	}

	/**
	 * the to string method
	 */
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
