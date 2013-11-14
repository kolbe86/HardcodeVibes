package de.nak.librarymgmt.actions.basicDataActions;

import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.model.PublicationType;
import de.nak.librarymgmt.service.PublicationService;
import de.nak.librarymgmt.service.PublicationTypeService;

public class DeletePublicationTypeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Publication publicationBean;
	private Set<PublicationType> publicationTypes;
	List<String> publicationTypeSelection;
	private PublicationService publicationService;
	private PublicationTypeService publicationTypeService;
	// private String tempFieldPublicationType;
	private String paramPublicationType;
	private PublicationType publicationTypeBean;

	public String execute() throws Exception {

		// publicationTypeBean = new PublicationType();
		publicationTypeService.deletePublicationType(publicationTypeBean
				.getName());
		// Get Publication-Types
		publicationTypes = publicationTypeService.listAllPublicationTypes();
		// publicationTypeSelection = new LinkedList<String>();
		// for (PublicationType publicationType : publicationTypes) {
		// publicationTypeSelection.add(publicationType.getName());
		// }

		// Erstmal raus, dann wahrscheinlich Feld leer
		// if (!(paramPublicationType == null)) {
		//
		// publicationTypeBean.setName(paramPublicationType);
		//
		// }
		// Publication Bean
		// if (publicationBean == null) {
		// // initialize
		// publicationBean = new Publication();
		// publicationBean.setTitle("Initial Title");
		// publicationBean.setPublicationDate(new Date());
		// publicationBean.setDistributed(false);
		// publicationBean.setReserved(false);
		// publicationBean.setIsbn("Initial ISBN");
		// publicationBean.setPublisher("InitialPublisher");
		// publicationBean.setIssue("Initial Issue");
		// publicationBean.setEdition("Initial Edition");
		//
		// }

		System.out.println("Delete BasicDataType Ende");
		return "basicDataSuccess";

	}

	public Publication getPublicationBean() {
		return publicationBean;
	}

	public void setPublicationBean(Publication publicationBean) {
		this.publicationBean = publicationBean;
	}

	public PublicationService getPublicationService() {
		return publicationService;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

	public PublicationTypeService getPublicationTypeService() {
		return publicationTypeService;
	}

	public void setPublicationTypeService(
			PublicationTypeService publicationTypeService) {
		this.publicationTypeService = publicationTypeService;
	}

	public Set<PublicationType> getPublicationTypes() {
		return publicationTypes;
	}

	public void setPublicationTypes(Set<PublicationType> publicationTypes) {
		this.publicationTypes = publicationTypes;
	}

	public List<String> getPublicationTypeSelection() {
		return publicationTypeSelection;
	}

	public void setPublicationTypeSelection(
			List<String> publicationTypeSelection) {
		this.publicationTypeSelection = publicationTypeSelection;
	}

	public String getParamPublicationType() {
		return paramPublicationType;
	}

	public void setParamPublicationType(String paramPublicationType) {
		this.paramPublicationType = paramPublicationType;
	}

	public PublicationType getPublicationTypeBean() {
		return publicationTypeBean;
	}

	public void setPublicationTypeBean(PublicationType publicationTypeBean) {
		this.publicationTypeBean = publicationTypeBean;
	}
}
