package de.nak.actions;

import de.nak.librarymgmt.model.ProbeBuch;
import de.nak.librarymgmt.model.Publication;

import com.opensymphony.xwork2.ActionSupport;

public class PublicationCreationAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private ProbeBuch probeBuchBean;
	private Publication publicationBean;
	private String titel;
	

	@Override
	public String execute() throws Exception {
		
		//call Service class to store personBean's state in database
		
		return SUCCESS;
		
	}
	
	public ProbeBuch getProbeBuchBean() {
		
		return probeBuchBean;
		
	}
	
	public void setProbeBuchBean(ProbeBuch probeBuch) {
		
		probeBuchBean = probeBuch;
		
	}
	
	public String getTitel() {
		
		return titel;
		
	}
	
	public void setTitel(String titel) {
		
		this.titel = titel;
		
	}
	
	public Publication getPublicationBean() {
		
		return publicationBean;
		
	}
	
	public void setPublicationBean(Publication publication) {
		
		publicationBean = publication;
		
	}

}
