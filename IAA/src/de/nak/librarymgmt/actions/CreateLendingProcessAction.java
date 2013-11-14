package de.nak.librarymgmt.actions;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Publication;

public class CreateLendingProcessAction extends ActionSupport {

	private Publication publicationBean;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() {

		return SUCCESS;
	}

	public Publication getPublicationBean() {
		return publicationBean;
	}

	public void setPublicationBean(Publication publicationBean) {
		this.publicationBean = publicationBean;
	}
}
