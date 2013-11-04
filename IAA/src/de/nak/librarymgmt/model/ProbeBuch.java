package de.nak.librarymgmt.model;

import java.util.Date;

public class ProbeBuch {
	
	private String titel;
	private String author;
	private Date datum;
	
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
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	public String toString()
    {
        return "Titel: " + getTitel() + " Author:  " + getAuthor() + 
        " Datum:      " + getDatum() ;
    }

}
