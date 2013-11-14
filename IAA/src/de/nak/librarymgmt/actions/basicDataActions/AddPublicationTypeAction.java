package de.nak.librarymgmt.actions.basicDataActions;

import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.PublicationType;
import de.nak.librarymgmt.service.PublicationTypeService;

public class AddPublicationTypeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Set<PublicationType> publicationTypes;
	private PublicationTypeService publicationTypeService;
	private String paramPublicationType;
	private PublicationType publicationTypeBean;

	public String execute() throws Exception {

		publicationTypeService.createPublicationType(publicationTypeBean
				.getName());
		// Get Publication-Types
		publicationTypes = publicationTypeService.listAllPublicationTypes();

		System.out.println("Add BasicDataType Ende");
		return "basicDataSuccess";

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
