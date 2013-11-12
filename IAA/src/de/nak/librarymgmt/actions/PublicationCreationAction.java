package de.nak.librarymgmt.actions;


import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Publication;

public class PublicationCreationAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Publication publicationBean;

	@Override
	public String execute() throws Exception {
		
		Publication testPublication = publicationBean;

		System.out.println("TEST");

		return "publicationSuccess";

	}

	public Publication getPublicationBean() {
		return publicationBean;
	}

	public void setPublicationBean(Publication publicationBean) {
		this.publicationBean = publicationBean;
	}

}
