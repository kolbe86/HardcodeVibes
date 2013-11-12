package de.nak.librarymgmt.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.service.PublicationService;

public class AddAuthorAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Publication publicationBean;
	private Publication publication;
	private PublicationService publicationService;

	@Override
	public String execute() throws Exception {

		Map<String, Object> session = ActionContext.getContext().getSession();
		//
		// if (session.containsKey("publication")) {
		// @SuppressWarnings("unchecked")
		// Publication publication = (Publication) session.get("publication");
		// publication.addAuthors(publicationBean.getAuthors());
		// session.put("publication", publication);
		// } else {
		// session.put("publication", publicationBean);
		//
		// }
		//
		// Publication publication = (Publication) session.get("publication");
		// System.out.println(publication.getAuthors());
		return SUCCESS;

	}

	public Publication getPublicationBean() {
		return publicationBean;
	}

	public void setPublicationBean(Publication publicationBean) {
		this.publicationBean = publicationBean;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public PublicationService getPublicationService() {
		return publicationService;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

}
