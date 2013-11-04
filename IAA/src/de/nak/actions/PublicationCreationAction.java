package de.nak.actions;

import de.nak.librarymgmt.model.Publication;

import com.opensymphony.xwork2.ActionSupport;

public class PublicationCreationAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private Publication publicationBean;
	

	@Override
	public String execute() throws Exception {
		
		//call Service class to store personBean's state in database
		
		return SUCCESS;
		
	}
	
	public Publication getPublicationBean() {
		
		return publicationBean;
		
	}
	
	public void setPublicationBean(Publication publication) {
		
		publicationBean = publication;
		
	}

}
