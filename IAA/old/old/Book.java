package de.nak.librarymgmt.old;

import java.io.Serializable;

import de.nak.librarymgmt.model.Publication;

public class Book extends Publication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String isbn;
	private String publisher;
	private String edition;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

}