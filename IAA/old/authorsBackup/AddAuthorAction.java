package de.nak.librarymgmt.actions;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Publication;

public class AddAuthorAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Publication publicationBean;
	private String author;

	@Override
	public String execute() throws Exception {

		publicationBean.getAuthors().add(author);

		return SUCCESS;
	}

	public Publication getPublicationBean() {
		return publicationBean;
	}

	public void setPublicationBean(Publication publicationBean) {
		this.publicationBean = publicationBean;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
