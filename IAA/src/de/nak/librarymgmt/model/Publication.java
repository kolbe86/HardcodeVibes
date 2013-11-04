/**
 * 
 */
package de.nak.librarymgmt.model;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author Kowk Bond Chu
 */
public abstract class Publication {

	/** The identifier. */
	private Long id;
	/** The titel of the publication. */
	private String titel;
	/** The author of the publication. */
	private String author;
	/** The date of publication. */
	private Date dateOfPublication;
	/** The list of keywords for the publication. */
	private List<String> keywords;
	/**
	 * private enum condition;
	 * 
	 */
	/** The associated lending process. */
	private LendingProcess lendingProcess;

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(Date dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	public LendingProcess getLendingProcess() {
		return lendingProcess;
	}

	public void setLendingProcess(LendingProcess lendingProcess) {
		this.lendingProcess = lendingProcess;
	}
}
