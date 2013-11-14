package de.nak.actions;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.service.PublicationService;

public class ShowPublicationDetailAction implements Action {

	private List<Publication> publications;
	private PublicationService publicationService;
	private Long param;
	private Long publicationID;
	private Publication publicationBean;

	@Override
	public String execute() throws Exception {

		setPublications(publicationService.listPublications());

		setParam(publicationID);
		setPublicationBean(publicationService.findPublicationById(param));

		return SUCCESS;
	}

	public Long getPublicationID() {
		return publicationID;
	}

	public void setPublicationID(Long publicationID) {
		this.publicationID = publicationID;
	}

	public PublicationService getPublicationService() {
		return publicationService;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public Long getParam() {
		return param;
	}

	public void setParam(Long param) {
		this.param = param;
	}

	public Publication getPublicationBean() {
		return publicationBean;
	}

	public void setPublicationBean(Publication publicationBean) {
		this.publicationBean = publicationBean;
	}

}
