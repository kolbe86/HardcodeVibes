package de.nak.librarymgmt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The room entity.
 * 
 * @author Kowk Bond Chu
 */
/**
 * @author mariokolbe
 * 
 */
@Entity
@Table(name = "Publication")
public abstract class Publication implements Serializable {

	/** Serial version uid. */
	private static final long serialVersionUID = 1L;
	/** The identifier. */
	private Long id;
	/** The title of the publication. */
	private String title;
	/** The author of the publication. */
	private String author;
	/** The date of publication. */
	private Date dateOfPublication;

	/** The list of keywords for the publication. */
	// private List<String> keywords;

	/**
	 * private enum condition;
	 * 
	 */
	/** The associated lending process. */
	// private LendingProcess lendingProcess;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	// public List<String> getKeywords() {
	// return keywords;
	// }
	//
	// public void setKeywords(List<String> keywords) {
	// this.keywords = keywords;
	// }

	// public LendingProcess getLendingProcess() {
	// return lendingProcess;
	// }
	//
	// public void setLendingProcess(LendingProcess lendingProcess) {
	// this.lendingProcess = lendingProcess;
	// }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
