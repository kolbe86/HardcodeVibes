package de.nak.librarymgmt.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.service.PublicationService;

public class PublicationManagementDetailAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Publication> publications;
	private PublicationService publicationService;
	private Long param;
	private Long publicationID;
	private Publication publicationBean;


	@Override
	public String execute() throws Exception {

		// call Service class to store personBean's state in database

		setPublications(publicationService.listPublications());
		
		setParam(publicationID);
		setPublicationBean(publicationService.findPublicationById(param));

		// publications.add(new ProbeBuch("Harry Potter", "JK Rowling",
		// "123-456-789", "Super Verlag"));
		// publications.add(new ProbeBuch("Die Bibel", "Jesus", "000-000-000",
		// "Heiliger Verlag"));
		// publications.add(new ProbeBuch("Investitionsfinanzierung",
		// "Ralf Kesten", "111-111-111", "NAK Verlag"));
		// publications.add(new ProbeBuch("How to Be Awesome", "Jonas Maeckel",
		// "567-567-567", "Mein verlag"));

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
