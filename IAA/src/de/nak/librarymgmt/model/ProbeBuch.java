package de.nak.librarymgmt.model;

import java.util.Date;
import java.util.List;

public class ProbeBuch {
	
	private String titel;
	private String author;
	private Date datum;
	private List<String> schlagwort;
	private String art;
	private String isbn;
	private String verlag;
	private Integer anzahl;
	
	public String getTitel() {
		return titel;
	}
	public String getArt() {
		return art;
	}
	public void setArt(String art) {
		this.art = art;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getVerlag() {
		return verlag;
	}
	public void setVerlag(String verlag) {
		this.verlag = verlag;
	}
	public Integer getAnzahl() {
		return anzahl;
	}
	public void setAnzahl(Integer anzahl) {
		this.anzahl = anzahl;
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
	public List<String> getSchlagwort() {
		return schlagwort;
	}
	public void setSchlagwort(List<String> schlagwort) {
		this.schlagwort = schlagwort;
	}


}
