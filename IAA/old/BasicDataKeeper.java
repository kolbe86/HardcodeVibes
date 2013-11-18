package de.nak.librarymgmt.model;

import java.util.List;

public class BasicDataKeeper {
	
	private List<String> buzzword;
	private List<String> publicationType;
	private List<String> lender;
	
	public List<String> getBuzzword() {
		return buzzword;
	}
	public void setBuzzword(List<String> buzzword) {
		this.buzzword = buzzword;
	}
	public List<String> getPublicationType() {
		return publicationType;
	}
	public void setPublicationType(List<String> publicationType) {
		this.publicationType = publicationType;
	}
	public List<String> getLender() {
		return lender;
	}
	public void setLender(List<String> lender) {
		this.lender = lender;
	}

}
