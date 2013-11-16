package de.nak.librarymgmt.sortingactions;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.comparators.PublicationConditionComparator;
import de.nak.librarymgmt.comparators.PublicationDistributedComparator;
import de.nak.librarymgmt.comparators.PublicationEditionComparator;
import de.nak.librarymgmt.comparators.PublicationIsbnComparator;
import de.nak.librarymgmt.comparators.PublicationIssueComparator;
import de.nak.librarymgmt.comparators.PublicationKeywordComparator;
import de.nak.librarymgmt.comparators.PublicationPublicationDateComparator;
import de.nak.librarymgmt.comparators.PublicationPublicationTypeComparator;
import de.nak.librarymgmt.comparators.PublicationPublisherComparator;
import de.nak.librarymgmt.comparators.PublicationTitleComparator;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.service.PublicationService;

public class SortPublications extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Publication> publications;
	private PublicationService publicationService;
	private boolean increasing;
	private String whichColumn;

	public String execute() throws Exception {

		setPublications(publicationService.listPublications());

		switch (whichColumn) {
		case "title":

			Comparator<Publication> compTitle = new PublicationTitleComparator();
			Collections.sort(publications, compTitle);
			if (increasing == false) {
				Collections.reverse(publications);
			}
			break;

		case "publicationDate":

			Comparator<Publication> compPublicationDate = new PublicationPublicationDateComparator();
			Collections.sort(publications, compPublicationDate);
			if (increasing == false) {
				Collections.reverse(publications);
			}
			break;

		case "publicationType":

			Comparator<Publication> compPublicationType = new PublicationPublicationTypeComparator();
			Collections.sort(publications, compPublicationType);
			if (increasing == false) {
				Collections.reverse(publications);
			}
			break;

		case "keyword":

			Comparator<Publication> compKeyword = new PublicationKeywordComparator();
			Collections.sort(publications, compKeyword);
			if (increasing == false) {
				Collections.reverse(publications);
			}
			break;

		case "isbn":

			Comparator<Publication> compIsbn = new PublicationIsbnComparator();
			Collections.sort(publications, compIsbn);
			if (increasing == false) {
				Collections.reverse(publications);
			}
			break;

		case "publisher":

			Comparator<Publication> compPublisher = new PublicationPublisherComparator();
			Collections.sort(publications, compPublisher);
			if (increasing == false) {
				Collections.reverse(publications);
			}
			break;

		case "edition":

			Comparator<Publication> compEdition = new PublicationEditionComparator();
			Collections.sort(publications, compEdition);
			if (increasing == false) {
				Collections.reverse(publications);
			}
			break;

		case "issue":

			Comparator<Publication> compIssue = new PublicationIssueComparator();
			Collections.sort(publications, compIssue);
			if (increasing == false) {
				Collections.reverse(publications);
			}
			break;

		case "distributed":

			Comparator<Publication> compDistributed = new PublicationDistributedComparator();
			Collections.sort(publications, compDistributed);
			if (increasing == false) {
				Collections.reverse(publications);
			}
			break;

		// case "reserved":
		//
		// Comparator<Publication> compReserved = new
		// PublicationReservedComparator();
		// Collections.sort(publications, compReserved);
		// if (increasing == false) {
		// Collections.reverse(publications);
		// }
		// break;

		case "condition":

			Comparator<Publication> compCondition = new PublicationConditionComparator();
			Collections.sort(publications, compCondition);
			if (increasing == false) {
				Collections.reverse(publications);
			}
			break;

		default:

			break;
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

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public PublicationService getPublicationService() {
		return publicationService;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

}
