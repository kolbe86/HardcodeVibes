package de.nak.librarymgmt.model;

import java.io.Serializable;

public class Keyword implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long keywordID;
	private String name;



	public long getKeywordID() {
		return keywordID;
	}

	public void setKeywordID(long keywordID) {
		this.keywordID = keywordID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
