/**
 * 
 */
package de.nak.librarymgmt.model;

/**
 * @author chupow
 * 
 */
public class Book extends Publication {
	private String isbn;
	private String publisher;

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
}
