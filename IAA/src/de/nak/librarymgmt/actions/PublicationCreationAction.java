package de.nak.librarymgmt.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.service.PublicationService;

public class PublicationCreationAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private PublicationService publicationService;
	private Publication publicationBean;

	@Override
	public String execute() throws Exception {

		publicationService.createPublication(publicationBean.getTitle(),
				publicationBean.getAuthors(),
				publicationBean.getPublicationDate(),
				publicationBean.getCondition(),
				publicationBean.getPublicationType(),
				publicationBean.getKeywords(), publicationBean.getIsbn(),
				publicationBean.getPublisher(), publicationBean.getIssue(),
				publicationBean.getEdition());

		System.out.println("Publikation gespeichert");

		ActionContext.getContext().getSession().remove("publication");
		System.out.println("Session cleared");

		return "publicationSuccess";

	}

	public PublicationService getPublicationService() {
		return publicationService;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

	public Publication getPublicationBean() {
		return publicationBean;
	}

	public void setPublicationBean(Publication publicationBean) {
		this.publicationBean = publicationBean;
	}
}
