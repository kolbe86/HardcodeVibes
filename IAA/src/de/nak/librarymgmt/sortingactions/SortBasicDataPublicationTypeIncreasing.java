package de.nak.librarymgmt.sortingactions;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.comparators.PublicationTypeComparator;
import de.nak.librarymgmt.model.PublicationType;
import de.nak.librarymgmt.service.PublicationTypeService;

public class SortBasicDataPublicationTypeIncreasing extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Set<PublicationType> tempPublicationTypes;

	private List<PublicationType> publicationTypes;
	private PublicationTypeService publicationTypeService;

	public String execute() throws Exception {

		Comparator<PublicationType> comp = new PublicationTypeComparator();

		setTempPublicationTypes(publicationTypeService
				.listAllPublicationTypes());

		setPublicationTypes(new LinkedList<PublicationType>());
		for (PublicationType publicationType : tempPublicationTypes) {
			publicationTypes.add(publicationType);
		}

		Collections.sort(publicationTypes, comp);

		return SUCCESS;

	}

	public PublicationTypeService getPublicationTypeService() {
		return publicationTypeService;
	}

	public void setPublicationTypeService(
			PublicationTypeService publicationTypeService) {
		this.publicationTypeService = publicationTypeService;
	}

	public Set<PublicationType> getTempPublicationTypes() {
		return tempPublicationTypes;
	}

	public void setTempPublicationTypes(
			Set<PublicationType> tempPublicationTypes) {
		this.tempPublicationTypes = tempPublicationTypes;
	}

	public List<PublicationType> getPublicationTypes() {
		return publicationTypes;
	}

	public void setPublicationTypes(List<PublicationType> publicationTypes) {
		this.publicationTypes = publicationTypes;
	}

}
