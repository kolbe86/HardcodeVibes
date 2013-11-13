package de.nak.librarymgmt.actions;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Publication;

public class PublicationManagementStartup extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Publication publicationBean;

	// private Map<String, Object> session;

	public String execute() throws Exception {

		return SUCCESS;

	}

	public Publication getPublicationBean() {
		return publicationBean;
	}

	public void setPublicationBean(Publication publicationBean) {
		this.publicationBean = publicationBean;
	}
}
