package de.nak.librarymgmt.model;

import java.io.Serializable;
import java.util.Set;

public class PublicationType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long publicationTypeID;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPublicationTypeID() {
		return publicationTypeID;
	}

	public void setPublicationTypeID(long publicationTypeID) {
		this.publicationTypeID = publicationTypeID;
	}

}
