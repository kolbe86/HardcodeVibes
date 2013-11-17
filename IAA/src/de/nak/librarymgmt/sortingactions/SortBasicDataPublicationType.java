package de.nak.librarymgmt.sortingactions;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.comparators.PublicationTypeComparator;
import de.nak.librarymgmt.model.PublicationType;
import de.nak.librarymgmt.service.PublicationTypeService;

public class SortBasicDataPublicationType extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<PublicationType> publicationTypes;
	private PublicationTypeService publicationTypeService;
	private boolean increasing;
	private String whichColumn;

	public String execute() throws Exception {

		// this class checks the type of sorting with the variables increasing
		// and whichColumn
		// they are filled by the radio buttons in the jsp
		// then search for the right sorting method with switch and if
		// statements
		setPublicationTypes(new LinkedList<PublicationType>(
				publicationTypeService.listAllPublicationTypes()));

		Comparator<PublicationType> comp = new PublicationTypeComparator();
		Collections.sort(publicationTypes, comp);
		if (increasing == false) {
			Collections.reverse(publicationTypes);
		}

		return SUCCESS;

	}

	public boolean isIncreasing() {
		return increasing;
	}

	public void setIncreasing(boolean increasing) {
		this.increasing = increasing;
	}

	public String getWhichColumn() {
		return whichColumn;
	}

	public void setWhichColumn(String whichColumn) {
		this.whichColumn = whichColumn;
	}

	public List<PublicationType> getPublicationTypes() {
		return publicationTypes;
	}

	public void setPublicationTypes(List<PublicationType> publicationTypes) {
		this.publicationTypes = publicationTypes;
	}

	public PublicationTypeService getPublicationTypeService() {
		return publicationTypeService;
	}

	public void setPublicationTypeService(
			PublicationTypeService publicationTypeService) {
		this.publicationTypeService = publicationTypeService;
	}

}
